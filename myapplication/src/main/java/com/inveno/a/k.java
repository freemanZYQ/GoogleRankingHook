package com.inveno.a;

import com.inveno.se.f.a;
import java.util.List;

class k extends al {
    k() {
    }

    void a() {
        a.a("DataSDK", "查询上报失败缓存");
        List a = n.a().a(1);
        if (a.size() > 0) {
            a.a("DataSDK", "重传最近失败的一次上报");
            as.a().a((ap) a.get(0));
            return;
        }
        a.a("DataSDK", "上报失败缓存为空");
    }
}
