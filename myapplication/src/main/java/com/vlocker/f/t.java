package com.vlocker.f;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.a.a.a;
import com.a.a.l;
import com.vlocker.locker.R;
import com.vlocker.ui.cover.ag;

public class t implements m {
    a a;
    Context b;
    boolean c;
    private l d;
    private l e;
    private ag f;
    private int g;

    public t(Context context) {
        this.b = context;
    }

    private l a(Dialog dialog, s sVar) {
        return new x(this, dialog, sVar);
    }

    public static boolean e() {
        a a = a.a();
        if (a == null) {
            return false;
        }
        a.b();
        return true;
    }

    private l f() {
        return this.d == null ? new w(this) : this.d;
    }

    public void a() {
        d();
        if (this.a != null && this.a.c() != null && this.a.c().length > 0 && !this.c) {
            this.g = 0;
            this.d = f();
            this.a.a(this.d, this.a.c());
        }
    }

    public void a(Context context) {
        a(context, null);
    }

    public void a(Context context, s sVar) {
        this.g = 0;
        d();
        Dialog create = new Builder(context).create();
        if (!(this.a == null || this.a.c() == null || this.a.c().length <= 0)) {
            this.e = a(create, sVar);
            this.a.a(this.e, this.a.c());
        }
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.fingerprint_dialog_verify, null);
        linearLayout.findViewById(R.id.fp_dialog_verify_btn).setOnClickListener(new u(this, context, sVar, create));
        create.setOnCancelListener(new v(this, context, sVar));
        create.show();
        create.getWindow().setGravity(16);
        create.setCanceledOnTouchOutside(false);
        create.setContentView(linearLayout);
    }

    public void a(ag agVar) {
        this.f = agVar;
    }

    public boolean b() {
        a a = a.a();
        if (a != null) {
            if (a.c() == null || a.c().length <= 0) {
                a.b();
            } else {
                a.b();
                return true;
            }
        }
        return false;
    }

    public void c() {
        try {
            if (this.a != null) {
                this.a.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() {
        c();
        this.a = a.a();
    }
}
