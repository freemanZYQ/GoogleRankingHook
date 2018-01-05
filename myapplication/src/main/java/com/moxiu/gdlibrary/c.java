package com.moxiu.gdlibrary;

import com.moxiu.b.a.a;
import com.moxiu.b.b.b;
import com.qq.e.ads.splash.SplashADListener;

final class c implements SplashADListener {
    final /* synthetic */ b a;
    final /* synthetic */ a b;

    c(b bVar, a aVar) {
        this.a = bVar;
        this.b = aVar;
    }

    public void onADClicked() {
        if (this.a != null) {
            this.a.c(this.b);
        }
    }

    public void onADDismissed() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void onADPresent() {
        if (this.a != null) {
            this.a.a(this.b);
        }
    }

    public void onNoAD(int i) {
        if (this.a != null) {
            this.a.b(this.b);
        }
    }
}
