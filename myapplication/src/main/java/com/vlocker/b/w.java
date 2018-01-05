package com.vlocker.b;

import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class w {
    public static void a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static synchronized void a(byte[] bArr) {
        synchronized (w.class) {
            try {
                a(Environment.getExternalStorageDirectory().toString() + "/vlocker");
                a(Environment.getExternalStorageDirectory().toString() + "/vlocker/log");
                FileOutputStream fileOutputStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory().toString() + "/vlocker/log" + "/huoyue"), true);
                fileOutputStream.write(bArr);
                fileOutputStream.write("\n".getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
            }
        }
    }
}
