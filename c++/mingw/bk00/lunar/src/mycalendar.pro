TEMPLATE = app 
TARGET +=  
DEPENDPATH += . 
INCLUDEPATH += . 
QT           += sql 
 
# Input 
HEADERS += mycalendar.h TCalendar.h  
FORMS += calendar.ui 
SOURCES += main.cpp mycalendar.cpp TCalendar.cpp 
RESOURCES += mycalendar.qrc 
TRANSLATIONS += translate/i18_zh_CN.ts