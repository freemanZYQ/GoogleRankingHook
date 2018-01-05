package com.vlocker.weather.a;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class r extends Handler {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.h.a(this.a.j);
                this.a.h.notifyDataSetChanged();
                return;
            case 2:
                this.a.s.setText(this.a.x);
                return;
            case 3:
                this.a.g.setVisibility(0);
                return;
            case 4:
                this.a.g.setVisibility(8);
                return;
            case 5:
                this.a.w();
                return;
            case 6:
                Toast.makeText(this.a.i, "暂无数据", 0).show();
                return;
            default:
                return;
        }
    }
}
