package com.vlocker.f;

import android.app.Dialog;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import fingerprint.core.FingerprintCore.IFingerprintResultListener;

class af implements IFingerprintResultListener {
    final /* synthetic */ ab a;
    private Dialog b;
    private s c;
    private Handler d = new Handler();

    public af(ab abVar) {
        this.a = abVar;
    }

    public af(ab abVar, Dialog dialog, s sVar) {
        this.a = abVar;
        this.b = dialog;
        this.c = sVar;
    }

    public void onAuthenticateError(int i, CharSequence charSequence) {
        if (i == 7) {
            if (this.b != null) {
                this.a.a(this.b, this.c);
                Toast.makeText(this.a.a, "验证失败过多，请稍后重新开启", 1).show();
            } else if (this.a.b > 0) {
                Toast.makeText(this.a.a, "指纹验证错误过多，请稍后再试", 1).show();
                if (this.a.d != null) {
                    this.a.d.a(charSequence);
                }
            }
        }
    }

    public void onAuthenticateFailed(int i) {
        if (this.b == null) {
            if (this.a.d != null) {
                this.a.d.a(this.a.b);
            }
            this.a.b = this.a.b + 1;
            p.a(this.a.a, "Vlock_Unlock_FP_PPC_TF", "manufacturer", Build.MANUFACTURER, "status", "false_" + this.a.b);
            return;
        }
        ImageView imageView = (ImageView) this.b.findViewById(R.id.fp_dialog_verify_iv);
        TextView textView = (TextView) this.b.findViewById(R.id.fp_dialog_verify_tv);
        if (this.a.b >= 4) {
            this.a.a(this.b, this.c);
            p.a(this.a.a, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_verify_times_out");
            return;
        }
        imageView.setImageDrawable(this.a.a.getResources().getDrawable(R.drawable.fingerprint_verify_dialog_error));
        textView.setText("指纹验证失败，请重试");
        this.a.a(this.a.c);
        this.d.postDelayed(new ah(this, textView, imageView), 1500);
        this.a.b = this.a.b + 1;
    }

    public void onAuthenticateSuccess() {
        if (this.b == null) {
            if (this.a.d != null) {
                this.a.d.a();
            }
            if ("moxiu-launcher".equals(j.p(this.a.a))) {
                p.a(this.a.a, "Vlocker_Times_Unlock_PPC_TF", new String[0]);
            }
            p.a(this.a.a, "Vlock_Unlock_FP_PPC_TF", "manufacturer", Build.MANUFACTURER, "status", "true");
            return;
        }
        ((TextView) this.b.findViewById(R.id.fp_dialog_verify_tv)).setText("验证成功");
        if (this.b != null && this.b.isShowing()) {
            new Handler(new ag(this)).sendEmptyMessageAtTime(-1, 1500);
            a.a(this.a.a).aC(true);
            if (this.c != null) {
                this.c.a();
            }
            p.a(this.a.a, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_verify_success");
            this.a.c();
        }
    }

    public void onStartAuthenticateResult(boolean z) {
    }
}
