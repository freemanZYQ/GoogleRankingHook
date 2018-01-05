package com.vlocker.locker.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class m extends AnimatorListenerAdapter {
    final /* synthetic */ View a;
    final /* synthetic */ i b;

    m(i iVar, View view) {
        this.b = iVar;
        this.a = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setScaleX(1.0f);
        this.a.setScaleY(1.0f);
        this.a.setLayerType(0, null);
        this.b.a(0);
    }

    public void onAnimationStart(Animator animator) {
    }
}
