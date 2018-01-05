package com.vlocker.f;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.pass.SpassFingerprint.IdentifyListener;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.settings.FingerprintSettingActivity;

class ao implements IdentifyListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ Context b;
    final /* synthetic */ s c;
    final /* synthetic */ Handler d;
    final /* synthetic */ ai e;

    ao(ai aiVar, Dialog dialog, Context context, s sVar, Handler handler) {
        this.e = aiVar;
        this.a = dialog;
        this.b = context;
        this.c = sVar;
        this.d = handler;
    }

    public void onCompleted() {
    }

    public void onFinished(int i) {
        switch (i) {
            case 0:
                ((TextView) this.a.findViewById(R.id.fp_dialog_verify_tv)).setText("验证成功");
                if (this.a != null && this.a.isShowing()) {
                    new Handler(new ap(this)).sendEmptyMessageAtTime(-1, 1500);
                    p.a(this.b, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_verify_success");
                    a.a(this.b).aC(true);
                    if (this.c != null) {
                        this.c.a();
                    }
                    this.e.c();
                    return;
                }
                return;
            case 16:
                ImageView imageView = (ImageView) this.a.findViewById(R.id.fp_dialog_verify_iv);
                TextView textView = (TextView) this.a.findViewById(R.id.fp_dialog_verify_tv);
                if (this.e.i >= 4) {
                    textView.setText("验证失败过多，请稍后重新开启");
                    new Handler(new aq(this)).sendEmptyMessageAtTime(-2, 1500);
                    p.a(this.b, "Vlock_Choose_FingerP_guide_PPC_TF", "button_name", "FP_verify_times_out");
                    a.a(this.b).aC(false);
                    if (this.c != null) {
                        this.c.b();
                    } else {
                        FingerprintSettingActivity.a(this.b, "");
                    }
                    this.e.c();
                    return;
                }
                imageView.setImageDrawable(this.b.getResources().getDrawable(R.drawable.fingerprint_verify_dialog_error));
                textView.setText("指纹验证失败，请重试");
                this.e.c();
                this.d.postDelayed(new ar(this, textView, imageView), 1500);
                this.e.i = this.e.i + 1;
                return;
            default:
                return;
        }
    }

    public void onReady() {
    }

    public void onStarted() {
    }
}
