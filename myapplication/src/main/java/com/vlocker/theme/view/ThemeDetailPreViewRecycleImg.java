package com.vlocker.theme.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowManager;
import com.vlocker.theme.imageloader.RecyclingImageView;

public class ThemeDetailPreViewRecycleImg extends RecyclingImageView {
    private int f;
    private int g;
    private int h = ((int) (((double) this.f) * 0.72d));
    private int i = ((int) (((double) this.g) * 0.72d));

    public ThemeDetailPreViewRecycleImg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = a(context);
        this.g = b(context);
    }

    public static int a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static int b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.h, this.i);
    }
}
