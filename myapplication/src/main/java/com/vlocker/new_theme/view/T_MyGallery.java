package com.vlocker.new_theme.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;

public class T_MyGallery extends Gallery {
    public T_MyGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent2.getX() > motionEvent.getX();
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        onKeyDown(a(motionEvent, motionEvent2) ? 21 : 22, null);
        return super.onFling(motionEvent, motionEvent2, 0.0f, f2);
    }
}
