package me.hhhaiai.jnicpp;

public class HelloJni {
    static {
        System.loadLibrary("demo");
    }

    /**
     * JNI方式加载字符串
     *
     * @return
     */
    public static native String helloLoad();
}
