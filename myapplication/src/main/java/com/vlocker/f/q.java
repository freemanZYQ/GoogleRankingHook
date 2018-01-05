package com.vlocker.f;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.c.a;

class q implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ Dialog b;
    final /* synthetic */ o c;

    q(o oVar, Context context, Dialog dialog) {
        this.c = oVar;
        this.a = context;
        this.b = dialog;
    }

    public void onClick(View view) {
        p.a(this.a, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_guide_disable");
        if (this.b != null && this.b.isShowing()) {
            this.b.dismiss();
        }
        a.a(this.a).aC(false);
    }
}
