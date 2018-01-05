package com.vlocker.f;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.samsung.android.sdk.pass.SpassFingerprint;
import com.samsung.android.sdk.pass.SpassFingerprint.IdentifyListener;
import com.samsung.android.sdk.pass.SpassInvalidStateException;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.cover.ag;

public class ai implements m {
    int a = 0;
    boolean b;
    Context c;
    SpassFingerprint d;
    a e;
    private IdentifyListener f;
    private IdentifyListener g;
    private ag h;
    private int i;

    public ai(Context context) {
        this.c = context;
        this.e = a.a(context);
    }

    private IdentifyListener a(Dialog dialog, Context context, s sVar) {
        return new ao(this, dialog, context, sVar, new Handler());
    }

    private IdentifyListener e() {
        return this.f == null ? new al(this) : this.f;
    }

    public void a() {
        d();
        if (this.e.ch() && this.e.cg() && this.d.hasRegisteredFinger()) {
            try {
                this.f = e();
                this.d.startIdentify(this.f);
                this.b = true;
            } catch (SpassInvalidStateException e) {
                if (e.getType() == 1) {
                    Toast.makeText(this.c, "指纹验证失败过多，请稍后再试", 1).show();
                    try {
                        this.d.startIdentifyWithDialog(this.c, this.f, true);
                    } catch (Exception e2) {
                    }
                }
            } catch (IllegalStateException e3) {
            }
        }
    }

    public void a(Context context) {
        a(context, null);
    }

    public void a(Context context, s sVar) {
        this.i = 0;
        Dialog create = new Builder(context).create();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.fingerprint_dialog_verify, null);
        linearLayout.findViewById(R.id.fp_dialog_verify_btn).setOnClickListener(new aj(this, context, create, sVar));
        d();
        this.g = a(create, context, sVar);
        try {
            this.d.startIdentify(this.g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        create.setOnCancelListener(new ak(this, context, sVar));
        create.show();
        create.getWindow().setGravity(16);
        create.setCanceledOnTouchOutside(false);
        create.setContentView(linearLayout);
    }

    public void a(ag agVar) {
        this.h = agVar;
    }

    public boolean b() {
        boolean z = false;
        try {
            z = new SpassFingerprint(this.c).hasRegisteredFinger();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public void c() {
        try {
            if (this.d != null) {
                this.d.cancelIdentify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() {
        try {
            if (this.d == null) {
                this.d = new SpassFingerprint(MoSecurityApplication.a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
