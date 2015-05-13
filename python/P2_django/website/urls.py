#!/usr/bin/env python
# -*- coding:utf-8 -*-

from django.conf import settings
from django.conf.urls import patterns, include, url, static
from django.contrib import admin
# from filebrowser.sites import site
import books

admin.autodiscover()

urlpatterns = patterns('',
    # url(r'^admin/filebrowser/', include(site.urls)),
    # url(r'^grappelli/', include('grappelli.urls')),
    url(r'^admin/', include(admin.site.urls)),
    # url(r'^comments/', include('django.contrib.comments.urls')),
    # url(r'^', include('zinnia.urls')),
    # url(r'^tinymce/', include('tinymce.urls')),
    url(r'^book/$', include(books.urls)),
)

if settings.DEBUG:
    urlpatterns += static.static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
    urlpatterns += static.static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)
