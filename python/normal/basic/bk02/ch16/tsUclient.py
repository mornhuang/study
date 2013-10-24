#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 18:06
udp client
"""

from socket import *

HOST = 'localhost'
PORT = 21567
BUFFER_SIZE = 1024
ADDR = (HOST, PORT)

udpCliSock = socket(AF_INET, SOCK_DGRAM)

while True:
    data = input(">")
    if not data:
        break
    udpCliSock.sendto(data.encode(), ADDR)

    data, addr = udpCliSock.recvfrom(BUFFER_SIZE)
    if not data:
        break
    print(data.decode())

if __name__ == '__main__':
    pass