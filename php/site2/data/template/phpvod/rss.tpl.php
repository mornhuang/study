<div class="w960 mt15 fl">
<div class="w700 fl">
<dl class="box">
<dt>RSS订阅中心</dt>
<dd class="rss">
<table class="rsstable">
<tr>
<td class="rsscaption">首页</td>
<td class="rssurl"><a href="<?php echo $db_wwwurl;?>/rss.php?cid=0" target="_blank"><?php echo $db_wwwurl;?>/rss.php?cid=0</a></td>
<td><a href="<?php echo $db_wwwurl;?>/rss.php?cid=0" target="_blank"><img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/rss.gif" alt="RSS订阅" /></a></td>
</tr><?php include PHPVOD_ROOT . 'data/cache/class.php';
$cids=getsubcid();
foreach($_class as $cid => $class)
{
if(strpos(','.$cids.',', ','.$cid.',') === false) continue;
$link = pv_url('rss.php?cid=' . $class['cid'], true); ?><tr>
<td class="rsscaption"><?php echo $class['caption'];?></td>
<td class="rssurl"><a href="<?php echo $link;?>" target="_blank"><?php echo $link;?></a></td>
<td><a href="<?php echo $link;?>" target="_blank"><img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/rss.gif" alt="RSS订阅" /></a></td>
</tr><?php } ?></table>
</dd>		
</dl>		
</div>
<div class="w245 fr">
<dl class="box">
<dt>什么是RSS?</dt>
<dd class="rsstxt">
RSS是在线共享内容的一种简易方式（也叫聚合内容，Really Simple Syndication）。通常在时效性比较强的内容上使用RSS订阅能更快速获取信息，网站提供RSS输出，有利于让用户获取网站内容的最新更新。
网络用户可以在客户端借助于支持RSS的聚合工具软件，也可以在线订阅站点，方便用户订阅、收藏关注的视频。PHPVOD遵循 RSS 2.0 版本规范。				
</dd>						
</dl>
<dl class="box mt10">
<dt>RSS如何工作？</dt>
<dd class="rsstxt">
您需要下载和安装一个RSS阅读器，或者在线注册rss账号，然后从网站提供的RSS目录列表中订阅您感兴趣的栏目的内容。订阅后，您将会及时获得所订阅频道的最新内容。
</dd>						
</dl>	
</div>
</div>
