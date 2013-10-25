#!/usr/bin/env python
#-*- coding:UTF-8 -*-

"""
Date: 2013-10-18 23:00
exercise string's usage
"""

if __name__ == '__main__':
    str1 = 'abc中国人的在efg'
    str2 = r"\cc\aa\b\c\d\""
    print("str1[3] order ==>", ord(str1[3]))
    print("first order str1[3], then char back ==>", chr(ord(str1[3])))
    print("str1[3] order's hex value ==>", hex(ord(str1[3])))
    print("ascii str1 ==>", ascii(str1))
    print("show raw string  ==>", str2)
    print("String strip  ==>", str1.strip('ab'))
    print("Bin number 10 ==>", bin(10))
    print("string encoding utf-8 ==>", str1.encode('utf-8'))
    print("string encoding   gbk ==>", str1.encode('gbk'))
    enc1 = str1.encode('utf-8')
    print("decode enc1 ==>", enc1.decode('utf-8'))
    str3 = ("a", "b", "c")
    print(" z".join(str3))
    print("{0} {1} {2}".format('a', 'b', 'c'))