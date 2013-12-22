#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-21 14:49

"""

from django.core.mail import send_mail
from django.http import HttpResponseRedirect, HttpResponse
from django.shortcuts import render_to_response
from django.template import RequestContext

from pysite.contact.forms import ContactForm


def contact(request):
    if request.method == 'POST':
        form = ContactForm(request.POST)
        if form.is_valid():
            cd = form.cleaned_data
            send_mail(
                cd['subject'],
                cd['message'],
                cd.get('email', 'noreply@anonymous.com'),
                ['morn.huang@gmail.com'],
                True
            )
            return HttpResponseRedirect('/contact/thanks')
    else:
        form = ContactForm(
            initial={'subject': 'i love your site'}
        )

    return render_to_response('contact_form.html',
                              context_instance=RequestContext(request, {'form': form}))


def thank(request):
    return HttpResponse("Thanks")