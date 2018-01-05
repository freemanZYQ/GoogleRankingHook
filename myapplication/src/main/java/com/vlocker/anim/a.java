package com.vlocker.anim;

import android.view.animation.Interpolator;

public class a implements Interpolator {
    public float getInterpolation(float f) {
        float f2 = 10.0f * f;
        f2 = f2 <= 2.0f ? (f2 * 5.0f) / 6.0f : f2 <= 4.0f ? (float) ((Math.pow((double) ((f2 / 2.0f) + 1.0f), 2.0d) * 5.0d) / 12.0d) : f2 <= 6.0f ? ((f2 - 1.0f) * 5.0f) / 4.0f : f2 <= 8.0f ? ((((f2 * f2) / 48.0f) - (f2 / 2.0f)) + 1.0f) * -5.0f : ((f2 + 2.0f) * 5.0f) / 6.0f;
        return f2 / 10.0f;
    }
}
