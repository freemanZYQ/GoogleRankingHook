package com.vlocker.new_theme.c;

import com.vlocker.new_theme.a.i;
import com.vlocker.new_theme.b.n;
import com.vlocker.new_theme.beans.f;

class m extends i {
    final /* synthetic */ j a;

    m(j jVar) {
        this.a = jVar;
    }

    public void a(f fVar) {
        if (this.a.c() != null) {
            super.a(fVar);
            this.a.ak = fVar;
            if (fVar == null || this.a.ak.b() == null) {
                this.a.K();
            } else {
                if (this.a.al == null) {
                    this.a.al = new n(this.a.c(), this.a.ak.b(), this.a.ab);
                    this.a.ab.setAdapter(this.a.al);
                }
                this.a.ac.setVisibility(8);
                this.a.ad.a(this.a.ak.c());
            }
            this.a.ad.a(false);
            this.a.ad.b(false);
        }
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        try {
            this.a.K();
            this.a.ad.a(false);
            this.a.ad.b(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
