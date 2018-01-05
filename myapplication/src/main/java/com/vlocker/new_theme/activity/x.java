package com.vlocker.new_theme.activity;

import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import com.vlocker.new_theme.a.i;
import com.vlocker.theme.c.a;
import com.vlocker.theme.model.T_ThemeListPageInfo;

class x extends i {
    final /* synthetic */ SpecialSingleItemActivity a;

    x(SpecialSingleItemActivity specialSingleItemActivity) {
        this.a = specialSingleItemActivity;
    }

    public void a(T_ThemeListPageInfo t_ThemeListPageInfo) {
        super.a(t_ThemeListPageInfo);
        if (!(t_ThemeListPageInfo == null || t_ThemeListPageInfo.a == null)) {
            this.a.q.setVisibility(8);
            this.a.u = t_ThemeListPageInfo;
            this.a.m = t_ThemeListPageInfo.h();
            T_ThemeListPageInfo a = a.b().a(this.a.w);
            this.a.L = t_ThemeListPageInfo.f();
            this.a.J.post(new y(this));
            if (this.a.L.equals("1")) {
                this.a.M.setVisibility(0);
                this.a.H.a(t_ThemeListPageInfo.d(), 1, 0);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.a.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                LayoutParams layoutParams = this.a.H.getLayoutParams();
                layoutParams.width = displayMetrics.widthPixels;
                layoutParams.height = (int) (((float) displayMetrics.widthPixels) / 1.95f);
                this.a.B.setTextSize(1, 14.0f);
                if (t_ThemeListPageInfo.e() != null) {
                    this.a.B.setVisibility(0);
                    this.a.B.setText("        " + t_ThemeListPageInfo.e());
                } else {
                    this.a.B.setVisibility(8);
                    this.a.B.setText("");
                }
            } else {
                this.a.M.setVisibility(8);
            }
            if (a.h() == null) {
                a.b(this.a.m);
            } else {
                a.h().addAll(this.a.m);
            }
            try {
                this.a.t.a(a.h());
                this.a.s.a(t_ThemeListPageInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.a.a(t_ThemeListPageInfo, this.a.I, Boolean.valueOf(this.a.p));
        }
        this.a.s.a(false);
        this.a.J.setVisibility(0);
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        this.a.h();
    }
}
