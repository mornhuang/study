<?php if(!$action) { ?>
<form method="post" action="search.php">
<input type="hidden" name="action" value="search" />
<table class="box w958 mt10">
<tr><th colspan="2">
<img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/dticon1.gif" align="absmiddle"> <a href="<?php echo $db_bfn;?>"><?php echo $db_wwwname;?></a> &raquo; 搜索视频
</th></tr>

<tr>
<td class="w40">关键词</td>
<td>
<select name="field">
<option value="subject">标题</option>
<option value="playactor">演员</option>
<option value="director">导演</option>
<option value="author">会员</option>
<option value="tag">标签</option>
<option value="year">年份</option>
<option value="memo">备注</option>
</select>
<input type="text" name="keyword" value="" class="text" />
</td>
</tr>

<tr>
<td>所属类别</td>
<td>
<select name="cid">
<option value="">无限制</option>
<?php echo $_class_opt;?>
</select>
</td>
</tr>

<tr>
<td>国家地区</td>
<td>
<select name="nid">
<option value="">无限制</option>
<?php echo $_nation_opt;?>
</select>
</td>
</tr>

<tr>
<td>排序类型</td>
<td>
<select name="orderway">
<option value="postdate">发表时间</option>
<option value="lastdate">更新时间</option>
<option value="hits">人气</option>
<option value="reply">评论</option>
</select>

<select name="asc">
<option value="ASC">升序</option>
<option value="DESC" selected>降序</option>
</select>
</td>
</tr>

<tr>
<td>每页显示行数</td>
<td>
<input type="text" size="5" value="<?php echo $db_perpage;?>" name="lines" class="text"/>
</td>
</tr>

</table><br />
<center><input type="submit" name="submit" value="提 交" class="button1" /></center><br />
</form>

<?php } elseif($action=='search') { ?>

<div class="w960 mt10 fl">
<div class="w700 fr">
<dl class="box">
<dt>视频搜索</dt>
<dd class="w698"><?php $videodb = pv_loop('video',"$tagstr|showsub=1|order=$orderway $asc|limit=$lines|page=$page|url=$url"); ?><ul class="clist"><?php if(is_array($videodb)) { foreach($videodb as $video) { ?><li>
<a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>"/></a>
<h2><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></h2>
<p>主演: <?php echo $video['playactor'];?></p>
<p>地区: <?php echo $video['nation_name'];?></p>
<p>时间: <?php echo get_date($video['postdate'],'Y-m-d'); ?></p>
<p>会员: <a href="profile.php?action=show&id=<?php echo $video['authorid'];?>" target="_blank"><?php echo $video['author'];?></a></p>
<p>人气: <?php echo $video['hits'];?></p>
<p>评论: <?php echo $video['reply'];?></p>
</li><?php } } ?></ul>								
</dd>
</dl>
<div class="pages"><?php pv_page($pageinfo); ?></div>
</div>

<div class="w245 fl">
<dl class="box">
<dt>相关排行 </dt>
<dd class="h395 numbg">
<ul class="vl"><?php $i=1; $videodb = pv_loop('video',"$tagstr_left|order=hits DESC|limit=10"); if(is_array($videodb)) { foreach($videodb as $video) { if($i==1) { ?>
<li class="l1">
<a class="imgbg1" href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>"/><span class="num1"></span></a>
<p class="subject"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></p>
<p>类别: <?php echo $video['class_name'];?></p>
<p>地区: <?php echo $video['nation_name'];?></p>
<p>热度: <?php echo $video['hits'];?></p>
<p>更新日期: <?php echo get_date($video['lastdate'],'Y-m-d'); ?></p>							
</li>					
<?php } else { ?>
<li>
<span class="fr"><?php echo $video['hits'];?></span>
<span class="sj"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></span>
</li>					
<?php } $i++; } } ?></ul>			
</dd>
</dl><?php $videodb = pv_loop('video',"$tagstr_left|best=2|order=lastdate DESC,postdate DESC|limit=3|dateformat=1"); if(!empty($videodb)) { ?>
<dl class="box mt10">
<dt>相关推荐 </dt>
<dd>
<ul class="vl"><?php if(is_array($videodb)) { foreach($videodb as $key => $video) { ?><li class="l1<?php if($key>0) { ?> mt10<?php } ?>">
<a class="imgbg1" href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>"/></a>
<p class="subject"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></p>
<p>类别: <?php echo $video['class_name'];?></p>
<p>地区: <?php echo $video['nation_name'];?></p>
<p>热度: <?php echo $video['hits'];?></p>
<p>更新日期: <?php echo get_date($video['lastdate'],'Y-m-d'); ?></p>							
</li><?php } } ?></ul>				
</dd>
</dl>
<?php } ?>

</div>


</div>


<?php } ?>