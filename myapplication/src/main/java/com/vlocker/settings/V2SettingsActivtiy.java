package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.b.i;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.e.e;
import com.vlocker.locker.R;
import com.vlocker.m.m;
import com.vlocker.ui.widget.V2SettingHeaderBar;
import com.vlocker.update.g;
import java.io.File;
import java.io.IOException;

public class V2SettingsActivtiy extends Activity implements OnClickListener {
    private V2SettingHeaderBar a;
    private TextView b;
    private a c;

    private void a() {
        this.a = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.a.setBackOnClickListener(new de(this));
        ((TextView) findViewById(R.id.setting_msg)).setText(VERSION.SDK_INT < 18 ? getString(R.string.v2_setting_msg) : getString(R.string.v2_setting_msg_redpacket));
        findViewById(R.id.setting_msg_layout).setOnClickListener(this);
        findViewById(R.id.setting_music_layout).setOnClickListener(this);
        findViewById(R.id.setting_toolbox_layout).setOnClickListener(this);
        findViewById(R.id.setting_weather).setOnClickListener(this);
        findViewById(R.id.setting_wallpaper).setOnClickListener(this);
        findViewById(R.id.setting_voice_shake).setOnClickListener(this);
        findViewById(R.id.setting_status_bar).setOnClickListener(this);
        findViewById(R.id.setting_delay_lock).setOnClickListener(this);
        if (this.c.bY()) {
            findViewById(R.id.setting_charge).setVisibility(0);
        } else {
            findViewById(R.id.setting_charge).setVisibility(8);
        }
        if (j.a((Context) this, "com.moxiu.launcher")) {
            findViewById(R.id.setting_launcher_entry_layout).setVisibility(8);
        } else {
            findViewById(R.id.setting_launcher_entry_layout).setVisibility(0);
        }
        findViewById(R.id.setting_launcher_entry_layout).setOnClickListener(this);
        findViewById(R.id.setting_charge).setOnClickListener(this);
        this.b = (TextView) findViewById(R.id.setting_delay_lock_des);
        a(false);
    }

    private void a(boolean z) {
        int an = a.a((Context) this).an();
        if (an == 0) {
            if (z) {
                this.b.setText(R.string.l_setting_lockertime_now);
            } else {
                this.b.setText(R.string.l_setting_lockertime_now);
            }
        } else if (an == 1) {
            if (z) {
                this.b.setText(R.string.l_setting_lockertime_first);
            } else {
                this.b.setText(R.string.l_setting_lockertime_first);
            }
        } else if (an == 2) {
            if (z) {
                this.b.setText(R.string.l_setting_lockertime_second);
            } else {
                this.b.setText(R.string.l_setting_lockertime_second);
            }
        } else if (an == 3) {
            if (z) {
                this.b.setText(R.string.l_setting_lockertime_third);
            } else {
                this.b.setText(R.string.l_setting_lockertime_third);
            }
        } else if (an == 4) {
            if (z) {
                this.b.setText(R.string.l_setting_lockertime_four);
            } else {
                this.b.setText(R.string.l_setting_lockertime_four);
            }
        } else if (an == 5) {
            if (z) {
                this.b.setText(R.string.l_setting_lockertime_five);
            } else {
                this.b.setText(R.string.l_setting_lockertime_five);
            }
        }
    }

    private void b() {
        File file = new File(i.g + "vlocker_launcher" + ".apk");
        if (file.exists()) {
            p.a((Context) this, "Vlock_Set_Moxiuclick_CY", "scene", "install");
            try {
                Object a = g.a(file);
                if (!TextUtils.isEmpty(a) && a.equals(com.vlocker.update.i.a((Context) this))) {
                    Uri fromFile = Uri.fromFile(file);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                    startActivity(intent);
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (j.h(this).booleanValue()) {
            p.a((Context) this, "Vlock_Set_Moxiuclick_CY", "scene", "download");
            new e(this).a("setting_view");
            return;
        }
        p.a((Context) this, "Vlock_Set_Moxiuclick_CY", "scene", "not");
        Toast.makeText(this, "请在wifi环境下载", 1).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_msg_layout:
                p.a((Context) this, "Vlocker_Click_Msg_Settings_PPC_TF", new String[0]);
                NotificationSettingActivity.a((Context) this);
                findViewById(R.id.setting_msg_hint).setVisibility(4);
                this.c.aB(true);
                return;
            case R.id.setting_music_layout:
                p.a((Context) this, "Vlocker_Click_Music_Settings_PPC_TF", new String[0]);
                startActivity(new Intent(this, V2SettingMusicActivity.class));
                return;
            case R.id.setting_toolbox_layout:
                p.a((Context) this, "Vlocker_Click_Toolbox_Camera_Settings_PPC_TF", new String[0]);
                startActivity(new Intent(this, V2SettingToolboxActivity.class));
                findViewById(R.id.setting_toolbox_hint).setVisibility(4);
                this.c.aA(true);
                return;
            case R.id.setting_weather:
                p.a((Context) this, "Vlocker_Click_Weather_Settings_PPC_TF", new String[0]);
                WeatherSettingsActivity.a((Context) this);
                return;
            case R.id.setting_charge:
                startActivity(new Intent(this, ChargeSettingActivity.class));
                return;
            case R.id.setting_launcher_entry_layout:
                if (j.a((Context) this, "com.moxiu.launcher")) {
                    Toast.makeText(this, "已安装桌面美化大师", 1).show();
                } else {
                    b();
                }
                this.c.ck();
                return;
            case R.id.setting_wallpaper:
                p.a((Context) this, "Vlocker_Click_Wallpaper_Settings_PPC_TF", new String[0]);
                WallpaperSettingsActivity.a((Activity) this);
                return;
            case R.id.setting_voice_shake:
                p.a((Context) this, "Vlocker_Click_Sound_Viberate_Settings_PPC_TF", new String[0]);
                startActivity(new Intent(this, V2SettingVoiceShakeActivity.class));
                return;
            case R.id.setting_status_bar:
                p.a((Context) this, "Vlocker_Click_StatusBar_Settings_PPC_TF", new String[0]);
                StatusBarSettingsActivity.a((Activity) this);
                return;
            case R.id.setting_delay_lock:
                m mVar = new m(this, new df(this));
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_v2_settings_layout);
        this.c = a.a((Context) this);
        a();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (this.c.ce()) {
            findViewById(R.id.setting_toolbox_hint).setVisibility(4);
        }
        if (this.c.cf() || this.c.bi()) {
            findViewById(R.id.setting_msg_hint).setVisibility(4);
        }
        if (this.c.cl()) {
            findViewById(R.id.setting_launcher_hint).setVisibility(8);
        }
    }
}
