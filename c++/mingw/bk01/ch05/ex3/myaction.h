#ifndef MYACTION_H
#define MYACTION_H

#include <QWidgetAction>
class QLineEdit;

class MyAction : public QWidgetAction
{
    Q_OBJECT

public:
    explicit MyAction(QWidget *parent = 0);

protected:
    QWidget* createWidget(QWidget *parent);

signals:
    void getText(const QString &string);

public slots:

private slots:
    void sendText();

private:
    QLineEdit *lineEdit;
};

#endif // MYACTION_H
