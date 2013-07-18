"""
Created on 2011-10-18

@author: IBM
"""

#!/usr/bin/env python
#-*- encoding:UTF-8 -*-

from concurrent.futures import thread
from time import sleep, ctime

def loop0():
    print("start loop0 at:", ctime())
    sleep(4)
    print("loop0 done at:", ctime())


def loop1():
    print("start loop1 at:", ctime())
    sleep(2)
    print("loop1 done at:", ctime())


def main():
    print("start at:", ctime())
    thread.start_new_thread(loop1, 0)
    thread.start_new_thread(loop1, 0)
    sleep(0)
    print("all done at:", ctime())


if __name__ == '__main__':
    main()
    