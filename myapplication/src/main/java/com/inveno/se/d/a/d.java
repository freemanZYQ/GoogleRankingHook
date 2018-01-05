package com.inveno.se.d.a;

import java.util.Comparator;

final class d implements Comparator {
    d() {
    }

    public int a(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((byte[]) obj, (byte[]) obj2);
    }
}
