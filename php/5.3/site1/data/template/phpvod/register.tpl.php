<form action="register.php" method="post" onSubmit="return check(this)" name="register">
<input type="hidden" value="2" name="step" />
<table class="box w958 mt10">
<tr><th colspan="2">
<img src="<?php echo $imgpath;?>/<?php echo $stylepath;?>/dticon1.gif" align="absmiddle"> 
<a href="<?php echo $db_bfn;?>"><?php echo $db_wwwname;?></a> &raquo; 新会员注册
</th></tr>
<?php if($db_gdcheck & 1) { ?>
<tr>
<td><strong>认证码<span style="color: red;">*</span></strong></td>
<td> 
<div><input type="input" id="gdcode" name="gdcode" size="6" class="text" /></div>
<div class="mt2"><img src="ck.php?nowtime=<?php echo $timestamp;?>" align="absmiddle" style="cursor:pointer;" id="ckcode" onclick="this.src='ck.php?nowtime='+new Date().getTime();" alt="看不清楚，换一张" title="看不清楚，换一张" /></div>
</td>
</tr>
<?php } ?>
<tr>
<td class="w40">
<strong>用户名<span style="color: red;">*</span></strong><br />可以是中文，不能有空格，长度控制在 <?php echo $rg_regminname;?> - <?php echo $rg_regmaxname;?> 字节以内
</td>
<td>
<input type="text" class="text" name="regname" onblur='$.ajax({type:"POST",url:"ajax.php",data:"action=check_username&username="+this.value, success:function(msg){$("#register_check_regname").html(msg);}});' />
<span id="register_check_regname"></span>
</td>
</tr>

<tr>
<td><strong>密码<span style="color: red;">*</span></strong><br />英文字母或数字等不少于6位</td>
<td><input type="password" class="text" name="regpwd" id="regpwd" onchange="checkpwd();" />&nbsp;<span id="pwd_info"></span></td>
</tr>

<tr>
<td><strong>确认密码<span style="color: red;">*</span></strong></td>
<td><input type="password" class="text" name="regpwdrepeat" id="regpwdrepeat" onchange="checkpwdrepeat();" />&nbsp;<span id="pwdrepeat_info"></span></td>
</tr>

<tr>
<td><strong>E-Mail<span style="color: red;">*</span></strong><?php if($rg_regcheck=='1') { ?><br /><span class="stylecolor">帐号需要认证，请正确填写邮箱地址</span><?php } ?></td>
<td><input type="text" class="text" name="regemail" id="regemail" onblur='$.ajax({type:"POST",url:"ajax.php",data:"action=check_email&email="+this.value, success:function(msg){$("#register_check_email").html(msg);}});' />&nbsp;<span id="register_check_email"></span></td>
</tr>
</table>
<br /><center><input name="regsubmit" type="submit" value="提 交" class="button1"/></center>
</form>

<script language="JavaScript" type="text/javascript">
function checkpwd()
{
var pwd = document.getElementById("regpwd").value;
var pwdrepeat = document.getElementById("regpwdrepeat").value;
if (pwd.length<6)
document.getElementById("pwd_info").innerHTML = "<span style=\"color: red;\">密码太少，请用6位以上。</span>";
else
document.getElementById("pwd_info").innerHTML = "";

if(pwdrepeat) checkpwdrepeat();
}
function checkpwdrepeat()
{
var pwd = document.getElementById("regpwd").value;
var pwdrepeat = document.getElementById("regpwdrepeat").value;
if (pwdrepeat==pwd)
document.getElementById("pwdrepeat_info").innerHTML = "";
else
document.getElementById("pwdrepeat_info").innerHTML = "<span style=\"color: red;\">两次输入的密码不一致，请检查后重试。</span>";
}
</script>
