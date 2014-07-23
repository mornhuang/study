<?php if($action=='sendpwd') { ?>
<form action="sendpwd.php" method="post" name="sendpwd">
<input type="hidden" value="sendpwd" name="action" />
<input type="hidden" value="2" name="step" />
<table class="box w958 mt10">
<tr><th colspan="2">
<img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/dticon1.gif" align="absmiddle"> 
<a href="<?php echo $db_bfn;?>"><?php echo $db_wwwname;?></a> &raquo; 密码发送程序
</th></tr>
<?php if($db_gdcheck & 16) { ?>
<tr>
<td><strong>验证码</strong></td>
<td>
<div><input type="input" id="gdcode" name="gdcode" size="6" class="text" /></div>
<div class="mt2"><img src="ck.php?nowtime=<?php echo $timestamp;?>" align="absmiddle" style="cursor:pointer;" id="ckcode" onclick="this.src='ck.php?nowtime='+new Date().getTime();" alt="看不清楚，换一张" title="看不清楚，换一张" /></div>
</td>
</tr>
<?php } ?>
<tr>
<td class="w40"><strong>用户名</strong></td>
<td><input type="text" name="username" class="text" /></td>
</tr>
<tr>
<td><strong>Email</strong></td>
<td><input type="text" name="email" class="text" /></td>
</tr>
</table>
<br /><center><input type="submit" value="提 交" class="button1" /></center>
</form>

<?php } elseif($action=='getback') { ?>

<form action="sendpwd.php" method="post" name="sendpwd">
<input type="hidden" name="action" value="getback" />
<input type="hidden" name="job" value="2" />
<input type="hidden" name="uid" value="<?php echo $uid;?>" />
<input type="hidden" name="submit" value="<?php echo $submit;?>" />

<table class="box w958 mt10">
<tr><th colspan="2">
<img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/dticon1.gif" align="absmiddle"> 
<a href="<?php echo $db_bfn;?>"><?php echo $db_wwwname;?></a> &raquo; 设置新密码
</th></tr>

<tr>
<td class="w40"><strong>新密码</strong></td>
<td><input type="password" name="new_pwd" class="text" /></td>
</tr>

<tr>
<td><strong>重复新密码</strong></td>
<td><input type="password" name="rep_pwd" class="text" /></td>
</tr>
</table>
<br /><center><input type="submit" value="提 交" class="button1" /></center>
</form>

<?php } ?>
