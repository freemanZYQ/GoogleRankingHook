package com.vlocker.locker.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;

class as implements OnClickListener {
    final /* synthetic */ ao a;

    as(ao aoVar) {
        this.a = aoVar;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.gesturepwd_unlock_cancel) {
            this.a.n();
        } else if (id == R.id.l_more_pattern_img) {
            this.a.o();
        }
    }
}
