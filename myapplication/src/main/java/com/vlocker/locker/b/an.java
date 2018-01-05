package com.vlocker.locker.b;

import android.graphics.Bitmap;
import com.vlocker.locker.a.a;

class an extends a {
    final /* synthetic */ am a;

    an(am amVar) {
        this.a = amVar;
    }

    public void a(Bitmap bitmap) {
        super.a(bitmap);
        this.a.f = bitmap;
        this.a.b.setImageBitmap(this.a.f);
        this.a.a(this.a.f);
    }

    public /* synthetic */ Object b() {
        return d();
    }

    public Bitmap d() {
        try {
            return this.a.g();
        } catch (OutOfMemoryError e) {
            return null;
        }
    }
}
