package com.vlocker.share;

import android.text.TextUtils;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;

class l implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ h b;

    l(h hVar, int i) {
        this.b = hVar;
        this.a = i;
    }

    public void run() {
        int i = 1;
        IMediaObject wXWebpageObject = new WXWebpageObject();
        if (!TextUtils.isEmpty(this.b.m)) {
            wXWebpageObject.webpageUrl = this.b.m;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        if (!TextUtils.isEmpty(this.b.j)) {
            wXMediaMessage.title = this.b.j;
        }
        if (!TextUtils.isEmpty(this.b.l)) {
            wXMediaMessage.description = this.b.l;
        }
        if (this.b.p != null) {
            wXMediaMessage.setThumbImage(this.b.p);
        }
        BaseReq req = new Req();
        req.transaction = System.currentTimeMillis() + "";
        req.message = wXMediaMessage;
        if (this.a != 1) {
            i = 0;
        }
        req.scene = i;
        this.b.h.sendReq(req);
    }
}
