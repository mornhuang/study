TEMPLATE = app
TARGET = cqt
QT += core \
    gui
HEADERS += src/gotocelldialog.h \
    src/analogclock.h
SOURCES += src/gotocelldialog.cpp \
    src/main.cpp \
    src/analogclock.cpp
FORMS += forms/gotocelldialog.ui \
    forms/analogclock.ui
RESOURCES += 
UI_DIR += forms
