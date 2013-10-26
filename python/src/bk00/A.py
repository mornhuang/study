#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-26 23:15

"""
import bk00

if __name__ == '__main__':
    print(bk00.Flag)

bk00.Flag = 'A'

if __name__ == '__main__':
    print(bk00.Flag)