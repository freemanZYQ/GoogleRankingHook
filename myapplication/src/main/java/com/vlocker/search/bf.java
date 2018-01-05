package com.vlocker.search;

import android.text.TextUtils;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.m.av;

class bf implements av {
    final /* synthetic */ ba a;

    bf(ba baVar) {
        this.a = baVar;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            p.a(this.a.a, "Vlock_Switch_Constellation_PPC_TF", "constellation", str);
            a.a(this.a.a).O(str);
            this.a.a(str);
        }
    }
}
