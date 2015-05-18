from django.http import HttpResponse
from django.shortcuts import render_to_response
from models import Book


def hello(request):
    return HttpResponse("hello")


def showRequest(request):
    # context = ''
    # for key in request.META:
    #     context += "%s: %s<br>" % (key, request.META[key])
    # return HttpResponse(context)

    # vals = request.META.items()
    # vals.sort()
    # html = []
    # for k, v in vals:
    #     html.append("<tr><td>%s</td><td>%s</td></tr>" % (k, v))
    # return HttpResponse('<table style="word-wrap: break-word">%s</table>' % '\n'.join(html))

    vals = request.META.items()
    vals.sort()
    return render_to_response("show.html", {'vals': vals})


def search_form(request):
    return render_to_response('search_form.html')


def search(request):
    # if 'q' in request.GET:
    #     message = 'You searched for: %r' % request.GET['q']
    # else:
    #     message = 'You submit an empty form.'
    #
    # return HttpResponse(message)

    if 'q' in request.GET and request.GET['q']:
        q = request.GET['q']
        books = Book.objects.filter(title__icontains=q)
        return render_to_response('search_result.html', {'books': books, 'query': q})
    else:
        # return HttpResponse('Please submit a search term.')
        return render_to_response('search_form.html', {'error': True})