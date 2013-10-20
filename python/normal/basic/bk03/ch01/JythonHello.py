#!usr/bin/env python
#-*- coding:utf-8 -*-
# 
# Date: 2013-10-21 02:18
# 

import java
from java import awt


def exit(e):
    java.lang.System.exit(0)

frame = awt.Frame('AWT Example', visible=1)
button = awt.Button('Close Me!', actionPerformed=exit)
frame.add(button, 'Center')
frame.pack()

if __name__ == '__main__':
    print("hello")
    pass