#include <QApplication>
#include <QDialog>
#include <QLabel>

int main( int argc, char* argv[] )
{
    QApplication a(argc, argv);
    QDialog w;
    QLabel lab(&w);
    w.show();
    return a.exec();
}

