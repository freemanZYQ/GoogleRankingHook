package com.vlocker.f;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.settings.FingerprintSettingActivity;
import com.vlocker.theme.f.b;
import com.vlocker.ui.cover.ag;
import com.vlocker.ui.cover.k;
import fingerprint.core.FingerprintCore;

public class ab implements m {
    Context a;
    private int b;
    private af c;
    private ag d;
    private FingerprintCore e;

    public ab(Context context) {
        this.a = context;
        d();
    }

    private void a(Dialog dialog, s sVar) {
        ((TextView) dialog.findViewById(R.id.fp_dialog_verify_tv)).setText("验证失败过多，请稍后重新开启");
        new Handler(new ae(this, dialog)).sendEmptyMessageAtTime(-2, 1500);
        a.a(this.a).aC(false);
        if (sVar != null) {
            sVar.b();
        } else {
            FingerprintSettingActivity.a(this.a, "");
        }
        c();
    }

    private void a(af afVar) {
        d();
        this.e.setFingerprintListener(afVar);
        this.e.startAuthenticate();
    }

    public static boolean b(Context context) {
        return FingerprintCore.isSupport(context);
    }

    public void a() {
        this.b = 0;
        if (b()) {
            a(new af(this));
        }
    }

    public void a(Context context) {
        a(context, null);
    }

    public void a(Context context, s sVar) {
        this.b = 0;
        Dialog create = new Builder(context).create();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.fingerprint_dialog_verify, null);
        linearLayout.findViewById(R.id.fp_dialog_verify_btn).setOnClickListener(new ac(this, context, create, sVar));
        this.c = new af(this, create, sVar);
        a(this.c);
        create.setOnCancelListener(new ad(this, context, sVar));
        create.show();
        create.getWindow().setGravity(16);
        create.setCanceledOnTouchOutside(false);
        create.setContentView(linearLayout);
    }

    public void a(ag agVar) {
        this.d = agVar;
    }

    public boolean b() {
        try {
            return b.b() ? k.a(this.a) ? FingerprintCore.isHasEnrolledFingerprints(this.a) : a.a(this.a).da() : FingerprintCore.isHasEnrolledFingerprints(this.a);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void c() {
        if (this.e != null) {
            this.e.cancelAuthenticate();
        }
    }

    public void d() {
        if (this.e == null) {
            this.e = new FingerprintCore(this.a);
        }
    }
}
