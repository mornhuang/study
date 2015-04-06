<?php

/**
 * Created by PhpStorm.
 * User: Morn
 * Date: 14-8-1
 * Time: 下午6:17
 */
class ClassA
{
    private $secret;
    public $x;

    public function __construct()
    {
        echo "Call " . __METHOD__ . "\n";
        $this->setSecret();
    }

    function __destruct()
    {
        echo "Call " . __METHOD__ . "\n";
    }

    function __get($name)
    {
        echo "Call __get:".$name."\n";
    }

    function __set($name, $value)
    {
        echo "Call __set:".$name.",".$value."\n";
    }

    function __call($name, $arguments)
    {
        echo "Call __call:".$name.",".print_r($arguments, true)."\n";
    }

    function __sleep()
    {
        echo "Call ".__METHOD__."\n";
        $this->secret = "unknown";
        return array("secret");
    }

    function __wakeup()
    {
        echo "Call ".__METHOD__."\n";
        $this->setSecret();
    }

    private function setSecret()
    {
        $this->secret = "my secrets";
    }
}

$a = new ClassA();
$a->attrA = "ValueA";
echo $a->attrB;
$a->hello(1);
$b = serialize($a);
var_dump($b);
$c = unserialize($b);
var_dump($c);

$a->x = "test";
echo $a->x . "\n";



