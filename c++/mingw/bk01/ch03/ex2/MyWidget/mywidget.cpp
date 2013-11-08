#include "mywidget.h"
#include "ui_mywidget.h"
#include <QDialog>

MyWidget::MyWidget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::MyWidget)
{
    ui->setupUi(this);
//    connect(ui->showChildButton, SIGNAL(clicked()), this, SLOT(showChildDialog()));

    QDialog dialog(this);
    dialog.setWindowTitle("Dialog");
    dialog.setModal(true);
    dialog.show();
//    dialog.exec();

//    QDialog *dialog = new QDialog(this);
//    dialog->setWindowTitle("Dialog");
//    dialog->setModal(true);
//    dialog->show();

}

MyWidget::~MyWidget()
{
    delete ui;
}

void MyWidget::on_showChildButton_clicked()
{
    QDialog *dialog = new QDialog(this);
    dialog->show();
}

//void MyWidget::showChildDialog()
//{
//    QDialog *dialog = new QDialog(this);
//    dialog->show();
//}
