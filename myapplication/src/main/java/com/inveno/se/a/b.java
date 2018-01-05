package com.inveno.se.a;

import com.inveno.se.f.a;

public final class b {
    private static final int a(int i, int i2, int i3, int i4, int i5, int[] iArr) {
        return (((i3 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i3 << 4))) ^ ((i ^ i2) + (iArr[(i4 & 3) ^ i5] ^ i3));
    }

    public static final byte[] a(byte[] bArr, byte[] bArr2) {
        return bArr.length == 0 ? bArr : a(a(a(bArr, true), a(bArr2, false)), false);
    }

    private static final byte[] a(int[] iArr, boolean z) {
        int i;
        int length = iArr.length << 2;
        a.b("toByteArray n:" + length + " includeLength:" + z + " data:" + iArr);
        if (z) {
            i = iArr[iArr.length - 1];
            a.b("toByteArray m:" + i);
            if (i > length) {
                return null;
            }
        }
        i = length;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((iArr[i2 >>> 2] >>> ((i2 & 3) << 3)) & 255);
        }
        return bArr;
    }

    private static final int[] a(byte[] bArr, boolean z) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z) {
            iArr = new int[(length + 1)];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (length = 0; length < length2; length++) {
            int i = length >>> 2;
            iArr[i] = iArr[i] | ((bArr[length] & 255) << ((length & 3) << 3));
        }
        return iArr;
    }

    private static final int[] a(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length >= 1) {
            int[] iArr3;
            if (iArr2.length < 4) {
                iArr3 = new int[4];
                System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            } else {
                iArr3 = iArr2;
            }
            int i = iArr[length];
            int i2 = iArr[0];
            i2 = (52 / (length + 1)) + 6;
            int i3 = 0;
            while (true) {
                int i4 = i2 - 1;
                if (i2 <= 0) {
                    break;
                }
                i2 = -1640531527 + i3;
                int i5 = (i2 >>> 2) & 3;
                int i6 = 0;
                while (i6 < length) {
                    i = iArr[i6] + a(i2, iArr[i6 + 1], i, i6, i5, iArr3);
                    iArr[i6] = i;
                    i6++;
                }
                i = iArr[length] + a(i2, iArr[0], i, i6, i5, iArr3);
                iArr[length] = i;
                i3 = i2;
                i2 = i4;
            }
        }
        return iArr;
    }

    public static final byte[] b(byte[] bArr, byte[] bArr2) {
        return bArr.length == 0 ? bArr : a(b(a(bArr, false), a(bArr2, false)), true);
    }

    private static final int[] b(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length >= 1) {
            int[] iArr3;
            if (iArr2.length < 4) {
                iArr3 = new int[4];
                System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            } else {
                iArr3 = iArr2;
            }
            int i = iArr[length];
            int i2 = iArr[0];
            for (i = ((52 / (length + 1)) + 6) * -1640531527; i != 0; i -= -1640531527) {
                int i3 = (i >>> 2) & 3;
                int i4 = length;
                while (i4 > 0) {
                    i2 = iArr[i4] - a(i, i2, iArr[i4 - 1], i4, i3, iArr3);
                    iArr[i4] = i2;
                    i4--;
                }
                i2 = iArr[0] - a(i, i2, iArr[length], i4, i3, iArr3);
                iArr[0] = i2;
            }
        }
        return iArr;
    }
}
