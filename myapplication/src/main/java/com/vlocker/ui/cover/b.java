package com.vlocker.ui.cover;

import com.vlocker.n.a;

class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        try {
            if (!this.a.f) {
                if (this.a.c()) {
                    a.a().postDelayed(this.a.h, 200);
                    if (!this.a.g) {
                        this.a.g = true;
                        this.a.e.post(new c(this));
                        return;
                    }
                    return;
                }
                if (this.a.g) {
                    this.a.g = false;
                    this.a.e.post(new d(this));
                }
                a.a().postDelayed(this.a.h, 2000);
            }
        } catch (Exception e) {
        }
    }
}
