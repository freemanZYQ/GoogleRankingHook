package com.vlocker.search;

import com.vlocker.b.p;
import com.vlocker.new_theme.a.i;

class l extends i {
    final /* synthetic */ String a;
    final /* synthetic */ BaiduSearchActivity b;

    l(BaiduSearchActivity baiduSearchActivity, String str) {
        this.b = baiduSearchActivity;
        this.a = str;
    }

    public void a(ac acVar) {
        super.a(acVar);
        try {
            this.b.p = acVar;
            if (acVar != null && this.b.p.d() != null && this.b.p.d().size() > 0) {
                this.b.q = this.b.a(this.a, null, this.b.p.d());
                if (this.b.s == null) {
                    this.b.s = new ah(this.b, this.b.q);
                    this.b.e.setAdapter(this.b.s);
                } else {
                    this.b.s.a(this.b.q);
                }
                if (this.b.z) {
                    this.b.z = false;
                    p.a(this.b, "Vlock_Input_Content_Search_PPC_TF", "search_engine", this.b.f);
                }
                this.b.e.setVisibility(0);
                this.b.d.setVisibility(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        this.b.e.setVisibility(8);
        this.b.d.setVisibility(0);
    }
}
