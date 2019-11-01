cmake_minimum_required(VERSION 3.4.1)

add_library(hello SHARED
        hello.c)

# Include libraries needed for hello-jni lib
target_link_libraries(hello
        android
        log)
