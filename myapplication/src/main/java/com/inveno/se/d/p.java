package com.inveno.se.d;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.inveno.se.f.a;
import com.inveno.se.f.k;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public abstract class p implements Comparable {
    private final ac a = new ac();
    private final int b;
    private String c;
    private final int d;
    private final u e;
    private Integer f;
    private s g;
    private boolean h = true;
    private boolean i = false;
    private boolean j = false;
    private long k = 0;
    private x l;
    private c m = null;

    public p(int i, String str, u uVar) {
        int i2 = 0;
        this.b = i;
        this.c = str;
        this.e = uVar;
        a(new f());
        if (!(TextUtils.isEmpty(str) || k.a(Uri.parse(str).getHost()))) {
            i2 = Uri.parse(str).getHost().hashCode();
        }
        this.d = i2;
    }

    public int a(p pVar) {
        r f = f();
        r f2 = pVar.f();
        return f == f2 ? this.f.intValue() - pVar.f.intValue() : f2.ordinal() - f.ordinal();
    }

    protected aa a(aa aaVar) {
        return aaVar;
    }

    protected abstract t a(m mVar);

    protected Map a() {
        return null;
    }

    public final void a(int i) {
        this.f = Integer.valueOf(i);
    }

    public void a(c cVar) {
        this.m = cVar;
    }

    public void a(s sVar) {
        this.g = sVar;
    }

    public void a(x xVar) {
        this.l = xVar;
    }

    protected abstract void a(Object obj);

    public void a(String str) {
        this.a.a(str, Thread.currentThread().getId());
    }

    public final void a(boolean z) {
        this.h = z;
    }

    protected byte[] a(Map map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode(String.valueOf(entry.getValue()), str));
                stringBuilder.append('&');
            }
            a.b("encodedParams.toString():" + stringBuilder.toString());
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public void b(aa aaVar) {
        if (this.e != null) {
            this.e.a(aaVar);
        }
    }

    void b(String str) {
        if (this.g != null) {
            this.g.b(this);
        }
        long id = Thread.currentThread().getId();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new q(this, str, id));
            return;
        }
        this.a.a(str, id);
        this.a.a(toString());
    }

    public byte[] b() {
        Map a = a();
        return (a == null || a.size() <= 0) ? null : a(a, p());
    }

    public String c() {
        return i();
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((p) obj);
    }

    public c d() {
        return this.m;
    }

    public String e() {
        return "application/x-www-form-urlencoded; charset=" + p();
    }

    public r f() {
        return r.NORMAL;
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return this.d;
    }

    public String i() {
        return this.c;
    }

    public boolean j() {
        return this.i;
    }

    public Map k() {
        return Collections.emptyMap();
    }

    protected Map l() {
        return a();
    }

    protected String m() {
        return p();
    }

    public String n() {
        return e();
    }

    public byte[] o() {
        Map l = l();
        return (l == null || l.size() <= 0) ? null : a(l, m());
    }

    protected String p() {
        return "UTF-8";
    }

    public final boolean q() {
        return this.h;
    }

    public final int r() {
        return this.l.a();
    }

    public x s() {
        return this.l;
    }

    public void t() {
        this.j = true;
    }

    public String toString() {
        return (this.i ? "[X] " : "[ ] ") + i() + " " + ("0x" + Integer.toHexString(h())) + " " + f() + " " + this.f;
    }

    public boolean u() {
        return this.j;
    }

    public void v() {
    }
}
