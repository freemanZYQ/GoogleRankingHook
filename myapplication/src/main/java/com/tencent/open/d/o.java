package com.tencent.open.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.a.j;
import java.lang.ref.WeakReference;
import java.net.URL;

public class o {
    private static o a = null;
    private volatile WeakReference b = null;

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (a == null) {
                a = new o();
            }
            oVar = a;
        }
        return oVar;
    }

    public String a(Context context, String str) {
        if (this.b == null || this.b.get() == null) {
            this.b = new WeakReference(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            Object host = new URL(str).getHost();
            if (host == null) {
                j.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
            } else {
                Object string = ((SharedPreferences) this.b.get()).getString(host, null);
                if (string == null || host.equals(string)) {
                    j.a("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
                } else {
                    str = str.replace(host, string);
                    j.a("openSDK_LOG.ServerSetting", "return environment url : " + str);
                }
            }
        } catch (Exception e) {
            j.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
        }
        return str;
    }
}
