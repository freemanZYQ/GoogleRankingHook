package com.moxiu.sdk.statistics.a;

import com.moxiu.sdk.statistics.c.b;
import com.moxiu.sdk.statistics.e.f;
import java.io.Serializable;

public class a implements Serializable {
    private int a;
    private f b;
    private String c;
    private byte[] d;
    private boolean e;

    private a() {
    }

    public static a a(int i, int i2, String str, byte[] bArr) {
        a aVar = new a();
        aVar.d = bArr;
        aVar.a = i;
        aVar.c = str;
        aVar.b = f.a(i2);
        aVar.e = true;
        return aVar;
    }

    public static a a(b bVar, f fVar) {
        if (bVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.d = bVar.a();
        aVar.a = bVar.b();
        aVar.c = bVar.c();
        aVar.b = fVar;
        aVar.e = false;
        return aVar;
    }

    public static a b(int i, int i2, String str, byte[] bArr) {
        a aVar = new a();
        aVar.d = bArr;
        aVar.a = i;
        aVar.c = str;
        aVar.b = f.a(i2);
        aVar.e = false;
        return aVar;
    }

    public int a() {
        return this.a;
    }

    public f b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public byte[] d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }
}
