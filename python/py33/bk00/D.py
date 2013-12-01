#!usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-01 11:05

"""


from bk00.flag.orig import bb
from bk00.flag.orig import zz
from bk00.flag import aa

Flag = "Override in Module D"

if __name__ == "__main__":
    for k in globals().keys():
        print(k, globals()[k])



