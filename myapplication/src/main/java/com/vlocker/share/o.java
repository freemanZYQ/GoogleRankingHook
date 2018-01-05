package com.vlocker.share;

import com.tencent.tauth.b;
import com.tencent.tauth.d;

class o implements b {
    final /* synthetic */ h a;

    o(h hVar) {
        this.a = hVar;
    }

    public void onCancel() {
        this.a.f = null;
        this.a.a();
    }

    public void onComplete(Object obj) {
        this.a.f = null;
        this.a.a();
    }

    public void onError(d dVar) {
        this.a.f = null;
        this.a.a();
    }
}
