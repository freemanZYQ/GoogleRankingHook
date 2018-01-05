package com.vlocker.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.vlocker.locker.R;
import com.vlocker.setting.a.a;
import com.vlocker.settings.SettingsActivity;

public class StartGuideActivity extends Activity {
    private boolean a = false;
    private ImageView b;
    private LinearLayout c;
    private Animation d;
    private Animation e;
    private Handler f = new Handler(new y(this));

    private final synchronized void a() {
        if (!this.a) {
            this.a = true;
            if (VERSION.SDK_INT < 16 || a.getInstance().finished()) {
                SettingsActivity.b((Context) this);
            } else {
                OneKeySettingActivity.b(this, "from_StartGuideActivity");
            }
            finish();
            overridePendingTransition(17432576, 17432577);
        }
    }

    public static final void a(Context context) {
        Intent intent = new Intent(context, StartGuideActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void b() {
        this.b = (ImageView) findViewById(R.id.logo);
        this.c = (LinearLayout) findViewById(R.id.app_description);
        this.d = AnimationUtils.loadAnimation(this, R.anim.setting_start_guide_icon);
        this.e = AnimationUtils.loadAnimation(this, R.anim.setting_start_guide_des);
    }

    public void onBackPressed() {
        a();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.getInstance(getApplicationContext()).init();
        setContentView(R.layout.setting_start_guide);
        b();
        this.b.startAnimation(this.d);
        this.c.startAnimation(this.e);
    }

    protected void onDestroy() {
        if (findViewById(R.id.guide_layout) != null) {
            findViewById(R.id.guide_layout).setBackgroundDrawable(null);
        }
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStart() {
        super.onStart();
        this.f.sendEmptyMessageDelayed(0, 3200);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 1) {
            a();
        }
        return super.onTouchEvent(motionEvent);
    }
}
