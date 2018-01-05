package com.baidu.mobads.production.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
    private CountDownTimer A;
    private f B;
    private boolean C = false;
    private boolean D = false;
    private Activity E;
    private Boolean F;
    public final String w = "html5_intersitial";
    protected final IXAdLogger x = m.a().f();
    private RelativeLayout y;
    private TextView z;

    public b(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.p = SlotType.SLOT_TYPE_INTERSTITIAL;
        this.F = bool;
        this.B = new f(getApplicationContext(), getActivity(), this.p, Boolean.valueOf(true));
        this.B.c(SlotType.SLOT_TYPE_INTERSTITIAL.getValue());
        this.B.c(adSize.getValue());
        this.B.d(str);
        c(str);
    }

    private boolean s() {
        return o();
    }

    private View t() {
        if (this.y == null) {
            this.y = new RelativeLayout(this.f);
            this.y.setBackgroundColor(Color.argb(42, 0, 0, 0));
            this.z = new TextView(this.f);
            this.z.setTextColor(-65536);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.y.addView(this.z, layoutParams);
        }
        this.A = new e(this, 6000, 1000).start();
        return this.y;
    }

    private void u() {
        if (!(this.y == null || this.y.getParent() == null)) {
            ((ViewGroup) this.y.getParent()).removeView(this.y);
        }
        if (this.A != null) {
            this.x.d("cancel countDownTimer before it finished");
            try {
                this.A.cancel();
            } catch (Throwable e) {
                this.x.d(e);
            }
        }
    }

    private RelativeLayout.LayoutParams v() {
        int screenDensity = (int) (20.0f * m.a().m().getScreenDensity(this.f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenDensity, screenDensity);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        return layoutParams;
    }

    public void a(int i, int i2) {
        if (!this.C && !this.D) {
            this.B.a(i);
            this.B.b(i2);
            load();
        }
    }

    public void a(Activity activity) {
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.x.d("showInterstitialAdInit");
            if (this.C && !this.D) {
                this.D = true;
                this.C = false;
                this.E = activity;
                start();
                q();
                this.e.setBackgroundColor(0);
                View relativeLayout2 = new RelativeLayout(activity);
                relativeLayout2.setBackgroundColor(0);
                relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -1));
                this.e.addView(this.h.getAdView(), new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout2.addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
                this.h.getAdView().setVisibility(4);
            } else if (this.D) {
                this.x.w("interstitial ad is showing now");
            } else if (!this.C) {
                this.x.w("interstitial ad is not ready");
            }
        } catch (Throwable e) {
            this.x.d(e);
        }
    }

    protected void a(d dVar, t tVar, int i) {
        tVar.a(dVar, "{'ad':[{'id':99999999,'url':'" + this.B.b() + "', type='" + CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return true;
    }

    public void c() {
    }

    protected void c(IXAdContainer iXAdContainer, HashMap hashMap) {
        this.C = true;
    }

    protected void d() {
        this.n = 8000;
    }

    protected void d(IXAdContainer iXAdContainer, HashMap hashMap) {
        n();
    }

    protected void e(IXAdContainer iXAdContainer, HashMap hashMap) {
        q();
        this.D = false;
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return p();
    }

    public void m() {
    }

    public void n() {
        new Handler(Looper.getMainLooper()).post(new c(this));
    }

    protected boolean o() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == this.B.getApt();
    }

    public com.baidu.mobads.vo.d p() {
        return this.B;
    }

    protected void q() {
        if (this.E != null) {
            this.E.runOnUiThread(new d(this));
        }
    }

    public boolean r() {
        return this.C;
    }

    public void request() {
        super.a(this.B);
    }

    public void start() {
        super.start();
    }
}
