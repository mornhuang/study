#!usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-01 11:11

"""

from bk00.flag.orig.zz import *
from bk00.flag.orig import bb

AA_Flag = 'Module A'
bb.BB_Flag = "Change in A"
BB_Flag = "Override in Module A"


def showFlag():
    print("AA_FLAG", AA_Flag)
    print("BB_FLAG in orig", bb.BB_Flag)


def showHello():
    print("hello")


if __name__ == "__main__":
    print(globals())
    showFlag()

