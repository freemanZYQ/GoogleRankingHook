package com.inveno.a;

import org.json.JSONObject;

public abstract class u {
    final int a;
    final long b;

    u(int i, long j) {
        this.a = i;
        this.b = j;
    }

    static String a(long j, long j2) {
        return String.valueOf(((j - j2) + 999) / 1000);
    }

    abstract JSONObject a();

    String b() {
        return String.valueOf(this.b / 1000);
    }
}
