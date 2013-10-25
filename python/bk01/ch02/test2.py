#!/usr/bin/env python
#-*- coding:UTF-8 -*-

"""
Date: 2013-10-18 23:00
Test import sentence
"""

import sys
from bk01.ch01 import test as test1


def test():
    print("hello")


if __name__ == '__main__':
    print(sys.path)
    test1.test(12)





