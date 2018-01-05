package com.vlocker.f;

import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;

class ar implements Runnable {
    final /* synthetic */ TextView a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ ao c;

    ar(ao aoVar, TextView textView, ImageView imageView) {
        this.c = aoVar;
        this.a = textView;
        this.b = imageView;
    }

    public void run() {
        try {
            this.c.e.d.startIdentify(this.c.e.g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.a.setText("验证指纹后，开启指纹解锁");
        this.b.setImageDrawable(this.c.b.getResources().getDrawable(R.drawable.fingerprint_verfiy_dialog));
    }
}
