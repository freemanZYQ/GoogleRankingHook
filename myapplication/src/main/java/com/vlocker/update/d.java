package com.vlocker.update;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.j;
import com.vlocker.b.o;

class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        if (j.b(this.a.b.getApplicationContext()) == o.twoGNetStatus) {
            this.a.b(false);
            this.a.f.dismiss();
            return;
        }
        if (j.a(this.a.c.p(), 0) && j.b(this.a.b, "com.tencent.android.qqdownloader")) {
            this.a.a("com.tencent.android.qqdownloader");
        } else if (j.a(this.a.c.p(), 1) && j.b(this.a.b, "com.baidu.appsearch")) {
            this.a.a("com.baidu.appsearch");
        } else if (j.a(this.a.c.p(), 2) && j.b(this.a.b, "com.wandoujia.phoenix2")) {
            this.a.a("com.wandoujia.phoenix2");
        } else {
            this.a.b(false);
        }
        i.a(this.a.b, this.a.g);
        this.a.f.dismiss();
    }
}
