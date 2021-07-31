package me.hhhaiai.jnicpp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView tv = (TextView) findViewById(R.id.tv);
        String s = HelloJni.helloLoad();
        tv.setText("JNI data ===>[ " + s + " ]<===");
    }
}