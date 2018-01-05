package com.vlocker.msg.b;

import android.app.NotificationManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.msg.ab;
import com.vlocker.msg.ao;
import com.vlocker.msg.as;

class p implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ o c;

    p(o oVar, String str, String str2) {
        this.c = oVar;
        this.a = str;
        this.b = str2;
    }

    public void onClick(View view) {
        ao.e(this.c.a, this.a);
        ((NotificationManager) this.c.a.getSystemService("notification")).cancel(as.b(this.b));
        ab.e(this.b);
    }
}
