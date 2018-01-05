package com.vlocker.ui.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.vlocker.locker.R;
import com.vlocker.locker.b;
import java.util.ArrayList;

public class V2IndicatorViewGroup extends LinearLayout {
    private LayoutInflater a;
    private int[] b;
    private int c;
    private ArrayList d;
    private int e;

    public V2IndicatorViewGroup(Context context) {
        this(context, null);
    }

    public V2IndicatorViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public V2IndicatorViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new int[2];
        this.d = new ArrayList();
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.PageIndicator, i, 0);
            this.c = obtainStyledAttributes.getInteger(0, 15);
            this.b[0] = 0;
            this.b[1] = 0;
            this.a = LayoutInflater.from(context);
            obtainStyledAttributes.recycle();
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.setDuration(175);
            setLayoutTransition(layoutTransition);
        }
    }

    private void a() {
    }

    private void b() {
    }

    void a(int i, be beVar, boolean z) {
        int max = Math.max(0, Math.min(i, this.d.size()));
        V2PageIndicatorMarker v2PageIndicatorMarker = (V2PageIndicatorMarker) this.a.inflate(R.layout.l_v2_page_indicator_marker, this, false);
        v2PageIndicatorMarker.a(beVar.a, beVar.b);
        this.d.add(max, v2PageIndicatorMarker);
        a(this.e, z);
    }

    void a(int i, boolean z) {
        int childCount;
        if (i < 0) {
            new Throwable().printStackTrace();
        }
        int min = Math.min(this.d.size(), this.c);
        float f = ((float) min) / 2.0f;
        int min2 = Math.min(this.d.size(), Math.max(0, i - (min / 2)) + this.c);
        int min3 = min2 - Math.min(this.d.size(), min);
        min = ((min2 - min3) / 2) + min3;
        if (min3 == 0) {
        }
        if (min2 == this.d.size()) {
        }
        boolean z2 = (this.b[0] == min3 && this.b[1] == min2) ? false : true;
        if (!z) {
            b();
        }
        for (childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            V2PageIndicatorMarker v2PageIndicatorMarker = (V2PageIndicatorMarker) getChildAt(childCount);
            int indexOf = this.d.indexOf(v2PageIndicatorMarker);
            if (indexOf < min3 || indexOf >= min2) {
                removeView(v2PageIndicatorMarker);
            }
        }
        childCount = 0;
        while (childCount < this.d.size()) {
            v2PageIndicatorMarker = (V2PageIndicatorMarker) this.d.get(childCount);
            if (min3 > childCount || childCount >= min2) {
                v2PageIndicatorMarker.b(true);
            } else {
                if (indexOfChild(v2PageIndicatorMarker) < 0) {
                    addView(v2PageIndicatorMarker, childCount - min3);
                }
                if (childCount == i) {
                    v2PageIndicatorMarker.a(z2);
                } else {
                    v2PageIndicatorMarker.b(z2);
                }
            }
            childCount++;
        }
        if (!z) {
            a();
        }
        this.b[0] = min3;
        this.b[1] = min2;
    }

    void a(boolean z) {
        while (this.d.size() > 0) {
            b(Integer.MAX_VALUE, z);
        }
    }

    void b(int i, boolean z) {
        if (this.d.size() > 0) {
            this.d.remove(Math.max(0, Math.min(this.d.size() - 1, i)));
            a(this.e, z);
        }
    }

    public int getSize() {
        return this.d.size();
    }

    void setActiveMarker(int i) {
        this.e = i;
        a(i, false);
    }
}
