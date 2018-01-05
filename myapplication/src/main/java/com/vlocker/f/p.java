package com.vlocker.f;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

class p implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ Dialog b;
    final /* synthetic */ o c;

    p(o oVar, Context context, Dialog dialog) {
        this.c = oVar;
        this.a = context;
        this.b = dialog;
    }

    public void onClick(View view) {
        com.vlocker.b.p.a(this.a, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_guide_enable");
        this.c.c(this.a);
        if (this.b != null && this.b.isShowing()) {
            this.b.dismiss();
        }
    }
}
