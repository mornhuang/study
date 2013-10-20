#!/usr/bin/env python
#-*- coding:UTF-8 -*-
# Copyright (c) 2008-11 Qtrac Ltd. All rights reserved.
# This program or module is free software: you can redistribute it and/or
# modify it under the terms of the GNU General Public License as published
# by the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version. It is provided for educational
# purposes and is distributed in the hope that it will be useful, but
# WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
# General Public License for more details.

"""
Module MyClass is used for demo class create
Usage: import basic.bk02.ch02.MyClass
Enjoy it!
"""


class MyClass():
    """My Very First Class"""

    version = 0.1

    def __init__(self, nm='Huang'):
        """construct"""
        self.name = nm
        print("create a class instance for ", self.name)

    def showName(self):
        """display instance attribute and class name"""
        print('your name is ', self.name)
        print('my name is ', self.__class__.__name__)

    def showVersion(self):
        """display class(static) attribute"""
        print(self.version)

    @staticmethod
    def addMe2Me(x):
        """apply + operation to argument"""
        return x+x

if __name__ == '__main__':
    mycls = MyClass('Mike')
    mycls.showName()
    mycls.showVersion()
    print(mycls.addMe2Me(3))

    MyClass.version = 22
    mycls2 = MyClass('John')
    mycls2.showVersion()

    print(MyClass.addMe2Me(4))
