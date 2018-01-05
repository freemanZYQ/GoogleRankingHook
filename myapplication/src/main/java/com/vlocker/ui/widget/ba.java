package com.vlocker.ui.widget;

import com.qq.e.comm.constants.ErrorCode.AdError;
import com.qq.e.comm.constants.ErrorCode.InitError;
import com.qq.e.comm.constants.ErrorCode.OtherError;
import java.util.ArrayList;

public class ba {
    boolean a;
    boolean b;
    int c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    public ArrayList k;

    public ba(boolean z, String str) {
        this(z, str, true);
    }

    public ba(boolean z, String str, boolean z2) {
        this.a = z;
        this.b = z2;
        if (this.a) {
            h(str);
        } else {
            g(str);
        }
    }

    private void g(String str) {
        if (str != null) {
            this.d = str;
            if (this.b) {
                this.c = OtherError.CONTAINER_INVISIBLE_ERROR;
            } else {
                this.c = 10;
            }
        }
    }

    private void h(String str) {
        if (str != null) {
            this.d = str;
            if ("type_new_version".equals(str)) {
                this.c = 100;
            } else if ("type_fix_lock".equals(str)) {
                this.c = InitError.INIT_AD_ERROR;
            } else if ("type_pwd".equals(str)) {
                this.c = 260;
            } else if ("type_msg".equals(str)) {
                this.c = 240;
            } else if ("type_main".equals(str)) {
                this.c = AdError.PLACEMENT_ERROR;
            } else if ("type_close_sys_lock".equals(str)) {
                this.c = 280;
            } else if ("type_move_app".equals(str)) {
                this.c = 270;
            }
        }
    }

    public String a() {
        return this.d;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(ArrayList arrayList) {
        this.k = arrayList;
    }

    public String b() {
        return this.e;
    }

    public void b(String str) {
        this.i = str;
    }

    public String c() {
        return this.i;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.f;
    }

    public void d(String str) {
        this.g = str;
    }

    public String e() {
        return this.g;
    }

    public void e(String str) {
        this.h = str;
    }

    public String f() {
        return this.h;
    }

    public void f(String str) {
        this.j = str;
    }

    public ArrayList g() {
        return this.k;
    }

    public String h() {
        return this.j;
    }

    public String toString() {
        return "BannerModel [type=" + this.d + ", imgUrl=" + this.e + ", tag=" + this.f + ", title=" + this.g + ", dataUrl=" + this.h + ", subType=" + this.j + "]";
    }
}
