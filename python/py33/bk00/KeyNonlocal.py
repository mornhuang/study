#!usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-11-01 10:49
study keyword nonlocal usage

>>> f()()
Traceback (most recent call last):
...
UnboundLocalError: local variable 'x' referenced before assignment
>>> a()()
3
"""


def f():
    x = 1

    def g():
        x += 2
        return x
    return g


def a():
    x = 1

    def b():
        nonlocal x
        x += 2
        return x
    return b

if __name__ == '__main__':
    import doctest
    doctest.testmod()