#include "mydialog.h"
#include <QApplication>
#include "mywidget.h"
#include <QTextCodec>
#include <QTranslator>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    QTextCodec::setCodecForTr(QTextCodec::codecForName("utf-8"));
    QTranslator translator(a);
    translator.load("")

    MyWidget w;
    w.show();

    return a.exec();
}
