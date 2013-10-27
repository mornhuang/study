# -*- mode: python -*-
a = Analysis(['HelloWorld.py'],
             pathex=['E:\\person\\coding\\studies\\python\\src\\bk00'],
             hiddenimports=[],
             hookspath=None,
             runtime_hooks=None)
pyz = PYZ(a.pure)
exe = EXE(pyz,
          a.scripts,
          a.binaries,
          a.zipfiles,
          a.datas,
          name='HelloWorld.exe',
          debug=False,
          strip=None,
          upx=True,
          console=True )
