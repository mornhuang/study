#ifndef ANALOGCLOCK_H
#define ANALOGCLOCK_H

#include <QtGui/QWidget>
//#include "ui_analogclock.h"

class AnalogClock : public QWidget
{
    Q_OBJECT

public:
    AnalogClock(QWidget *parent = 0);
    ~AnalogClock();

protected:
    void paintEvent(QPaintEvent *event);

private:
//    Ui::AnalogClockClass ui;
};

#endif // ANALOGCLOCK_H
