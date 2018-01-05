package com.baidu.mobads.production.h;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class a extends d {
    protected IXAdProd a;

    public a(Context context, Activity activity, SlotType slotType, IXAdProd iXAdProd) {
        super(context, activity, slotType);
        this.b = "http://mobads.baidu.com/cpro/ui/mads.php";
        this.a = iXAdProd;
    }

    protected HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("slottype", this.f.getValue());
        hashMap.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
        hashMap.put("prod", "video");
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
        hashMap.put(IXAdRequestInfo.AD_TYPE, "10");
        hashMap.put(IXAdRequestInfo.AD_COUNT, "1");
        if (this.a.getProdBase() == null) {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, "640");
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, "480");
        }
        return hashMap;
    }

    public String b() {
        return super.b();
    }
}
