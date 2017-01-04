package com.googleranking.hack;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import dalvik.system.DexClassLoader;

/**
 * Created by apple on 16/12/11.
 */
public class NdkUtilsHookHelper {

    public static String TAG = "ndkUtilsHelper";
    public static String className = "com.ndk.test.two.NdkUtils";
    public String test(Context context) throws Exception{
        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        File dirFile = new File(root,"ndktools");
//        File optFile = new File();
        File libFile = new File(dirFile,"lib");
        File apkFile = new File(dirFile,"the.apk");
        DexClassLoader classLoader = new DexClassLoader(apkFile.getAbsolutePath(),context.getDir("dex",0).getAbsolutePath(),libFile.getAbsolutePath(),ClassLoader.getSystemClassLoader());

        Class<?> clazz;
        clazz = classLoader.loadClass(className);

        Constructor constructor = clazz.getConstructor(new Class[] {});
        Object instance = constructor.newInstance(new Object[] {});
//        Object instance = clazz
//                .getDeclaredConstructor()
//                .newInstance();
        Log.d(TAG,"clazz invoke:"+clazz);

        Method method = clazz.getMethod("getResultTest",String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(instance,"hello");
        return result;
    }

}
