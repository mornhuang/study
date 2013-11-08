/********************************************************************************
** Form generated from reading UI file 'analogclock.ui'
**
** Created: Mon Oct 24 22:19:06 2011
**      by: Qt User Interface Compiler version 4.7.4
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_ANALOGCLOCK_H
#define UI_ANALOGCLOCK_H

#include <QtCore/QVariant>
#include <QtGui/QAction>
#include <QtGui/QApplication>
#include <QtGui/QButtonGroup>
#include <QtGui/QHeaderView>
#include <QtGui/QWidget>

QT_BEGIN_NAMESPACE

class Ui_AnalogClockClass
{
public:

    void setupUi(QWidget *AnalogClockClass)
    {
        if (AnalogClockClass->objectName().isEmpty())
            AnalogClockClass->setObjectName(QString::fromUtf8("AnalogClockClass"));
        AnalogClockClass->resize(400, 300);

        retranslateUi(AnalogClockClass);

        QMetaObject::connectSlotsByName(AnalogClockClass);
    } // setupUi

    void retranslateUi(QWidget *AnalogClockClass)
    {
        AnalogClockClass->setWindowTitle(QApplication::translate("AnalogClockClass", "AnalogClock", 0, QApplication::UnicodeUTF8));
    } // retranslateUi

};

namespace Ui {
    class AnalogClockClass: public Ui_AnalogClockClass {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_ANALOGCLOCK_H
