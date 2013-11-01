#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-26 17:56

"""

import urllib2
import cookielib
import urllib

cookie = cookielib.CookieJar()
opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cookie))
response = opener.open('http://t.sohu.com/settings/bindMobile/registSendVerificationCode')
data = {'mobileNumber': '13558233012'}
r = opener.open('http://t.sohu.com/settings/bindMobile/registSendVerificationCode', urllib.urlencode(data))
print r.read()

if __name__ == '__main__':
    pass