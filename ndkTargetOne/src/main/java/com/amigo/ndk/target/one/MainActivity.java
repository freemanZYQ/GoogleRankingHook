package com.amigo.ndk.target.one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NdkUtils ndkUtils = new NdkUtils();
                String output = ndkUtils.dothing("test1");
                Log.d("ndkUtils",output);
            }
        });
    }

    static{
        System.loadLibrary("ndkUtilsOne");
    }

}
