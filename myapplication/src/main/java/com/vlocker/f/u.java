package com.vlocker.f;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.c.a;

class u implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ s b;
    final /* synthetic */ Dialog c;
    final /* synthetic */ t d;

    u(t tVar, Context context, s sVar, Dialog dialog) {
        this.d = tVar;
        this.a = context;
        this.b = sVar;
        this.c = dialog;
    }

    public void onClick(View view) {
        p.a(this.a, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_verify_cancel");
        this.d.c();
        a.a(this.a).aC(false);
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null && this.c.isShowing()) {
            this.c.dismiss();
        }
    }
}
