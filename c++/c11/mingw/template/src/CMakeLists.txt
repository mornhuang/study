#设置模块名(生成目标的名称)
set( PROJECT        "project" )
set( MODULE_SHARE   "mod_share" )
set( MODULE_LIB     "mod_lib" )

#添加下级其它编译内容
add_subdirectory( main )
add_subdirectory( modshare )
add_subdirectory( modlib )



