package cn.jni;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.text);
        String s = ReflectionHelper.HelloLoad();
        tv.setText("JNI data ===>[ " + s + " ]<===");
    }

}
