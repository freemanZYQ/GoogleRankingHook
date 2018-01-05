package com.vlocker.m;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.vlocker.security.MoSecurityApplication;

public class l {
    private static DisplayMetrics a = MoSecurityApplication.a().getResources().getDisplayMetrics();

    private static float a(int i, float f, DisplayMetrics displayMetrics) {
        switch (i) {
            case 1:
            case 2:
                return TypedValue.applyDimension(i, f, displayMetrics);
            case 6:
                return f / displayMetrics.density;
            case 7:
                return f / displayMetrics.scaledDensity;
            default:
                return 0.0f;
        }
    }

    public static int a() {
        return a.widthPixels;
    }

    public static int a(float f) {
        return (int) a(1, f, a);
    }

    public static int a(Context context) {
        return a.heightPixels;
    }

    public static int a(Context context, float f) {
        return (int) a(1, f, a);
    }

    public static void a(View view, int i, int i2) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            if (i != -3) {
                layoutParams.width = i;
            }
            if (i2 != -3) {
                layoutParams.height = i2;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                a(view, (RelativeLayout.LayoutParams) layoutParams, i, i2, i3, i4);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                a(view, (LinearLayout.LayoutParams) layoutParams, i, i2, i3, i4);
            } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                a(view, (FrameLayout.LayoutParams) layoutParams, i, i2, i3, i4);
            }
        }
    }

    private static void a(View view, MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static int b() {
        return a.heightPixels;
    }

    public static int b(float f) {
        return (int) a(2, f, a);
    }

    public static int c(float f) {
        return (int) a(7, f, a);
    }
}
