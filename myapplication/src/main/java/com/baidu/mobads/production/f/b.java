package com.baidu.mobads.production.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.e.d;
import com.baidu.mobads.production.a;
import com.baidu.mobads.production.t;
import java.util.HashMap;

public class b extends a implements a {
    private boolean A = false;
    private boolean B = false;
    private Activity C;
    private RelativeLayout D;
    private Boolean E;
    public final String w = "html5_intersitial";
    protected final IXAdLogger x = m.a().f();
    private d y;
    private AdSize z;

    public b(Context context, RelativeLayout relativeLayout, Boolean bool, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.p = SlotType.SLOT_TYPE_INTERSTITIAL;
        this.E = bool;
        this.z = AdSize.InterstitialGame;
        m.a().p();
        this.y = new d(getApplicationContext(), getActivity(), this.p, Boolean.valueOf(true));
        this.y.d(str);
        this.y.c(AdSize.InterstitialGame.getValue());
        c(str);
    }

    private ViewGroup c(Context context) {
        return (ViewGroup) ((Activity) context).getWindow().getDecorView();
    }

    public void a(int i, int i2) {
    }

    public void a(Activity activity) {
        if (this.A && !this.B) {
            this.B = true;
            this.A = false;
            this.C = activity;
            start();
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            this.e.setBackgroundColor(0);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = rect.top;
            ViewGroup c = c((Context) activity);
            this.D = new RelativeLayout(activity);
            this.D.addView(this.e, layoutParams);
            c.addView(this.D, new RelativeLayout.LayoutParams(-1, -1));
            this.e.setFocusableInTouchMode(true);
            this.e.setFocusable(true);
            this.e.requestFocus();
        } else if (this.B) {
            this.x.w("interstitial ad is showing now");
        } else if (!this.A) {
            this.x.w("interstitial ad is not ready");
        }
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
    }

    protected void a(d dVar, t tVar, int i) {
        tVar.a(dVar, "{'ad':[{'id':99999999,'url':'" + this.y.b() + "', type='" + CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    public void c() {
    }

    protected void c(IXAdContainer iXAdContainer, HashMap hashMap) {
        this.A = true;
        if (hashMap != null) {
            Object obj = hashMap.get("type");
            if (obj != null && !((String) obj).equals("video")) {
            }
        }
    }

    protected void d() {
        this.n = 8000;
    }

    protected void d(IXAdContainer iXAdContainer, HashMap hashMap) {
    }

    protected void e(IXAdContainer iXAdContainer, HashMap hashMap) {
        o();
        this.B = false;
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return n();
    }

    public void m() {
        load();
    }

    public com.baidu.mobads.vo.d n() {
        return this.y;
    }

    public void o() {
        if (this.C != null) {
            this.C.runOnUiThread(new c(this));
        }
    }

    public boolean r() {
        return this.A;
    }

    public void request() {
        super.a(this.y);
    }

    public void start() {
        super.start();
    }
}
