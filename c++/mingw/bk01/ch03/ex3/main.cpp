#include "mydialog.h"
#include <QApplication>
#include "mywidget.h"
#include <QTextCodec>
#include <QTranslator>
#include <QLocale>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);

    QTextCodec::setCodecForTr(QTextCodec::codecForName("utf-8"));

    QTranslator translator;
    translator.load(QLocale::system(), "my");
    a.installTranslator(&translator);

    MyWidget w;
    w.show();

    return a.exec();
}
