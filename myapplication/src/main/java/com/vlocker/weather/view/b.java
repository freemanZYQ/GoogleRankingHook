package com.vlocker.weather.view;

import android.content.Intent;
import com.vlocker.m.t;
import com.vlocker.settings.CitySelectActivity;
import com.vlocker.ui.cover.LockerService;

class b implements t {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a() {
        LockerService.a().b();
    }

    public void a(Intent intent) {
    }

    public void a(String str) {
    }

    public void b() {
        CitySelectActivity.c(this.a.a.getContext(), true);
    }
}
