package com.vlocker.weather.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.weather.a;
import com.vlocker.weather.e.d;

class c implements OnClickListener {
    Boolean a = Boolean.valueOf(true);
    final /* synthetic */ a b;

    c(a aVar) {
        this.b = aVar;
    }

    public void onClick(View view) {
        if (this.b.n != null) {
            this.b.n.a(3);
        }
        d.a(this.b.l, "Weather(V)_Click_WarningDetail_PPC_YZY", new String[0]);
        a.a(this.b.l);
    }
}
