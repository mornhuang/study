<?php
/**
 * Created by PhpStorm.
 * User: Morn
 * Date: 14-8-1
 * Time: 下午9:45
 */

$attr = array(
    array(
        "id" => 1,
        "name" => "James"
    ),
    array(
        "id" => 2,
        "name" => "Iris"
    )
);

print_r($attr);

$str = json_encode($attr);
echo "Array 2 Json: " . $str . "\n";

echo "Json 2 Array: ";
$arr = json_decode($str);
print_r($arr);

echo $arr[0]->id;