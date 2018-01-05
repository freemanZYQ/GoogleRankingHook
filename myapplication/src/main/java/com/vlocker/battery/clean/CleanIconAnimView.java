package com.vlocker.battery.clean;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.security.MoSecurityApplication;
import java.util.ArrayList;
import java.util.List;

public class CleanIconAnimView extends View {
    private List a = new ArrayList();
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r = 1.0f;
    private float s = 1.0f;
    private float t = 0.0f;
    private Matrix u = new Matrix();
    private ValueAnimator v;
    private ValueAnimator w;
    private ValueAnimator x;
    private boolean y = true;

    public CleanIconAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
        c();
    }

    private void a(int i, Canvas canvas) {
        float f;
        float f2;
        float f3 = 0.0f;
        this.u.reset();
        switch (i) {
            case 0:
                f = this.p + (this.b * this.s);
                f2 = (this.c * this.s) + this.q;
                f3 = this.s;
                break;
            case 1:
                f = this.p + (this.d * this.r);
                f2 = (this.e * this.r) + this.q;
                f3 = this.r * 0.7f;
                break;
            case 2:
                f = this.p + (this.f * this.s);
                f2 = (this.g * this.s) + this.q;
                f3 = this.s * 0.7f;
                break;
            case 3:
                f = this.p + (this.h * this.r);
                f2 = (this.i * this.r) + this.q;
                f3 = this.r * 0.7f;
                break;
            case 4:
                f = this.p + (this.j * this.s);
                f2 = (this.k * this.s) + this.q;
                f3 = this.s;
                break;
            case 5:
                f = this.p + (this.l * this.r);
                f2 = (this.m * this.r) + this.q;
                f3 = this.r;
                break;
            case 6:
                f = this.p + (this.n * this.s);
                f2 = (this.o * this.s) + this.q;
                f3 = this.s;
                break;
            default:
                f2 = 0.0f;
                f = 0.0f;
                break;
        }
        this.u.setScale(f3, f3);
        this.u.postRotate(this.y ? (this.t * 6.0f) - 3.0f : ((1.0f - this.t) * 6.0f) - 3.0f, ((float) l.a(20.0f)) * f3, f3 * ((float) l.a(20.0f)));
        this.u.postTranslate(f, f2);
        try {
            canvas.drawBitmap((Bitmap) this.a.get(i), this.u, null);
        } catch (Exception e) {
        }
    }

    private void c() {
        this.v = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.v.setDuration(300);
        this.v.setStartDelay(500);
        this.v.setInterpolator(new LinearInterpolator());
        this.v.addUpdateListener(new u(this));
        this.w = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.w.setDuration(300);
        this.w.setStartDelay(600);
        this.w.setInterpolator(new LinearInterpolator());
        this.w.addUpdateListener(new v(this));
        this.x = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.x.setDuration(100);
        this.x.setRepeatCount(-1);
        this.x.setInterpolator(new LinearInterpolator());
        this.x.addUpdateListener(new w(this));
        this.x.addListener(new x(this));
    }

    private void d() {
        this.b = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_1_x);
        this.c = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_1_y);
        this.d = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_2_x);
        this.e = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_2_y);
        this.f = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_3_x);
        this.g = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_3_y);
        this.h = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_4_x);
        this.i = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_4_y);
        this.j = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_5_x);
        this.k = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_5_y);
        this.l = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_6_x);
        this.m = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_6_y);
        this.n = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_7_x);
        this.o = getContext().getResources().getDimension(R.dimen.clean_icon_view_pos_7_y);
    }

    private void e() {
        for (int i = 0; i < this.a.size(); i++) {
            Bitmap bitmap = (Bitmap) this.a.get(i);
        }
        this.a.clear();
    }

    public void a() {
        this.r = 1.0f;
        this.s = 1.0f;
        e();
    }

    public void a(List list) {
        int i = 0;
        this.a.clear();
        int size = list.size() > 7 ? 7 : list.size();
        while (i < size) {
            try {
                PackageManager packageManager = MoSecurityApplication.a().getPackageManager();
                this.a.add(Bitmap.createScaledBitmap(((BitmapDrawable) packageManager.getPackageInfo((String) list.get(i), 0).applicationInfo.loadIcon(packageManager)).getBitmap(), l.a(48.0f), l.a(48.0f), true));
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void b() {
        this.v.start();
        this.w.start();
        this.x.start();
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        this.p = (float) (getWidth() / 2);
        this.q = (float) (getHeight() / 2);
        canvas.save();
        canvas.rotate((1.0f - this.r) * 70.0f, this.p, this.q);
        int i2 = 0;
        while (i2 < this.a.size()) {
            if (i2 == 1 || i2 == 3 || i2 == 5) {
                a(i2, canvas);
            }
            i2++;
        }
        canvas.restore();
        canvas.save();
        canvas.rotate((1.0f - this.s) * 70.0f, this.p, this.q);
        while (i < this.a.size()) {
            if (i == 0 || i == 2 || i == 4 || i == 6) {
                a(i, canvas);
            }
            i++;
        }
        canvas.restore();
    }
}
