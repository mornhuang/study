<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<?php echo $db_wwwurl;?>/" />
<meta http-equiv="Content-Type" content="text/html; charset=<?php echo $db_charset;?>" />
<?php if(PHPFUNC=='showmsg') { ?>	
<title>提示信息 - powered by PHPvod.com</title>	
<meta name="keywords" content="<?php echo $db_keywords;?>" />
<meta name="description" content="<?php echo $db_description;?>" />
<?php } elseif(PHPSELF=='index') { ?>
<title><?php echo $db_wwwname;?> - powered by PHPvod.com</title>	
<meta name="keywords" content="<?php echo $db_keywords;?>" />
<meta name="description" content="<?php echo $db_description;?>" />
<?php } elseif(PHPSELF=='category') { ?>
<title><?php echo $_class[$cid]['caption'];?> - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<meta name="keywords" content="<?php echo $db_keywords;?>" />
<meta name="description" content="<?php echo $db_description;?>" />	
<?php } elseif(PHPSELF=='class') { ?>
<title><?php echo $_class[$cid]['caption'];?> - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<meta name="keywords" content="<?php echo $db_keywords;?>" />
<meta name="description" content="<?php echo $db_description;?>" />
<?php } elseif(PHPSELF=='read') { ?>
<title><?php echo $video['subject'];?> - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<meta name="keywords" content="<?php echo str_replace(array('"',"\'",'&nbsp;'), '', strip_tags($video['subject'])) ?>" />
<meta name="description" content="<?php echo pv_substr(str_replace(array('"',"\'","\n",'&nbsp;',' ','　'), '', strip_tags($video['synopsis'])), 200, 1); ?>" />
<?php } elseif(PHPSELF=='play') { ?>
<title><?php echo $video['subject'];?>(<?php echo $urlcaption;?>) - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<meta name="keywords" content="<?php echo $db_keywords;?>" />
<meta name="description" content="<?php echo $db_description;?>" />
<?php } else { if(PHPSELF == 'post') { ?>
<title>发布视频 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } elseif(PHPSELF == 'faq') { ?>
<title>帮助 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } elseif(PHPSELF == 'hack') { ?>	
<title><?php echo $_hack[$hackname]['name'];?> - 插件 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } elseif(PHPSELF == 'login') { ?>	
<title>会员登录 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } elseif(PHPSELF == 'message') { ?>
<title>短消息 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } elseif(PHPSELF == 'notice') { ?>	
<title>网站公告 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } elseif(PHPSELF == 'profile') { ?>
<title>个人中心 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>		
<?php } elseif(PHPSELF == 'register') { ?>
<title>会员注册 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } elseif(PHPSELF == 'report') { ?>
<title>举报 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } elseif(PHPSELF == 'search') { if(!empty($keyword)) $search_keyword = $keyword . ' - '; else $search_keyword = ''; ?><title><?php echo $search_keyword;?>搜索 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } elseif(PHPSELF == 'sendpwd') { ?>
<title>找回密码 - <?php echo $db_wwwname;?> - powered by PHPvod.com</title>
<?php } else { ?>
<title><?php echo $db_wwwname;?></title>
<?php } ?>
<meta name="keywords" content="<?php echo $db_keywords;?>" />
<meta name="description" content="<?php echo $db_description;?>" />
<?php } ?>
<!-- <meta content="IE=7.0000" http-equiv="X-UA-Compatible"> -->
<link rel="stylesheet" type="text/css" href="<?php echo $imgpath;?>/<?php echo $stylepath;?>/style.css" />
<script language="javascript" src="js/jquery.js"></script>
<script language="javascript" src="js/function.js"></script>
</head>
<body><?php $adcode = ad('header'); if($adcode!='') { ?><div class="adheader"><?php echo $adcode;?></div><?php } ?>	
<div id="header">
<div id="logo"><a href="<?php echo $db_bfn;?>"><img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/logo.gif" alt="<?php echo $db_wwwname;?>"/></a></div>
<div id="banner">
<div id="nav">
您好，
<?php if($groupid=='guest') { ?>
请 <a href="register.php">注册</a> 或 <a href="login.php">登录</a>
<?php } else { ?>
<?php echo $username;?>！<a href="login.php?action=quit">[退出]</a>
┆ <a href="profile.php?action=show&id=<?php echo $uid;?>">个人中心</a>
┆ <a href="message.php">短消息</a> <?php if($user['newpm']==1) { ?><img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/new.gif" /><?php } } if($gp_allowpost=='1') { ?>
┆ <a href="post.php" class="stylecolor">发布视频</a>
<?php } if(is_array($hackdb['1'])) { foreach($hackdb['1'] as $h) { ?>┆ <a href="hack.php?hackname=<?php echo $h['directory'];?>"><?php echo $h['name'];?></a><?php } } if($SYSTEM['allowadmincp']=='1') { ?>
┆ <a href="admin.php" target="_blank">后台管理</a>
<?php } ?>

┆ <a href="search.php">搜索</a>

<?php if($db_mergesystype=='ucenter' && $db_mergeshowapp=='1') { include_once PHPVOD_ROOT . 'uc_client/data/cache/apps.php'; if(is_array($_CACHE['apps'])) { foreach($_CACHE['apps'] as $key => $app) { if($app['appid'] != UC_APPID && is_numeric($key)) { ?>
┆ <a href="<?php echo $app['url'];?>" target="_blank"><?php echo $app['name'];?></a>	
<?php } } } } ?>

┆ <a href="arthome.php">文档</a>
┆ <a href="rss.php" target="_blank">RSS</a>			
</div>

<div id="bdy">
<div id="search">
<form method="post" action="search.php">
<div class="sch-left"></div>
<div class="sch-input">
<input type="hidden" name="action" value="search" />
<input type="hidden" name="field" value="subject" />
<input type="hidden" name="cid" value="" />
<input type="hidden" name="nid" value="" />
<input type="hidden" name="orderway" value="postdate" />
<input type="hidden" name="asc" value="DESC" />
<input type="hidden" name="lines" value="10" />
<input type="hidden" name="showtype" value="0" />
<input type="text" name="keyword" maxlength="30" />					
</div>
<input id="search-btn" name="submit" type="submit" value="" class="sch-btn"/>
</form>
</div>
</div>		
</div>

<script type="text/javascript">
$('#search-btn').bind('mouseenter mouseleave', function() {
  $(this).toggleClass('on-sch-btn');
});	
</script>		

</div><!-- header end -->

<div id="menu">
<div id="menubar">
<div id="menuitem"><?php if(PHPSELF=='category') $t=$cid; elseif(PHPSELF=='class' || PHPSELF=='read') $t=$top; elseif(PHPSELF=='index') $t=0;
$t>=0 && $ms[$t]=' class="current"';
 ?><a href="<?php echo $db_bfn;?>"<?php echo $ms['0'];?>>首页</a><?php $cdb = pv_loop('class',"cid=0"); if(is_array($cdb)) { foreach($cdb as $c) { ?><a href="category.php?cid=<?php echo $c['cid'];?>"<?php echo $ms[$c['cid']];?>><?php echo $c['caption'];?></a><?php } } if(is_array($hackdb['2'])) { foreach($hackdb['2'] as $h) { ?><a href="hack.php?hackname=<?php echo $h['directory'];?>"><?php echo $h['name'];?></a><?php } } ?><div class="menu-left"></div>			
</div>
<div class="siteinfo">今日:<?php echo get_today_vodnum('60'); ?> ┆ 影片:<?php echo $siteinfo['totalvideo'];?> ┆ 会员:<?php echo $siteinfo['totalmember'];?> ┆ 新会员:<?php echo $siteinfo['newmember'];?></div>
</div>
<div class="menu-right"></div>
</div>

<div id="mainbody">
