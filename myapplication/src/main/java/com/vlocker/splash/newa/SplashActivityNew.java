package com.vlocker.splash.newa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.splash.a.c;
import com.vlocker.splash.a.f;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.ui.view.GifImageView;
import java.util.Date;
import java.util.List;

public class SplashActivityNew extends Activity implements OnClickListener, d {
    long a;
    c b;
    ViewGroup c;
    GifImageView d;
    ViewGroup e;
    View f;
    RecyclingImageView g;
    List h;
    a i;
    private Handler j = new g(this);

    private void b() {
        a a = a.a((Context) this);
        int date = new Date().getDate();
        if (a.cm() != date) {
            a.O(date);
            a.P(0);
        }
        a.P(a.cn() + 1);
        p.a((Context) this, "Vlock_Splash_Show_LZS", "time", date + "");
    }

    private void c() {
        this.c = (ViewGroup) findViewById(R.id.splashcontainer);
        this.d = (GifImageView) findViewById(R.id.iv_splash_ad);
        this.e = (ViewGroup) findViewById(R.id.splashcontainercover);
        this.g = (RecyclingImageView) findViewById(R.id.iv_splash_ad_label);
        this.f = findViewById(R.id.iv_splash_skip);
        this.f.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    public a a(com.moxiu.b.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        String str = aVar.C;
        return "ade".equals(str) ? new f(this.e, aVar, this.j) : "baidu".equals(str) ? new com.vlocker.splash.a.a(this.e, aVar, this.j) : "dianou".equals(str) ? new c(aVar, this.d, this.j) : null;
    }

    public void a() {
        this.j.sendEmptyMessage(53);
        finish();
        overridePendingTransition(17432576, 17432577);
    }

    public void a(List list) {
        this.h = list;
        this.j.sendEmptyMessage(36);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_splash_skip:
                p.a((Context) this, "Vlock_Skipscreen_Time_PPC_LZS", new String[0]);
                a();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.j.sendEmptyMessageDelayed(50, 4000);
            this.b = new e(this, this.j);
            this.b.a();
            setContentView(R.layout.l_activity_splash_new);
            c();
            b();
        } catch (Exception e) {
            e.printStackTrace();
            a();
        } finally {
            this.a = System.currentTimeMillis();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (findViewById(R.id.rl_splash_layout) != null) {
            findViewById(R.id.rl_splash_layout).setBackgroundDrawable(null);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 && i != 3) {
            return super.onKeyDown(i, keyEvent);
        }
        Log.e("splash", "key back or key home");
        return true;
    }

    protected void onPause() {
        super.onPause();
    }
}
