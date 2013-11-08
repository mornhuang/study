#设置本级编译内容
aux_source_directory( . SRC_LIST )

#设置生成的目标
add_library( ${MODULE_SHARE} SHARED ${SRC_LIST} )

#添加宏编译定义
add_definitions( "-DMODULE_EXPORTS" )

#添加Include目录
include_directories( ${CMAKE_HOME_DIRECTORY}/inc )

