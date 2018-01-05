package com.baidu.location.e;

import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.b.d;
import com.baidu.location.b.h;
import com.baidu.location.b.p;
import com.baidu.location.f;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class j {
    private static j i = null;
    private static final String k = (d.a + "/conlts.dat");
    private static int l = -1;
    private static int m = -1;
    private static int n = 0;
    public boolean a = true;
    public boolean b = true;
    public boolean c = false;
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;
    public boolean g = true;
    public boolean h = false;
    private a j = null;

    class a extends com.baidu.location.b.j {
        String a;
        boolean k;
        boolean l;
        final /* synthetic */ j m;

        public a(j jVar) {
            this.m = jVar;
            this.a = null;
            this.k = false;
            this.l = false;
            this.f = new ArrayList();
        }

        public void a() {
            this.c = h.b();
            this.d = 2;
            String H = Jni.H(this.a);
            this.a = null;
            if (this.k) {
                this.f.add(new BasicNameValuePair("qt", "grid"));
            } else {
                this.f.add(new BasicNameValuePair("qt", "conf"));
            }
            this.f.add(new BasicNameValuePair("req", H));
        }

        public void a(String str, boolean z) {
            if (!this.l) {
                this.l = true;
                this.a = str;
                this.k = z;
                if (z) {
                    e();
                } else {
                    f();
                }
            }
        }

        public void a(boolean z) {
            if (!z || this.e == null) {
                this.m.b(null);
            } else if (this.k) {
                this.m.a(this.e);
            } else {
                this.m.b(this.e);
            }
            if (this.f != null) {
                this.f.clear();
            }
            this.l = false;
        }
    }

    private j() {
    }

    public static j a() {
        if (i == null) {
            i = new j();
        }
        return i;
    }

    private void a(int i) {
        boolean z = true;
        this.a = (i & 1) == 1;
        this.b = (i & 2) == 2;
        this.c = (i & 4) == 4;
        this.d = (i & 8) == 8;
        this.f = (i & 65536) == 65536;
        if ((i & 131072) != 131072) {
            z = false;
        }
        this.g = z;
        if ((i & 16) == 16) {
            this.e = false;
        }
    }

    private void a(HttpEntity httpEntity) {
        int i = 0;
        try {
            byte[] toByteArray = EntityUtils.toByteArray(httpEntity);
            if (toByteArray != null) {
                if (toByteArray.length < 640) {
                    h.u = false;
                    h.r = h.p + 0.025d;
                    h.q = h.o - 0.025d;
                    i = 1;
                } else {
                    h.u = true;
                    h.q = Double.longBitsToDouble(((((((((((long) toByteArray[7]) & 255) << 56) | ((((long) toByteArray[6]) & 255) << 48)) | ((((long) toByteArray[5]) & 255) << 40)) | ((((long) toByteArray[4]) & 255) << 32)) | ((((long) toByteArray[3]) & 255) << 24)) | ((((long) toByteArray[2]) & 255) << 16)) | ((((long) toByteArray[1]) & 255) << 8)) | (((long) toByteArray[0]) & 255));
                    h.r = Double.longBitsToDouble(((((((((((long) toByteArray[15]) & 255) << 56) | ((((long) toByteArray[14]) & 255) << 48)) | ((((long) toByteArray[13]) & 255) << 40)) | ((((long) toByteArray[12]) & 255) << 32)) | ((((long) toByteArray[11]) & 255) << 24)) | ((((long) toByteArray[10]) & 255) << 16)) | ((((long) toByteArray[9]) & 255) << 8)) | (((long) toByteArray[8]) & 255));
                    h.t = new byte[625];
                    while (i < 625) {
                        h.t[i] = toByteArray[i + 16];
                        i++;
                    }
                    i = 1;
                }
            }
            if (i != 0) {
                f();
            }
        } catch (Exception e) {
        }
    }

    private void b(int i) {
        File file = new File(k);
        if (!file.exists()) {
            h();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.seek((long) ((readInt * n) + 128));
            byte[] bytes = (b.g + '\u0000').getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(i);
            if (readInt2 == n) {
                randomAccessFile.seek(8);
                randomAccessFile.writeInt(readInt2 + 1);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private void b(HttpEntity httpEntity) {
        String str = null;
        m = -1;
        if (httpEntity != null) {
            try {
                str = EntityUtils.toString(httpEntity, "utf-8");
                if (b(str)) {
                    e();
                }
            } catch (Exception e) {
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ctr")) {
                    m = Integer.parseInt(jSONObject.getString("ctr"));
                }
            } catch (Exception e2) {
            }
        }
        try {
            int i;
            i();
            if (m != -1) {
                i = m;
                b(m);
            } else {
                i = l != -1 ? l : -1;
            }
            if (i != -1) {
                a(i);
            }
            if (f.isServing) {
                try {
                    if (this.c && !h.m) {
                    }
                } catch (Exception e3) {
                }
            }
        } catch (Exception e4) {
        }
    }

    private boolean b(String str) {
        boolean z = true;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getString("ver"));
                if (parseInt > h.v) {
                    String[] split;
                    h.v = parseInt;
                    if (jSONObject.has("gps")) {
                        split = jSONObject.getString("gps").split("\\|");
                        if (split.length > 10) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                h.w = Float.parseFloat(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                h.x = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                h.y = Float.parseFloat(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                h.z = Float.parseFloat(split[3]);
                            }
                            if (!(split[4] == null || split[4].equals(""))) {
                                h.A = Integer.parseInt(split[4]);
                            }
                            if (!(split[5] == null || split[5].equals(""))) {
                                h.B = Integer.parseInt(split[5]);
                            }
                            if (!(split[6] == null || split[6].equals(""))) {
                                h.C = Integer.parseInt(split[6]);
                            }
                            if (!(split[7] == null || split[7].equals(""))) {
                                h.D = Integer.parseInt(split[7]);
                            }
                            if (!(split[8] == null || split[8].equals(""))) {
                                h.E = Integer.parseInt(split[8]);
                            }
                            if (!(split[9] == null || split[9].equals(""))) {
                                h.F = Integer.parseInt(split[9]);
                            }
                            if (!(split[10] == null || split[10].equals(""))) {
                                h.G = Integer.parseInt(split[10]);
                            }
                        }
                    }
                    if (jSONObject.has("up")) {
                        split = jSONObject.getString("up").split("\\|");
                        if (split.length > 3) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                h.H = Float.parseFloat(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                h.I = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                h.J = Float.parseFloat(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                h.K = Float.parseFloat(split[3]);
                            }
                        }
                    }
                    if (jSONObject.has("wf")) {
                        split = jSONObject.getString("wf").split("\\|");
                        if (split.length > 3) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                h.L = Integer.parseInt(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                h.M = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                h.N = Integer.parseInt(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                h.O = Float.parseFloat(split[3]);
                            }
                        }
                    }
                    if (jSONObject.has("ab")) {
                        split = jSONObject.getString("ab").split("\\|");
                        if (split.length > 3) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                h.P = Float.parseFloat(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                h.Q = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                h.R = Integer.parseInt(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                h.S = Integer.parseInt(split[3]);
                            }
                        }
                    }
                    if (jSONObject.has("zxd")) {
                        split = jSONObject.getString("zxd").split("\\|");
                        if (split.length > 4) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                h.ak = Float.parseFloat(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                h.al = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                h.am = Integer.parseInt(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                h.an = Integer.parseInt(split[3]);
                            }
                            if (!(split[4] == null || split[4].equals(""))) {
                                h.ao = Integer.parseInt(split[4]);
                            }
                        }
                    }
                    if (jSONObject.has("gpc")) {
                        split = jSONObject.getString("gpc").split("\\|");
                        if (split.length > 5) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                if (Integer.parseInt(split[0]) > 0) {
                                    h.U = true;
                                } else {
                                    h.U = false;
                                }
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                if (Integer.parseInt(split[1]) > 0) {
                                    h.V = true;
                                } else {
                                    h.V = false;
                                }
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                h.W = Integer.parseInt(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                h.Y = Integer.parseInt(split[3]);
                            }
                            if (!(split[4] == null || split[4].equals(""))) {
                                int parseInt2 = Integer.parseInt(split[4]);
                                if (parseInt2 > 0) {
                                    h.ad = (long) parseInt2;
                                    h.Z = (h.ad * 1000) * 60;
                                    h.ae = h.Z >> 2;
                                } else {
                                    h.m = false;
                                }
                            }
                            if (!(split[5] == null || split[5].equals(""))) {
                                h.ag = Integer.parseInt(split[5]);
                            }
                        }
                    }
                    if (jSONObject.has("shak")) {
                        split = jSONObject.getString("shak").split("\\|");
                        if (split.length > 2) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                h.ah = Integer.parseInt(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                h.ai = Integer.parseInt(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                h.aj = Float.parseFloat(split[2]);
                            }
                        }
                    }
                    if (jSONObject.has("dmx")) {
                        h.af = jSONObject.getInt("dmx");
                    }
                    return z;
                }
            } catch (Exception e) {
                return false;
            }
        }
        z = false;
        return z;
    }

    private void d() {
        String str = "&ver=" + h.v + "&usr=" + b.a().b() + "&app=" + b.g + "&prod=" + b.h;
        if (this.j == null) {
            this.j = new a(this);
        }
        this.j.a(str, false);
    }

    private void e() {
        String str = d.a + "/config.dat";
        int i = h.U ? 1 : 0;
        int i2 = h.V ? 1 : 0;
        byte[] bytes = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", new Object[]{Integer.valueOf(h.v), Float.valueOf(h.w), Float.valueOf(h.x), Float.valueOf(h.y), Float.valueOf(h.z), Integer.valueOf(h.A), Integer.valueOf(h.B), Integer.valueOf(h.C), Integer.valueOf(h.D), Integer.valueOf(h.E), Integer.valueOf(h.F), Integer.valueOf(h.G), Float.valueOf(h.H), Float.valueOf(h.I), Float.valueOf(h.J), Float.valueOf(h.K), Integer.valueOf(h.L), Float.valueOf(h.M), Integer.valueOf(h.N), Float.valueOf(h.O), Float.valueOf(h.P), Float.valueOf(h.Q), Integer.valueOf(h.R), Integer.valueOf(h.S), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(h.W), Integer.valueOf(h.Y), Long.valueOf(h.ad), Integer.valueOf(h.ag), Float.valueOf(h.ak), Float.valueOf(h.al), Integer.valueOf(h.am), Integer.valueOf(h.an), Integer.valueOf(h.ao), Integer.valueOf(h.ah), Integer.valueOf(h.ai), Float.valueOf(h.aj), Integer.valueOf(h.af)}).getBytes();
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(d.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.writeBoolean(true);
            randomAccessFile.seek(2);
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes);
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private void f() {
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(d.a + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(d.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(1);
            randomAccessFile.writeBoolean(true);
            randomAccessFile.seek(1024);
            randomAccessFile.writeDouble(h.q);
            randomAccessFile.writeDouble(h.r);
            randomAccessFile.writeBoolean(h.u);
            if (h.u && h.t != null) {
                randomAccessFile.write(h.t);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private void g() {
        try {
            File file = new File(d.a + "/config.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    b(new String(bArr));
                }
                randomAccessFile.seek(1);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(1024);
                    h.q = randomAccessFile.readDouble();
                    h.r = randomAccessFile.readDouble();
                    h.u = randomAccessFile.readBoolean();
                    if (h.u) {
                        h.t = new byte[625];
                        randomAccessFile.read(h.t, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        b(null);
    }

    private void h() {
        try {
            File file = new File(k);
            if (!file.exists()) {
                File file2 = new File(d.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    file = null;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(128);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    private void i() {
        int i = 0;
        try {
            File file = new File(k);
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4);
                int readInt = randomAccessFile.readInt();
                if (readInt > 3000) {
                    randomAccessFile.close();
                    n = 0;
                    h();
                    return;
                }
                int readInt2 = randomAccessFile.readInt();
                randomAccessFile.seek(128);
                byte[] bArr = new byte[readInt];
                while (i < readInt2) {
                    randomAccessFile.seek((long) ((readInt * i) + 128));
                    int readInt3 = randomAccessFile.readInt();
                    if (readInt3 > 0 && readInt3 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt3);
                        if (bArr[readInt3 - 1] == (byte) 0) {
                            String str = new String(bArr, 0, readInt3 - 1);
                            b.a();
                            if (str.equals(b.g)) {
                                l = randomAccessFile.readInt();
                                n = i;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (i == readInt2) {
                    n = readInt2;
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    public void a(String str) {
        if (this.j == null) {
            this.j = new a(this);
        }
        this.j.a(str, true);
    }

    public void b() {
    }

    public void c() {
        if (System.currentTimeMillis() - p.a().c() > 86400000) {
            p.a().b(System.currentTimeMillis());
            d();
        }
        g();
    }
}
