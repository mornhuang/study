#!/usr/bin/env python
#-*- coding:UTF-8 -*-

import sys
from basic.bk01.ch01 import mtloop


def test(value):
    value = value + 1
    print("Inner value", value)
    mtloop.loop_out()


if __name__ == '__main__':
    value2 = 10
    print("old value", value2)
    test(value2)
    print("new value", value2)

    print("中文")

    print(sys.argv)
    print(sys.path)

    mtloop.loop0()