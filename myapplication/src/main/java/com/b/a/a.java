package com.b.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.moxiu.b.d.c;
import com.moxiu.b.d.e;
import com.moxiu.b.d.f;
import java.util.List;
import java.util.Map;

public class a extends com.moxiu.b.a.a {
    public String A = "";
    private c W;
    private Context X;
    public String a = "";
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h = "";
    public String i;
    public String j;
    public String k;
    public String l;
    public List m;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public Map s;
    public List t;
    public List u;
    public List v;
    public long w;
    public int x;
    public int y;
    public boolean z = true;

    public static void a(Context context, String str) {
        com.alimama.ad.mobile.b.a aVar = new com.alimama.ad.mobile.b.a();
        aVar.a("login", 2);
        aVar.a("url", str);
        aVar.a("appContext", (Object) context);
        com.alimama.ad.mobile.a.a().b(aVar);
    }

    private void a(String str) {
        new b(this, str).start();
    }

    private void b(Context context) {
        try {
            if (this.W == null) {
                this.W = new c(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.moxiu.http.action.promotion.filedownload.downloading");
                context.registerReceiver(this.W, intentFilter);
            }
            com.mx.http.download.a aVar = new com.mx.http.download.a();
            if (!(TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.H))) {
                aVar.g(this.B);
                aVar.h(this.H);
                aVar.b(this.b);
                aVar.i(f.a(2, context, this));
                aVar.j(f.a(3, context, this));
                if ("post".equals(this.A)) {
                    aVar.d(1);
                } else {
                    aVar.d(0);
                }
                if (this.u != null && this.u.size() > 0) {
                    aVar.a(this.u);
                }
                if (this.v != null && this.v.size() > 0) {
                    aVar.b(this.v);
                }
                aVar.f(this.g);
                aVar.c(this.i);
                aVar.b(1);
                aVar.n(this.d);
                aVar.e(".apk");
            }
            com.mx.http.f.a(context).a(this.i, aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void a() {
        double d = 1.0d;
        synchronized (this) {
            try {
                if (this.s != null) {
                    List list;
                    if (this.w == 0) {
                        list = (List) this.s.get(0 + "");
                        this.s.remove("0");
                        this.w = System.currentTimeMillis();
                    } else {
                        double currentTimeMillis = (double) ((System.currentTimeMillis() - this.w) / 1000);
                        if (currentTimeMillis >= 1.0d) {
                            d = currentTimeMillis;
                        }
                        int ceil = (int) Math.ceil(d);
                        list = (List) this.s.get(ceil + "");
                        this.s.remove(ceil + "");
                    }
                    a(list);
                }
            } catch (Exception e) {
            }
        }
    }

    public void a(Context context) {
        try {
            a();
            if (!this.J && !TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(this.H)) {
                f.b(0, context, this);
                this.J = true;
            }
        } catch (Exception e) {
        }
    }

    public void a(View view) {
        if (!c.a() && view != null) {
            this.X = view.getContext();
            try {
                a(this.t);
                f.b(1, view.getContext(), this);
                if (c.c(view.getContext(), this.b)) {
                    try {
                        view.getContext().startActivity(view.getContext().getPackageManager().getLaunchIntentForPackage(this.b));
                        this.y = 1;
                    } catch (Exception e) {
                    }
                } else if ((this.y == 0 || this.y == 8 || this.y == 16 || this.y == 3) && this.z) {
                    if ("app".equals(this.D) && !TextUtils.isEmpty(this.i)) {
                        b(view.getContext());
                    }
                } else if (this.y == 4 && this.z) {
                    Toast.makeText(view.getContext(), "拼命下载中...", 0).show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if ("taobao".equals(this.n)) {
                if (!c.c(view.getContext(), "com.taobao.taobao") || c.d(view.getContext(), "com.taobao.taobao") < 123) {
                    throw new Throwable("taobao is not installed");
                }
                a(view.getContext(), i());
            } else if ("third-app".equals(this.n)) {
                if (TextUtils.isEmpty(this.q)) {
                    this.q = "android.intent.action.VIEW";
                }
                Intent intent = new Intent(this.q, Uri.parse(this.o));
                intent.setFlags(268435456);
                if (c.a(view.getContext(), intent)) {
                    view.getContext().startActivity(intent);
                    if ("dianou".equals(this.P)) {
                        e.a(view.getContext(), this.o);
                        return;
                    }
                    return;
                }
                throw new Throwable("third app is not installed");
            }
        }
    }

    public void a(List list) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String str = (String) list.get(i);
                if (!TextUtils.isEmpty(str) && str.length() >= 5) {
                    a(str);
                }
            }
        }
    }

    public void a(boolean z) {
        this.N = z;
    }

    public String b() {
        return this.g;
    }

    public void b(View view) {
        if (view != null) {
            this.X = view.getContext();
            try {
                a();
                if (!this.J && !TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(this.H)) {
                    f.b(0, view.getContext(), this);
                    this.J = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b(List list) {
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.h;
    }

    public int e() {
        return this.y;
    }

    public boolean equals(Object obj) {
        return equals(obj);
    }

    public boolean f() {
        return "app".equals(this.D);
    }

    public String g() {
        return this.C;
    }

    public String h() {
        return this.d;
    }

    public String i() {
        return this.a;
    }

    public String j() {
        return this.e;
    }

    public String k() {
        return this.f + "";
    }

    public String l() {
        return this.b;
    }

    public String m() {
        if (f()) {
            return "app|" + (TextUtils.isEmpty(this.d) ? "" : this.d) + "|" + (TextUtils.isEmpty(this.b) ? "" : this.b);
        }
        return (TextUtils.isEmpty(this.D) ? "url" : this.D) + "|" + this.h + "|" + (TextUtils.isEmpty(this.a) ? "" : this.a);
    }

    public String n() {
        return this.O > 0 ? "AA_SELFRUN_N" : "AA_SELFRUN_Y";
    }

    public List o() {
        return null;
    }

    public String p() {
        return this.j;
    }

    public String q() {
        return this.k;
    }

    public String r() {
        return this.l;
    }

    public String s() {
        return this.n;
    }

    public String t() {
        return "app".equals(this.D) ? c.c(this.i) : "url".equals(this.D) ? c.c(this.a) : "";
    }

    public String u() {
        return c.c(this.d);
    }

    public String v() {
        return c.c(this.c);
    }

    public String w() {
        return this.T;
    }

    public int x() {
        return this.U;
    }

    public boolean y() {
        return this.V;
    }
}
