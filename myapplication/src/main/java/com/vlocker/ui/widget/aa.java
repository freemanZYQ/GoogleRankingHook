package com.vlocker.ui.widget;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.vlocker.locker.R;

public class aa {
    private final s a;
    private int b;

    public aa(Context context) {
        this(context, R.style.AliDialog);
    }

    public aa(Context context, int i) {
        this.a = new s(context);
        this.b = i;
    }

    public aa a(int i) {
        this.a.i = this.a.a.getText(i);
        return this;
    }

    public aa a(int i, OnClickListener onClickListener) {
        this.a.m = this.a.a.getText(i);
        this.a.n = onClickListener;
        return this;
    }

    public z a() {
        z zVar;
        int i = this.b;
        if (this.a.p == null && this.a.n == null) {
            zVar = new z(this.a.a, i);
            this.a.a(zVar.a);
            zVar.setCancelable(this.a.s);
            zVar.setOnCancelListener(this.a.t);
        } else {
            zVar = new z(this.a.a, i);
            this.a.a(zVar.a);
            zVar.setCancelable(this.a.s);
            zVar.setOnCancelListener(this.a.t);
        }
        if (this.a.u != null) {
            zVar.setOnKeyListener(this.a.u);
        }
        return zVar;
    }

    public aa b(int i, OnClickListener onClickListener) {
        this.a.o = this.a.a.getText(i);
        this.a.p = onClickListener;
        return this;
    }

    public z b() {
        z a = a();
        a.show();
        return a;
    }
}
