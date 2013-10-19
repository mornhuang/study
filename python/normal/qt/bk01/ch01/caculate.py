#-*- coding:utf-8 -*-
#!/usr/bin/env python

#
# Created on 2011-10-5
# @author: IBM
#

import sys
from PyQt4.QtCore import *
from PyQt4.QtGui import *


class Form(QDialog):
    def __init__(self, parent=None):
        super(Form, self).__init__(parent)
        self.browser = QTextBrowser()
        self.line_edit = QLineEdit("Type an express and press enter")
        self.lineEdit.selectAll()
        layout = QVBoxLayout()
        layout.addWidget(self.browser)
        layout.addWidget(self.lineEdit)
        self.setLayout(layout)
        self.lineEdit.setFocus()
        self.connect(self.lineEdit, SIGNAL("returnPressed()"), self.updateUi)
        self.setWindowTitle("Calculate")
    
    def update_ui(self):
        try:
            text = str(self.lineEdit.text())
            self.browser.append("%s = <b>%s</b>" % (text, eval(text)))
        except:
            self.browser.append("<font color=red>%s is invalid</font>" % text)
        

if __name__ == '__main__':
    app = QApplication(sys.argv)
    form = Form()
    form.show()
    app.exec_()

