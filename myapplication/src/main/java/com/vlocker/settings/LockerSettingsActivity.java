package com.vlocker.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.ui.cover.LockPatternView;
import com.vlocker.ui.cover.l;
import com.vlocker.ui.cover.r;
import com.vlocker.ui.widget.view.LockNumberCoverView;
import com.vlocker.ui.widget.view.k;
import java.util.Date;

@SuppressLint({"ResourceAsColor"})
public class LockerSettingsActivity extends BaseBinderActivity implements OnClickListener {
    public static int b = 0;
    boolean a;
    protected k c = new bc(this);
    protected r d = new bd(this);
    Runnable e = new bf(this);
    private a f = null;
    private LockPatternView g;
    private LockNumberCoverView h;
    private CountDownTimer i = null;
    private Handler j = new ba(this);
    private TextView k;
    private Animation l;
    private Toast m;
    private TextView n;
    private long o;
    private boolean p = false;
    private Runnable q = new bb(this);

    private void a(int i) {
        if (this.m == null) {
            this.m = Toast.makeText(this, i, 0);
            this.m.setGravity(17, 0, 0);
        } else {
            this.m.setText(i);
        }
        this.m.show();
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, LockerSettingsActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void d() {
        if (this.a) {
            f();
        } else {
            e();
        }
    }

    private void e() {
        this.h = (LockNumberCoverView) findViewById(R.id.locknummain);
        this.h.setTip(getString(R.string.input_bf_password_txt));
        this.h.setOnLockNumListener(this.c);
        if (this.f.ao()) {
            this.h.setDelType(0);
        }
        this.h.h();
    }

    private void f() {
        this.g = (LockPatternView) findViewById(R.id.gesturepwd_unlock_lockview);
        this.g.setOnPatternListener(this.d);
        this.g.setTactileFeedbackEnabled(false);
        this.k = (TextView) findViewById(R.id.gesturepwd_unlock_text);
        this.l = AnimationUtils.loadAnimation(this, R.anim.l_shake_x);
        this.n = (TextView) findViewById(R.id.gesturepwd_unlock_cancel);
        this.n.setOnClickListener(this);
        a();
    }

    private void g() {
        if (this.i != null) {
            this.i.cancel();
        }
    }

    public void a() {
        this.o = new Date().getTime();
        if (this.o - l.a < 30000) {
            this.p = true;
            this.g.setEnabled(false);
            this.j.removeCallbacks(this.e);
            this.j.post(this.e);
        }
    }

    public void b() {
        if (this.k != null) {
            this.k.setText(R.string.gesture_password_guide_draw_btn);
            this.k.setTextColor(-1);
        }
        b = 0;
    }

    public void c() {
        finish();
        PasswordSettingsActivity.a((Context) this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gesturepwd_unlock_cancel:
                finish();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        this.f = a.a((Context) this);
        this.f.i(true);
        if (this.f.Q()) {
            this.a = true;
            setContentView(R.layout.l_gesturepassword_unlock);
        } else if (this.f.S()) {
            this.a = false;
            LockNumberCoverView.a = false;
            setContentView(R.layout.l_locker_number_custom);
        }
        d();
        if (getWindow().getDecorView() != null) {
            getWindow().getDecorView().setBackgroundResource(R.drawable.l_v3_bg);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onDestroy() {
        /*
        r2 = this;
        r1 = 0;
        r0 = r2.getWindow();
        r0 = r0.getDecorView();
        r0.setBackgroundDrawable(r1);
        super.onDestroy();
        r0 = r2.a;
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r0 = r2.g;
        if (r0 == 0) goto L_0x0017;
    L_0x0017:
        r2.g();
        return;
    L_0x001b:
        r0 = r2.h;
        if (r0 == 0) goto L_0x0017;
    L_0x001f:
        r0 = r2.h;
        r0.k();
        r0 = r2.h;
        r0.removeAllViews();
        r2.h = r1;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.settings.LockerSettingsActivity.onDestroy():void");
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
