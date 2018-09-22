package cn.jni;

/**
 * @Copyright © 2018 sanbo Inc. All rights reserved.
 * @Description: 反射辅助类
 * @Version: 1.0
 * @Create: 2018年9月22日 下午9:49:20
 * @Author: Administrator
 */
public class ReflectionHelper {
    static {
        System.loadLibrary("hellojni");
    }

    /**
     * JNI方式加载字符串
     * 
     * @return
     */
    public static native String HelloLoad();

}
