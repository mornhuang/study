<?php
require_once 'global.php';
require_once 'require/rss.php';

initvar('cid', 'GP', 2);

if(is_numeric($cid))
{
	$rss_listnum = 20; //��ʾ��Ŀ
	$rss_updatetime = 10; //�������ʱ��(����)
	print_rss($cid, $rss_listnum, $rss_updatetime);	
}
else
{
	require_once PHPVOD_ROOT . 'require/header.php';
	require_once gettpl('rss');
	footer();
}
?>