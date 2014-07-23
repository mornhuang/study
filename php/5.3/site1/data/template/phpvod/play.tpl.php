<div class="navpath blue">当前位置: <?php echo $navpath;?></div><?php $adcode = ad('nav'); if($adcode!='') { ?><div class="adnav"><?php echo $adcode;?></div><?php } ?>

<dl class="box w958 mt10">
<dt><?php echo $video['subject'];?> - <?php echo $urlcaption;?></dt>
<dd class="tc p5"><?php $adcode = ad('play',1); ?><!-- 播放器左侧广告 190*550-->
<?php if($adcode!='') { ?><div class="fl adplayside"><?php echo $adcode;?></div><?php } $adcode = ad('play',2); ?><!-- 播放器右侧广告 190*550-->
<?php if($adcode!='') { ?><div class="fr adplayside"><?php echo $adcode;?></div><?php } ?>

<div class="play"><?php echo $player;?></div>
</dd>	
</dl><?php if(is_array($urldb)) { foreach($urldb as $pg => $msg) { ?><dl class="box w958 mt10">
<dt><span class="fr"><?php echo $msg['player'];?></span>播放组<?php echo $msg['playgroup'];?></dt>
<dd class="playlist"><?php if(is_array($msg['urls'])) { foreach($msg['urls'] as $key => $value) { ?><a href="play.php?vid=<?php echo $msg['vid'];?>&playgroup=<?php echo $msg['playgroup'];?>&index=<?php echo $key;?>" title="<?php echo $value['caption'];?>" <?php if($msg['playgroup']==$playgroup && $key==$index) { ?>class="sel"<?php } ?>><?php echo $value['caption'];?></a><?php } } ?><div class="cb"></div>							
</dd>
</dl><?php } } $adcode = ad('play',3); if($adcode!='') { ?><div class="adplay"><?php echo $adcode;?></div><?php } ?>

