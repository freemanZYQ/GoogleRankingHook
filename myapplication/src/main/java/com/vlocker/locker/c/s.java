package com.vlocker.locker.c;

import com.vlocker.msg.p;
import com.vlocker.ui.widget.MusicLrcView;

class s implements Runnable {
    final /* synthetic */ b a;

    s(b bVar) {
        this.a = bVar;
    }

    public void run() {
        this.a.av = false;
        this.a.U();
        this.a.ao.setVisibility(0);
        this.a.ap.setVisibility(4);
        if (MusicLrcView.a && this.a.al != null) {
            this.a.al.b(true);
        }
        p.a().k();
        this.a.ao.a();
    }
}
