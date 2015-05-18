#!/usr/bin/env python
# -*- coding: utf-8 -*-
# Author     : Morn
# DateTime   : 2015/5/13 15:12

from django.conf.urls import patterns, url
from views import *

urlpatterns = patterns('',
    url(r'^hello/$', hello),
    url(r'^show/$', showRequest),
    url(r'^search-form/$', search_form),
    url(r'^search/$', search),
)
