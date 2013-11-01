#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 13:15

"""

if __name__ == '__main__':
    def foo():
        print("call foo..")
        aString = "test"
        anInt = 10
        print("foo's globals: ", globals().keys())
        print("foo's locals: ", locals().keys())

    print("__main__'s globals: ", globals().keys())
    print("__main__'s locals: ", locals().keys())
    foo()