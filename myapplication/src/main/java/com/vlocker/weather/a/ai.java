package com.vlocker.weather.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.weather.a;
import com.vlocker.weather.e.d;

class ai implements OnClickListener {
    final /* synthetic */ ah a;

    ai(ah ahVar) {
        this.a = ahVar;
    }

    public void onClick(View view) {
        if (ah.j != null) {
            a.a(this.a.b);
            d.b(this.a.b, "1010", ah.j.m(), ah.j.n());
            com.vlocker.b.a.a(this.a.b, ah.j, this.a.d, "weather_dianshang", this.a.f, false, null);
            p.a(this.a.b, "Vlock_Weathericon_Adclick_LZS", "referer", ah.j.n(), "name", ah.j.m());
        }
    }
}
