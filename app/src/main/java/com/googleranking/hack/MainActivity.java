package com.googleranking.hack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvResult = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvResult = (TextView)findViewById(R.id.result);

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NdkUtilsHookHelper ndkUtilsHookHelper = new NdkUtilsHookHelper();
                try {
                    String result = ndkUtilsHookHelper.test(MainActivity.this);
                    mTvResult.setText(result);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
