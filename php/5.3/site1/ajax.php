<?php
require_once 'global.php';
header("Content-type: text/html;charset=$db_charset");
header("Cache-Control: no-cache, must-revalidate"); //不缓存数据
initvar('action', 'GP', 0);

//影片评分
if($action == 'videostar')
{
	initvar(array('vid', 'starnum'), 'GP', 2);
	$cookievalue = getcookie('videostar');
	if(strpos(',' . $cookievalue . ',', ',' . $vid . ',') === false)
	{
		$info = $db->get_one("SELECT usernth,fraction,star FROM pv_video WHERE vid='$vid'");
		$info['usernth'] += 1;
		$info['fraction'] += $starnum * 2;
		$info['star'] = $info['fraction'] / $info['usernth'];
		$db->update("UPDATE pv_video SET usernth='$info[usernth]', fraction='$info[fraction]', star='$info[star]' WHERE vid='$vid'");
		$cookievalue = $cookievalue == '' ? $vid : $cookievalue . ',' . $vid;
		cookie('videostar', $cookievalue);
		exit(lang('ajax_star_success'));
	}
	else
	{
		exit(lang('ajax_star_error'));
	}
}
//检测视频标题
elseif($action == 'check_video_subject')
{
	initvar('subject', 'GP', 0);
	if(trim($subject) == '') exit(strfmt(array('str' => lang('ajax_check_subject_empty'), 'color' => 'red')));

	if($db_charset != 'utf-8')
	{
		$subject = str_convert($subject, $db_charset, 'utf-8');
	}
	$n = $db->get_one("SELECT COUNT(*) AS num FROM pv_video WHERE subject='$subject'");
	if($n['num'] > 0)
		exit(strfmt(array('str' => lang('ajax_check_subject_no'), 'color' => 'red')));
	else
		exit(strfmt(array('str' => lang('ajax_check_subject_yes'), 'color' => 'green')));
}
//收藏视频
elseif($action == 'add_favorite')
{
	initvar('vid', 'GP', 2);
	if($groupid == 'guest') exit(lang('guest_error'));

	$update = false;
	$u = $db->get_one("SELECT favorite FROM pv_memberdata WHERE uid='$uid'");
	if($u['favorite'] == '')
	{
		$favorite_vid = ",{$vid},";
		$update = true;
	}
	else
	{
		if(strpos($u['favorite'], ",$vid,") !== false)
		{
			exit(lang('ajax_favorite_exists'));
		}
		else
		{
			$favorite_vid = $u['favorite'] . "{$vid},";
			$update = true;
		}
	}

	if($update == true)
	{
		$db->update("UPDATE pv_memberdata SET favorite='$favorite_vid' WHERE uid='$uid'");
		exit(lang('ajax_favorite_success'));
	}
}
//购买视频
elseif($action == 'buy_video')
{
	initvar('vid', 'GP', 2);
	if($groupid == 'guest') exit(lang('guest_error'));

	$video = $db->get_one("SELECT * FROM pv_video WHERE vid='$vid'");
	if($video)
	{
		if($video['sale'] != '')
		{
			$video['sale_value'] = 0;
			$p = strpos($video['sale'], '|');
			if($p !== false)
			{
				$video['sale_value'] = substr($video['sale'], 0, $p);
				$video['sale_type'] = substr($video['sale'], $p + 1);

				if(is_numeric($video['sale_value']) && $video['sale_value'] > 0)
				{
					switch($video['sale_type'])
					{
						case 'money':
							$v['n'] = $user['money'];
							break;
						case 'rvrc':
							$v['n'] = $user['rvrc'];
							break;
						default:
							$v = $db->get_one("SELECT value as n FROM pv_membercredit WHERE uid='$uid' AND cid='$video[sale_type]'");
					}
					if((int)$v['n'] < (int)$video['sale_value']) exit(lang('ajax_buy_video_3'));

					if($user['buyvid'] == '')
						$buyvid = ",{$vid},";
					else
						$buyvid = $user['buyvid'] . "{$vid},";

					switch($video['sale_type'])
					{
						case 'money':
							$db->update("UPDATE pv_memberdata SET money=money-$video[sale_value],buyvid='$buyvid' WHERE uid='$uid'");
							if($video['authorid'] != '0') $db->update("UPDATE pv_memberdata SET money=money+$video[sale_value] WHERE uid='$video[authorid]'");
							break;
						case 'rvrc':
							$db->update("UPDATE pv_memberdata SET rvrc=rvrc-$video[sale_value],buyvid='$buyvid' WHERE uid='$uid'");
							if($video['authorid'] != '0') $db->update("UPDATE pv_memberdata SET rvrc=rvrc+$video[sale_value] WHERE uid='$video[authorid]'");
							break;
						default:
							$db->update("UPDATE pv_membercredit SET value=value-$video[sale_value] WHERE uid='$uid' AND cid='$video[sale_type]'");
							if($video['authorid'] != '0') $db->update("UPDATE pv_membercredit SET value=value+$video[sale_value] WHERE uid='$video[authorid]' AND cid='$video[sale_type]'");
							break;
					}

					$db->update("UPDATE pv_memberdata SET buyvid='$buyvid' WHERE uid='$uid'");
				}
			}
			exit('1'); //购买成功
		}
		else
		{
			exit(lang('ajax_buy_video_2'));
		}
	}
	else
	{
		exit(lang('ajax_buy_video_1'));
	}
}
//检测用户名
elseif($action == 'check_username')
{
	initvar('username', 'GP', 0);
	if($db_charset != 'utf-8')
	{
		$username = str_convert($username, $db_charset, 'utf-8');
	}
	$t = checkname($username);
	if($t != 1)
		exit(strfmt(array('str' => lang('ajax_check_username_' . $t), 'color' => 'red')));

	exit('');
}
//检测Email
elseif($action == 'check_email')
{
	initvar('email', 'GP', 0);
	if(checkemail($email) == 0)
		exit(strfmt(array('str' => lang('ajax_check_email_0'), 'color' => 'red')));

	$t = $db->get_one("SELECT uid FROM pv_members WHERE email='$email'");
	if(!empty($t))
		exit(strfmt(array('str' => lang('ajax_check_email_1'), 'color' => 'red')));

	exit('');
}
//重发验证邮件
elseif($action == 'resend_email')
{
	initvar('yzuid', 'P', 2);
	$yzuid != $uid && exit(lang('ajax_resend_email_-1'));
	$u = $db->get_one("SELECT * FROM pv_members WHERE uid='$yzuid'");
	!$u && exit(lang('ajax_resend_email_-3'));
	$u['groupid'] != '4' && exit(lang('ajax_resend_email_-2'));
	!checkemail($u['email']) && exit(lang('ajax_check_email_0'));
	if(($timestamp-$u['yz']) < 86400) exit(lang('ajax_resend_email_0')); //24小时内只允许发送一次邮件
	
	$subject = lang('email_check_subject',array($db_wwwname));
	$message = lang('email_check_content',array($u['username'],$db_wwwname,$db_wwwurl,$u['uid'],$timestamp,'******'));
	if(sendemail(array($u['email']), $subject, $message))
	{
		$db->update("UPDATE pv_members SET yz='$timestamp' WHERE uid='$yzuid'");
		exit(lang('ajax_resend_email_1'));
	}
	else
	{
		exit(lang('ajax_resend_email_2'));
	}
}

/**
 * 格式化字符串
 * @param array $arr
 */
function strfmt($arr)
{
	global $imgpath, $stylepath;
	$str = '';
	if(isset($arr['pic'])) $str .= '<img src="' . $imgpath . '/' . $stylepath . '/' . $arr['pic'] . '" /> ';
	if(isset($arr['str']))
	{
		if(isset($arr['color']))
			$str .= '<span style="color: ' . $arr['color'] . '">' . $arr['str'] . '</span>';
		else
			$str .= $arr['str'];
	}
	echo $str;
}

?>