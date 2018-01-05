package com.vlocker.j;

class j implements Runnable {
    final /* synthetic */ a a;

    j(a aVar) {
        this.a = aVar;
    }

    public void run() {
        try {
            this.a.a(this.a.h);
            a.e.d = this.a.h;
            a.e.c = this.a.g;
            a.e.e = this.a.i;
            this.a.r = false;
            this.a.o = "com.miui.player";
            if (!(a.e.d.isEmpty() || a.e.c.isEmpty())) {
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
