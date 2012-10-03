/*
 * gotocelldialog.h
 *
 *  Created on: 2011-10-25
 *      Author: Morn Huang
 */

#ifndef GOTOCELLDIALOG_H_
#define GOTOCELLDIALOG_H_

#include <QDialog>
#include "ui_gotocelldialog.h"

class GoToCellDialog: public QDialog, public Ui::GoToCellDialog
{
	Q_OBJECT
public:
	GoToCellDialog(QWidget *parent = 0);

private slots:
	void on_lineEdit_textChanged();
};



#endif /* GOTOCELLDIALOG_H_ */
