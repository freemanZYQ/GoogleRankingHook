package com.vlocker.weather.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.vlocker.weather.view.u;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class a extends Thread {
    private Bitmap A;
    private c B;
    private boolean C;
    private byte[] D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private int I;
    private int J;
    private short[] K;
    private byte[] L;
    private byte[] M;
    private byte[] N;
    private c O;
    private int P;
    private b Q;
    private byte[] R;
    public int a;
    public int b;
    private InputStream c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private Bitmap z;

    public a(InputStream inputStream, b bVar) {
        this.g = 1;
        this.B = null;
        this.C = false;
        this.D = new byte[256];
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = false;
        this.I = 0;
        this.Q = null;
        this.R = null;
        this.c = inputStream;
        this.Q = bVar;
    }

    public a(byte[] bArr, b bVar) {
        this.g = 1;
        this.B = null;
        this.C = false;
        this.D = new byte[256];
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = false;
        this.I = 0;
        this.Q = null;
        this.R = null;
        this.R = bArr;
        this.Q = bVar;
    }

    private int[] c(int i) {
        int read;
        int i2 = 0;
        int i3 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i3];
        try {
            read = this.c.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            read = 0;
        }
        if (read < i3) {
            this.d = 1;
            this.Q.a(false, -1);
        } else {
            iArr = new int[256];
            read = 0;
            while (i2 < i) {
                i3 = read + 1;
                int i4 = bArr[read] & 255;
                int i5 = i3 + 1;
                int i6 = bArr[i3] & 255;
                read = i5 + 1;
                i3 = i2 + 1;
                iArr[i2] = (((i4 << 16) | -16777216) | (i6 << 8)) | (bArr[i5] & 255);
                i2 = i3;
            }
        }
        return iArr;
    }

    private void e() {
        try {
            int i;
            int i2;
            int i3;
            int i4;
            int[] iArr = new int[(this.a * this.b)];
            if (this.G > 0) {
                if (this.G == 3) {
                    i = this.P - 2;
                    if (i > 0) {
                        this.A = a(i - 1);
                    } else {
                        this.A = null;
                    }
                }
                if (this.A != null) {
                    this.A.getPixels(iArr, 0, this.a, 0, 0, this.a, this.b);
                    if (this.G == 2) {
                        i = !this.H ? this.m : 0;
                        for (i2 = 0; i2 < this.y; i2++) {
                            i3 = ((this.w + i2) * this.a) + this.v;
                            i4 = this.x + i3;
                            while (i3 < i4) {
                                iArr[i3] = i;
                                i3++;
                            }
                        }
                    }
                }
            }
            i3 = 8;
            int i5 = 0;
            i = 0;
            i2 = 1;
            while (i5 < this.u) {
                int i6;
                int i7;
                int i8;
                if (this.p) {
                    if (i >= this.u) {
                        i2++;
                        switch (i2) {
                            case 2:
                                i = 4;
                                break;
                            case 3:
                                i = 2;
                                i3 = 4;
                                break;
                            case 4:
                                i = 1;
                                i3 = 2;
                                break;
                        }
                    }
                    i6 = i + i3;
                    i7 = i3;
                    i8 = i2;
                } else {
                    i6 = i;
                    i7 = i3;
                    i8 = i2;
                    i = i5;
                }
                i += this.s;
                if (i < this.b) {
                    i2 = i * this.a;
                    i3 = i2 + this.r;
                    i = this.t + i3;
                    i4 = this.a + i2 < i ? this.a + i2 : i;
                    i = this.t * i5;
                    i2 = i3;
                    while (i2 < i4) {
                        i3 = i + 1;
                        i = this.j[this.N[i] & 255];
                        if (i != 0) {
                            iArr[i2] = i;
                        }
                        i2++;
                        i = i3;
                    }
                }
                i5++;
                i = i6;
                i3 = i7;
                i2 = i8;
            }
            try {
                this.z = Bitmap.createBitmap(iArr, this.a, this.b, Config.ARGB_4444);
            } catch (OutOfMemoryError e) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private int f() {
        try {
            this.c = new ByteArrayInputStream(this.R);
            return j();
        } catch (Exception e) {
            return 0;
        }
    }

    private int g() {
        int i = 0;
        try {
            i = this.c.read();
        } catch (Exception e) {
            this.d = 1;
            this.Q.a(i, -1);
        }
        return i;
    }

    private int h() {
        return g() | (g() << 8);
    }

    private void i() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) g());
        }
        if (str.startsWith("GIF")) {
            r();
            if (this.e && !l()) {
                this.h = c(this.f);
                this.l = this.h[this.k];
                return;
            }
            return;
        }
        this.z = BitmapFactory.decodeByteArray(this.R, 0, this.R.length);
        if (this.z == null) {
            this.d = 1;
            this.Q.a(false, -1);
            try {
                this.c.close();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.a = this.z.getWidth();
        this.b = this.z.getHeight();
        if (this.a < 1 || this.b < 1) {
            this.d = 1;
            this.Q.a(false, -1);
            try {
                this.c.close();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        this.O = new c(this, this.z, this.I);
        this.B = this.O;
        this.Q.a(true, 1, u.COVER);
        this.d = -1;
        try {
            this.c.close();
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }

    private int j() {
        m();
        try {
            if (this.c != null) {
                i();
                if (!l()) {
                    o();
                    if (this.P < 0) {
                        this.d = 1;
                        this.Q.a(false, -1);
                    } else {
                        this.d = -1;
                        this.Q.a(true, -1);
                    }
                }
                try {
                    if (this.c != null) {
                        this.c.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                this.d = 2;
                this.Q.a(false, -1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.d = 2;
            this.Q.a(false, -1);
        }
        return this.d;
    }

    private void k() {
        int i;
        int i2 = this.t * this.u;
        if (this.N == null || this.N.length < i2) {
            this.N = new byte[i2];
        }
        if (this.K == null) {
            this.K = new short[4096];
        }
        if (this.L == null) {
            this.L = new byte[4096];
        }
        if (this.M == null) {
            this.M = new byte[4097];
        }
        int g = g();
        int i3 = 1 << g;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = g + 1;
        int i7 = (1 << i6) - 1;
        for (i = 0; i < i3; i++) {
            this.K[i] = (short) 0;
            this.L[i] = (byte) i;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = -1;
        i = 0;
        while (i12 < i2) {
            int i16;
            int i17;
            if (i9 == 0) {
                if (i14 >= i6) {
                    i16 = i11 & i7;
                    i11 >>= i6;
                    i14 -= i6;
                    if (i16 <= i5 && i16 != i4) {
                        if (i16 != i3) {
                            if (i15 != -1) {
                                int i18;
                                if (i16 == i5) {
                                    i18 = i9 + 1;
                                    this.M[i9] = (byte) i10;
                                    i10 = i15;
                                } else {
                                    i18 = i9;
                                    i10 = i16;
                                }
                                while (i10 > i3) {
                                    i9 = i18 + 1;
                                    this.M[i18] = this.L[i10];
                                    i10 = this.K[i10];
                                    i18 = i9;
                                }
                                i10 = this.L[i10] & 255;
                                if (i5 >= 4096) {
                                    break;
                                }
                                i9 = i18 + 1;
                                this.M[i18] = (byte) i10;
                                this.K[i5] = (short) i15;
                                this.L[i5] = (byte) i10;
                                i15 = i5 + 1;
                                if ((i15 & i7) == 0 && i15 < 4096) {
                                    i6++;
                                    i7 += i15;
                                }
                                i17 = i9;
                                i9 = i11;
                                i11 = i16;
                                i16 = i7;
                                i7 = i10;
                                i10 = i14;
                                i14 = i6;
                                i6 = i17;
                            } else {
                                i10 = i9 + 1;
                                this.M[i9] = this.L[i16];
                                i9 = i10;
                                i15 = i16;
                                i10 = i16;
                            }
                        } else {
                            i6 = g + 1;
                            i7 = (1 << i6) - 1;
                            i5 = i3 + 2;
                            i15 = -1;
                        }
                    } else {
                        break;
                    }
                }
                if (i13 == 0) {
                    i13 = n();
                    if (i13 <= 0) {
                        break;
                    }
                    i = 0;
                }
                i11 += (this.D[i] & 255) << i14;
                i14 += 8;
                i++;
                i13--;
            } else {
                i16 = i7;
                i7 = i10;
                i10 = i14;
                i14 = i6;
                i6 = i9;
                i9 = i11;
                i11 = i15;
                i15 = i5;
            }
            i5 = i6 - 1;
            i6 = i8 + 1;
            this.N[i8] = this.M[i5];
            i12++;
            i8 = i6;
            i6 = i14;
            i14 = i10;
            i10 = i7;
            i7 = i16;
            i17 = i11;
            i11 = i9;
            i9 = i5;
            i5 = i15;
            i15 = i17;
        }
        for (i = i8; i < i2; i++) {
            this.N[i] = (byte) 0;
        }
    }

    private boolean l() {
        return this.d != 0;
    }

    private void m() {
        this.d = 0;
        this.P = 0;
        this.O = null;
        this.h = null;
        this.i = null;
    }

    private int n() {
        this.E = g();
        if (this.E <= 0) {
            return 0;
        }
        int i = 0;
        while (i < this.E) {
            try {
                int read = this.c.read(this.D, i, this.E - i);
                if (read == -1) {
                    break;
                }
                i += read;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (i >= this.E) {
            return i;
        }
        this.d = 1;
        this.Q.a(false, -1);
        return i;
    }

    private void o() {
        boolean z = false;
        while (!z && !l()) {
            switch (g()) {
                case 0:
                    break;
                case 33:
                    switch (g()) {
                        case 249:
                            p();
                            break;
                        case 255:
                            n();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.D[i]);
                            }
                            if (!str.equals("NETSCAPE2.0")) {
                                u();
                                break;
                            } else {
                                s();
                                break;
                            }
                        default:
                            u();
                            break;
                    }
                case 44:
                    q();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.d = 1;
                    this.Q.a(false, -1);
                    break;
            }
        }
    }

    private void p() {
        boolean z = true;
        g();
        int g = g();
        this.F = (g & 28) >> 2;
        if (this.F == 0) {
            this.F = 1;
        }
        if ((g & 1) == 0) {
            z = false;
        }
        this.H = z;
        this.I = h() * 10;
        this.J = g();
        g();
    }

    private void q() {
        this.r = h();
        this.s = h();
        this.t = h();
        this.u = h();
        int g = g();
        this.o = (g & 128) != 0;
        this.p = (g & 64) != 0;
        this.q = 2 << (g & 7);
        if (this.o) {
            this.i = c(this.q);
            this.j = this.i;
        } else {
            this.j = this.h;
            if (this.k == this.J) {
                this.l = 0;
            }
        }
        if (this.H) {
            int i = this.j[this.J];
            this.j[this.J] = 0;
        } else {
            boolean z = false;
        }
        if (this.j == null) {
            this.d = 1;
            this.Q.a(false, -1);
        }
        if (!l()) {
            k();
            u();
            if (!l()) {
                this.P++;
                this.z = Bitmap.createBitmap(this.a, this.b, Config.ARGB_4444);
                e();
                if (this.O == null) {
                    this.O = new c(this, this.z, this.I);
                    this.B = this.O;
                } else {
                    c cVar = this.O;
                    while (cVar.c != null) {
                        cVar = cVar.c;
                    }
                    cVar.c = new c(this, this.z, this.I);
                }
                if (this.H) {
                    this.j[this.J] = i;
                }
                t();
                this.Q.a(true, this.P);
            }
        }
    }

    private void r() {
        this.a = h();
        this.b = h();
        int g = g();
        this.e = (g & 128) != 0;
        this.f = 2 << (g & 7);
        this.k = g();
        this.n = g();
    }

    private void s() {
        do {
            n();
            if (this.D[0] == (byte) 1) {
                this.g = (this.D[1] & 255) | ((this.D[2] & 255) << 8);
            }
            if (this.E <= 0) {
                return;
            }
        } while (!l());
    }

    private void t() {
        this.G = this.F;
        this.v = this.r;
        this.w = this.s;
        this.x = this.t;
        this.y = this.u;
        this.A = this.z;
        this.m = this.l;
        this.F = 0;
        this.H = false;
        this.I = 0;
        this.i = null;
    }

    private void u() {
        do {
            n();
            if (this.E <= 0) {
                return;
            }
        } while (!l());
    }

    public Bitmap a(int i) {
        c b = b(i);
        return b == null ? null : b.a;
    }

    public void a() {
        try {
            c cVar = this.O;
            while (cVar != null) {
                cVar.a.recycle();
                cVar.a = null;
                this.O = this.O.c;
                cVar = this.O;
            }
            if (this.c != null) {
                this.c.close();
                this.c = null;
            }
            this.R = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int b() {
        return this.P;
    }

    public c b(int i) {
        int i2 = 0;
        for (c cVar = this.O; cVar != null; cVar = cVar.c) {
            if (i2 == i) {
                return cVar;
            }
            i2++;
        }
        return null;
    }

    public Bitmap c() {
        return a(0);
    }

    public c d() {
        if (this.C) {
            if (this.B == null || this.d != 0) {
                this.B = this.B.c;
                if (this.B == null) {
                    this.B = this.O;
                }
            } else if (this.B.c != null) {
                this.B = this.B.c;
            }
            return this.B;
        }
        this.C = true;
        return this.O;
    }

    public void run() {
        if (this.c != null) {
            j();
        } else if (this.R != null) {
            f();
        }
    }
}
