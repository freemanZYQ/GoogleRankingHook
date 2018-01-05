package com.baidu.mobads.production.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class b extends d {
    public b(Context context, Activity activity, SlotType slotType) {
        super(context, activity, slotType);
        this.b = "http://mobads.baidu.com/cpro/ui/mads.php";
        a("androidfeed");
    }

    protected HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
        return hashMap;
    }

    public String b() {
        return super.b();
    }
}
