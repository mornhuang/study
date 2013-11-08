#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-26 23:21
Demonstrate value change in different namespace
@see A/B module
"""

import bk00

# import namespace bk00's Flag into local namespace.
# now local space has a Flag object, it's initial value equal bk00.Flag
from bk00 import Flag

if __name__ == '__main__':
    # output 3
    print("bk00's flag:", bk00.Flag)
    # output 3
    print(Flag)

# change local Flag's value
Flag = 'A'

if __name__ == '__main__':
    # output 3
    print("bk00's flag:", bk00.Flag)
    # output 'A'
    print(Flag)