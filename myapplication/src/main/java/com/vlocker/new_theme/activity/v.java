package com.vlocker.new_theme.activity;

import com.vlocker.locker.R;
import com.vlocker.new_theme.a.i;
import com.vlocker.new_theme.b.y;
import com.vlocker.theme.c.a;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.T_ThemeListPageInfo;
import com.vlocker.theme.model.d;
import java.util.Collection;

class v extends i {
    final /* synthetic */ SearchResultActivity a;
    private int b;

    v(SearchResultActivity searchResultActivity) {
        this.a = searchResultActivity;
    }

    public void a(T_ThemeListPageInfo t_ThemeListPageInfo) {
        super.a(t_ThemeListPageInfo);
        if (!(t_ThemeListPageInfo == null || t_ThemeListPageInfo.a == null)) {
            this.a.x.setVisibility(8);
            this.a.m = t_ThemeListPageInfo.h();
            if (this.a.M) {
                this.a.N = a.b().a(8200 + this.a.y + this.a.O);
            } else {
                this.a.N = a.b().a(8200 + this.a.y + this.a.H);
            }
            try {
                if (this.a.N.h() == null) {
                    this.a.N.b(this.a.m);
                    if (t_ThemeListPageInfo.g() != null && t_ThemeListPageInfo.g().size() > 0) {
                        this.a.N.a(t_ThemeListPageInfo.g());
                    }
                } else {
                    this.a.N.h().addAll(this.a.m);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (t_ThemeListPageInfo.k() && this.a.B) {
                try {
                    e.a(this.a, t_ThemeListPageInfo.j() + this.a.getResources().getString(R.string.t_market_moxiu_search_total), 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                } catch (OutOfMemoryError e3) {
                    e3.printStackTrace();
                }
                this.a.B = false;
            }
            if (t_ThemeListPageInfo.k()) {
                this.a.I.setVisibility(0);
                d h = t_ThemeListPageInfo.h();
                Collection dVar = new d();
                com.vlocker.new_theme.beans.e eVar = new com.vlocker.new_theme.beans.e();
                d dVar2 = new d();
                com.vlocker.new_theme.beans.e eVar2 = eVar;
                for (int i = 0; i < h.size(); i++) {
                    this.b++;
                    dVar2.add((T_ThemeItemInfo) h.get(i));
                    if (this.b == 3) {
                        eVar2.c(2);
                        eVar2.b("");
                        eVar2.a(dVar2);
                        dVar.add(eVar2);
                        eVar2 = new com.vlocker.new_theme.beans.e();
                        this.b = 0;
                        dVar2 = new d();
                    }
                }
                if (this.b != 0 && (this.a.n.size() == 0 || h.size() < 9)) {
                    eVar2.c(2);
                    eVar2.b("");
                    eVar2.a(dVar2);
                    dVar.add(eVar2);
                    com.vlocker.new_theme.beans.e eVar3 = new com.vlocker.new_theme.beans.e();
                    this.b = 0;
                    d dVar3 = new d();
                }
                if (this.a.C == null) {
                    this.a.C = new y(this.a, this.a.n);
                    this.a.w.setAdapter(this.a.C);
                }
                this.a.n.addAll(dVar);
                this.a.C.a(this.a.n);
                this.a.C.notifyDataSetChanged();
                this.a.D.a(t_ThemeListPageInfo.i());
                this.a.D.a(false);
                this.a.D.b(false);
                this.a.J.setVisibility(8);
            } else {
                this.a.r = true;
                this.a.I.setVisibility(8);
                this.a.J.setVisibility(0);
            }
            this.a.a(this.a, this.a.v);
        }
        this.a.D.a(false);
        this.a.D.b(false);
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        this.a.I.setVisibility(8);
        if (this.a.C != null && (this.a.C.a() == null || this.a.C.a().size() == 0)) {
            this.a.A = false;
        }
        this.a.D.a(false);
        this.a.D.b(false);
    }
}
