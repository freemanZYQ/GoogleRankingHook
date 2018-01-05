package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.msg.an;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.SettingService;
import com.vlocker.ui.widget.V2SettingHeaderBar;

public class V2SettingMusicActivity extends Activity implements OnClickListener {
    private V2SettingHeaderBar a;
    private View b;
    private CheckBox c;
    private View d;
    private CheckBox e;
    private a f = null;
    private TextView g;

    private void a() {
        this.a = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.a.setTitle(getString(R.string.v2_setting_music));
        this.a.setBackOnClickListener(new cr(this));
        this.b = findViewById(R.id.switch_open);
        this.d = findViewById(R.id.switch_music_not_show_lock);
        this.c = (CheckBox) findViewById(R.id.switch_check);
        this.e = (CheckBox) findViewById(R.id.switch_check_not_show_lock);
        this.b.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.g = (TextView) findViewById(R.id.v2_setting_switch_music_des);
    }

    private boolean a(CheckBox checkBox) {
        boolean z = !checkBox.isChecked();
        checkBox.setChecked(z);
        return z;
    }

    private void b() {
        this.c.isChecked();
    }

    private void c() {
        String str;
        String[] strArr;
        boolean a = a(this.c);
        this.f.B(a);
        if (an.c(this)) {
            str = "Vlocker_Switch_Show_Music_PPC_TF";
            strArr = new String[2];
            strArr[0] = "status";
        } else {
            str = "Vlocker_Switch_Show_Music_PPC_TF";
            strArr = new String[2];
            strArr[0] = "status";
        }
        strArr[1] = a ? "On" : "Off";
        p.a((Context) this, str, strArr);
        if (a) {
            this.e.setChecked(false);
            this.f.F(false);
            if (VERSION.SDK_INT >= 18) {
                com.vlocker.j.a.a().n();
            }
        } else if (VERSION.SDK_INT >= 18) {
            com.vlocker.j.a.a().p();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r7) {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = r7.getId();
        switch(r0) {
            case 2131428228: goto L_0x000a;
            case 2131428229: goto L_0x0009;
            case 2131428230: goto L_0x0009;
            case 2131428231: goto L_0x001e;
            default: goto L_0x0009;
        };
    L_0x0009:
        return;
    L_0x000a:
        r0 = r6.f;
        r0 = r0.aq();
        if (r0 != 0) goto L_0x0017;
    L_0x0012:
        r0 = r6.f;
        r0.C(r5);
    L_0x0017:
        r6.c();
        r6.b();
        goto L_0x0009;
    L_0x001e:
        r0 = r6.e;
        r1 = r6.a(r0);
        r0 = r6.f;
        r0.F(r1);
        r2 = "Vlocker_Switch_NoLocker_Music_PPC_TF";
        r0 = 2;
        r3 = new java.lang.String[r0];
        r0 = "status";
        r3[r4] = r0;
        if (r1 == 0) goto L_0x0054;
    L_0x0036:
        r0 = "On";
    L_0x0039:
        r3[r5] = r0;
        com.vlocker.b.p.a(r6, r2, r3);
        if (r1 == 0) goto L_0x0050;
    L_0x0040:
        r0 = r6.f;
        r0.B(r4);
        r0 = r6.c;
        r0.setChecked(r4);
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 18;
        if (r0 < r1) goto L_0x0050;
    L_0x0050:
        r6.b();
        goto L_0x0009;
    L_0x0054:
        r0 = "Off";
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.settings.V2SettingMusicActivity.onClick(android.view.View):void");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = a.a((Context) this);
        setContentView(R.layout.l_v2_activity_setting_music);
        a();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (!an.a((Context) this) || VERSION.SDK_INT < 18 || (MoSecurityApplication.e && !SettingService.b((Context) this))) {
            this.e.setChecked(this.f.ar());
            this.b.setVisibility(8);
        } else if (an.c(this)) {
            this.d.setVisibility(8);
            this.f.F(false);
            if (this.f.aq()) {
                boolean ap = this.f.ap();
                this.f.B(ap);
                this.c.setChecked(ap);
            } else {
                this.f.B(true);
                this.c.setChecked(true);
                if (VERSION.SDK_INT >= 18) {
                    com.vlocker.j.a.a().n();
                }
            }
        } else {
            this.g.setText(getString(R.string.v2_setting_switch_music_des_second));
            if (this.f.aq()) {
                this.c.setChecked(this.f.ap());
                this.e.setChecked(this.f.ar());
            } else {
                this.c.setChecked(false);
                this.e.setChecked(this.f.ar());
            }
        }
        b();
    }
}
