#include <stdlib.h>


#include "hellojni.h"

// 获取数组的大小
# define NELEM(x) ((int) (sizeof(x) / sizeof((x)[0])))
// 指定要注册的类，对应完整的java类名
#define JNIREG_CLASS "me/hhhaiai/cc/HelloJni"

// 返回字符串"hello load jni"
JNIEXPORT jstring JNICALL native_hello(JNIEnv *env, jclass clazz) {
    return (*env)->NewStringUTF(env, "hello load jni");
}


/**
 * 结构模型{"Java层参数","(JAVA层类型)返回值类型;",C++实现函数名称}
 */
static JNINativeMethod method_table[] = {
        {"helloLoad", "()Ljava/lang/String;", (jstring *) native_hello},
};

// 注册native方法到java中
static int registerNativeMethods(JNIEnv *env, const char *className,
                                 JNINativeMethod *gMethods, int numMethods) {
    LOGI("registerNativeMethods");
    jclass clazz;
    clazz = (*env)->FindClass(env, className);
    if (clazz == NULL) {
        return JNI_FALSE;
    }
    if ((*env)->RegisterNatives(env, clazz, gMethods, numMethods) < 0) {
        return JNI_FALSE;
    }

    return JNI_TRUE;
}

JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    LOGD("inside JNI_OnLoad");
    JNIEnv *env = NULL;
    jint result = -1;
    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_4) != JNI_OK) {
        return result;
    }

    if (!registerNativeMethods(env, JNIREG_CLASS, method_table,
                               NELEM(method_table))) { //注册
        return -1;
    }
    //成功
    result = JNI_VERSION_1_4;
    // 返回jni的版本
    return JNI_VERSION_1_4;
}


