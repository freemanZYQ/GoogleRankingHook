package com.vlocker.f;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.b.p;

class d implements OnTouchListener {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        p.a(this.a.c, "Vlock_Click_GuideBall_FP_PPC_TF", new String[0]);
        this.a.c();
        return false;
    }
}
