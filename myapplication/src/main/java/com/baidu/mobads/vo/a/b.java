package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.j.m;
import java.util.HashMap;

public class b extends a {
    public boolean n = true;
    private Context o;
    private IXAppInfo p;

    public b(Context context, IXAppInfo iXAppInfo) {
        super(iXAppInfo.getAdId(), iXAppInfo.getQk(), iXAppInfo.getProd());
        this.o = context;
        this.p = iXAppInfo;
    }

    protected HashMap b() {
        String str = "" + m.a().n().getCurrentProcessId(this.o);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("autoOpen", this.n ? "true" : "false");
            hashMap.put(IXAdRequestInfo.PACKAGE, this.p.getPackageName());
            hashMap.put("c", "0");
            hashMap.put("clickProcId", str);
            hashMap.put("clickTime", this.p.getClickTime() + "");
            hashMap.put("contentLength", "" + this.p.getAppSize());
            hashMap.put("dlCnt", "1");
            hashMap.put("dlTime", String.valueOf(System.currentTimeMillis() - this.p.getClickTime()));
            hashMap.put("dlTunnel", "3");
            hashMap.put("dlWay", this.p.isTooLarge() ? "1" : "0");
            hashMap.put("exp_id", "");
            hashMap.put("exp2", "");
            hashMap.put("pkg", this.p.getPackageName());
            hashMap.put("typeProcId", str);
            hashMap.put("url2", "");
            hashMap.put(IXAdRequestInfo.SN, m.a().e().encode(m.a().n().getDeviceId(this.o)));
        } catch (Throwable e) {
            m.a().f().d(e);
        }
        return hashMap;
    }
}
