<div class="w960 mt10 fl">

<div class="w700 fl">
<dl class="box mb10">
<dt><?php echo $_artclass[$classid];?></dt>
<dd class="p10">
<ul class="artlist"><?php $articledb = pv_loop('article',"classid=$classid|limit=20|page=$page|url=artlist.php?classid=$classid&|cachetime=60s|sync=1"); if(is_array($articledb)) { foreach($articledb as $article) { ?><li>
<span class="arttime"><?php echo get_date($article['timestamp']); ?></span>
<span class="artsubject"><a href="article.php?aid=<?php echo $article['aid'];?>"><?php echo $article['subject'];?></a></span>
</li><?php } } ?></ul>	
</dd>	
</dl>
<div class="pages"><?php pv_page($pageinfo); ?></div>
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
