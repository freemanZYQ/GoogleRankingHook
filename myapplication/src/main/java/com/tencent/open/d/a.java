package com.tencent.open.d;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import com.tencent.open.a.j;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class a {
    private static String c;
    private String a;
    private d b;
    private long d;
    private Handler e;
    private Runnable f = new c(this);

    public a(Activity activity) {
        this.e = new b(this, activity.getMainLooper());
    }

    public static Bitmap a(String str) {
        j.a("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            j.a("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            j.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            j.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }

    public void a(String str, d dVar) {
        j.a("AsynLoadImg", "--save---");
        if (str == null || str.equals("")) {
            dVar.a(1, null);
        } else if (u.a()) {
            c = Environment.getExternalStorageDirectory() + "/tmp/";
            this.d = System.currentTimeMillis();
            this.a = str;
            this.b = dVar;
            new Thread(this.f).start();
        } else {
            dVar.a(2, null);
        }
    }

    public boolean a(Bitmap bitmap, String str) {
        Throwable e;
        OutputStream outputStream;
        String str2 = c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
            str2 = str2 + str;
            j.a("AsynLoadImg", "saveFile:" + str);
            OutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2)));
            try {
                bitmap.compress(CompressFormat.JPEG, 80, bufferedOutputStream2);
                bufferedOutputStream2.flush();
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } catch (IOException e3) {
                e = e3;
                outputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    j.a("AsynLoadImg", "saveFile bmp fail---", e);
                    if (bufferedOutputStream != null) {
                        return false;
                    }
                    try {
                        bufferedOutputStream.close();
                        return false;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    e = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e42) {
                            e42.printStackTrace();
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                outputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw e;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            j.a("AsynLoadImg", "saveFile bmp fail---", e);
            if (bufferedOutputStream != null) {
                return false;
            }
            bufferedOutputStream.close();
            return false;
        }
    }
}
