#include <QtGui>   
#include <QCoreApplication>   
#include <QTranslator>   
#include "mycalendar.h"   
   
int main(int argc, char *argv[])   
{   
    QApplication app(argc, argv);   
    QTranslator translator;   
      
    translator.load(QDir::currentPath() +"/i18_zh_CN");   
    app.installTranslator(&translator);   
    translator.load(QCoreApplication::applicationDirPath ()+"/i18_zh_CN.qm");   
    app.installTranslator(&translator);   
    Mycalendar window;   
    //window.resize(640, 256);   
    window.show();   
    return app.exec();   
}