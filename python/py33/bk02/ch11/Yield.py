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


def counter(start_at=0):
    count = start_at
    while True:
        val = (yield count)
        if val is not None:
            count = val
        else:
            count += 1

if __name__ == '__main__':
    s = simpleGen()
    print(next(s))
    print(next(s))

    for eachItem in simpleGen():
        print(eachItem)

    #for i in range(3):
    #    print(randint(0, 2))

    for item in randGen(['rock', 'paper', 'cc']):
        print(item)

    c = counter(5)
    print(next(c))
    print(next(c))
    print(next(c))
    c.send(9)
    print(next(c))