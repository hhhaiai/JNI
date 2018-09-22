package cn.jni.fk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String TAG = "xxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("xxx", "xxx=>" + ReflectionHelper.unseal(MainActivity.this));

        qqq();
    }

    private void qqq() {
        Log.i(TAG, "version : " + Build.VERSION.SDK_INT + " fingerprint: " + Build.FINGERPRINT);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Method setHiddenApiEnforcementPolicy =
                        ApplicationInfo.class.getDeclaredMethod("setHiddenApiEnforcementPolicy", int.class);
                    Log.i(TAG, "setHiddenApiEnforcementPolicy:" + setHiddenApiEnforcementPolicy);

                    Class<?> assetManagerClass = AssetManager.class;
                    Method ensureStringBlocks = assetManagerClass.getDeclaredMethod("ensureStringBlocks");
                    ensureStringBlocks.setAccessible(true);
                    ensureStringBlocks.invoke(getAssets());
                    Log.i(TAG, "call success!!");
                } catch (Throwable e) {
                    Log.e(TAG, "error:", e);
                    toast("error: " + e);
                }

                Log.i(TAG, "test  setHiddenApiEnforcementPolicy over .");

                try {

                    Log.i(TAG, "begin test ActivityThread");

                    test();
                    Log.i(TAG, "begin test success.");
                } catch (Throwable e) {
                    Log.e(TAG, "begin test failed: " + Log.getStackTraceString(e));
                }
            }
        });

        findViewById(R.id.unreal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ret = ReflectionHelper.unseal(MainActivity.this);
                toast("unseal result: " + ret);
            }
        });
    }

    private void toast(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.i(TAG, msg);
    }

    private void test() throws Throwable {
        Class<?> activityThread = Class.forName("android.app.ActivityThread");
        Class<?> hclass = Class.forName("android.app.ActivityThread$H");
        Field[] declaredFields = hclass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Log.i(TAG, "declareField: " + declaredField);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
