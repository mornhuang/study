#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-26 23:15
Demonstrate value change in different namespace
@see B/C module
"""
import bk00

if __name__ == '__main__':
    # Flag value define in __init__ module, so import bk00 Flag will be assign to 3
    # should output 3
    print(bk00.Flag)

# change Flag's value
bk00.Flag = 'A'

if __name__ == '__main__':
    # should output 'A'
    print(bk00.Flag)