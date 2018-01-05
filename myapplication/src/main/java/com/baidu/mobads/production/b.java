package com.baidu.mobads.production;

import com.baidu.mobads.c.a;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.vo.c;
import org.json.JSONException;

class b implements IOAdEventListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run(IOAdEvent iOAdEvent) {
        String str;
        this.a.g();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            try {
                this.a.setAdResponseInfo(new c((String) iOAdEvent.getData().get(com.baidu.mobads.openad.d.b.EVENT_MESSAGE)));
                if (this.a.getAdResponseInfo().getAdInstanceList().size() > 0) {
                    this.a.b = Boolean.valueOf(true);
                    this.a.a("XAdMouldeLoader ad-server requesting success");
                    return;
                }
                m.a().q().printErrorMessage(this.a.getAdResponseInfo().getErrorCode(), this.a.getAdResponseInfo().getErrorMessage(), "");
                this.a.b(this.a.getAdResponseInfo().getErrorMessage());
                return;
            } catch (JSONException e) {
                str = "response json parsing error";
                m.a().q().printErrorMessage("", str, "");
                this.a.b(str);
                a.a().a(str);
                return;
            }
        }
        str = "request ad-server error, io_err/timeout";
        m.a().q().printErrorMessage("", str, "");
        this.a.b(str);
        a.a().a(str);
    }
}
