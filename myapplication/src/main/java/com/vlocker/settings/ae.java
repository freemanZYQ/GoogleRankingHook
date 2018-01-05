package com.vlocker.settings;

import com.vlocker.locker.a.a;

class ae extends a {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ FeedBackActivity d;

    ae(FeedBackActivity feedBackActivity, String str, String str2, String str3) {
        this.d = feedBackActivity;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public void a(String str) {
        super.a(str);
        this.d.b(str);
    }

    public /* synthetic */ Object b() {
        return d();
    }

    public void c() {
        super.c();
        this.d.b(null);
    }

    public String d() {
        return this.d.b(this.a, this.b, this.c);
    }
}
