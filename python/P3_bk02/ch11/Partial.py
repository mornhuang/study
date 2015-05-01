#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-23 11:28

"""

from time import time


def logged(when):
    def log(f, *args, **kwargs):
        print("""Called:
        function: {0}
        args: {1}
        kwargs: {2}
        """.format(f.__name__, args, kwargs))

    def pre_logged(f):
        def wrapper(*args, **kwargs):
            log(f, *args, **kwargs)
            return f(*args, **kwargs)
        return wrapper

    def post_logged(f):
        def wrapper(*args, **kwargs):
            now = time()
            try:
                return f(*args, **kwargs)
            finally:
                log(f, *args, **kwargs)
                print("time delta: {0}".format(time()-now))
        return wrapper

    try:
        return {"pre": pre_logged, "post": post_logged}[when]
    except KeyError as e:
        raise ValueError('Must be "pre" or "post"') from e


if __name__ == '__main__':
    from operator import add, mul
    from functools import partial

    add1 = partial(add, 1)
    mul2 = partial(mul, 2)

    print(add(1, 1))
    print(add1(1))

    print(mul(10, 2))
    print(mul2(10))

    baseTwo = partial(int, base=2)
    print(int('10010', 2))
    print(baseTwo('10010'))

    # Test Closure
    def foo(start_at=0):
        m = [start_at]

        def inc():
            n = 4
            m[0] += n
            return m[0]

        return inc

    count = foo(13)
    print(count())
    print(count())
    #print(m)
    #incr()

    @logged("pre")
    def printHello(n, t=2, a="kk"):
        for i in range(t):
            print("hello{0}_{1}".format(i, n), a)

    printHello(10, 3, a="must")
