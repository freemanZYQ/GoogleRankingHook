package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.battery.saver.b;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.V2SettingHeaderBar;

public class ChargeSettingActivity extends Activity implements OnClickListener {
    private V2SettingHeaderBar a;
    private TextView b;
    private CheckBox c;
    private a d = null;

    private void a() {
        this.a = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.a.setTitle(getString(R.string.v2_setting_charge));
        this.a.setBackOnClickListener(new b(this));
        this.b = (TextView) findViewById(R.id.tv_switch_charge_des);
        this.c = (CheckBox) findViewById(R.id.switch_charge_check);
        findViewById(R.id.switch_charge).setOnClickListener(this);
    }

    private boolean a(CheckBox checkBox) {
        boolean z = !checkBox.isChecked();
        checkBox.setChecked(z);
        return z;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.switch_charge:
                boolean a = a(this.c);
                this.d.av(a);
                if (a) {
                    this.b.setVisibility(8);
                    this.d.l(0);
                    return;
                }
                p.a((Context) this, "Vlocker_Close_Charge_Battery_PPC_TF", "source", "in");
                b.a((Context) this).c();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = a.a((Context) this);
        setContentView(R.layout.l_activity_setting_charge);
        a();
    }

    protected void onResume() {
        super.onResume();
        this.c.setChecked(this.d.bX());
        if (System.currentTimeMillis() <= this.d.bZ()) {
            this.b.setVisibility(0);
            this.c.setChecked(false);
            return;
        }
        this.b.setVisibility(8);
    }
}
