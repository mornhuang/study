#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-21 21:24

"""

import re
import datetime
from django import template
from pysite.books.models import Book

register = template.Library()


def cut(value, arg):
    return value.replace(arg, '')
register.filter('cut', cut)


@register.filter(name='lower')
def lower(value):
    return value.lower()


@register.tag(name='current_time')
def do_current_time(parser, token):
    try:
        tagname, format_string = token.split_contents()
    except ValueError:
        msg = '%r tag requires a single argument' % token.split_contents()[0]
        raise template.TemplateSyntaxError(msg)
    return CurrentTimeNode(format_string[1:-1])


class CurrentTimeNode(template.Node):
    def __init__(self, format_string):
        self.format_string = str(format_string)

    def render(self, context):
        now = datetime.datetime.now()
        return now.strftime(self.format_string)


@register.tag(name='current_time2')
def do_current_time2(parser, token):
    try:
        tagname, format_string = token.split_contents()
    except ValueError:
        msg = '%r tag requires a single argument' % token.split_contents()[0]
        raise template.TemplateSyntaxError(msg)
    return CurrentTimeNode2(format_string[1:-1])


class CurrentTimeNode2(template.Node):
    def __init__(self, format_string):
        self.format_string = str(format_string)

    def render(self, context):
        now = datetime.datetime.now()
        context['current_time'] = now.strftime(self.format_string)
        return ''


@register.tag(name='current_time3')
def do_current_time3(parser, token):
    try:
        tag_name, arg = token.contents.split(None, 1)
    except ValueError:
        msg = '%r tag requires arguments' % token.contents[0]
        raise template.TemplateSyntaxError(msg)

    m = re.search(r'(.*?) as (\w+)', arg)
    if m:
        fmt, var_name = m.groups()
    else:
        msg = '%r tag has invalid argument' % tag_name
        raise template.TemplateSyntaxError(msg)

    if not (fmt[0] == fmt[-1] and fmt[0] in ("'", '"')):
        msg = "%r tag's argument should be in quotes" % tag_name
        raise template.TemplateSyntaxError(msg)

    return CurrentTimeNode3(fmt[1:-1], var_name)


class CurrentTimeNode3(template.Node):
    def __init__(self, format_string, var_name):
        self.format_string = str(format_string)
        self.var_name = var_name

    def render(self, context):
        now = datetime.datetime.now()
        context[self.var_name] = now.strftime(self.format_string)
        return ''


@register.tag(name='upper')
def do_upper(parser, token):
    nodlist = parser.parse(('endupper',))
    parser.delete_first_token()
    return UpperNode(nodlist)


class UpperNode(template.Node):
    def __init__(self, nodelist):
        self.nodelist = nodelist

    def render(self, context):
        output = self.nodelist.render(context)
        return output.upper()


@register.simple_tag(name='current_time4')
def current_time4(token):
    try:
        return datetime.datetime.now().strftime(str(token))
    except UnicodeEncodeError:
        return ''


@register.inclusion_tag('book_snippet.html')
def books_for_author(author):
    books = Book.objects.filter(authors__id=author.id)
    return {'books': books}