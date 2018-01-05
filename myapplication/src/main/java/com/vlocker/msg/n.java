package com.vlocker.msg;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.ui.cover.LockerService;

class n implements OnTouchListener {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            McmPushWidget.getInstance(this.a.c).removeRedPacketMsg();
            switch (view.getId()) {
                case R.id.btn_close:
                    this.a.a("red_packet_msg");
                    break;
                case R.id.btn_open:
                    if (an.b(this.a.c)) {
                        a.a(this.a.c).ab(true);
                    }
                    LockerService.a().a(new o(this), 2);
                    break;
            }
        }
        return true;
    }
}
