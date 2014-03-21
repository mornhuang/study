<?php
!defined('IN_PHPVOD') && exit('Forbidden');

if(!$action)
{
	$playerdb = array();
	$query = $db->query("SELECT * FROM pv_player ORDER BY pid");
	while($player = $db->fetch_array($query))
	{
		$playerdb[] = $player;
	}
}
elseif($action == "add")
{
	initvar('step', 'P', 2);
	if($step == '2')
	{
		initvar(array('name', 'subject'), 'P');
		initvar(array('playpath', 'content'), 'P', 0);
		initvar('hidden', 'P', 2);
		$content = stripslashes($content);

		if(empty($name) || empty($content) || empty($playpath)) adminmsg('operate_fail');
		$playpath .= '.htm';
		if(is_file(PHPVOD_ROOT . 'data/player/' . $playpath)) adminmsg('player_file_exists', 'goback', array($playpath));
		writeover(PHPVOD_ROOT . 'data/player/' . $playpath, $content);
		if(is_file(PHPVOD_ROOT . 'data/player/' . $playpath))
		{
			$db->update("INSERT INTO pv_player (hidden,name,subject,playpath) VALUES ('$hidden','$name','$subject','$playpath');");
			adminmsg('operate_success');
		}
		else
		{
			adminmsg('player_error', 'goback');
		}
	}
}
elseif($action == "edit")
{
	initvar('step', 'P', 2);
	if($step != '2')
	{
		initvar('pid', 'G', 2);
		$player = $db->get_one("SELECT * FROM pv_player WHERE pid='$pid'");
		!$player && adminmsg('player_not_exists');
		ifcheck($player['hidden'], 'hidden');
		$content = readover(PHPVOD_ROOT . 'data/player/' . $player['playpath']);
		$player['playpath'] = trim($player['playpath'], '.htm');
	}
	else
	{
		initvar(array('name', 'subject'), 'P');
		initvar(array('playpath', 'content'), 'P', 0);
		initvar(array('hidden', 'pid'), 'P', 2);
		$content = stripslashes($content);

		if(empty($name) || empty($content) || empty($playpath)) adminmsg('operate_fail');
		$playpath .= '.htm';

		$player = $db->get_one("SELECT playpath FROM pv_player WHERE pid='$pid'");
		if($player['playpath'] != $playpath)
		{
			if(is_file(PHPVOD_ROOT . 'data/player/' . $playpath)) adminmsg('player_file_exists', 'goback', array($playpath));
			rename(PHPVOD_ROOT . 'data/player/' . $player['playpath'], PHPVOD_ROOT . 'data/player/' . $playpath);
		}
		writeover(PHPVOD_ROOT . 'data/player/' . $playpath, $content);
		$db->update("UPDATE pv_player SET hidden='$hidden',name='$name',subject='$subject',playpath='$playpath' WHERE pid='$pid'");
		adminmsg('operate_success');
	}
}
elseif($action == "del")
{
	initvar(array('selid','applyid'), 'P', 2);
	if(!empty($selid))
	{
		foreach($selid as $pid)
		{
			$player = $db->get_one("SELECT playpath FROM pv_player WHERE pid='$pid'");
			delfile(PHPVOD_ROOT . 'data/player/' . $player['playpath']);
			$db->update("DELETE FROM pv_player WHERE pid='$pid'");
		}
	}
	$db->update("UPDATE pv_player SET hidden=0");
	if($idstr = checkselid($applyid))
	{
		$db->update("UPDATE pv_player SET hidden=1 WHERE pid IN($idstr)");
	}
	adminmsg('operate_success');
}

include gettpl('player');

?>