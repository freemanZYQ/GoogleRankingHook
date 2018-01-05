package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;

final class ae implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ y b = null;

    ae(Context context) {
        this.a = context;
    }

    public final void run() {
        if (this.a == null) {
            x.q.d("The Context of StatService.onResume() can not be null!");
        } else {
            x.a(this.a, l.h(this.a), this.b);
        }
    }
}
