package com.vlocker.weather.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.weather.e.d;

class av implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ at b;

    av(at atVar, String str) {
        this.b = atVar;
        this.a = str;
    }

    public void onClick(View view) {
        if (this.b.i != null) {
            this.b.i.a(2);
        }
        d.a(this.b.f, "Weather(V)_ClickWind_PPC_YZY", "Wind", this.a);
    }
}
