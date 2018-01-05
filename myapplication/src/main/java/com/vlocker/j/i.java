package com.vlocker.j;

class i implements Runnable {
    final /* synthetic */ a a;

    i(a aVar) {
        this.a = aVar;
    }

    public void run() {
        try {
            this.a.a(this.a.h);
            if (!(a.e.d.equals(this.a.h) && a.e.c.equals(this.a.g))) {
                a.e.d = this.a.h;
                a.e.c = this.a.g;
                this.a.p.removeMessages(3);
                this.a.p.sendEmptyMessage(3);
            }
            Thread.sleep(1500);
            a.a = this.a.d.a();
            this.a.p.removeMessages(4);
            this.a.p.sendEmptyMessage(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
