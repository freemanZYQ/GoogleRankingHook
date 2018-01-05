package com.vlocker.g;

import android.content.Context;
import android.text.TextUtils;
import com.vlocker.security.MoSecurityApplication;
import mcm.sdk.a;

public class t {
    protected Context a = MoSecurityApplication.a();
    protected a b;

    public t(a aVar) {
        this.b = aVar;
    }

    public void a() {
    }

    public void b() {
        if (this.b != null && this.b.w && !TextUtils.isEmpty(this.b.v)) {
            a.b(this.a, this.b.v, "2.1");
        }
    }
}
