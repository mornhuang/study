#工程名称
project( qtstudy )

#CMake支持的最小版本
cmake_minimum_required( VERSION 2.8 )

#设置全局输出路径
set( CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/lib )
set( CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/lib )
set( CMAKE_RUNTIME_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/dist )

#设置全局源代码路径
set( PROJECT_SOURCE_DIR src )

#编译Debug版本
set( CMAKE_BUILD_TYPE Debug )

#添加下级编译内容
add_subdirectory( src )



