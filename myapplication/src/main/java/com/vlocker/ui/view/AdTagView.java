package com.vlocker.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class AdTagView extends ImageView {
    String a = "热销15W";
    String b = "";
    String c = "";
    Paint d = new Paint();

    public AdTagView(Context context) {
        super(context);
    }

    public AdTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private float a(Paint paint) {
        return Math.abs(paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
    }

    public Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(102, 102, Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        try {
            canvas.save();
            canvas.rotate(-45.0f, 0.0f, 102.0f);
            this.d.setColor(Color.parseColor("#ff5050"));
            Path path = new Path();
            path.moveTo(36.0f, 66.0f);
            path.lineTo(108.0f, 66.0f);
            path.lineTo(144.0f, 102.0f);
            path.lineTo(0.0f, 102.0f);
            path.close();
            canvas.drawPath(path, this.d);
            this.d.setColor(Color.parseColor("#99000000"));
            this.d.setStrokeWidth(1.0f);
            canvas.drawLine(0.0f, 102.0f, 144.0f, 102.0f, this.d);
            this.d.setColor(Color.parseColor("#66000000"));
            canvas.drawLine(0.0f, 103.0f, 144.0f, 103.0f, this.d);
            this.d.setColor(Color.parseColor("#33000000"));
            canvas.drawLine(0.0f, 104.0f, 144.0f, 104.0f, this.d);
            this.d.setTextSize(18.0f);
            this.d.setColor(-1);
            this.d.setAntiAlias(true);
            this.d.setTextAlign(Align.CENTER);
            canvas.drawText(this.a, 72.0f, (84.0f + (a(this.d) / 2.0f)) - 3.0f, this.d);
            canvas.restore();
        } catch (Exception e) {
        } catch (Error e2) {
        }
        return createBitmap;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setText(String str) {
        this.a = str;
        setScaleType(ScaleType.FIT_XY);
        setImageBitmap(a());
        invalidate();
    }
}
