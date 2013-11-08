/*
 * gotocelldialog.cpp
 *
 *  Created on: 2011-10-25
 *      Author: Morn Huang
 */

#include <QtGui>
#include "gotocelldialog.h"

GoToCellDialog::GoToCellDialog(QWidget *parent)
	:QDialog(parent)
{
	setupUi(this);

	QRegExp regExp("[A-Za-z][1-9][0-9]{0,2}");
	lineEdit->setValidator(new QRegExpValidator(regExp, this));

	connect(okButton, SIGNAL(clicked()), this, SLOT(accept()));
	connect(cancleButton, SIGNAL(clicked()), this, SLOT(reject()));

}

void GoToCellDialog::on_lineEdit_textChanged()
{
    if (lineEdit->hasAcceptableInput())
        okButton->setEnabled(true);
    else
        okButton->setEnabled(false);
}

