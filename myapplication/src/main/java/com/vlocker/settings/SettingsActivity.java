package com.vlocker.settings;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.f.j;
import com.vlocker.locker.R;
import com.vlocker.m.a.b;
import com.vlocker.m.a.d;
import com.vlocker.m.h;
import com.vlocker.m.l;
import com.vlocker.m.o;
import com.vlocker.msg.an;
import com.vlocker.new_theme.activity.ThemeMainActivity;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.StartGuideActivity;
import com.vlocker.splash.newa.SplashActivityNew;
import com.vlocker.theme.activity.LocationThemeActivity;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.y;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.k;
import com.vlocker.ui.view.WaveAnimView;
import com.vlocker.ui.view.ao;
import com.vlocker.ui.widget.V2GuideBannerView;
import com.vlocker.update.i;

public class SettingsActivity extends BaseBinderActivity implements OnClickListener {
    public static boolean b;
    public static boolean c;
    SharedPreferences a;
    private a d = null;
    private boolean e = false;
    private V2GuideBannerView f;
    private boolean g = false;
    private TextView h;
    private WaveAnimView i;
    private Handler j;
    private boolean k = false;
    private boolean l;
    private long m;
    private ao n;

    private int a(boolean z) {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        defaultDisplay.getMetrics(new DisplayMetrics());
        return z ? defaultDisplay.getWidth() : defaultDisplay.getHeight();
    }

    private void a(int i) {
        a(findViewById(R.id.main_pwd_img_layout), ((float) i) * 0.08f);
        a(findViewById(R.id.main_theme_img_layout), ((float) i) * 0.53f);
        a(findViewById(R.id.main_setting_img_layout), ((float) i) * 0.3f);
        a(findViewById(R.id.main_about_img_layout), ((float) i) * 0.75f);
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        intent.setFlags(268468224);
        context.startActivity(intent);
    }

    private void a(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.setMargins((int) f, layoutParams.topMargin, 0, 0);
        view.setLayoutParams(layoutParams);
    }

    public static void b(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void c() {
        if (k.a(this)) {
            Dialog create = new Builder(this).create();
            LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_disable_sys_locker_url, null);
            linearLayout.findViewById(R.id.btn_close_lock).setOnClickListener(new ck(this, create));
            TextView textView = (TextView) linearLayout.findViewById(R.id.txt_url);
            ((TextView) linearLayout.findViewById(R.id.txt_tips)).setText(R.string.dont_close_system_lock);
            textView.setVisibility(8);
            create.show();
            create.getWindow().setGravity(16);
            create.getWindow().setContentView(linearLayout);
            create.setCanceledOnTouchOutside(true);
            p.a((Context) this, "Vlock_View_Close_SystemPw_PPC_TF", "location", "home_popup");
        }
    }

    public static void c(Context context) {
        if (e.c(context)) {
            Intent intent = new Intent();
            intent.setClass(context, ThemeMainActivity.class);
            intent.putExtra("from", "wallpaper");
            context.startActivity(intent);
            return;
        }
        LocationThemeActivity.a(context);
    }

    private void d(Context context) {
        this.l = true;
        new cl(this, context).start();
    }

    private boolean d() {
        Intent intent = getIntent();
        return (intent == null || intent.getAction() == null || (!intent.getAction().equals("android.intent.action.MAIN") && !intent.getAction().equals("android.intent.action.VIEW"))) ? false : true;
    }

    private void e() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_viewpager_layout);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = ((a(true) - l.a(30.0f)) * 3) / 4;
        frameLayout.setLayoutParams(layoutParams);
    }

    private void e(Context context) {
        Intent intent = new Intent();
        intent.setClass(this, SplashActivityNew.class);
        intent.setFlags(268435456);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    private void f() {
        if (this.a == null) {
            this.a = i.b(this);
        }
        if (this.a.getInt("update_service_ver", 0) > o.b(this)) {
            if (findViewById(R.id.guide_version_small_icon) != null) {
                findViewById(R.id.guide_version_small_icon).setVisibility(0);
            }
            if (this.h != null) {
                this.h.setText("V " + o.a(this));
            }
            this.g = true;
            return;
        }
        if (findViewById(R.id.guide_version_small_icon) != null) {
            findViewById(R.id.guide_version_small_icon).setVisibility(8);
        }
        if (this.h != null) {
            this.h.setText(R.string.v2_setting_about_feedback);
        }
        this.g = false;
    }

    private void g() {
        this.j.postDelayed(new cm(this, j.a()), 500);
    }

    private void h() {
        this.d.aj(true);
        if (this.n == null || !this.n.isShowing()) {
            this.n = new ao(this, R.style.aiVlockerTimeDialog);
            this.n.setCanceledOnTouchOutside(true);
            this.n.c(R.layout.l_dialog_red_packet_main);
            this.n.d.setOnClickListener(this);
            this.n.e.setOnClickListener(this);
        }
    }

    private void i() {
        this.f = (V2GuideBannerView) findViewById(R.id.guide_banner);
        findViewById(R.id.guide_theme).setOnClickListener(this);
        findViewById(R.id.guide_pwd).setOnClickListener(this);
        findViewById(R.id.guide_settings).setOnClickListener(this);
        findViewById(R.id.guide_about).setOnClickListener(this);
        findViewById(R.id.guide_theme_tv).setOnClickListener(this);
        findViewById(R.id.guide_pwd_tv).setOnClickListener(this);
        findViewById(R.id.guide_settings_tv).setOnClickListener(this);
        findViewById(R.id.guide_about_tv).setOnClickListener(this);
        this.h = (TextView) findViewById(R.id.guide_version_text);
        this.h.setText("V " + o.a(this));
        this.h.setOnClickListener(this);
        this.a = i.b(this);
        e();
        this.i = (WaveAnimView) findViewById(R.id.guide_theme_wave);
    }

    private void j() {
        finish();
    }

    public void a() {
        if (com.vlocker.b.o.noNetStatus != com.vlocker.b.j.b((Context) this)) {
            b();
        } else {
            Toast.makeText(this, getResources().getString(R.string.vlocker_setting_update_app_nonetdip), 0).show();
        }
    }

    public void b() {
        com.vlocker.update.a.d();
        if (this.d.cT()) {
            this.d.aL(false);
        }
        this.d.r(System.currentTimeMillis());
        new com.vlocker.update.a(this, 0, true).b();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10086 && i2 == 10010) {
            finish();
        }
    }

    public void onBackPressed() {
        j();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close_dialog:
                if (this.n != null) {
                    this.n.dismiss();
                    return;
                }
                return;
            case R.id.new_sure_btn:
                Intent intent = new Intent(this, RedPacketActivity.class);
                intent.putExtra("from", com.vlocker.setting.a.a.e.ACTION_MAIN);
                startActivity(intent);
                if (this.n != null) {
                    this.n.dismiss();
                    return;
                }
                return;
            case R.id.guide_theme:
            case R.id.guide_theme_tv:
                p.a(this, "v_click", "102000", "102001");
                p.b("102000", "");
                this.d.aF(false);
                c((Context) this);
                return;
            case R.id.guide_pwd:
            case R.id.guide_pwd_tv:
                if (this.d.S() || this.d.Q()) {
                    LockerSettingsActivity.a((Context) this);
                } else {
                    PasswordSettingsActivity.a((Context) this);
                }
                p.a(this, "v_click", "102000", "102002");
                p.b("102000", "");
                findViewById(R.id.guide_pwd_hint).setVisibility(4);
                this.d.az(false);
                return;
            case R.id.guide_settings:
            case R.id.guide_settings_tv:
                p.a(this, "v_click", "102000", "102003");
                p.b("102000", "");
                startActivity(new Intent(this, V2SettingsActivtiy.class));
                findViewById(R.id.guide_settings_hint).setVisibility(4);
                this.d.ay(true);
                return;
            case R.id.guide_about:
            case R.id.guide_about_tv:
                p.a(this, "v_click", "102000", "102004");
                p.b("102000", "");
                startActivity(new Intent(this, V2SettingAboutActivity.class));
                return;
            case R.id.guide_version:
            case R.id.guide_version_text:
                Log.i("kevint", "guide_version_text===version check");
                if (this.g) {
                    p.a((Context) this, "Vlocker_Click_Update_PPC_TF", "status", "SettingHome");
                    a();
                } else {
                    p.a(this, "v_click", "102000", "102005");
                    FeedBackActivity.a = true;
                    startActivity(new Intent(this, FeedBackActivity.class));
                }
                p.b("102000", "");
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = a.a((Context) this);
        if (this.d.s()) {
            this.d.g(false);
            LockerService.a((Context) this);
            finish();
            return;
        }
        if (!(MoSecurityApplication.a || h.a((Context) this, "com.moxiu.launcher"))) {
            com.vlocker.e.j.a().a("1");
        }
        System.out.println("hello world");
        this.j = new Handler();
        boolean z = this.d.aK() && com.vlocker.b.j.f(this) && d() && this.d.O() && !this.d.q();
        if (z) {
            d((Context) this);
        }
        if (!an.a((Context) this) || VERSION.SDK_INT < 18) {
            this.d.aj(true);
            this.d.ag(true);
        } else {
            this.e = an.b(this);
        }
        if (VERSION.SDK_INT <= 17) {
            this.d.U(true);
        } else if (this.d.ao()) {
            this.d.V(false);
            this.d.W(true);
        }
        if (!this.d.aK() && !MoSecurityApplication.a) {
            this.d.aL();
            StartGuideActivity.a((Context) this);
            finish();
        } else if (this.d.O()) {
            requestWindowFeature(1);
            setContentView(R.layout.l_v2_activity_main);
            i();
            if (this.f != null) {
                this.f.c();
            }
            p.a((Context) this, "Vlock_EnterTimes_MainMenu_LZS", new String[0]);
            if (i.b()) {
                com.vlocker.update.a.a((Context) this, new ci(this));
            } else if (getIntent().getBooleanExtra("forceUpdateDialog", false) || ((this.d.cT() || this.d.cU()) && System.currentTimeMillis() - this.d.cV() > 10800000)) {
                b();
            }
            int a = a(true);
            if (a.a((Context) this).ay() != a) {
                a.a((Context) this).m(a);
            }
            a(a);
            Thread cjVar = new cj(this);
            cjVar.setPriority(3);
            cjVar.start();
            b = true;
            e.a(getApplicationContext());
            this.d.di();
            g();
        } else {
            Intent intent = new Intent(this, V2SettingStartActivity.class);
            intent.putExtra("from", "start");
            startActivity(intent);
            finish();
        }
    }

    protected void onDestroy() {
        if (this.j != null) {
            this.j.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
        if (this.f != null) {
            this.f.g();
        }
        y.a().b(1);
        if (findViewById(R.id.setting_main_layout) != null) {
            findViewById(R.id.setting_main_layout).setBackgroundDrawable(null);
        }
        MoSecurityApplication.a().e();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            b = true;
            if (this.f != null) {
                this.f.g();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onNewIntent(Intent intent) {
        if (intent.getBooleanExtra("forceUpdateDialog", false)) {
            b();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.f != null) {
            this.f.f();
        }
        this.i.b();
    }

    protected void onResume() {
        super.onResume();
        com.vlocker.b.j.m(this);
        if (this.d.O()) {
            p.a("102000");
            boolean z;
            if (!d.b || k.a(this)) {
                z = false;
            } else {
                b.a(this).a(1);
                d.b = false;
                z = true;
            }
            if (this.d.cc()) {
                findViewById(R.id.guide_settings_hint).setVisibility(4);
            }
            if (!this.d.cd() || j.a() == null) {
                findViewById(R.id.guide_pwd_hint).setVisibility(4);
                this.d.az(false);
            }
            try {
                f();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f != null) {
                this.f.b();
            }
            b = false;
            com.vlocker.b.a.a(this);
            if (this.l) {
                this.m = 1500;
                this.l = false;
                return;
            }
            if (this.d.cj()) {
                this.j.postDelayed(new cn(this), this.m);
            }
            if (this.k && !r0) {
                Intent intent = new Intent();
                intent.setClass(this, PasswordSettingsActivity.class);
                intent.putExtra("from_system_setting", true);
                startActivity(intent);
                this.k = false;
            }
            if (com.vlocker.f.b.a) {
                com.vlocker.f.b.a().d();
            }
            if (!(!c || com.vlocker.f.i.b || k.a(this))) {
                Toast.makeText(this, "点击”密码“进一步保护手机安全", 1).show();
                c = false;
            }
            if (com.vlocker.f.i.d) {
                j.a().a((Context) this);
                com.vlocker.f.i.d = false;
                return;
            }
            return;
        }
        intent = new Intent(this, V2SettingStartActivity.class);
        intent.putExtra("from", "start");
        startActivity(intent);
        finish();
    }

    protected void onStop() {
        super.onStop();
        if (this.f != null) {
            this.f.f();
        }
        p.b();
        if (this.d.cW()) {
            this.d.aN(false);
        }
    }
}
