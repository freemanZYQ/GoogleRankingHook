package com.vlocker.ui.widget;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class o implements OnClickListener {
    final /* synthetic */ MyAlertController a;

    o(MyAlertController myAlertController) {
        this.a = myAlertController;
    }

    public void onClick(View view) {
        boolean c;
        Message message = null;
        if (view == this.a.w && this.a.y != null) {
            message = Message.obtain(this.a.y);
            c = this.a.v;
        } else if (view == this.a.A && this.a.C != null) {
            message = Message.obtain(this.a.C);
            c = this.a.z;
        } else if (view != this.a.E || this.a.G == null) {
            c = true;
        } else {
            message = Message.obtain(this.a.G);
            c = this.a.D;
        }
        if (message != null) {
            message.sendToTarget();
        }
        if (c) {
            this.a.S.obtainMessage(1, this.a.d).sendToTarget();
        }
    }
}
