package com.baidu.location.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.b.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

final class a {
    private final h a;
    private int b;
    private double c;
    private double d;
    private Long e;
    private final b f = new b(this, this, true);
    private final b g = new b(this, this, false);
    private final SQLiteDatabase h;
    private final SQLiteDatabase i;
    private StringBuffer j = null;
    private StringBuffer k = null;
    private HashSet l = new HashSet();
    private ConcurrentHashMap m = new ConcurrentHashMap();
    private ConcurrentHashMap n = new ConcurrentHashMap();
    private StringBuffer o = new StringBuffer();
    private boolean p = false;

    class a extends Thread {
        final /* synthetic */ a a;
        private String b;
        private Long c;
        private BDLocation d;
        private BDLocation e;
        private BDLocation f;
        private String g;
        private LinkedHashMap h;

        private a(a aVar, String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap linkedHashMap) {
            this.a = aVar;
            this.b = str;
            this.c = l;
            this.d = bDLocation;
            this.e = bDLocation2;
            this.f = bDLocation3;
            this.g = str2;
            this.h = linkedHashMap;
        }

        public void run() {
            this.a.a(this.b, this.c, this.d);
            this.a.j = null;
            this.a.k = null;
            this.a.a(this.h);
            this.a.a(this.f, this.d, this.e, this.b, this.c);
            if (this.g != null) {
                this.a.a.j().a(this.g);
            }
            this.h = null;
            this.b = null;
            this.g = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
        }
    }

    final class b extends j {
        final /* synthetic */ a a;
        private String k;
        private final String l;
        private String m;
        private a n;
        private boolean o = false;
        private int p = 0;
        private long q = -1;
        private long r = -1;
        private long s = -1;
        private long t = -1;

        b(a aVar, a aVar2, boolean z) {
            this.a = aVar;
            this.n = aVar2;
            if (z) {
                this.l = "load";
            } else {
                this.l = "update";
            }
            this.f = new ArrayList();
            this.k = h.a;
        }

        private void a(String str, String str2, String str3) {
            this.m = str3;
            this.k = String.format("http://%s/%s", new Object[]{str, str2});
            f();
        }

        private void c() {
            this.p++;
            this.q = System.currentTimeMillis();
        }

        private boolean j() {
            if (this.p < 2) {
                return true;
            }
            if (this.q + 43200000 >= System.currentTimeMillis()) {
                return false;
            }
            this.p = 0;
            this.q = -1;
            return true;
        }

        private void k() {
            this.m = null;
            if (!p()) {
                this.m = m();
            } else if (this.r == -1 || this.r + 86400000 <= System.currentTimeMillis()) {
                this.m = l();
            }
            if (this.m == null && (this.s == -1 || this.s + 86400000 <= System.currentTimeMillis())) {
                if (this.a.a.k().a()) {
                    this.m = n();
                } else {
                    this.m = o();
                }
            }
            if (this.m != null) {
                f();
            }
        }

        private String l() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                jSONObject.put("type", "0");
                jSONObject.put("cuid", com.baidu.location.b.b.a().b);
                jSONObject.put("ver", "1");
                jSONObject.put("prod", com.baidu.location.b.b.h + ":" + com.baidu.location.b.b.g);
            } catch (Exception e) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.G(jSONObject.toString()) : null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String m() {
            /*
            r11 = this;
            r4 = 0;
            r1 = 0;
            r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0185, all -> 0x016a }
            r6.<init>();	 Catch:{ Exception -> 0x0185, all -> 0x016a }
            r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0185, all -> 0x016a }
            r0.<init>();	 Catch:{ Exception -> 0x0185, all -> 0x016a }
            r2 = r11.a;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r2 = r2.i;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r3 = "SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r7 = 0;
            r8 = "CL";
            r5[r7] = r8;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r7 = 1;
            r8 = 5;
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r5[r7] = r8;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r7 = 2;
            r8 = 50;
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r5[r7] = r8;	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r3 = java.lang.String.format(r3, r5);	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            r5 = 0;
            r2 = r2.rawQuery(r3, r5);	 Catch:{ Exception -> 0x018b, all -> 0x016a }
            if (r2 == 0) goto L_0x0196;
        L_0x003a:
            r3 = r2.moveToFirst();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            if (r3 == 0) goto L_0x0196;
        L_0x0040:
            r3 = r2.getCount();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r5 = new org.json.JSONArray;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r5.<init>();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
        L_0x0049:
            r7 = r2.isAfterLast();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            if (r7 != 0) goto L_0x00ac;
        L_0x004f:
            r7 = 1;
            r7 = r2.getString(r7);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r5.put(r7);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r2.moveToNext();	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            goto L_0x0049;
        L_0x005b:
            r3 = move-exception;
            r3 = r1;
        L_0x005d:
            if (r3 == 0) goto L_0x0062;
        L_0x005f:
            r3.close();	 Catch:{ Exception -> 0x0179 }
        L_0x0062:
            if (r2 == 0) goto L_0x0193;
        L_0x0064:
            r2.close();	 Catch:{ Exception -> 0x0166 }
            r2 = r0;
        L_0x0068:
            if (r2 == 0) goto L_0x0190;
        L_0x006a:
            r0 = "model";
            r0 = r2.has(r0);
            if (r0 != 0) goto L_0x0190;
        L_0x0073:
            r4 = r11.t;
            r6 = -1;
            r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r0 == 0) goto L_0x0089;
        L_0x007b:
            r4 = r11.t;
            r6 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
            r4 = r4 + r6;
            r6 = java.lang.System.currentTimeMillis();
            r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r0 >= 0) goto L_0x0190;
        L_0x0089:
            r0 = r2.toString();
            r1 = com.baidu.location.Jni.G(r0);
            r4 = java.lang.System.currentTimeMillis();
            r11.t = r4;
            r0 = r1;
        L_0x0098:
            if (r2 == 0) goto L_0x00ab;
        L_0x009a:
            r1 = "model";
            r1 = r2.has(r1);
            if (r1 == 0) goto L_0x00ab;
        L_0x00a3:
            r0 = r2.toString();
            r0 = com.baidu.location.Jni.G(r0);
        L_0x00ab:
            return r0;
        L_0x00ac:
            r7 = "cell";
            r6.put(r7, r5);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r5 = r3;
        L_0x00b3:
            r3 = r11.a;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r3 = r3.i;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r7 = "SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;";
            r8 = 3;
            r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r9 = 0;
            r10 = "AP";
            r8[r9] = r10;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r9 = 1;
            r10 = 5;
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r9 = 2;
            r10 = 50;
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r7 = java.lang.String.format(r7, r8);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            r8 = 0;
            r3 = r3.rawQuery(r7, r8);	 Catch:{ Exception -> 0x005b, all -> 0x0180 }
            if (r3 == 0) goto L_0x010b;
        L_0x00e1:
            r7 = r3.moveToFirst();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            if (r7 == 0) goto L_0x010b;
        L_0x00e7:
            r4 = r3.getCount();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7.<init>();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
        L_0x00f0:
            r8 = r3.isAfterLast();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            if (r8 != 0) goto L_0x0105;
        L_0x00f6:
            r8 = 1;
            r8 = r3.getString(r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7.put(r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r3.moveToNext();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            goto L_0x00f0;
        L_0x0102:
            r4 = move-exception;
            goto L_0x005d;
        L_0x0105:
            r8 = "ap";
            r6.put(r8, r7);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
        L_0x010b:
            r7 = "type";
            r8 = "1";
            r0.put(r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7 = "cuid";
            r8 = com.baidu.location.b.b.a();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8 = r8.b;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r0.put(r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7 = "ver";
            r8 = "1";
            r0.put(r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r7 = "prod";
            r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8.<init>();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r9 = com.baidu.location.b.b.h;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8 = r8.append(r9);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r9 = ":";
            r8 = r8.append(r9);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r9 = com.baidu.location.b.b.g;	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8 = r8.append(r9);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r8 = r8.toString();	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            r0.put(r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
            if (r5 != 0) goto L_0x014f;
        L_0x014d:
            if (r4 == 0) goto L_0x0155;
        L_0x014f:
            r4 = "model";
            r0.put(r4, r6);	 Catch:{ Exception -> 0x0102, all -> 0x0182 }
        L_0x0155:
            if (r3 == 0) goto L_0x015a;
        L_0x0157:
            r3.close();	 Catch:{ Exception -> 0x0177 }
        L_0x015a:
            if (r2 == 0) goto L_0x0193;
        L_0x015c:
            r2.close();	 Catch:{ Exception -> 0x0162 }
            r2 = r0;
            goto L_0x0068;
        L_0x0162:
            r2 = move-exception;
            r2 = r0;
            goto L_0x0068;
        L_0x0166:
            r2 = move-exception;
            r2 = r0;
            goto L_0x0068;
        L_0x016a:
            r0 = move-exception;
            r2 = r1;
        L_0x016c:
            if (r1 == 0) goto L_0x0171;
        L_0x016e:
            r1.close();	 Catch:{ Exception -> 0x017c }
        L_0x0171:
            if (r2 == 0) goto L_0x0176;
        L_0x0173:
            r2.close();	 Catch:{ Exception -> 0x017e }
        L_0x0176:
            throw r0;
        L_0x0177:
            r3 = move-exception;
            goto L_0x015a;
        L_0x0179:
            r3 = move-exception;
            goto L_0x0062;
        L_0x017c:
            r1 = move-exception;
            goto L_0x0171;
        L_0x017e:
            r1 = move-exception;
            goto L_0x0176;
        L_0x0180:
            r0 = move-exception;
            goto L_0x016c;
        L_0x0182:
            r0 = move-exception;
            r1 = r3;
            goto L_0x016c;
        L_0x0185:
            r0 = move-exception;
            r0 = r1;
            r2 = r1;
            r3 = r1;
            goto L_0x005d;
        L_0x018b:
            r2 = move-exception;
            r2 = r1;
            r3 = r1;
            goto L_0x005d;
        L_0x0190:
            r0 = r1;
            goto L_0x0098;
        L_0x0193:
            r2 = r0;
            goto L_0x0068;
        L_0x0196:
            r5 = r4;
            goto L_0x00b3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.b.m():java.lang.String");
        }

        private String n() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "2");
                    jSONObject.put("ver", "1");
                    jSONObject.put("cuid", com.baidu.location.b.b.a().b);
                    jSONObject.put("prod", com.baidu.location.b.b.h + ":" + com.baidu.location.b.b.g);
                    this.s = System.currentTimeMillis();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.G(jSONObject.toString()) : null;
        }

        private String o() {
            JSONObject jSONObject;
            try {
                JSONObject b = this.a.a.k().b();
                if (b != null) {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "3");
                        jSONObject.put("ver", "1");
                        jSONObject.put("cuid", com.baidu.location.b.b.a().b);
                        jSONObject.put("prod", com.baidu.location.b.b.h + ":" + com.baidu.location.b.b.g);
                        jSONObject.put("rgc", b);
                        this.s = System.currentTimeMillis();
                    } catch (Exception e) {
                    }
                } else {
                    jSONObject = null;
                }
            } catch (Exception e2) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.G(jSONObject.toString()) : null;
        }

        private boolean p() {
            Throwable th;
            Cursor cursor = null;
            boolean z = true;
            Cursor rawQuery;
            try {
                rawQuery = this.a.h.rawQuery("SELECT COUNT(*) FROM AP;", null);
                try {
                    cursor = this.a.h.rawQuery("SELECT COUNT(*) FROM CL", null);
                    if (!(rawQuery == null || !rawQuery.moveToFirst() || cursor == null || !cursor.moveToFirst() || (rawQuery.getInt(0) == 0 && cursor.getInt(0) == 0))) {
                        z = false;
                    }
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e5) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                rawQuery = cursor;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                rawQuery = cursor;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            return z;
        }

        public void a() {
            this.o = true;
            this.c = this.k;
            this.f.clear();
            this.f.add(new BasicNameValuePair("qt", this.l));
            this.f.add(new BasicNameValuePair("req", this.m));
        }

        public void a(boolean z) {
            if (!z || this.e == null) {
                this.o = false;
                c();
                return;
            }
            new c(this).start();
        }

        void b() {
            if (j() && !this.o) {
                this.a.g.k();
            }
        }
    }

    final class c {
        double a;
        double b;
        double c;

        private c(double d, double d2, double d3) {
            this.a = d;
            this.b = d2;
            this.c = d3;
        }
    }

    a(h hVar) {
        File file;
        SQLiteDatabase openOrCreateDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        this.a = hVar;
        try {
            file = new File(this.a.c(), "ofl_location.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, null);
        } catch (Exception e) {
            openOrCreateDatabase = null;
        }
        this.h = openOrCreateDatabase;
        if (this.h != null) {
            try {
                this.h.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
                this.h.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
            } catch (Exception e2) {
            }
        }
        try {
            file = new File(this.a.c(), "ofl_statistics.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(file, null);
        } catch (Exception e3) {
        }
        this.i = sQLiteDatabase;
        if (this.i != null) {
            try {
                this.i.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY, originid VARCHAR(15), frequency INTEGER DEFAULT 0);");
                this.i.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY, originid VARCHAR(40), frequency INTEGER DEFAULT 0);");
            } catch (Exception e4) {
            }
        }
    }

    private double a(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        double toRadians = Math.toRadians(d);
        Math.toRadians(d2);
        double toRadians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        d5 = Math.toRadians(d5);
        d6 = Math.toRadians(d6);
        d5 = (Math.sin(d5 / 2.0d) * ((Math.cos(toRadians) * Math.cos(toRadians2)) * Math.sin(d5 / 2.0d))) + (Math.sin(d6 / 2.0d) * Math.sin(d6 / 2.0d));
        return (Math.atan2(Math.sqrt(d5), Math.sqrt(1.0d - d5)) * 2.0d) * 6378137.0d;
    }

    private int a(ArrayList arrayList, double d) {
        if (arrayList.size() == 0) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2;
            int i3;
            if (arrayList.size() >= 3) {
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (i2 = 0; i2 < arrayList.size(); i2++) {
                    d2 += ((c) arrayList.get(i2)).a;
                    d3 += ((c) arrayList.get(i2)).b;
                }
                d2 /= (double) arrayList.size();
                d3 /= (double) arrayList.size();
                int i4 = 0;
                int i5 = -1;
                double d4 = -1.0d;
                while (i4 < arrayList.size()) {
                    double a = a(d3, d2, ((c) arrayList.get(i4)).b, ((c) arrayList.get(i4)).a);
                    if (a > d4) {
                        i2 = i4;
                    } else {
                        i2 = i5;
                        a = d4;
                    }
                    i4++;
                    i5 = i2;
                    d4 = a;
                }
                if (d4 > d && i5 >= 0 && i5 < arrayList.size()) {
                    i++;
                    arrayList.remove(i5);
                    i2 = 1;
                    i3 = i;
                    if (i2 == 1) {
                        return i3;
                    }
                    i = i3;
                }
            }
            i2 = 0;
            i3 = i;
            if (i2 == 1) {
                return i3;
            }
            i = i3;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.location.BDLocation a(java.lang.Long r20) {
        /*
        r19 = this;
        r2 = 0;
        r0 = r19;
        r0.p = r2;
        r8 = 0;
        r6 = 0;
        r4 = 0;
        r3 = 0;
        r0 = r19;
        r2 = r0.e;
        if (r2 == 0) goto L_0x0047;
    L_0x0011:
        r0 = r19;
        r2 = r0.e;
        r0 = r20;
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0047;
    L_0x001d:
        r3 = 1;
        r0 = r19;
        r6 = r0.c;
        r0 = r19;
        r4 = r0.d;
        r0 = r19;
        r8 = r0.b;
    L_0x002a:
        if (r3 == 0) goto L_0x0114;
    L_0x002c:
        r2 = new com.baidu.location.BDLocation;
        r2.<init>();
        r3 = (float) r8;
        r2.setRadius(r3);
        r2.setLatitude(r4);
        r2.setLongitude(r6);
        r3 = "cl";
        r2.setNetworkLocationType(r3);
        r3 = 66;
        r2.setLocType(r3);
    L_0x0046:
        return r2;
    L_0x0047:
        r2 = 0;
        r9 = java.util.Locale.US;
        r10 = "SELECT * FROM CL WHERE id = %d AND timestamp + %d > %d;";
        r11 = 3;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r11[r12] = r20;
        r12 = 1;
        r13 = 15552000; // 0xed4e00 float:2.1792994E-38 double:7.683709E-317;
        r13 = java.lang.Integer.valueOf(r13);
        r11[r12] = r13;
        r12 = 2;
        r14 = java.lang.System.currentTimeMillis();
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r14 = r14 / r16;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r9 = java.lang.String.format(r9, r10, r11);
        r0 = r19;
        r10 = r0.h;	 Catch:{ Exception -> 0x00fd, all -> 0x0108 }
        r11 = 0;
        r2 = r10.rawQuery(r9, r11);	 Catch:{ Exception -> 0x00fd, all -> 0x0108 }
        if (r2 == 0) goto L_0x00ec;
    L_0x007b:
        r9 = r2.moveToFirst();	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        if (r9 == 0) goto L_0x00ec;
    L_0x0081:
        r9 = "cl";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r10 = r2.getDouble(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r12 = 0;
        r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r9 <= 0) goto L_0x00ec;
    L_0x0092:
        r3 = 1;
        r9 = "x";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r6 = r2.getDouble(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r9 = "y";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r4 = r2.getDouble(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r9 = "r";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r8 = r2.getInt(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r9 = "timestamp";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r9 = r2.getInt(r9);	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r10 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r9 = r9 + r10;
        r10 = (long) r9;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r9 >= 0) goto L_0x00d4;
    L_0x00cf:
        r9 = 1;
        r0 = r19;
        r0.p = r9;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
    L_0x00d4:
        r9 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r8 >= r9) goto L_0x00f6;
    L_0x00d8:
        r8 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
    L_0x00da:
        r0 = r19;
        r0.c = r6;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r0 = r19;
        r0.d = r4;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r0 = r19;
        r0.b = r8;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
        r0 = r20;
        r1 = r19;
        r1.e = r0;	 Catch:{ Exception -> 0x00fd, all -> 0x0119 }
    L_0x00ec:
        if (r2 == 0) goto L_0x002a;
    L_0x00ee:
        r2.close();	 Catch:{ Exception -> 0x00f3 }
        goto L_0x002a;
    L_0x00f3:
        r2 = move-exception;
        goto L_0x002a;
    L_0x00f6:
        r9 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r9 >= r8) goto L_0x00da;
    L_0x00fa:
        r8 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        goto L_0x00da;
    L_0x00fd:
        r9 = move-exception;
        if (r2 == 0) goto L_0x002a;
    L_0x0100:
        r2.close();	 Catch:{ Exception -> 0x0105 }
        goto L_0x002a;
    L_0x0105:
        r2 = move-exception;
        goto L_0x002a;
    L_0x0108:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
    L_0x010e:
        if (r3 == 0) goto L_0x0113;
    L_0x0110:
        r3.close();	 Catch:{ Exception -> 0x0117 }
    L_0x0113:
        throw r2;
    L_0x0114:
        r2 = 0;
        goto L_0x0046;
    L_0x0117:
        r3 = move-exception;
        goto L_0x0113;
    L_0x0119:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x010e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a(java.lang.Long):com.baidu.location.BDLocation");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.location.BDLocation a(java.util.LinkedHashMap r34, com.baidu.location.BDLocation r35, int r36) {
        /*
        r33 = this;
        r0 = r33;
        r2 = r0.o;
        r3 = 0;
        r2.setLength(r3);
        r6 = 0;
        r4 = 0;
        r2 = 0;
        if (r35 == 0) goto L_0x0386;
    L_0x000f:
        r2 = 1;
        r4 = r35.getLatitude();
        r6 = r35.getLongitude();
        r21 = r2;
    L_0x001a:
        r28 = 0;
        r26 = 0;
        r24 = 0;
        r23 = 0;
        r10 = new java.lang.StringBuffer;
        r10.<init>();
        r3 = 1;
        r2 = r34.entrySet();
        r11 = r2.iterator();
        r2 = 0;
        r8 = r2;
        r9 = r3;
    L_0x0033:
        r2 = r34.size();
        r3 = 30;
        r2 = java.lang.Math.min(r2, r3);
        if (r8 >= r2) goto L_0x0088;
    L_0x003f:
        r2 = r11.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r2 = r2.getValue();
        r2 = (java.lang.Integer) r2;
        r12 = r2.intValue();
        if (r12 >= 0) goto L_0x0060;
    L_0x0057:
        r2 = r2.intValue();
        r2 = -r2;
        r2 = java.lang.Integer.valueOf(r2);
    L_0x0060:
        r12 = com.baidu.location.Jni.I(r3);
        if (r12 != 0) goto L_0x006c;
    L_0x0066:
        r3 = r9;
    L_0x0067:
        r2 = r8 + 1;
        r8 = r2;
        r9 = r3;
        goto L_0x0033;
    L_0x006c:
        r0 = r33;
        r13 = r0.n;
        r13.put(r12, r3);
        if (r9 == 0) goto L_0x0082;
    L_0x0075:
        r9 = 0;
    L_0x0076:
        r0 = r33;
        r3 = r0.m;
        r3.put(r12, r2);
        r10.append(r12);
        r3 = r9;
        goto L_0x0067;
    L_0x0082:
        r3 = 44;
        r10.append(r3);
        goto L_0x0076;
    L_0x0088:
        r2 = java.util.Locale.US;
        r3 = "SELECT * FROM AP WHERE id IN (%s) AND timestamp+%d>%d;";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r10;
        r9 = 1;
        r10 = 7776000; // 0x76a700 float:1.0896497E-38 double:3.8418545E-317;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.System.currentTimeMillis();
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r12;
        r10 = java.lang.Long.valueOf(r10);
        r8[r9] = r10;
        r3 = java.lang.String.format(r2, r3, r8);
        r2 = 0;
        r0 = r33;
        r8 = r0.h;	 Catch:{ Exception -> 0x034f, all -> 0x0349 }
        r9 = 0;
        r22 = r8.rawQuery(r3, r9);	 Catch:{ Exception -> 0x034f, all -> 0x0349 }
        if (r22 == 0) goto L_0x037d;
    L_0x00bb:
        r2 = r22.moveToFirst();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        if (r2 == 0) goto L_0x037d;
    L_0x00c1:
        r29 = new java.util.ArrayList;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r29.<init>();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
    L_0x00c6:
        r2 = r22.isAfterLast();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        if (r2 != 0) goto L_0x0232;
    L_0x00cc:
        r2 = 0;
        r0 = r22;
        r2 = r0.getLong(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 1;
        r0 = r22;
        r10 = r0.getDouble(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 2;
        r0 = r22;
        r8 = r0.getDouble(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 3;
        r0 = r22;
        r12 = r0.getInt(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 4;
        r0 = r22;
        r14 = r0.getDouble(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 5;
        r0 = r22;
        r3 = r0.getInt(r3);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r33;
        r13 = r0.l;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13.add(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r3 = r3 + r13;
        r0 = (long) r3;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = r0;
        r18 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r30 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r18 = r18 / r30;
        r3 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1));
        if (r3 >= 0) goto L_0x0163;
    L_0x0114:
        r0 = r33;
        r3 = r0.o;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = r3.length();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        if (r3 <= 0) goto L_0x0128;
    L_0x011e:
        r0 = r33;
        r3 = r0.o;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13 = ",";
        r3.append(r13);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
    L_0x0128:
        r0 = r33;
        r3 = r0.o;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13 = java.util.Locale.US;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = "(%d,\"%s\",%d)";
        r17 = 3;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r17 = r0;
        r18 = 0;
        r17[r18] = r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = 1;
        r0 = r33;
        r0 = r0.n;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r19 = r0;
        r0 = r19;
        r19 = r0.get(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r17[r18] = r19;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = 2;
        r19 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r19 = java.lang.Integer.valueOf(r19);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r17[r18] = r19;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r16;
        r1 = r17;
        r13 = java.lang.String.format(r13, r0, r1);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3.append(r13);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
    L_0x0163:
        r16 = 0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 > 0) goto L_0x019b;
    L_0x0169:
        r22.moveToNext();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        goto L_0x00c6;
    L_0x016e:
        r2 = move-exception;
        r2 = r22;
        r3 = r23;
        r12 = r24;
        r10 = r26;
        r4 = r28;
    L_0x0179:
        if (r2 == 0) goto L_0x017e;
    L_0x017b:
        r2.close();	 Catch:{ Exception -> 0x0343 }
    L_0x017e:
        if (r3 == 0) goto L_0x0340;
    L_0x0180:
        r2 = new com.baidu.location.BDLocation;
        r2.<init>();
        r3 = (float) r4;
        r2.setRadius(r3);
        r2.setLatitude(r12);
        r2.setLongitude(r10);
        r3 = "wf";
        r2.setNetworkLocationType(r3);
        r3 = 66;
        r2.setLocType(r3);
    L_0x019a:
        return r2;
    L_0x019b:
        r14 = 0;
        r3 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r3 <= 0) goto L_0x01ad;
    L_0x01a1:
        r14 = 0;
        r3 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r3 <= 0) goto L_0x01ad;
    L_0x01a7:
        if (r12 <= 0) goto L_0x01ad;
    L_0x01a9:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r12 < r3) goto L_0x01b9;
    L_0x01ad:
        r22.moveToNext();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        goto L_0x00c6;
    L_0x01b2:
        r2 = move-exception;
    L_0x01b3:
        if (r22 == 0) goto L_0x01b8;
    L_0x01b5:
        r22.close();	 Catch:{ Exception -> 0x0346 }
    L_0x01b8:
        throw r2;
    L_0x01b9:
        r3 = 1;
        r0 = r21;
        if (r0 != r3) goto L_0x01d2;
    L_0x01be:
        r3 = r33;
        r14 = r3.a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 <= 0) goto L_0x01d2;
    L_0x01cd:
        r22.moveToNext();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        goto L_0x00c6;
    L_0x01d2:
        r0 = r33;
        r3 = r0.m;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = r3.get(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = (java.lang.Integer) r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = r2.intValue();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 30;
        r2 = java.lang.Math.max(r3, r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r3 = 100;
        r2 = java.lang.Math.min(r3, r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = 70;
        if (r2 <= r3) goto L_0x0229;
    L_0x01f2:
        r2 = r2 + -70;
        r2 = (double) r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = 4629137466983448576; // 0x403e000000000000 float:0.0 double:30.0;
        r2 = r2 / r16;
        r2 = r2 + r14;
    L_0x01fa:
        r14 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r12 = (double) r12;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r12 = java.lang.Math.max(r14, r12);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r14 = 4603579539098121011; // 0x3fe3333333333333 float:4.172325E-8 double:0.6;
        r12 = java.lang.Math.pow(r12, r14);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r14 = -4634023872579145564; // 0xbfb0a3d70a3d70a4 float:9.121204E-33 double:-0.065;
        r12 = r12 * r14;
        r2 = r2 * r12;
        r18 = java.lang.Math.exp(r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r13 = new com.baidu.location.c.a$c;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r20 = 0;
        r14 = r10;
        r16 = r8;
        r13.<init>(r14, r16, r18);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r29;
        r0.add(r13);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r22.moveToNext();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        goto L_0x00c6;
    L_0x0229:
        r2 = r2 + -70;
        r2 = (double) r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r16 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r2 = r2 / r16;
        r2 = r2 + r14;
        goto L_0x01fa;
    L_0x0232:
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r33;
        r1 = r29;
        r0.a(r1, r2);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r10 = 0;
        r12 = 0;
        r8 = 0;
        r2 = 0;
        r16 = r2;
    L_0x0247:
        r2 = r29.size();	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r16;
        if (r0 >= r2) goto L_0x0282;
    L_0x024f:
        r0 = r29;
        r1 = r16;
        r2 = r0.get(r1);	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = (com.baidu.location.c.a.c) r2;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r14 = r2.c;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = 0;
        r3 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1));
        if (r3 > 0) goto L_0x026a;
    L_0x0261:
        r2 = r8;
        r8 = r12;
    L_0x0263:
        r12 = r16 + 1;
        r16 = r12;
        r12 = r8;
        r8 = r2;
        goto L_0x0247;
    L_0x026a:
        r14 = r2.a;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r2.c;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = r0;
        r14 = r14 * r18;
        r14 = r14 + r10;
        r10 = r2.b;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r0 = r2.c;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r18 = r0;
        r10 = r10 * r18;
        r10 = r10 + r12;
        r2 = r2.c;	 Catch:{ Exception -> 0x016e, all -> 0x01b2 }
        r2 = r2 + r8;
        r8 = r10;
        r10 = r14;
        goto L_0x0263;
    L_0x0282:
        r2 = 0;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0373;
    L_0x0288:
        r2 = 0;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0373;
    L_0x028e:
        r2 = 0;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0373;
    L_0x0294:
        r10 = r10 / r8;
        r12 = r12 / r8;
        r3 = 1;
        r8 = 0;
        r2 = 0;
        r32 = r2;
        r2 = r8;
        r8 = r32;
    L_0x029e:
        r9 = r29.size();	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        if (r8 >= r9) goto L_0x02cb;
    L_0x02a4:
        r0 = (double) r2;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r18 = r0;
        r0 = r29;
        r2 = r0.get(r8);	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = (com.baidu.location.c.a.c) r2;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r14 = r2.a;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r0 = r29;
        r2 = r0.get(r8);	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = (com.baidu.location.c.a.c) r2;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r0 = r2.b;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r16 = r0;
        r9 = r33;
        r14 = r9.a(r10, r12, r14, r16);	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r14 = r14 + r18;
        r9 = (float) r14;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = r8 + 1;
        r8 = r2;
        r2 = r9;
        goto L_0x029e;
    L_0x02cb:
        r8 = r29.size();	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r8 = (float) r8;	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = r2 / r8;
        r28 = java.lang.Math.round(r2);	 Catch:{ Exception -> 0x035a, all -> 0x01b2 }
        r2 = 30;
        r0 = r28;
        if (r0 >= r2) goto L_0x0333;
    L_0x02db:
        r28 = 30;
        r2 = r3;
        r8 = r12;
        r12 = r28;
    L_0x02e1:
        if (r21 != 0) goto L_0x02eb;
    L_0x02e3:
        r3 = r29.size();	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r13 = 1;
        if (r3 > r13) goto L_0x02eb;
    L_0x02ea:
        r2 = 0;
    L_0x02eb:
        r3 = r29.size();	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r0 = r36;
        if (r3 >= r0) goto L_0x030e;
    L_0x02f3:
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = r29.size();	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r0 = (double) r3;	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r16 = r0;
        r14 = r14 * r16;
        r3 = r34.size();	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r0 = (double) r3;	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r16 = r0;
        r14 = r14 / r16;
        r16 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 >= 0) goto L_0x030e;
    L_0x030d:
        r2 = 0;
    L_0x030e:
        r3 = 1;
        r0 = r21;
        if (r0 != r3) goto L_0x0369;
    L_0x0313:
        r3 = 1;
        if (r2 != r3) goto L_0x0369;
    L_0x0316:
        r3 = r33;
        r4 = r3.a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x0361, all -> 0x01b2 }
        r6 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x0369;
    L_0x0325:
        r2 = 0;
        r3 = r2;
        r4 = r12;
        r12 = r8;
    L_0x0329:
        if (r22 == 0) goto L_0x017e;
    L_0x032b:
        r22.close();	 Catch:{ Exception -> 0x0330 }
        goto L_0x017e;
    L_0x0330:
        r2 = move-exception;
        goto L_0x017e;
    L_0x0333:
        r2 = 100;
        r0 = r28;
        if (r2 >= r0) goto L_0x036d;
    L_0x0339:
        r28 = 100;
        r2 = r3;
        r8 = r12;
        r12 = r28;
        goto L_0x02e1;
    L_0x0340:
        r2 = 0;
        goto L_0x019a;
    L_0x0343:
        r2 = move-exception;
        goto L_0x017e;
    L_0x0346:
        r3 = move-exception;
        goto L_0x01b8;
    L_0x0349:
        r3 = move-exception;
        r22 = r2;
        r2 = r3;
        goto L_0x01b3;
    L_0x034f:
        r3 = move-exception;
        r3 = r23;
        r12 = r24;
        r10 = r26;
        r4 = r28;
        goto L_0x0179;
    L_0x035a:
        r2 = move-exception;
        r2 = r22;
        r4 = r28;
        goto L_0x0179;
    L_0x0361:
        r3 = move-exception;
        r3 = r2;
        r4 = r12;
        r12 = r8;
        r2 = r22;
        goto L_0x0179;
    L_0x0369:
        r3 = r2;
        r4 = r12;
        r12 = r8;
        goto L_0x0329;
    L_0x036d:
        r2 = r3;
        r8 = r12;
        r12 = r28;
        goto L_0x02e1;
    L_0x0373:
        r2 = r23;
        r8 = r24;
        r10 = r26;
        r12 = r28;
        goto L_0x02e1;
    L_0x037d:
        r3 = r23;
        r12 = r24;
        r10 = r26;
        r4 = r28;
        goto L_0x0329;
    L_0x0386:
        r21 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a(java.util.LinkedHashMap, com.baidu.location.BDLocation, int):com.baidu.location.BDLocation");
    }

    private void a(BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str, Long l) {
        if (bDLocation != null && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
            String format;
            String format2;
            if (bDLocation2 != null && bDLocation.getNetworkLocationType().equals("cl") && a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 300.0d) {
                format = String.format(Locale.US, "UPDATE CL SET cl = 0 WHERE id = %d;", new Object[]{l});
                format2 = String.format(Locale.US, "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);", new Object[]{l, str, Integer.valueOf(100000)});
                try {
                    this.h.execSQL(format);
                    this.i.execSQL(format2);
                } catch (Exception e) {
                }
            }
            if (bDLocation3 != null && bDLocation.getNetworkLocationType().equals("wf") && a(bDLocation3.getLatitude(), bDLocation3.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 100.0d) {
                format = String.format("UPDATE AP SET cl = 0 WHERE id In (%s);", new Object[]{this.j.toString()});
                format2 = String.format("INSERT OR REPLACE INTO AP VALUES %s;", new Object[]{this.k.toString()});
                try {
                    this.h.execSQL(format);
                    this.i.execSQL(format2);
                } catch (Exception e2) {
                }
            }
        }
    }

    private void a(String str, Long l, BDLocation bDLocation) {
        if (str != null) {
            if (bDLocation != null) {
                try {
                    this.h.execSQL(String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[]{l}));
                } catch (Exception e) {
                }
            } else {
                String format = String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", new Object[]{l, str});
                String format2 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[]{l});
                try {
                    this.i.execSQL(format);
                    this.i.execSQL(format2);
                } catch (Exception e2) {
                }
            }
            if (this.p) {
                try {
                    this.i.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", new Object[]{l, str, Integer.valueOf(100000)}));
                } catch (Exception e3) {
                }
            }
        }
    }

    private void a(String str, String str2, String str3) {
        this.f.a(str, str2, str3);
    }

    private void a(LinkedHashMap linkedHashMap) {
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            String str;
            this.j = new StringBuffer();
            this.k = new StringBuffer();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            int i = 1;
            int i2 = 1;
            for (Long l : this.m.keySet()) {
                try {
                    int i3;
                    int i4;
                    if (this.l.contains(l)) {
                        if (i2 != 0) {
                            i2 = 0;
                        } else {
                            this.j.append(',');
                            this.k.append(',');
                        }
                        this.j.append(l);
                        this.k.append('(').append(l).append(',').append('\"').append((String) this.n.get(l)).append('\"').append(',').append(100000).append(')');
                        i3 = i;
                        i4 = i2;
                    } else {
                        str = (String) this.n.get(l);
                        if (i != 0) {
                            i = 0;
                        } else {
                            stringBuffer.append(',');
                            stringBuffer2.append(',');
                        }
                        stringBuffer.append(l);
                        stringBuffer2.append('(').append(l).append(',').append('\"').append(str).append('\"').append(",0)");
                        i3 = i;
                        i4 = i2;
                    }
                    i = i3;
                    i2 = i4;
                } catch (Exception e) {
                    i = i;
                    i2 = i2;
                }
            }
            try {
                this.h.execSQL(String.format(Locale.US, "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)", new Object[]{this.j.toString()}));
            } catch (Exception e2) {
            }
            if (this.o.length() > 0) {
                if (stringBuffer2.length() > 0) {
                    stringBuffer2.append(",");
                }
                stringBuffer2.append(this.o);
            }
            String format = String.format("INSERT OR IGNORE INTO AP VALUES %s;", new Object[]{stringBuffer2.toString()});
            str = String.format("UPDATE AP SET frequency=frequency+1 WHERE id in (%s);", new Object[]{stringBuffer.toString()});
            try {
                if (stringBuffer2.length() > 0) {
                    this.i.execSQL(format);
                }
                if (stringBuffer.length() > 0) {
                    this.i.execSQL(str);
                }
            } catch (Exception e3) {
            }
        }
    }

    private void a(String[] strArr) {
        this.a.l().a(strArr);
    }

    Cursor a(a aVar) {
        BDLocation bDLocation;
        BDLocation bDLocation2 = new BDLocation();
        bDLocation2.setLocType(67);
        int i = 0;
        if (aVar.c) {
            double[] dArr;
            List list;
            String str = aVar.b;
            LinkedHashMap linkedHashMap = aVar.i;
            int i2 = aVar.f;
            BDLocation bDLocation3 = aVar.g;
            BDLocation bDLocation4 = null;
            Long valueOf = Long.valueOf(Long.MIN_VALUE);
            if (!(str == null || this.h == null)) {
                valueOf = Jni.I(str);
                if (valueOf != null) {
                    bDLocation4 = a(valueOf);
                }
            }
            BDLocation bDLocation5 = null;
            if (!(linkedHashMap == null || linkedHashMap.size() <= 0 || this.h == null)) {
                this.m.clear();
                this.l.clear();
                this.n.clear();
                bDLocation5 = a(linkedHashMap, bDLocation4, i2);
            }
            Double d = null;
            Double d2 = null;
            Double d3 = null;
            Double d4 = null;
            if (bDLocation4 != null) {
                d = Double.valueOf(bDLocation4.getLongitude());
                d2 = Double.valueOf(bDLocation4.getLatitude());
                dArr = Jni.if(bDLocation4.getLongitude(), bDLocation4.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                bDLocation4.setCoorType("gcj");
                bDLocation4.setLatitude(dArr[1]);
                bDLocation4.setLongitude(dArr[0]);
                bDLocation4.setNetworkLocationType("cl");
            }
            if (bDLocation5 != null) {
                d3 = Double.valueOf(bDLocation5.getLongitude());
                d4 = Double.valueOf(bDLocation5.getLatitude());
                dArr = Jni.if(bDLocation5.getLongitude(), bDLocation5.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                bDLocation5.setCoorType("gcj");
                bDLocation5.setLatitude(dArr[1]);
                bDLocation5.setLongitude(dArr[0]);
                bDLocation5.setNetworkLocationType("wf");
            }
            if (bDLocation4 != null && bDLocation5 == null) {
                i = 1;
            } else if (bDLocation4 == null && bDLocation5 != null) {
                i = 2;
            } else if (!(bDLocation4 == null || bDLocation5 == null)) {
                i = 4;
            }
            Object obj = aVar.f > 0 ? 1 : null;
            Object obj2 = (linkedHashMap == null || linkedHashMap.size() <= 0) ? 1 : null;
            if (obj != null) {
                if (bDLocation5 != null) {
                    d2 = d3;
                    bDLocation = bDLocation5;
                } else {
                    if (!(obj2 == null || bDLocation4 == null)) {
                        d4 = d2;
                        bDLocation = bDLocation4;
                        d2 = d;
                    }
                    d4 = null;
                    d2 = null;
                    bDLocation = bDLocation2;
                }
            } else if (bDLocation5 != null) {
                d2 = d3;
                bDLocation = bDLocation5;
            } else {
                if (bDLocation4 != null) {
                    d4 = d2;
                    bDLocation = bDLocation4;
                    d2 = d;
                }
                d4 = null;
                d2 = null;
                bDLocation = bDLocation2;
            }
            if (aVar.e && this.a.l().l() && d4 != null && d2 != null) {
                bDLocation.setAddr(this.a.k().a(d2.doubleValue(), d4.doubleValue()));
            }
            if (obj != null && aVar.e && bDLocation.getAddrStr() == null) {
                d4 = null;
                d2 = null;
                i = 0;
                bDLocation = bDLocation2;
            }
            if ((!aVar.d && !aVar.h) || d4 == null || d2 == null) {
                list = null;
            } else {
                List b = this.a.k().b(d2.doubleValue(), d4.doubleValue());
                if (aVar.d) {
                    bDLocation.setPoiList(b);
                }
                list = b;
            }
            if (obj == null || !aVar.d || (list != null && list.size() > 0)) {
                i2 = i;
            } else {
                i2 = 0;
                bDLocation = bDLocation2;
            }
            String str2 = null;
            if (aVar.h && list != null && list.size() > 0) {
                str2 = String.format(Locale.CHINA, "在%s附近", new Object[]{((Poi) list.get(0)).getName()});
                bDLocation.setLocationDescribe(str2);
            }
            if (obj != null && aVar.h && r4 == null) {
                i2 = 0;
                bDLocation = bDLocation2;
            }
            StringBuffer stringBuffer = new StringBuffer();
            String str3 = null;
            if (aVar.a != null) {
                stringBuffer.append(aVar.a);
                stringBuffer.append(g.a(bDLocation5, bDLocation4, aVar));
                stringBuffer.append(g.a(bDLocation, i2));
                str3 = stringBuffer.toString();
            }
            new b(this, str, valueOf, bDLocation4, bDLocation5, bDLocation3, str3, linkedHashMap).start();
        } else {
            bDLocation = bDLocation2;
        }
        return g.a(bDLocation);
    }

    SQLiteDatabase a() {
        return this.i;
    }

    void b() {
        this.g.b();
    }
}
