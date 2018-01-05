package com.baidu.mobads.h;

import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.e.a;
import com.baidu.mobads.openad.e.d;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import java.util.HashMap;

class l implements Runnable {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public void run() {
        try {
            IXAdURIUitls i = m.a().i();
            double d = this.a.a ? g.b.a : 0.0d;
            IOAdEventListener mVar;
            HashMap hashMap;
            d dVar;
            if (this.a.a) {
                mVar = new m(this, d);
                hashMap = new HashMap();
                hashMap.put(IXAdRequestInfo.V, "" + d);
                hashMap.put(IXAdRequestInfo.OS, "android");
                hashMap.put(IXAdRequestInfo.PHONE_TYPE, m.a().m().getTextEncoder(Build.MODEL));
                hashMap.put(IXAdRequestInfo.BDR, m.a().m().getTextEncoder(VERSION.SDK));
                dVar = new d(i.addParameters(g.h, hashMap), "");
                dVar.e = 1;
                this.a.b.i = new a();
                this.a.b.i.addEventListener("URLLoader.Load.Complete", mVar);
                this.a.b.i.addEventListener("URLLoader.Load.Error", mVar);
                this.a.b.i.a(dVar);
            } else {
                mVar = new m(this, d);
                hashMap = new HashMap();
                hashMap.put(IXAdRequestInfo.V, "" + d);
                hashMap.put(IXAdRequestInfo.OS, "android");
                hashMap.put(IXAdRequestInfo.PHONE_TYPE, m.a().m().getTextEncoder(Build.MODEL));
                hashMap.put(IXAdRequestInfo.BDR, m.a().m().getTextEncoder(VERSION.SDK));
                dVar = new d(i.addParameters(g.h, hashMap), "");
                dVar.e = 1;
                this.a.b.i = new a();
                this.a.b.i.addEventListener("URLLoader.Load.Complete", mVar);
                this.a.b.i.addEventListener("URLLoader.Load.Error", mVar);
                this.a.b.i.a(dVar);
            }
        } catch (Exception e) {
        }
    }
}
