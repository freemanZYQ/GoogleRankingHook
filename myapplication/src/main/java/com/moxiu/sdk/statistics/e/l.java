package com.moxiu.sdk.statistics.e;

public class l {
    public static synchronized byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        synchronized (l.class) {
            bArr3 = null;
            try {
                bArr3 = b(bArr, bArr2);
            } catch (Throwable e) {
                i.a("getEncryptData Exception = ", e);
            }
        }
        return bArr3;
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr;
    }
}
