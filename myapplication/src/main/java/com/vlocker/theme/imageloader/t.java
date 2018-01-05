package com.vlocker.theme.imageloader;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import com.vlocker.b.i;
import java.io.File;

public class t {
    public int a = 5120;
    public int b = 10485760;
    public int c = 0;
    public File d = new File(this.j);
    public CompressFormat e = r.c;
    public int f = 100;
    public boolean g = true;
    public boolean h = true;
    public boolean i = false;
    public String j = i.h;

    public t(Context context) {
    }

    public void a(float f) {
        if (f < 0.01f || f > 0.8f) {
            throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.01 and 0.8 (inclusive)");
        }
        this.a = Math.round((((float) Runtime.getRuntime().maxMemory()) * f) / 1024.0f);
    }
}
