package com.baidu.mobads.production.a;

import android.content.Context;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.e.d;
import com.baidu.mobads.production.t;
import com.baidu.mobads.vo.b;
import com.baidu.mobads.vo.c;
import java.util.HashMap;
import org.json.JSONException;

public class a extends com.baidu.mobads.production.a implements IXNonLinearAdSlot {
    private c w;

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.p = SlotType.SLOT_TYPE_BANNER;
        m.a().p();
        this.w = new c(getApplicationContext(), getActivity(), this.p);
        this.w.c(AdSize.Banner.getValue());
        this.w.d(str);
        ((b) this.w.d()).a(z);
        c(str);
    }

    protected void a() {
        new Thread(new b(this)).start();
    }

    protected void a(d dVar, t tVar, int i) {
        String str = "{'ad':[{'id':99999999,'url':'" + this.w.b() + "', type='" + CreativeType.HTML.getValue() + "'}],'n':1}";
        this.b = Boolean.valueOf(true);
        try {
            setAdResponseInfo(new c(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a("XAdMouldeLoader ad-server requesting success");
    }

    protected void b(com.baidu.mobads.vo.d dVar) {
        this.l = dVar;
        g();
        a(null, null, 5000);
    }

    public void c() {
        load();
    }

    protected void c(IXAdContainer iXAdContainer, HashMap hashMap) {
        start();
    }

    protected void d() {
        this.n = 10000;
    }

    protected void d(IXAdContainer iXAdContainer, HashMap hashMap) {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return m();
    }

    public com.baidu.mobads.vo.d m() {
        return this.w;
    }

    public void request() {
        a(this.w);
        try {
            WebView webView = new WebView(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
