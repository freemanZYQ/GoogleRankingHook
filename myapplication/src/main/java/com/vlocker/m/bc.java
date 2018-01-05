package com.vlocker.m;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.theme.f.b;

public class bc {
    public static LayoutParams a(Context context, WindowManager windowManager) {
        int i = 0;
        LayoutParams layoutParams = new LayoutParams();
        if (j.a(windowManager)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.y = 0;
            layoutParams.width = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            layoutParams.height = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels) + j.g();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                layoutParams.width += j.g();
                layoutParams.height -= j.g();
            }
            layoutParams.gravity = 48;
            layoutParams.flags = 155714048;
            layoutParams.type = 2005;
            layoutParams.softInputMode = 16;
            layoutParams.screenOrientation = 1;
            layoutParams.format = -3;
            layoutParams.systemUiVisibility = VERSION.SDK_INT >= 19 ? 5890 : 1795;
        } else {
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.format = -3;
            layoutParams.screenOrientation = 1;
            if (!(b.m() && b.a(context) && !b.a(context, 24))) {
                i = 1;
            }
            if (i != 0) {
                if (a.a(context).aj() == 0 || a.a(context).ai() == 0) {
                    layoutParams.type = 2002;
                } else {
                    layoutParams.type = 2010;
                }
            } else if (VERSION.SDK_INT < 20) {
                layoutParams.type = 2010;
            } else if (VERSION.SDK_INT >= 20) {
                layoutParams.type = 2005;
            }
            layoutParams.flags = 21103616;
            if (VERSION.SDK_INT >= 19 || a.a(context).ai() != 0) {
                layoutParams.flags |= 256;
            }
        }
        layoutParams.packageName = context.getPackageName();
        return layoutParams;
    }
}
