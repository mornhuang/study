#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-25 09:24

"""

from django.conf.urls import url, patterns
from django.views.generic import TemplateView, ListView

from pysite.gallery.models import Item

urlpatterns = patterns("",
    url(r'^$',
        TemplateView.as_view(
            template_name='index.html'
        ),
        kwargs={'item_list': lambda: Item.objects.all()},
        name='index'
    ),
    url(r'^items/$',
        ListView.as_view(
            queryset=Item.objects.all(),
            template_name='item_list.html'
        ),
        name='item_list'
    ),
    url(r'^items(?P<object_id>\d+)/$',
        ListView.as_view(
            queryset=Item.objects.all(),
            template_name='item_detail.html'
        ),
        name='item_detail'
    ),
    url(r'^photos(?P<object_id>\d+)/$',
        ListView.as_view(
            queryset=Item.objects.all(),
            template_name='photo_detail.html'
        ),
        name='photo_detail'
    ),
)