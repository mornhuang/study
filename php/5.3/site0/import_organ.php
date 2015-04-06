<?php
/**
 * Created by PhpStorm.
 * User: Morn
 * Date: 14-8-22
 * Time: 下午6:16
 */

error_reporting(E_ALL);
set_include_path(get_include_path() . PATH_SEPARATOR . '../Classes/');
include 'PHPExcel.php';

$objPHPExcel = new PHPExcel();
