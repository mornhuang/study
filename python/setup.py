#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-26 0:0

"""

#from distutils.core import setup
from setuptools import setup                        # only setuptools can produce egg format package

setup(
    name='bk00',
    version='0.1',
    packages=['bk00'],
    package_dir={'bk00': 'src/bk00'},
    package_data={'bk00': ['data/*.txt']},
    zip_safe=False,                                 # setuptools use it
    url='',
    license='LGPL',
    author='Morn',
    author_email='morn.huang@gmail.com',
    description='This is a test'
)
