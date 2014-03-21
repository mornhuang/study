#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Django settings for pysite project.

For more information on this file, see
https://docs.djangoproject.com/en/1.6/topics/settings/

For the full list of settings and their values, see
https://docs.djangoproject.com/en/1.6/ref/settings/
"""

import os
BASE_DIR = os.path.dirname(os.path.dirname(__file__))
SITE_NAME = os.path.basename(os.path.dirname(__file__))

ADMINS = (
    ('Morn Huang', 'morn.huang@gmail.com'),
)
MANAGERS = ADMINS

SITE_ID = 1
SECRET_KEY = '6p@9oy(cl%&ycdc!a2&chitc3qik$$64(@qwks@s*21r=pt15l'
TIME_ZONE = 'Asia/Shanghai'
LANGUAGE_CODE = 'zh-cn'
USE_I18N = True
USE_L10N = True
USE_TZ = True

ROOT_URLCONF = '%s.urls' % SITE_NAME
WSGI_APPLICATION = '%s.wsgi.application' % SITE_NAME
SESSION_SERIALIZER = 'django.contrib.sessions.serializers.JSONSerializer'

####################################################################
###               Static/Media Content
###################################################################
STATICFILES_FINDERS = (
    'django.contrib.staticfiles.finders.FileSystemFinder',
    'django.contrib.staticfiles.finders.AppDirectoriesFinder',
    'django.contrib.staticfiles.finders.DefaultStorageFinder',
)

MEDIA_URL = '/media/'
STATIC_URL = '/static/'

STATICFILES_DIRS = (
    os.path.join(BASE_DIR, 'static').replace('\\', '/'),
)

###################################################################
##                  Template Content
###################################################################
TEMPLATE_LOADERS = (
    # 'app_namespace.Loader',   # https://github.com/Fantomas42/django-app-namespace-template-loader
    'django.template.loaders.filesystem.Loader',
    'django.template.loaders.app_directories.Loader',
    'django.template.loaders.eggs.Loader',
)

TEMPLATE_CONTEXT_PROCESSORS = {
    'django.contrib.auth.context_processors.auth',
    'django.core.context_processors.debug',
    'django.core.context_processors.i18n',
    'django.core.context_processors.request',
    'django.core.context_processors.media',
    'django.core.context_processors.static',
    'django.core.context_processors.tz',
    'django.contrib.messages.context_processors.messages',
}

TEMPLATE_DIRS = (
    os.path.join(BASE_DIR, 'templates').replace('\\', '/'),
)

#################################################################
###             Application
################################################################
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
    'grappelli',
    'filebrowser',
    'django.contrib.admin',
    'django.contrib.comments',
    'south',
    'tagging',
    'mptt',
    'tinymce',
    # 'zinnia_bootstrap',
    'zinnia',
)

#################################################################
###             Debug Setting
################################################################
import socket
HOST_NAME = socket.gethostname()

# Product environment
if HOST_NAME.endswith('.hray.info'):
    TEMPLATE_DEBUG = DEBUG = False

    if HOST_NAME == 'rsc.hray.info':
        SERVER_EMAIL = 'admin@hray.info'
        ALLOWED_HOSTS = ['.hray.info', '192.168.1.10']
    elif HOST_NAME == 'vsc.hray.info':
        ALLOWED_HOSTS = ['.hray.info', '192.168.1.20', '192.168.111.20']

    MEDIA_ROOT = '/srv/www/blog/media'
    STATIC_ROOT = '/srv/www/blog/static'

    DATABASES = {
        'default': {
            'ENGINE': 'django.db.backends.postgresql_psycopg2',
            'NAME': 'website',
            'USER': 'hraymgr',
            'PASSWORD': '1hray2mgr',
            'HOST': '127.0.0.1',
            'PORT': '',
        }
    }

    LOGGING = {
        'version': 1,
        'disable_existing_loggers': False,
        'formatters': {
            'standard': {
                'format': '%(asctime)s [%(levelname)s]- %(message)s'
            },
        },
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
            },
            'file_log': {
                'level': 'ERROR',
                'class': 'logging.handlers.RotatingFileHandler',
                'filename': '/var/log/site/blog.log',
                'formatter': 'standard',
            }
        },
        'loggers': {
            'django': {
                'handlers': ['file_log'],
                'level': 'ERROR',
                'propagate': False,
            },
            'django.request': {
                'handlers': ['mail_admins'],
                'level': 'ERROR',
                'propagate': True,
            },
        }
    }

# Development environment
else:
    TEMPLATE_DEBUG = DEBUG = True

    MEDIA_ROOT = "G:/Cache/blog/media"
    STATIC_ROOT = "G:/Cache/blog/static"

    DATABASES = {
        'default': {
            'ENGINE': 'django.db.backends.postgresql_psycopg2',
            'NAME': 'django',
            'USER': 'test',
            'PASSWORD': 'test',
            'HOST': '127.0.0.1',
            'PORT': '',
        }
    }

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

    # INSTALLED_APPS += (
    #     'debug_toolbar',
    # )

    # DEBUG_TOOLBAR_PATCH_SETTINGS = False

    # MIDDLEWARE_CLASSES += (
    #     'debug_toolbar.middleware.DebugToolbarMiddleware',
    # )
    #
    # INTERNAL_IPS = ('127.0.0.1',)

#################################################################
###             FileBrowser
################################################################
FILEBROWSER_URL_FILEBROWSER_MEDIA = MEDIA_URL + 'filebrowser/'
FILEBROWSER_PATH_FILEBROWSER_MEDIA = MEDIA_ROOT + 'filebrowser/'
FILEBROWSER_DIRECTORY = 'uploads/'