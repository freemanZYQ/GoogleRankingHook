package com.vlocker.new_theme.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;
import com.vlocker.theme.activity.LocationThemeActivity;

class ah implements OnClickListener {
    final /* synthetic */ ThemeMainActivity a;

    ah(ThemeMainActivity themeMainActivity) {
        this.a = themeMainActivity;
    }

    public void onClick(View view) {
        System.gc();
        switch (view.getId()) {
            case R.id.themetab_searchdetail_back:
                this.a.j();
                return;
            case R.id.themetab_search:
                Intent intent = new Intent();
                intent.setClass(this.a, SearchActivity.class);
                this.a.startActivity(intent);
                return;
            case R.id.t_main_home_local_image:
                LocationThemeActivity.a(this.a);
                return;
            default:
                return;
        }
    }
}
