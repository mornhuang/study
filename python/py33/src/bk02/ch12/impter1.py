#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 13:05
Demonstrate namespace using from and import, @see module impter2
"""


if __name__ == '__main__':
    print("before import globals: ", list(globals().keys()))
    print("before import locals: ", list(locals().keys()))

    from bk02.ch12.imptee import *

    print("after import globals: ", list(globals().keys()))
    print("after import locals: ", list(locals().keys()))

    show()
    foo = 123
    print("foo from impter: ", foo)
    show()

