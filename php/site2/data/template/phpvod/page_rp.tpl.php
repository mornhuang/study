<?php if(!empty($pageinfo)) { $page_first_url = str_replace('%page%', $pageinfo['page_first'], $pageinfo['url']); ?><a href="<?php echo $page_first_url;?>">首页</a>&nbsp;&nbsp;<?php $page_up_url = str_replace('%page%', $pageinfo['page_up'], $pageinfo['url']); ?><a href="<?php echo $page_up_url;?>">上一页</a>&nbsp;&nbsp;<?php for($i=$pageinfo['page_current']-3;$i<$pageinfo['page_current'];$i++) { if($i<1) continue; $url = str_replace('%page%', $i, $pageinfo['url']); ?><a href="<?php echo $url;?>"><?php echo $i;?></a>&nbsp;&nbsp;<?php } ?><strong><?php echo $pageinfo['page_current'];?></strong>&nbsp;&nbsp;

<?php if($pageinfo['page_current']<$pageinfo['page_end']) { $flag=0; for($i=$pageinfo['page_current']+1;$i<=$pageinfo['page_end'];$i++) { $url = str_replace('%page%', $i, $pageinfo['url']); ?><a href="<?php echo $url;?>"><?php echo $i;?></a>&nbsp;&nbsp;<?php $flag++; if($flag==4) break; } } $page_down_url = str_replace('%page%', $pageinfo['page_down'], $pageinfo['url']); ?><a href="<?php echo $page_down_url;?>">下一页</a>&nbsp;&nbsp;<?php $page_end_url = str_replace('%page%', $pageinfo['page_end'], $pageinfo['url']); ?><a href="<?php echo $page_end_url;?>">尾页</a>&nbsp;Pages: ( <?php echo $pageinfo['page_current'];?>/<?php echo $pageinfo['page_end'];?> total )
<?php } ?>