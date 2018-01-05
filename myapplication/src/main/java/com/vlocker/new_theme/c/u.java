package com.vlocker.new_theme.c;

import com.vlocker.new_theme.a.i;
import com.vlocker.theme.model.T_ThemeListPageInfo;

class u extends i {
    final /* synthetic */ q a;

    u(q qVar) {
        this.a = qVar;
    }

    public void a(T_ThemeListPageInfo t_ThemeListPageInfo) {
        super.a(t_ThemeListPageInfo);
        this.a.ag = t_ThemeListPageInfo;
        if (!(t_ThemeListPageInfo == null || this.a.ag.a == null)) {
            this.a.ac.setVisibility(8);
            this.a.ah.addAll(this.a.ag.h());
            this.a.ad.a(this.a.ah);
            this.a.ae.a(this.a.ag.c);
        }
        this.a.ae.a(false);
        this.a.ae.b(false);
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        this.a.K();
        this.a.ae.a(false);
        this.a.ae.b(false);
    }
}
