package com.inveno.a;

import com.inveno.se.f.a;

class o implements Runnable {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void run() {
        if (this.a.b != null) {
            try {
                this.a.b.close();
                a.a("DataSDK", "数据库关闭");
            } catch (Exception e) {
            }
        }
    }
}
