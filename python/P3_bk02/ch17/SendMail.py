#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 22:47
Send Email's Code, that is very cool.
"""

if __name__ == '__main__':
    from smtplib import SMTP

    origHdrs = ['From: huangmeng@189.cn', 'To: morn.huang@gmail.com', 'Subject: test msg']
    origBody = ['xxx', 'yyy', 'zzz']
    origMsg = '\r\n\r\n'.join(['\r\n'.join(origHdrs), '\r\n'.join(origBody)])

    sendSvr = SMTP('smtp.189.cn', 25)     # 25 is smtp default port
    sendSvr.login('huangmeng@189.cn', 'password')
    errs = sendSvr.sendmail('huangmeng@189.cn',
                            ('morn.huang@gmail.com',), origMsg)  # Toaddr is a list, split by ','
    sendSvr.quit()

    if not errs:
        print(errs)


