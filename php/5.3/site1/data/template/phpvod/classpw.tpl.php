<dl class="box mt10">
<dt>栏目密码</dt>
<dd>
<form method="post" action="do.php">
<input type="hidden" name="action" value="confirm_classpw" />
<input type="hidden" name="cid" value="<?php echo $cid;?>" />
<input type="hidden" name="forward" value="<?php echo $forward;?>" />
<center>
<br />
本栏目为加密版块,需密码验证 (游客无权登录此栏目)<br /><br />
请输入密码:&nbsp;
<input type="password" size="20" maxlength="75" name="classpass" class="text"/>
<input type="submit" value="提 交" class="button" />
</center><br />
</form>		
</dd>
</dl>
