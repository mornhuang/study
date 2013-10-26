#!/usr/bin/env python
#-*- coding:UTF-8 -*-

"""
Created on 2011-10-5
@author: IBM
"""

import sys

if __name__ == '__main__':
    print("Type integers, each followed by Enter; or just Enter to finish")

    total = 0
    count = 0

    while True:
        line = input("integer:")
        if line:
            try:
                number = int(line)
            except ValueError as err:
                print(err)
                continue
            total += number
            count += 1
        else:
            break

    if count:
        print("总共=", count, "total=", total, "mean=", total / count)
        sys.exit(0)
