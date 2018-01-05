package com.inveno.a;

import a.d;
import android.text.TextUtils;
import com.inveno.se.f.a;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class as {
    private static as a;
    private AtomicBoolean b = new AtomicBoolean(false);

    private as() {
    }

    static synchronized as a() {
        as asVar;
        synchronized (as.class) {
            if (a == null) {
                a = new as();
            }
            asVar = a;
        }
        return asVar;
    }

    private void b(int i) {
        switch (i) {
            case 0:
                a.a("DataSDK", "获取到uid触发上报");
                return;
            case 1:
                a.a("DataSDK", "退出列表触发上报");
                return;
            case 2:
                a.a("DataSDK", "条目点击触发上报");
                return;
            case 3:
                a.a("DataSDK", "内容条目阅读结束触发上报");
                return;
            case 4:
                a.a("DataSDK", "退出页面触发上报");
                return;
            case 5:
                a.a("DataSDK", "reset触发上报");
                return;
            case 6:
                a.a("DataSDK", "后台报活事件触发上报");
                return;
            case 7:
                a.a("DataSDK", "达到上报缓存上限触发上报");
                return;
            case 8:
                a.a("DataSDK", "轮询时间到触发上报");
                return;
            case 10:
                a.a("DataSDK", "自定义事件触发上报");
                return;
            default:
                return;
        }
    }

    private void b(ap apVar) {
        a.a("DataSDK", "上报成功：" + apVar);
        this.b.set(false);
        switch (apVar.b) {
            case 2:
                e(apVar);
                break;
        }
        am.a().a(new k());
    }

    private boolean b() {
        boolean z = this.b.get();
        boolean isEmpty = TextUtils.isEmpty(l.a().A());
        boolean z2 = !d.a(i.a);
        if (!z && !isEmpty && !z2) {
            return true;
        }
        String str = z ? "正在上报" : isEmpty ? "没有uid" : "没有网";
        a.a("DataSDK", str);
        return false;
    }

    private void c(ap apVar) {
        a.a("DataSDK", "上报失败：" + apVar);
        this.b.set(false);
        switch (apVar.b) {
            case 1:
                d(apVar);
                return;
            default:
                return;
        }
    }

    private boolean c(int i) {
        if (!b.a(i.a).a()) {
            return false;
        }
        switch (i) {
            case 7:
            case 9:
                return false;
            default:
                return true;
        }
    }

    private void d(ap apVar) {
        a.a("DataSDK", "写入磁盘缓存：" + apVar);
        am.a().a(new ak(apVar));
    }

    private void e(ap apVar) {
        a.a("DataSDK", "删除磁盘缓存：" + apVar);
        am.a().a(new s(apVar));
    }

    void a(int i) {
        b(i);
        if (!c(i) || b()) {
            Object c = af.a().c();
            if (TextUtils.isEmpty(c)) {
                a.a("DataSDK", "没有需要上传的事件");
                return;
            } else {
                a(new ar(c, l.a().w()).a());
                return;
            }
        }
        a.a("DataSDK", "与未上报事件合并");
    }

    void a(ap apVar) {
        if (b()) {
            this.b.set(true);
            Map a = apVar.a();
            a.a("DataSDK", ah.a().c);
            g.a().a(ah.a().c, a, new at(this, apVar));
        } else if (apVar.b == 1) {
            d(apVar);
        }
    }

    void a(x xVar) {
        a.a("DataSDK", "上报推送事件 " + xVar);
        String d = xVar.d();
        a(new ar(d, l.a().x()).a());
        a.a("DataSDK", d);
    }
}
