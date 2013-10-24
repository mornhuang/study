#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 10:13
Test With sentence
"""

import contextlib


if __name__ == '__main__':
    try:
        with open("test.text", "r") as f:
            for line in f:
                print(line)
    except:
        import sys
        exec_tuple = sys.exc_info()

    for item in exec_tuple:
        print(item)