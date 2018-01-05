package com.vlocker.m;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import com.vlocker.c.a;

public class g {
    public static Drawable a(Drawable drawable, int i) {
        if (i != -1) {
            drawable.setColorFilter(i, Mode.SRC_IN);
        }
        return drawable;
    }

    public static void a(Context context) {
        a a = a.a(context);
        int g = y.g(context);
        if (g != 0) {
            a.b(g);
            a.c(255);
        }
    }
}
