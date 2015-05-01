#!/usr/bin/env python
#-*- coding:utf-8 -*-
#
# Django settings for pysite project.
#

import os


BASE_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__)))

LOGGING = {
    'version': 1,
    'disable_existing_loggers': False,
    'filters': {
        'require_debug_false': {
            '()': 'django.utils.log.RequireDebugFalse'
        }
    },
    'handlers': {
        'mail_admins': {
            'level': 'ERROR',
            'filters': ['require_debug_false'],
            'class': 'django.utils.log.AdminEmailHandler'
        }
    },
    'loggers': {
        'django.request': {
            'handlers': ['mail_admins'],
            'level': 'ERROR',
            'propagate': True,
        },
    }
}

ADMINS = (
    ('Morn Huang', 'morn.huang@gmail.com'),
)
MANAGERS = ADMINS

SITE_ID = 1
SECRET_KEY = '7$jn!@ukzcul-te403wl%$xo9gr+zepi28ekw_tkj(q4lhj6)&'
TIME_ZONE = 'Asia/Shanghai'
LANGUAGE_CODE = 'zh-cn'

ALLOWED_HOSTS = []
USE_I18N = True
USE_L10N = True
USE_TZ = True

ROOT_URLCONF = 'pysite.urls'
WSGI_APPLICATION = 'pysite.wsgi.application'
SESSION_SERIALIZER = 'django.contrib.sessions.serializers.JSONSerializer'

MEDIA_ROOT = os.path.join(BASE_DIR, 'media').replace('\\', '/')
MEDIA_URL = '/media/'

STATIC_ROOT = os.path.join(BASE_DIR, 'static').replace('\\', '/')
STATIC_URL = '/static/'
STATICFILES_DIRS = (
)

STATICFILES_FINDERS = (
    'django.contrib.staticfiles.finders.FileSystemFinder',
    'django.contrib.staticfiles.finders.AppDirectoriesFinder',
    'django.contrib.staticfiles.finders.DefaultStorageFinder',
)


MIDDLEWARE_CLASSES = (
    'django.middleware.common.CommonMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
    'django.middleware.clickjacking.XFrameOptionsMiddleware',
    'django.middleware.locale.LocaleMiddleware',
)

INSTALLED_APPS = (
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.sites',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    'django.contrib.admin',
    'south',
    'pysite.gallery',
    'pysite.books',
    'pysite.contact',
    'pysite',
)

TEMPLATE_LOADERS = (
    'django.template.loaders.filesystem.Loader',
    'django.template.loaders.app_directories.Loader',
    'django.template.loaders.eggs.Loader',
)

#TEMPLATE_CONTEXT_PROCESSORS = {
#    'django.contrib.auth.context_processors.auth',
#    'django.core.context_processors.i18n',
#    'django.core.context_processors.media',
#}

#TEMPLATE_DIRS = (
#    os.path.join(BASE_DIR, 'books/templates').replace('\\', '/'),
#    os.path.join(BASE_DIR, 'contact/templates').replace('\\', '/'),
#    os.path.join(BASE_DIR, 'templates').replace('\\', '/'),
#)

TEMPLATE_DEBUG = DEBUG = True

DATABASES = {
    #'default': {
    #    'ENGINE': 'django.db.backends.sqlite3',
    #    'NAME': os.path.join(BASE_DIR, 'db.sqlite3'),
    #    'USER': '',
    #    'PASSWORD': '',
    #    'HOST': '',
    #    'PORT': '',
    #}
    #'default': {
    #    'ENGINE': 'django.db.backends.mysql',
    #    'NAME': 'django',
    #    'USER': 'test',
    #    'PASSWORD': 'test',
    #    'HOST': '',
    #    'PORT': '',
    #}
    'default': {
        'ENGINE': 'django.db.backends.postgresql_psycopg2',
        'NAME': 'django',
        'USER': 'test',
        'PASSWORD': 'test',
        'HOST': '',
        'PORT': '',
    }
}
