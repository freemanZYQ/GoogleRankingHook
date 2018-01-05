package com.vlocker.settings;

import com.vlocker.locker.R;
import com.vlocker.ui.cover.r;
import java.util.ArrayList;
import java.util.List;

class i implements r {
    final /* synthetic */ CreateGesturePasswordActivity a;

    i(CreateGesturePasswordActivity createGesturePasswordActivity) {
        this.a = createGesturePasswordActivity;
    }

    private void c() {
        this.a.a.setText(R.string.lockpattern_recording_inprogress);
    }

    public void a() {
        this.a.e.removeCallbacks(this.a.j);
        c();
    }

    public void a(List list) {
        if (list != null) {
            if (this.a.h == m.NeedToConfirm || this.a.h == m.ConfirmWrong) {
                if (this.a.c == null) {
                    throw new IllegalStateException("null chosen pattern in stage 'need to confirm");
                } else if (this.a.c.equals(list)) {
                    this.a.e.b();
                    this.a.c();
                } else {
                    this.a.a(m.ConfirmWrong);
                }
            } else if (this.a.h != m.Introduction && this.a.h != m.ChoiceTooShort) {
                throw new IllegalStateException("Unexpected stage " + this.a.h + " when " + "entering the pattern.");
            } else if (list.size() < 4) {
                this.a.a(m.ChoiceTooShort);
            } else {
                this.a.c = new ArrayList(list);
                this.a.a(m.NeedToConfirm);
            }
        }
    }

    public void b() {
        this.a.e.removeCallbacks(this.a.j);
    }

    public void b(List list) {
    }
}
