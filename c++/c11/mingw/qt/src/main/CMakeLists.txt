#设置编译内容
aux_source_directory( . SRC_LIST )

#设置生成的目标
add_executable( ${PROJECT_NAME} ${SRC_LIST} )

#添加Include目录
include_directories( ${CMAKE_HOME_DIRECTORY}/inc )

#添加Library目录
link_directories( ${PROJECT_BINARY_DIR}/lib )


