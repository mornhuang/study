#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-22 10:49

"""


if __name__ == '__main__':
    var1 = map(lambda x: x**2, range(6))
    var2 = [x**2 for x in range(6)]
    print(list(var1))
    print(var2)

    seq = [1, 2, 3, 4, 5, 6]
    var3 = filter(lambda x: x % 2, seq)
    var4 = [x for x in seq if x % 2]
    print(list(var3))
    print(var4)

    var5 = [(x+1, y+1) for x in range(3) for y in range(5)]
    print(var5)
    pass