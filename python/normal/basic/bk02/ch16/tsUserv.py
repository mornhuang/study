#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 17:53
udp server
"""

from socket import *
from time import ctime

HOST = ''
PORT = 21567
BUFFER_SIZE = 1024
ADDR = (HOST, PORT)

udpSerSock = socket(AF_INET, SOCK_DGRAM)
udpSerSock.bind(ADDR)

while True:
    print("waiting for message ...")
    data, addr = udpSerSock.recvfrom(BUFFER_SIZE)

    data = "[" + ctime() + "] " + data.decode()
    udpSerSock.sendto(data.encode(), addr)
    print("receive message from:", addr)

udpSerSock.close()

if __name__ == '__main__':
    pass