package com.baidu.mobads.production.g;

import android.content.Context;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.e.d;
import com.baidu.mobads.production.t;
import java.util.HashMap;

public class a extends com.baidu.mobads.production.a {
    protected final IXAdLogger w = m.a().f();
    private d x;
    private Context y;

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z, int i, int i2) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.p = SlotType.SLOT_TYPE_SPLASH;
        this.y = context;
        this.x = new d(getApplicationContext(), this.p);
        this.x.a(z);
        IXAdConstants p = m.a().p();
        this.x.b(z ? p.getSupportedActionType4RequestingNone() + "," + p.getSupportedActionType4RequestingLandingPage() + "," + p.getSupportedActionType4RequestingDownload() + "," + p.getSupportedActionType4RequestingAPO() : p.getSupportedActionType4RequestingNone());
        this.x.a(i);
        this.x.b(i2);
        this.x.e(0);
        this.x.d(str);
        this.x.c(8);
        this.x.d(1);
        this.x.f(p.getAdCreativeTypeImage());
        c(str);
    }

    protected void a(d dVar, t tVar, int i) {
        tVar.a(dVar, (double) i);
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
        Handler handler = new Handler(this.y.getMainLooper());
        handler.post(new b(this));
        handler.postDelayed(new c(this), 5000);
    }

    protected void d() {
        this.n = 4200;
    }

    protected void d(IXAdContainer iXAdContainer, HashMap hashMap) {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return m();
    }

    public com.baidu.mobads.vo.d m() {
        return this.x;
    }

    public void request() {
        i();
        a(this.x);
    }
}
