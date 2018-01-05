package com.moxiu.b.c;

class i implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ h b;

    i(h hVar, Runnable runnable) {
        this.b = hVar;
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
