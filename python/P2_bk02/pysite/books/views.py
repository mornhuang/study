#!/usr/bin/env python
#-*- coding:utf-8 -*-

import os
import datetime
import csv

from django.conf import settings
from django.core.mail import send_mail
from django.http import HttpResponse, Http404, HttpResponseRedirect
from django.shortcuts import render_to_response

from reportlab.pdfgen import canvas

from pysite.books.models import Book
from pysite.contact.forms import ContactForm


def hello(request):
    return HttpResponse("Hello World!")


def hello_tmpl(request):
    return render_to_response('hello.html', {'list': range(4)})


def latest_books(request):
    book_list = Book.objects.order_by('-publication_date')[:10]
    return render_to_response('latest_books.html', {'book_list': book_list})


def current_date(request):
    now = datetime.datetime.now()
    html = "<html><body>It is now %s. </body></html>" % now
    return HttpResponse(html)


def hours_ahead(request, offset):
    try:
        offset = int(offset)
    except ValueError:
        raise Http404()
    dt = datetime.datetime.now() + datetime.timedelta(hours=offset)

    #html = "<html><body>In %s hours, it will be %s.</body></html>" % (offset, dt)
    #return HttpResponse(html)

    return render_to_response('hours_ahead.html', {'hour_offset': offset, 'next_time': dt})


def show_request(request):
    values = request.META.items()
    values.sort()
    return render_to_response('show.html', {'values': values})


#def search_form(request):
#    return render_to_response('search_form.html')


def search(request):
    #if 'q' in request.GET:
    #    message = 'you are search for %r' % request.GET['q']
    #else:
    #    message = 'you submitted an empty form'
    #return HttpResponse(message)

    #if 'q' in request.GET and request.GET['q']:
    #    q = request.GET['q']
    #    books = Book.objects.filter(title__icontains=q)
    #    return render_to_response('search_result.html', {'books': books, 'query': q})
    #else:
    #    return render_to_response('search_form.html', {'error': True})

    error = False
    if 'q' in request.GET:
        q = request.GET['q']
        if not q:
            error = True
        else:
            q = request.GET['q']
            books = Book.objects.filter(title__icontains=q)
            return render_to_response('search_result.html', {'books': books, 'query': q})
    return render_to_response('search_form.html', {'error': error})


def use_tag(request):
    book = Book.objects.all()[0]
    author = book.authors.all()[0]
    return render_to_response('show_tag.html', {'author': author})


def my_image(request):
    image_data = open(os.path.join(settings.STATIC_ROOT, 'Mammooth.png'), 'rb')
    return HttpResponse(image_data, mimetype='image/png')


UNRULY_PASSENGERS = [100, 123, 333, 222, 45, 666]


def unruly_passenger_csv(request):
    response = HttpResponse(mimetype='text/csv')
    response['Content-Disposition'] = 'attachment; filename=unruly.csv'

    writer = csv.writer(response)
    writer.writerow(['Year', 'Unruly Airline Passengers'])
    for year, num in zip(range(1995, 2001), UNRULY_PASSENGERS):
        writer.writerow([year, num])

    return response


def hello_pdf(request):
    response = HttpResponse(mimetype='application/pdf')
    response['Content-Disposition'] = 'attachment; filename=hello.pdf'

    p = canvas.Canvas(response)

    p.drawString(100, 100, 'Hello world')
    p.showPage()
    p.save()

    return response