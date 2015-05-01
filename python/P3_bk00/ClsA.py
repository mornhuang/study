#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-11-01 10:49
Test special attribute with single/double under line
"""

FlagB = 1


class A:
    def __init__(self):
        self.__testa = 'a'  # will convert to _A__testa
        self._testb = 'b'


class B(A):                 # Class B inherit A's attribute(_A__testa, _testb)
    pass


class _C:
    pass


class __D:
    pass


if __name__ == '__main__':
    clsa = A()
    # output 'a'
    print(clsa._A__testa)
    # output 'b'
    print(clsa._testb)

    clsb = B()
    # output 'a'
    print(clsb._A__testa)
    # output 'b'
    print(clsb._testb)