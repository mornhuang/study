#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-26 0:0

Setuptools' setup config file.
Use to create python egg.
"""

#from distutils.core import setup
from setuptools import setup                        # only setuptools can produce egg format package

setup(
    name='appset',
    version='0.1',
    packages=['appset'],
    package_dir={'appset': ['abstract', 'appmain', 'modules', 'utils']},
    package_data={'appset': ['appset.zh_CN.qm']},
    zip_safe=False,                                 # setuptools use it
    url='',
    license='LGPL',
    author='Morn',
    author_email='morn.huang@gmail.com',
    description='Application tool set'
)
