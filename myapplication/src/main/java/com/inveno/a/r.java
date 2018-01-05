package com.inveno.a;

import a.e;
import a.f;
import android.text.TextUtils;
import com.inveno.se.f.a;
import com.qq.e.comm.constants.ErrorCode.InitError;
import java.io.File;
import java.io.IOException;

class r {
    private static r c;
    private ao a = new ao(InitError.INIT_AD_ERROR);
    private String b = "";

    private r() {
    }

    static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (c == null) {
                c = new r();
            }
            rVar = c;
        }
        return rVar;
    }

    boolean a(x xVar) {
        String c = xVar.c();
        boolean equals = TextUtils.isEmpty(this.b) ? false : this.b.indexOf("#") == -1 ? this.b.equals(c) : (this.b.indexOf(new StringBuilder().append(c).append("#").toString()) == -1 && this.b.indexOf("#" + c) == -1) ? false : true;
        if (equals) {
            a.a("DataSDK", "重复事件 eventId = " + xVar.a + " scenario = " + xVar.c + " contentId = " + xVar.d);
            return true;
        }
        this.a.a(c);
        this.b = this.a.toString();
        if (m.c) {
            d();
        }
        a.a("DataSDK", "加入去重缓存 eventId = " + xVar.a + " scenario = " + xVar.c + " contentId = " + xVar.d);
        return false;
    }

    void b() {
        if (m.c) {
            this.b = e.a(e.a(i.a, "reportdata" + File.separator + "de_duplication"));
        } else {
            this.b = f.c(i.a, "data_sdk", "de_duplication");
        }
        if (!TextUtils.isEmpty(this.b)) {
            for (Object a : this.b.split("#")) {
                this.a.a(a);
            }
        }
        a.a("DataSDK", "去重缓存恢复：" + this.b);
    }

    void c() {
        this.a.c();
        this.b = this.a.toString();
    }

    void d() {
        this.b = this.a.toString();
        if (m.c && !TextUtils.isEmpty(this.b)) {
            try {
                e.a(this.b, e.a(i.a, "reportdata" + File.separator + "de_duplication"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        f.a(i.a, "data_sdk", "de_duplication", this.b);
        a.a("DataSDK", "去重缓存持久化：" + this.b);
    }
}
