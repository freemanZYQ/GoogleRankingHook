package com.baidu.location.h;

import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;

public final class d {
    public static k a() {
        return c.a();
    }

    public static String a(int i) {
        if (m.a().g()) {
            return "WIFI";
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case IMediaObject.TYPE_OLD_TV /*14*/:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return IXAdSystemUtils.NT_UNKNOWN;
        }
    }
}
