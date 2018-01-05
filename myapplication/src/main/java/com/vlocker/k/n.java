package com.vlocker.k;

import com.vlocker.n.a;

class n implements Runnable {
    final /* synthetic */ k a;

    n(k kVar) {
        this.a = kVar;
    }

    public void run() {
        if (this.a.f()) {
            a.a().postDelayed(this.a.u, 100);
        } else if (this.a.d) {
            this.a.n.post(new o(this));
        }
    }
}
