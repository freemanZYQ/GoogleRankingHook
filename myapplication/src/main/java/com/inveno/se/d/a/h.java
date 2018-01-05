package com.inveno.se.d.a;

import java.io.FilterInputStream;
import java.io.InputStream;

class h extends FilterInputStream {
    private int a;

    private h(InputStream inputStream) {
        super(inputStream);
        this.a = 0;
    }

    public int read() {
        int read = super.read();
        if (read != -1) {
            this.a++;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.a += read;
        }
        return read;
    }
}
