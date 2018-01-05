package com.vlocker.settings;

import android.media.AudioManager;
import android.view.animation.AnimationUtils;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.aa;
import com.vlocker.ui.cover.l;
import com.vlocker.ui.cover.r;
import java.util.List;

class bd implements r {
    final /* synthetic */ LockerSettingsActivity a;

    bd(LockerSettingsActivity lockerSettingsActivity) {
        this.a = lockerSettingsActivity;
    }

    private void c() {
    }

    public void a() {
        this.a.j.sendEmptyMessage(1);
        this.a.g.removeCallbacks(this.a.q);
        c();
    }

    public void a(List list) {
        if (list != null) {
            if (l.b(list, this.a)) {
                this.a.g.setDisplayMode(0);
                this.a.b();
                this.a.g.b();
                this.a.c();
                return;
            }
            if ("moxiu-launcher".equals(j.p(this.a))) {
                p.a(this.a, "Vlocker_Wrong_Pattern_Password_PPC_TF", new String[0]);
            }
            this.a.g.setDisplayMode(2);
            if (list.size() >= 4) {
                LockerSettingsActivity.b++;
                int i = 5 - LockerSettingsActivity.b;
                if (i >= 0) {
                    if (i == 0) {
                        this.a.l = AnimationUtils.loadAnimation(this.a, R.anim.l_shake_x);
                        this.a.g.b();
                        this.a.g.setEnabled(false);
                        this.a.k.setText(this.a.getString(R.string.gesture_password_gesturepwd_unlock_failed_tip));
                    } else {
                        this.a.l = AnimationUtils.loadAnimation(this.a, R.anim.l_shake_x);
                        this.a.k.setText(this.a.getString(R.string.gesture_password_unlock_failed_tip) + i + this.a.getString(R.string.gesture_password_unlock_failed_tip_num));
                    }
                    this.a.k.setTextColor(-65536);
                    this.a.l.setAnimationListener(new be(this, i));
                    this.a.k.startAnimation(this.a.l);
                    if (((AudioManager) this.a.getSystemService("audio")).getRingerMode() != 0 && a.a(this.a).au()) {
                        aa.a(this.a);
                    }
                }
            } else {
                this.a.a((int) R.string.lockpattern_recording_incorrect_too_short);
            }
            if (LockerSettingsActivity.b < 5) {
                this.a.g.post(this.a.q);
            }
        }
    }

    public void b() {
        this.a.g.removeCallbacks(this.a.q);
    }

    public void b(List list) {
    }
}
