#!/usr/bin/env python
#-*- coding:UTF-8 -*-

#
# Created on 2011-10-5
# @author: IBM
#

import threading
from time import sleep, ctime


class ThreadFunc(object):
    def __init__(self, func, args, name=""):
        self.name = name
        self.func = func
        self.args = args
    
    def __call__(self):
        self.func(self.args)


def loop(args):
    print("start loop", args[0], "at:", ctime())
    sleep(args[1])
    print("loop", args[0], "done at:", ctime())


def main():
    loops = [4, 2]

    print("starting at:", ctime())
    threads = []
    n = range(len(loops))
    
    for i in n:
        t = threading.Thread(target=ThreadFunc(loop, (i, loops[i]), loop.__name__))
        threads.append(t)
        
    for i in n:
        threads[i].start()
        
    for i in n:
        threads[i].join()
        
    print("all done at:", ctime())   

if __name__ == '__main__':
    main()