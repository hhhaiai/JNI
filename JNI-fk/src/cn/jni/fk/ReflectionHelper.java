package cn.jni.fk;

import java.lang.reflect.Method;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;

/**
 * @Copyright © 2018 sanbo Inc. All rights reserved.
 * @Description: 辅助类
 * @Version: 1.0
 * @Create: 2018年9月22日 下午9:49:20
 * @Author: Administrator
 */
public class ReflectionHelper {
    static {
        System.loadLibrary("art");
    }

    private static native int unsealNative(int targetSdkVersion);

    private static int UNKNOWN = -9999;

    private static final int ERROR_SET_APPLICATION_FAILED = -20;

    private static int unsealed = UNKNOWN;

    public static int unseal(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            // Below Android P, ignore
            return 0;
        }

        if (context == null) {
            return -10;
        }

        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int targetSdkVersion = applicationInfo.targetSdkVersion;

        synchronized (ReflectionHelper.class) {
            if (unsealed == UNKNOWN) {
                unsealed = unsealNative(targetSdkVersion);
                if (unsealed >= 0) {
                    try {
                        @SuppressLint("PrivateApi")
                        Method setHiddenApiEnforcementPolicy =
                            ApplicationInfo.class.getDeclaredMethod("setHiddenApiEnforcementPolicy", int.class);
                        setHiddenApiEnforcementPolicy.invoke(applicationInfo, 0);
                    } catch (Throwable e) {
                        e.printStackTrace();
                        unsealed = ERROR_SET_APPLICATION_FAILED;
                    }
                }
            }
        }
        return unsealed;
    }
}
