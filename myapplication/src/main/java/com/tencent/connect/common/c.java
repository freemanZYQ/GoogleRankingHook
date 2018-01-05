package com.tencent.connect.common;

import com.tencent.open.a.j;
import com.tencent.open.d.p;
import com.tencent.tauth.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static c a = null;
    private Map b = Collections.synchronizedMap(new HashMap());

    private c() {
        if (this.b == null) {
            this.b = Collections.synchronizedMap(new HashMap());
        }
    }

    public static c a() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    public b a(String str) {
        if (str == null) {
            j.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        d dVar;
        synchronized (this.b) {
            dVar = (d) this.b.get(str);
            this.b.remove(str);
        }
        return dVar == null ? null : dVar.b;
    }

    public Object a(int i, b bVar) {
        String a = p.a(i);
        if (a == null) {
            j.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i);
            return null;
        }
        d dVar;
        synchronized (this.b) {
            dVar = (d) this.b.put(a, new d(this, i, bVar));
        }
        return dVar == null ? null : dVar.b;
    }

    public Object a(String str, b bVar) {
        int a = p.a(str);
        if (a == -1) {
            j.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        d dVar;
        synchronized (this.b) {
            dVar = (d) this.b.put(str, new d(this, a, bVar));
        }
        return dVar == null ? null : dVar.b;
    }
}
