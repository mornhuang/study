
//***************************************************************************  
// *    本代码参考了中国中国农历函数库  
// *    版权所有 (C) 2005-2006 孙高勇  
// *  Mail:sungaoyong@gmail.com  
// ***************************************************************************  
  
  
#include "mycalendar.h"  
#include "TCalendar.h"  
#include <QtGui>  
  
Mycalendar::Mycalendar(QDialog *parent)  
    : QDialog(parent)  
{  
    setupUi(this);  
  
    mycalendat=new MyCTCalendar;  
    mycalendat->InitConnection(QDir::currentPath ());  
    selectedDate = QDate::currentDate();  
    for (int month = 1; month <= 12; ++month)  
        monthCombo->addItem(QDate::longMonthName(month));  
    monthCombo->setCurrentIndex(selectedDate.month() - 1);  
    YearSelect->setDate(selectedDate);  
    insertCalendar();  
    connect(monthCombo, SIGNAL(currentIndexChanged(int)), this, SLOT(setMonth(int)));  
    connect(monthCombo, SIGNAL(activated(int)), this, SLOT(setMonth(int)));  
    connect(YearSelect, SIGNAL(dateChanged(QDate)), this, SLOT(setYear(QDate)));  
}  
  
Mycalendar::~Mycalendar()  
{  
  delete mycalendat;  
}  
//***************************************************************************  
// *函数：void setMonth(int month);  
// *功能：设置月  
// *参数：int month  
// *返回值：  
// ***************************************************************************/  
void Mycalendar::setMonth(int month)  
{  
    selectedDate = QDate(selectedDate.year(), month + 1, selectedDate.day());  
    insertCalendar();  
}  
  
//***************************************************************************  
// *函数：void setYear(QDate date)  
// *功能：设置年  
// *参数：QDate date  
// *返回值：  
// ***************************************************************************/  
void Mycalendar::setYear(QDate date)  
{  
    selectedDate = QDate(date.year(), selectedDate.month(), selectedDate.day());  
    insertCalendar();  
}  
  
//***************************************************************************  
// *函数：void insertCalendar()  
// *功能：在tableCalendar中插入日期数据  
// *参数：  
// *返回值：  
// ***************************************************************************/  
void Mycalendar::insertCalendar()  
{  
    struct CTCalendar c;  
    tableCalendar->clear();  
    tableCalendar->setRowCount(2);  
    tableCalendar->setColumnCount(7);  
    tableCalendar->horizontalHeader()->hide();  
    tableCalendar->verticalHeader()->hide();  
    for(int i=0;i<7;i++)  
        tableCalendar->setColumnWidth(i,(width()-30)/7);  
  
    QDate date(selectedDate.year(), selectedDate.month(), 1);    
  
    //写入星期  
    for (int weekDay = 1; weekDay <= 7; ++weekDay) {         
        tableCalendar->setItem(0,weekDay-1,new QTableWidgetItem(QDate::longDayName(weekDay)));  
        if(weekDay<=5)  
            tableCalendar->item(0,weekDay-1)->setBackgroundColor(Qt::cyan);  
        else  
            tableCalendar->item(0,weekDay-1)->setBackgroundColor(Qt::red);  
    }  
    //加入日期  
     while (date.month() == selectedDate.month()) {  
          int weekDay = date.dayOfWeek();  
            
         mycalendat->ctcl_solar_to_lunar(selectedDate.year(),selectedDate.month(),date.day(),&c);//获取农历信息  
           QString mycday;  
                    mycday=c.cday;  
          if(c.sterm.at(0) >=QChar('0') && c.sterm.at(0) <= QChar('9'))  
            mycday=c.cday;  
          else  
            mycday=c.sterm;  
  
          tableCalendar->setItem(tableCalendar->rowCount()-1,weekDay-1,new QTableWidgetItem(QString("%1\n%2").arg(date.day()).arg(mycday)));  
  
          QString CuText=tr("NongLi year");  
          CuText.append(c.ganzhi+tr("year(")+c.shengxiao+")");  
          CuText.append("\n"+tr("NongLi Day:")+c.cmonth+c.cday);  
          CuText.append("\n"+tr("today constellation:")+c.zodiac);  
          CuText.append("\n"+tr("forthcoming sterm:")+c.sterm);  
                  if(!c.holiday.isNull())  
                    CuText.append("\n"+tr("holiday:")+c.holiday);  
                  if(!c.choliday.isNull())  
                    CuText.append("\n"+tr("choliday:")+c.choliday);  
  
          tableCalendar->item(tableCalendar->rowCount()-1, weekDay-1)->setToolTip(CuText);  
          date = date.addDays(1);  
            if (weekDay == 7 && date.month() == selectedDate.month())  
                tableCalendar->insertRow(tableCalendar->rowCount());  
     }  
}  
  
void Mycalendar::on_TbpreviousYear_clicked()  
{  
    YearSelect->setDate(selectedDate.addYears(-1));  
}  
  
void Mycalendar::on_TbpreviousMonth_clicked()  
{  
    monthCombo->setCurrentIndex(monthCombo->currentIndex()-1);  
}  
  
void Mycalendar::on_TbnextMonth_clicked()  
{  
    monthCombo->setCurrentIndex(monthCombo->currentIndex()+1);  
}  
  
void Mycalendar::on_TbnextYear_clicked()  
{  
    YearSelect->setDate(selectedDate.addYears(1));  
}  