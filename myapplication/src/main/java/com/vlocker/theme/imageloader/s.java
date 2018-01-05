package com.vlocker.theme.imageloader;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.c.g;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.lang.ref.SoftReference;

class s extends g {
    final /* synthetic */ r a;

    s(r rVar, int i) {
        this.a = rVar;
        super(i);
    }

    protected int a(String str, BitmapDrawable bitmapDrawable) {
        int a = r.a(bitmapDrawable) / IXAdIOUtils.BUFFER_SIZE;
        return a == 0 ? 1 : a;
    }

    protected void a(boolean z, String str, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
        if (z.class.isInstance(bitmapDrawable)) {
            ((z) bitmapDrawable).b(false);
        } else if (aa.b()) {
            this.a.g.add(new SoftReference(bitmapDrawable.getBitmap()));
        }
    }

    protected /* synthetic */ int b(Object obj, Object obj2) {
        return a((String) obj, (BitmapDrawable) obj2);
    }
}
