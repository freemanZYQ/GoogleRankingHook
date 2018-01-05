package com.vlocker.new_theme.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.new_theme.c.a;
import com.vlocker.new_theme.c.f;
import com.vlocker.new_theme.c.j;
import com.vlocker.new_theme.c.q;
import com.vlocker.new_theme.view.TabFragmentIndicator;
import com.vlocker.settings.SettingsActivity;
import com.vlocker.theme.activity.LocationThemeActivity;
import com.vlocker.theme.f.e;

public class ThemeMainActivity extends FragmentActivity {
    public static String m = null;
    public static String n = null;
    public static Boolean o = Boolean.valueOf(true);
    OnClickListener p = new ah(this);
    private RelativeLayout q;
    private ViewPager r;
    private TabFragmentIndicator s;

    private void b(int i) {
        if (e.c((Context) this)) {
            this.r.setCurrentItem(i);
            this.s.d(i);
            this.s.c(i);
            return;
        }
        LocationThemeActivity.a((Context) this);
        Toast.makeText(this, R.string.t_market_vlocker_give_net_dip, 0).show();
        finish();
    }

    private void g() {
        Fragment aVar = new a();
        Fragment fVar = new f();
        Fragment jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putString("type", "hot");
        bundle.putInt("postion", 6);
        Fragment qVar = new q();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "new");
        bundle2.putInt("postion", 5);
        qVar.b(bundle2);
        this.s.a(0, fVar);
        this.s.a(1, aVar);
        this.s.a(2, jVar);
        this.s.a(3, qVar);
        this.s.setTabContainerView(R.layout.layout_home_tabindicator);
        this.r.setOffscreenPageLimit(4);
        this.s.setTabSliderView(R.layout.layout_home_tab_slider);
        this.s.setViewPager(this.r);
        h();
    }

    private void h() {
        String stringExtra = getIntent().getStringExtra("tag");
        if (stringExtra == null || "topic".equals(stringExtra)) {
            b(1);
        } else if ("digest".equals(stringExtra)) {
            b(2);
        } else if ("cate".equals(stringExtra)) {
            b(0);
        } else {
            b(1);
        }
    }

    private void i() {
        this.q = (RelativeLayout) findViewById(R.id.t_titlelayout);
        this.q.setVisibility(0);
        findViewById(R.id.themetab_search).setOnClickListener(this.p);
        findViewById(R.id.themetab_searchdetail_back).setOnClickListener(this.p);
        ((ImageView) findViewById(R.id.t_main_home_local_image)).setOnClickListener(this.p);
        this.r = (ViewPager) findViewById(R.id.viewPager);
        this.s = (TabFragmentIndicator) findViewById(R.id.tabFragmentIndicator);
    }

    private void j() {
        startActivity(new Intent(this, SettingsActivity.class));
        finish();
    }

    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawable(null);
            setContentView(R.layout.t_moxiuframe_content_frame);
            i();
            g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onDestroy() {
        findViewById(R.id.moxiuframe_center_layout).setBackgroundDrawable(null);
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        j();
        return true;
    }
}
