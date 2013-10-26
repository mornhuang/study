#!/usr/bin/env python
#-*- coding:UTF-8 -*-

"""
Created on 2011-10-5
@author: IBM
"""

import threading
from time import sleep, ctime


def loop(args):
    print("start loop", args[0], "at:", ctime())
    sleep(args[1])
    print("loop", args[0], "done at:", ctime())


class MyThread(threading.Thread):
    def __init__(self, func, args, name=""):
        #threading.Thread.__init__(self)
        #super().__init__(name=name)
        super().__init__()
        self.name = name
        self.func = func
        self.args = args

    def run(self):
        self.func(self.args)


def main():
    loops = [4, 2]

    print("starting at:", ctime())
    threads = []
    n = range(len(loops))

    for i in n:
        t = MyThread(loop, (i, loops[i]), loop.__name__)
        threads.append(t)

    for i in n:
        threads[i].start()

    for i in n:
        threads[i].join()

    print("all done at:", ctime())


if __name__ == '__main__':
    main()