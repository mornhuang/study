#!/usr/bin/env python
#-*- coding:UTF-8 -*-

"""
Created on 2011-10-5
@author: IBM
Demonstrate thread, thread is unsupport in py3
"""

import sys

if int(sys.version[:1]) < 3:
    import thread
    from time import sleep, ctime

    def loop0(arg):
        print("start loop0 at:", ctime())
        sleep(1)
        print("loop0 done at:", ctime())

    def loop_out():
        print("loop====>")
        print(__name__)
        print(sys.path)

    def loop1(arg):
        print("start loop1 at:", ctime())
        sleep(2)
        print("loop1 done at:", ctime())

    def main():
        print("start at:", ctime())
        thread.start_new_thread(loop0, (1,))
        thread.start_new_thread(loop1, (2,))
        sleep(0)
        print("all done at:", ctime())

if __name__ == '__main__':
    if int(sys.version[:1]) < 3:
        main()
    else:
        print("Unsupport Python3")
