<?php
/**
 * Created by PhpStorm.
 * User: Morn
 * Date: 14-4-5
 * Time: 上午11:11
 */

$var = 3 . 2.74;
echo $var;

$var = 'a';
echo ++$var; // b
$var = 'z';
echo ++$var; // aa
$var = 'spaz';
echo ++$var; // spba
$var = 'K9';
echo ++$var; // L0
$var = 42;
echo ++$var; // 43

echo "\n";

function hello() {
    echo "hello\n";
}

register_tick_function("hello");
declare(ticks = 5) {
    for($i = 0; $i < 10; $i++) {
        echo $i;
        echo "\n";
    }
}

function outer($a) {
    function inner($b) {
        echo "there is $b\n";
    }

    echo "there $a\n";
}

outer("well");
inner("reader");

$which = "hello";
if (function_exists($which)) {
    $which();
}

$s = <<< begin
dfdsi
dfi "dkd";
ddiid


begin;
echo $s;

$string = "hello, world";
echo $string{1};
echo "\n";

$str = htmlentities("test < hello");
echo $str . "\n";
$table = get_html_translation_table(HTML_ENTITIES);
echo $table . "\n";
$rev_trans = array_flip($table);
echo $rev_trans . "\n";
echo strtr($str, $rev_trans) . "\n";

$whoops = array(1 => "monday", "brand", "temp");
print_r($whoops);

$score = array(5, 10);
$pad1 = array_pad($score, 5, 0);
$pad2 = array_pad($score, -5, 0);
print_r($pad1);
print_r($pad2);

