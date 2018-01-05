package com.vlocker.weather.view;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.al;
import android.support.v4.widget.bf;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.vlocker.locker.R;
import com.vlocker.weather.Weather2Activity;

public class PromotionAppDetailLayout extends FrameLayout {
    Weather2Activity a;
    private final bf b;
    private PromotionAppDetailScrollView c;
    private boolean d;
    private Point e;
    private int f;
    private float g;
    private boolean h;
    private p i;
    private View j;
    private float k;
    private float l;

    public PromotionAppDetailLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PromotionAppDetailLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.e = new Point();
        this.h = false;
        this.b = bf.a((ViewGroup) this, 1.0f, new o());
        this.a = (Weather2Activity) getContext();
    }

    private int a(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public void computeScroll() {
        if (this.b.a(true)) {
            invalidate();
        }
    }

    protected void onFinishInflate() {
        this.c = (PromotionAppDetailScrollView) findViewById(R.id.scollview);
        this.j = findViewById(R.id.f_promotion_view);
        this.j.setBackgroundColor(getContext().getResources().getColor(R.color.weather_down_bg_color));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a = al.a(motionEvent);
        if (a == 3 || a == 1 || this.c.getScrollY() > 0) {
            this.b.e();
            if (motionEvent.getY() < ((float) a(93.0f)) && this.c.getScrollY() < a(93.0f)) {
                this.a.g();
            }
            return false;
        }
        float y;
        switch (a) {
            case 0:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                this.k = x;
                this.l = y;
                break;
            case 2:
                y = motionEvent.getX();
                float y2 = motionEvent.getY();
                Math.abs(y - this.k);
                if (Math.abs(y2 - this.l) > ((float) this.b.d()) && y2 - this.l >= 0.0f && this.c.getScrollY() <= 0) {
                    Log.e("liu---", "mDragScrollView.getScrollY()=" + this.c.getScrollY());
                    return true;
                }
        }
        return this.b.a(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.e.x = this.c.getLeft();
        this.e.y = this.c.getTop();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = i2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.c.getScrollY() > 0 || this.h) {
                return false;
            }
            this.b.b(motionEvent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void setPageCloseListener(p pVar) {
        this.i = pVar;
    }
}
