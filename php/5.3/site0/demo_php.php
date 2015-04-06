<?php
header("Content-type: text/html; charset=utf-8");

//ini_set('get_magic_quotes_gpc', 1);
//ini_set('magic_quotes_runtime', 1);

/* 我们在表单里填写:    "    这些符号,如果magic_quotes_gpc没有开启，那么他们不会被反斜杠转义 */
echo "现在通过POST传递过来的值是:". $_POST[str]."<br />";

if(get_magic_quotes_gpc()) {      // 检查magic_quotes_gpc是否打开,如果没有打开，用addslashes进行转义
    $str = $_POST[str];
} else {
    $str = addslashes($_POST[str]);
}

echo "这里是转义过后的: ,$str, <hr />";


//=====================================================================================
//-----magic_quotes_gpc只会转义：     通过Get/Post/Cookies获得的数据
//-----magic_quotes_runtime会转义：从文件中读取的数据或执行exec()的结果或是从ＳＱＬ查询中得到的
//=====================================================================================
$data = implode(file('try.txt'));      // 我们在里面依然写"这几个字符，用来测试
echo '这里是try.php的数据';
if (get_magic_quotes_runtime()) {
    echo "被系统自带转义的" . $data;
} else {
    $data = addslashes($data);
    echo "被addslashes转义了的" . $data;
}

$sql = "INSERT INTO lastnames (lastname) VALUES ($data)";
echo "<br />SQL语句为：<br /> ,$sql";
//---入库都转义了，但是多余了反斜杠，我们要读出来是原来的数据时候使用stripslashes()去掉反斜杠
//---stripslashes()和addslashes()作用相反


/**
 *
 */
function test() {

}