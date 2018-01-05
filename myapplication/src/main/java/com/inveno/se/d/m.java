package com.inveno.se.d;

import java.util.Map;

public class m {
    public final int a;
    public final byte[] b;
    public final Map c;
    public final boolean d;

    public m(int i, byte[] bArr, Map map, boolean z) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        this.d = z;
    }

    public m(byte[] bArr, Map map) {
        this(200, bArr, map, false);
    }
}
