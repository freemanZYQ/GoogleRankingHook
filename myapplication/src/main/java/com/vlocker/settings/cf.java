package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;

class cf implements OnClickListener {
    final /* synthetic */ RedPacketActivity a;

    cf(RedPacketActivity redPacketActivity) {
        this.a = redPacketActivity;
    }

    public void onClick(View view) {
        this.a.e.x(this.a.h.getValue());
        this.a.e.y(this.a.i.getValue());
        this.a.e.z(this.a.j.getValue());
        this.a.e.A(this.a.k.getValue());
        this.a.f.dismiss();
        this.a.h();
        p.a(this.a, "Vlocker_Nodisturb_Hongbao_Settings_PPC_TF", "time_duration", this.a.l.getText().toString());
    }
}
