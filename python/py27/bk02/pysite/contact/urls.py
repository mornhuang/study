#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-21 14:50

"""

from django.conf.urls import url, patterns
from pysite.contact import views

urlpatterns = patterns('',
    url(r'^contact/$', views.contact),
    url(r'^thanks/$', views.thank),
)