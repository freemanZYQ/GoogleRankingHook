package com.vlocker.settings;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.locker.R;

class aw implements OnTouchListener {
    final /* synthetic */ LockNumberActivityNew a;

    aw(LockNumberActivityNew lockNumberActivityNew) {
        this.a = lockNumberActivityNew;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if ((motionEvent.getAction() & 255) == 0) {
            switch (id) {
                case R.id.del:
                    this.a.g();
                    break;
                case R.id.next:
                    this.a.e();
                    break;
            }
        }
        return true;
    }
}
