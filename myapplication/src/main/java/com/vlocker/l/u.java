package com.vlocker.l;

import android.view.View;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;

class u extends ad {
    final /* synthetic */ j a;

    public u(j jVar, View view) {
        this.a = jVar;
        super(jVar);
    }

    void a() {
    }

    void b() {
        p.a(this.a.b, "Vlocker_Click_Settings_Toolbox_PPC_TF", new String[0]);
        if (!a.a(this.a.b).al()) {
            a.a(this.a.b).y(true);
        }
        c();
    }

    void c() {
        this.a.r.a(new v(this), this.a.b.getResources().getString(R.string.lk_number_password_ui_from_vlocker_tip));
    }
}
