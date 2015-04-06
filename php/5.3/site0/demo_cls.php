<?php

include_once("common/common.php");

/**
 * Created by PhpStorm.
 * User: Morn
 * Date: 14-8-2
 * Time: 下午10:26
 */
class A
{
    function test()
    {
        echo "hello test\n";
    }

    function test2()
    {
        echo "test hello\n";
    }
}

A::test();
$a = new A();
$a->test2();

dump(get_declared_classes());