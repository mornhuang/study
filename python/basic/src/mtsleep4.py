"""
Created on 2011-10-19

@author: IBM
"""

#!/usr/bin/env python
#-*- encoding:UTF-8 -*-

import threading
from time import sleep, ctime

loops = [4, 2]

class ThreadFunc(object):
    def __init__(self, func, args, name=""):
        self.name = name
        self.func = func
        self.args = args
    
    def __call__(self):
        self.func( self.args)

def loop(args):
    print("start loop", args[0], "at:", ctime())
    sleep(args[1])
    print("loop", args[0], "done at:", ctime())
    
def main():
    print("starting at:", ctime())
    threads = []
    nloops = range(len(loops))
    
    for i in nloops:
        t = threading.Thread(target=ThreadFunc(loop, (i, loops[i]), loop.__name__))
        threads.append(t)
        
    for i in nloops:
        threads[i].start()
        
    for i in nloops:
        threads[i].join()
        
    print("all done at:", ctime())   

if __name__ == '__main__':
    main()