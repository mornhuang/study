#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-22 11:48

"""

from random import randint


def simpleGen():
    yield 1
    yield '2 --> punch'


def randGen(alist):
    while len(alist) > 0:
        yield alist.pop(randint(0, len(alist)-1))


if __name__ == '__main__':
    #while True:
    #    try:
    #        print(iter(simpleGen()).next())
    #    except StopIteration:
    #        break

    for eachItem in simpleGen():
        print(eachItem)

    #for i in range(3):
    #    print(randint(0, 2))

    for item in randGen(['rock', 'paper', 'cc']):
        print(item)
