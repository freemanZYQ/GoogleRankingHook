package com.baidu.location.b;

import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.e.d;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class q {
    public static final String a = (d.a + "/llin.dat");
    private static q b = null;
    private static String c = "LogSDK";
    private static int d = 5;
    private static int e = IXAdIOUtils.BUFFER_SIZE;
    private static final String f = (d.a + "/llg.dat");
    private static final String g = (d.a + "/ller.dat");
    private SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private i i = null;
    private a j = null;
    private long k = 0;

    class a extends j {
        final /* synthetic */ q a;
        private String k;
        private boolean l;

        a(q qVar) {
            this.a = qVar;
            this.k = null;
            this.l = false;
            this.f = new ArrayList();
        }

        public void a() {
            this.f.clear();
            this.f.add(new BasicNameValuePair("qt", "stat"));
            this.f.add(new BasicNameValuePair("req", this.k));
            this.c = "http://loc.map.baidu.com/statloc";
        }

        public void a(String str) {
            this.k = str;
            if (this.k != null) {
                f();
                this.l = true;
            }
        }

        public void a(boolean z) {
            this.l = false;
            if (!z || this.e == null) {
                this.a.k = System.currentTimeMillis();
                return;
            }
            try {
                EntityUtils.toString(this.e, "utf-8");
            } catch (Exception e) {
            }
        }

        public boolean b() {
            return this.l;
        }
    }

    private q() {
        if (this.i == null) {
            this.i = new i();
        }
    }

    public static q a() {
        if (b == null) {
            synchronized (q.class) {
                if (b == null) {
                    b = new q();
                }
            }
        }
        return b;
    }

    public static synchronized void a(String str, String str2) {
        synchronized (q.class) {
            File file = new File(str);
            if (!file.exists()) {
                b(str);
            }
            try {
                int i;
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                int readInt4 = randomAccessFile.readInt();
                int readInt5 = randomAccessFile.readInt();
                if (readInt3 < readInt) {
                    randomAccessFile.seek((long) ((readInt2 * readInt3) + 128));
                    byte[] bytes = (str2 + '\u0000').getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes, 0, bytes.length);
                    i = readInt3 + 1;
                } else {
                    randomAccessFile.seek((long) ((readInt4 * readInt2) + 128));
                    byte[] bytes2 = (str2 + '\u0000').getBytes();
                    randomAccessFile.writeInt(bytes2.length);
                    randomAccessFile.write(bytes2, 0, bytes2.length);
                    readInt4++;
                    if (readInt4 > readInt3) {
                        readInt4 = 0;
                        i = readInt3;
                    } else {
                        i = readInt3;
                    }
                }
                randomAccessFile.seek(12);
                randomAccessFile.writeInt(i);
                randomAccessFile.writeInt(readInt4);
                randomAccessFile.writeInt(readInt5);
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
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
            byte[] bArr = new byte[e];
            int i = readInt2;
            readInt2 = d + 1;
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

    private static void b(String str) {
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
                randomAccessFile.writeInt(LocationClientOption.MIN_SCAN_SPAN);
                randomAccessFile.writeInt(1040);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    public void a(i iVar) {
        if (iVar != null) {
            a(f, Jni.H(iVar.b()));
        }
    }

    public void a(String str) {
        if (str != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String format = this.h.format(new Date());
                stringBuffer.append("&time=");
                stringBuffer.append(format);
                stringBuffer.append("&err=");
                stringBuffer.append(str);
                stringBuffer.append(b.a().a(false));
                stringBuffer.append(d.a().c());
                a(g, Jni.H(stringBuffer.toString()));
            } catch (Exception e) {
            }
        }
    }

    public i b() {
        return this.i;
    }

    public void c() {
        if (this.i != null) {
            a(f, Jni.H(this.i.b()));
            this.i.a();
        }
    }

    public void d() {
        if (this.j == null) {
            this.j = new a(this);
        }
        if (System.currentTimeMillis() - this.k >= 3600000 && !this.j.b()) {
            try {
                Object obj;
                Object obj2;
                List arrayList = new ArrayList();
                a(g, arrayList);
                if (arrayList.size() > 0) {
                    obj = null;
                    obj2 = 1;
                } else {
                    a(f, arrayList);
                    if (arrayList.size() == 0) {
                        a(a, arrayList);
                        int i = 1;
                        obj2 = null;
                    } else {
                        obj = null;
                        obj2 = null;
                    }
                }
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                if (arrayList.size() > 0) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        jSONArray.put((String) arrayList.get(i2));
                    }
                    if (obj2 != null) {
                        jSONObject.put("locpt", jSONArray);
                    } else if (obj != null) {
                        jSONObject.put("locup", jSONArray);
                    } else {
                        jSONObject.put("loctc", jSONArray);
                    }
                    this.j.a(jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }
}
