package com.inveno.se.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.inveno.se.d.ab;
import com.inveno.se.d.m;
import com.inveno.se.d.o;
import com.inveno.se.d.r;
import com.inveno.se.d.t;
import com.inveno.se.d.v;
import com.inveno.se.f.a;

public class p extends com.inveno.se.d.p {
    private static final Object e = new Object();
    private final v a;
    private final Config b;
    private final int c;
    private final int d;
    private q f;

    static int a(int i, int i2, int i3, int i4) {
        float f = 1.0f;
        while (((double) (f * 2.0f)) <= Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4))) {
            f *= 2.0f;
        }
        return (int) f;
    }

    private static int b(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (i == 0) {
            return (int) ((((double) i2) / ((double) i4)) * ((double) i3));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        return ((double) i) * d > ((double) i2) ? (int) (((double) i2) / d) : i;
    }

    private t b(m mVar) {
        Object decodeByteArray;
        byte[] bArr = mVar.b;
        Options options = new Options();
        if (this.c == 0 && this.d == 0) {
            options.inPreferredConfig = this.b;
            options.inSampleSize = 1;
            if (this.f != null) {
                this.f.a(options);
            }
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            a.a("bitmap", "data size imageloader:" + bArr.length);
            options.inJustDecodeBounds = true;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inPreferredConfig = Config.RGB_565;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int b = b(this.c, this.d, i, i2);
            int b2 = b(this.d, this.c, i2, i);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i, i2, b, b2);
            if (this.f != null) {
                this.f.a(options);
            }
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        return decodeByteArray == null ? t.a(new o()) : t.a(decodeByteArray, j.a(mVar));
    }

    protected t a(m mVar) {
        t b;
        synchronized (e) {
            try {
                b = b(mVar);
            } catch (Throwable e) {
                ab.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(mVar.b.length), i());
                b = t.a(new o(e));
            }
        }
        return b;
    }

    protected void a(Bitmap bitmap) {
        this.a.a(bitmap);
    }

    public r f() {
        return r.LOW;
    }
}
