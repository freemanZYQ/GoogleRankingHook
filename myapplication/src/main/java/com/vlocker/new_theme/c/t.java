package com.vlocker.new_theme.c;

import android.os.Message;
import com.vlocker.theme.f.e;

class t extends Thread {
    final /* synthetic */ q a;

    t(q qVar) {
        this.a = qVar;
    }

    public void run() {
        super.run();
        if (this.a.aq == null) {
            this.a.am = this.a.an;
        } else if (this.a.aq.equals("new")) {
            this.a.aa = "zuixin";
            this.a.am = e.c();
        } else if (this.a.aq.equals("fenlei")) {
            this.a.am = this.a.an;
            this.a.aa = this.a.aq;
        }
        Message obtainMessage = this.a.ap.obtainMessage();
        obtainMessage.obj = this.a.am;
        obtainMessage.what = 3;
        this.a.ap.sendMessage(obtainMessage);
    }
}
