#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 17:07
demonstrate a tcp server how to work
"""

from socket import *
from time import ctime

HOST = ''
PORT = 21567
BUFFER_SIZE = 1024
ADDR = (HOST, PORT)

tcpSerSock = socket(AF_INET, SOCK_STREAM)
tcpSerSock.bind(ADDR)
tcpSerSock.listen(1)    # accept max 5 connections

while True:
    print('waiting for connection ...')
    tcpCliSock, addr = tcpSerSock.accept()
    print('... connect from: ', addr)

    try:
        while True:
            data = tcpCliSock.recv(BUFFER_SIZE)             # receive msg bytes
            if not data:
                break
            data = "[" + ctime() + "] " + data.decode()     # send msg bytes
            tcpCliSock.send(data.encode())

        # don't use this method. if remote client is forced to close, it will cause an exception
        #tcpCliSock.close()

    except:
        tcpCliSock.shutdown()

tcpSerSock.close()

if __name__ == '__main__':
    pass