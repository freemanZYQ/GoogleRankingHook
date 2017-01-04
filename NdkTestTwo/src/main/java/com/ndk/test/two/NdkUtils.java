package com.ndk.test.two;

import android.util.Log;

/**
 * Created by apple on 16/12/11.
 */
public class NdkUtils {

    public NdkUtils(){
        System.loadLibrary("ndkUtils");
        Log.d("hhaha","haha");
    }

    public String saySomething(){
        Log.d("haha","hahah");
        return "hello";
    }

    public String getResultTest(String s){
        return getResult(s);
    }

    public native String getResult(String s);

}
