package com.vlocker.weather.view;

import com.vlocker.ui.cover.LockerService;

class a implements c {
    final /* synthetic */ CoverTipsLayout a;

    a(CoverTipsLayout coverTipsLayout) {
        this.a = coverTipsLayout;
    }

    public void a() {
        LockerService.a().a(5, 3, new b(this));
    }

    public void b() {
        com.vlocker.c.a.a(this.a.getContext()).X();
        this.a.setVisibility(8);
    }
}
