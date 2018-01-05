package com.vlocker.f;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.c.a;

class ac implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ Dialog b;
    final /* synthetic */ s c;
    final /* synthetic */ ab d;

    ac(ab abVar, Context context, Dialog dialog, s sVar) {
        this.d = abVar;
        this.a = context;
        this.b = dialog;
        this.c = sVar;
    }

    public void onClick(View view) {
        this.d.c();
        p.a(this.a, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_verify_cancel");
        if (this.b != null && this.b.isShowing()) {
            this.b.dismiss();
        }
        a.a(this.a).aC(false);
        if (this.c != null) {
            this.c.c();
        }
    }
}
