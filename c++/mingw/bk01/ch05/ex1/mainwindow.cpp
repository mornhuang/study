#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    QMenu *editMenut = ui->menuBar->addMenu("&Edit");

    QAction *action_Open = editMenut->addAction(QIcon(":/a.png"), "&Open");
    action_Open->setShortcut(QKeySequence("Ctrl+O"));
    ui->mainToolBar->addAction(action_Open);

    QActionGroup *group = new QActionGroup(this);
    QAction *action_l = group->addAction("left");
    action_l->setCheckable(true);
    QAction *action_r = group->addAction("right");
    action_r->setCheckable(true);
    QAction *action_c = group->addAction("central");
    action_c->setCheckable(true);
    action_l->setChecked(true);
    editMenut->addAction(action_l);
    editMenut->addAction(action_r);
    editMenut->addAction(action_c);

}

MainWindow::~MainWindow()
{
    delete ui;
}
