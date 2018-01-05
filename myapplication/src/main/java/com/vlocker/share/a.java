package com.vlocker.share;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.vlocker.b.i;
import com.vlocker.locker.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class a implements Runnable {
    final /* synthetic */ ShareActivity a;

    a(ShareActivity shareActivity) {
        this.a = shareActivity;
    }

    public void run() {
        Exception e;
        Throwable th;
        File file = new File(i.l);
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = file.listFiles();
        if (listFiles.length > 0) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        BufferedOutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(i.l + "main_icon.png")));
            try {
                BitmapFactory.decodeResource(this.a.getResources(), R.drawable.main_icon).compress(CompressFormat.PNG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            bufferedOutputStream = null;
            e.printStackTrace();
            bufferedOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            bufferedOutputStream.close();
            throw th;
        }
    }
}
