package com.vlocker.settings;

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
import com.vlocker.m.h;
import com.vlocker.ui.view.ao;
import com.vlocker.ui.widget.V2SettingHeaderBar;
import com.vlocker.ui.widget.aa;
import com.vlocker.weather.b.c;
import com.vlocker.weather.e.d;

public class WeatherSettingsActivity extends BaseBinderActivity implements OnClickListener {
    private ImageView a = null;
    private a b = null;
    private TextView c;
    private V2SettingHeaderBar d;
    private ao e;

    private void a() {
        if (a.a((Context) this).I()) {
            this.c.setText(R.string.use_my_location);
            return;
        }
        CharSequence C = a.a((Context) this).C();
        if (C == null || C.equals("null") || C.length() <= 0) {
            this.c.setText(R.string.not_set);
        } else {
            this.c.setText(C);
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, WeatherSettingsActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
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

    private void a(boolean z) {
        a(this.a, z);
        this.b.s(z);
        if (z) {
            d.a((Context) this, "Weather(V)_SettingWeatherSwitch_PPC_YZY", "state", "on");
            a.a((Context) this).k(true);
            c.a(getApplicationContext()).a(true);
        } else {
            d.a((Context) this, "Weather(V)_SettingWeatherSwitch_PPC_YZY", "state", "off");
        }
        if (z && !h.a(this)) {
            d();
        }
    }

    private void b() {
        this.d = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.d.setTitle(getString(R.string.v2_setting_weather));
        this.d.setBackOnClickListener(new dh(this));
        this.a = (ImageView) findViewById(R.id.setting_show_weather_img);
        this.c = (TextView) findViewById(R.id.setting_city_desc_tv);
        this.a.setOnClickListener(this);
        findViewById(R.id.setting_temperature_layout).setOnClickListener(this);
        findViewById(R.id.setting_windspeed_layout).setOnClickListener(this);
        findViewById(R.id.setting_city_layout).setOnClickListener(this);
        findViewById(R.id.setting_show_weather_layout).setOnClickListener(this);
        findViewById(R.id.setting_temperature_layout).setVisibility(8);
        findViewById(R.id.setting_windspeed_layout).setVisibility(8);
    }

    private void c() {
        a(this.a, this.b.W());
    }

    private void d() {
        aa aaVar = new aa(this);
        aaVar.a(R.string.weather_tips_network);
        aaVar.b(R.string.dialog_quit, null);
        aaVar.a(R.string.dialog_connect, new di(this));
        aaVar.b().setCanceledOnTouchOutside(true);
    }

    private void e() {
        try {
            if (this.e != null) {
                if (this.e.isShowing()) {
                    this.e.dismiss();
                }
                this.e = null;
            }
            this.e = new ao(this, R.style.aiVlockerFeedbackDialog);
            this.e.setCanceledOnTouchOutside(true);
            this.e.a(R.layout.l_weather_dialog);
            this.e.e.setText(R.string.dialog_weather_close_close);
            this.e.a.setText(R.string.dialog_weather_close_title);
            this.e.d.setText(R.string.dialog_weather_close_sure);
            this.e.d.setOnClickListener(new dj(this));
            this.e.e.setOnClickListener(new dk(this));
        } catch (Exception e) {
            if (this.e != null && this.e.isShowing()) {
                this.e.dismiss();
            }
        }
    }

    public void onClick(View view) {
        boolean z = false;
        switch (view.getId()) {
            case R.id.setting_city_layout:
                p.a((Context) this, "Vlocker_Click_Location_Setting_PPC_TF", new String[0]);
                CitySelectActivity.a((Context) this, false);
                return;
            case R.id.setting_show_weather_img:
            case R.id.setting_show_weather_layout:
                if (!this.b.W()) {
                    z = true;
                }
                if (z) {
                    a(z);
                    return;
                } else {
                    e();
                    return;
                }
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.l_activity_weather_setting);
        getWindow().setBackgroundDrawable(null);
        this.b = a.a((Context) this);
        b();
        c();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        a();
        a(this.a, this.b.W());
        super.onResume();
    }
}
