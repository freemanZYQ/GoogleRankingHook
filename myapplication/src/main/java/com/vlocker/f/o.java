package com.vlocker.f;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.vlocker.b.p;
import com.vlocker.f.a.a;
import com.vlocker.locker.R;
import com.vlocker.m.a.b;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.a.a.e;
import com.vlocker.settings.FingerprintSettingActivity;
import com.vlocker.ui.cover.k;

public class o implements h {
    private void b(Context context) {
        Dialog create = new Builder(context).create();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.fingerprint_dialog_two_btn, null);
        linearLayout.findViewById(R.id.fp_dialog_guide_btn_yes).setOnClickListener(new p(this, context, create));
        linearLayout.findViewById(R.id.fp_dialog_guide_btn_no).setOnClickListener(new q(this, context, create));
        create.setOnCancelListener(new r(this, context));
        p.a(context, "Vlock_Show_FingerP_guide_PPC_TF", "type", d(context));
        create.show();
        create.getWindow().setGravity(16);
        create.setCanceledOnTouchOutside(false);
        create.setContentView(linearLayout);
    }

    private void c(Context context) {
        if (!j.a().b()) {
            FingerprintSettingActivity.a(context, "点击指纹开关，开启指纹解锁");
        } else if (k.a(MoSecurityApplication.a())) {
            i.a = 10;
            i.d = true;
            b.a().c();
            b.a(context).a(3);
        } else {
            j.a().a(context);
        }
    }

    private String d(Context context) {
        return k.a(context) ? j.a().b() ? "FP_guide_pw_fp" : "FP_guide_pw" : j.a().b() ? "FP_guide_fp" : "FP_guide_no";
    }

    public void a(Context context) {
        b(context);
    }

    public void a(Context context, a aVar) {
        if (aVar != null) {
            try {
                if (a.b()) {
                    a.a(context, false);
                    return;
                }
                Intent intent = new Intent();
                intent.setFlags(268435456);
                if (!TextUtils.isEmpty(aVar.f)) {
                    if (e.ACTION_MAIN.equals(aVar.f)) {
                        intent.setAction("android.intent.action.MAIN");
                        intent.addCategory("android.intent.category.LAUNCHER");
                    } else {
                        intent.setAction(aVar.f);
                    }
                }
                if (!TextUtils.isEmpty(aVar.e)) {
                    String str = aVar.e;
                    intent.setComponent(new ComponentName(str.substring(0, str.indexOf("/")), str.substring(str.indexOf("/") + 1)));
                }
                if (!TextUtils.isEmpty(aVar.g)) {
                    intent.setData(Uri.parse(aVar.g));
                }
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Context context, s sVar) {
        if (!j.a().b()) {
            if (k.a(context)) {
                i.a = 6;
            } else {
                i.a = 7;
            }
            i.c = true;
            b.a().c();
            j.a().c(context);
        } else if (k.a(context)) {
            i.a = 10;
            i.d = true;
            b.a().c();
            b.a(context).a(3);
        } else {
            i.a = 8;
            j.a().a(context, sVar);
        }
    }
}
