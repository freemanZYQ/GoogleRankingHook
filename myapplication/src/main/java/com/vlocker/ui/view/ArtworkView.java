package com.vlocker.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.vlocker.locker.R;

public class ArtworkView extends View implements Runnable {
    private Paint a;
    private Paint b;
    private Paint c;
    private Paint d;
    private float e;
    private float f;
    private float g;
    private float h;
    private Bitmap i;
    private PaintFlagsDrawFilter j;
    private ImageView k;
    private Handler l;
    private boolean m;
    private boolean n;
    private Matrix o;
    private float p;

    public ArtworkView(Context context) {
        super(context);
        this.l = new a(this);
    }

    public ArtworkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArtworkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new a(this);
        c();
    }

    private void c() {
        this.c = new Paint();
        this.a = new Paint();
        this.b = new Paint();
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setColor(436207615);
        this.a.setAntiAlias(true);
        this.a.setColor(-16777216);
        this.b.setAntiAlias(true);
        this.b.setColor(1291845632);
        this.b.setStrokeWidth(getResources().getDimension(R.dimen.music_lrc_cover_line_width));
        this.b.setStyle(Style.STROKE);
        this.c.setAntiAlias(true);
        this.j = new PaintFlagsDrawFilter(0, 3);
    }

    private void d() {
        this.i = BitmapFactory.decodeResource(getResources(), R.drawable.music_lrc_cover);
        this.o = new Matrix();
        float width = ((this.f * 2.0f) / ((float) this.i.getWidth())) + 0.04f;
        float height = ((this.f * 2.0f) / ((float) this.i.getHeight())) + 0.04f;
        this.o.postScale(width, height);
        this.o.postTranslate((((float) getWidth()) - (width * ((float) this.i.getWidth()))) / 2.0f, (((float) getHeight()) - (height * ((float) this.i.getHeight()))) / 2.0f);
    }

    private void e() {
        if (this.o != null) {
            this.o.postRotate(0.5f, (float) (getWidth() / 2), (float) (getHeight() / 2));
        }
        if (this.k != null) {
            this.p += 0.5f;
            if (this.p == 360.0f) {
                this.p = 0.0f;
            }
            this.l.sendEmptyMessage(0);
        }
    }

    private void f() {
        this.m = true;
        this.e = getResources().getDimension(R.dimen.music_lrc_img_back_width_little) / 2.0f;
        this.f = getResources().getDimension(R.dimen.music_lrc_cover_black_width_little) / 2.0f;
        this.g = getResources().getDimension(R.dimen.music_lrc_cover_trans_width_little) / 2.0f;
        this.h = getResources().getDimension(R.dimen.music_lrc_cover_line_div_little);
        d();
    }

    public void a() {
        if (!this.n) {
            this.n = true;
            new Thread(this).start();
        }
    }

    public void a(ImageView imageView) {
        this.k = imageView;
    }

    public void b() {
        this.n = false;
    }

    protected void onDraw(Canvas canvas) {
        if (!this.m) {
            f();
        }
        super.onDraw(canvas);
        canvas.setDrawFilter(this.j);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.g, this.d);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.f, this.a);
        canvas.drawBitmap(this.i, this.o, this.c);
        float f = this.e;
        while (f < this.f) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), f, this.b);
            f += this.h;
        }
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.e, this.a);
    }

    public void run() {
        while (this.n) {
            e();
            postInvalidate();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
