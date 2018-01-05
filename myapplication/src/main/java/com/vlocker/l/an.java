package com.vlocker.l;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.Html;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ag;

public class an extends a {
    private boolean c;

    public an(Context context, ag agVar) {
        super(context, agVar);
    }

    public void a() {
        a("android.settings.WIFI_SETTINGS");
    }

    public boolean a(int i) {
        return false;
    }

    public boolean a(b bVar) {
        try {
            WifiManager wifiManager = (WifiManager) this.b.getSystemService(IXAdSystemUtils.NT_WIFI);
            if (wifiManager != null) {
                if (b.SWITCH_OFF == bVar) {
                    this.c = false;
                } else if (b.SWITCH_ON == bVar) {
                    this.c = true;
                }
                new Thread(new ao(this, wifiManager)).start();
                c();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int b() {
        WifiManager wifiManager = (WifiManager) this.b.getSystemService(IXAdSystemUtils.NT_WIFI);
        return (wifiManager == null || !wifiManager.isWifiEnabled()) ? 0 : 1;
    }

    public void c() {
        CharSequence fromHtml;
        String string = this.b.getString(R.string.toast_type_wifi);
        if (this.c) {
            fromHtml = Html.fromHtml(this.b.getString(R.string.toast_template_on, new Object[]{string}));
        } else {
            fromHtml = Html.fromHtml(this.b.getString(R.string.toast_template_off, new Object[]{string}));
        }
        a(fromHtml);
    }
}
