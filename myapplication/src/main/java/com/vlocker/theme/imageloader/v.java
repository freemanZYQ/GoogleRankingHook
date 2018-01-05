package com.vlocker.theme.imageloader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import java.lang.ref.WeakReference;

class v extends ClipDrawable {
    private final WeakReference a;

    public v(Resources resources, Bitmap bitmap, w wVar, int i) {
        super(resources.getDrawable(i), 17, 1);
        this.a = new WeakReference(wVar);
    }

    public w a() {
        return (w) this.a.get();
    }
}
