package com.vlocker.l;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.provider.Settings.System;
import android.text.Html;
import android.text.TextUtils;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ag;
import com.vlocker.theme.f.b;

public class h extends a {
    public h(Context context, ag agVar) {
        super(context, agVar);
    }

    private Intent a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName(str, str2);
        return intent;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i;
        boolean z;
        try {
            i = Intent.class.getField("FLAG_ACTIVITY_CLEAR_TASK").getInt(null);
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
            z = false;
        }
        Intent intent = new Intent();
        intent.setAction(str);
        intent.addFlags(268435456);
        if (z) {
            intent.addFlags(i);
        }
        if (com.vlocker.m.h.b(this.b, intent) != 0) {
            return false;
        }
        e();
        return true;
    }

    private void e() {
        new Thread(new i(this)).start();
    }

    public void a() {
        if (!b(b.y() ? "android.settings.SETTINGS" : "android.settings.AIRPLANE_MODE_SETTINGS")) {
            try {
                this.b.startActivity(c());
            } catch (Exception e) {
            }
        }
    }

    public boolean a(int i) {
        return false;
    }

    public boolean a(b bVar) {
        try {
            if (VERSION.SDK_INT >= 17) {
                return false;
            }
            int i = b.SWITCH_OFF == bVar ? 0 : b.SWITCH_ON == bVar ? 1 : 0;
            System.putInt(this.b.getContentResolver(), "airplane_mode_on", i);
            Intent intent = new Intent("android.intent.action.AIRPLANE_MODE");
            intent.putExtra("state", i == 1);
            this.b.sendBroadcast(intent);
            d();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int b() {
        try {
            ContentResolver contentResolver = this.b.getContentResolver();
            if (VERSION.SDK_INT < 17) {
                return System.getInt(contentResolver, "airplane_mode_on");
            }
            for (Class cls : Settings.class.getDeclaredClasses()) {
                if (cls.getSimpleName().equals("Global")) {
                    return ((Integer) cls.getMethod("getInt", new Class[]{ContentResolver.class, String.class}).invoke(null, new Object[]{contentResolver, "airplane_mode_on"})).intValue();
                }
            }
            return System.getInt(contentResolver, "airplane_mode_on");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Intent c() {
        Intent a = a("com.android.settings", "com.android.settings.WirelessSettings");
        a.setFlags(335544320);
        if (!com.vlocker.m.h.a(this.b, a)) {
            a.setClassName("com.android.settings", "com.android.settings.Settings$WirelessSettingsActivity");
        }
        return a;
    }

    public void d() {
        CharSequence fromHtml;
        String string = this.b.getString(R.string.toast_type_airplane);
        if (b() == 1) {
            fromHtml = Html.fromHtml(this.b.getString(R.string.toast_template_on, new Object[]{string}));
        } else {
            fromHtml = Html.fromHtml(this.b.getString(R.string.toast_template_off, new Object[]{string}));
        }
        a(fromHtml);
    }
}
