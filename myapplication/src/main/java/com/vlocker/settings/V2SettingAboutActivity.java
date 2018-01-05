package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.a.b;
import com.vlocker.m.a.d;
import com.vlocker.m.o;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.OneKeySettingActivity;
import com.vlocker.setting.SettingService;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.k;
import com.vlocker.ui.widget.V2SettingHeaderBar;

public class V2SettingAboutActivity extends Activity implements OnClickListener {
    a a;
    private V2SettingHeaderBar b;
    private TextView c;
    private com.vlocker.m.a.a d;
    private CheckBox e;

    private void a() {
        this.b = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.b.setTitle(getString(R.string.v2_setting_guide_about));
        this.b.setBackOnClickListener(new cq(this));
        findViewById(R.id.big_icon).setOnClickListener(this);
        if ((!SettingService.a((Context) this) || MoSecurityApplication.a) && !MoSecurityApplication.e) {
            findViewById(R.id.setting_about_init_item).setVisibility(8);
        } else {
            findViewById(R.id.setting_about_init_item).setOnClickListener(this);
        }
        findViewById(R.id.setting_about_close_system_lock).setOnClickListener(this);
        findViewById(R.id.setting_about_item).setOnClickListener(this);
        findViewById(R.id.setting_about_feedback_item).setOnClickListener(this);
        findViewById(R.id.setting_about_close_lock).setOnClickListener(this);
        findViewById(R.id.setting_about_question_item).setOnClickListener(this);
        this.c = (TextView) findViewById(R.id.version_code);
        this.c.setText("V " + o.a(this));
        this.e = (CheckBox) findViewById(R.id.close_lock_check);
        this.e.setChecked(this.a.O());
    }

    private boolean a(CheckBox checkBox) {
        boolean z = !checkBox.isChecked();
        checkBox.setChecked(z);
        return z;
    }

    private void b() {
        this.a.m(false);
        this.a.q(false);
        this.a.o(false);
        Toast.makeText(this, getResources().getString(R.string.v2_lock_close_tip), 0).show();
        Intent intent = new Intent(this, V2SettingStartActivity.class);
        intent.putExtra("from", "start");
        startActivity(intent);
        finish();
    }

    private void c() {
        this.a.m(true);
        LockerService.a((Context) this);
        Toast.makeText(this, getResources().getString(R.string.v2_lock_open_tip), 0).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.big_icon:
                p.a((Context) this, "Vlocker_Click_VLogo_Help_PPC_TF", new String[0]);
                return;
            case R.id.setting_about_init_item:
                p.a((Context) this, "Vlocker_Click_Rescue_Locker_PPC_TF", new String[0]);
                OneKeySettingActivity.b(this, "from_SettingsActivity");
                return;
            case R.id.setting_about_close_system_lock:
                p.a((Context) this, "Vlocker_Click_Disable_SystemLocker_PPC_TF", new String[0]);
                if (!this.a.aR()) {
                    this.a.N(true);
                }
                this.d.a(1);
                return;
            case R.id.setting_about_close_lock:
                if (a(this.e)) {
                    p.a((Context) this, "Vlocker_Switch_Enable_Vlocker_PPC_TF", "status", "on");
                    c();
                    return;
                }
                p.a((Context) this, "Vlocker_Switch_Enable_Vlocker_PPC_TF", "status", "off");
                b();
                return;
            case R.id.setting_about_feedback_item:
                p.a((Context) this, "Vlocker_Click_Feedback_Help_PPC_TF", new String[0]);
                startActivity(new Intent(this, FeedBackActivity.class));
                return;
            case R.id.setting_about_question_item:
                p.a((Context) this, "Vlocker_Click_FeedbackQuestion_PPC_TF", "from", "help");
                Intent intent = new Intent(this, FlowWebViewActivity.class);
                intent.putExtra("tag", "normal_question");
                intent.putExtra("title", getString(R.string.feedback_normal_question));
                intent.putExtra("url", "http://mobile.moxiu.com/misc/?do=Vlocker.Help");
                startActivity(intent);
                return;
            case R.id.setting_about_item:
                startActivity(new Intent(this, AboutActivity.class));
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_v2_activity_setting_about);
        this.d = b.a(this);
        this.a = a.a((Context) this);
        a();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (d.b && !k.a(this)) {
            this.d.a(1);
            d.b = false;
        }
    }
}
