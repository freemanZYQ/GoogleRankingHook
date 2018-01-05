package com.baidu.mobads.production;

import com.baidu.mobads.c.a;
import com.baidu.mobads.h.g.c;
import com.baidu.mobads.interfaces.event.IXAdEvent;

class j implements c {
    final /* synthetic */ a a;

    j(a aVar) {
        this.a = aVar;
    }

    public void a(boolean z) {
        if (z) {
            try {
                if (BaiduXAdSDKContext.mApkLoader != null) {
                    a.a = BaiduXAdSDKContext.mApkLoader.g();
                    BaiduXAdSDKContext.isRemoteLoadSuccess = Boolean.valueOf(true);
                    this.a.a("XAdMouldeLoader load success");
                    return;
                }
            } catch (Throwable e) {
                com.baidu.mobads.j.j.a().e(e);
                a.a().a("async apk on load exception: " + e.toString());
                return;
            }
        }
        BaiduXAdSDKContext.mApkLoader = null;
        this.a.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR));
    }
}
