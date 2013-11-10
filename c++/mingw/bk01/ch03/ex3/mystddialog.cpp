#include "mystddialog.h"
#include "ui_mystddialog.h"
#include <QColorDialog>
#include <QColor>
#include <QDebug>
#include <QFileDialog>
#include <QFont>
#include <QFontDialog>
#include <QInputDialog>
#include <QLineEdit>
#include <QString>
#include <QMessageBox>
#include <QProgressDialog>
#include <QWizard>
#include <QWizardPage>

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
    QString fileName = QFileDialog::getOpenFileName(this, tr("选择文件"), "E:",
                                                    tr("图片文件 (*.png *.jpg);;文本文件 (*.txt)"));
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

void MyStdDialog::on_inputButton_clicked()
{
    bool ok;
    QString str = QInputDialog::getText(this, "input", "username",
                                        QLineEdit::PasswordEchoOnEdit, "admin", &ok);
    if (ok) qDebug() << "String: " << str << endl;

}

void MyStdDialog::on_messageButton_clicked()
{
    QMessageBox::critical(this, "critical", "Serial Question", QMessageBox::YesAll);
}

void MyStdDialog::on_progressButton_clicked()
{
    QProgressDialog dlg("progress", "cancel", 0, 50000, this);
    dlg.setWindowModality(Qt::WindowModal);
    dlg.show();
    for (int i = 0; i < 50000; i++)
    {
        dlg.setValue(i);
        QCoreApplication::processEvents();
        if (dlg.wasCanceled())
        {
            break;
        }
    }
    dlg.setValue(50000);
}

void MyStdDialog::on_guidButton_clicked()
{
    QWizard wiz(this);

    QWizardPage *p1 = new QWizardPage();
    p1->setTitle("page1");

    wiz.addPage(p1);
    wiz.exec();
}
