package com.vlocker.settings;

import com.vlocker.b.p;
import com.vlocker.m.n;

class by implements n {
    final /* synthetic */ boolean a;
    final /* synthetic */ PasswordSettingsActivity b;

    by(PasswordSettingsActivity passwordSettingsActivity, boolean z) {
        this.b = passwordSettingsActivity;
        this.a = z;
    }

    public void a(boolean z) {
        this.b.e(z);
        if (z != this.a) {
            if (z) {
                p.a(this.b, "Vlocker_Switch_EmergencyLock_PPC_TF", "status", "on");
                return;
            }
            p.a(this.b, "Vlocker_Switch_EmergencyLock_PPC_TF", "status", "off");
        }
    }
}
