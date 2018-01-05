package com.vlocker.new_theme.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.vlocker.theme.f.e;
import java.util.Hashtable;

public class T_MyLinearLayout extends ViewGroup {
    int a;
    int b;
    int c;
    int d;
    Hashtable e = new Hashtable();

    public T_MyLinearLayout(Context context) {
        super(context);
    }

    public T_MyLinearLayout(Context context, int i, int i2) {
        super(context);
    }

    public T_MyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int a(int i, int i2) {
        return i > 0 ? e.f(getContext()).getWidth() >= 720 ? (a(i - 1, i2 - 1) + getChildAt(i2 - 1).getMeasuredWidth()) + 28 : (a(i - 1, i2 - 1) + getChildAt(i2 - 1).getMeasuredWidth()) + 16 : getPaddingLeft();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(1, 1);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            c cVar = (c) this.e.get(childAt);
            if (cVar != null) {
                childAt.layout(cVar.a, cVar.b, cVar.c, cVar.d);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int width = e.f(getContext()).getWidth();
        int size = MeasureSpec.getSize(i);
        int childCount = getChildCount();
        this.a = 0;
        this.b = 0;
        this.c = 6;
        this.d = 0;
        if (width > 720) {
            this.c = 10;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < childCount) {
            int i7;
            View childAt = getChildAt(i4);
            childAt.measure(0, 0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i6 += measuredWidth;
            c cVar = new c();
            this.a = a(i4 - i3, i4);
            i6 = width >= 720 ? i6 + 28 : i6 + 16;
            this.b = this.a + childAt.getMeasuredWidth();
            if (i6 >= size) {
                i6 = i5 + measuredHeight;
                this.a = 0;
                this.b = this.a + childAt.getMeasuredWidth();
                this.c = i6 + 6;
                if (width >= 720) {
                    this.c = i6 + 10;
                }
                i6 = i4;
                i3 = measuredWidth;
            } else {
                i7 = i3;
                i3 = i6;
                i6 = i7;
            }
            this.d = this.c + childAt.getMeasuredHeight();
            measuredWidth = this.c;
            cVar.a = this.a;
            cVar.b = this.c + 6;
            if (width > 720) {
                cVar.b = this.c + 10;
            }
            cVar.c = this.b;
            cVar.d = this.d;
            this.e.put(childAt, cVar);
            i4++;
            i5 = measuredWidth;
            i7 = i6;
            i6 = i3;
            i3 = i7;
        }
        setMeasuredDimension(size, this.d);
    }
}
