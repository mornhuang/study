project(mfc)
cmake_minimum_required(VERSION 2.8)

set(PLATFORM X86)
set(CMAKE_BUILD_TYPE Debug)
set(CMAKE_CXX_FLAGS "${CMAKE_C_FLAGS} /MTd /EHsc")

add_definitions("-D_WINDOWS -D__WIN__ -D_CRT_SECURE_NO_DEPRECATE")
add_definitions("-D_WIN32_WINNT=0x0501")
add_definitions("-D_AFXDLL")

aux_source_directory(. SRC_LIST)
add_executable(${PROJECT_NAME} ${SRC_LIST})

