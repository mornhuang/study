'''
Created on 2011-10-19

@author: IBM
'''

#!/usr/bin/env python
#-*- encoding:UTF-8 -*-

import threading
from time import sleep, ctime

loops = [4, 2]

def loop(args):
    print("start loop", args[0], "at:", ctime())
    sleep(args[1])
    print("loop", args[0], "done at:", ctime())
    
class MyThread(threading.Thread):
    def __init__(self, func, args, name=""):
        threading.Thread.__init__(self)
        self.name = name
        self.func = func
        self.args = args
    
    def run(self):
        self.func(self.args)    
        
def main():
    print("starting at:", ctime())
    threads = []
    nloops = range(len(loops))
    
    for i in nloops:
        t = MyThread(loop, (i, loops[i]), loop.__name__)
        threads.append(t)
        
    for i in nloops:
        threads[i].start()
        
    for i in nloops:
        threads[i].join()
        
    print("all done at:", ctime())   

if __name__ == '__main__':
    main()