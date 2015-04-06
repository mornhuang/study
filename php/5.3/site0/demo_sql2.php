<?php
/**
 * 文件：sqlite.php
 * 功能：对sqlite数据库的处理
 * 作者：heiyeluren
 * 时间：2005-8-5
 */
define("LN", __LINE__); //行号
define("FL", __FILE__); //当前文件
define("DEBUG", 0); //调试开关

$db_name = "heiyeluren.db";
//创建数据库文件,文件内容为空
if (!file_exists($db_name)) {
    if (!($fp = fopen($db_name, "w+"))) {
        exit(error_code(-1, LN));
    }
    fclose($fp);
}


if ($db = sqlite_open($db_name, 0666, $sqliteerror)) {
    sqlite_query($db,'CREATE TABLE foo (bar varchar(10))');
    sqlite_query($db,"INSERT INTO foo VALUES ('fnord')");
    $result = sqlite_query($db,'select bar from foo');
    var_dump(sqlite_fetch_array($result));
} else {
    die ($sqliteerror);
}


//打开数据库文件
sqlite_open($db_name);
if (!($db = sqlite_open($db_name))) {
    exit(error_code(-2, LN));
}



//产生数据表结构
if (!sqlite_query($db, "DROP TABLE test")) {
    exit(error_code(-3, LN));
}
if (!sqlite_query($db, "CREATE TABLE test (id integer primary key,pid integer,name varchar(10) UNIQUE)")) {
    exit(error_code(-3, LN));
}
//插入一条数据
if (!sqlite_query($db, " INSERT INTO test (name) VALUES ('heiyeluren') ")) {
    exit(error_code(-4, LN));
}
//把数据检索出来
if (!($result = sqlite_query($db, "SELECT * FROM test"))) {
    exit(error_code(-5, LN));
}

//获取检索数据并显示
while ($array = sqlite_fetch_array($result)) {
    echo "ID: " . $array[id] . "<br>Name: " . $array[name];
}

/* 错误信息代码函数 */
function error_code($code, $line_num, $debug = DEBUG)
{
    if ($code < -6 || $code > -1) {
        return false;
    }
    switch ($code) {
        case -1:
            $errmsg = "Create database file error.";
            break;
        case -2:
            $errmsg = "Open sqlite database file failed.";
            break;
        case -3:
            $errmsg = "Create table failed, table already exist.";
            break;
        case -4:
            $errmsg = "Insert data failed.";
            break;
        case -5:
            $errmsg = "Query database data failed.";
            break;
        case -6:
            $errmsg = "Fetch data failed.";
            break;
        case -7:
            $errmsg = "";
            break;
        default:
            $errmsg = "Unknown error.";
    }

    $m = "<b>[ Error ]</b><br>File: " . basename(FL) . " <br>Line: " . LN . "<br>Mesg: " . $errmsg . "";
    if (!$debug) {
        ($m = $errmsg);
    }
    return $m;
}
