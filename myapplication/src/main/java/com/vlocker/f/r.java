package com.vlocker.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.vlocker.b.p;

class r implements OnCancelListener {
    final /* synthetic */ Context a;
    final /* synthetic */ o b;

    r(o oVar, Context context) {
        this.b = oVar;
        this.a = context;
    }

    public void onCancel(DialogInterface dialogInterface) {
        p.a(this.a, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_guide_cancel");
    }
}
