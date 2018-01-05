package com.vlocker.ui.widget;

import android.os.Message;
import android.view.View;
import android.view.Window;
import com.vlocker.locker.R;

class p extends r {
    final /* synthetic */ MyAlertController a;

    p(MyAlertController myAlertController) {
        this.a = myAlertController;
        super();
    }

    public void handleMessage(Message message) {
        if (message.obj != null) {
            Window window = (Window) message.obj;
            View findViewById = window.findViewById(R.id.parentPanel);
            if (findViewById == null) {
                return;
            }
            if (findViewById.getHeight() > message.arg1) {
                window.setLayout(findViewById.getWidth(), message.arg1);
            } else {
                window.setLayout(findViewById.getWidth(), findViewById.getMeasuredHeight());
            }
        }
    }
}
