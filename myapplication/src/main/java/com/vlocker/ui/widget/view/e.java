package com.vlocker.ui.widget.view;

import android.view.View;
import android.view.View.OnClickListener;

class e implements OnClickListener {
    final /* synthetic */ LockNumberCoverView a;

    e(LockNumberCoverView lockNumberCoverView) {
        this.a = lockNumberCoverView;
    }

    public void onClick(View view) {
        switch (((LockNumberDelView) view).a) {
            case 0:
                this.a.a(view);
                return;
            case 1:
                if (this.a.j == null) {
                    return;
                }
                if (this.a.b) {
                    this.a.j.c();
                    return;
                } else {
                    this.a.j.b();
                    return;
                }
            default:
                return;
        }
    }
}
