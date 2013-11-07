#include <QtGui>

int main(int argc, char* argv[])
{
    QApplication a(argc, argv);
    QTextCodec::setCodecForTr(QTextCodec::codecForName("UTF-8"));

    QWidget *widget = new QWidget(0, Qt::Dialog);
    widget->setWindowTitle(QObject::tr("我是widget"));

    QLabel *label = new QLabel(0, Qt::SplashScreen);
    label->setWindowTitle(QObject::tr("我是Label"));
    label->setText(QObject::tr("我是个窗口"));
    label->resize(180, 20);

    QLabel *label2 = new QLabel(widget);
    label2->setText(QObject::tr("我不是独立的"));
    label2->resize(250, 20);

    label->show();
    widget->show();

    qDebug(QObject::tr("输出测试数据"));
    qDebug() << "x: " << widget->x() << "y: " << widget->y();

    int ret = a.exec();
    delete widget;
    delete label;
    return ret;
}
