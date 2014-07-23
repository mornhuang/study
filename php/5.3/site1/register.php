<?php
require_once 'global.php';
include_once PHPVOD_ROOT . 'data/cache/dbreg.php';

initvar('vip');
if($vip == 'activating')
{
	initvar(array('r_uid','r_pwd'),'GP',2);
	$u = $db->get_one("SELECT yz FROM pv_members WHERE uid='$r_uid'");
	if($u)
	{
		if($r_pwd == $u['yz'] && (($timestamp-$u['yz']) < 86400)) //����ʱ�����֤
		{
			$db->update("UPDATE pv_members SET groupid='-1',yz='1' WHERE uid='$r_uid'");
			showmsg('reg_active_success', '','index.php');
		}
		else
		{
			showmsg('reg_active_fail');
		}
	}
	else
	{
		showmsg('reg_active_fail');
	}
}

!$rg_allowregister && showmsg('reg_close');
$groupid != 'guest' && showmsg('reg_repeat');

initvar('step', 'P', 2);
if($step == 2)
{
	initvar(array('regname', 'regpwd', 'regpwdrepeat', 'regemail'), 'P', 0);
	if($db_gdcheck & 1)
	{
		initvar('gdcode', 'P', 0);
		if(!gdconfirm($gdcode)) showmsg('check_error');
	}

	if(!$regpwd || strlen($regpwd) < 6) showmsg('not_password');
	if($regpwd != $regpwdrepeat) showmsg('password_confirm');

	$gid = $rg_regcheck == 0 ? '-1' : '4';
	$t = pv_user_register($regname, $regpwd, $regemail, $gid);
	if($t > 0)
	{
		//����cookie
		cookie('user', $t . "\t" . md5($regpwd));

		if($rg_regcheck==1)
		{
			$db->update("UPDATE pv_members SET yz='$timestamp' WHERE uid='$t'");
			$subject = lang('email_check_subject',array($db_wwwname));
			$message = lang('email_check_content',array($regname,$db_wwwname,$db_wwwurl,$t,$timestamp,$regpwd));
			if(sendemail(array($regemail), $subject, $message))
				showmsg('reg_email_success','',$db_bfn);
			else
				showmsg('reg_email_fail','',$db_bfn);
		}
		else
		{
			refreshto($db_bfn, 'reg_success');
		}
	}
	else
	{
		showmsg('pv_user_' . $t);
	}
}

require_once PHPVOD_ROOT . 'require/header.php';
require_once gettpl('register');
footer();
?>