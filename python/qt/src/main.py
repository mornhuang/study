'''
Created on 2011-10-27

@author: Morn
'''

#!/usr/bin/env python
#-*- encoding:UTF-8 -*-

import sys
from PyQt4.QtGui import *
from PyQt4.QtCore import *
from ui_hello import Ui_Form

class MyForm(QMainWindow):
    def __init__(self, parent=None):
        QMainWindow.__init__(self, parent)
        self.ui = Ui_Form()
        self.ui.setupUi(self)

def main():
    app = QApplication(sys.argv)
    form = MyForm()
    form.show()
    sys.exit(app.exec_())

if __name__ == '__main__':
    main()
