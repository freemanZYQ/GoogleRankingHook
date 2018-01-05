package com.baidu.location.e;

import android.location.Location;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.d;
import com.baidu.location.b.e;
import com.baidu.location.b.h;
import com.baidu.location.b.j;
import com.baidu.location.c.h.b;
import com.baidu.location.c.h.c;
import com.baidu.location.f;
import com.baidu.location.h.g;
import com.baidu.location.h.i;
import com.baidu.location.h.m;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

public class u {
    private static u A = null;
    private static ArrayList b = new ArrayList();
    private static ArrayList c = new ArrayList();
    private static ArrayList d = new ArrayList();
    private static String e = (d.a + "/yo.dat");
    private static final String f = (d.a + "/yoh.dat");
    private static final String g = (d.a + "/yom.dat");
    private static final String h = (d.a + "/yol.dat");
    private static final String i = (d.a + "/yor.dat");
    private static File j = null;
    private static int k = 8;
    private static int l = 8;
    private static int m = 16;
    private static int n = IXAdIOUtils.BUFFER_SIZE;
    private static double o = 0.0d;
    private static double p = 0.1d;
    private static double q = 30.0d;
    private static double r = 100.0d;
    private static int s = 0;
    private static int t = 64;
    private static int u = 128;
    private static Location v = null;
    private static Location w = null;
    private static Location x = null;
    private static g y = null;
    private int B;
    long a;
    private a z;

    class a extends j {
        boolean a;
        int k;
        int l;
        final /* synthetic */ u m;
        private ArrayList n;

        public a(u uVar) {
            this.m = uVar;
            this.a = false;
            this.k = 0;
            this.l = 0;
            this.n = null;
            this.f = new ArrayList();
        }

        public void a() {
            this.c = h.b();
            this.d = 2;
            if (this.n != null) {
                for (int i = 0; i < this.n.size(); i++) {
                    if (this.k == 1) {
                        this.f.add(new BasicNameValuePair("cldc[" + i + "]", (String) this.n.get(i)));
                    } else {
                        this.f.add(new BasicNameValuePair("cltr[" + i + "]", (String) this.n.get(i)));
                    }
                }
                this.f.add(new BasicNameValuePair("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())})));
            }
        }

        public void a(boolean z) {
            if (!(!z || this.e == null || this.n == null)) {
                this.n.clear();
            }
            if (this.f != null) {
                this.f.clear();
            }
            this.a = false;
        }

        public void b() {
            if (!this.a) {
                if (j <= 4 || this.l >= j) {
                    this.l = 0;
                    this.a = true;
                    this.k = 0;
                    if (this.n == null || this.n.size() < 1) {
                        if (this.n == null) {
                            this.n = new ArrayList();
                        }
                        this.k = 0;
                        int i = 0;
                        do {
                            String b = this.k < 2 ? u.b() : null;
                            if (b != null || this.k == 1) {
                                this.k = 1;
                            } else {
                                this.k = 2;
                                try {
                                    b = q.b();
                                } catch (Exception e) {
                                    b = null;
                                }
                            }
                            if (b == null) {
                                break;
                            }
                            this.n.add(b);
                            i += b.length();
                        } while (i < e.h);
                    }
                    if (this.n == null || this.n.size() < 1) {
                        this.n = null;
                        this.a = false;
                        return;
                    }
                    f();
                    return;
                }
                this.l++;
            }
        }
    }

    private u() {
        this.z = null;
        this.B = 0;
        this.a = 0;
        this.z = new a(this);
        this.B = 0;
    }

    private static int a(List list, int i) {
        if (list == null || i > 256 || i < 0) {
            return -1;
        }
        try {
            if (j == null) {
                j = new File(e);
                if (!j.exists()) {
                    j = null;
                    return -2;
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(j, "rw");
            if (randomAccessFile.length() < 1) {
                randomAccessFile.close();
                return -3;
            }
            randomAccessFile.seek((long) i);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            int readInt4 = randomAccessFile.readInt();
            long readLong = randomAccessFile.readLong();
            if (!a(readInt, readInt2, readInt3, readInt4, readLong) || readInt2 < 1) {
                randomAccessFile.close();
                return -4;
            }
            byte[] bArr = new byte[n];
            int i2 = readInt2;
            readInt2 = k;
            while (readInt2 > 0 && i2 > 0) {
                randomAccessFile.seek(((long) ((((readInt + i2) - 1) % readInt3) * readInt4)) + readLong);
                int readInt5 = randomAccessFile.readInt();
                if (readInt5 > 0 && readInt5 < readInt4) {
                    randomAccessFile.read(bArr, 0, readInt5);
                    if (bArr[readInt5 - 1] == (byte) 0) {
                        list.add(new String(bArr, 0, readInt5 - 1));
                    }
                }
                readInt2--;
                i2--;
            }
            randomAccessFile.seek((long) i);
            randomAccessFile.writeInt(readInt);
            randomAccessFile.writeInt(i2);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.writeInt(readInt4);
            randomAccessFile.writeLong(readLong);
            randomAccessFile.close();
            return k - readInt2;
        } catch (Exception e) {
            e.printStackTrace();
            return -5;
        }
    }

    public static u a() {
        if (A == null) {
            A = new u();
        }
        return A;
    }

    public static String a(int i) {
        String str;
        List list;
        String str2 = null;
        if (i == 1) {
            str = f;
            list = b;
        } else if (i == 2) {
            str = g;
            list = c;
        } else if (i == 3) {
            str = h;
            list = d;
        } else {
            if (i == 4) {
                str = i;
                list = d;
            }
            return str2;
        }
        if (list != null) {
            if (list.size() < 1) {
                a(str, list);
            }
            synchronized (u.class) {
                int size = list.size();
                if (size > 0) {
                    str2 = (String) list.get(size - 1);
                    list.remove(size - 1);
                }
            }
        }
        return str2;
    }

    public static void a(int i, boolean z) {
        String str;
        Object obj;
        String str2;
        if (i == 1) {
            str2 = f;
            if (!z) {
                str = str2;
                List list = b;
            } else {
                return;
            }
        } else if (i == 2) {
            str2 = g;
            if (z) {
                str = str2;
                obj = b;
            } else {
                str = str2;
                obj = c;
            }
        } else if (i == 3) {
            str2 = h;
            if (z) {
                str = str2;
                obj = c;
            } else {
                str = str2;
                obj = d;
            }
        } else if (i == 4) {
            str2 = i;
            if (z) {
                str = str2;
                obj = d;
            } else {
                return;
            }
        } else {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            a(str);
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            int readInt4 = randomAccessFile.readInt();
            int readInt5 = randomAccessFile.readInt();
            int size = list.size();
            int i2 = readInt5;
            while (size > l) {
                readInt5 = z ? i2 + 1 : i2;
                byte[] bytes;
                if (readInt3 >= readInt) {
                    if (!z) {
                        obj = 1;
                        i2 = readInt5;
                        break;
                    }
                    randomAccessFile.seek((long) ((readInt4 * readInt2) + 128));
                    bytes = (((String) list.get(0)) + '\u0000').getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes, 0, bytes.length);
                    list.remove(0);
                    i2 = readInt4 + 1;
                    if (i2 > readInt3) {
                        i2 = 0;
                    }
                    readInt4 = readInt3;
                } else {
                    randomAccessFile.seek((long) ((readInt2 * readInt3) + 128));
                    bytes = (((String) list.get(0)) + '\u0000').getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes, 0, bytes.length);
                    list.remove(0);
                    int i3 = readInt4;
                    readInt4 = readInt3 + 1;
                    i2 = i3;
                }
                size--;
                readInt3 = readInt4;
                readInt4 = i2;
                i2 = readInt5;
            }
            obj = null;
            randomAccessFile.seek(12);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.writeInt(readInt4);
            randomAccessFile.writeInt(i2);
            randomAccessFile.close();
            if (obj != null && i < 4) {
                a(i + 1, true);
            }
        } catch (Exception e) {
        }
    }

    public static void a(i iVar, g gVar, Location location, String str) {
        if (!j.a().a) {
            return;
        }
        if (h.s != 3 || a(location, gVar) || a(location, false)) {
            BDLocation a;
            String str2;
            if (com.baidu.location.c.d.a().a(true).getLocType() == 66) {
                str = str + String.format(Locale.CHINA, "&ofrt=%f|%f|%d", new Object[]{Double.valueOf(r0.getLongitude()), Double.valueOf(r0.getLatitude()), Integer.valueOf((int) r0.getRadius())});
            }
            if (h.a(f.getServiceContext())) {
                a = com.baidu.location.c.h.a().a(iVar, gVar, null, c.IS_MIX_MODE, b.NO_NEED_TO_LOG);
            } else {
                a = com.baidu.location.c.h.a().a(iVar, gVar, null, c.IS_NOT_MIX_MODE, b.NO_NEED_TO_LOG);
            }
            if (a == null || a.getLocType() == 67) {
                str2 = str + String.format(Locale.CHINA, "&ofl=%s|0", new Object[]{"1"});
            } else {
                int i = 0;
                if (a.getNetworkLocationType().equals("cl")) {
                    i = 1;
                } else if (a.getNetworkLocationType().equals("wf")) {
                    i = 2;
                }
                str2 = str + String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", new Object[]{"1", Integer.valueOf(i), Double.valueOf(a.getLongitude()), Double.valueOf(a.getLatitude()), Integer.valueOf((int) a.getRadius())});
            }
            if (iVar != null && iVar.b()) {
                if (!a(location, gVar)) {
                    gVar = null;
                }
                str2 = h.a(iVar, gVar, location, str2, 1);
                if (str2 != null) {
                    c(Jni.H(str2));
                    w = location;
                    v = location;
                    if (gVar != null) {
                        y = gVar;
                    }
                }
            } else if (gVar != null && gVar.h() && a(location, gVar)) {
                if (!a(location) && !com.baidu.location.h.c.a().d()) {
                    str2 = "&cfr=1" + str2;
                } else if (!a(location) && com.baidu.location.h.c.a().d()) {
                    str2 = "&cfr=3" + str2;
                } else if (com.baidu.location.h.c.a().d()) {
                    str2 = "&cfr=2" + str2;
                }
                str2 = h.a(iVar, gVar, location, str2, 2);
                if (str2 != null) {
                    d(Jni.H(str2));
                    x = location;
                    v = location;
                    if (gVar != null) {
                        y = gVar;
                    }
                }
            } else {
                if (!a(location) && !com.baidu.location.h.c.a().d()) {
                    str2 = "&cfr=1" + str2;
                } else if (!a(location) && com.baidu.location.h.c.a().d()) {
                    str2 = "&cfr=3" + str2;
                } else if (com.baidu.location.h.c.a().d()) {
                    str2 = "&cfr=2" + str2;
                }
                if (!a(location, gVar)) {
                    gVar = null;
                }
                if (iVar != null || gVar != null) {
                    str2 = h.a(iVar, gVar, location, str2, 3);
                    if (str2 != null) {
                        e(Jni.H(str2));
                        v = location;
                        if (gVar != null) {
                            y = gVar;
                        }
                    }
                }
            }
        }
    }

    public static void a(String str) {
        try {
            File file = new File(str);
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
                randomAccessFile.writeInt(32);
                randomAccessFile.writeInt(2048);
                randomAccessFile.writeInt(1040);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    private static boolean a(int i, int i2, int i3, int i4, long j) {
        return i >= 0 && i < i3 && i2 >= 0 && i2 <= i3 && i3 >= 0 && i3 <= IXAdIOUtils.BUFFER_SIZE && i4 >= 128 && i4 <= IXAdIOUtils.BUFFER_SIZE;
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        if (w == null || v == null) {
            w = location;
            return true;
        }
        double distanceTo = (double) location.distanceTo(w);
        return ((double) location.distanceTo(v)) > ((distanceTo * ((double) h.Q)) + ((((double) h.P) * distanceTo) * distanceTo)) + ((double) h.R);
    }

    private static boolean a(Location location, g gVar) {
        if (location == null || gVar == null || gVar.a == null || gVar.a.isEmpty() || gVar.b(y)) {
            return false;
        }
        if (x != null) {
            return true;
        }
        x = location;
        return true;
    }

    public static boolean a(Location location, boolean z) {
        return com.baidu.location.h.a.a(v, location, z);
    }

    public static boolean a(String str, List list) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(8);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            byte[] bArr = new byte[n];
            int i = readInt2;
            readInt2 = l + 1;
            boolean z = false;
            while (readInt2 > 0 && i > 0) {
                if (i < readInt3) {
                    readInt3 = 0;
                }
                try {
                    randomAccessFile.seek((long) (((i - 1) * readInt) + 128));
                    int readInt4 = randomAccessFile.readInt();
                    if (readInt4 > 0 && readInt4 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt4);
                        if (bArr[readInt4 - 1] == (byte) 0) {
                            list.add(0, new String(bArr, 0, readInt4 - 1));
                            z = true;
                        }
                    }
                    readInt2--;
                    i--;
                } catch (Exception e) {
                    return z;
                }
            }
            randomAccessFile.seek(12);
            randomAccessFile.writeInt(i);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.close();
            return z;
        } catch (Exception e2) {
            return false;
        }
    }

    public static String b() {
        return d();
    }

    public static synchronized void b(String str) {
        synchronized (u.class) {
            List list;
            int i = h.n;
            if (i == 1) {
                list = b;
            } else if (i == 2) {
                list = c;
            } else {
                if (i == 3) {
                    list = d;
                }
            }
            if (list != null) {
                if (list.size() <= m) {
                    list.add(str);
                }
                if (list.size() >= m) {
                    a(i, false);
                }
                while (list.size() > m) {
                    list.remove(0);
                }
            }
        }
    }

    private static void c(String str) {
        b(str);
    }

    public static String d() {
        String str = null;
        for (int i = 1; i < 5; i++) {
            str = a(i);
            if (str != null) {
                return str;
            }
        }
        a(d, t);
        if (d.size() > 0) {
            str = (String) d.get(0);
            d.remove(0);
        }
        if (str != null) {
            return str;
        }
        a(d, s);
        if (d.size() > 0) {
            str = (String) d.get(0);
            d.remove(0);
        }
        if (str != null) {
            return str;
        }
        a(d, u);
        if (d.size() <= 0) {
            return str;
        }
        str = (String) d.get(0);
        d.remove(0);
        return str;
    }

    private static void d(String str) {
        b(str);
    }

    public static void e() {
        l = 0;
        a(1, false);
        a(2, false);
        a(3, false);
        l = 8;
    }

    private static void e(String str) {
        b(str);
    }

    public static String f() {
        RandomAccessFile randomAccessFile;
        int readInt;
        File file = new File(g);
        if (file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20);
                readInt = randomAccessFile.readInt();
                if (readInt > 128) {
                    String str = "&p1=" + readInt;
                    randomAccessFile.seek(20);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.close();
                    return str;
                }
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
        file = new File(h);
        if (file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20);
                readInt = randomAccessFile.readInt();
                if (readInt > 256) {
                    str = "&p2=" + readInt;
                    randomAccessFile.seek(20);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.close();
                    return str;
                }
                randomAccessFile.close();
            } catch (Exception e2) {
            }
        }
        file = new File(i);
        if (!file.exists()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(20);
            readInt = randomAccessFile.readInt();
            if (readInt > 512) {
                str = "&p3=" + readInt;
                randomAccessFile.seek(20);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
                return str;
            }
            randomAccessFile.close();
            return null;
        } catch (Exception e3) {
            return null;
        }
    }

    public void c() {
        if (m.a().g()) {
            this.z.b();
        }
    }
}
