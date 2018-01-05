package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.g;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

final class ah implements Runnable {
    private Context a = null;
    private Map b = null;
    private y c = null;

    public ah(Context context) {
        this.a = context;
        this.c = null;
    }

    private static u a(String str, int i) {
        Throwable th;
        u uVar = new u();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            uVar.a(str);
            uVar.b(i);
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            uVar.a(System.currentTimeMillis() - currentTimeMillis);
            uVar.b(inetSocketAddress.getAddress().getHostAddress());
            socket.close();
            try {
                socket.close();
            } catch (Throwable th2) {
                x.q.b(th2);
            }
        } catch (Throwable e) {
            th2 = e;
            i2 = -1;
            x.q.b(th2);
            socket.close();
        } catch (Throwable th22) {
            x.q.b(th22);
        }
        uVar.a(i2);
        return uVar;
    }

    private static Map a() {
        Map hashMap = new HashMap();
        String a = v.a("__MTA_TEST_SPEED__");
        if (!(a == null || a.trim().length() == 0)) {
            for (String a2 : a2.split(";")) {
                String[] split = a2.split(",");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                        } catch (Throwable e) {
                            x.q.b(e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public final void run() {
        try {
            if (this.b == null) {
                this.b = a();
            }
            if (this.b == null || this.b.size() == 0) {
                x.q.a((Object) "empty domain list.");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.b.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null || str.length() == 0) {
                    x.q.c("empty domain name.");
                } else if (((Integer) entry.getValue()) == null) {
                    x.q.c("port is null for " + str);
                } else {
                    jSONArray.put(a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).a());
                }
            }
            if (jSONArray.length() != 0) {
                d gVar = new g(this.a, x.a(this.a, false, this.c), this.c);
                gVar.a(jSONArray.toString());
                new ai(gVar).a();
            }
        } catch (Throwable th) {
            x.q.b(th);
        }
    }
}
