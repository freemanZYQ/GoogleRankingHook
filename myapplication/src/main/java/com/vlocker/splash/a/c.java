package com.vlocker.splash.a;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.vlocker.splash.newa.a;
import com.vlocker.ui.view.GifImageView;
import com.vlocker.ui.view.p;

public class c extends a {
    GifImageView a;
    com.moxiu.b.a.a b;
    Handler c;
    p d = new e(this);

    public c(com.moxiu.b.a.a aVar, View view, Handler handler) {
        this.b = aVar;
        this.a = (GifImageView) view;
        this.c = handler;
    }

    private void c() {
        this.c.sendEmptyMessageDelayed(40, 3000);
    }

    private void d() {
        Message obtain = Message.obtain();
        obtain.obj = this.b;
        obtain.what = 49;
        this.c.sendMessage(obtain);
    }

    public void a() {
        this.a.setDataLoadListener(this.d);
        this.a.setGifUrl(this.b.d());
        this.a.setOnClickListener(new d(this));
        a(this.b);
    }
}
