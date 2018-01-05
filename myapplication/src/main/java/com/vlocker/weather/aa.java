package com.vlocker.weather;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.locker.R;

class aa implements OnClickListener {
    final /* synthetic */ z a;

    aa(z zVar) {
        this.a = zVar;
    }

    public void onClick(View view) {
        if (view != null && view.getId() == R.id.time_textview) {
            p.a(this.a.c, "Vlocker_Click_LockerTime_PPC_TF", new String[0]);
        }
        if (this.a.d.p()) {
            this.a.d.o();
            this.a.d.n();
            return;
        }
        this.a.b();
    }
}
