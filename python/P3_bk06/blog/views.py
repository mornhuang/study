# Create your views here.

from django.template import loader, Context
from django.http import HttpResponse, Http404
from bk06.blog.models import BlogPost, Book, Author
import datetime


def archive(request):
    posts = BlogPost.objects.all()

    t = loader.get_template("archive.html")
    c = Context({'posts': posts})

    return HttpResponse(t.render(c))


def showbook(request):
    book = Book.objects.get(title="Moby dick")

    # foreign key
    #author = book.author
    #au_book = author.book_set.all()

    # manytomany
    authors = book.authors.all()
    author = authors[0]
    au_book = author.book_set.all()

    t = loader.get_template("book.html")
    c = Context({'book': book, 'author': author, 'au_book': au_book})

    return HttpResponse(t.render(c))


def hour(request, offset):
    try:
        offset = int(offset)
    except ValueError:
        raise Http404()
    dt = datetime.datetime.now() + datetime.timedelta(hours=offset)
    html = "<html><body>In %s hours(s), it will be %s</body></html>" % (offset, dt)
    return HttpResponse(html)