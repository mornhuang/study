<?php
require_once 'global.php';
include_once PHPVOD_ROOT . 'data/cache/class.php';
include_once PHPVOD_ROOT . 'data/cache/nation.php';

initvar(array('cid', 'nid', 'page'), 'GP', 2);
initvar(array('order', 'year'), 'GP');

if(!is_numeric($cid) || !isset($_class[$cid])) showmsg('class_illegal');

//�û���Ȩ�޼��
if($gp_allowread != '1') showmsg('group_read');

//��ĿȨ�޼��
$cr = pv_class_allow($cid);
switch($cr['result'])
{
	case '-1':
		showmsg('class_guest');
		break;
	case '-2':
		showmsg('class_visit');
		break;
	case '-3':
		showmsg('class_guestlimit');
		break;
	case '-4':
		showmsg('class_creditlimit','','',array($cr['data']['class_rvrcneed'],$cr['data']['user_rvrc'],$cr['data']['class_moneyneed'],$cr['data']['user_money'],$cr['data']['class_postneed'],$cr['data']['user_postnum']),30);
		break;
	case '-5':
		showmsg('classpw_guest');
		break;
	case '-6':
		$cid = $cr['data']['cid'];
		$forward = $cr['data']['forward'];
		require_once PHPVOD_ROOT . 'require/header.php';
		require_once gettpl('classpw');
		footer();
		break;
}

if(!empty($cid))
{
	$cidurl = "?cid=$cid"; //alink
	$tagstr = "cid=$cid"; //looptag
	$sel['cid'][$cid] = ' class="sel"'; //style
}

if(!empty($nid))
{
	$nidurl = "&nid=$nid";
	$tagstr .= "|nid=$nid";
	$sel['nid'][$nid] = ' class="sel"';
}
else
{
	$sel['nid']['all'] = ' class="sel"';
}

if(!empty($year))
{
	$yearurl = "&year=$year";
	$tagstr .= "|year=$year";
	$sel['year'][$year] = ' class="sel"';
}
else
{
	$sel['year']['all'] = ' class="sel"';
}

if(!empty($order))
{
	$orderurl = "&order=$order";
	$orderway = $order; //order key
	$orderasc = 'DESC'; //order type
}
else
{
	$orderway = $_class[$cid]['orderway']; //order key
	$orderasc = $_class[$cid]['orderasc'] == '0' ? 'ASC' : 'DESC'; //order type
}
$sel['order'][$orderway] = ' class="sel"';

if(!empty($page))
{
	$pagenumurl = "&page=$page";
}

$_class[$cid]['link'] != '' && obheader($_class[$cid]['link']); //��Ŀ�ⲿ����
$navpath = navpath($cid); //����

(!is_numeric($page) || $page < 1) && $page = 1; //ҳ��
$url = "class.php{$cidurl}{$nidurl}{$yearurl}{$orderurl}&"; //numofpage url
$cup = $_class[$cid]['cup']; //cupID
$top = strpos($_class[$cid]['fathers'], ',') === false ? $_class[$cid]['fathers'] : substr($_class[$cid]['fathers'], 0, strpos($_class[$cid]['fathers'], ',')); //topID
$tplfile = $_class[$cid]['tplfile'] != '' ? $_class[$cid]['tplfile'] : 'class'; //tplfile

require_once PHPVOD_ROOT . 'require/header.php';
require_once gettpl($tplfile);
footer();
?>