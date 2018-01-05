package com.vlocker.m.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.msg.an;
import com.vlocker.settings.GuideSettingListActivity;
import com.vlocker.settings.GuideWindowActivity;
import com.vlocker.theme.f.b;
import com.vlocker.ui.cover.k;

public class a {
    protected Context a;

    public a(Context context) {
        this.a = context;
    }

    public void a() {
        try {
            if (an.a(this.a)) {
                this.a.startActivity(an.a());
                GuideWindowActivity.b(this.a, 2);
                return;
            }
            GuideSettingListActivity.a(this.a);
        } catch (Exception e) {
        }
    }

    public void a(int i) {
        if (k.a(this.a)) {
            try {
                Intent intent;
                ComponentName componentName;
                if (b.e()) {
                    if (b.h()) {
                        intent = new Intent();
                        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ChooseLockGeneric"));
                        this.a.startActivity(intent);
                    } else if (b.j()) {
                        intent = new Intent();
                        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.SecuritySettings"));
                        this.a.startActivity(intent);
                    } else if (b.g()) {
                        intent = new Intent();
                        componentName = new ComponentName("com.android.settings", "com.android.settings.Settings$ScreenPasswordSettingsActivity");
                        intent.setFlags(268435456);
                        intent.setComponent(componentName);
                        this.a.startActivity(intent);
                    } else if (b.i()) {
                        intent = new Intent();
                        componentName = new ComponentName("com.android.settings", "com.android.settings.ChooseLockGeneric");
                        intent.setFlags(268435456);
                        intent.setComponent(componentName);
                        this.a.startActivity(intent);
                    }
                } else if (b.w()) {
                    intent = new Intent();
                    componentName = new ComponentName("com.android.settings", "com.android.settings.SecuritySettings");
                    intent.setFlags(268435456);
                    intent.setComponent(componentName);
                    this.a.startActivity(intent);
                } else if (b.F()) {
                    intent = new Intent();
                    intent.setComponent(new ComponentName("com.vivo.fingerprint", "com.vivo.fingerprint.FingerprintActivity"));
                    this.a.startActivity(intent);
                } else {
                    intent = new Intent("android.app.action.SET_NEW_PASSWORD");
                    intent.setFlags(268435456);
                    this.a.startActivity(intent);
                }
                GuideWindowActivity.b(this.a, i);
                return;
            } catch (Exception e) {
                return;
            }
        }
        Toast.makeText(this.a, R.string.no_system_lock, 1).show();
    }
}
