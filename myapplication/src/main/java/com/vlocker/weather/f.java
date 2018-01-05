package com.vlocker.weather;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.weather.e.d;

class f implements OnClickListener {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        if (this.a.H != null && !this.a.H.d()) {
            d.a(this.a.h, "Weather(V)_Jump_ToAD_PPC_YZY", new String[0]);
            a.a(this.a.h);
            this.a.a(0);
        }
    }
}
