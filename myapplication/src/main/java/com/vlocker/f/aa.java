package com.vlocker.f;

import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;

class aa implements Runnable {
    final /* synthetic */ TextView a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ x c;

    aa(x xVar, TextView textView, ImageView imageView) {
        this.c = xVar;
        this.a = textView;
        this.b = imageView;
    }

    public void run() {
        this.a.setText("验证指纹后，开启指纹解锁");
        this.b.setImageDrawable(this.c.d.b.getResources().getDrawable(R.drawable.fingerprint_verfiy_dialog));
    }
}
