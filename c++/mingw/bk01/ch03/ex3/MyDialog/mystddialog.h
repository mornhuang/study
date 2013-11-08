#ifndef MYSTDDIALOG_H
#define MYSTDDIALOG_H

#include <QDialog>

namespace Ui {
class MyStdDialog;
}

class MyStdDialog : public QDialog
{
    Q_OBJECT

public:
    explicit MyStdDialog(QWidget *parent = 0);
    ~MyStdDialog();

private slots:
    void on_colorButton_clicked();

    void on_fileButton_clicked();

    void on_fontButton_clicked();

private:
    Ui::MyStdDialog *ui;
};

#endif // MYSTDDIALOG_H
