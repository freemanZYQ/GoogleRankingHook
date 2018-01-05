package com.vlocker.locker.c;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.vlocker.locker.b.p;

public abstract class a implements com.vlocker.i.a {
    protected Context a;
    protected View b;
    protected p c;
    public String d = "unknown_page";

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void a(float f, long j, long j2, AnimatorListener animatorListener) {
        if (this.b != null) {
            this.b.animate().alpha(f).setListener(animatorListener).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(j).setStartDelay(j2).start();
        }
    }

    public abstract void a(String str, String str2);

    public void a_(int i) {
    }

    public abstract void b();

    public abstract void c();

    public void d() {
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }
}
