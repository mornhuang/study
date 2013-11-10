#include "mywidget.h"
#include "ui_mywidget.h"
#include "mydialog.h"
#include "mystddialog.h"
#include <QTextCodec>

MyWidget::MyWidget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::MyWidget)
{
    ui->setupUi(this);
}

MyWidget::~MyWidget()
{
    delete ui;
}

void MyWidget::on_pushButton_clicked()
{
    close();
    MyDialog d;
    if (d.exec() == QDialog::Accepted)
    {
        show();
    }
}

void MyWidget::on_pushButton_2_clicked()
{
    MyStdDialog *dlg = new MyStdDialog(this);
    dlg->setModal(true);
    dlg->show();
}
