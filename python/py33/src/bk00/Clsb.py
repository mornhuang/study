#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-11-01 11:10
test special module attribute with single/double under line
"""

import bk00.ClsA
from bk00.ClsA import _C
from bk00.ClsA import __D
from bk00.ClsA import FlagB


if __name__ == '__main__':
    clsc = _C()
    clsd = __D()
    Flag = 2
    pass