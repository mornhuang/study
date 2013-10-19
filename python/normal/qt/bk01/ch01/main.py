#-*- coding:utf-8 -*-
#!/usr/bin/env python

#
# Created on 2011-10-5
# @author: IBM
#

import sys
from PyQt4.QtGui import *
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
