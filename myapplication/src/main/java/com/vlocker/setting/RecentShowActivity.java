package com.vlocker.setting;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.a.a.e;

public class RecentShowActivity extends Activity {
    private static RecentShowActivity f;
    private WindowManager a;
    private View b;
    private View c;
    private LayoutParams d;
    private LayoutParams e;
    private String g;
    private int h;
    private boolean i;
    private Handler j = new Handler();
    private Runnable k = new n(this);

    public static void a() {
        if (f != null) {
            f.finish();
        }
    }

    private boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(IXAdRequestInfo.ACT);
        String stringExtra2 = intent.getStringExtra("packageName");
        this.g = intent.getStringExtra("activity");
        this.h = intent.getIntExtra("recent_type", 0);
        return this.g != null ? a(getApplicationContext(), stringExtra, stringExtra2, this.g) : SettingService.a() != null && SettingService.a().performGlobalAction(3);
    }

    private void d() {
        try {
            if (this.d == null) {
                this.d = b();
            }
            if (this.b.getParent() == null) {
                this.a.addView(this.b, this.d);
            }
        } catch (Exception e) {
        }
    }

    private void e() {
        try {
            if (this.c != null && this.c.getParent() == null) {
                this.a.addView(this.c, this.e);
            }
        } catch (Exception e) {
        }
    }

    private void f() {
        try {
            if (this.b.getParent() != null) {
                this.a.removeViewImmediate(this.b);
            }
            if (this.c != null && this.c.getParent() != null) {
                this.a.removeViewImmediate(this.c);
            }
        } catch (Exception e) {
        }
    }

    public void a(Context context) {
        try {
            View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.guide_recent_toast, null);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(119, 0, 0);
            toast.setDuration(1);
            toast.setView(inflate);
            toast.show();
        } catch (Exception e) {
        }
    }

    public boolean a(Context context, String str, String str2, String str3) {
        Intent intent;
        if (str == null) {
            try {
                intent = new Intent();
            } catch (Exception e) {
                return false;
            }
        } else if (e.ACTION_MAIN.equals(str)) {
            intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
        } else {
            intent = new Intent(str);
        }
        intent.setComponent(new ComponentName(str2, str3));
        intent.addFlags(268435456);
        context.startActivity(intent);
        return true;
    }

    public LayoutParams b() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.systemUiVisibility = 1;
        if (this.g == null) {
            layoutParams.type = 2010;
        } else if (VERSION.SDK_INT <= 18) {
            layoutParams.type = 2002;
        } else {
            layoutParams.type = 2005;
        }
        layoutParams.gravity = 80;
        layoutParams.format = 1;
        layoutParams.flags = 1064;
        layoutParams.width = -1;
        layoutParams.height = this.a.getDefaultDisplay().getHeight() / 4;
        return layoutParams;
    }

    public LayoutParams c() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.systemUiVisibility = 1;
        layoutParams.type = 2010;
        layoutParams.gravity = 48;
        layoutParams.format = 1;
        layoutParams.flags = 1064;
        layoutParams.width = -1;
        layoutParams.height = -2;
        return layoutParams;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = true;
        setContentView(R.layout.guide_recent_page);
        this.a = (WindowManager) getApplication().getSystemService("window");
        this.b = new View(MoSecurityApplication.a());
        this.b.setBackgroundColor(0);
        this.c = getLayoutInflater().inflate(R.layout.guide_recent_toast, null);
        this.e = c();
        this.j.postDelayed(this.k, 10000);
        getWindow().getDecorView().setOnTouchListener(new o(this));
        f = this;
    }

    protected void onDestroy() {
        f = null;
        f();
        this.j.removeCallbacks(this.k);
        this.j.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.i) {
            this.j.postDelayed(new p(this), 200);
            this.j.postDelayed(new q(this), 400);
            this.i = false;
        }
    }
}
