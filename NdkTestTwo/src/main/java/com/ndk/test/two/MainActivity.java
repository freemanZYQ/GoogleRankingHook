package com.ndk.test.two;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView mTvClick;
    private TextView mTvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.loadLibrary("ndkUtils");
        mTvClick = (TextView) findViewById(R.id.click);
        mTvResult = (TextView) findViewById(R.id.result);
        mTvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NdkUtils utils = new NdkUtils();
                mTvResult.setText(utils.getResult("test"));
            }
        });
    }
}
