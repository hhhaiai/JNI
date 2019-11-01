package com.example.hellojni;

/**
 * @Copyright © 2019 sanbo Inc. All rights reserved.
 * @Description: TODO
 * @Version: 1.0
 * @Create: 2019-10-31 16:12:02
 * @author: sanbo
 */
public class ReflectionHelper {

    private static class HOLDER {
        private static ReflectionHelper INSTANCE = new ReflectionHelper();
    }

    private ReflectionHelper() {
    }

    public static ReflectionHelper getInstance() {
        return HOLDER.INSTANCE;
    }

    public native String helloLoad();

    static {
        System.loadLibrary("hello");
    }
}
