package com.vlocker.ui.view;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class n implements Runnable {
    Context a;
    String b;
    Handler c;

    public n(Context context, Handler handler, String str) {
        this.a = context;
        this.c = handler;
        this.b = str;
    }

    public static final String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll("[^a-zA-Z0-9]", "").replaceAll("\\s+", "_");
    }

    private void a(int i, Object obj) {
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = obj;
        this.c.sendMessage(obtainMessage);
    }

    public String a(Context context) {
        return Environment.getExternalStorageDirectory().toString() + "/moxiu/temp/";
    }

    public String a(Context context, String str) {
        String a = a(context);
        File file = new File(a);
        if (!file.exists()) {
            file.mkdirs();
        }
        String a2 = a(str);
        return (a2 == null || a2.length() <= 0) ? null : a + a2;
    }

    public void a(byte[] bArr, File file) {
        if (bArr == null || bArr.length < 100) {
            Log.d("fetcher", "data write fail");
            return;
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public byte[] a(String str, byte[] bArr, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        try {
            byte[] c = c(str);
            a(c, file);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] b(Context context, String str) {
        byte[] b;
        String a = a(context, str);
        try {
            b = b(a);
        } catch (Exception e) {
            e.printStackTrace();
            b = null;
        }
        return b == null ? a(str, b, a) : b;
    }

    public byte[] b(String str) {
        if (!new File(str).exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayOutputStream.close();
                fileInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public byte[] c(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection.getResponseCode() == 200 ? a(httpURLConnection.getInputStream()) : null;
    }

    public void run() {
        try {
            Object b = b(this.a, this.b);
            if (b != null) {
                a(817, b);
            } else {
                a(820, (Object) "fetch data null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            a(820, (Object) "fetch data exception");
        } catch (Error e2) {
            e2.printStackTrace();
            a(820, (Object) "fetch data error");
        }
    }
}
