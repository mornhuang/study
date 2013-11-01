#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-26 23:16
Demonstrate value change in different namespace
@see A\C module
"""

import bk00

# output 3
print(bk00.Flag)

import bk00.A

# output 'A', because bk00.Flag has been changed to 'A'
print(bk00.Flag)

if __name__ == '__main__':
    pass