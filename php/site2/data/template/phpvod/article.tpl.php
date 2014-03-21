<div class="w960 mt10 fl">

<div class="w700 fl">
<dl class="box mb10">
<dt>文档内容</dt>
<dd class="article">
<h3><?php echo $article['subject'];?></h3>
<span class="artinfo">
<span>发布人：<a href="profile?uid=<?php echo $article['authorid'];?>" target="_blank"><?php echo $article['author'];?></a></span> &nbsp;&nbsp;&nbsp;
<span>发布时间：<?php echo get_date($article['timestamp']); ?></span> &nbsp;&nbsp;&nbsp;
<span>点击数：<?php echo $article['hits'];?></span>
</span>
<span class="article_content">
<?php echo $article['content'];?>
</span>					
</dd>	
</dl>
</div>

<div class="w245 fr">
<dl class="box">
<dt>栏目列表</dt>
<dd>
<ul class="artclass">
<li><a href="arthome.php">文档首页</a></li><?php if(is_array($_artclass)) { foreach($_artclass as $classid => $classname) { ?><li><a href="artlist.php?classid=<?php echo $classid;?>"><?php echo $classname;?></a></li><?php } } ?></ul>				
</dd>			
</dl>		
</div>

</div>