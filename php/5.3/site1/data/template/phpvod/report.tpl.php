<form action="report.php" method="post">
<input type="hidden" value="2" name="step" />
<input type="hidden" name="vid" value="<?php echo $vid;?>">
<table class="box w958 mt10">
<tr>
<th colspan="2">
<img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/dticon1.gif" align="absmiddle"> 
<a href="<?php echo $db_bfn;?>"><?php echo $db_wwwname;?></a> &raquo; 举报视频
</th>
</tr>
<tr>
<td class="w40">报告为</td>
<td>
<select name="type">
<option value="链接失效">链接失效</option>
<option value="违禁视频">违禁视频</option>
<option value="其它原因">其它原因</option>
</select>
</td>
</tr>
<tr>
<td>原因</td>
<td><textarea name="reason" cols="60" rows="6"></textarea></td>
</tr>
</table><br />
<center><input type="submit" value="提 交" class="button1"></center>
</form>
