<?php include gettpl('panel_flash'); $adcode = ad('nav'); if($adcode!='') { ?><div class="adnav"><?php echo $adcode;?></div><?php } ?>

<div class="w960 mt10 fl">
<div class="w700 fl">
<dl class="box">
<dt>推荐影片</dt>
<dd class="h395">
<ul class="sv"><?php $videodb = pv_loop('video',"cid=$cid|showsub=1|best=2|limit=10|order=lastdate DESC,postdate DESC,v.vid DESC"); if(is_array($videodb)) { foreach($videodb as $video) { ?><li>
<div class="pic"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>" /></a></div>
<div class="subject"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></div>
<div class="author"><a href="profile.php?action=show&id=<?php echo $video['authorid'];?>" target="_blank" title="<?php echo $video['author'];?>"><?php echo $video['author'];?></a></div>
</li><?php } } ?></ul>
</dd>		
</dl>		
</div>
<div class="w245 fr">
<dl class="box">
<dt>最近更新</dt>
<dd class="h395 numbg">
<ul class="vl"><?php $i=1; $videodb = pv_loop('video',"cid=0|showsub=1|limit=10|order=lastdate DESC,postdate DESC,v.vid DESC"); if(is_array($videodb)) { foreach($videodb as $video) { if($i==1) { ?>
<li class="l1">
<a class="imgbg1" href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>"/><span class="num1"></span></a>
<p class="subject"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></p>
<p>类别: <?php echo $video['class_name'];?></p>
<p>地区: <?php echo $video['nation_name'];?></p>
<p>热度: <?php echo $video['hits'];?></p>
<p>更新日期: <?php echo get_date($video['lastdate'], 'Y-m-d'); ?></p>							
</li>					
<?php } else { ?>
<li>
<span class="fr"><?php echo get_date($video['lastdate'],'m-d'); ?></span>
<span class="sj"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></span>
</li>					
<?php } $i++; } } ?></ul>				
</dd>			
</dl>		
</div>
</div><?php $adcode = ad('class',1); if($adcode!='') { ?><div class="adclass"><?php echo $adcode;?></div><?php } $adi=2; $c1db = pv_loop('class',"cid=$cid"); if(is_array($c1db)) { foreach($c1db as $c1) { ?><div class="w960 mt10 fl">
<div class="w700 fl">
<dl class="box">
<dt>
<span class="fr fz12"><?php $c2db = pv_loop('class',"cid=$c1[cid]"); if(is_array($c2db)) { foreach($c2db as $c2) { ?>&nbsp;&nbsp;<a href="class.php?cid=<?php echo $c2['cid'];?>"><?php echo $c2['caption'];?></a><?php } } ?>&nbsp;&nbsp;<a href="class.php?cid=<?php echo $c1['cid'];?>">更多...</a>
</span>
<?php echo $c1['caption'];?>				
</dt>
<dd class="h395">
<ul class="sv"><?php $videodb = pv_loop('video',"cid=$c1[cid]|showsub=1|order=lastdate DESC,postdate DESC,v.vid DESC|limit=10"); if(is_array($videodb)) { foreach($videodb as $video) { ?><li>
<div class="pic"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>" /></a></div>
<div class="subject"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></div>
<div class="author"><a href="profile.php?action=show&id=<?php echo $video['authorid'];?>" target="_blank" title="<?php echo $video['author'];?>"><?php echo $video['author'];?></a></div>
</li><?php } } ?></ul>
</dd>		
</dl>		
</div>
<div class="w245 fr">
<dl class="box">
<dt>
<div class="rank">
<a href="javascript:;" onmouseover="tab('<?php echo $c1['cid'];?>',3,1);" id="a<?php echo $c1['cid'];?>_1" class="sel">昨天</a>
<a href="javascript:;" onmouseover="tab('<?php echo $c1['cid'];?>',3,2);" id="a<?php echo $c1['cid'];?>_2">本周</a>
<a href="javascript:;" onmouseover="tab('<?php echo $c1['cid'];?>',3,3);" id="a<?php echo $c1['cid'];?>_3">本月</a>
</div>				
<?php echo $c1['caption'];?>排行
</dt><?php $rankarr = array('1'=>'yesterday_hits','2'=>'week_hits','3'=>'month_hits'); if(is_array($rankarr)) { foreach($rankarr as $k => $t) { $stylestr = $t=='yesterday_hits' ? 'block' : 'none'; ?><dd class="h395 numbg" id="c<?php echo $c1['cid'];?>_<?php echo $k;?>" style="display: <?php echo $stylestr;?>">
<ul class="vl"><?php $i=1; $videodb = pv_loop('video',"cid=$c1[cid]|showsub=1|limit=10|order=$t DESC,hits DESC|cachetime=1d"); if(is_array($videodb)) { foreach($videodb as $video) { if($i==1) { ?>
<li class="l1">
<a class="imgbg1" href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><img src="<?php echo $video['picurl'];?>" alt="<?php echo $video['subject'];?>"/><span class="num1"></span></a>
<p class="subject"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></p>
<p>类别: <?php echo $video['class_name'];?></p>
<p>地区: <?php echo $video['nation_name'];?></p>
<p>热度: <?php echo $video[$t];?></p>
<p>更新日期: <?php echo get_date($video['lastdate'], 'Y-m-d'); ?></p>							
</li>					
<?php } else { ?>
<li>
<span class="fr"><?php echo $video[$t];?></span>
<span class="sj"><a href="read.php?vid=<?php echo $video['vid'];?>" title="<?php echo $video['subject'];?>"><?php echo $video['subject'];?></a></span>
</li>					
<?php } $i++; } } ?></ul>				
</dd><?php } } ?></dl>		
</div>
</div><?php $adcode = ad('class',$adi); $adi++; if($adcode!='') { ?><div class="adclass"><?php echo $adcode;?></div><?php } } } ?>