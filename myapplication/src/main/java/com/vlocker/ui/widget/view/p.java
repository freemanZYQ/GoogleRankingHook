package com.vlocker.ui.widget.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class p implements AnimatorUpdateListener {
    final /* synthetic */ LockNumberPointView a;

    p(LockNumberPointView lockNumberPointView) {
        this.a = lockNumberPointView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.a.k != null) {
            this.a.k.setTextColor(((Integer) valueAnimator.getAnimatedValue("mTextColor")).intValue());
        }
    }
}
