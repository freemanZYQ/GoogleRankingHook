package com.vlocker.anim;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import com.android.internal.R;

public class PwdErrorCycleInterplator implements Interpolator {
    private float a;

    public PwdErrorCycleInterplator(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CycleInterpolator);
        this.a = obtainStyledAttributes.getFloat(0, 1.0f);
        obtainStyledAttributes.recycle();
    }

    public float getInterpolation(float f) {
        return ((double) f) <= 0.125d ? (float) Math.sin(50.26548245743669d * ((double) f)) : ((double) f) <= 0.375d ? -((float) (0.5d * Math.sin(25.132741228718345d * ((double) f)))) : (float) (Math.sin(10.053096491487338d * (((double) f) - 0.375d)) * 0.125d);
    }
}
