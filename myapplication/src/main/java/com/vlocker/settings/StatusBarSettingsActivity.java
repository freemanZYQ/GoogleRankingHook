package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.V2SettingHeaderBar;

public class StatusBarSettingsActivity extends BaseBinderActivity implements OnClickListener {
    private a a = null;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private V2SettingHeaderBar e;
    private TextView f;
    private boolean g = false;

    private void a() {
        this.e = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.e.setTitle(getString(R.string.v2_setting_statusbar));
        this.e.setBackOnClickListener(new co(this));
        this.b = (ImageView) findViewById(R.id.setting_statusbar_show_check);
        this.c = (ImageView) findViewById(R.id.setting_statusbar_hide_check);
        this.d = (ImageView) findViewById(R.id.setting_statusbar_electricity_check);
        findViewById(R.id.setting_statusbar_show_layout).setOnClickListener(this);
        findViewById(R.id.setting_statusbar_hide_layout).setOnClickListener(this);
        findViewById(R.id.setting_statusbar_electricity).setOnClickListener(this);
        this.f = (TextView) findViewById(R.id.setting_statusbar_electricity_tv);
    }

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, StatusBarSettingsActivity.class));
    }

    private void a(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(R.drawable.l_setting_off);
        } else {
            imageView.setImageResource(R.drawable.l_setting_on);
        }
    }

    private void a(boolean z) {
        finish();
    }

    private void b() {
        boolean z = true;
        int ai = this.a.ai();
        a(this.b, ai == 0);
        a(this.c, this.a.aj() == 0);
        Boolean valueOf = Boolean.valueOf(this.a.ak());
        ImageView imageView = this.d;
        if (valueOf.booleanValue()) {
            z = false;
        }
        a(imageView, z);
        if (ai == 0) {
            this.f.setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
        } else {
            this.f.setTextColor(getResources().getColor(R.color.v2_setting_item_title));
        }
    }

    public void onBackPressed() {
        a(false);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_statusbar_hide_layout:
                if (this.a.aj() == 0) {
                    this.a.k(1);
                    p.a((Context) this, "Vlocker_Switch_Disable_Drag_StatusBar_PPC_TF", "status", "On");
                } else {
                    this.a.k(0);
                    p.a((Context) this, "Vlocker_Switch_Disable_Drag_StatusBar_PPC_TF", "status", "Off");
                }
                this.g = true;
                b();
                return;
            case R.id.setting_statusbar_show_layout:
                if (this.a.ai() == 0) {
                    this.a.j(1);
                    p.a((Context) this, "Vlocker_Switch_Hide_StatusBar_PPC_TF", "status", "On");
                } else {
                    this.a.j(0);
                    this.a.x(false);
                    p.a((Context) this, "Vlocker_Switch_Hide_StatusBar_PPC_TF", "status", "Off");
                }
                this.g = true;
                b();
                return;
            case R.id.setting_statusbar_electricity:
                if (this.a.ai() != 0) {
                    if (this.a.ak()) {
                        this.a.x(false);
                        p.a((Context) this, "Vlocker_Switch_Show_BatteryInfo_PPC_TF", "status", "Off");
                    } else {
                        this.a.x(true);
                        p.a((Context) this, "Vlocker_Switch_Show_BatteryInfo_PPC_TF", "status", "On");
                    }
                    b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.l_activity_status_bar_setting);
        getWindow().setBackgroundDrawable(null);
        this.a = a.a((Context) this);
        a();
        b();
        this.g = false;
    }

    protected void onDestroy() {
        if (this.g) {
            p.a((Context) this, this.a);
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }
}
