package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;

public class ThemeColorSettingsActivity extends Activity implements OnClickListener {
    static int[] e = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    ImageButton a;
    ImageButton b;
    ImageButton c;
    boolean d;
    private a f = null;

    public static void a(Context context) {
        Intent intent = new Intent(context, ThemeColorSettingsActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void c() {
        findViewById(R.id.btn_back_main).setOnClickListener(this);
        findViewById(R.id.settings_ok_click).setOnClickListener(this);
        findViewById(R.id.settings_pattercontent1).setOnClickListener(this);
        findViewById(R.id.settings_pattercontent2).setOnClickListener(this);
        findViewById(R.id.btn_click1_text).setOnClickListener(this);
        findViewById(R.id.btn_click2_text).setOnClickListener(this);
        findViewById(R.id.setting_show_draw_line).setOnClickListener(this);
        this.a = (ImageButton) findViewById(R.id.btn_grid_title_bnt);
        this.a.setOnClickListener(this);
        c(this.f.R());
        this.b = (ImageButton) findViewById(R.id.btn_click1_bnt);
        this.c = (ImageButton) findViewById(R.id.btn_click2_bnt);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        a(this.f.u());
    }

    private void c(boolean z) {
        this.f.p(z);
        if (z) {
            this.a.setImageResource(R.drawable.l_setting_off);
        } else {
            this.a.setImageResource(R.drawable.l_setting_on);
        }
    }

    private void d() {
        e();
        this.d = true;
        finish();
    }

    private void e() {
        if (!this.d && !this.f.v()) {
            QuestionActivity.a((Context) this);
        }
    }

    public void a() {
        try {
            String t = this.f.t();
            if (t != null) {
                for (int i = 0; i < t.length(); i++) {
                    e[i] = Integer.parseInt(t.substring(i, i + 1));
                }
            }
        } catch (Exception e) {
        }
    }

    public void a(boolean z) {
        if (z) {
            this.b.setImageResource(R.drawable.l_theme_color_selected);
            this.c.setImageResource(R.drawable.l_v2_checkbox_circle_normal);
            return;
        }
        this.c.setImageResource(R.drawable.l_theme_color_selected);
        this.b.setImageResource(R.drawable.l_v2_checkbox_circle_normal);
    }

    public void b() {
        try {
            String str = "";
            for (int i : e) {
                str = str + i;
            }
            this.f.f(str);
        } catch (Exception e) {
        }
    }

    public void b(boolean z) {
        if (this.f.u()) {
            if (!z) {
                this.f.h(false);
                e = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                p.a((Context) this, "Vlocker_Selected_Colors_Pattern_PPC_TF", "status", "Single");
                a(false);
                b();
            }
        } else if (z) {
            p.a((Context) this, "Vlocker_Selected_Colors_Pattern_PPC_TF", "status", "Color");
            this.f.h(true);
            e = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            a(true);
            b();
        }
    }

    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case R.id.btn_back_main:
            case R.id.settings_ok_click:
                d();
                return;
            case R.id.setting_show_draw_line:
            case R.id.btn_grid_title_bnt:
                if (this.f.R()) {
                    p.a((Context) this, "Vlocker_Switch_ShowDrawLine_Pattern_PPC_TF", "status", "on");
                } else {
                    p.a((Context) this, "Vlocker_Switch_ShowDrawLine_Pattern_PPC_TF", "status", "off");
                }
                if (this.f.R()) {
                    z = false;
                }
                c(z);
                return;
            case R.id.settings_pattercontent1:
            case R.id.btn_click1_bnt:
            case R.id.btn_click1_text:
                b(true);
                return;
            case R.id.settings_pattercontent2:
            case R.id.btn_click2_bnt:
            case R.id.btn_click2_text:
                b(false);
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f = a.a((Context) this);
        setContentView(R.layout.l_activity_setting_theme_color);
        c();
        this.d = false;
    }

    protected void onDestroy() {
        e();
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (this.f.u()) {
            e = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        } else {
            a();
        }
    }
}
