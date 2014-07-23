<?php
require_once 'global.php';

include_once PHPVOD_ROOT . 'data/cache/class.php';
include_once PHPVOD_ROOT . 'data/cache/nation.php';
include_once PHPVOD_ROOT . 'data/cache/dbset.php';

initvar('action');
empty($action) && $action = "new";

if($groupid == 'guest')
{
	$uid = '0';
	$username = lang('guest');
}

if($action == "new")
{
	initvar('step', 'P', 2);
	if($step != '2')
	{
		/* �û���Ȩ�� */
		if($gp_allowpost != '1') showmsg('group_post');

		$_class_opt = create_class_option(array('optgroup' => true, 'auth' => array('allowpost')));
		$_nation_opt = create_nation_option();
		$_credit_opt = create_credit_option();
		$sale_opt = $need_opt = $_credit_opt;
		$img = $imgpath . '/' . $stylepath . '/nopic.gif';

		/* ��ʼ�� */
		$video['urls'][] = '';
		$video['player'][] = create_player_option();

		require_once PHPVOD_ROOT . 'require/header.php';
		require_once gettpl('post');
		footer();
	}
	else
	{
		initvar('video', 'GP', 0);
		$n = post_video($video);

		if($n == -1)
			showmsg('check_error', '', 'goback');
		elseif($n == -2)
			showmsg('post_guest', '', 'goback');
		elseif($n == -3)
			showmsg('post_noper', '', 'goback');
		elseif($n == -4)
			showmsg('post_type', '', 'goback');
		elseif($n == -5)
			showmsg('form_error', '', 'goback');
		elseif($n == 0)
			refreshto("class.php?cid=$video[cid]", 'vid_success_check');
		elseif($n > 0)
			refreshto("class.php?cid=$video[cid]", 'vid_success');
	}

}
elseif($action == "modify")
{
	initvar('step', 'P', 2);
	if($step != '2')
	{
		initvar('vid', 'GP', 2);

		$video = $db->get_one("SELECT v.*,vd.* FROM pv_video v LEFT JOIN pv_videodata vd ON v.vid=vd.vid WHERE v.vid='$vid'");
		if(!$video) showmsg('video_illegal');
		if($SYSTEM['allowadminedit'] != '1')
		{
			if($video['authorid'] != $uid || $gp_alloweditatc != '1') showmsg('modify_vod_error');
		}

		$_class_opt = create_class_option(array('select' => $video['cid'], 'optgroup' => true, 'auth' => array('allowpost')));
		$_nation_opt = create_nation_option($video['nid']);
		$year[$video['year']] = ' selected="selected"';

		if($video['serialise'] > '0')
			$serialise_1 = ' selected="selected"';
		else
			$serialise_0 = ' selected="selected"';

		$need_opt = $sale_opt = create_credit_option();
		if($video['sale'] != '')
		{
			$p = strpos($video['sale'], '|');
			if($p !== false)
			{
				$sale_value = substr($video['sale'], 0, $p);
				$sale_type = substr($video['sale'], $p + 1);
				if(!is_numeric($sale_value) || (int)$sale_value <= 0) $sale_value = 0;
				$sale_opt = str_replace('<option value="' . $sale_type . '">', '<option value="' . $sale_type . '" selected="selected">', $sale_opt);
			}
			else
			{
				$sale_value = '0';
			}
		}
		else
		{
			$sale_value = '0';
		}

		if($video['need'] != '')
		{
			$p = strpos($video['need'], '|');
			if($p !== false)
			{
				$need_value = substr($video['need'], 0, $p);
				$need_type = substr($video['need'], $p + 1);
				if(!is_numeric($need_value) || (int)$need_value <= 0) $need_value = 0;
				$need_opt = str_replace('<option value="' . $need_type . '">', '<option value="' . $need_type . '" selected="selected">', $need_opt);
			}
			else
			{
				$need_value = '0';
			}
		}
		else
		{
			$need_value = '0';
		}

		$_player_opt = create_player_option();
		$result = $db->query("SELECT * FROM pv_urls WHERE vid='$vid' ORDER BY playgroup ASC");
		while($row = $db->fetch_array($result))
		{
			$video['urls'][] = $row['url'];
			$video['player'][] = str_replace("<option value=\"$row[pid]\">", "<option value=\"$row[pid]\" selected=\"selected\">", $_player_opt);
		}

		$img = get_poster_url($video['picfolder'], $video['pic'], 3);

		require_once PHPVOD_ROOT . 'require/header.php';
		require_once gettpl('post');
		footer();

	}
	elseif($step == '2')
	{
		initvar('video', 'P', 0);
		$n = edit_video($video['vid'], $video);
		switch($n)
		{
			case -1:
				showmsg('check_error', '', 'goback');
				break;
			case -4:
				showmsg('post_type', '', 'goback');
				break;
			case -5:
				showmsg('form_error', '', 'goback');
				break;
			case 0: 
			case 1: 
				if($n == 0) $msgkey = 'vid_edit_success_check'; else $msgkey = 'vid_edit_success';
				//ɾ������
				$cs->delete('videoinfo_' . $video['vid']);
				$cs->delete('videourl_' . $video['vid']);				
				refreshto("read.php?vid=$video[vid]", $msgkey);
				break;
			default:
				showmsg('error_nodefine', '', 'goback');
		}
	}
}
elseif($action == 'del')
{
	initvar('vid', 'GP', 2);

	$video = $db->get_one("SELECT cid,authorid,yz FROM pv_video WHERE vid='$vid'");
	if(!$video) showmsg('video_illegal');

	//Ȩ�޼��
	if($SYSTEM['allowadmindel'] != '1')
	{
		if($video['authorid'] != $uid || $gp_allowdelatc != '1') showmsg('delete_vod_error');
	}

	$uflag = $video['yz'] == '1' ? true : false;
	del_video($vid, $uflag);
	
	//ɾ������
	$cs->delete('videoinfo_' . $vid);
	$cs->delete('videourl_' . $vid); 

	refreshto("class.php?cid=$video[cid]", 'operate_success');
}

?>