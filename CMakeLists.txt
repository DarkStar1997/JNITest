find_program(CCACHE_PROGRAM ccache)

if(CCACHE_PROGRAM)
    MESSAGE("CCACHE support enabled")
    set_property(GLOBAL PROPERTY RULE_LAUNCH_COMPILE "${CCACHE_PROGRAM}")
    set_property(GLOBAL PROPERTY RULE_LAUNCH_LINK "${CCACHE_PROGRAM}")
endif()

find_package(JNI REQUIRED)

set(CMAKE_EXPORT_COMPILE_COMMANDS 1)
set(CMAKE_CXX_FLAGS "-O3 -march=native -std=c++17 -fPIC")
set(MODULE_NAME "HelloWorldJNI")
set(LIB_NAME "native")

set(headers
    ${MODULE_NAME}.h
    )

set(sources
    sample.cpp
    )

add_library(${LIB_NAME} SHARED ${headers} ${sources})
#target_include_directories(${LIB_NAME} PRIVATE "/usr/lib/jvm/java-13-openjdk/include" "/usr/lib/jvm/java-13-openjdk/include/linux")
target_include_directories(${LIB_NAME} PRIVATE ${JNI_INCLUDE_DIRS})
