package com.vlocker.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.vlocker.c.a;

class l implements OnCancelListener {
    final /* synthetic */ Context a;
    final /* synthetic */ s b;
    final /* synthetic */ j c;

    l(j jVar, Context context, s sVar) {
        this.c = jVar;
        this.a = context;
        this.b = sVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        a.a(this.a).aC(false);
        this.c.a(this.a, this.b);
    }
}
