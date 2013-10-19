#!/usr/bin/env python
#-*- coding:UTF-8 -*-

#
# Created on 2011-10-5
# @author: IBM
#

import threading
from time import sleep, ctime


def loop(n, sec):
    print("start loop", n, "at:", ctime())
    sleep(sec)
    print("loop", n, "done at:", ctime())


def main():
    loops = [4, 2]

    print("starting at:", ctime())
    threads = []
    n = range(len(loops))
    
    for i in n:
        t = threading.Thread(target=loop, args=[i, loops[i]])
        threads.append(t)
        
    for i in n:
        threads[i].start()
        
    for i in n:
        threads[i].join()
        
    print("all done at:", ctime())


if __name__ == '__main__':
    main()