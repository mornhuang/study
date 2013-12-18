#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-22 22:57

"""

from django.conf.urls import *
from bk06.blog.views import archive, showbook, hour


urlpatterns = patterns('',
    url(r'^archive/$', archive),
    url(r'^book/$', showbook),
    url(r'^hour/(\d{1,2})/$', hour),
)
