#工程名称
project( basic )

#CMake支持的最小版本
cmake_minimum_required( VERSION 2.8 )

#编译Debug版本
set( CMAKE_BUILD_TYPE Debug )

#设置全局输出路径
set( CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/bin )
set( CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/bin )
set( CMAKE_RUNTIME_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/bin )

#设置全局源代码路径
set( PROJECT_SOURCE_DIR src )

#添加全局编译选项
if( MSVC )
    set( CMAKE_CXX_FLAGS "/EHsc" )
    set( CMAKE_CXX_FLAGS_DEBUG "/MDd" )
    set( CMAKE_C_FLAGS_DEBUG "/MDd" )
else()
    set( CMAKE_CXX_FLAGS "-Wall" )
    set( CMAKE_CXX_FLAGS_DEBUG "-O0 -ggdb" )
    set( CMAKE_C_FLAGS_DEBUG "-O3" )
endif()

#添加全局编译定义
if( MSVC)
    add_definitions( "-D_AFXDLL -DWIN32 -D_WIN32_WINNT=0x0403" )    
endif()

#添加下级编译内容
add_subdirectory( src build)



