package com.baidu.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.location.a.a;
import com.baidu.location.b.d;
import com.baidu.location.b.h;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;

public class f extends Service {
    public static boolean isServing = false;
    public static Context mC = null;
    public static String replaceFileName = "repll.jar";
    LLSInterface a = null;
    LLSInterface b = null;
    LLSInterface c = null;

    private boolean a(File file) {
        boolean z = false;
        try {
            File file2 = new File(d.a + "/grtcf.dat");
            if (file2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(200);
                if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean()) {
                    int readInt = randomAccessFile.readInt();
                    if (readInt != 0) {
                        byte[] bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        String str = new String(bArr);
                        String a = h.a(file);
                        if (!(str == null || a == null || !a.equals(str))) {
                            z = true;
                        }
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        return z;
    }

    public static float getFrameVersion() {
        return 6.05f;
    }

    public static String getJarFileName() {
        return "app.jar";
    }

    public static Context getServiceContext() {
        return mC;
    }

    public IBinder onBind(Intent intent) {
        return this.c.onBind(intent);
    }

    public void onCreate() {
        mC = getApplicationContext();
        System.currentTimeMillis();
        this.b = new a();
        try {
            File file = new File(h.g() + File.separator + replaceFileName);
            File file2 = new File(h.g() + File.separator + "app.jar");
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            if (file2.exists()) {
                this.a = (LLSInterface) new DexClassLoader(h.g() + File.separator + "app.jar", h.g(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
            }
        } catch (Exception e) {
            this.a = null;
        }
        if (this.a == null || this.a.getVersion() < this.b.getVersion() || !a(new File(h.g() + File.separator + "app.jar"))) {
            this.c = this.b;
            this.a = null;
        } else {
            this.c = this.a;
            this.b = null;
        }
        isServing = true;
        this.c.onCreate(this);
    }

    public void onDestroy() {
        isServing = false;
        this.c.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return this.c.onStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return this.c.onUnBind(intent);
    }
}
