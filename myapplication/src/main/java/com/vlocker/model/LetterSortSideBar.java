package com.vlocker.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.vlocker.locker.R;
import java.util.ArrayList;
import java.util.List;

public class LetterSortSideBar extends View {
    public List a = new ArrayList();
    public int b = 0;
    private i c;
    private Paint d = new Paint();
    private boolean e = false;
    private List f = new ArrayList();
    private Context g;
    private float h = 0.5f;
    private float i = 0.5f;
    private int j = 0;
    private int k = 0;
    private TextView l;
    private List m = new ArrayList();
    private int n;

    public LetterSortSideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = context;
        a();
    }

    public LetterSortSideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = context;
        a();
    }

    private void a() {
        this.n = getResources().getColor(R.color.v2_setting_set_color);
    }

    public int a(float f) {
        return (int) (255.0f * f);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.b;
        i iVar = this.c;
        if (this.a == null || this.a.size() == 0) {
            return false;
        }
        int height = (int) ((y / ((float) getHeight())) * ((float) this.a.size()));
        switch (action) {
            case 0:
                this.e = false;
                if (height >= 0 && height < this.a.size()) {
                    if (iVar != null) {
                        iVar.a((String) this.a.get(height), 0);
                    }
                    if (this.l != null) {
                        this.l.setText((CharSequence) this.a.get(height));
                        this.l.setVisibility(0);
                    }
                    this.b = height;
                    invalidate();
                    break;
                }
            case 1:
                if (i != height && height >= 0 && height < this.a.size()) {
                    this.b = height;
                    invalidate();
                }
                iVar.a((String) this.a.get(i), 1);
                if (this.l != null) {
                    postDelayed(new h(this), 400);
                    break;
                }
                break;
            case 2:
                this.e = false;
                if (i != height) {
                    if (height >= 0 && height < this.a.size()) {
                        if (iVar != null) {
                            iVar.a((String) this.a.get(height), 2);
                        }
                        if (this.l != null) {
                            this.l.setText((CharSequence) this.a.get(height));
                            this.l.setVisibility(0);
                        }
                        this.b = height;
                        invalidate();
                        break;
                    }
                }
                if (iVar != null) {
                    iVar.a((String) this.a.get(height), -1);
                }
                if (this.l != null) {
                    this.l.setText((CharSequence) this.a.get(height));
                    this.l.setVisibility(0);
                }
                this.b = height;
                invalidate();
                break;
        }
        return true;
    }

    public boolean getScrollState() {
        return this.e;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int size = this.a != null ? this.a.size() == 0 ? 1 : height / this.a.size() : 1;
        for (int i = 0; i < this.a.size(); i++) {
            this.d.setTypeface(Typeface.DEFAULT_BOLD);
            this.d.setAntiAlias(true);
            this.d.setColor(-16777216);
            this.d.setAlpha(a(0.5f));
            this.d.setTextSize(getResources().getDimension(R.dimen.vlocker_letter_sidebar_text_size));
            FontMetrics fontMetrics = this.d.getFontMetrics();
            float measureText = ((float) (width / 2)) - (this.d.measureText((String) this.a.get(i)) / 2.0f);
            float ceil = (float) ((size * i) + ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent))));
            if (this.f.contains((String) this.a.get(i))) {
                this.d.setColor(this.n);
            }
            canvas.drawText((String) this.a.get(i), measureText, ceil, this.d);
            this.d.reset();
        }
    }

    public void setOnTouchingLetterChangedListener(i iVar) {
        this.c = iVar;
    }

    public void setScrollState(boolean z) {
        this.e = z;
    }
}
