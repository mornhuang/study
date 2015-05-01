#!usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-01 11:17

"""

BB_Flag = "Module_B"


def showFlag():
    print("BB_Flag", BB_Flag)


if __name__ == "__main__":
    import doctest

    doctest.testmod()
