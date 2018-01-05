package com.baidu.lbsapi.auth;

import java.util.Hashtable;

class j implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ LBSAuthManager f;

    j(LBSAuthManager lBSAuthManager, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = lBSAuthManager;
        this.a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    public void run() {
        if (a.a) {
            a.a("status = " + this.a + "; forced = " + this.b + "checkAK = " + this.f.b(this.c));
        }
        if (this.a == 601 || this.b || this.a == -1 || this.f.b(this.c)) {
            if (a.a) {
                a.a("authenticate sendAuthRequest");
            }
            String[] b = b.b(LBSAuthManager.b);
            if (a.a) {
                a.a("authStrings.length:" + b.length);
            }
            if (b == null || b.length <= 1) {
                this.f.a(this.b, this.d, this.e, this.c);
                return;
            }
            if (a.a) {
                a.a("more sha1 auth");
            }
            this.f.a(this.b, this.d, this.e, b, this.c);
        } else if (602 == this.a) {
            if (a.a) {
                a.a("authenticate wait  ");
            }
            LBSAuthManager.e.b();
            this.f.a(null, this.c);
        } else {
            if (a.a) {
                a.a("authenticate else  ");
            }
            this.f.a(null, this.c);
        }
    }
}
