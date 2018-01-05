package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.a.b;
import com.vlocker.msg.an;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.SettingService;
import com.vlocker.ui.widget.V2SettingHeaderBar;

public class NotificationSettingActivity extends Activity {
    boolean a = false;
    private a b = null;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private V2SettingHeaderBar h;
    private OnClickListener i = new bm(this);

    private void a() {
        if (this.b.bi()) {
            findViewById(R.id.notify_app_select_hint).setVisibility(4);
            findViewById(R.id.notify_enable_hint).setVisibility(4);
        } else if (an.b(this)) {
            findViewById(R.id.notify_app_select_hint).setVisibility(0);
            findViewById(R.id.notify_enable_hint).setVisibility(4);
        } else if (this.b.aC()) {
            this.b.U(true);
            findViewById(R.id.notify_app_select_hint).setVisibility(4);
            findViewById(R.id.notify_enable_hint).setVisibility(4);
        } else {
            findViewById(R.id.notify_app_select_hint).setVisibility(4);
            findViewById(R.id.notify_enable_hint).setVisibility(0);
        }
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, NotificationSettingActivity.class));
    }

    private void a(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(R.drawable.l_setting_on);
        } else {
            imageView.setImageResource(R.drawable.l_setting_off);
        }
    }

    private void b() {
        if (!an.a((Context) this) || VERSION.SDK_INT < 18) {
            findViewById(R.id.setting_redpacket_layout).setVisibility(8);
            findViewById(R.id.setting_redpacket_title).setVisibility(8);
        }
        this.f = (TextView) findViewById(R.id.notify_app_select_tv);
        this.e = (TextView) findViewById(R.id.notify_show_tv);
        this.g = (TextView) findViewById(R.id.notify_enable_private_tv);
        this.h = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.h.setTitle(VERSION.SDK_INT < 18 ? getString(R.string.v2_setting_msg) : getString(R.string.v2_setting_msg_redpacket));
        this.h.setBackOnClickListener(new bl(this));
        this.c = (ImageView) findViewById(R.id.notify_enable_img);
        this.d = (ImageView) findViewById(R.id.notify_enable_private_img);
        findViewById(R.id.notify_enable_layout).setOnClickListener(this.i);
        findViewById(R.id.notify_enable_private_layout).setOnClickListener(this.i);
        findViewById(R.id.notify_app_select_layout).setOnClickListener(this.i);
        findViewById(R.id.notify_show_layout).setOnClickListener(this.i);
        findViewById(R.id.setting_redpacket_layout).setOnClickListener(this.i);
        if (VERSION.SDK_INT < 18 || (MoSecurityApplication.e && !SettingService.b((Context) this))) {
            findViewById(R.id.notify_enable_private_layout).setVisibility(8);
            findViewById(R.id.notify_app_select_layout).setVisibility(8);
            ((TextView) findViewById(R.id.notify_enable_des)).setText(getString(R.string.v2_setting_msg_4142_hint));
        }
    }

    private void c() {
        p.a((Context) this, "Vlocker_Click_Light_Msg_PPC_TF", new String[0]);
        if (an.b(this)) {
            NotificationLightActivity.a((Context) this);
        } else {
            f();
        }
    }

    private void d() {
        boolean z = !this.b.aB();
        this.b.K(z);
        a(this.c, z);
        if (!z) {
            com.vlocker.msg.p.a().d();
            this.b.M(false);
            this.b.O(false);
            this.b.P(false);
            a(this.d, false);
        }
        if (an.b(this)) {
            String str = "Vlocker_Switch_MsgNotify_PPC_TF";
            String[] strArr = new String[2];
            strArr[0] = "status";
            strArr[1] = z ? "On" : "Off";
            p.a((Context) this, str, strArr);
            return;
        }
        this.a = true;
        f();
    }

    private void e() {
        String str;
        String[] strArr;
        boolean z = !this.b.aD();
        this.b.M(z);
        a(this.d, z);
        Log.i("kevint", "enableHiddenPrivateNotify==mConfig.getHiddenPrivateNotifyEnabled()==" + this.b.aD());
        if (z) {
            str = "Vlocker_Switch_NoDetail_Msg_PPC_TF";
            strArr = new String[2];
            strArr[0] = "status";
        } else {
            str = "Vlocker_Switch_NoDetail_Msg_PPC_TF";
            strArr = new String[2];
            strArr[0] = "status";
        }
        strArr[1] = z ? "On" : "Off";
        p.a((Context) this, str, strArr);
        if (an.b(this)) {
            this.b.K(true);
            a(this.c, true);
            return;
        }
        f();
    }

    private void f() {
        try {
            p.a((Context) this, "Vlocker_Open_Msg_Service_PPC_TF", new String[0]);
            b.a(this).a();
        } catch (Exception e) {
        }
    }

    private void g() {
        finish();
    }

    public void onBackPressed() {
        g();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_notification_settings);
        this.b = a.a((Context) this);
        b();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (an.b(this)) {
            if (this.a) {
                this.a = false;
                if (VERSION.SDK_INT >= 18) {
                    p.a((Context) this, "Vlocker_Success_Msg_Service_PPC_TF", "status", "True");
                }
                p.a((Context) this, "Vlocker_Switch_MsgNotify_PPC_TF", "status", "On");
            }
            if (!this.b.aC()) {
                this.b.K(true);
            }
            if (!this.b.aB()) {
                this.b.O(false);
                this.b.M(false);
            }
            a(this.c, this.b.aB());
            a(this.d, this.b.aD());
            findViewById(R.id.notify_enable_private_layout).setEnabled(true);
            findViewById(R.id.notify_app_select_layout).setEnabled(true);
            findViewById(R.id.notify_show_layout).setEnabled(true);
            this.f.setTextColor(getResources().getColor(R.color.v2_setting_item_title));
            this.e.setTextColor(getResources().getColor(R.color.v2_setting_item_title));
            this.g.setTextColor(getResources().getColor(R.color.v2_setting_item_title));
        } else {
            if (this.a) {
                this.a = false;
                if (VERSION.SDK_INT >= 18) {
                    p.a((Context) this, "Vlocker_Success_Msg_Service_PPC_TF", "status", "False");
                }
            }
            this.b.M(false);
            this.b.O(false);
            this.b.K(false);
            this.b.P(false);
            a(this.d, false);
            a(this.c, false);
            findViewById(R.id.notify_enable_private_layout).setEnabled(false);
            findViewById(R.id.notify_app_select_layout).setEnabled(false);
            findViewById(R.id.notify_show_layout).setEnabled(false);
            this.f.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
            this.e.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
            this.g.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
        }
        a();
    }
}
