#设置编译内容
aux_source_directory( . SRC_LIST )

#设置生成的目标
add_library( ${TEST2_MODULE} STATIC ${SRC_LIST} )

#添加Include目录
include_directories( ${CMAKE_HOME_DIRECTORY}/inc )

#设置生成的执行文件所在路径
#set_target_properties( ${TEST2_MODULE}  PROPERTIES
#    RUNTIME_OUTPUT_DIRECTORY  "${PROJECT_BINARY_DIR}/lib"
#)
