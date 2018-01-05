package com.baidu.location.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.h;
import com.baidu.location.b.q;
import com.baidu.location.e.r;
import com.baidu.location.h.g;
import com.baidu.location.h.i;
import com.baidu.location.h.m;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public final class d {
    private static d a = null;
    private static final String k = (Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/");
    private static final String l = (Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/" + "/ls.db");
    private String b = null;
    private boolean c = false;
    private boolean d = false;
    private double e = 0.0d;
    private double f = 0.0d;
    private double g = 0.0d;
    private double h = 0.0d;
    private double i = 0.0d;
    private volatile boolean j = false;
    private Handler m = new Handler();

    class a extends AsyncTask {
        final /* synthetic */ d a;

        private a(d dVar) {
            this.a = dVar;
        }

        protected Boolean a(Boolean... boolArr) {
            SQLiteDatabase sQLiteDatabase = null;
            if (boolArr.length != 4) {
                return Boolean.valueOf(false);
            }
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(d.l, null);
            } catch (Exception e) {
            }
            if (sQLiteDatabase == null) {
                return Boolean.valueOf(false);
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            try {
                sQLiteDatabase.beginTransaction();
                if (boolArr[0].booleanValue()) {
                    try {
                        sQLiteDatabase.execSQL("delete from wof where ac < " + (currentTimeMillis - 35));
                    } catch (Exception e2) {
                    }
                }
                if (boolArr[1].booleanValue()) {
                    try {
                        sQLiteDatabase.execSQL("delete from bdcltb09 where ac is NULL or ac < " + (currentTimeMillis - 130));
                    } catch (Exception e3) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            } catch (Exception e4) {
            }
            return Boolean.valueOf(true);
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((Boolean[]) objArr);
        }
    }

    class b extends AsyncTask {
        final /* synthetic */ d a;

        private b(d dVar) {
            this.a = dVar;
        }

        protected Boolean a(Object... objArr) {
            SQLiteDatabase sQLiteDatabase = null;
            if (objArr.length != 4) {
                this.a.j = false;
                return Boolean.valueOf(false);
            }
            SQLiteDatabase openOrCreateDatabase;
            try {
                openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(d.l, null);
            } catch (Exception e) {
                openOrCreateDatabase = sQLiteDatabase;
            }
            if (openOrCreateDatabase == null) {
                this.a.j = false;
                return Boolean.valueOf(false);
            }
            try {
                openOrCreateDatabase.beginTransaction();
                this.a.a((String) objArr[0], (i) objArr[1], openOrCreateDatabase);
                this.a.a((g) objArr[2], (BDLocation) objArr[3], openOrCreateDatabase);
                openOrCreateDatabase.setTransactionSuccessful();
                openOrCreateDatabase.endTransaction();
                openOrCreateDatabase.close();
            } catch (Exception e2) {
            }
            this.a.j = false;
            return Boolean.valueOf(true);
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a(objArr);
        }
    }

    private d() {
        try {
            File file = new File(k);
            File file2 = new File(l);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            if (file2.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file2, null);
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
                openOrCreateDatabase.setVersion(1);
                openOrCreateDatabase.close();
            }
        } catch (Exception e) {
        }
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    private void a(g gVar, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
        if (bDLocation != null && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
            if (("wf".equals(bDLocation.getNetworkLocationType()) || bDLocation.getRadius() < 300.0f) && gVar.a != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
                System.currentTimeMillis();
                int i = 0;
                for (ScanResult scanResult : gVar.a) {
                    if (scanResult.level != 0) {
                        int i2 = i + 1;
                        if (i2 <= 6) {
                            ContentValues contentValues = new ContentValues();
                            String J = Jni.J(scanResult.BSSID.replace(":", ""));
                            try {
                                int i3;
                                int i4;
                                double d;
                                Object obj;
                                double d2;
                                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from wof where id = \"" + J + "\";", null);
                                if (rawQuery == null || !rawQuery.moveToFirst()) {
                                    i3 = 0;
                                    i4 = 0;
                                    d = 0.0d;
                                    obj = null;
                                    d2 = 0.0d;
                                } else {
                                    double d3 = rawQuery.getDouble(1) - 113.2349d;
                                    double d4 = rawQuery.getDouble(2) - 432.1238d;
                                    int i5 = rawQuery.getInt(4);
                                    i3 = rawQuery.getInt(5);
                                    i4 = i5;
                                    d = d3;
                                    double d5 = d4;
                                    obj = 1;
                                    d2 = d5;
                                }
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                                if (obj == null) {
                                    contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                                    contentValues.put("time", Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                    contentValues.put("bc", Integer.valueOf(1));
                                    contentValues.put("cc", Integer.valueOf(1));
                                    contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                                    contentValues.put("id", J);
                                    sQLiteDatabase.insert("wof", null, contentValues);
                                } else if (i3 == 0) {
                                    i = i2;
                                } else {
                                    float[] fArr = new float[1];
                                    Location.distanceBetween(d2, d, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                                    if (fArr[0] > 1500.0f) {
                                        int i6 = i3 + 1;
                                        if (i6 <= 10 || i6 <= i4 * 3) {
                                            contentValues.put("cc", Integer.valueOf(i6));
                                        } else {
                                            contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                                            contentValues.put("time", Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                            contentValues.put("bc", Integer.valueOf(1));
                                            contentValues.put("cc", Integer.valueOf(1));
                                            contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                                        }
                                    } else {
                                        d2 = ((d2 * ((double) i4)) + bDLocation.getLatitude()) / ((double) (i4 + 1));
                                        ContentValues contentValues2 = contentValues;
                                        contentValues2.put("mktime", Double.valueOf((((d * ((double) i4)) + bDLocation.getLongitude()) / ((double) (i4 + 1))) + 113.2349d));
                                        contentValues.put("time", Double.valueOf(d2 + 432.1238d));
                                        contentValues.put("bc", Integer.valueOf(i4 + 1));
                                        contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                                    }
                                    try {
                                        if (sQLiteDatabase.update("wof", contentValues, "id = \"" + J + "\"", null) <= 0) {
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                            } catch (Exception e2) {
                            }
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r8, android.database.sqlite.SQLiteDatabase r9) {
        /*
        r7 = this;
        r0 = 0;
        if (r8 == 0) goto L_0x000b;
    L_0x0003:
        r1 = r7.b;
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r1 = 0;
        r7.c = r1;
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r1.<init>();	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r2 = "select * from bdcltb09 where id = \"";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r1 = r1.append(r8);	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r2 = "\";";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r2 = 0;
        r0 = r9.rawQuery(r1, r2);	 Catch:{ Exception -> 0x0069, all -> 0x0072 }
        r7.b = r8;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        if (r1 == 0) goto L_0x0061;
    L_0x0037:
        r1 = 1;
        r2 = r0.getDouble(r1);	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r4 = 4653148304163072062; // 0x40934dbaacd9e83e float:-6.193295E-12 double:1235.4323;
        r2 = r2 - r4;
        r7.f = r2;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r1 = 2;
        r2 = r0.getDouble(r1);	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r4 = 4661478502002851840; // 0x40b0e60000000000 float:0.0 double:4326.0;
        r2 = r2 - r4;
        r7.e = r2;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r1 = 3;
        r2 = r0.getDouble(r1);	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r4 = 4657424210545395263; // 0x40a27ea4b5dcc63f float:-1.6448975E-6 double:2367.3217;
        r2 = r2 - r4;
        r7.g = r2;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
        r1 = 1;
        r7.c = r1;	 Catch:{ Exception -> 0x0069, all -> 0x007e }
    L_0x0061:
        if (r0 == 0) goto L_0x000b;
    L_0x0063:
        r0.close();	 Catch:{ Exception -> 0x0067 }
        goto L_0x000b;
    L_0x0067:
        r0 = move-exception;
        goto L_0x000b;
    L_0x0069:
        r1 = move-exception;
        if (r0 == 0) goto L_0x000b;
    L_0x006c:
        r0.close();	 Catch:{ Exception -> 0x0070 }
        goto L_0x000b;
    L_0x0070:
        r0 = move-exception;
        goto L_0x000b;
    L_0x0072:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0076:
        if (r1 == 0) goto L_0x007b;
    L_0x0078:
        r1.close();	 Catch:{ Exception -> 0x007c }
    L_0x007b:
        throw r0;
    L_0x007c:
        r1 = move-exception;
        goto L_0x007b;
    L_0x007e:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.d.a(java.lang.String, android.database.sqlite.SQLiteDatabase):void");
    }

    private void a(String str, i iVar, SQLiteDatabase sQLiteDatabase) {
        Object obj = null;
        double d = 0.0d;
        if (iVar.c() && r.b().g()) {
            System.currentTimeMillis();
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            String h = iVar.h();
            try {
                double parseDouble;
                float parseFloat;
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getJSONObject("result").getString("error"));
                int i;
                if (parseInt == BDLocation.TypeNetWorkLocation) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    if (jSONObject2.has("clf")) {
                        String string = jSONObject2.getString("clf");
                        if (string.equals("0")) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("point");
                            d = Double.parseDouble(jSONObject3.getString("x"));
                            parseDouble = Double.parseDouble(jSONObject3.getString("y"));
                            parseFloat = Float.parseFloat(jSONObject2.getString("radius"));
                        } else {
                            String[] split = string.split("\\|");
                            d = Double.parseDouble(split[0]);
                            parseDouble = Double.parseDouble(split[1]);
                            parseFloat = Float.parseFloat(split[2]);
                        }
                    }
                    i = 1;
                    parseFloat = 0.0f;
                    parseDouble = 0.0d;
                } else {
                    if (parseInt == BDLocation.TypeServerError) {
                        sQLiteDatabase.delete("bdcltb09", "id = \"" + h + "\"", null);
                        return;
                    }
                    i = 1;
                    parseFloat = 0.0f;
                    parseDouble = 0.0d;
                }
                if (obj == null) {
                    d += 1235.4323d;
                    parseDouble += 2367.3217d;
                    float f = 4326.0f + parseFloat;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("time", Double.valueOf(d));
                    contentValues.put("tag", Float.valueOf(f));
                    contentValues.put("type", Double.valueOf(parseDouble));
                    contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                    try {
                        if (sQLiteDatabase.update("bdcltb09", contentValues, "id = \"" + h + "\"", null) <= 0) {
                            contentValues.put("id", h);
                            sQLiteDatabase.insert("bdcltb09", null, contentValues);
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
    }

    private void a(String str, List list) {
        SQLiteDatabase sQLiteDatabase;
        if (str == null || str.equals(this.b)) {
            sQLiteDatabase = null;
        } else {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(l, null);
            a(str, sQLiteDatabase);
        }
        if (list != null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(l, null);
            }
            a(list, sQLiteDatabase);
        }
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            sQLiteDatabase.close();
        }
    }

    private void a(List list, SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        System.currentTimeMillis();
        this.d = false;
        if (list != null && sQLiteDatabase != null && list != null) {
            double d = 0.0d;
            double d2 = 0.0d;
            int i = 0;
            Object obj = null;
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            for (ScanResult scanResult : list) {
                if (i2 > 10) {
                    break;
                }
                if (i2 > 0) {
                    stringBuffer.append(",");
                }
                i2++;
                stringBuffer.append("\"").append(Jni.J(scanResult.BSSID.replace(":", ""))).append("\"");
            }
            Cursor cursor = null;
            Cursor rawQuery;
            try {
                rawQuery = sQLiteDatabase.rawQuery("select * from wof where id in (" + stringBuffer.toString() + ");", null);
                try {
                    if (rawQuery.moveToFirst()) {
                        int i3 = 0;
                        double[] dArr = null;
                        while (!rawQuery.isAfterLast()) {
                            double d3 = rawQuery.getDouble(1) - 113.2349d;
                            double d4 = rawQuery.getDouble(2) - 432.1238d;
                            int i4 = rawQuery.getInt(4);
                            int i5 = rawQuery.getInt(5);
                            if (i5 <= 8 || i5 <= i4) {
                                int i6;
                                double[] dArr2;
                                float[] fArr;
                                if (!this.c) {
                                    if (obj == null) {
                                        if (dArr != null) {
                                            int i7 = 0;
                                            while (i7 < i3) {
                                                Object obj2;
                                                double d5;
                                                double d6;
                                                fArr = new float[1];
                                                Location.distanceBetween(d4, d3, dArr[i7 + 1], dArr[i7], fArr);
                                                if (fArr[0] < 1000.0f) {
                                                    obj2 = 1;
                                                    d5 = d + dArr[i7];
                                                    d6 = dArr[i7 + 1] + d2;
                                                    i5 = i + 1;
                                                } else {
                                                    obj2 = obj;
                                                    i5 = i;
                                                    d6 = d2;
                                                    d5 = d;
                                                }
                                                i7 += 2;
                                                d2 = d6;
                                                d = d5;
                                                obj = obj2;
                                                i = i5;
                                            }
                                            if (obj == null) {
                                                if (i3 >= 8) {
                                                    break;
                                                }
                                                i4 = i3 + 1;
                                                dArr[i3] = d3;
                                                i3 = i4 + 1;
                                                dArr[i4] = d4;
                                                i6 = i3;
                                                dArr2 = dArr;
                                            } else {
                                                d += d3;
                                                d2 += d4;
                                                i++;
                                                i6 = i3;
                                                dArr2 = dArr;
                                            }
                                        } else {
                                            dArr = new double[8];
                                            i4 = i3 + 1;
                                            dArr[i3] = d3;
                                            i3 = i4 + 1;
                                            dArr[i4] = d4;
                                            i6 = i3;
                                            dArr2 = dArr;
                                        }
                                    } else {
                                        fArr = new float[1];
                                        Location.distanceBetween(d4, d3, d2 / ((double) i), d / ((double) i), fArr);
                                        if (fArr[0] > 1000.0f) {
                                            rawQuery.moveToNext();
                                        } else {
                                            i6 = i3;
                                            dArr2 = dArr;
                                        }
                                    }
                                } else {
                                    fArr = new float[1];
                                    Location.distanceBetween(d4, d3, this.g, this.f, fArr);
                                    if (((double) fArr[0]) > this.e + 2000.0d) {
                                        rawQuery.moveToNext();
                                    } else {
                                        obj = 1;
                                        d += d3;
                                        d2 += d4;
                                        i++;
                                        i6 = i3;
                                        dArr2 = dArr;
                                    }
                                }
                                if (i > 4) {
                                    break;
                                }
                                rawQuery.moveToNext();
                                i3 = i6;
                                dArr = dArr2;
                            } else {
                                rawQuery.moveToNext();
                            }
                        }
                        if (i > 0) {
                            this.d = true;
                            this.h = d / ((double) i);
                            this.i = d2 / ((double) i);
                        }
                    }
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    cursor = rawQuery;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                    }
                }
            } catch (Throwable th3) {
                rawQuery = null;
                th = th3;
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        }
    }

    private String b(boolean z) {
        double d;
        double d2;
        boolean z2;
        boolean z3;
        double d3 = 0.0d;
        if (this.d) {
            d = this.h;
            d2 = this.i;
            d3 = 246.4d;
            z2 = true;
            z3 = true;
        } else if (this.c) {
            d = this.f;
            d2 = this.g;
            d3 = this.e;
            z2 = r.b().g();
            z3 = true;
        } else {
            z2 = false;
            z3 = false;
            d2 = 0.0d;
            d = 0.0d;
        }
        if (!z3) {
            return z ? "{\"result\":{\"time\":\"" + h.a() + "\",\"error\":\"67\"}}" : "{\"result\":{\"time\":\"" + h.a() + "\",\"error\":\"63\"}}";
        } else {
            if (z) {
                return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + h.a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Boolean.valueOf(true)});
            }
            return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + h.a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Boolean.valueOf(z2)});
        }
    }

    private void d() {
        SQLiteDatabase openOrCreateDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        boolean z = true;
        try {
            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(l, null);
        } catch (Exception e) {
            openOrCreateDatabase = sQLiteDatabase;
        }
        if (openOrCreateDatabase != null) {
            try {
                long queryNumEntries = DatabaseUtils.queryNumEntries(openOrCreateDatabase, "wof");
                long queryNumEntries2 = DatabaseUtils.queryNumEntries(openOrCreateDatabase, "bdcltb09");
                boolean z2 = queryNumEntries > 10000;
                if (queryNumEntries2 <= 10000) {
                    z = false;
                }
                if (z2 || z) {
                    new a().execute(new Boolean[]{Boolean.valueOf(z2), Boolean.valueOf(z)});
                }
                openOrCreateDatabase.close();
            } catch (Exception e2) {
            }
        }
    }

    public BDLocation a(String str, List list, boolean z) {
        String str2 = "{\"result\":\"null\"}";
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        String str3 = (FutureTask) newSingleThreadExecutor.submit(new f(this, str, list));
        try {
            str3 = (String) str3.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            str3.cancel(true);
            str3 = str2;
            return new BDLocation(str3);
        } catch (ExecutionException e2) {
            str3.cancel(true);
            str3 = str2;
            return new BDLocation(str3);
        } catch (TimeoutException e3) {
            if (z) {
                q.a().a("old offlineLocation Timeout Exception!");
            }
            str3.cancel(true);
            str3 = str2;
            return new BDLocation(str3);
        } finally {
            newSingleThreadExecutor.shutdown();
        }
        return new BDLocation(str3);
    }

    public BDLocation a(boolean z) {
        i f = com.baidu.location.h.d.a().f();
        String str = null;
        if (f != null) {
            str = f.h();
        }
        g j = m.a().j();
        BDLocation a = a(str, j.a, true);
        if (a != null && a.getLocType() == 66) {
            StringBuffer stringBuffer = new StringBuffer(IXAdIOUtils.BUFFER_SIZE);
            stringBuffer.append(String.format(Locale.CHINA, "&ofl=%f|%f|%f", new Object[]{Double.valueOf(a.getLatitude()), Double.valueOf(a.getLongitude()), Float.valueOf(a.getRadius())}));
            if (j != null && j.a() > 0) {
                stringBuffer.append("&wf=");
                stringBuffer.append(j.c(15));
            }
            if (f != null) {
                stringBuffer.append(f.j());
            }
            stringBuffer.append("&uptype=oldoff");
            stringBuffer.append(com.baidu.location.b.b.a().a(false));
            stringBuffer.append(com.baidu.location.e.d.a().c());
            q.a(q.a, Jni.H(stringBuffer.toString()));
        }
        return a;
    }

    public void a(String str, i iVar, g gVar, BDLocation bDLocation) {
        int i = (iVar.c() && r.b().g()) ? 0 : true;
        int i2 = (bDLocation == null || bDLocation.getLocType() != BDLocation.TypeNetWorkLocation || (!"wf".equals(bDLocation.getNetworkLocationType()) && bDLocation.getRadius() >= 300.0f)) ? true : 0;
        if (gVar.a == null) {
            i2 = true;
        }
        if ((i == 0 || r0 == 0) && !this.j) {
            this.j = true;
            new b().execute(new Object[]{str, iVar, gVar, bDLocation});
        }
    }

    public void b() {
        this.m.postDelayed(new e(this), 3000);
    }
}
