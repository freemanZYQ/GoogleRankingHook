package com.vlocker.l;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.m.h;

abstract class ad {
    private Toast a;
    private View b;
    private TextView c;
    protected Intent d;
    final /* synthetic */ j e;

    private ad(j jVar) {
        this.e = jVar;
    }

    abstract void a();

    void a(CharSequence charSequence) {
        if (this.b == null) {
            this.b = View.inflate(this.e.b, R.layout.l_cover_toast, null);
            this.c = (TextView) this.b.findViewById(R.id.toast_text);
        }
        if (this.a == null) {
            this.a = new Toast(this.e.b);
            this.a.setView(this.b);
            this.a.setGravity(17, 0, h.a(this.e.b, -30.0f));
            this.a.setDuration(0);
        }
        this.c.setText(charSequence);
        this.a.show();
    }

    abstract void b();

    void c() {
        try {
            this.e.b.startActivity(this.d);
        } catch (Exception e) {
            e.printStackTrace();
            a();
        }
    }
}
