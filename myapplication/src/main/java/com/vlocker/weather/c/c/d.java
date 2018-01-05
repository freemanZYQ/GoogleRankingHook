package com.vlocker.weather.c.c;

import java.util.ArrayList;
import java.util.List;

public class d extends b {
    private String a;
    private String b;
    private String c;
    private String d;
    private List e = new ArrayList();

    public d(String str, String str2, String str3, List list, String str4, boolean z) {
        this.b = str;
        this.d = str2;
        this.a = str3;
        this.e = list;
        this.c = str4;
        if (!z || list.size() < 3) {
            a(1);
        } else {
            a(2);
        }
    }

    public String b() {
        return "热度" + this.a + "℃";
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public List e() {
        return this.e;
    }

    public String f() {
        return this.d;
    }
}
