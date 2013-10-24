#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-22 22:57

"""

from django.conf.urls import *
from djweb.bk04.views import archive

urlpatterns = patterns('',
    url(r'^$', archive),
)

if __name__ == '__main__':
    pass