<?php if(is_array($replydb)) { foreach($replydb as $key => $value) { ?><div class="reply">
<div class="icon"><img src="<?php echo $value['icon'];?>" /></div>

<div class="txt">
<div class="title">
<?php if($value['authorid']!=0) { ?>
<span class="fr"><a href="message.php?action=write&touid=<?php echo $value['authorid'];?>" target="_blank">发送短消息</a></span>
<a href="profile.php?action=show&id=<?php echo $value['authorid'];?>" target='_blank'><?php echo $value['author'];?></a>
<?php } else { ?>
<?php echo $value['author'];?> 
<?php } ?>
发布于 <?php echo $value['postdate'];?>
</div>
<div class="content"><?php echo $value['content'];?></div>
<div class="signature"><?php echo $value['signature'];?></div>
</div>
</div><?php } } ?><div class="pages"><?php pv_page($pages, 'page_rp'); ?></div>