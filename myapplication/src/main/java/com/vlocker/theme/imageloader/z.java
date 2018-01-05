package com.vlocker.theme.imageloader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class z extends BitmapDrawable {
    private int a = 0;
    private int b = 0;
    private boolean c;

    public z(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    private synchronized void a() {
        if (this.a <= 0 && this.b <= 0 && this.c && b()) {
            getBitmap().recycle();
        }
    }

    private synchronized boolean b() {
        boolean z;
        Bitmap bitmap = getBitmap();
        z = (bitmap == null || bitmap.isRecycled()) ? false : true;
        return z;
    }

    public void a(boolean z) {
        synchronized (this) {
            if (z) {
                this.b++;
                this.c = true;
            } else {
                this.b--;
            }
        }
        a();
    }

    public void b(boolean z) {
        synchronized (this) {
            if (z) {
                this.a++;
            } else {
                this.a--;
            }
        }
        a();
    }
}
