#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-23 16:04

"""

from django.contrib import admin
from pysite.gallery.models import Item, Photo


class PhotoInline(admin.StackedInline):
    model = Photo


class ItemAdmin(admin.ModelAdmin):
    inlines = [PhotoInline]


admin.site.register(Item, ItemAdmin)
admin.site.register(Photo)