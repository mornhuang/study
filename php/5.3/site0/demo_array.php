<?php
/**
 * Created by PhpStorm.
 * User: Morn
 * Date: 14-7-29
 * Time: 下午10:42
 */

include_once "common/common.php";

$primes = array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
for ($count = 1; $count < 1000; $count++) {
    $randomNum = rand(1, 50);
    if (in_array($randomNum, $primes)) {
        break;
    } else {
        printf("Non-Prime number found: %d <br />", $randomNum);
    }
}

$cost = 20.99;
$tax = 0.0575;

function calculateCost(&$cost, $tax)
{
    $cost = $cost + ($cost * $tax);
    $tax += 4;
}

calculateCost($cost, $tax);
printf("Tax is %01.2f%% <br />", $tax * 100);
printf("Cost is %01.2f <br />", $cost);

$tmp[0] = 1;
$tmp[49] = 2;
echo "<pre>";
print_r($tmp);
echo "</pre>";

echo "Array {<br />";
foreach ($tmp as $key => $val) {
    echo "&nbsp;&nbsp;&nbsp;&nbsp;[$key] => $val <br />";
}
echo "}";


echo "<pre>";
echo "Array {<br />";
foreach ($tmp as $key => $val) {
    echo "    [$key] => $val <br />";
}
echo "}";
echo "</pre>";

$tmp2 = print_r($tmp, true);
echo $tmp2;

echo "<p>demonstrate unshift</p>";
$tmp = array(2, 3, "tt" => "tt", 10 => "m");
echo "<pre>";
print_r($tmp);
echo "</pre>";

array_unshift($tmp, "hello1", "hello2");
echo "<pre>";
print_r($tmp);
echo "</pre>";

echo "<p>demonstrate next</p>";
$x =  next($tmp) . "<br />";
$x =  next($tmp) . "<br />";
$x =  next($tmp) . "<br />";
$x =  next($tmp) . "<br />";
$x = next($tmp) . "<br />";
$x = next($tmp) . "<br />";
$x = next($tmp) . "<br />";
$x = next($tmp) . "<br />";

$m = false;
echo $m;

$face = array("J", "Q", "K", "A");
$numbered = array("2", "3", "4", "5", "6");
$cards = array_merge($face, $numbered);
echo "<p>demonstrate array_merge</p>";
echo "<pre>";
print_r($cards);
echo "</pre>";

shuffle($cards);
dump($cards);

$states = array("Ohio" => "Columbus", "Iowa" => "Des Moines", "Arizona" => "Phoenix");
$randomStates = array_rand($states, 2);
dump($randomStates);

