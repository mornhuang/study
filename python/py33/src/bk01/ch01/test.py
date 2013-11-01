#!/usr/bin/env python
#-*- coding:UTF-8 -*-

"""
Test chinese input in py3
Test arg value
"""

import sys
from bk01.ch01 import mtloop


def test(arg):
    # change arg' value will no affect outer value.
    # It's same as c++, different with java/javascript
    arg = arg + 1
    print("Inner value", arg)


if __name__ == '__main__':
    value2 = 10
    print("old value", value2)
    test(value2)
    print("new value", value2)

    # py3 support unicode directly
    print("中文")

    print(sys.argv)
    print(sys.path)
