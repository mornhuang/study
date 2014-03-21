<?php
!defined('IN_PHPVOD') && exit('Forbidden');
$dbsetfile = 'data/cache/dbset.php';

if($action != 'unsubmit')
{
	!$admintype && $admintype = 'wwwset';
	if($admintype == 'wwwset' || $admintype == 'all')
	{
		$db_whyclose = str_replace('<br />', "\n", $db_whyclose);
		$db_copyright = str_replace('<br />', "\n", $db_copyright);
		ifcheck($db_siteifopen, 'siteifopen');
	}
	if($admintype == 'function' || $admintype == 'all')
	{
		ifcheck($db_lp, 'lp');
		$db_timedf < 0 ? ${'zone_0' . str_replace('.', '_', abs($db_timedf))} = 'selected' : ${'zone_' . str_replace('.', '_', $db_timedf)} = 'selected';
		${'charset_' . str_replace('-', '', $db_charset)} = 'selected = "selected"';
		ifcheck($db_cc, 'cc','select');
		ifcheck($db_xforwardip, 'xforwardip');
		ifcheck($db_obstart, 'obstart');
		ifcheck($db_debug, 'debug');

		if($db_datefm)
		{
			if(strpos($db_datefm, 'h:i A'))
			{
				$db_datefm = str_replace(' h:i A', '', $db_datefm);
				$check_12 = 'checked';
			}
			else
			{
				$db_datefm = str_replace(' H:i', '', $db_datefm);
				$check_24 = 'checked';
			}
			$db_datefm = str_replace('m', 'mm', $db_datefm);
			$db_datefm = str_replace('n', 'm', $db_datefm);
			$db_datefm = str_replace('d', 'dd', $db_datefm);
			$db_datefm = str_replace('j', 'd', $db_datefm);
			$db_datefm = str_replace('y', 'yy', $db_datefm);
			$db_datefm = str_replace('Y', 'yyyy', $db_datefm);
		}
		else
		{
			$db_datefm = 'yyyy-mm-dd';
			$check_24 = 'checked';
		}

		ifcheck($db_forcecharset, 'forcecharset');
		ifcheck($db_tplrefresh, 'tplrefresh');
		ifcheck($db_iconupload, 'iconupload');
		$choseskin = create_style_option($db_defaultstyle);
		ifcheck($db_encodeurl, 'encodeurl');
	}
	if($admintype == 'ck' || $admintype == 'all')
	{
		for($i = 0; $i < 6; $i++)
		{
			($db_gdcheck & pow(2, $i)) && ifcheck(pow(2, $i), 'gdcheck');
			($db_gdstyle & pow(2, $i)) && ifcheck(pow(2, $i), 'gdstyle');
		}
		ifcheck($db_gdtype, 'gdtype', 'select');
		$gdsize = explode("\t", $db_gdsize);
	}
	if($admintype == 'info' || $admintype == 'all')
	{
		$db_setshowpic = implode("\r\n", unserialize($db_setshowpic));		
		ifcheck($db_showpic, 'showpic');
		ifcheck($db_indexlink, 'indexlink');
		ifcheck($db_indexmqlink, 'indexmqlink');
		ifcheck($db_reply, 'reply');
	}
	if($admintype == 'pathset' || $admintype == 'all')
	{
		if(file_exists($imgdir) && !is_writeable($imgdir))
		{
			$imgdisabled = 'disabled';
		}
		if(file_exists($attachdir) && !is_writeable($attachdir))
		{
			$attdisabled = 'disabled';
		}
		ifcheck($db_autochange, 'autochange');
		ifcheck($db_hour, 'hour','select');
	}
	if($admintype == 'sethtm' || $admintype == 'all')
	{
		ifcheck($db_htmifopen, 'htmifopen');
		!$db_dir && $db_dir = '.php?';
		!$db_ext && $db_ext = '.html';
		for($i = 0; $i < 4; $i++)
		{
			($db_optimizelink & pow(2, $i)) && ifcheck(pow(2, $i), 'optimizelink');
		}
	}
	if($admintype == 'picupload' || $admintype == 'all')
	{
		ifcheck($db_uploadvodpic, 'uploadvodpic');
		ifcheck($db_picdir, 'picdir');
		$db_picmaxsize = ceil($db_picmaxsize / 1024);
		ifcheck($db_createthumb, 'createthumb');
		ifcheck($db_watermark, 'watermark');
		ifcheck($db_waterpos, 'waterpos');
	}
	if($admintype == 'regset' || $admintype == 'all')
	{
		include (PHPVOD_ROOT . 'data/cache/dbreg.php');
		ifcheck($rg_allowregister, 'allowregister');
		ifcheck($rg_regcheck, 'regcheck', 'select');
	}
	if($admintype == 'atcset' || $admintype == 'all')
	{
		$credit = unserialize($db_creditset);
	}
	if($admintype == 'email' || $admintype == 'all')
	{
		ifcheck($db_mailmethod, 'mailmethod');
		ifcheck($db_mailauth, 'mailauth');
	}

	include gettpl('settings');
	exit();
}
elseif($action == "unsubmit")
{
	if(!pv_is_writable(PHPVOD_ROOT . 'data/cache/config.php') && !chmod(PHPVOD_ROOT . 'data/cache/config.php', 0777))
	{
		adminmsg('config_777');
	}

	initvar('config','P',0);

	if($admintype == 'function' || $admintype == 'all')
	{
		if($config['datefm'])
		{
			initvar('time_f','P',2);
			if(strpos($config['datefm'], 'mm') !== false)
			{
				$config['datefm'] = str_replace('mm', 'm', $config['datefm']);
			}
			else
			{
				$config['datefm'] = str_replace('m', 'n', $config['datefm']);
			}
			if(strpos($config['datefm'], 'dd') !== false)
			{
				$config['datefm'] = str_replace('dd', 'd', $config['datefm']);
			}
			else
			{
				$config['datefm'] = str_replace('d', 'j', $config['datefm']);
			}
			$config['datefm'] = str_replace('yyyy', 'Y', $config['datefm']);
			$config['datefm'] = str_replace('yy', 'y', $config['datefm']);
			$timefm = $time_f == '12' ? ' h:i A' : ' H:i';
			$config['datefm'] .= $timefm;
		}
		else
		{
			$config['datefm'] = 'Y-n-j H:i';
		}

		!is_numeric($config['iconsize']) && $config['iconsize'] = 20;
		$config['cachetime'] = (int)$config['cachetime'];
	}

	if($admintype == 'ck' || $admintype == 'all')
	{
		initvar(array('gdcheck','gdstyle','gdsize'),'P',2);
		$config['gdcheck'] = !empty($gdcheck) ? intval(array_sum($gdcheck)) : 0;
		$config['gdstyle'] = !empty($gdstyle) ? intval(array_sum($gdstyle)) : 0;
		$config['gdsize'] = implode("\t", $gdsize);
	}
	if($admintype == 'info' || $admintype == 'all')
	{
		$s = explode("\r\n", $config['setshowpic']);
		$config['setshowpic'] = serialize($s);
		!is_numeric($config['adminperpage']) && $config['adminperpage'] = 20;
		!is_numeric($config['perpage']) && $config['perpage'] = 10;
		!is_numeric($config['readperpage']) && $config['readperpage'] = 10;
		!is_numeric($config['postmin']) && $config['postmin'] = 3;
		!is_numeric($config['postmax']) && $config['postmax'] = 5000;
		if(!is_numeric($config['yearstart']) || !is_numeric($config['yearend']) || (int)$config['yearstart'] > (int)$config['yearend'])
			$config['yearstart'] = $config['yearend'] = '';
	}
	if($admintype == 'pathset' || $admintype == 'all')
	{
		initvar('set','P');
		if($config['http'] != 'N' && !ereg("^http", $config['http']))
		{
			adminmsg('setting_http');
		}
		if($config['autochange'])
		{
			if(!is_writeable($imgdir))
			{
				$config['autochange'] = 0;
			}
		}
		if(!is_dir($set['picpath']) && $picpath != $set['picpath'] && !@rename($picpath, $set['picpath']))
		{
			$set['picpath'] = $picpath;
			adminmsg('setting_777');
		}
		if(!is_dir($set['attachpath']) && $attachname != $set['attachpath'] && !@rename($attachname, $set['attachpath']))
		{
			$set['attachpath'] = $attachname;
			adminmsg('setting_777');
		}
		$dbcontent = "<?php\r\n\$picpath = '$set[picpath]';\r\n\$attachname = '$set[attachpath]';\r\n?>";
		writeover(PHPVOD_ROOT . 'data/cache/dbset.php', $dbcontent);
	}
	if($admintype == 'sethtm' || $admintype == 'all')
	{
		initvar('optimizelink','P',2);
		$config['optimizelink'] = !empty($optimizelink) ? intval(array_sum($optimizelink)) : 0;
	}	
	if($admintype == 'picupload' || $admintype == 'all')
	{
		$config['picmaxsize'] = !is_numeric($config['picmaxsize']) ? 0 : $config['picmaxsize'] * 1024;
	}
	if($admintype == 'regset' || $admintype == 'all')
	{
		initvar('reg','P');
		!is_numeric($reg['regmaxhonor']) && $reg['regmaxhonor'] = 30;
		!is_numeric($reg['regmaxsign']) && $reg['regmaxsign'] = 100;
		!is_numeric($reg['regrvrc']) && $reg['regrvrc'] = 0;
		!is_numeric($reg['regmoney']) && $reg['regmoney'] = 0;
		!is_numeric($reg['regminname']) && $reg['regminname'] = 3;
		!is_numeric($reg['regmaxname']) && $reg['regmaxname'] = 12;
		if($reg['regmaxname'] > 15 || $reg['regminname'] < 1)
		{
			adminmsg('illegal_username');
		}
	}
	if($admintype == 'atcset' || $admintype == 'all')
	{
		initvar('creditdb','P',2);
		foreach($creditdb as $key => $value)
		{
			foreach($value as $k => $val)
			{
				$creditdb[$key][$k] = (int)$val;
			}
		}
		$config['creditset'] = $creditdb ? serialize($creditdb) : '';
	}

	//get pv_config
	$result = $db->query("SELECT * FROM pv_config WHERE 1");
	while($row = $db->fetch_array($result))
	{
		$row['db_name'] = str_replace("'", "\'", $row['db_name']);
		$configdb[$row['db_name']] = $row['db_value'];
	}

	//write pv_config
	$pre = array('config'=>'db_', 'reg'=>'rg_');
	foreach($pre as $k => $v)
	{
		${$k . '_update'} = false; //update flag
		$postarray = ${$k};
		if(is_array($postarray))
		{
			foreach($postarray as $key => $value)
			{
				$keyname = $v . $key;
				$c_key = ${$keyname};
				if($c_key != $value || $configdb[$keyname] != $value)
				{
					$db->if_update(
						"SELECT db_name FROM pv_config WHERE db_name='$keyname'",
						"UPDATE pv_config SET db_value='$value' WHERE db_name='$keyname'",
						"INSERT INTO pv_config SET db_name='$keyname',db_value='$value'"
					);
					${$k . '_update'} = true;
				}
			}
		}
	}

	//update cache
	$config_update && updatecache_config('db');
	$reg_update && updatecache_config('rg');

	adminmsg('operate_success');
}
?>