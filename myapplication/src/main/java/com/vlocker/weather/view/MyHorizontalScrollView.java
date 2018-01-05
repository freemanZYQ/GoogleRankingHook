package com.vlocker.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.vlocker.b.j;
import com.vlocker.m.l;
import com.vlocker.weather.a;
import com.vlocker.weather.e.d;

public class MyHorizontalScrollView extends HorizontalScrollView {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e = 1.0f;
    private float f;
    private int g = l.a(getContext(), 30.0f);

    public MyHorizontalScrollView(Context context) {
        super(context);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            switch (motionEvent.getAction()) {
                case 0:
                    this.b = 0.0f;
                    this.a = 0.0f;
                    this.c = motionEvent.getRawX();
                    this.d = motionEvent.getRawY();
                    this.e = motionEvent.getRawX();
                    this.f = motionEvent.getRawY();
                    break;
                case 1:
                case 3:
                    if (getScrollX() > getWidth()) {
                        this.e = motionEvent.getRawX();
                        this.a = this.e - this.c;
                    } else {
                        this.e = motionEvent.getRawX();
                        this.a = this.e - this.c;
                    }
                    if (this.a <= 0.0f || this.a < ((float) this.g)) {
                        if (this.a < 0.0f && this.a <= ((float) (-this.g))) {
                            if ("moxiu-launcher".equals(j.p(getContext()))) {
                                d.a(getContext(), "Weather(V)_24hoursScroll_PPC_YZY", new String[0]);
                            }
                            a.a(getContext());
                            break;
                        }
                    }
                    if ("moxiu-launcher".equals(j.p(getContext()))) {
                        d.a(getContext(), "Weather(V)_24hoursScroll_PPC_YZY", new String[0]);
                    }
                    a.a(getContext());
                    break;
                    break;
                case 2:
                    this.e = motionEvent.getRawX();
                    this.f = motionEvent.getRawY();
                    break;
            }
            this.a = Math.abs(this.e - this.c);
            this.b = Math.abs(this.f - this.d);
            return (this.a <= this.b || this.a <= 0.0f || this.e <= this.c || getScrollX() != 0) ? super.onTouchEvent(motionEvent) : false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
