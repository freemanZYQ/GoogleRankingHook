package com.vlocker.settings;

import android.view.MotionEvent;
import android.view.View;
import com.vlocker.b.p;
import com.vlocker.locker.b.ap;
import com.vlocker.ui.widget.view.LockNumberPointView;
import com.vlocker.ui.widget.view.u;

class av implements u {
    final /* synthetic */ LockNumberActivityNew a;

    av(LockNumberActivityNew lockNumberActivityNew) {
        this.a = lockNumberActivityNew;
    }

    public boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.a.a) {
            LockNumberPointView lockNumberPointView = (LockNumberPointView) view;
            if (action == 0) {
                lockNumberPointView.b();
                if (!(this.a.l || this.a.x)) {
                    try {
                        this.a.a(lockNumberPointView.a);
                        if (!(ap.a() == null || ap.a().q == null)) {
                        }
                    } catch (Exception e) {
                    }
                }
            } else if (action == 1) {
                lockNumberPointView.c();
                p.b("101000", "101003");
                if (this.a.x && !this.a.l) {
                    this.a.x = false;
                    this.a.b();
                }
            } else if (action == 3) {
                lockNumberPointView.d();
                if (this.a.x && !this.a.l) {
                    this.a.x = false;
                    this.a.b();
                }
            } else if (action == 4) {
            }
        }
        return true;
    }
}
