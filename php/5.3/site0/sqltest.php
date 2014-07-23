<?php
/**
 * Created by PhpStorm.
 * User: Morn
 * Date: 14-7-19
 * Time: 下午3:22
 */
$dbfile = "./imcpslwebint.db";
$db = new PDO("sqlite:" . $dbfile); //注意红字部分的路径格式，这样写会报错：new PDO('myDB.sqlite');
if ($db) {
    echo "connect ok\n";
} else {
    echo "connect bad\n";
}

$sql = "SELECT * FROM spot";
$result = $db->query($sql);
echo "dddddd\n";
//echo $result;
var_dump($result);
echo "return data:\n";
foreach ($db->query($sql) as $row) {
    // echo "$row[0]";
    echo $row[0] . ' / ' . $row[1] . ' / ' . $row[2] . '<br />' . "\n";
}
?>

<?php
phpinfo();
?>