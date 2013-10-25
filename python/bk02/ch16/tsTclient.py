#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 17:24
tcp client
"""

from socket import *

HOST = 'localhost'
PORT = 21567
BUFFER_SIZE = 1024
ADDR = (HOST, PORT)

tcpCliSock = socket(AF_INET, SOCK_STREAM)

try:
    p = tcpCliSock.connect(ADDR)

    while True:
        data = input(">")                       # get input msg str
        if not data:
            break
        tcpCliSock.send(data.encode())          # send bytes msg
        data = tcpCliSock.recv(BUFFER_SIZE)
        if not data:
            break
        print(data.decode())

except Exception as e:
    print(e)

tcpCliSock.close()


if __name__ == '__main__':
    pass