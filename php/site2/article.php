<?php
require_once 'global.php';
include_once PHPVOD_ROOT . 'data/cache/artclass.php';
initvar('aid','G',2);
if(!is_numeric($aid)) showmsg('article_illegal');
$article = $db->get_one("SELECT * FROM pv_article WHERE aid='$aid'");
if(empty($article)) showmsg('article_not_exists');
require_once PHPVOD_ROOT.'require/header.php';
require_once gettpl('article');footer();
?>