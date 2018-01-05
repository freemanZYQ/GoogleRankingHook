package com.vlocker.l;

import android.widget.ImageView;
import com.vlocker.h.b;
import com.vlocker.locker.R;

class ab implements b {
    final /* synthetic */ ImageView a;
    final /* synthetic */ aa b;

    ab(aa aaVar, ImageView imageView) {
        this.b = aaVar;
        this.a = imageView;
    }

    public void a() {
    }

    public void a(boolean z) {
        if (z) {
            this.a.setImageResource(R.drawable.l_toolbox_flashlight_on);
        } else {
            this.a.setImageResource(R.drawable.l_toolbox_flashlight_off);
        }
        this.b.c = false;
    }
}
