package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;

class ai implements Runnable {
    final /* synthetic */ IOAdEvent a;
    final /* synthetic */ ah b;

    ai(ah ahVar, IOAdEvent iOAdEvent) {
        this.b = ahVar;
        this.a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.a.getType())) {
            m.a().f().i(this.a);
        } else if (IXAdEvent.AD_STARTED.equals(this.a.getType())) {
            this.b.a.c.onAdPresent();
        } else if ("AdUserClick".equals(this.a.getType())) {
            this.b.a.c.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.a.getType())) {
            this.b.a.a.removeAllListeners();
            this.b.a.c.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.a.getType())) {
            this.b.a.a.removeAllListeners();
            this.b.a.c.onAdFailed(m.a().q().getMessage(this.a.getData()));
        }
    }
}
