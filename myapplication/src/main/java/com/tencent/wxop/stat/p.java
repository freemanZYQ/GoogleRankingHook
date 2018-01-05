package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;

final class p implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ y b = null;

    p(Context context) {
        this.a = context;
    }

    public final void run() {
        if (this.a == null) {
            x.q.d("The Context of StatService.onPause() can not be null!");
        } else {
            x.b(this.a, l.h(this.a), this.b);
        }
    }
}
