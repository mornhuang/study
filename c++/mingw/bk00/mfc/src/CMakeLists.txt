set( MAIN_APP_SRC "main" )
set( TEST1_MODULE_SRC "test1" )
set( TEST2_MODULE_SRC "test2" )

set( MAIN_APP     ${PROJECT_NAME}     )
set( TEST1_MODULE ${TEST1_MODULE_SRC} )
set( TEST2_MODULE ${TEST2_MODULE_SRC} )

#添加下级其它编译内容
add_subdirectory( ${MAIN_APP_SRC} )
add_subdirectory( ${TEST1_MODULE_SRC} )
add_subdirectory( ${TEST2_MODULE_SRC} )



