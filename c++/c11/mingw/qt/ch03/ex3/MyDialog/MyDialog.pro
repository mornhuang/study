#-------------------------------------------------
#
# Project created by QtCreator 2013-11-08T11:42:54
#
#-------------------------------------------------

QT       += core gui

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = MyDialog
TEMPLATE = app


SOURCES += main.cpp\
    mydialog.cpp \
    mywidget.cpp \
    mystddialog.cpp

HEADERS  += mydialog.h \
    mywidget.h \
    mystddialog.h

FORMS    += mydialog.ui \
    mywidget.ui \
    mystddialog.ui

TRANSLATIONS += zh_CN.ts \
    en_US.ts
