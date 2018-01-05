package com.vlocker.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.vlocker.locker.R;

public class V2PageIndicatorMarker extends FrameLayout {
    private ImageView a;
    private ImageView b;
    private boolean c;

    public V2PageIndicatorMarker(Context context) {
        this(context, null);
    }

    public V2PageIndicatorMarker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public V2PageIndicatorMarker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
    }

    void a(int i, int i2) {
        Resources resources = getResources();
        this.a.setImageDrawable(resources.getDrawable(i));
        this.b.setImageDrawable(resources.getDrawable(i2));
    }

    void a(boolean z) {
        if (z) {
            this.a.animate().cancel();
            this.a.setAlpha(1.0f);
            this.a.setScaleX(1.0f);
            this.a.setScaleY(1.0f);
            this.b.animate().cancel();
            this.b.setAlpha(0.0f);
        } else {
            this.a.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(175).start();
            this.b.animate().alpha(0.0f).setDuration(175).start();
        }
        this.c = true;
    }

    void b(boolean z) {
        if (z) {
            this.b.animate().cancel();
            this.b.setAlpha(1.0f);
            this.a.animate().cancel();
            this.a.setAlpha(0.0f);
            this.a.setScaleX(0.5f);
            this.a.setScaleY(0.5f);
        } else {
            this.b.animate().alpha(1.0f).setDuration(175).start();
            this.a.animate().alpha(0.0f).scaleX(0.5f).scaleY(0.5f).setDuration(175).start();
        }
        this.c = false;
    }

    protected void onFinishInflate() {
        this.a = (ImageView) findViewById(R.id.active);
        this.b = (ImageView) findViewById(R.id.inactive);
    }
}
