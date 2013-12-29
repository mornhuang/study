#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-19 15:19

"""

from django.conf.urls import patterns, url
from django.views.generic import TemplateView
from django.views.generic.list import ListView
from pysite.books import views
from pysite.books.models import Publisher


urlpatterns = patterns('',
    url(r'^hello/$', views.hello),
    url(r'^hello_t/$', views.hello_tmpl),
    url(r'^time/$', views.current_date),
    url(r'^time/plus/(\d{1,2})/$', views.hours_ahead),
    url(r'^show/$', views.show_request),
    url(r'^show-tag/$', views.use_tag),

    url(r'^latest/$', views.latest_books),
    #url(r'^search-form/$', views.search_form),
    url(r'^search/$', views.search),

    url(r'^go/$',
        TemplateView.as_view(
            template_name='go.html'
        )
    ),
    url(r'^publisher/$',
        ListView.as_view(
            queryset=Publisher.objects.all(),
            template_name='publisher_list.html'
        )
    ),

    url(r'^image/$', views.my_image),
    url(r'^csv/$', views.unruly_passenger_csv),
    url(r'^pdf/$', views.hello_pdf),
)