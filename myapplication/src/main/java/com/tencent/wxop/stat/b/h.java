package com.tencent.wxop.stat.b;

public class h {
    static final /* synthetic */ boolean a = (!h.class.desiredAssertionStatus());

    private h() {
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length;
        j jVar = new j(new byte[((length * 3) / 4)]);
        if (!jVar.a(bArr, length)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (jVar.b == jVar.a.length) {
            return jVar.a;
        } else {
            Object obj = new byte[jVar.b];
            System.arraycopy(jVar.a, 0, obj, 0, jVar.b);
            return obj;
        }
    }

    public static byte[] b(byte[] bArr) {
        int length = bArr.length;
        k kVar = new k();
        int i = (length / 3) * 4;
        if (!kVar.d) {
            switch (length % 3) {
                case 0:
                    break;
                case 1:
                    i += 2;
                    break;
                case 2:
                    i += 3;
                    break;
                default:
                    break;
            }
        } else if (length % 3 > 0) {
            i += 4;
        }
        if (kVar.e && length > 0) {
            i += (kVar.f ? 2 : 1) * (((length - 1) / 57) + 1);
        }
        kVar.a = new byte[i];
        kVar.a(bArr, length);
        if (a || kVar.b == i) {
            return kVar.a;
        }
        throw new AssertionError();
    }
}
