package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.vlocker.c.a;
import com.vlocker.ui.cover.LockerService;

public class SubSetingActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(null);
        }
        try {
            getWindow().getDecorView().setOnTouchListener(new cp(this));
        } catch (Exception e) {
        }
        if (a.a((Context) this).s()) {
            a.a((Context) this).g(false);
        }
        LockerService.a((Context) this);
        finish();
    }

    protected void onResume() {
        super.onResume();
        finish();
    }
}
