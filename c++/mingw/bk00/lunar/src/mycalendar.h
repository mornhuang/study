//*************************************************************************** 
// *	本代码参考了中国中国农历函数库 
// *	版权所有 (C) 2005-2006 孙高勇 
// *  Mail:sungaoyong@gmail.com 
// ***************************************************************************/ 
 
 
#ifndef MYCALENDAR_H 
#define MYCALENDAR_H 
 
#include <QDialog> 
#include <QDate> 
#include "ui_calendar.h" 
 
class MyCTCalendar; 
class Mycalendar: public QDialog, private Ui::Calendar 
{ 
    Q_OBJECT 
public: 
    Mycalendar(QDialog *parent = 0); 
    virtual ~Mycalendar(); 
private: 
	QDate selectedDate; 
	void insertCalendar(); 
	MyCTCalendar *mycalendat; 
public slots: 
    void setMonth(int month); 
    void setYear(QDate date); 
 
 
private slots: 
	void on_TbnextYear_clicked(); 
	void on_TbnextMonth_clicked(); 
	void on_TbpreviousMonth_clicked(); 
	void on_TbpreviousYear_clicked(); 
}; 
 
#endif 
