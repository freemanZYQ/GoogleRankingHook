package com.vlocker.m;

class as implements at {
    final /* synthetic */ String a;
    final /* synthetic */ float b;
    final /* synthetic */ ap c;

    as(ap apVar, String str, float f) {
        this.c = apVar;
        this.a = str;
        this.b = f;
    }

    public void a() {
        try {
            this.c.a.play(((Integer) this.c.b.get(this.a)).intValue(), this.b, this.b, 1, 0, 1.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
