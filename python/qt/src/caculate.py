'''
Created on 2011-11-3

@author: Morn
'''

#!/usr/bin/env python
#-*- encoding:UTF-8 -*-

import sys
from math import *
from PyQt4.QtCore import *
from PyQt4.QtGui import *

class Form(QDialog):
    def __init__(self, parent=None):
        super(Form, self).__init__(parent)
        self.brower = QTextBrowser()
        self.lineedit = QLineEdit("Type an express and press enter")
        self.lineedit.selectAll()
        layout = QVBoxLayout()
        layout.addWidget(self.brower)
        layout.addWidget(self.lineedit)
        self.setLayout(layout)
        self.lineedit.setFocus()
        self.connect(self.lineedit, SIGNAL("returnPressed()"), self.updateUi)
        self.setWindowTitle("Caculate")
    
    def updateUi(self):
        try:
            text = str(self.lineedit.text())
            self.brower.append("%s = <b>%s</b>" % (text, eval(text)))
        except:
            self.brower.append("<font color=red>%s is invalid</font>" % text)
        

if __name__ == '__main__':
    app = QApplication(sys.argv)
    form = Form()
    form.show()
    app.exec_()
    
