package com.vlocker.splash.newa;

import android.os.Handler;
import android.os.Message;
import com.moxiu.b.a.a;
import com.samsung.android.sdk.pass.SpassFingerprint;
import com.vlocker.b.p;

class g extends Handler {
    final /* synthetic */ SplashActivityNew a;
    private a b;

    g(SplashActivityNew splashActivityNew) {
        this.a = splashActivityNew;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 36:
                if (this.a.h != null) {
                    this.a.i = this.a.a((a) this.a.h.get(0));
                    if (this.a.i != null) {
                        this.a.i.a(this.a);
                        this.a.i.a(this.a.g);
                    }
                    if (this.a.h.size() > 1 && this.a.i != null) {
                        this.a.i.e = this.a.a((a) this.a.h.get(1));
                        if (this.a.i.e != null) {
                            this.a.i.e.a(this.a);
                            this.a.i.e.a(this.a.g);
                        }
                    }
                }
                if (this.a.i != null) {
                    p.a(this.a, "1012");
                    this.a.i.a();
                    return;
                }
                this.a.j.sendEmptyMessageDelayed(40, 3000);
                return;
            case 40:
                this.a.j.removeMessages(40);
                this.a.j.removeMessages(50);
                this.a.a();
                return;
            case 49:
                this.a.j.removeMessages(50);
                this.a.j.removeMessages(49);
                this.a.f.setVisibility(0);
                this.b = (a) message.obj;
                if (this.b != null && "dianou".equals(this.b.C)) {
                    this.a.j.sendEmptyMessageDelayed(51, 1000);
                    return;
                }
                return;
            case 50:
                this.a.j.removeMessages(50);
                this.a.a();
                return;
            case SpassFingerprint.STATUS_OPERATION_DENIED /*51*/:
                this.b.a();
                this.a.j.removeMessages(51);
                this.a.j.sendEmptyMessageDelayed(51, 1000);
                return;
            case 53:
                this.a.j.removeMessages(51);
                return;
            default:
                return;
        }
    }
}
