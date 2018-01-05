package com.vlocker.settings;

import android.content.Intent;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.m.t;
import com.vlocker.ui.cover.LockerService;

class cc implements t {
    final /* synthetic */ QuestionActivity a;

    cc(QuestionActivity questionActivity) {
        this.a = questionActivity;
    }

    public void a() {
        LockerService.a().a("main_page", false);
        LockerService.a().b();
        this.a.finish();
    }

    public void a(Intent intent) {
        this.a.finish();
        PasswordSettingsActivity.a(this.a);
        Toast.makeText(this.a, R.string.v2_re_setting_pattern_tip, 0).show();
    }

    public void a(String str) {
    }

    public void b() {
        LockerService.a().a(5);
    }
}
