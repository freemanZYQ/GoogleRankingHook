package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.c.a;
import com.vlocker.model.e;
import java.util.HashMap;

class bv implements OnClickListener {
    final /* synthetic */ bt a;

    bv(bt btVar) {
        this.a = btVar;
    }

    public void onClick(View view) {
        if (this.a.a.e != null) {
            HashMap a = this.a.a.e.a();
            if (!(a == null || this.a.a.f == null || a.size() != this.a.a.f.size())) {
                a.a(this.a.a).aE();
                for (int i = 0; i < a.size(); i++) {
                    if (((Boolean) a.get(Integer.valueOf(i))).booleanValue()) {
                        a.a(this.a.a).d(((e) this.a.a.f.get(i)).b().a(), true);
                    }
                }
            }
        }
        this.a.a.finish();
    }
}
