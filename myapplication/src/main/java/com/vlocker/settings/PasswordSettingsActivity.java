package com.vlocker.settings;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.f.j;
import com.vlocker.locker.R;
import com.vlocker.m.a.b;
import com.vlocker.m.a.d;
import com.vlocker.m.m;
import com.vlocker.ui.cover.k;
import com.vlocker.ui.view.ao;

public class PasswordSettingsActivity extends BaseBinderActivity implements OnClickListener {
    private a a = null;
    private ImageView b = null;
    private ImageView c = null;
    private ImageView d = null;
    private ImageView e = null;
    private ImageView f = null;
    private ImageView g = null;
    private TextView h;
    private boolean i;
    private boolean j = false;
    private boolean k;
    private ao l;
    private boolean m;

    public static void a(Context context) {
        Intent intent = new Intent(context, PasswordSettingsActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void a(ImageView imageView, boolean z, int i) {
        if (i == 1) {
            if (imageView == null) {
                return;
            }
            if (z) {
                imageView.setImageResource(R.drawable.l_setting_on);
            } else {
                imageView.setImageResource(R.drawable.l_setting_off);
            }
        } else if (imageView == null) {
        } else {
            if (z) {
                imageView.setImageResource(R.drawable.l_theme_color_selected);
            } else {
                imageView.setImageResource(R.drawable.l_v2_checkbox_circle_normal);
            }
        }
    }

    private void a(boolean z) {
        this.a.p(z);
        a(this.g, !z, 1);
    }

    private void b(boolean z) {
        if (!this.a.bm()) {
            this.a.W(true);
            this.a.V(false);
        } else if (!this.a.bo()) {
            this.a.X(true);
            this.a.V(true);
            Toast.makeText(this, getString(R.string.pwd_shortstyle_close_hint), 0).show();
        }
    }

    private void c() {
        if (k.a(this)) {
            Dialog create = new Builder(this).create();
            LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_disable_sys_locker_url, null);
            linearLayout.findViewById(R.id.btn_close_lock).setOnClickListener(new bw(this, create));
            TextView textView = (TextView) linearLayout.findViewById(R.id.txt_tips);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.txt_url);
            if (this.i) {
                textView.setText(getString(R.string.close_system_lock_failure));
                textView2.setText(R.string.can_not_select_slide_password);
                textView2.setVisibility(0);
                textView2.setOnClickListener(new bx(this, create));
            } else {
                textView.setText(R.string.dont_close_system_lock);
                textView2.setVisibility(8);
            }
            create.show();
            create.getWindow().setGravity(16);
            create.getWindow().setContentView(linearLayout);
            create.setCanceledOnTouchOutside(true);
            p.a((Context) this, "Vlock_View_Close_SystemPw_PPC_TF", "location", "password_popup");
        } else if (this.i) {
            Toast.makeText(this, R.string.set_vlocker_password, 1).show();
        }
    }

    private void c(boolean z) {
        b();
        if (!z) {
            i();
            Toast.makeText(this, getString(R.string.password_clean_toast), 0).show();
        }
    }

    private void d() {
        this.b = (ImageView) findViewById(R.id.setting_enable_pattern_locker_img);
        this.d = (ImageView) findViewById(R.id.setting_enable_none_img);
        this.c = (ImageView) findViewById(R.id.setting_enable_num_locker_img);
        this.e = (ImageView) findViewById(R.id.setting_locker_bg_img);
        this.f = (ImageView) findViewById(R.id.setting_enable_normal_locker_img);
        this.h = (TextView) findViewById(R.id.setting_locker_emergency_desc_tv);
        this.g = (ImageView) findViewById(R.id.setting_pattern_line_img);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        findViewById(R.id.btn_back_main).setOnClickListener(this);
        findViewById(R.id.setting_enable_num_locker_layout).setOnClickListener(this);
        findViewById(R.id.setting_enable_pattern_locker_layout).setOnClickListener(this);
        findViewById(R.id.setting_none_layout).setOnClickListener(this);
        findViewById(R.id.setting_locker_bg_layout).setOnClickListener(this);
        findViewById(R.id.setting_enable_normal_locker_layout).setOnClickListener(this);
        findViewById(R.id.setting_forget_num_layout).setOnClickListener(this);
        findViewById(R.id.setting_locker_emergency_layout).setOnClickListener(this);
        findViewById(R.id.setting_pattern_line_layout).setOnClickListener(this);
        findViewById(R.id.setting_enable_fingerprint_locker_layout).setOnClickListener(this);
        if (j.a() == null) {
            findViewById(R.id.setting_enable_fingerprint_locker_layout).setVisibility(8);
        }
    }

    private void d(boolean z) {
        try {
            this.k = true;
            startActivity(new Intent(this, LockNumberActivityNew.class));
        } catch (Exception e) {
        }
        if (!z) {
            i();
            Toast.makeText(this, getString(R.string.password_clean_toast), 0).show();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
        r4 = this;
        r1 = 1;
        r2 = 0;
        r0 = r4.a;
        r0 = r0.Q();
        if (r0 != 0) goto L_0x0012;
    L_0x000a:
        r0 = r4.a;
        r0 = r0.S();
        if (r0 == 0) goto L_0x0026;
    L_0x0012:
        r4.m = r1;
        r0 = r4.k;
        if (r0 == 0) goto L_0x0026;
    L_0x0018:
        r4.k = r2;
        r0 = com.vlocker.ui.cover.k.a(r4);
        if (r0 == 0) goto L_0x0026;
    L_0x0020:
        r0 = android.os.Build.VERSION.SDK_INT;
        r3 = 22;
        if (r0 >= r3) goto L_0x0026;
    L_0x0026:
        r0 = r4.a;
        r0 = r0.O();
        if (r0 != 0) goto L_0x0034;
    L_0x002e:
        r4.c(r2);
        r4.d(r2);
    L_0x0034:
        r0 = r4.b;
        r3 = r4.a;
        r3 = r3.Q();
        r4.a(r0, r3, r2);
        r0 = r4.c;
        r3 = r4.a;
        r3 = r3.S();
        r4.a(r0, r3, r2);
        r3 = r4.d;
        r0 = r4.a;
        r0 = r0.S();
        if (r0 != 0) goto L_0x008e;
    L_0x0054:
        r0 = r4.a;
        r0 = r0.Q();
        if (r0 != 0) goto L_0x008e;
    L_0x005c:
        r0 = r1;
    L_0x005d:
        r4.a(r3, r0, r2);
        r0 = r4.e;
        r3 = r4.a;
        r3 = r3.i();
        r4.a(r0, r3, r1);
        r0 = r4.f;
        r3 = r4.a;
        r3 = r3.ao();
        r4.a(r0, r3, r1);
        r0 = r4.g;
        r3 = r4.a;
        r3 = r3.R();
        if (r3 != 0) goto L_0x0081;
    L_0x0080:
        r2 = r1;
    L_0x0081:
        r4.a(r0, r2, r1);
        r0 = r4.a;
        r0 = r0.at();
        r4.e(r0);
        return;
    L_0x008e:
        r0 = r2;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.settings.PasswordSettingsActivity.e():void");
    }

    private void e(boolean z) {
        if (z) {
            this.h.setText(getResources().getString(R.string.setting_locker_emergency_desc_txt_started));
        } else {
            this.h.setText(getResources().getString(R.string.setting_locker_emergency_desc_txt));
        }
    }

    private void f() {
        if (this.l != null) {
            if (this.l.isShowing()) {
                this.l.dismiss();
            }
            this.l = null;
        }
        this.l = new ao(this, R.style.aiVlockerTimeDialog);
        this.l.setCanceledOnTouchOutside(true);
        this.l.c(R.layout.l_dialog_pwd_hint);
        this.l.e.setOnClickListener(this);
        this.l.d.setOnClickListener(this);
    }

    private void g() {
        boolean z = true;
        this.a.R(true);
        boolean i = this.a.i();
        if (i) {
            p.a((Context) this, "Vlocker_Switch_BlurPassword_PPC_TF", "status", "off");
        } else {
            p.a((Context) this, "Vlocker_Switch_BlurPassword_PPC_TF", "status", "on");
        }
        a(this.e, !i, 1);
        a aVar = this.a;
        if (i) {
            z = false;
        }
        aVar.c(z);
    }

    private void h() {
        boolean z = !this.a.ao();
        if (z) {
            this.a.c(false);
            a(this.e, false, 1);
            p.a((Context) this, "Vlocker_SinglePasswordSum_PPC_TF", new String[0]);
        } else {
            this.a.R(true);
            this.a.c(true);
            a(this.e, true, 1);
        }
        if (!this.a.bl() && VERSION.SDK_INT > 17) {
            b(z);
        }
        a(this.f, z, 1);
        this.a.A(z);
    }

    private void i() {
        this.j = true;
        this.a.o(false);
        this.a.q(false);
        this.m = false;
        e();
        a();
    }

    private void j() {
        m mVar = new m(this, true, new by(this, this.a.at()));
    }

    public void a() {
        if (this.m) {
            findViewById(R.id.setting_help_tv).setVisibility(0);
            findViewById(R.id.setting_enable_normal_locker_layout).setVisibility(0);
            findViewById(R.id.setting_locker_bg_layout).setVisibility(0);
            findViewById(R.id.setting_forget_num_layout).setVisibility(0);
            findViewById(R.id.setting_forget_num_line).setVisibility(0);
            findViewById(R.id.setting_locker_emergency_layout).setVisibility(0);
            if (this.a.Q()) {
                findViewById(R.id.setting_pattern_line_layout).setVisibility(0);
                return;
            } else {
                findViewById(R.id.setting_pattern_line_layout).setVisibility(8);
                return;
            }
        }
        findViewById(R.id.setting_help_tv).setVisibility(8);
        findViewById(R.id.setting_enable_normal_locker_layout).setVisibility(8);
        findViewById(R.id.setting_locker_bg_layout).setVisibility(8);
        findViewById(R.id.setting_forget_num_layout).setVisibility(8);
        findViewById(R.id.setting_forget_num_line).setVisibility(8);
        findViewById(R.id.setting_locker_emergency_layout).setVisibility(8);
        findViewById(R.id.setting_pattern_line_layout).setVisibility(8);
    }

    public void b() {
        try {
            this.k = true;
            startActivity(new Intent(this, CreateGesturePasswordActivity.class));
        } catch (Exception e) {
        }
    }

    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case R.id.btn_back_main:
                finish();
                return;
            case R.id.setting_none_layout:
            case R.id.setting_enable_none_img:
                p.a((Context) this, "Vlocker_Click_NoPassword_PPC_TF", new String[0]);
                i();
                return;
            case R.id.setting_enable_pattern_locker_layout:
            case R.id.setting_enable_pattern_locker_img:
                if (this.a.Q()) {
                    z = false;
                }
                c(z);
                return;
            case R.id.setting_enable_num_locker_layout:
            case R.id.setting_enable_num_locker_img:
                if (this.a.S()) {
                    z = false;
                }
                d(z);
                return;
            case R.id.setting_enable_fingerprint_locker_layout:
                FingerprintSettingActivity.a((Context) this, "");
                return;
            case R.id.setting_enable_normal_locker_layout:
            case R.id.setting_enable_normal_locker_img:
                if (VERSION.SDK_INT <= 17) {
                    h();
                    return;
                } else if (this.a.ao()) {
                    h();
                    return;
                } else {
                    f();
                    return;
                }
            case R.id.setting_locker_bg_layout:
            case R.id.setting_locker_bg_img:
                g();
                return;
            case R.id.setting_pattern_line_layout:
            case R.id.setting_pattern_line_img:
                if (this.a.R()) {
                    z = false;
                }
                a(z);
                return;
            case R.id.setting_forget_num_layout:
                QuestionActivity.a((Context) this);
                return;
            case R.id.setting_locker_emergency_layout:
                j();
                return;
            case R.id.close_dialog:
                if (this.l != null) {
                    this.l.dismiss();
                    return;
                }
                return;
            case R.id.new_sure_btn:
                if (this.l != null) {
                    this.l.dismiss();
                }
                h();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.l_activity_password_setting);
        getWindow().setBackgroundDrawable(null);
        this.a = a.a((Context) this);
        this.j = false;
        d();
        this.i = getIntent().getBooleanExtra("from_system_setting", false);
        if (this.a.c()) {
            c();
            this.a.b(false);
        }
    }

    protected void onDestroy() {
        if (this.j && !this.m) {
            p.a((Context) this, "Vlocker_NoPasswordSum_PPC_TF", new String[0]);
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        e();
        a();
        if (d.b && !k.a(this)) {
            b.a(this).a(1);
            d.b = false;
        }
        if (this.a.ch() && com.vlocker.f.b.a) {
            com.vlocker.f.b.a().d();
        }
    }
}
