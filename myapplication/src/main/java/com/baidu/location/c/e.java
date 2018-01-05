package com.baidu.location.c;

import com.baidu.location.f;

class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        if (f.isServing) {
            this.a.d();
        }
    }
}
