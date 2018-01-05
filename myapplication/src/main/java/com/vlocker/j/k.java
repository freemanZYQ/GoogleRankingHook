package com.vlocker.j;

class k implements Runnable {
    final /* synthetic */ a a;

    k(a aVar) {
        this.a = aVar;
    }

    public void run() {
        try {
            Thread.sleep(1500);
            a.a = this.a.d.a();
            this.a.o = "com.tencent.qqmusic";
            this.a.p.removeMessages(4);
            this.a.p.sendEmptyMessage(4);
            this.a.a(this.a.h);
            if (!a.e.d.equals(this.a.h) || !a.e.c.equals(this.a.g)) {
                a.e.d = this.a.h;
                a.e.c = this.a.g;
                if (!a.e.d.isEmpty() && !a.e.c.isEmpty()) {
                    this.a.p.removeMessages(3);
                    this.a.p.sendEmptyMessage(3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
