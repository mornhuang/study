#设置编译内容
aux_source_directory( . SRC_LIST )

#设置生成的目标
add_executable( ${MAIN_APP} ${SRC_LIST} )

#添加Include目录
include_directories( ${CMAKE_HOME_DIRECTORY}/inc )

#添加Library目录
link_directories( ${PROJECT_BINARY_DIR}/lib )

#设置目标要链接的静态库
target_link_libraries( ${MAIN_APP}
    ${TEST1_MODULE}
    ${TEST2_MODULE}
)

#设置编译顺序依赖
add_dependencies( ${MAIN_APP}
    ${TEST1_MODULE}
    ${TEST2_MODULE}
)

