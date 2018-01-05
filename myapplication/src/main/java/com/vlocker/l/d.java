package com.vlocker.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.Html;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ag;
import java.lang.reflect.Method;

public class d extends a {
    private boolean c;

    public d(Context context, ag agVar) {
        super(context, agVar);
    }

    private boolean f() {
        TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
        return (telephonyManager == null || telephonyManager.getSimState() == 1 || telephonyManager.getSimState() == 0) ? false : true;
    }

    public void a() {
        if (!f()) {
            return;
        }
        if (VERSION.SDK_INT >= 20) {
            e();
        } else {
            a("android.settings.DATA_ROAMING_SETTINGS");
        }
    }

    public boolean a(int i) {
        return false;
    }

    public boolean a(b bVar) {
        try {
            if (f()) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
                    this.c = false;
                    if (b.SWITCH_OFF == bVar) {
                        this.c = false;
                    } else if (b.SWITCH_ON == bVar) {
                        this.c = true;
                    }
                    Method method = ConnectivityManager.class.getMethod("setMobileDataEnabled", new Class[]{Boolean.TYPE});
                    method.setAccessible(true);
                    method.invoke(connectivityManager, new Object[]{Boolean.valueOf(this.c)});
                    c();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    e();
                    return false;
                }
            }
            a(this.b.getString(R.string.toast_no_sim_txt));
            return false;
        } catch (Exception e2) {
        }
    }

    public int b() {
        if (f()) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
            try {
                Method method = ConnectivityManager.class.getMethod("getMobileDataEnabled", new Class[0]);
                method.setAccessible(true);
                this.c = ((Boolean) method.invoke(connectivityManager, new Object[0])).booleanValue();
                if (this.c) {
                    return 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void c() {
        CharSequence fromHtml;
        String string = this.b.getString(R.string.toast_type_data);
        if (this.c) {
            fromHtml = Html.fromHtml(this.b.getString(R.string.toast_template_on, new Object[]{string}));
        } else {
            fromHtml = Html.fromHtml(this.b.getString(R.string.toast_template_off, new Object[]{string}));
        }
        a(fromHtml);
    }

    public void d() {
        String str = null;
        try {
            if (VERSION.SDK_INT >= 20) {
                String str2;
                Intent intent;
                switch (j.i()) {
                    case 0:
                        str2 = "com.android.phone";
                        str = "com.android.phone.MiuiMobileNetworkSettings";
                        break;
                    case 1:
                        str2 = "com.android.phone";
                        str = "com.android.phone.Settings";
                        break;
                    case 2:
                        Intent intent2 = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
                        intent2.addFlags(268435456);
                        this.b.startActivity(intent2);
                        str2 = null;
                        break;
                    case 3:
                        str2 = "com.android.phone";
                        str = "com.android.phone.MobileNetworkSettings";
                        break;
                    case 4:
                        str2 = null;
                        break;
                    case 5:
                        str2 = "com.android.settings";
                        str = "com.android.settings.Settings$DataUsageSummaryActivity";
                        break;
                    case 6:
                        intent = new Intent();
                        intent.setAction("android.intent.action.MAIN");
                        intent.setComponent(new ComponentName("com.lenovo.simsettings", "com.lenovo.simsettings.MobileNetworkSettings"));
                        intent.addFlags(268435456);
                        this.b.startActivity(intent);
                        return;
                    case 7:
                        intent = new Intent();
                        intent.setAction("android.intent.action.MAIN");
                        ComponentName componentName = new ComponentName("com.android.phone", "com.android.phone.Settings");
                        intent.addFlags(268435456);
                        intent.setComponent(componentName);
                        this.b.startActivity(intent);
                        return;
                    default:
                        str2 = null;
                        break;
                }
                intent = new Intent("android.settings.DATA_ROAMING_SETTINGS");
                intent.setComponent(new ComponentName(str2, str));
                intent.addFlags(268435456);
                this.b.startActivity(intent);
            }
        } catch (Exception e) {
        }
    }

    public void e() {
        this.a.a(new e(this), (byte) 4);
    }
}
