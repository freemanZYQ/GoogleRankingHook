package com.vlocker.weather;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.vlocker.b.j;
import com.vlocker.locker.R;

class h implements OnClickListener {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        a.a(this.a.h);
        if (j.i(this.a.h)) {
            if (this.a.H != null) {
                this.a.H.smoothScrollTo(0, 0);
            }
            this.a.k.a(3, new i(this));
            return;
        }
        Toast.makeText(this.a.h, R.string.l_check_network, 0).show();
    }
}
