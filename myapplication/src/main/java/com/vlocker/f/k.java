package com.vlocker.f;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.m.a.b;

class k implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ Dialog b;
    final /* synthetic */ j c;

    k(j jVar, Context context, Dialog dialog) {
        this.c = jVar;
        this.a = context;
        this.b = dialog;
    }

    public void onClick(View view) {
        p.a(this.a, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_nosystemlock_yes");
        i.a = 9;
        i.d = true;
        b.a().c();
        b.a(this.a).a(3);
        if (this.b != null && this.b.isShowing()) {
            this.b.dismiss();
        }
    }
}
