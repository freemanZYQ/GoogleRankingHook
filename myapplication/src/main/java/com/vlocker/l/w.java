package com.vlocker.l;

import android.view.View;
import com.vlocker.b.p;
import com.vlocker.locker.R;

class w extends ad {
    String[] a = new String[]{"com.android.calculator2", "com.sec.android.app.popupcalculator", "com.sec.android.app.calculator", "com.htc.calculator", "com.meizu.flyme.calculator", "com.android.bbkcalculator"};
    aj b = null;
    final /* synthetic */ j c;

    public w(j jVar, View view) {
        this.c = jVar;
        super(jVar);
        new Thread(new x(this, jVar)).start();
    }

    private boolean a(String str) {
        for (String equals : this.a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    void a() {
        a(this.c.b.getString(R.string.toast_error_calculator));
    }

    void b() {
        p.a(this.c.b, "Vlocker_Click_Calculater_PPC_TF", new String[0]);
        this.c.r.a(new y(this), (byte) 1);
    }
}
