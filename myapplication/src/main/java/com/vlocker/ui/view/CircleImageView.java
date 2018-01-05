package com.vlocker.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleImageView extends ImageView {
    private Paint a;
    private PaintFlagsDrawFilter b;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new PaintFlagsDrawFilter(0, 3);
        this.a = new Paint();
    }

    private Bitmap a(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.a.setAntiAlias(true);
        this.a.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        this.a.setColor(-12434878);
        int width = bitmap.getWidth();
        canvas.drawCircle((float) (width / 2), (float) (width / 2), (float) (width / 2), this.a);
        this.a.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, this.a);
        return createBitmap;
    }

    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap a = a(((BitmapDrawable) drawable).getBitmap(), 14);
            Rect rect = new Rect(0, 0, a.getWidth(), a.getHeight());
            Rect rect2 = new Rect(0, 0, getWidth(), getHeight());
            this.a.reset();
            canvas.setDrawFilter(this.b);
            canvas.drawBitmap(a, rect, rect2, this.a);
            return;
        }
        super.onDraw(canvas);
    }
}
