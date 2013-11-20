#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-11-10 21:55

"""


class D(object):
    def foo(self):
        print("class D")


class B(object):
    def foo(self):
        print("class B")
        #super(B, self).foo()
        super().foo()


class C(D):
    def foo(self):
        print("class C")
        super(C, self).foo()


class A(C, B):
    print("class A")
    pass


if __name__ == '__main__':
    f = A()
    f.foo()
    print('MRO:',[x.__name__ for x in A.__mro__])