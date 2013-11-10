#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QLabel>
#include <QFrame>
#include "myaction.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    ui->statusBar->showMessage("hello", 2000);

    QLabel *permanent = new QLabel(this);
    permanent->setFrameStyle(QFrame::Box | QFrame::Sunken);
    permanent->setText("www.hongray.com");

    ui->statusBar->addPermanentWidget(permanent);

    MyAction *myAction = new MyAction();
    QMenu *editMenu = ui->menuBar->addMenu("Edit");
    editMenu->addAction(myAction);
    connect(myAction, SIGNAL(getText(QString)), this, SLOT(setText(QString)));

}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::setText(const QString &string)
{
    ui->textEdit->setText(string);
}
