# Copyright (C) 2009 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

#目标so名字，源文件
LOCAL_MODULE    := hellojni
LOCAL_SRC_FILES := \
	hellojni.c

LOCAL_C_INCLUDES := $(LOCAL_PATH)/include

#下面两种方式均是使用log方法,任选一句即可
LOCAL_LDLIBS := -llog
#LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib -llog
#下面一句是编译成动态库，即so库
include $(BUILD_SHARED_LIBRARY)

LOCAL_PATH := $(call my-dir)