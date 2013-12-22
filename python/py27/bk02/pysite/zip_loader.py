#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-22 14:58

"""

from django.conf import settings
from django.template import TemplateDoesNotExist
import zipfile


def load_template_source(template_name, template_dirs=None):
    template_zipfiles = getattr(settings, 'TEMPLATE_ZIP_FILES', [])

    for fname in template_zipfiles:
        try:
            z = zipfile.ZipFile(fname)
            source = z.read(template_name)
        except (IOError, KeyError):
            continue
        z.close()

        template_path = "%s:%s" % (fname, template_name)
        return source, template_path

    raise TemplateDoesNotExist(template_name)

# This loader is always usable, since zipfile is included with python
load_template_source.is_usable = True