<?php
/**
 * Created by PhpStorm.
 * User: Morn
 * Date: 14-8-2
 * Time: 上午10:54
 */

require("Smarty.class.php");

$smarty = new Smarty();

$smarty->assign("pagetitle", "Welcome to the Starship");
$smarty->assign("name", "Kirk");

$smarty->display("test.tpl");