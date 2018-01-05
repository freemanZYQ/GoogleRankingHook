package com.vlocker.ui.widget;

import android.util.Property;
import android.view.View;

public class ah {
    public Property a = View.TRANSLATION_Y;
    public float b;
    public float c;

    protected void a(View view) {
        this.b = view.getTranslationY();
        this.c = (float) view.getHeight();
    }
}
