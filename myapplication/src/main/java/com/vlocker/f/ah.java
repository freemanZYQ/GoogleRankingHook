package com.vlocker.f;

import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;

class ah implements Runnable {
    final /* synthetic */ TextView a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ af c;

    ah(af afVar, TextView textView, ImageView imageView) {
        this.c = afVar;
        this.a = textView;
        this.b = imageView;
    }

    public void run() {
        this.a.setText("验证指纹后，开启指纹解锁");
        this.b.setImageDrawable(this.c.a.a.getResources().getDrawable(R.drawable.fingerprint_verfiy_dialog));
    }
}
