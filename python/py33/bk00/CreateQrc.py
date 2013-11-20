#/usr/bin/env python3
# -*- coding: utf-8 -*-
#
# Copyright (c) 2011 David Townshend
#
# This program is free software; you can redistribute it and/or modify it
# under the terms of the GNU General Public License as published by the
# Free Software Foundation; either version 2 of the License, or (at your
# option) any later version.
#
# This program is distributed in the hope that it will be useful, but
# WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
# or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
# for more details.
#
# You should have received a copy of the GNU General Public License along
# with this program; if not, write to the Free Software Foundation, Inc.,
# 675 Mass Ave, Cambridge, MA 02139, USA.

''' Create or update the qrc file. '''

import os
import os.path
import subprocess

root = 'tango-0.8.90-svg'
qrc = 'tango_0_8_90.qrc'
rcc = '../qte/tango_rcc.py'

# A list of search paths for the rcc executable.  Add paths as necessary.
rccexe_paths = [r'C:\Python32\Lib\site-packages\PySide\pyside-rcc.exe']

for p in rccexe_paths:
    rccexe = p
    if os.path.exists(p):
        break
else:
    raise OSError("Can't find rcc executable")


def main():
    print('Creating {}'.format(qrc))
    fh = open(qrc, 'w')
    fh.write('<RCC>\n')
    for folder in os.listdir(root):
        fh.write('  <qresource prefix="{}">\n'.format(folder))
        for name in os.listdir(os.path.join(root, folder)):
            filepath = os.path.join(root, folder, name)
            alias = os.path.splitext(name)[0]
            fh.write('    <file alias="{}">{}</file>\n'.format(alias, filepath))
        fh.write('  </qresource>\n')
    fh.write('</RCC>\n')
    fh.close()

    print('Creating {}'.format(rcc))
    subprocess.call([rccexe, '-py3', '-compress', '9', '-o', rcc, qrc])
    print('Done')


if __name__ == '__main__':
    main()