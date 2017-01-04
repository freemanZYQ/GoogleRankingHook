package com.ndk.test;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTvStartService;
    private TextView mTvStopService;
    private TextView mTvDebug;
    private EditText mEdtInputCode;

    static {
        System.loadLibrary("d56C9732651AC");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvStartService = (TextView)findViewById(R.id.start);
        mTvStopService = (TextView)findViewById(R.id.stop);
        mEdtInputCode = (EditText)findViewById(R.id.input);
        mTvDebug = (TextView)findViewById(R.id.debug);
        mTvStopService.setOnClickListener(this);
        mTvStartService.setOnClickListener(this);
        mTvDebug.setOnClickListener(this);

//        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    new DroidGuardHelper().guard(MainActivity.this);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.start:
                String input = mEdtInputCode.getText().toString();
                if(TextUtils.isEmpty(input)){
                    Toast.makeText(this,"没有代号",Toast.LENGTH_LONG).show();
                    return;
                }
                    HeartBeatRunnable.id = input;
                    Intent service = new Intent(this,BackgroundService.class);
                    startService(service);
                break;
            case R.id.stop:
                break;
            case R.id.debug:
                DroidGuardHelper droidGuardHelper = new DroidGuardHelper();
                String root = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(root,"response");
                try {
                    byte[] inputs = FileUtils.readStreamToEnd(new FileInputStream(file));
                    Log.d("droidguard","inputs.length:"+inputs.length);
                    droidGuardHelper.guardFromFile(this,"38bc5f6ef6639f1b","zhengyuqin128@gmail.com",inputs,"addAccount");
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }
}
