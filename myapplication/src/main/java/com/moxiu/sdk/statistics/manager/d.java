package com.moxiu.sdk.statistics.manager;

import com.moxiu.sdk.statistics.e.i;
import com.moxiu.sdk.statistics.e.j;

public class d {
    int a;
    int b;
    final /* synthetic */ a c;

    private d(a aVar) {
        this.c = aVar;
        this.a = 0;
        this.b = 0;
    }

    private void a() {
        i.a("reset counter");
        this.a = 0;
        this.b = 0;
    }

    private void b() {
        this.a++;
        if (this.a >= 30) {
            a();
        }
    }

    private boolean c() {
        this.a++;
        this.b++;
        if (this.b == 1 && !j.a()) {
            i.a("ping fail stop report");
            return false;
        } else if (this.b >= 5) {
            i.a("fail too much stop report");
            return false;
        } else {
            if (this.a >= 30) {
                a();
            }
            return true;
        }
    }
}
