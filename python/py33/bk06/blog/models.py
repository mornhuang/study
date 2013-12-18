#!usr/bin/env python
#-*- coding:utf-8 -*-

from django.db import models
from django.contrib import admin


class BlogPost(models.Model):
    title = models.CharField(max_length=150)
    body = models.TextField()
    timestamp = models.DateTimeField()

    class Meta:
        ordering = ('-timestamp',)

    def __str__(self):
        return self.title


class Author(models.Model):
    name = models.CharField(max_length=100)

    def __str__(self):
        return self.name


class Book(models.Model):
    title = models.CharField(max_length=100)
    #author = models.ForeignKey(Author)
    authors = models.ManyToManyField(Author)

    def __str__(self):
        return self.title


class BlogPostAdmin(admin.ModelAdmin):
    list_display = ('title', 'timestamp')


class BookAdmin(admin.ModelAdmin):
    list_display = ('title', )


class AuthorAdmin(admin.ModelAdmin):
    list_display = ('name', )


admin.site.register(BlogPost, BlogPostAdmin)
admin.site.register(Author, AuthorAdmin)
admin.site.register(Book, BookAdmin)