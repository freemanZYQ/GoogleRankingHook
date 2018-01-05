package com.tencent.open.d;

class t implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ s b;

    t(s sVar, Runnable runnable) {
        this.b = sVar;
        this.a = runnable;
    }

    public void run() {
        try {
            this.a.run();
        } finally {
            this.b.a();
        }
    }
}
