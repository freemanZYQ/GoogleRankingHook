package com.vlocker.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.widget.TextView;

public class SearchShimmerTextView extends TextView {
    private LinearGradient a;
    private Matrix b;
    private Paint c;
    private int d = 0;
    private int e = 0;
    private boolean f = true;

    public SearchShimmerTextView(Context context) {
        super(context);
    }

    public SearchShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SearchShimmerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f && this.b != null) {
            this.e += this.d / 10;
            if (this.e > this.d * 2) {
                this.e = -this.d;
            }
            this.b.setTranslate((float) this.e, 0.0f);
            this.a.setLocalMatrix(this.b);
            postInvalidateDelayed(50);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.d == 0) {
            this.d = getMeasuredWidth() / 2;
            if (this.d > 0) {
                this.c = getPaint();
                this.a = new LinearGradient((float) (-this.d), 0.0f, 0.0f, 0.0f, new int[]{Integer.MAX_VALUE, -1, Integer.MAX_VALUE}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP);
                this.c.setShader(this.a);
                this.b = new Matrix();
            }
        }
    }

    public void setmAnimating(boolean z) {
        this.f = z;
    }
}
