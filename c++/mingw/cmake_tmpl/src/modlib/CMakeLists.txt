#设置编译内容
aux_source_directory( . SRC_LIST )

#设置生成的目标
add_library( ${MODULE_LIB} STATIC ${SRC_LIST} )

#添加Include目录
include_directories( ${CMAKE_HOME_DIRECTORY}/inc )

