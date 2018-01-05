package com.baidu.mobads.g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mobads.AppActivity.ActionBarColorTheme;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.j.m;

public class a extends RelativeLayout {
    protected c a;
    Paint b;
    int c;
    int d;
    private Context e;
    private IXAdCommonUtils f;
    private ActionBarColorTheme g;
    private TextView h;

    public class a extends View {
        final /* synthetic */ a a;

        public a(a aVar, Context context) {
            this.a = aVar;
            super(context);
        }
    }

    class b extends a {
        final /* synthetic */ a b;
        private Paint c;
        private int d;

        public b(a aVar, Context context, int i) {
            this.b = aVar;
            super(aVar, context);
            this.d = i;
        }

        private Paint a() {
            if (this.c == null) {
                this.c = new Paint();
                this.c.setStyle(Style.STROKE);
                this.c.setColor(this.d);
                this.c.setAlpha(255);
                this.c.setAntiAlias(true);
                this.c.setStrokeWidth((float) ((int) this.b.f.getScreenDensity(getContext())));
            }
            return this.c;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawLine((float) this.b.f.getPixel(getContext(), 18), (float) this.b.f.getPixel(getContext(), 15), (float) this.b.f.getPixel(getContext(), 34), (float) this.b.f.getPixel(getContext(), 31), a());
            canvas.drawLine((float) this.b.f.getPixel(getContext(), 18), (float) this.b.f.getPixel(getContext(), 31), (float) this.b.f.getPixel(getContext(), 34), (float) this.b.f.getPixel(getContext(), 15), a());
        }
    }

    public interface c {
        void a();

        void b();
    }

    class d extends a {
        final /* synthetic */ a b;
        private Paint c;
        private int d;

        public d(a aVar, Context context, int i) {
            this.b = aVar;
            super(aVar, context);
            this.d = i;
        }

        private Paint a() {
            if (this.c == null) {
                this.c = new Paint();
                this.c.setColor(this.d);
                this.c.setAlpha(255);
                this.c.setAntiAlias(true);
            }
            return this.c;
        }

        private void a(Canvas canvas, int i) {
            canvas.drawCircle((float) this.b.f.getPixel(getContext(), 26), (float) this.b.f.getPixel(getContext(), i), (float) ((int) (this.b.f.getScreenDensity(getContext()) * 1.0f)), a());
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            a(canvas, 31);
            a(canvas, 15);
            a(canvas, 23);
        }
    }

    public a(Context context) {
        super(context);
        this.b = new Paint();
        this.c = 0;
        this.d = 0;
        this.e = context;
    }

    public a(Context context, ActionBarColorTheme actionBarColorTheme) {
        this(context);
        this.g = actionBarColorTheme;
        setBackgroundColor(this.g.getBackgroundColor());
        this.f = m.a().m();
        a();
    }

    protected void a() {
        int pixel = this.f.getPixel(this.e, 52);
        View bVar = new b(this, this.e, this.g.getCloseColor());
        bVar.setId(132343242);
        addView(bVar, new LayoutParams(pixel, -1));
        bVar.setOnClickListener(new b(this));
        bVar = new d(this, this.e, this.g.getCloseColor());
        bVar.setId(132343243);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(pixel, -1);
        layoutParams.addRule(11);
        bVar.setOnClickListener(new c(this));
        addView(bVar, layoutParams);
        this.h = new TextView(this.e);
        this.h.setTextSize(1, 16.0f);
        this.h.setLines(1);
        this.h.setEllipsize(TruncateAt.END);
        this.h.setGravity(16);
        this.h.setTextColor(this.g.getTitleColor());
        this.h.setText("");
        layoutParams = new LayoutParams(this.f.getScreenRect(this.e).width() - (pixel * 2), -1);
        layoutParams.addRule(14);
        addView(this.h, layoutParams);
    }

    public void a(c cVar) {
        this.a = cVar;
    }

    public void a(String str) {
        if (this.h != null) {
            this.h.setText(str);
            this.h.invalidate();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.g.equals(ActionBarColorTheme.ACTION_BAR_WHITE_THEME)) {
            this.b.setColor(-5592406);
            this.b.setStyle(Style.STROKE);
            this.b.setStrokeWidth((float) this.f.getPixel(this.e, 1));
            canvas.drawLine(0.0f, (float) this.d, (float) this.c, (float) this.d, this.b);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c = i3 - i;
        this.d = i4 - i2;
    }
}
