<!--<form method="post" action="#">-->
<!--    <input type="text" name="content" size="20" />-->
<!--    <select name="type">-->
<!--        <option value="招聘信息">--招聘信息--</option>-->
<!--        <option value="求职信息">--求职信息--</option>-->
<!--    </select>-->
<!--    <input type="submit" value="提交" />-->
<!--</form>-->

<?php
/**
 * Created by PhpStorm.
 * User: Morn
 * Date: 14-3-16
 * Time: 上午3:27
 */

//if ($_SERVER['REQUEST_METHOD'] != 'POST') exit(0);
//header("Content-Type:text/html;charset=utf-8");
$content = $_POST['content'];
$type = $_POST['type'];

$link = mysql_connect('localhost', 'root', 'huangmeng') or die("数据库服务器连接错误:".mysql_error());
mysql_select_db('db_pursey', $link)  or die("数据库访问错误:".mysql_error());
$sql = mysql_query('select * from tb_info', $link);
$info = mysql_fetch_array($sql);
//echo '<pre>';
//var_dump($info);
//echo '</pre>';
echo '<pre>';
print_r($info);
echo '</pre>';

$output = "this is  这是 \ta line.\nAnd this is another line.";
echo "$output <br />";
$output2 = 'this is \\ another';
echo "$output2 <br />";
$output3 = 'this is another \\';
echo "$output3 <br />";


