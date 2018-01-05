package com.vlocker.ui.view;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

class w implements Runnable {
    final /* synthetic */ Drawable a;
    final /* synthetic */ Matrix b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ ImageViewTouchBase e;

    w(ImageViewTouchBase imageViewTouchBase, Drawable drawable, Matrix matrix, float f, float f2) {
        this.e = imageViewTouchBase;
        this.a = drawable;
        this.b = matrix;
        this.c = f;
        this.d = f2;
    }

    public void run() {
        this.e.b(this.a, this.b, this.c, this.d);
    }
}
