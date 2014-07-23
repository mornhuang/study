<?php
!defined('IN_PHPVOD') && exit('Forbidden');

include_once PHPVOD_ROOT . "data/style/{$db_defaultstyle}.php";
$levelimg = array();
if($fp = opendir("$imgdir/$stylepath/level"))
{
	while(($file = readdir($fp)))
	{
		if(!is_dir($file) && substr($file, -4) == '.gif')
		{
			$imgid = substr($file, 0, -4);
			$levelimg[$imgid] = $file;
		}
	}
	closedir($fp);
}
ksort($levelimg);

if(empty($action))
{
	$groupdb = array();
	$query = $db->query("SELECT gid,gptype,grouptitle,groupimg,grouppost FROM pv_usergroups ORDER BY grouppost,gid");
	while($row = $db->fetch_array($query))
	{
		$groupdb[$row['gptype']][] = $row;
	}
}
elseif($action == 'menedit')
{
	initvar(array('memtitle','mempost','mempic'),'P');
	@asort($mempost);
	foreach($mempost as $key => $value)
	{
		if(!is_numeric($value))
		{
			$value = 20 * pow(2, $key);
			$mempost[$key] = $value;
		}
		$db->update("UPDATE pv_usergroups SET grouptitle='$memtitle[$key]',groupimg='$mempic[$key]',grouppost='$mempost[$key]' WHERE gptype='member' AND gid='$key'");
		updatecache_group($key);
	}
	updatecache_level();
	adminmsg('operate_success');
}
elseif($action == 'defedit' || $action == 'sysedit')
{
	initvar(array('memtitle', 'mempic'), 'P', 0);
	$gptype = $action == 'sysedit' ? 'system' : 'default';
	foreach($memtitle as $key => $value)
	{
		$db->update("UPDATE pv_usergroups SET grouptitle='$memtitle[$key]',groupimg='$mempic[$key]' WHERE gptype='$gptype' AND gid='$key'");
		updatecache_group($key);
	}
	updatecache_level();
	adminmsg('operate_success');
}
elseif($action == 'addmengroup' || $action == 'addadmingroup')
{
	initvar(array('newtitle', 'newpic'), 'P');
	initvar(array('newpost'), 'P', 2);
	$gptype = $action == 'addmengroup' ? 'member' : 'system';
	$db->update("INSERT INTO pv_usergroups(gptype,grouptitle,groupimg,grouppost) VALUES ('$gptype', '$newtitle', '$newpic','$newpost')");
	$gid = $db->insert_id();
	$action == 'addadmingroup' && updatecache_group($gid);
	updatecache_level();
	adminmsg('operate_success',"$basename&action=editgroup&gid=$gid");
}
elseif($action == "delgroup")
{
	initvar('delid','G',2);
	if($delid < 5)
	{
		adminmsg('level_del');
	}
	$db->update("DELETE FROM pv_usergroups WHERE gid='$delid'");
	file_exists(PHPVOD_ROOT . "data/groupdb/group_$delid.php") && delfile(PHPVOD_ROOT . "data/groupdb/group_$delid.php");
	updatecache_level();
	adminmsg('operate_success');
}
elseif($action == "editgroup")
{
	initvar('step','GP',2);
	if(!$step)
	{
		initvar('gid','G',2);
		if(file_exists(PHPVOD_ROOT . "data/groupdb/group_$gid.php") && $gid != 1)
		{
			include_once path_cv(PHPVOD_ROOT . "data/groupdb/group_$gid.php");
			$default = 0;
		}
		else
		{
			include_once (PHPVOD_ROOT . "data/groupdb/group_1.php");
			$default = 1;
		}
		ifcheck($gid, 'selgid','select');
		foreach($ltitle as $key => $value)
		{
			$groupselect .= "<option value=\"$key\" ${'selgid_'.$key}>$value</option>";
		}

		/**
		 * ����Ȩ��
		 */
		ifcheck($gp_allowread, 'allowread');
		ifcheck($gp_allowrp, 'allowrp');
		ifcheck($gp_allowhonor, 'allowhonor');
		ifcheck($gp_alloweditatc, 'alloweditatc');
		ifcheck($gp_allowdelatc, 'allowdelatc');
		ifcheck($gp_allowpost, 'allowpost');
		ifcheck($gp_allowmessage, 'allowmessage');
		ifcheck($gp_allowplay, 'allowplay');
		ifcheck($gp_atccheck, 'atccheck');
		ifcheck($gp_rpcheck, 'rpcheck');
		ifcheck($gp_allowprofile, 'allowprofile');
		ifcheck($gp_allowseticon, 'allowseticon');
		ifcheck($gp_allowupicon, 'allowupicon');
		ifcheck($gp_allowsell, 'allowsell');
		ifcheck($gp_allowencode, 'allowencode');

		/**
		 *  ����Ȩ��
		 */
		ifcheck($SYSTEM['allowadmincp'], 'allowadmincp');
		ifcheck($SYSTEM['allowadminedit'], 'allowadminedit');
		ifcheck($SYSTEM['allowadmindel'], 'allowadmindel');
		ifcheck($SYSTEM['allowadminshow'], 'allowadminshow');
		ifcheck($SYSTEM['allowadminviewhide'], 'allowadminviewhide');
		
		/**
		 * ��̨Ȩ�޹���(ֻ�й���Ա��������)
		 */
		if($admin['groupid'] == '3')
		{
			$table_str = '';
			$permissions = unserialize($SYSTEM['permissions']);
			$leftlang = require getlang('left');
			foreach($leftlang as $kkk => $vvv)
			{
				$table_str .= '<tr><td width="20%">' . $kkk . '</td><td><ul class="list200">';
				foreach($vvv as $kk => $vv)
				{
					if(is_array($vv))
					{
						foreach($vv as $k => $v)
						{
							$cstr = $permissions[$kk . '.' . $k] == '1' ? 'checked="checked"' : '';
							$table_str .= "<li><input type=\"checkbox\" name=\"permissions[{$kk}.{$k}]\" value=\"1\" {$cstr} /> {$v}</li>";	
						}
					}
					else 
					{
						$cstr = $permissions[$kk] == '1' ? 'checked="checked"' : '';
						$table_str .= "<li><input type=\"checkbox\" name=\"permissions[{$kk}]\" value=\"1\" {$cstr} /> {$vv}</li>";
					}
				}
				$table_str .= '</ul></td></tr>';			
			}
		}		
	}
	elseif($step == 2)
	{
		initvar(array('group','gid'),'P',2);
		initvar('gptype','P');
		$group['ifdefault'] = $gid != 1 ? 0 : 1;
		
		if($admin['groupid'] == '3')
		{
			initvar('permissions', 'P', 2);
			$permissions = serialize($permissions);
			$group['permissions'] = $permissions;		
		}
		
		if($gptype == 'system')
		{
			initvar('sysgroup','P',2);
			foreach($sysgroup as $key => $value)
			{
				$group[$key] = $value;
			}
		}

		$sql = "gid='$gid'";
		foreach($group as $key => $value)
		{
			$sql .= ",$key='$value'";
		}

		$db->update("UPDATE pv_usergroups SET $sql WHERE gid='$gid'");
		updatecache_group($gid);
		adminmsg('operate_success');
	}
}
elseif($action=='setdef')
{
	initvar('gid','G',2);
	$db->update("UPDATE pv_usergroups SET ifdefault='1' WHERE gid='$gid'");
	file_exists(PHPVOD_ROOT . "data/groupdb/group_$gid.php") && delfile(PHPVOD_ROOT . "data/groupdb/group_$gid.php");
	adminmsg('operate_success',"$basename&action=editgroup&gid=$gid");
}

include gettpl('level');
?>