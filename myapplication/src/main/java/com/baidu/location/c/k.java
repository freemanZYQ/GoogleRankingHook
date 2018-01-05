package com.baidu.location.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.qq.e.comm.constants.ErrorCode.AdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

final class k {
    private static final double[] b = new double[]{45.0d, 135.0d, 225.0d, 315.0d};
    private final h a;
    private final int c;
    private final SQLiteDatabase d;
    private int e = -1;
    private int f = -1;

    final class a {
        private double a;
        private double b;

        private a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    enum b {
        AREA("RGCAREA", "area", "addrv", 0, LocationClientOption.MIN_SCAN_SPAN),
        ROAD("RGCROAD", "road", "addrv", LocationClientOption.MIN_SCAN_SPAN, 10000),
        SITE("RGCSITE", "site", "addrv", 100, 50000),
        POI("RGCPOI", "poi", "poiv", LocationClientOption.MIN_SCAN_SPAN, 5000);
        
        private final int e;
        private final String f;
        private final String g;
        private final String h;
        private final int i;

        private b(String str, String str2, String str3, int i, int i2) {
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.e = i;
            this.i = i2;
        }

        private String a(int i, double d, double d2) {
            HashSet hashSet = new HashSet();
            hashSet.add(k.b(i, d, d2));
            double d3 = ((double) this.e) * 1.414d;
            if (this.e > 0) {
                for (double a : k.b) {
                    double[] a2 = k.b(d2, d, d3, a);
                    hashSet.add(k.b(i, a2[1], a2[0]));
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = hashSet.iterator();
            Object obj = 1;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append("\"").append(str).append("\"");
            }
            return String.format("SELECT * FROM %s WHERE gridkey IN (%s);", new Object[]{this.f, stringBuffer.toString()});
        }

        private String a(JSONObject jSONObject) {
            Iterator keys = jSONObject.keys();
            StringBuffer stringBuffer = new StringBuffer();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("\"").append(str).append("\"");
            }
            return String.format(Locale.US, "DELETE FROM %s WHERE gridkey IN (%s)", new Object[]{this.f, stringBuffer});
        }

        public static b[] a() {
            return (b[]) j.clone();
        }

        private static void b(StringBuffer stringBuffer, String str, String str2, int i) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"").append(str).append("\",\"").append(str2).append("\",").append(i).append(",").append(System.currentTimeMillis() / 86400000).append(")");
        }

        abstract List a(JSONObject jSONObject, String str, int i);
    }

    k(h hVar, SQLiteDatabase sQLiteDatabase, int i) {
        this.a = hVar;
        this.d = sQLiteDatabase;
        this.c = i;
        if (this.d != null && this.d.isOpen()) {
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCAREA(gridkey VARCHAR(10) PRIMARY KEY, country VARCHAR(100),countrycode VARCHAR(100), province VARCHAR(100), city VARCHAR(100), citycode VARCHAR(100), district VARCHAR(100), timestamp INTEGER, version VARCHAR(50))");
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCROAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE)");
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCSITE(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), streetnumber VARCHAR(100), x DOUBLE, y DOUBLE)");
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCPOI(pid VARCHAR(50) PRIMARY KEY , gridkey VARCHAR(10), name VARCHAR(100), type VARCHAR(50), x DOUBLE, y DOUBLE, rank INTEGER)");
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCUPDATE(gridkey VARCHAR(10), version VARCHAR(50), type INTEGER, timestamp INTEGER, PRIMARY KEY(gridkey, type))");
        }
    }

    private double a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = ((d5 - d3) * (d - d3)) + ((d6 - d4) * (d2 - d4));
        if (d7 <= 0.0d) {
            return Math.sqrt(((d - d3) * (d - d3)) + ((d2 - d4) * (d2 - d4)));
        }
        double d8 = ((d5 - d3) * (d5 - d3)) + ((d6 - d4) * (d6 - d4));
        if (d7 >= d8) {
            return Math.sqrt(((d - d5) * (d - d5)) + ((d2 - d6) * (d2 - d6)));
        }
        d7 /= d8;
        d8 = ((d5 - d3) * d7) + d3;
        d7 = (d7 * (d6 - d4)) + d4;
        return Math.sqrt(((d7 - d2) * (d7 - d2)) + ((d - d8) * (d - d8)));
    }

    private static int a(int i, int i2) {
        double d;
        int i3;
        if (100 > i2) {
            d = -0.1d;
            i3 = 60000;
        } else if (AdError.PLACEMENT_ERROR > i2) {
            d = -0.75d;
            i3 = 55500;
        } else {
            d = -0.5d;
            i3 = 0;
        }
        return ((int) (((double) i3) + (d * ((double) i2)))) + i;
    }

    private static String b(int i, double d, double d2) {
        int i2 = i * 5;
        char[] cArr = new char[(i + 1)];
        a aVar = new a(90.0d, -90.0d);
        a aVar2 = new a(180.0d, -180.0d);
        int i3 = 1;
        Object obj = 1;
        int i4 = 0;
        while (i3 <= i2) {
            a aVar3;
            double d3;
            int i5;
            int i6;
            if (obj != null) {
                aVar3 = aVar2;
                d3 = d;
            } else {
                aVar3 = aVar;
                d3 = d2;
            }
            double a = (aVar3.b + aVar3.a) / 2.0d;
            i4 <<= 1;
            if (((int) (d3 * 1000000.0d)) > ((int) (1000000.0d * a))) {
                aVar3.b = a;
                i5 = i4 | 1;
            } else {
                aVar3.a = a;
                i5 = i4;
            }
            if (i3 % 5 == 0) {
                cArr[(i3 / 5) - 1] = "0123456789bcdefghjkmnpqrstuvwxyz".charAt(i5);
                i6 = 0;
            } else {
                i6 = i5;
            }
            i3++;
            obj = obj == null ? 1 : null;
            i4 = i6;
        }
        cArr[i] = '\u0000';
        StringBuffer stringBuffer = new StringBuffer();
        for (i5 = 0; i5 < i; i5++) {
            stringBuffer.append(cArr[i5]);
        }
        return stringBuffer.toString();
    }

    private static double[] b(double d, double d2, double d3, double d4) {
        double[] dArr = new double[2];
        double toRadians = Math.toRadians(d);
        double toRadians2 = Math.toRadians(d2);
        double toRadians3 = Math.toRadians(d4);
        double asin = Math.asin((Math.sin(toRadians) * Math.cos(d3 / 6378137.0d)) + ((Math.cos(toRadians) * Math.sin(d3 / 6378137.0d)) * Math.cos(toRadians3)));
        toRadians = Math.atan2((Math.sin(toRadians3) * Math.sin(d3 / 6378137.0d)) * Math.cos(toRadians), Math.cos(d3 / 6378137.0d) - (Math.sin(toRadians) * Math.sin(asin))) + toRadians2;
        dArr[0] = Math.toDegrees(asin);
        dArr[1] = Math.toDegrees(toRadians);
        return dArr;
    }

    private double c(double d, double d2, double d3, double d4) {
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.baidu.location.a a(double r32, double r34) {
        /*
        r31 = this;
        r24 = 0;
        r23 = 0;
        r22 = 0;
        r21 = 0;
        r20 = 0;
        r25 = 0;
        r12 = 0;
        r11 = 0;
        r10 = 0;
        r4 = com.baidu.location.c.k.b.SITE;	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r0 = r31;
        r5 = r0.c;	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r6 = r32;
        r8 = r34;
        r4 = r4.a(r5, r6, r8);	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r0 = r31;
        r5 = r0.d;	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r6 = 0;
        r4 = r5.rawQuery(r4, r6);	 Catch:{ Exception -> 0x011d, all -> 0x0131 }
        r5 = r4.moveToFirst();	 Catch:{ Exception -> 0x02e4, all -> 0x02df }
        if (r5 == 0) goto L_0x031f;
    L_0x002c:
        r6 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r16 = r6;
        r14 = r11;
        r15 = r12;
    L_0x0035:
        r5 = r4.isAfterLast();	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        if (r5 != 0) goto L_0x0074;
    L_0x003b:
        r5 = 2;
        r19 = r4.getString(r5);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = 3;
        r18 = r4.getString(r5);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = 5;
        r10 = r4.getDouble(r5);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = 4;
        r12 = r4.getDouble(r5);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = r31;
        r6 = r34;
        r8 = r32;
        r8 = r5.c(r6, r8, r10, r12);	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1));
        if (r5 >= 0) goto L_0x0319;
    L_0x005d:
        r5 = com.baidu.location.c.k.b.SITE;	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r5 = r5.e;	 Catch:{ Exception -> 0x02ec, all -> 0x02df }
        r6 = (double) r5;
        r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r5 > 0) goto L_0x0319;
    L_0x0068:
        r5 = r18;
        r6 = r19;
    L_0x006c:
        r4.moveToNext();	 Catch:{ Exception -> 0x02e9, all -> 0x02df }
        r16 = r8;
        r14 = r5;
        r15 = r6;
        goto L_0x0035;
    L_0x0074:
        r5 = r14;
        r6 = r15;
    L_0x0076:
        if (r4 == 0) goto L_0x0314;
    L_0x0078:
        r4.close();	 Catch:{ Exception -> 0x0117 }
        r18 = r5;
        r10 = r6;
    L_0x007e:
        if (r18 != 0) goto L_0x013f;
    L_0x0080:
        r11 = 0;
        r4 = com.baidu.location.c.k.b.ROAD;	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r0 = r31;
        r5 = r0.c;	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r6 = r32;
        r8 = r34;
        r4 = r4.a(r5, r6, r8);	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r0 = r31;
        r5 = r0.d;	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r6 = 0;
        r19 = r5.rawQuery(r4, r6);	 Catch:{ Exception -> 0x025e, all -> 0x026d }
        r4 = r19.moveToFirst();	 Catch:{ Exception -> 0x02d6, all -> 0x02d4 }
        if (r4 == 0) goto L_0x0138;
    L_0x009e:
        r26 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r4 = "wgs842mc";
        r0 = r32;
        r2 = r34;
        r29 = com.baidu.location.Jni.if(r0, r2, r4);	 Catch:{ Exception -> 0x02d6, all -> 0x02d4 }
        r4 = r10;
    L_0x00af:
        r5 = r19.isAfterLast();	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        if (r5 != 0) goto L_0x0139;
    L_0x00b5:
        r5 = 2;
        r0 = r19;
        r28 = r0.getString(r5);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = 3;
        r0 = r19;
        r6 = r0.getDouble(r5);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = 4;
        r0 = r19;
        r8 = r0.getDouble(r5);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = "wgs842mc";
        r5 = com.baidu.location.Jni.if(r6, r8, r5);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r6 = 5;
        r0 = r19;
        r6 = r0.getDouble(r6);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r8 = 6;
        r0 = r19;
        r8 = r0.getDouble(r8);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r10 = "wgs842mc";
        r16 = com.baidu.location.Jni.if(r6, r8, r10);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r6 = 0;
        r6 = r29[r6];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r8 = 1;
        r8 = r29[r8];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r10 = 0;
        r10 = r5[r10];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r12 = 1;
        r12 = r5[r12];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = 0;
        r14 = r16[r5];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = 1;
        r16 = r16[r5];	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = r31;
        r6 = r5.a(r6, r8, r10, r12, r14, r16);	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = (r6 > r26 ? 1 : (r6 == r26 ? 0 : -1));
        if (r5 >= 0) goto L_0x030f;
    L_0x0102:
        r5 = com.baidu.location.c.k.b.ROAD;	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r5 = r5.e;	 Catch:{ Exception -> 0x02db, all -> 0x02d4 }
        r8 = (double) r5;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 > 0) goto L_0x030f;
    L_0x010d:
        r4 = r6;
        r10 = r28;
    L_0x0110:
        r19.moveToNext();	 Catch:{ Exception -> 0x02d6, all -> 0x02d4 }
        r26 = r4;
        r4 = r10;
        goto L_0x00af;
    L_0x0117:
        r4 = move-exception;
        r18 = r5;
        r10 = r6;
        goto L_0x007e;
    L_0x011d:
        r4 = move-exception;
        r4 = r10;
        r5 = r11;
        r6 = r12;
    L_0x0121:
        if (r4 == 0) goto L_0x0314;
    L_0x0123:
        r4.close();	 Catch:{ Exception -> 0x012b }
        r18 = r5;
        r10 = r6;
        goto L_0x007e;
    L_0x012b:
        r4 = move-exception;
        r18 = r5;
        r10 = r6;
        goto L_0x007e;
    L_0x0131:
        r4 = move-exception;
    L_0x0132:
        if (r10 == 0) goto L_0x0137;
    L_0x0134:
        r10.close();	 Catch:{ Exception -> 0x02a5 }
    L_0x0137:
        throw r4;
    L_0x0138:
        r4 = r10;
    L_0x0139:
        if (r19 == 0) goto L_0x030c;
    L_0x013b:
        r19.close();	 Catch:{ Exception -> 0x025a }
        r10 = r4;
    L_0x013f:
        r4 = com.baidu.location.c.k.b.AREA;
        r0 = r31;
        r5 = r0.c;
        r6 = r32;
        r8 = r34;
        r5 = r4.a(r5, r6, r8);
        r4 = 0;
        r0 = r31;
        r6 = r0.d;	 Catch:{ Exception -> 0x0276, all -> 0x0299 }
        r7 = 0;
        r4 = r6.rawQuery(r5, r7);	 Catch:{ Exception -> 0x0276, all -> 0x0299 }
        r5 = r4.moveToFirst();	 Catch:{ Exception -> 0x0276, all -> 0x02af }
        if (r5 == 0) goto L_0x02fe;
    L_0x015d:
        r5 = r4.isAfterLast();	 Catch:{ Exception -> 0x0276, all -> 0x02af }
        if (r5 != 0) goto L_0x02fe;
    L_0x0163:
        r5 = "country";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x0276, all -> 0x02af }
        r9 = r4.getString(r5);	 Catch:{ Exception -> 0x0276, all -> 0x02af }
        r5 = "countrycode";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x02b6, all -> 0x02af }
        r8 = r4.getString(r5);	 Catch:{ Exception -> 0x02b6, all -> 0x02af }
        r5 = "province";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x02c0, all -> 0x02af }
        r7 = r4.getString(r5);	 Catch:{ Exception -> 0x02c0, all -> 0x02af }
        r5 = "city";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x02c8, all -> 0x02af }
        r6 = r4.getString(r5);	 Catch:{ Exception -> 0x02c8, all -> 0x02af }
        r5 = "citycode";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Exception -> 0x02ce, all -> 0x02af }
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x02ce, all -> 0x02af }
        r11 = "district";
        r11 = r4.getColumnIndex(r11);	 Catch:{ Exception -> 0x02d2, all -> 0x02af }
        r25 = r4.getString(r11);	 Catch:{ Exception -> 0x02d2, all -> 0x02af }
        r11 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r25;
    L_0x01ac:
        if (r4 == 0) goto L_0x01b1;
    L_0x01ae:
        r4.close();	 Catch:{ Exception -> 0x02aa }
    L_0x01b1:
        if (r11 == 0) goto L_0x01c1;
    L_0x01b3:
        r4 = new java.lang.String;
        r11 = r11.getBytes();
        r11 = com.baidu.location.f.b.b.a(r11);
        r4.<init>(r11);
        r11 = r4;
    L_0x01c1:
        if (r9 == 0) goto L_0x01d1;
    L_0x01c3:
        r4 = new java.lang.String;
        r9 = r9.getBytes();
        r9 = com.baidu.location.f.b.b.a(r9);
        r4.<init>(r9);
        r9 = r4;
    L_0x01d1:
        if (r8 == 0) goto L_0x01e1;
    L_0x01d3:
        r4 = new java.lang.String;
        r8 = r8.getBytes();
        r8 = com.baidu.location.f.b.b.a(r8);
        r4.<init>(r8);
        r8 = r4;
    L_0x01e1:
        if (r7 == 0) goto L_0x01f1;
    L_0x01e3:
        r4 = new java.lang.String;
        r7 = r7.getBytes();
        r7 = com.baidu.location.f.b.b.a(r7);
        r4.<init>(r7);
        r7 = r4;
    L_0x01f1:
        if (r6 == 0) goto L_0x0201;
    L_0x01f3:
        r4 = new java.lang.String;
        r6 = r6.getBytes();
        r6 = com.baidu.location.f.b.b.a(r6);
        r4.<init>(r6);
        r6 = r4;
    L_0x0201:
        if (r5 == 0) goto L_0x0211;
    L_0x0203:
        r4 = new java.lang.String;
        r5 = r5.getBytes();
        r5 = com.baidu.location.f.b.b.a(r5);
        r4.<init>(r5);
        r5 = r4;
    L_0x0211:
        if (r10 == 0) goto L_0x0221;
    L_0x0213:
        r4 = new java.lang.String;
        r10 = r10.getBytes();
        r10 = com.baidu.location.f.b.b.a(r10);
        r4.<init>(r10);
        r10 = r4;
    L_0x0221:
        if (r18 == 0) goto L_0x02f1;
    L_0x0223:
        r4 = new java.lang.String;
        r12 = r18.getBytes();
        r12 = com.baidu.location.f.b.b.a(r12);
        r4.<init>(r12);
    L_0x0230:
        r12 = new com.baidu.location.a$a;
        r12.<init>();
        r11 = r12.country(r11);
        r9 = r11.countryCode(r9);
        r8 = r9.province(r8);
        r7 = r8.city(r7);
        r6 = r7.cityCode(r6);
        r5 = r6.district(r5);
        r5 = r5.street(r10);
        r4 = r5.streetNumber(r4);
        r4 = r4.build();
        return r4;
    L_0x025a:
        r5 = move-exception;
        r10 = r4;
        goto L_0x013f;
    L_0x025e:
        r4 = move-exception;
        r5 = r11;
        r4 = r10;
    L_0x0261:
        if (r5 == 0) goto L_0x030c;
    L_0x0263:
        r5.close();	 Catch:{ Exception -> 0x0269 }
        r10 = r4;
        goto L_0x013f;
    L_0x0269:
        r5 = move-exception;
        r10 = r4;
        goto L_0x013f;
    L_0x026d:
        r4 = move-exception;
        r19 = r11;
    L_0x0270:
        if (r19 == 0) goto L_0x0275;
    L_0x0272:
        r19.close();	 Catch:{ Exception -> 0x02a8 }
    L_0x0275:
        throw r4;
    L_0x0276:
        r5 = move-exception;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        r8 = r23;
        r9 = r24;
    L_0x0281:
        if (r4 == 0) goto L_0x02f5;
    L_0x0283:
        r4.close();	 Catch:{ Exception -> 0x028f }
        r11 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r25;
        goto L_0x01b1;
    L_0x028f:
        r4 = move-exception;
        r11 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r25;
        goto L_0x01b1;
    L_0x0299:
        r5 = move-exception;
        r30 = r5;
        r5 = r4;
        r4 = r30;
    L_0x029f:
        if (r5 == 0) goto L_0x02a4;
    L_0x02a1:
        r5.close();	 Catch:{ Exception -> 0x02ad }
    L_0x02a4:
        throw r4;
    L_0x02a5:
        r5 = move-exception;
        goto L_0x0137;
    L_0x02a8:
        r5 = move-exception;
        goto L_0x0275;
    L_0x02aa:
        r4 = move-exception;
        goto L_0x01b1;
    L_0x02ad:
        r5 = move-exception;
        goto L_0x02a4;
    L_0x02af:
        r5 = move-exception;
        r30 = r5;
        r5 = r4;
        r4 = r30;
        goto L_0x029f;
    L_0x02b6:
        r5 = move-exception;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        r8 = r23;
        goto L_0x0281;
    L_0x02c0:
        r5 = move-exception;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        goto L_0x0281;
    L_0x02c8:
        r5 = move-exception;
        r5 = r20;
        r6 = r21;
        goto L_0x0281;
    L_0x02ce:
        r5 = move-exception;
        r5 = r20;
        goto L_0x0281;
    L_0x02d2:
        r11 = move-exception;
        goto L_0x0281;
    L_0x02d4:
        r4 = move-exception;
        goto L_0x0270;
    L_0x02d6:
        r4 = move-exception;
        r5 = r19;
        r4 = r10;
        goto L_0x0261;
    L_0x02db:
        r5 = move-exception;
        r5 = r19;
        goto L_0x0261;
    L_0x02df:
        r5 = move-exception;
        r10 = r4;
        r4 = r5;
        goto L_0x0132;
    L_0x02e4:
        r5 = move-exception;
        r5 = r11;
        r6 = r12;
        goto L_0x0121;
    L_0x02e9:
        r7 = move-exception;
        goto L_0x0121;
    L_0x02ec:
        r5 = move-exception;
        r5 = r14;
        r6 = r15;
        goto L_0x0121;
    L_0x02f1:
        r4 = r18;
        goto L_0x0230;
    L_0x02f5:
        r11 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r25;
        goto L_0x01b1;
    L_0x02fe:
        r5 = r25;
        r6 = r20;
        r7 = r21;
        r8 = r22;
        r9 = r23;
        r11 = r24;
        goto L_0x01ac;
    L_0x030c:
        r10 = r4;
        goto L_0x013f;
    L_0x030f:
        r10 = r4;
        r4 = r26;
        goto L_0x0110;
    L_0x0314:
        r18 = r5;
        r10 = r6;
        goto L_0x007e;
    L_0x0319:
        r8 = r16;
        r5 = r14;
        r6 = r15;
        goto L_0x006c;
    L_0x031f:
        r5 = r11;
        r6 = r12;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.k.a(double, double):com.baidu.location.a");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void a(org.json.JSONObject r9) {
        /*
        r8 = this;
        r0 = r8.d;
        if (r0 == 0) goto L_0x0076;
    L_0x0004:
        r0 = r8.d;
        r0 = r0.isOpen();
        if (r0 == 0) goto L_0x0076;
    L_0x000c:
        r0 = r8.d;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0.beginTransaction();	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r2 = com.baidu.location.c.k.b.a();	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r3 = r2.length;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0 = 0;
        r1 = r0;
    L_0x0018:
        if (r1 >= r3) goto L_0x007b;
    L_0x001a:
        r4 = r2[r1];	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0 = r4.g;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0 = r9.has(r0);	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        if (r0 == 0) goto L_0x0077;
    L_0x0026:
        r0 = "";
        r5 = r4.h;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r5 = r9.has(r5);	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        if (r5 == 0) goto L_0x003b;
    L_0x0033:
        r0 = r4.h;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0 = r9.getString(r0);	 Catch:{ Exception -> 0x0070, all -> 0x008e }
    L_0x003b:
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r5.<init>();	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r6 = r4.g;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r6 = r9.getJSONObject(r6);	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r7 = r4.a(r6);	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r5.add(r7);	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r7 = r4.i;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0 = r4.a(r6, r0, r7);	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r5.addAll(r0);	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r4 = r5.iterator();	 Catch:{ Exception -> 0x0070, all -> 0x008e }
    L_0x005e:
        r0 = r4.hasNext();	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        if (r0 == 0) goto L_0x0077;
    L_0x0064:
        r0 = r4.next();	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r5 = r8.d;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r5.execSQL(r0);	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        goto L_0x005e;
    L_0x0070:
        r0 = move-exception;
        r0 = r8.d;	 Catch:{ Exception -> 0x0097 }
        r0.endTransaction();	 Catch:{ Exception -> 0x0097 }
    L_0x0076:
        return;
    L_0x0077:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0018;
    L_0x007b:
        r0 = r8.d;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0 = -1;
        r8.e = r0;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0 = -1;
        r8.f = r0;	 Catch:{ Exception -> 0x0070, all -> 0x008e }
        r0 = r8.d;	 Catch:{ Exception -> 0x008c }
        r0.endTransaction();	 Catch:{ Exception -> 0x008c }
        goto L_0x0076;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0076;
    L_0x008e:
        r0 = move-exception;
        r1 = r8.d;	 Catch:{ Exception -> 0x0095 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0095 }
    L_0x0094:
        throw r0;
    L_0x0095:
        r1 = move-exception;
        goto L_0x0094;
    L_0x0097:
        r0 = move-exception;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.k.a(org.json.JSONObject):void");
    }

    boolean a() {
        Cursor rawQuery;
        Throwable th;
        Cursor cursor = null;
        if (this.a.l().l() && this.f == -1 && this.e == -1 && this.d != null && this.d.isOpen()) {
            try {
                rawQuery = this.d.rawQuery("SELECT COUNT(*) FROM RGCSITE;", null);
                try {
                    rawQuery.moveToFirst();
                    this.f = rawQuery.getInt(0);
                    cursor = this.d.rawQuery("SELECT COUNT(*) FROM RGCAREA;", null);
                    cursor.moveToFirst();
                    this.e = cursor.getInt(0);
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
                    return this.f == 0 ? false : false;
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
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (this.f == 0) {
                }
            } catch (Throwable th3) {
                th = th3;
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        if (this.f == 0 && this.e == 0) {
            return true;
        }
    }

    List b(double d, double d2) {
        Cursor rawQuery;
        Poi poi;
        Throwable th;
        Cursor cursor = null;
        List arrayList = new ArrayList();
        String a = b.POI.a(this.c, d, d2);
        Map hashMap = new HashMap();
        List arrayList2 = new ArrayList();
        try {
            rawQuery = this.d.rawQuery(a, null);
            try {
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        String string = rawQuery.getString(0);
                        String string2 = rawQuery.getString(2);
                        double d3 = rawQuery.getDouble(4);
                        double d4 = rawQuery.getDouble(5);
                        int i = rawQuery.getInt(6);
                        double c = c(d2, d, d4, d3);
                        if (c < ((double) b.POI.e)) {
                            hashMap.put(new Poi(new String(com.baidu.location.f.b.b.a(string.getBytes())), new String(com.baidu.location.f.b.b.a(string2.getBytes())), 0.0d), Integer.valueOf(a(i, Math.round((float) c))));
                        }
                        rawQuery.moveToNext();
                    }
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception e3) {
                    }
                }
                arrayList2.addAll(hashMap.entrySet());
                Collections.sort(arrayList2, new l(this));
                if (arrayList2.size() > 0) {
                    poi = (Poi) ((Entry) arrayList2.get(0)).getKey();
                    arrayList.add(new Poi(poi.getId(), poi.getName(), 1.0d));
                }
                return arrayList;
            } catch (Throwable th2) {
                cursor = rawQuery;
                th = th2;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            arrayList2.addAll(hashMap.entrySet());
            Collections.sort(arrayList2, new l(this));
            if (arrayList2.size() > 0) {
                poi = (Poi) ((Entry) arrayList2.get(0)).getKey();
                arrayList.add(new Poi(poi.getId(), poi.getName(), 1.0d));
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        arrayList2.addAll(hashMap.entrySet());
        Collections.sort(arrayList2, new l(this));
        if (arrayList2.size() > 0) {
            poi = (Poi) ((Entry) arrayList2.get(0)).getKey();
            arrayList.add(new Poi(poi.getId(), poi.getName(), 1.0d));
        }
        return arrayList;
    }

    JSONObject b() {
        Cursor cursor = null;
        Cursor cursor2 = null;
        JSONObject jSONObject = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        String str = "SELECT * FROM RGCUPDATE WHERE type=%d AND %d > timestamp+%d ORDER BY gridkey";
        String str2 = "UPDATE RGCUPDATE SET timestamp=timestamp+1 WHERE type = %d AND gridkey IN (%s)";
        try {
            if (this.d != null && this.d.isOpen()) {
                HashSet hashSet;
                String string;
                String[] strArr;
                JSONObject jSONObject2;
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                cursor2 = this.d.rawQuery(String.format(str, new Object[]{Integer.valueOf(0), Integer.valueOf(currentTimeMillis), Integer.valueOf(this.a.l().p())}), null);
                cursor = this.d.rawQuery(String.format(str, new Object[]{Integer.valueOf(1), Integer.valueOf(currentTimeMillis), Integer.valueOf(this.a.l().q())}), null);
                if (cursor2.moveToFirst()) {
                    hashSet = new HashSet();
                    while (!cursor2.isAfterLast()) {
                        str = cursor2.getString(0);
                        string = cursor2.getString(1);
                        jSONArray3.put(str);
                        hashSet.add(string);
                        if (stringBuffer2.length() > 0) {
                            stringBuffer2.append(",");
                        }
                        stringBuffer2.append("\"").append(str).append("\"");
                        cursor2.moveToNext();
                    }
                    strArr = new String[hashSet.size()];
                    hashSet.toArray(strArr);
                    for (Object put : strArr) {
                        jSONArray4.put(put);
                    }
                }
                if (cursor.moveToFirst()) {
                    hashSet = new HashSet();
                    while (!cursor.isAfterLast()) {
                        str = cursor.getString(0);
                        string = cursor.getString(1);
                        jSONArray.put(str);
                        hashSet.add(string);
                        if (stringBuffer.length() > 0) {
                            stringBuffer.append(",");
                        }
                        stringBuffer.append("\"").append(str).append("\"");
                        cursor.moveToNext();
                    }
                    strArr = new String[hashSet.size()];
                    hashSet.toArray(strArr);
                    for (Object put2 : strArr) {
                        jSONArray2.put(put2);
                    }
                }
                if (jSONArray3.length() != 0) {
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("gk", jSONArray3);
                    jSONObject2.put("ver", jSONArray4);
                    jSONObject.put("addr", jSONObject2);
                }
                if (jSONArray.length() != 0) {
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("gk", jSONArray);
                    jSONObject2.put("ver", jSONArray2);
                    jSONObject.put("poi", jSONObject2);
                }
            }
            if (stringBuffer2.length() > 0) {
                this.d.execSQL(String.format(Locale.US, str2, new Object[]{Integer.valueOf(0), stringBuffer2.toString()}));
            }
            if (stringBuffer.length() > 0) {
                this.d.execSQL(String.format(Locale.US, str2, new Object[]{Integer.valueOf(1), stringBuffer.toString()}));
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
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
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e4) {
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                }
            }
        } catch (Throwable th) {
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e6) {
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e7) {
                }
            }
        }
        return (jSONObject.has("poi") || jSONObject.has("addr")) ? jSONObject : null;
    }
}
