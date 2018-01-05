package com.vlocker.f;

import android.app.Dialog;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.l;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.settings.FingerprintSettingActivity;

class x implements l {
    Handler a = new Handler();
    final /* synthetic */ Dialog b;
    final /* synthetic */ s c;
    final /* synthetic */ t d;

    x(t tVar, Dialog dialog, s sVar) {
        this.d = tVar;
        this.b = dialog;
        this.c = sVar;
    }

    public void a() {
        ImageView imageView = (ImageView) this.b.findViewById(R.id.fp_dialog_verify_iv);
        TextView textView = (TextView) this.b.findViewById(R.id.fp_dialog_verify_tv);
        if (this.d.g >= 4) {
            textView.setText("验证失败过多，请稍后重新开启");
            new Handler(new z(this)).sendEmptyMessageAtTime(-2, 1500);
            p.a(this.d.b, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_verify_times_out");
            a.a(this.d.b).aC(false);
            if (this.c != null) {
                this.c.b();
            } else {
                FingerprintSettingActivity.a(this.d.b, "");
            }
            this.d.c();
            return;
        }
        imageView.setImageDrawable(this.d.b.getResources().getDrawable(R.drawable.fingerprint_verify_dialog_error));
        textView.setText("验证失败，请重试");
        this.d.a.a(this.d.e, this.d.a.c());
        this.a.postDelayed(new aa(this, textView, imageView), 1500);
        this.d.g = this.d.g + 1;
    }

    public void a(int i, boolean z) {
        p.a(this.d.b, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_verify_success");
        ((TextView) this.b.findViewById(R.id.fp_dialog_verify_tv)).setText("验证成功");
        if (this.b != null && this.b.isShowing()) {
            new Handler(new y(this)).sendEmptyMessageAtTime(-1, 1500);
        }
        a.a(this.d.b).aC(true);
        if (this.c != null) {
            this.c.a();
        }
        this.d.c();
    }
}
