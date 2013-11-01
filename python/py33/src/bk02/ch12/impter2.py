#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 13:08
Demonstrate namespace using from and import, @see module impter1
"""

if __name__ == '__main__':
    print("before import globals: ", list(globals().keys()))
    print("before import locals: ", list(locals().keys()))

    import basic.bk02.ch12.imptee as imptee

    print("before import globals: ", list(globals().keys()))
    print("before import locals: ", list(locals().keys()))

    imptee.show()
    imptee.foo = 123
    print("foo from impter: ", imptee.foo)
    imptee.show()

