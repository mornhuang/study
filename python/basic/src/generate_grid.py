"""
Created on 2011-10-5

@author: IBM
"""
#!/usr/bin/env python
#-*- encoding:utf-8 -*-

import random

def get_int(msg, minimum, default):
    while True:
        try:
            line = input(msg)
            if not line and default is not None:
                return default
            i = int(line)
            if i < minimum :
                print("must be >=", minimum)
            else:
                return i
        except ValueError as err:
            print(err)
            

                