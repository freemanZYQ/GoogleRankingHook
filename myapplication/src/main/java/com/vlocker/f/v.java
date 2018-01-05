package com.vlocker.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.vlocker.c.a;

class v implements OnCancelListener {
    final /* synthetic */ Context a;
    final /* synthetic */ s b;
    final /* synthetic */ t c;

    v(t tVar, Context context, s sVar) {
        this.c = tVar;
        this.a = context;
        this.b = sVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.c.c();
        a.a(this.a).aC(false);
        if (this.b != null) {
            this.b.c();
        }
    }
}
