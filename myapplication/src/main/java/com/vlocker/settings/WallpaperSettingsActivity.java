package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.V2SettingHeaderBar;
import com.vlocker.weather.e.j;

public class WallpaperSettingsActivity extends BaseBinderActivity implements OnClickListener {
    private a a = null;
    private int b = 0;
    private V2SettingHeaderBar c;
    private boolean d = false;
    private boolean e;

    private void a() {
        this.c = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.c.setTitle(getString(R.string.v2_setting_wallpaper));
        this.c.setBackOnClickListener(new dg(this));
        findViewById(R.id.setting_wallpaper_user_define_layout).setOnClickListener(this);
        findViewById(R.id.setting_wallpaper_screen_layout).setOnClickListener(this);
    }

    public static void a(Activity activity) {
        activity.startActivityForResult(new Intent(activity, WallpaperSettingsActivity.class), 10086);
    }

    private void a(boolean z) {
        this.e = false;
        if (!this.d) {
            this.d = true;
            if (!getIntent().getBooleanExtra("extra_from_cover", false)) {
                finish();
            } else if (z) {
                this.e = true;
                finish();
            } else {
                this.e = true;
                finish();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 256 && i2 == -1) {
            this.b = 2;
            this.a.h(2);
            this.a.D(false);
            this.a.w(false);
            this.a.i(0);
            j.g(this);
            setResult(10010);
            a(false);
        }
    }

    public void onBackPressed() {
        a(false);
    }

    public void onClick(View view) {
        if (!this.d) {
            switch (view.getId()) {
                case R.id.setting_wallpaper_screen_layout:
                    p.a((Context) this, "Vlocker_Click_Launcher_Wallpaper_PPC_TF", new String[0]);
                    this.a.h(1);
                    this.a.D(false);
                    this.a.w(false);
                    this.a.i(0);
                    this.a.q("");
                    j.g(this);
                    Toast.makeText(this, R.string.setting_wallpaper_restore_to_screen_tip, 0).show();
                    setResult(10010);
                    a(false);
                    return;
                case R.id.setting_wallpaper_user_define_layout:
                    this.b = 1;
                    p.a((Context) this, "Vlocker_Click_Custom_Wallpaper_PPC_TF", new String[0]);
                    ChooseWallpaperActivity.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.l_activity_wallpaper_setting);
        getWindow().setBackgroundDrawable(null);
        this.a = a.a((Context) this);
        a();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }
}
