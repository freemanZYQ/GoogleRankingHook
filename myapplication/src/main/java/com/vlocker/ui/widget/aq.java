package com.vlocker.ui.widget;

import com.vlocker.b.j;
import com.vlocker.b.o;
import com.vlocker.new_theme.d.f;

class aq implements Runnable {
    final /* synthetic */ V2GuideBannerView a;

    aq(V2GuideBannerView v2GuideBannerView) {
        this.a = v2GuideBannerView;
    }

    public void run() {
        try {
            if (o.noNetStatus != j.b(this.a.f)) {
                this.a.k = f.c(this.a.l + "&conn=" + j.q(this.a.getContext()));
            }
            this.a.y.sendEmptyMessage(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
