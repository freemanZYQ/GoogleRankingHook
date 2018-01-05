package com.vlocker.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vlocker.b.p;

class m extends BroadcastReceiver {
    final /* synthetic */ a a;

    private m(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (a.d) {
            p.a(this.a.h, "Vlocker_Click_Msg_ToInfoFlow_PPC_RR", new String[0]);
            this.a.s();
            this.a.L = false;
            this.a.J.post(new n(this));
            this.a.J.postDelayed(new o(this), 200);
            this.a.J.postDelayed(new p(this), 700);
        }
    }
}
