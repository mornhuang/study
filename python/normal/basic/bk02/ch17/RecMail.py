#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 23:21
receive your email from here
"""

if __name__ == '__main__':
    from poplib import POP3

    recvSvr = POP3('pop.189.cn', 110)
    recvSvr.user('huangmeng@189.cn')
    recvSvr.pass_('mail5198')
    rsp, msg, siz = recvSvr.retr(recvSvr.stat()[0])

    for line in msg:
        print(line.decode('gb2312'))
