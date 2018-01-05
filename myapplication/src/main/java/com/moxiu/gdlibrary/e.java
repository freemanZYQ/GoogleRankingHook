package com.moxiu.gdlibrary;

import android.text.TextUtils;
import android.view.View;
import com.moxiu.b.a.a;
import com.moxiu.b.d.c;
import com.moxiu.b.d.f;
import com.qq.e.ads.nativ.NativeADDataRef;
import java.util.List;

public class e extends a {
    public NativeADDataRef a;

    public e(NativeADDataRef nativeADDataRef, a aVar) {
        super(aVar);
        this.a = nativeADDataRef;
        this.S = true;
        this.C = "ade";
        this.P = "ade";
    }

    public e(String str) {
        this.F = str;
    }

    public void a() {
    }

    public void a(View view) {
        if (!c.a()) {
            try {
                if (!(this.K || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.H))) {
                    f.b(1, view.getContext(), this);
                    this.K = true;
                }
                if (this.a != null) {
                    this.a.onClicked(view);
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
            if (!(this.J || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.H))) {
                f.b(0, view.getContext(), this);
                this.J = true;
            }
            if (this.a != null) {
                this.a.onExposured(view);
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
        return this.a.getImgUrl();
    }

    public int e() {
        return this.a.getAPPStatus();
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof NativeADDataRef)) ? (obj == null || !(obj instanceof e) || this.a == null) ? false : this.a.equals(((e) obj).a) : this.a != null ? this.a.equals(obj) : false;
    }

    public boolean f() {
        return this.a.isAPP();
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
        return this.a.getDownloadCount() + "";
    }

    public String k() {
        return this.a.getAPPScore() + "";
    }

    public String l() {
        return "";
    }

    public String m() {
        return this.a == null ? "" : f() ? "app|" + h() + "|" : "url|" + h() + "|";
    }

    public String n() {
        return "AA_GDT";
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
