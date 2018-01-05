package com.moxiu.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mobad.feeds.NativeResponse;
import com.moxiu.b.d.c;
import com.moxiu.b.d.f;
import java.util.List;

public class a extends com.moxiu.b.a.a {
    public NativeResponse a;

    public a(NativeResponse nativeResponse, com.moxiu.b.a.a aVar) {
        super(aVar);
        this.a = nativeResponse;
        this.S = true;
        this.C = "baidu";
        this.P = "baidu";
    }

    public a(String str) {
        this.F = str;
    }

    public void a() {
    }

    public void a(View view) {
        if (!c.a() && view != null) {
            try {
                if (this.a != null) {
                    this.a.handleClick(view);
                    c.b("baidu click");
                }
                if (!this.K && !TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(this.H)) {
                    f.b(1, view.getContext(), this);
                    this.K = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(boolean z) {
    }

    public String b() {
        return this.a.getIconUrl();
    }

    public void b(View view) {
        try {
            if (this.a != null) {
                this.a.recordImpression(view);
            }
            if (!this.J && !TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(this.H)) {
                f.b(0, view.getContext(), this);
                this.J = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(List list) {
    }

    public String c() {
        return this.a.getDesc();
    }

    public String d() {
        return this.a.getImageUrl();
    }

    public int e() {
        return this.a.isDownloadApp() ? 0 : 1;
    }

    public boolean equals(Object obj) {
        return equals(obj);
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.a.getAppPackage());
    }

    public String g() {
        return this.C;
    }

    public String h() {
        return this.a.getTitle();
    }

    public String i() {
        return "";
    }

    public String j() {
        return "";
    }

    public String k() {
        return "";
    }

    public String l() {
        return this.a == null ? "" : this.a.getAppPackage();
    }

    public String m() {
        String str = "";
        if (this.a == null) {
            return "";
        }
        try {
            str = f() ? "app|" + h() + "|" : "url|" + h() + "|";
        } catch (Exception e) {
        }
        return (str == null || str.equals("")) ? "notitle" : str;
    }

    public String n() {
        return "AA_BAIDU";
    }

    public List o() {
        return null;
    }

    public String p() {
        return "";
    }

    public String q() {
        return "";
    }

    public String r() {
        return "";
    }

    public String s() {
        return "";
    }

    public String t() {
        return "";
    }

    public String u() {
        return this.a == null ? "" : c.c(this.a.getTitle());
    }

    public String v() {
        return this.a == null ? "" : c.c(this.a.getDesc());
    }

    public String w() {
        return this.T;
    }

    public int x() {
        return 0;
    }

    public boolean y() {
        return false;
    }
}
