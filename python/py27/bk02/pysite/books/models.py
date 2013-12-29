#!/usr/bin/env python
#-*- coding:utf-8 -*-

from django.db import models, connection


class Publisher(models.Model):
    name = models.CharField(max_length=30)
    address = models.CharField(max_length=50)
    city = models.CharField(max_length=60)
    state_province = models.CharField(max_length=30)
    country = models.CharField(max_length=50)
    website = models.URLField()

    def __unicode__(self):
        return self.name

    class Meta():
        ordering = ['name']


class AuthorManager(models.Manager):
    def first_names(self, last_name):
        cursor = connection.cursor()
        cursor.execute("""
            select distinct first_name
            from book_author
            where last_name = %s""", [last_name])
        return [row[0] for row in cursor.fetchone()]


class Author(models.Model):
    first_name = models.CharField(max_length=30)
    last_name = models.CharField(max_length=40)
    email = models.EmailField(blank=True, verbose_name='e-mail')
    objects = AuthorManager()

    def __unicode__(self):
        return u'%s %s' % (self.first_name, self.last_name)


class BookManager(models.Manager):
    def title_count(self, keyword):
        return self.filter(title__icontains=keyword).count()


class DahlBookManager(models.Manager):
    def get_query_set(self):
        return super(DahlBookManager, self).get_query_set().filter(author='Roald Dahl')


class Book(models.Model):
    title = models.CharField(max_length=100)
    authors = models.ManyToManyField(Author)
    publisher = models.ForeignKey(Publisher)
    publication_date = models.DateField(null=True, blank=True)
    objects = BookManager()     # default manager
    dahl_objects = DahlBookManager()

    def __unicode__(self):
        return self.title

    class Meta:
        ordering = ['publication_date', 'title']


