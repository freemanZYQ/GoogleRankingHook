package com.substrate.java.gp;

import android.content.Context;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

import com.saurik.substrate.MS;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import defpackage.cpp;

/**
 * Created by apple on 16/12/12.
 */
public class Main {

    public static String TAG = "native_hook";
    public static boolean isNewFile = true;
    static void initialize(){
        Log.d(TAG,"initialize");
        MS.hookClassLoad("com.google.ccc.abuse.droidguard.DroidGuard", new MS.ClassLoadHook() {
            @Override
            public void classLoaded(Class<?> clazz) {
                Log.d(TAG,"classLoaded "+isNewFile);
                Constructor constructorMethod = null;
//                try{
//                    constructorMethod = clazz.getConstructor(Context.class,String.class,byte[].class,Object.class);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//                if(constructorMethod != null){
//                    MS.hookMethod(clazz, constructorMethod,
//                            new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//
//                                Log.d(TAG,"objects.size:"+objects.length);
//                                Context context = (Context) objects[0];
//                                String type = (String) objects[1];
//                                byte[] data = (byte[]) objects[2];
//                                Object callback = objects[3];
//                                Log.d(TAG, "context:" + context);
//                                Log.d(TAG, "type:" + type);
//                                Log.d(TAG, "data:" + new String(data));
//
//                                String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
//                                if(isNewFile) {
//                                    File gpDataFile = new File(rootPath,"gpData");
//                                    if(gpDataFile.exists()){
//                                        gpDataFile.delete();
//                                    }
//                                    FileUtils.createFile(gpDataFile.getAbsolutePath(),data);
//                                    Log.d(TAG,"保存大小是:"+data.length);
//                                    Log.d(TAG,"文件大小是:"+gpDataFile.length());
//                                }else{
//                                    File file = new File(rootPath,"response");
//                                    byte[] array = FileUtils.toByteArray(file);
//                                    DroidGuard.SignedDGResponse signedDGResponse = DroidGuard.SignedDGResponse.parseFrom(array);
//                                    Log.d(TAG,"datas:"+new String(signedDGResponse.getData().toByteArray()));
//                                    data = signedDGResponse.getData().toByteArray();
//                                    DroidGuard.DGResponse dgResponse = DroidGuard.DGResponse.parseFrom(data);
//                                    Log.d(TAG,"dgData:"+new String(dgResponse.getByteCode().toByteArray()));
//                                    Log.d(TAG,"dgCheckSum:"+new String(dgResponse.getVmChecksum().toByteArray()));
//                                    Log.d(TAG,"传进来大小是:"+dgResponse.getByteCode().toByteArray().length);
////                                    File newFile = new File(rootPath,"gpData1");
////                                    if(newFile.exists()){
////                                        newFile.delete();
////                                    }
////                                    FileUtils.createFile(newFile.getAbsolutePath(),data);
////                                    Log.d(TAG,"传进来大小是:"+data.length);
////                                    Log.d(TAG,"文件大小是:"+newFile.length());
////                                    File oldGpDataFile = new File(rootPath,"gpData");
////                                    data = FileUtils.toByteArray(oldGpDataFile);
////                                    Log.d(TAG,"原本文件大小:"+oldGpDataFile.length());
////                                    Log.d(TAG,"原本大小是:"+data.length);
//                                    objects[2]=dgResponse.getByteCode().toByteArray();
//                                }
//                                Log.d(TAG, "callback:" + callback);
//                            return invoke(o,context,type,data,callback);
//                        }
//                    });
//                }

                Method runMethod = null;
                try{
                    runMethod = clazz.getDeclaredMethod("run",Map.class);
                }catch (Exception e){
                    e.printStackTrace();
                }


                if(runMethod != null){
                    MS.hookMethod(clazz, runMethod, new MS.MethodAlteration<Object, byte[]>() {
                        @Override
                        public byte[] invoked(Object o, Object... objects) throws Throwable {
                            try {
                                Object first = objects[0];
                                Map<String, String> map = (Map<String, String>) first;
                                for(Map.Entry<String,String> entry:map.entrySet()){
                                    Log.d(TAG,entry.getKey()+"-->"+entry.getValue());
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            byte[] result = invoke(o,objects);
                            Log.d(TAG,"result.length:"+result.length);
                            String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                            File runResultFile ;
                            if(isNewFile) {
                                runResultFile = new File(rootPath, "newRunResult");
                                if(runResultFile.exists()){
                                    runResultFile.delete();
                                }
                            }else{
                                runResultFile = new File(rootPath,"oldRunResult");
                                if(runResultFile.exists()){
                                    runResultFile.delete();
                                }
                            }
                            FileUtils.createFile(runResultFile.getAbsolutePath(),(Base64.encodeToString(result, 11)).getBytes());
                            Log.d(TAG,"result:"+new String(result));
                            Log.d(TAG,"runResult文件大小是:"+runResultFile.length());

//                            byte[] result1 = invoke(o,objects);
//                            Log.d(TAG,"result1.length:"+result1.length);
//                            String rootPath1 = Environment.getExternalStorageDirectory().getAbsolutePath();
//                            File runResultFile1 ;
//                            if(isNewFile) {
//                                runResultFile1 = new File(rootPath1, "newRunResultnew");
//                                if(runResultFile1.exists()){
//                                    runResultFile1.delete();
//                                }
//                            }else{
//                                runResultFile1 = new File(rootPath1,"oldRunResultold");
//                                if(runResultFile1.exists()){
//                                    runResultFile1.delete();
//                                }
//                            }
//
//                            FileUtils.createFile(runResultFile1.getAbsolutePath(), (Base64.encodeToString(result1, 11)).getBytes());
//                            Log.d(TAG,"result1:"+new String(result1));
//                            Log.d(TAG,"runResult1文件大小是:"+runResultFile1.length());

                            return result;
                        }
                    });
                }
            }
        });

        MS.hookClassLoad("cpj", new MS.ClassLoadHook() {
            @Override
            public void classLoaded(Class<?> clazz) {
                Log.d(TAG,"cpj classLoaded");

                Method method = null;
                try{
                    method = clazz.getDeclaredMethod("a",byte[].class);
                }catch (Exception e){
                    Log.d(TAG,e.getMessage());
                    e.printStackTrace();
                }
                Log.d(TAG,"cpj method:"+method);
                if(method != null){
                    MS.hookMethod(clazz, method, new MS.MethodAlteration() {
                        @Override
                        public Object invoked(Object o, Object... objects) throws Throwable {
                            byte[] input = (byte[])objects[0];
                            Log.d(TAG,"cpj/a/input:"+new String(input));
                            String result = (String)invoke(o,input);
                            Log.d(TAG,"cpj/a/out:"+result);
                            input("dgC/cpj/a","out",result.getBytes());
                            return result;
                        }
                    });
                }
            }
        });

//        MS.hookClassLoad("cpr", new MS.ClassLoadHook() {
//                    @Override
//                    public void classLoaded(Class<?> clazz) {
//                        Log.d(TAG,"cpr classLoaded");
//                        Constructor constructorMethod = null;
//                        try{
//                            constructorMethod = clazz.getConstructor(String.class,Context.class,Throwable.class);
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//
//                        if(constructorMethod != null){
//                            MS.hookMethod(clazz, constructorMethod, new MS.MethodAlteration() {
//                                @Override
//                                public Object invoked(Object o, Object... objects) throws Throwable {
//                                    try {
//                                        Log.d(TAG, "string:" + objects[0]);
//                                        input("dgC/cpr/con","input",((String)(objects[0])).getBytes());
//                                        Log.d(TAG, "context:" + objects[1]);
//                                        Log.d(TAG, "throwable:" + objects[2]);
//                                    }catch (Exception e){
//                                        Log.e(TAG,e.getMessage());
//                                        e.printStackTrace();
//                                    }
//                                    return invoke(o,objects);
//                                }
//                            });
//                        }
//
//                        Method aMethod = null;
//                        try{
//                    aMethod = clazz.getDeclaredMethod("a",Map.class,byte[].class);
//                }catch (Exception e) {
//                    Log.d(TAG, e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(aMethod != null){
//                    MS.hookMethod(clazz, aMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            Map map = (Map)objects[0];
//                            byte[] bytes = (byte[])objects[1];
//                            printMap(map);
//                            Log.d(TAG,"cpr/a/input2:"+new String(bytes));
//                            Log.d(TAG,"cpr/a/input2:"+bytes.length);
//                            input("dgC/cpr/a","input2",bytes);
//                            byte[] result = (byte[])invoke(o,objects);
//                            Log.d(TAG,"cpr/a/output:"+ new String(result));
//                            Log.d(TAG,"cpr/a/output:"+result.length);
//                            input("dgC/cpr/a","out",result);
//                            return result;
//                        }
//                    });
//                }
//            }
//        });
//
//        MS.hookClassLoad("cpy", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"hook cpy");
//                Constructor constructorMethod = null;
//                try{
//                    constructorMethod = clazz.getConstructor(String.class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(constructorMethod != null){
//                    MS.hookMethod(clazz, constructorMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            try {
//                                Log.d(TAG,"cpy con start");
//                                Log.d(TAG, "string:" + objects[0]);
//                                input("dgC/cpy/con","input",((String)(objects[0])).getBytes());
//                            }catch (Exception e){
//                                Log.e(TAG,e.getMessage());
//                                e.printStackTrace();
//                            }
//                            return invoke(o,objects);
//                        }
//                    });
//                }
//
//                Method method = null;
//                try{
//                    method = clazz.getDeclaredMethod("a",int[].class);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//                if(method != null){
//                    MS.hookMethod(clazz, method, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            Log.d(TAG,"cpy a start");
//                            int[] input = (int[])objects[0];
//                            Log.d(TAG, Arrays.toString(input));
//                            String result = (String) invoke(o,objects);
//                            Log.d(TAG,"cpy/a/out:"+result);
//                            return result;
//                        }
//                    });
//                }
//            }
//        });
//
//        MS.hookClassLoad("cpq", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"hook cpq");
//                Method aMethod = null;
//                try{
//                    aMethod = clazz.getDeclaredMethod("a",String.class,byte[].class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(aMethod != null){
//                    MS.hookMethod(clazz, aMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            String input1 = (String) objects[0];
//                            Log.d(TAG,"cpq/a/input1:"+input1);
////                            cpp cpp = (cpp) invoke(o,objects);
////                            Log.d(TAG,"cpq/a/output:"+ cpp.a+" "+cpp.b+" "+cpp.c);
////                            input("dgC/cpq/a","out",(cpp.a+" "+cpp.b+" "+cpp.c).getBytes());
//                            return invoke(o,objects);
//                        }
//                    });
//                }
//
//                Method secondMethod = null;
//                try{
//                    secondMethod = clazz.getDeclaredMethod("a",String.class,String.class,String.class,String.class,String.class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(secondMethod != null){
//                    MS.hookMethod(clazz, secondMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            String s1 = (String)objects[0];
//                            String s2 = (String)objects[1];
//                            String s3 = (String)objects[2];
//                            String s4 = (String)objects[3];
//                            String s5 = (String)objects[4];
//                            Log.d(TAG,"cpq/a/secondInput:"+s1+" "+s2+" "+s3+" "+s4+" "+s5);
//                            input("dgC/cpq/a","secondinput",(s1+" "+s2+" "+s3+" "+s4+" "+s5).getBytes());
//                            return invoke(o,objects);
//                        }
//                    });
//                }
//
//                Method thirdMethod = null;
//                try{
//                    thirdMethod = clazz.getDeclaredMethod("a",String.class,String[].class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//                if(thirdMethod != null){
//                    MS.hookMethod(clazz, thirdMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            String input1 = (String)objects[0];
//                            String[] input2 = (String[])objects[1];
//                            Log.d(TAG,"cpq/a/input1:"+input1+" "+input2);
//                            return invoke(o,objects);
//                        }
//                    });
//                }
//            }
//        });
//
//        MS.hookClassLoad("dalvik.system.DexClassLoader", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"dexClassLoader hook");
//                Constructor constructorMethod = null;
//                try{
//                    constructorMethod = clazz.getConstructor(String.class,String.class,String.class,ClassLoader.class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(constructorMethod != null){
//                    MS.hookMethod(clazz, constructorMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            String dexPath = (String)objects[0];
//                            String optimizedDirectory = (String)objects[1];
//                            String libraryPath = (String)objects[2];
//                            ClassLoader parent = (ClassLoader)objects[3];
//                            Log.d(TAG,"dexClassLoader/con:"+dexPath+" "+optimizedDirectory+" "+libraryPath+" "+parent);
//                            input("dgC/dexClassLoader/con","input",(dexPath+" "+optimizedDirectory+" "+libraryPath).getBytes());
//                            return invoke(o,objects);
//                        }
//                    });
//                }
//            }
//        });
//
////        MS.hookClassLoad("bpi", new MS.ClassLoadHook() {
////            @Override
////            public void classLoaded(Class<?> clazz) {
////                Log.d(TAG,"bpi hook");
////                Method method = null;
////                try{
////                    method = clazz.getDeclaredMethod("a",File.class);
////                }catch (Exception e){
////                    Log.d(TAG,e.getMessage());
////                    e.printStackTrace();
////                }
////
////                if(method != null){
////                    MS.hookMethod(clazz, method, new MS.MethodAlteration() {
////                        @Override
////                        public Object invoked(Object o, Object... objects) throws Throwable {
////                            File file = (File)objects[0];
////                            Log.d(TAG,"bpi/a/input:"+file.getAbsolutePath());
////                            return invoke(o,objects);
////                        }
////                    });
////                }
////            }
////        });
//
//        MS.hookClassLoad("bpv", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"bpv hook");
//                Method method = null;
//                try{
//                    method = clazz.getDeclaredMethod("a",byte[].class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//                if(method != null){
//                    MS.hookMethod(clazz, method, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            byte[] data = (byte[]) objects[0];
//                            Log.d(TAG,"bpv/a/input:"+new String(data));
//                            input("dgC/bpv/a/","input",data);
//                            byte[] result = (byte[]) invoke(o,objects);
//                            Log.d(TAG,"bpv/a/out:"+new String(result));
//                            input("dgC/bpv/a/","out",result);
//                            return result;
//                        }
//                    });
//                }
//
//                Method secondMethod = null;
//                try{
//                    secondMethod = clazz.getDeclaredMethod("a",byte[].class,String.class);
//                }catch (Exception e){
//                    Log.e(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//                if(secondMethod != null){
//                    MS.hookMethod(clazz, secondMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            byte[] data = (byte[])objects[0];
//                            String input = (String)objects[1];
//                            Log.d(TAG,"bpv/a/input:"+new String(data)+" "+input);
//                            String result = (String) invoke(o,objects);
//                            Log.d(TAG,"bpv/a/out:"+result);
//                            return result;
//                        }
//                    });
//                }
//            }
//        });
//
//        MS.hookClassLoad("cpv", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"cpv hook");
//                Method method = null;
//                try{
//                    method = clazz.getDeclaredMethod("a",byte[].class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(method != null){
//                    MS.hookMethod(clazz, method, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            byte[] input = (byte[])objects[0];
//                            Log.d(TAG,"cpv/a/input:"+new String(input));
//                            byte[] result = (byte[]) invoke(o,objects);
//                            Log.d(TAG,"cpv/a/output:"+new String(result));
//                            return result;
//                        }
//                    });
//                }
//
//                Method secondMethod = null;
//                try{
//                    secondMethod = clazz.getDeclaredMethod("b",byte[].class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(secondMethod != null){
//                    MS.hookMethod(clazz, secondMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            byte[] input = (byte[])objects[0];
//                            Log.d(TAG,"cpv/b/input:"+new String(input));
//                            byte[] result = (byte[]) invoke(o,objects);
//                            Log.d(TAG,"cpv/b/output:"+new String(result));
//                            return result;
//                        }
//                    });
//                }
//
//                Method thirdMethod = null;
//                try{
//                    thirdMethod = clazz.getDeclaredMethod("c",byte[].class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(thirdMethod != null){
//                    MS.hookMethod(clazz, thirdMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            Log.d(TAG,"cpv c(byte[])");
//                            byte[] input = (byte[])objects[0];
//                            Log.d(TAG,"cpv/c/input:"+new String(input));
//                            byte[] result = (byte[]) invoke(o,objects);
//                            Log.d(TAG,"cpv/c/output:"+new String(result));
//                            return result;
//                        }
//                    });
//                }
//
//                Method fourthMethod = null;
//                try{
//                    fourthMethod = clazz.getDeclaredMethod("a",int.class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(fourthMethod != null){
//                    MS.hookMethod(clazz, fourthMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            Log.d(TAG,"cpv a(int)");
//                            int i = (int)objects[0];
//                            Log.d(TAG,"cpv/a/input:"+i);
//                            byte[] result = (byte[])invoke(o,objects);
//                            Log.d(TAG,"cpv/a/output:"+new String(result));
//                            return result;
//                        }
//                    });
//                }
//            }
//        });
//
//        MS.hookClassLoad("cpu", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"cpu hook");
//                Method method = null;
//                try{
//                    method = clazz.getDeclaredMethod("a",String.class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(method != null){
//                    MS.hookMethod(clazz, method, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            String input = (String)objects[0];
//                            Log.d(TAG,"cpu/a/input:"+input);
//                            String result = (String)invoke(o,objects);
//                            Log.d(TAG,"cpu/a/out:"+result);
//                            return result;
//                        }
//                    });
//                }
//            }
//        });
//
//        MS.hookClassLoad("cps", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"cps hook");
//                Method method = null;
//                try{
//                    method = clazz.getDeclaredMethod("a");
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//                if(method != null){
//                    MS.hookMethod(clazz, method, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            String result = (String)objects[0];
//                            Log.d(TAG,"cps/a/out:"+result);
//                            return result;
//                        }
//                    });
//                }
//
//                Method secondMethod = null;
//                try{
//                    secondMethod = clazz.getDeclaredMethod("a",String.class,List.class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//                if(secondMethod != null){
//                    MS.hookMethod(clazz, secondMethod, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            String s1 = (String) objects[0];
//                            List list = (List)objects[1];
//                            Log.d(TAG,"cps/a/input:"+s1+" "+list);
//                            return invoke(o,objects);
//                        }
//                    });
//                }
//            }
//        });
//
//        MS.hookClassLoad("cpt", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"cpt hook");
//                Method method = null;
//                try{
//                    method = clazz.getDeclaredMethod("accept",File.class,String.class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//
//                if(method != null){
//                    MS.hookMethod(clazz, method, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            File file = (File)objects[0];
//                            String input = (String)objects[1];
//                            Log.d(TAG,"cpt/accept/input:"+file.getAbsolutePath()+" "+input);
//                            boolean result = (boolean)invoke(o,objects);
//                            Log.d(TAG,"cpt/accept/out:"+result);
//                            return result;
//                        }
//                    });
//                }
//            }
//        });
//
//        MS.hookClassLoad("java.util.Collections", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"collections.shuffle");
//                Method method = null;
//                try{
//                    method = clazz.getDeclaredMethod("shuffle",List.class, Random.class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//                if(method != null){
//                    MS.hookMethod(clazz, method, new MS.MethodAlteration() {
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
//                            Log.d(TAG,"collections.shuffle start");
//                            List<Character> list = (List<Character>)objects[0];
//                            StringBuilder sb = new StringBuilder();
//                            StringBuilder txt = new StringBuilder();
//                            for(int i=0;i<list.size();i++){
//                                sb.append(list.get(i)).append(",");
//                                txt.append(list.get(i)).append("\n");
//                            }
//                            Log.d(TAG,"字符列表是:"+sb.toString());
//                            String root = Environment.getExternalStorageDirectory().getAbsolutePath();
//                            FileUtils.writeFile(root+"/charList",txt.toString(),false);
//                            return invoke(o,objects);
//                        }
//                    });
//                }
//            }
//        });
//
//        MS.hookClassLoad("bpi", new MS.ClassLoadHook() {
//            @Override
//            public void classLoaded(Class<?> clazz) {
//                Log.d(TAG,"bpi hook");
//                Method method = null;
//                try{
//                    method = clazz.getDeclaredMethod("a",File.class);
//                }catch (Exception e){
//                    Log.d(TAG,e.getMessage());
//                    e.printStackTrace();
//                }
//                if(method != null) {
//                    MS.hookMethod(clazz,method,new MS.MethodAlteration(){
//                        @Override
//                        public Object invoked(Object o, Object... objects) throws Throwable {
////                            File file = (File)objects[0];
////                            String path = file.getAbsolutePath();
////                            int index = path.lastIndexOf("/");
////                            String tmpPath = path.substring(0,index);
////                            String name = path.substring(index+1,path.length());
////                            String tmp_name = file.getName()+"_tmp";
////                            Log.d(TAG,"文件路径是:"+path+" 文件名字:"+name+" tmpName:"+tmp_name+" tmpPath:"+tmpPath);
////                            if(file.exists()){
////                                boolean isDir = file.isDirectory();
////                                Log.d(TAG,"是否是文件夹:"+isDir);
////                                if(!isDir) {
////                                    boolean copySuccess = FileUtils.copyFile(path, tmpPath + "/" + tmp_name, true);
////                                    Log.d(TAG,"文件:"+name+(copySuccess?"复制成功":"复制失败"));
////                                }else{
////                                    boolean copySuccess = FileUtils.copyDirectory(path,tmpPath+"/"+tmp_name,true);
////                                    Log.d(TAG,"文件夹:"+name+(copySuccess?"复制成功":"复制失败"));
////                                }
////                            }else{
////                                Log.d(TAG,"文件不存在");
////                            }
//                            return invoke(o,objects);
//                        }
//                    });
//                }
//            }
//        });
    }

    public static void printMap(Map<Object,Object> map){
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                Log.d(TAG, entry.getKey() + "-->" + entry.getValue());
                sb.append(entry.getKey()).append("-->").append(entry.getValue()).append("\n");
            }
        }catch (Exception e){
            sb.append(e.getMessage());
        }
        input("dgC/cpr/a","input1",sb.toString().getBytes());
    }

    /**
     * 纪录存储到
     * @param fileName
     * @param data
     *
     */
    public static  void input(String dir,String fileName,byte[] data){
        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        File dirFile = new File(root,dir);
        if(dirFile.exists()){
            if(dirFile.isFile()){
                dirFile.delete();
                dirFile.mkdirs();
            }
        }else {
            dirFile.mkdirs();
        }

        File file = new File(dirFile.getAbsolutePath(),fileName);
        if(file.exists()){
            file.delete();
        }
        try {
            FileUtils.createFile(file.getAbsolutePath(), data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
