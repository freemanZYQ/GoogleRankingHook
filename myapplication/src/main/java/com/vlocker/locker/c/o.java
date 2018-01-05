package com.vlocker.locker.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.vlocker.ui.view.BatteryChargeView;
import com.vlocker.ui.widget.MsgListView;
import com.vlocker.ui.widget.MusicLrcView;

class o implements AnimatorUpdateListener {
    final /* synthetic */ MsgListView a;
    final /* synthetic */ b b;

    o(b bVar, MsgListView msgListView) {
        this.b = bVar;
        this.a = msgListView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (MusicLrcView.a && BatteryChargeView.c) {
            this.b.al.setTranslationY(((float) ((Integer) valueAnimator.getAnimatedValue()).intValue()) + 0.0f);
        }
        this.a.setTranslationY(((float) ((Integer) valueAnimator.getAnimatedValue()).intValue()) + 0.0f);
    }
}
