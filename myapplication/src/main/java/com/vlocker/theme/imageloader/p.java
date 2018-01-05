package com.vlocker.theme.imageloader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class p {
    final /* synthetic */ l a;
    private final String b;
    private final long[] c;
    private boolean d;
    private n e;
    private long f;

    private p(l lVar, String str) {
        this.a = lVar;
        this.b = str;
        this.c = new long[lVar.g];
    }

    private void a(String[] strArr) {
        if (strArr.length != this.a.g) {
            throw b(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                this.c[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw b(strArr);
            }
        }
    }

    private IOException b(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File a(int i) {
        return new File(this.a.b, this.b + "." + i);
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.c) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    public File b(int i) {
        return new File(this.a.b, this.b + "." + i + ".tmp");
    }
}
