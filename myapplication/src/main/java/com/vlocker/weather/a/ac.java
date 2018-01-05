package com.vlocker.weather.a;

import android.text.TextUtils;
import com.vlocker.weather.e.d;
import com.vlocker.weather.y;

class ac implements y {
    final /* synthetic */ y a;

    ac(y yVar) {
        this.a = yVar;
    }

    public void a(String str) {
        try {
            this.a.F.a(this.a.G);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.a.e)) {
            d.a(this.a.D, this.a.e, this.a.F.m(), this.a.F.n());
        }
    }
}
