package com.substrate.java.gp;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Environment;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by apple on 16/12/14.
 */
public class FbUtils {

    public Context context;
    public String input = ", dalvik.system.VMStack.getThreadStackTrace, java.lang.Thread.getStackTrace, java.util.concurrent.Executors$RunnableAdapter.call";
    private static final char[] d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public FbUtils(Context context){
        this.context = context;
    }

    public void run(){
        String str1 = a(input.getBytes(),"SHA-1");
        String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        a(str1,"AES","AES/CBC/PKCS5Padding","droidguard/droidguasso.enc",rootPath+"/f.apk");
    }

    private void a(String str, String str2, String str3, String str4, String str5) {
        try {
            byte[] bArr = new byte[16];
            byte[] bytes = str.getBytes();
            int i = 0;
            while (i < bArr.length && i < bytes.length) {
                bArr[i] = bytes[i];
                i++;
            }
            Key secretKeySpec = new SecretKeySpec(bArr, str2);
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{(byte) 1, (byte) 33, (byte) 13, (byte) 28, (byte) 87, (byte) 122, (byte) 25, (byte) 5, (byte) 4, (byte) 30, (byte) 22, (byte) 101, (byte) 5, (byte) 50, (byte) 12, (byte) 0});
            AssetFileDescriptor openFd = this.context.getAssets().openFd(str4);
            int length = (int) openFd.getLength();
            openFd.close();
            bArr = new byte[length];
            InputStream open = this.context.getAssets().open(str4);
            open.read(bArr);
            open.close();
            Cipher e = e(str3);
            if (e != null) {
                e.init(2, secretKeySpec, ivParameterSpec);
                byte[] doFinal = e.doFinal(bArr);
                FileOutputStream fileOutputStream = new FileOutputStream(str5);
                fileOutputStream.write(doFinal);
                fileOutputStream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String a(byte[] bArr, String str) {
        MessageDigest a = a(str);
        if (a != null) {
            return a(a.digest(bArr), false).toLowerCase();
        }
        return "";
    }

    public static MessageDigest a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }
    public static String a(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(length * 2);
        int i = 0;
        while (i < length && (!z || i != length - 1 || (bArr[i] & 255) != 0)) {
            stringBuilder.append(d[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(d[bArr[i] & 15]);
            i++;
        }
        return stringBuilder.toString();
    }


    public static Cipher e(String str) {
        int i = 0;
        while (i < 2) {
            try {
                Cipher instance = Cipher.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
