package com.moxiu.sdk.statistics.b;

public class a {
    public static byte[] a(com.moxiu.sdk.statistics.a.a aVar) {
        int i = 1;
        int i2 = 0;
        byte[] d = aVar.d();
        if (d == null) {
            return new byte[2];
        }
        byte[] bArr = new byte[(d.length + 3)];
        bArr[0] = (byte) 3;
        bArr[1] = (byte) aVar.a();
        if (!aVar.e()) {
            i = 0;
        }
        bArr[2] = (byte) i;
        while (i2 < d.length) {
            bArr[i2 + 3] = d[i2];
            i2++;
        }
        return bArr;
    }
}
