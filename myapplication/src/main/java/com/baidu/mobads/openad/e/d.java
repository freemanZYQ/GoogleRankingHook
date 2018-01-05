package com.baidu.mobads.openad.e;

import android.net.Uri.Builder;
import com.baidu.mobads.j.m;

public class d {
    public String a;
    public String b;
    public long c = 0;
    public String d = "text/plain";
    public int e = 1;
    private Builder f;

    public d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return m.a().i().getFixedString(this.a);
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(Builder builder) {
        this.f = builder;
    }

    public Builder b() {
        return this.f;
    }
}
