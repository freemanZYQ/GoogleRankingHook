package com.vlocker.msg;

import android.content.Intent;
import com.vlocker.setting.a.a.e;
import com.vlocker.settings.RedPacketActivity;

class o implements Runnable {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void run() {
        try {
            Intent intent = new Intent(this.a.a.c, RedPacketActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("from", e.ACTION_MAIN);
            this.a.a.c.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
