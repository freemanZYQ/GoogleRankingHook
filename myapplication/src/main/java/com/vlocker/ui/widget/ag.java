package com.vlocker.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;

public class ag implements OnTouchListener {
    protected final am a;
    protected final ak b;
    protected final an c;
    protected final ai d;
    protected aj e;
    protected float f;
    int g;
    int h;
    private AbsListView i;

    public ag(AbsListView absListView) {
        this(absListView, -2.0f, 3.0f, 1.0f);
    }

    public ag(AbsListView absListView, float f, float f2, float f3) {
        this.a = new am();
        this.g = 1;
        this.h = 2;
        this.i = absListView;
        this.d = new ai(this, f);
        this.c = new an(this, f2, f3);
        this.b = new ak(this);
        this.e = this.b;
        f();
    }

    private void a(View view, float f) {
        view.setTranslationY(f);
    }

    private void a(View view, float f, MotionEvent motionEvent) {
        view.setTranslationY(f);
        motionEvent.offsetLocation(f - motionEvent.getY(0), 0.0f);
    }

    private void a(aj ajVar) {
        aj ajVar2 = this.e;
        this.e = ajVar;
        this.e.a(ajVar2);
    }

    private void f() {
        a().setOnTouchListener(this);
        a().setOverScrollMode(2);
    }

    public View a() {
        return this.i;
    }

    public boolean b() {
        return this.i.getChildCount() > 0 && !d();
    }

    public boolean c() {
        return this.i.getChildCount() > 0 && !e();
    }

    public boolean d() {
        this.i.getChildAt(0).getTop();
        this.i.getFirstVisiblePosition();
        return true;
    }

    public boolean e() {
        int childCount = this.i.getChildCount();
        return this.i.getFirstVisiblePosition() + childCount < this.i.getCount() || this.i.getChildAt(childCount - 1).getBottom() > this.i.getHeight() - this.i.getListPaddingBottom();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                return this.e.b(motionEvent);
            case 2:
                return this.e.a(motionEvent);
            default:
                return false;
        }
    }
}
