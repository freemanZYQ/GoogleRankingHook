package com.vlocker.l;

import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.text.Html;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ag;

public class c extends a {
    public c(Context context, ag agVar) {
        super(context, agVar);
    }

    public void a() {
        a("android.settings.DISPLAY_SETTINGS");
    }

    public boolean a(int i) {
        if (i >= -1 && i < 255) {
            try {
                if (i != c()) {
                    System.putInt(this.b.getContentResolver(), "screen_brightness", i);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(b bVar) {
        try {
            int i = b.SWITCH_OFF == bVar ? 0 : b.SWITCH_ON == bVar ? 1 : 0;
            System.putInt(this.b.getContentResolver(), "screen_brightness_mode", i);
            d();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int b() {
        try {
            return System.getInt(this.b.getContentResolver(), "screen_brightness_mode") == 1 ? 1 : 0;
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void b(int i) {
        if (b() == 1) {
            a(Html.fromHtml(this.b.getString(R.string.toast_template_brightness_auto)));
            return;
        }
        a(Html.fromHtml(this.b.getString(R.string.toast_template_brightness_r2, new Object[]{"" + ((i * 100) / 255)})));
    }

    public int c() {
        try {
            return System.getInt(this.b.getContentResolver(), "screen_brightness");
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void d() {
        b(c() + 26);
    }
}
