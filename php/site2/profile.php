<?php
require_once 'global.php';
include_once PHPVOD_ROOT . 'data/cache/dbreg.php';
include_once PHPVOD_ROOT . 'data/cache/level.php';

initvar('action');
if($action == "show")
{
	initvar('id','GP',2);

	/* �û���Ȩ�� */
	if($id != $uid && $gp_allowprofile == '0') showmsg('profile_error');
	if($id == '0') showmsg('guest_info');

	$userdb = array();
	$userdb = $db->get_one("SELECT m.*,md.* FROM pv_members m LEFT JOIN pv_memberdata md ON m.uid=md.uid WHERE m.uid='$id'");
	if(!$userdb) showmsg('user_not_exists','','',array($id));

	$logininfo = explode('|', $userdb['onlineip']);
	$userdb['ip'] = $logininfo[0];
	$userdb['lastlogin'] = get_date($logininfo[1], "Y-m-d");
	$userdb['regdate'] = get_date($userdb['regdate'], "Y-m-d");
	$userdb['grouptitle'] = $ltitle[$userdb['groupid']];
	$userdb['membertitle'] = $ltitle[$userdb['memberid']];
	!ereg("^http", $userdb['icon']) && $userdb['icon'] = "$imgpath/face/$userdb[icon]";

	$usercredit = array("postnum" => "$userdb[postnum]", "rvrc" => "$userdb[rvrc]", "money" => "$userdb[money]");
	$creditdb = get_custom_credit($id);
	foreach($creditdb as $key => $value)
	{
		$usercredit[$key] = $value[1];
	}
	$upgradeset = unserialize($db_upgrade);
	$userdb['credit'] = calculate_credit($usercredit, $upgradeset);
}
elseif($action == "modify")
{
	initvar('step','GP',2);
	$groupid == 'guest' && showmsg('not_login');
	if($step != 2)
	{
		ifcheck($user['receivemail'], 'receivemail');
		ifcheck($user['gender'], 'gender','select');
		ifcheck($user['publicmail'], 'publicmail');

		$getbirthday = explode("-", $user['bday']);
		$year[$getbirthday[0]] = 'selected="selected"';
		$month[$getbirthday[1]] = 'selected="selected"';
		$day[$getbirthday[2]] = 'selected="selected"';

		$userstyle = getcookie('userstyle');
		$style = $userstyle ? $userstyle : $db_defaultstyle;
		$styles = create_style_option($style);

		$delicon = ereg("^user/", $user['icon']) ? '1' : '0';

		$iconurl = $iconpath = '';
		if(ereg("^http", $user['icon']))
		{
			$iconurl = $user['icon'];
			$iconpath = $user['icon'];
		}
		else
		{
			$iconpath = "$imgpath/face/$user[icon]";
		}

		$img = @opendir("$imgdir/face");
		while($imagearray = @readdir($img))
		{
			$extend = pathinfo($imagearray);
			$extend = strtolower($extend["extension"]);
			if($imagearray != "." && $imagearray != ".." && $imagearray != "" && $imagearray != "none.gif" && in_array($extend, array('jpg', 'jpeg', 'gif', 'png', 'bmp')))
			{
				$filedb[] = $imagearray;
			}
		}
		@closedir($img);
		natcasesort($filedb);
		foreach($filedb as $value)
		{
			$value == $user['icon'] ? $c = 'selected="selected"' : $c = '';
			$imgselect .= "<option value='$value' $c>$value</option>";
		}
	}
	else
	{
		initvar(array('proicon','userstyle'),'GP',0);
		initvar(array('proyear','promonth','proday','progender','proreceivemail','propublicmail'), 'GP', 2);
		initvar(array('iconurl', 'prohonor', 'prooicq', 'promsn', 'prosite', 'prosign'), 'GP');
		
		$bday = (!$proyear || !$promonth || !$proday) ? '0000-00-00' : $proyear . "-" . $promonth . "-" . $proday;

		if(strlen($prohonor) > $rg_regmaxhonor)	showmsg('honor_limit','','goback',array($rg_regmaxhonor));
		if(strlen($prosign) > $rg_regmaxsign) showmsg('sign_limit','','goback',array($rg_regmaxsign));
		if(strpos($proicon, '..') !== false) showmsg('undefined_action','','goback');
		if(ereg("^user/", $user['icon'])) $proicon = $user['icon'];

		if($iconurl)
		{
			if(!ereg("^http", $iconurl))
			{
				showmsg('illegal_customimg','','goback');
			}
			else
			{
				if(ereg("^user/", $user['icon']) && file_exists($imgdir . '/face/' . $user['icon'])) showmsg('pro_custom_fail','','goback');
				$proicon = $iconurl;
			}
		}

		/* ϵͳ��� */
		if($userstyle == '')
			cookie('userstyle', '', 0);
		else
			cookie('userstyle', $userstyle);

		/* �ϴ�ͷ�� */
		$error = $_FILES['upicon']['error'];
		$img_name = $_FILES['upicon']['name'];
		$img_tmp = $_FILES['upicon']['tmp_name'];
		$img_size = $_FILES['upicon']['size'];
		$image_path = $imgpath . "/face/user/";

		if($error == '0' && $img_size > 0 && $db_iconupload == '1' && $gp_allowupicon == '1')
		{
			$iconsize = $db_iconsize * 1024;
			if($img_size > $iconsize) showmsg('pro_loadimg_limit','','',array($iconsize));
			if(ereg("^user/", $user['icon']) && file_exists($imgdir . '/face/' . $user['icon'])) showmsg('pro_loadimg_fail','','goback');

			$img_ext = strtolower(substr(strrchr($img_name, '.'), 1));
			if($img_ext && in_array($img_ext, array('jpg', 'jpeg', 'png', 'bmp', 'gif')) && !in_blacklist($img_ext))
			{
				$filename = $uid . '.' . $img_ext;
				if(copy($img_tmp, $image_path . $filename))
				{
					$proicon = "user/$filename";
				}
			}
			else
				showmsg('pro_loadimg_ext');
		}
		$db->update("UPDATE pv_members SET publicmail='$propublicmail', receivemail='$proreceivemail', honor='$prohonor', icon='$proicon', gender='$progender', oicq='$prooicq', msn='$promsn', site='$prosite', bday='$bday', signature='$prosign' WHERE uid='$uid'");
		refreshto("./profile.php?action=$action", 'operate_success');
	}
}
elseif($action == "changepass")
{
	initvar('step','GP',2);
	$groupid == 'guest' && showmsg('not_login');
	if($step == 2)
	{
		initvar(array('oldpwd','propwd','check_pwd','proemail'),'GP',0);
		if(!$oldpwd) showmsg('not_oldpwd','','goback');
		if(($propwd || $check_pwd) && ($propwd != $check_pwd)) showmsg('password_confirm','','goback');
		$n =  pv_user_edit($username,$oldpwd,$propwd,$proemail);
		if($n != 1) showmsg('pv_user_'.$n,'','goback');
		refreshto("./profile.php?action=show&id=$uid", 'operate_success');
	}
}
elseif($action == "myvideo")
{
	initvar(array('type','page'));
	if(empty($type) || !in_array($type, array('post','favorite','buy'))) $type = 'post';
	$groupid == 'guest' && showmsg('not_login');

	switch ($type)
	{
		case 'post':
			$rt = $db->get_one("SELECT COUNT(*) AS sum FROM pv_video WHERE authorid='$uid'");
			$video_num = $rt['sum'];
			$sql = "v.authorid='$uid'";
			break;
		case 'favorite':
			$rt = $db->get_one("SELECT favorite FROM pv_memberdata WHERE uid='$uid'");
			if(empty($rt['favorite']))
			{
				$video_num = 0;
				$sql = "0";
			}
			else
			{
				$rt['favorite'] = substr($rt['favorite'], 1, -1);
				$vids = explode(',', $rt['favorite']);
				$video_num = count($vids);
				$sql = "v.vid IN ($rt[favorite])";
			}
			break;
		case 'buy':
			$rt = $db->get_one("SELECT buyvid FROM pv_memberdata WHERE uid='$uid'");
			if(empty($rt['buyvid']))
			{
				$video_num = 0;
				$sql = 0;
			}
			else
			{
				$rt['buyvid'] = substr($rt['buyvid'], 1, -1);
				$vids = explode(',', $rt['buyvid']);
				$video_num = count($vids);
				$sql = "v.vid IN ($rt[buyvid])";
			}
			break;
	}

	(!is_numeric($page) || $page < 1) && $page = 1;
	$limit = "LIMIT " . ($page - 1) * $db_perpage . ",$db_perpage";
	$pages = numofpage($video_num, $page, $db_perpage, "profile.php?action=myvideo&type={$type}&");

	$videolist = array();
	$query = $db->query("SELECT * FROM pv_video AS v WHERE $sql ORDER BY postdate DESC $limit");
	while($video = $db->fetch_array($query))
	{
		$video['postdate'] = get_date($video['postdate']);
		$video['lastdate'] = get_date($video['lastdate']);
		$videolist[] = $video;
	}
}
elseif($action == 'remove')
{
	initvar('type');
	initvar('vid','GP',2);

	$groupid == 'guest' && showmsg('not_login');
	$rt = $db->get_one("SELECT buyvid,favorite FROM pv_memberdata WHERE uid='$uid'");

	if($type=='favorite')
	{
		$v = $rt['favorite'];
		$f = 'favorite';
	}
	elseif($type=='buy')
	{
		$v = $rt['buyvid'];
		$f = 'buyvid';
	}

	if($v == ','.$vid.',')
		$v = '';
	else
		$v = str_replace(','.$vid.',', ',', $v);

	$db->update("UPDATE pv_memberdata SET $f='$v' WHERE uid='$uid'");
	refreshto("profile.php?action=myvideo&type=$type", 'operate_success');
}
elseif($action == "delicon")
{
	$groupid == 'guest' && showmsg('not_login');
	if(ereg("^user/", $user['icon']) && file_exists("$imgdir/face/$user[icon]")) delfile("$imgdir/face/$user[icon]");
	$db->query("UPDATE pv_members SET icon='none.gif' WHERE uid='$uid'");
	refreshto('profile.php?action=modify', 'operate_success');
}

require_once PHPVOD_ROOT . 'require/header.php';
require_once gettpl('profile');
footer();
?>