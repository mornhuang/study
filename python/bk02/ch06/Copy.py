#!usr/bin/env python
#-*- coding:utf-8 -*-

""" 
Date: 2013-10-21 20:36
Demo difference between copy and deepcopy
"""

if __name__ == '__main__':
    person = ['name', ['savings', 100]]
    hubby = person[:]
    wife = list(person)
    print(person, hubby, wife)
    ids = [id(x) for x in (person, hubby, wife)]
    print(ids)

    hubby[0] = 'joe'
    wife[0] = 'jane'
    print(person, hubby, wife)
    ids = [id(x) for x in (person, hubby, wife)]
    print(ids)

    hubby[1][1] = 50
    print(person, hubby, wife)
    ids = [id(x) for x in (person, hubby, wife)]
    print(ids)

    import copy
    wife = copy.deepcopy(hubby)
    hubby[1][1] = 200
    print(person, hubby, wife)
    ids = [id(x) for x in (person, hubby, wife)]
    print(ids)
