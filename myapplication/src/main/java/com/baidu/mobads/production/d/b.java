package com.baidu.mobads.production.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.e.d;
import com.baidu.mobads.production.t;
import java.util.HashMap;

public class b extends com.baidu.mobads.production.a {
    private boolean A = true;
    private double B = 0.5d;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private ViewGroup F;
    private RelativeLayout G;
    protected final IXAdLogger w = m.a().f();
    IXAdCommonUtils x;
    private a y;
    private RelativeLayout z;

    class a {
        Activity a;
        View b;
        int c;
        int d;

        a() {
        }
    }

    public b(Activity activity, String str, boolean z, double d) {
        super(activity, str, SlotType.SLOT_TYPE_FRONTLINK);
        setActivity(activity);
        this.x = m.a().m();
        this.C = this.x.getPixel(activity, 80);
        this.D = this.x.getPixel(activity, 80);
        this.E = this.x.getStatusBarHeight(activity);
        this.B = d;
        this.A = z;
        this.y = new a(getApplicationContext());
        this.y.d(str);
        m().a(this.D);
        m().b(this.C);
        a(activity);
        request();
    }

    private void a(Activity activity) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.D, this.C);
        if (this.A) {
            layoutParams.addRule(9);
        } else {
            layoutParams.addRule(11);
        }
        int height = this.x.getScreenRect(activity).height();
        int i = (int) (((double) height) * this.B);
        height = (height - this.C) - this.E;
        if (i <= height) {
            height = i;
        }
        layoutParams.topMargin = height;
        this.G = new RelativeLayout(activity);
        this.z = new RelativeLayout(activity);
        this.z.setBackgroundColor(0);
        setAdSlotBase(this.z);
        this.G.addView(this.z, layoutParams);
        this.G.setBackgroundColor(0);
        this.F = (ViewGroup) activity.getWindow().getDecorView();
        this.F.addView(this.G, new LayoutParams(-1, -1));
    }

    protected void a(d dVar, t tVar, int i) {
        tVar.a(dVar, (double) i);
    }

    void a(a aVar) {
        Context context = aVar.a;
        View view = this.z;
        IXAdCommonUtils m = m.a().m();
        Rect screenRect = m.getScreenRect(context);
        this.h.getAdView().setOnTouchListener(new c(this, screenRect.width(), screenRect.height(), view, m.getPixel(context, aVar.c), m.getPixel(context, aVar.d)));
    }

    public void c() {
        if (this.h != null) {
            this.h.load();
        } else {
            this.w.e("container is null");
        }
    }

    protected void c(IXAdContainer iXAdContainer, HashMap hashMap) {
        start();
    }

    protected void d() {
        this.n = 4200;
    }

    protected void d(IXAdContainer iXAdContainer, HashMap hashMap) {
        View adView = iXAdContainer.getAdView();
        a aVar = new a();
        aVar.b = adView;
        aVar.a = getActivity();
        aVar.d = 80;
        aVar.c = 80;
        a(aVar);
    }

    protected void e(IXAdContainer iXAdContainer, HashMap hashMap) {
        super.e(iXAdContainer, hashMap);
        if (this.F != null && this.G != null) {
            this.F.removeView(this.G);
            this.F = null;
            this.G = null;
            l();
        }
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return m();
    }

    public void l() {
        if (this.F != null && this.G != null) {
            this.F.removeView(this.G);
            this.F = null;
            this.G = null;
            l();
        }
    }

    public com.baidu.mobads.vo.d m() {
        return this.y;
    }

    public void request() {
        a(this.y);
    }
}
