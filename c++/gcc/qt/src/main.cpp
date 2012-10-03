#include <QtGui>
#include <QApplication>

#include "analogclock.h"
#include "ui_gotocelldialog.h"
#include "gotocelldialog.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);

    GoToCellDialog *dialog = new GoToCellDialog();
    dialog->show();

//    Ui::GoToCellDialog ui;
//    QDialog *dialog = new QDialog;
//    ui.setupUi(dialog);
//    dialog->show();

//    AnalogClock w;
//    w.show();

    return a.exec();
}
