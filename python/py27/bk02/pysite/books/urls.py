#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-19 15:19

"""

from django.conf.urls import patterns, url
from pysite.books import views


urlpatterns = patterns('',
    url(r'^latest/$', views.latest_books),
    url(r'^hello/$', views.hello),
    url(r'^hello_t/$', views.hello_tmpl),
    url(r'^time/$', views.current_date),
    url(r'^time/plus/(\d{1,2})/$', views.hours_ahead),
    url(r'^show/$', views.show_request),
    #url(r'^search-form/$', views.search_form),
    url(r'^search/$', views.search),
    url(r'^show-tag/$', views.use_tag),
)