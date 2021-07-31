package me.hhhaiai.cc;

public class HelloJni {
    static {
        System.loadLibrary("hellojni");
    }

    /**
     * JNI方式加载字符串
     *
     * @return
     */
    public static native String helloLoad();
}
