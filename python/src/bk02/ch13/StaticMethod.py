#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 14:46
example for StaticMethod
"""


class StaticMethodTest():
    def foo():
        print("call static method foo()")

    foo = staticmethod(foo)


class ClassMethodTest():
    def foo(cls):
        print("call class method foo()")
        print("foo() is part of class: ", cls.__name__)

    foo = classmethod(foo)


class StaticMethodTest1():
    @staticmethod
    def foo1():
        print("call static method foo1()")


class ClassMethodTest1():
    @classmethod
    def foo1(cls):
        print("call class method foo1()")
        print("foo1() is part of class: ", cls.__name__)

    def car(self):
        print("call class method car()")


if __name__ == '__main__':
    tsm = StaticMethodTest()
    StaticMethodTest.foo()
    tsm.foo()

    tcs = ClassMethodTest()
    ClassMethodTest.foo()
    tcs.foo()

    tsm1 = StaticMethodTest1()
    StaticMethodTest1.foo1()
    tsm1.foo1()

    tcs1 = ClassMethodTest1()
    ClassMethodTest1.foo1()
    tcs1.foo1()
    #ClassMethodTest1.car()
    tcs1.car()