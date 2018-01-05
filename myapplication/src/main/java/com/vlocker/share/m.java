package com.vlocker.share;

import android.os.Bundle;
import android.text.TextUtils;
import com.vlocker.b.i;

class m implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ h b;

    m(h hVar, int i) {
        this.b = hVar;
        this.a = i;
    }

    public void run() {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        if (!TextUtils.isEmpty(this.b.j)) {
            bundle.putString("title", this.b.j);
        }
        if (!TextUtils.isEmpty(this.b.l)) {
            bundle.putString("summary", this.b.l);
        }
        if (!TextUtils.isEmpty(this.b.m)) {
            bundle.putString("targetUrl", this.b.m);
        }
        bundle.putString("imageLocalUrl", i.l + this.b.j + ".png");
        if (this.a == 1) {
            bundle.putInt("cflag", 1);
        }
        this.b.n.a(this.b.f, bundle, this.b.s);
    }
}
