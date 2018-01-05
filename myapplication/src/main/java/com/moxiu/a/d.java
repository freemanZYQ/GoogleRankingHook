package com.moxiu.a;

import com.baidu.mobads.SplashAdListener;
import com.moxiu.b.a.a;
import com.moxiu.b.b.b;

final class d implements SplashAdListener {
    final /* synthetic */ b a;
    final /* synthetic */ a b;

    d(b bVar, a aVar) {
        this.a = bVar;
        this.b = aVar;
    }

    public void onAdClick() {
        if (this.a != null) {
            this.a.c(this.b);
        }
    }

    public void onAdDismissed() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void onAdFailed(String str) {
        if (this.a != null) {
            this.a.b(this.b);
        }
    }

    public void onAdPresent() {
        if (this.a != null) {
            this.a.a(this.b);
        }
    }
}
