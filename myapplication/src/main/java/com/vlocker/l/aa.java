package com.vlocker.l;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.vlocker.b.p;
import com.vlocker.h.g;
import com.vlocker.locker.R;

class aa extends ad {
    final /* synthetic */ j a;
    private g b;
    private boolean c = false;

    public aa(j jVar, View view) {
        this.a = jVar;
        super(jVar);
        this.b = g.a(jVar.b);
    }

    void a() {
        a(this.a.b.getString(R.string.toast_error_flashlight));
    }

    public void a(ImageView imageView) {
        int i = R.drawable.l_toolbox_flashlight_off;
        int d = d();
        if (d != -1 && d == 1) {
            i = R.drawable.l_toolbox_flashlight_on;
        }
        imageView.setImageResource(i);
    }

    void b() {
    }

    public void b(ImageView imageView) {
        try {
            this.b.a(new ab(this, imageView));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void c(ImageView imageView) {
        if (this.b.a()) {
            if (this.b.b()) {
                imageView.setImageResource(R.drawable.l_toolbox_flashlight_off);
            } else {
                imageView.setImageResource(R.drawable.l_toolbox_flashlight_on);
            }
        }
        if (d() == -1) {
            if (this.a.p == null) {
                this.a.p = new f(this.a.b, this.a.d, this.b.a());
                this.a.p.a(new ac(this));
            }
            this.a.p.a();
        } else if (!this.c) {
            this.c = true;
            b(imageView);
        }
    }

    public int d() {
        return this.b.a() ? this.b.b() ? 1 : 0 : -1;
    }

    public void d(ImageView imageView) {
        if (d() == 0) {
            p.a(this.a.b, "Vlocker_Switch_Flashlight_PPC_TF", "status", "On");
            imageView.setImageResource(R.drawable.l_toolbox_flashlight_on);
        } else {
            p.a(this.a.b, "Vlocker_Switch_Flashlight_PPC_TF", "status", "Off");
        }
        Log.e("liu---", "launchApp");
        c(imageView);
    }
}
