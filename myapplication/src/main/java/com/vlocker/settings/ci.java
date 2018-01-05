package com.vlocker.settings;

import com.vlocker.update.f;

class ci implements f {
    final /* synthetic */ SettingsActivity a;

    ci(SettingsActivity settingsActivity) {
        this.a = settingsActivity;
    }

    public void a(boolean z) {
        this.a.onResume();
        if (z) {
            this.a.b();
        }
    }
}
