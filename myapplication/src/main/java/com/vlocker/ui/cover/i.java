package com.vlocker.ui.cover;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class i implements Interpolator {
    private List a = new ArrayList();
    private long b = 0;

    public long a() {
        return this.b;
    }

    public void a(Interpolator interpolator, long j, boolean z) {
        try {
            this.a.add(new j(this, interpolator, j, z));
            this.b += j;
        } catch (Exception e) {
        }
    }

    public float getInterpolation(float f) {
        long j = 0;
        int i = 0;
        while (i < this.a.size()) {
            j jVar = (j) this.a.get(i);
            if (((float) (jVar.b + j)) >= ((float) this.b) * f) {
                float interpolation = jVar.a.getInterpolation((((((float) this.b) * f) - ((float) j)) * 1.0f) / ((float) jVar.b));
                return jVar.c ? 1.0f - interpolation : interpolation;
            } else {
                j += jVar.b;
                i++;
            }
        }
        return 0.0f;
    }
}
