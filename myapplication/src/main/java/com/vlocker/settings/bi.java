package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;

class bi implements OnClickListener {
    final /* synthetic */ NotificationLightActivity a;

    bi(NotificationLightActivity notificationLightActivity) {
        this.a = notificationLightActivity;
    }

    public void onClick(View view) {
        this.a.a.s(this.a.l.getValue());
        this.a.a.t(this.a.m.getValue());
        this.a.a.u(this.a.n.getValue());
        this.a.a.v(this.a.o.getValue());
        this.a.k.dismiss();
        this.a.c();
        p.a(this.a, "Vlocker_Done_NoDisturb_LightMsg_PPC_TF", "period_time", this.a.d.getText().toString());
    }
}
