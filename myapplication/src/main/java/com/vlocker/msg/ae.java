package com.vlocker.msg;

import android.text.TextUtils;
import com.vlocker.c.a;

class ae implements Runnable {
    final /* synthetic */ ab a;

    ae(ab abVar) {
        this.a = abVar;
    }

    public void run() {
        synchronized (this.a.i) {
            a a = a.a(this.a.m);
            this.a.q = a.aJ();
            Object trim = a.aG().trim();
            if (!TextUtils.isEmpty(trim)) {
                String[] split = trim.split("\\|");
                if (trim != null) {
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            this.a.a(str);
                        }
                    }
                }
            }
        }
        this.a.h = true;
        if (this.a.c != null) {
            this.a.a(this.a.c, this.a.d, this.a.e, this.a.f);
        }
    }
}
