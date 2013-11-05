#设置本级编译内容
aux_source_directory( . SRC_LIST )

#设置生成的目标
add_library( ${TEST1_MODULE}_dynamci SHARED ${SRC_LIST} )
add_library( ${TEST1_MODULE}_static  STATIC ${SRC_LIST} )
set_target_properties( ${TEST1_MODULE}_dynamci ${TEST1_MODULE}_static PROPERTIES
    OUTPUT_NAME ${TEST1_MODULE}
)

#add_library( ${TEST1_MODULE} STATIC ${SRC_LIST} )
#set_target_properties( ${TEST1_MODULE} PROPERTIES DEFINE_SYMBOL "COMPILING_DLL" )

#添加宏编译定义
add_definitions( "-DTEST1_EXPORTS" )

#添加Include目录
include_directories( ${CMAKE_HOME_DIRECTORY}/inc )

#查看Include目录
get_target_property( EXTR_INC_PATH_GET ${TEST1_MODULE} INCLUDE_DIRECTORIES )
message( STATUS "EXTR_INC_PATH_GET >>> " ${EXTR_INC_PATH_GET} )




#include (GenerateExportHeader)
#GENERATE_EXPORT_HEADER( ${TEST1_MODULE}
#             BASE_NAME ${TEST1_MODULE}
#             EXPORT_MACRO_NAME ${TEST1_MODULE}_EXPORT
#             EXPORT_FILE_NAME ${TEST1_MODULE}_Export.h
#             STATIC_DEFINE ${TEST1_MODULE}_BUILT_AS_STATIC
#)

