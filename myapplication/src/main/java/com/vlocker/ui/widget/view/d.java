package com.vlocker.ui.widget.view;

import android.view.MotionEvent;
import android.view.View;
import com.vlocker.b.p;
import com.vlocker.locker.b.ap;

class d implements u {
    final /* synthetic */ LockNumberCoverView a;

    d(LockNumberCoverView lockNumberCoverView) {
        this.a = lockNumberCoverView;
    }

    public boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.a.g) {
            LockNumberPointView lockNumberPointView = (LockNumberPointView) view;
            if (action == 0) {
                lockNumberPointView.b();
                if (!(this.a.C || this.a.B)) {
                    try {
                        this.a.setValue(lockNumberPointView.a);
                        if (!(ap.a() == null || ap.a().q == null)) {
                            com.vlocker.m.ap.a(this.a.l, ap.a().q);
                        }
                    } catch (Exception e) {
                    }
                    this.a.H.sendEmptyMessage(1);
                }
            } else if (action == 1) {
                lockNumberPointView.c();
                p.b("101000", "101003");
                if (this.a.B && !this.a.C) {
                    this.a.B = false;
                    this.a.e();
                }
            } else if (action == 3) {
                lockNumberPointView.c();
                if (this.a.B && !this.a.C) {
                    this.a.B = false;
                    this.a.e();
                }
            } else if (action == 4) {
            }
        }
        return true;
    }
}
