
# version 1.0
<p>只是实现了简单的jni动态加载模块</p>
JNI模块的各种功能/技巧研究.

# 新版本SDK编译出错

```Shell
ndk-build 
Android NDK: Could not find application project directory !    
Android NDK: Please define the NDK_PROJECT_PATH variable to point to it.    
/home/用户路径/android-ndk-r15b/build/core/build-local.mk:151: *** Android NDK: Aborting    .  Stop.
```
修改`ndk-build`指令即可. 根目录执行如下指令即可
```Shell
ndk-build NDK_PROJECT_PATH=. NDK_APPLICATION_MK=jni/Application.mk APP_BUILD_SCRIPT=jni/Android.mk 
```
