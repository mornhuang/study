#include "mystddialog.h"
#include "ui_mystddialog.h"
#include <QColorDialog>
#include <QColor>
#include <QDebug>
#include <QFileDialog>
#include <QFont>
#include <QFontDialog>

MyStdDialog::MyStdDialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::MyStdDialog)
{
    ui->setupUi(this);
}

MyStdDialog::~MyStdDialog()
{
    delete ui;
}

void MyStdDialog::on_colorButton_clicked()
{
    QColor color = QColorDialog::getColor(Qt::red, this);
    qDebug() << "color: " << color << endl;
}

void MyStdDialog::on_fileButton_clicked()
{
    QString fileName = QFileDialog::getOpenFileName(this, tr("选择文件"), "E:", tr("图片文件 (*.png *.jpg);;文本文件 (*.txt)"));
    qDebug() << "file name: " << fileName << endl;
}

void MyStdDialog::on_fontButton_clicked()
{
    bool ok;
    QFont font = QFontDialog::getFont(&ok, this);
    if (ok)
        ui->fontButton->setFont(font);
    else
        qDebug() << "No Choose" << endl;

}
