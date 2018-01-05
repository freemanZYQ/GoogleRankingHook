package com.vlocker.share;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import com.vlocker.b.i;
import com.vlocker.theme.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

class j implements Runnable {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public void run() {
        Exception e;
        Throwable th;
        File file = new File(i.l);
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        BufferedOutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(i.l + this.a.j + ".png")));
            try {
                this.a.p = this.a.a(((BitmapDrawable) c.d(this.a.e, this.a.k)).getBitmap());
                this.a.p.compress(CompressFormat.PNG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                this.a.o = true;
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    e2.printStackTrace();
                    this.a.o = true;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            bufferedOutputStream = null;
            e22.printStackTrace();
            this.a.o = true;
            bufferedOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            bufferedOutputStream.close();
            throw th;
        }
    }
}
