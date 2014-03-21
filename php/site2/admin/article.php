<?php
!defined('IN_PHPVOD') && exit('Forbidden');
include_once PHPVOD_ROOT . 'data/cache/artclass.php';

if(!$action)
{
	$articledb = array();
	$query = $db->query("SELECT * FROM pv_article ORDER BY vieworder DESC,timestamp DESC");
	while($rt = $db->fetch_array($query))
	{
		strlen($rt['subject']) > 30 && $rt['subject'] = pv_substr($rt['subject'], 30);
		$rt['timestamp'] = get_date($rt['timestamp']);
		$articledb[] = $rt;
	}
}
elseif($action == 'add')
{
	initvar('step', 'P', 2);
	if($step == '2')
	{
		initvar(array('classid','vieworder'), 'P', 2);
		initvar('subject', 'P');
		initvar('content', 'P', 0);
		if(empty($subject) || empty($content)) adminmsg('operate_fail','goback');
		$db->update("INSERT INTO pv_article(classid,author,authorid,subject,content,vieworder,timestamp) VALUES('$classid','$admin[username]','$admin[uid]','$subject','$content','$vieworder','$timestamp')");
		adminmsg('operate_success');
	}
}
elseif($action == 'edit')
{
	initvar('step', 'GP', 2);
	if(!$step)
	{
		initvar('aid', 'GP', 2);
		@extract($db->get_one("SELECT * FROM pv_article WHERE aid='$aid'"));
		ifcheck($classid, 'classid', 'select');
	}
	elseif($step == '2')
	{
		initvar(array('aid', 'classid', 'vieworder'), 'P', 2);
		initvar('subject', 'P');
		initvar('content', 'P', 0);
		$db->update("UPDATE pv_article SET classid='$classid',subject='$subject',content='$content',vieworder='$vieworder' where aid='$aid'");
		adminmsg('operate_success');
	}
}
elseif($action == 'del')
{
	initvar('selid', 'P', 2);
	if(!$selid = checkselid($selid)) adminmsg('operate_error');
	$db->update("DELETE FROM pv_article WHERE aid IN($selid)");
	adminmsg('operate_success');
}
elseif($action == 'artclass')
{
	$artclassdb = array();
	$query = $db->query("SELECT * FROM pv_artclass ORDER BY vieworder");
	while($artclass = $db->fetch_array($query))
	{
		$artclassdb[] = $artclass;
	}
}
elseif($action == 'artclass_add')
{
	initvar('caption', 'P');
	empty($caption) && adminmsg('operate_fail',"$basename&action=artclass");
	$db->update("INSERT INTO pv_artclass SET caption='$caption'");
	updatecache_artclass();
	adminmsg('operate_success',"$basename&action=artclass");	
}
elseif($action == 'artclass_edit')
{
	initvar('vieworder', 'P', 2);
	initvar('caption', 'P');
	foreach($vieworder as $key => $value)
	{
		!empty($caption[$key]) && $db->update("UPDATE pv_artclass SET vieworder='$vieworder[$key]',caption='$caption[$key]' WHERE cid='$key'");
	}
	updatecache_artclass();
	adminmsg('operate_success',"$basename&action=artclass");	
}
elseif($action == 'artclass_del')
{
	initvar('cid', 'G', 2);
	
	$query = $db->query("SELECT aid FROM pv_article WHERE classid='$cid'");
	$recordnum = $db->num_rows($query);
	if($recordnum > 0) adminmsg('artclass_have_article',"$basename&action=artclass");
	
	$db->update("DELETE FROM pv_artclass WHERE cid='$cid'");
	updatecache_artclass();
	adminmsg('operate_success',"$basename&action=artclass");	
}

include gettpl('article');
?>