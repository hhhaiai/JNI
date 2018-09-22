LOCAL_PATH := $(call my-dir)
 
include $(CLEAR_VARS)
LOCAL_MODULE := demo
LOCAL_SRC_FILES := Test.cpp


#下面两种方式均是使用log方法,任选一句即可
#LOCAL_LDLIBS := -llog
LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib -llog
#下面一句是编译成动态库，即so库
include $(BUILD_SHARED_LIBRARY)

LOCAL_PATH := $(call my-dir)