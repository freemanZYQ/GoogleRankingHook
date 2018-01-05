package com.vlocker.weather.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.j;
import com.vlocker.weather.e.d;

class x implements OnClickListener {
    final /* synthetic */ v a;

    x(v vVar) {
        this.a = vVar;
    }

    public void onClick(View view) {
        if (this.a.p != null) {
            this.a.p.a(1);
        }
        if ("A_tengxun".equals(j.p(this.a.a))) {
            d.a(this.a.a, "Weather(V)_ClickTwodays_PPC_YZY", "Twodays", "Today");
        }
    }
}
