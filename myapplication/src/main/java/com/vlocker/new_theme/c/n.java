package com.vlocker.new_theme.c;

import com.vlocker.new_theme.a.i;
import com.vlocker.new_theme.beans.e;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.T_ThemeListPageInfo;
import com.vlocker.theme.model.d;
import java.util.Collection;

class n extends i {
    final /* synthetic */ j a;

    n(j jVar) {
        this.a = jVar;
    }

    public void a(T_ThemeListPageInfo t_ThemeListPageInfo) {
        super.a(t_ThemeListPageInfo);
        if (t_ThemeListPageInfo != null && t_ThemeListPageInfo.h() != null) {
            d h = t_ThemeListPageInfo.h();
            Collection dVar = new d();
            e eVar = new e();
            d dVar2 = new d();
            e eVar2 = eVar;
            for (int i = 0; i < h.size(); i++) {
                j.g(this.a);
                dVar2.add((T_ThemeItemInfo) h.get(i));
                if (this.a.am == 3) {
                    eVar2.c(2);
                    eVar2.b("");
                    eVar2.a(dVar2);
                    dVar.add(eVar2);
                    eVar2 = new e();
                    this.a.am = 0;
                    dVar2 = new d();
                }
            }
            this.a.ac.setVisibility(8);
            d dVar3 = null;
            try {
                dVar3 = this.a.ak.b();
            } catch (Exception e) {
                if (dVar3 == null) {
                    dVar3 = new d();
                }
                e.printStackTrace();
            }
            dVar3.addAll(dVar);
            this.a.al.a(dVar3);
            this.a.al.notifyDataSetChanged();
            this.a.ad.a(t_ThemeListPageInfo.i());
            this.a.ad.a(false);
            this.a.ad.b(false);
        }
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        this.a.ad.a(false);
        this.a.ad.b(false);
    }
}
