package com.vlocker.settings;

import android.os.Handler;
import android.os.Message;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.model.f;

class bn extends Handler {
    final /* synthetic */ NotifyAppsSelectActivity a;

    bn(NotifyAppsSelectActivity notifyAppsSelectActivity) {
        this.a = notifyAppsSelectActivity;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.d.setVisibility(8);
            this.a.a.setVisibility(0);
            this.a.b.setVisibility(0);
            this.a.c.setVisibility(0);
            this.a.e = new f(this.a, this.a.h, true);
            this.a.e.a(false);
            this.a.a.setAdapter(this.a.e);
            if (this.a.i.size() > 0) {
                this.a.n.setVisibility(0);
            }
            this.a.f = new f(this.a, this.a.i, true);
            this.a.f.a(false);
            this.a.b.setAdapter(this.a.f);
            if (this.a.j.size() > 0) {
                this.a.o.setVisibility(0);
            }
            this.a.g = new f(this.a, this.a.j, true);
            this.a.g.a(false);
            this.a.c.setAdapter(this.a.g);
            this.a.p = a.a(this.a).bh();
            if (this.a.p) {
                this.a.m.setText(this.a.getResources().getString(R.string.v2_msg_need_light_app_all_not));
            } else {
                this.a.m.setText(this.a.getResources().getString(R.string.v2_msg_need_light_app_all));
            }
            this.a.l.setText(this.a.a(this.a.h.size()));
            this.a.q = true;
        }
        super.handleMessage(message);
    }
}
