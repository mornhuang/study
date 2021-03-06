#!/usr/bin/env python
#-*- coding:utf-8 -*-

from django.conf.urls import patterns, include, url
from django.contrib import admin

admin.autodiscover()

urlpatterns = patterns('',
    url(r'^admin/doc/', include('django.contrib.admindocs.urls')),
    url(r'^admin/', include(admin.site.urls)),
    url(r'^books/', include('pysite.books.urls')),
    url(r'^contact/', include('pysite.contact.urls')),
    url(r'^gallery/', include('pysite.gallery.urls')),
)
