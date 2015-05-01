#!/usr/bin/env python
#-*- coding:utf-8 -*-

from django.conf import settings
from django.conf.urls import patterns, include, url, static
from django.contrib import admin
from zinnia.views.channels import EntryChannel

admin.autodiscover()

urlpatterns = patterns('',
    url(r'^admin/doc/', include('django.contrib.admindocs.urls')),
    url(r'^admin/', include(admin.site.urls)),
    url(r'^comments/', include('django.contrib.comments.urls')),
    url(r'^weblog/$',
        EntryChannel.as_view(
            query='category:blog OR category:django'
        )
    ),
    url(r'^weblog/', include('zinnia.urls')),
)

if settings.DEBUG:
    urlpatterns += static.static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
    urlpatterns += static.static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)
