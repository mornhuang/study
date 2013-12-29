#!/usr/bin/env python
#-*- coding:utf-8 -*-

"""
Date: 2013-12-28 15:34

"""

import sys

PY2 = sys.version_info[0] == 2
PY3 = sys.version_info[0] == 3


class _LazyDescr(object):
    test = 'test'
    aa = 'aa'

    def __init__(self, name):
        self.name = name

    def __get__(self, obj, tp):
        result = self._resolve()
        setattr(obj, self.name, result)
        # This is a bit ugly, but it avoids running this again.
        delattr(tp, self.name)
        return result


class MovedModule(_LazyDescr):
    test = 'test2'
    bb = 'bb'

    def __init__(self, name, old, new=None):
        super(MovedModule, self).__init__(name)
        if PY3:
            if new is None:
                new = name
            self.mod = new
        else:
            self.mod = old

    def _resolve(self):
        return _import_module(self.mod)


def _import_module(name):
    """Import module, returning the module after the last dot."""
    __import__(name)
    return sys.modules[name]


class Proxy(object):
    pp = MovedModule('builtins', '__builtin__')


if __name__ == '__main__':
    a = MovedModule("builtins", "__builtin__")
    b = [a]
    b[0].mod
    b[0].test
    MovedModule.test
    a.mod
    x = Proxy()
    x.pp