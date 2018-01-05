package com.vlocker.setting.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;

public class a {
    private static final LayoutParams a(int i, int i2) {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.systemUiVisibility = 1;
        if (i > 0) {
            layoutParams.type = 2003;
        } else {
            layoutParams.type = 2010;
        }
        if (com.vlocker.setting.a.a.getInstance().hasRomReature("huawei_em2+")) {
            layoutParams.type = 2005;
        }
        if (com.vlocker.setting.a.a.getInstance().hasRomReature("funtouch(5.0+)") || com.vlocker.setting.a.a.getInstance().hasRomReature("oppo_coloros_v2.1")) {
            layoutParams.type = 2005;
        }
        if (MoSecurityApplication.e || com.vlocker.setting.a.a.getInstance().hasRomReature("360UI")) {
            layoutParams.type = 2005;
        }
        layoutParams.screenOrientation = 1;
        layoutParams.gravity = 48;
        layoutParams.format = 1;
        layoutParams.flags = 264072;
        layoutParams.width = -1;
        layoutParams.height = i;
        layoutParams.y = i2;
        return layoutParams;
    }

    public static final void a(Context context) {
        View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.guide_setting_manual, null);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(119, 0, 0);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }

    @SuppressLint({"InflateParams"})
    public static final void a(Context context, String str) {
        Log.e(a.class.getSimpleName(), "alertToastDialog");
        View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.setting_alert_guide_banner, null);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(119, 0, 0);
        ((TextView) inflate.findViewById(R.id.alert_text)).setText(str);
        toast.setView(inflate);
        toast.show();
    }

    public static final void a(WindowManager windowManager, View view) {
        a(windowManager, view, a(-1, 0));
    }

    public static final void a(WindowManager windowManager, View view, int i) {
        b(windowManager, view, i, 0);
    }

    public static final void a(WindowManager windowManager, View view, int i, int i2) {
        LayoutParams a = a(i, i2);
        a.flags = 1976;
        a(windowManager, view, a);
    }

    private static final void a(WindowManager windowManager, View view, LayoutParams layoutParams) {
        try {
            if (view.getParent() == null) {
                windowManager.addView(view, layoutParams);
            }
        } catch (Exception e) {
        }
    }

    public static final void b(Context context, String str) {
        View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.guide_setting_yunos, null);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(55, 0, 0);
        toast.setDuration(1);
        ((TextView) inflate.findViewById(R.id.alert_text)).setText(str);
        toast.setView(inflate);
        toast.show();
    }

    public static final void b(WindowManager windowManager, View view) {
        try {
            if (view.getParent() != null) {
                windowManager.removeView(view);
            }
        } catch (Exception e) {
        }
    }

    public static final void b(WindowManager windowManager, View view, int i, int i2) {
        a(windowManager, view, a(i, i2));
    }
}
