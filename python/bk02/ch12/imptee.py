#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 13:04

"""

foo = 'abc'
_test = 10


def show():
    aStr = "kkk"
    print("foo from imptee: ", foo)
    print("imptee's globals: ", list(globals().keys()))
    print("imptee's import locals: ", list(locals().keys()))

if __name__ == '__main__':
    pass