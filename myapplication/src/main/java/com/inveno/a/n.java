package com.inveno.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.ArrayList;
import java.util.List;

class n {
    private static n a;
    private p b;
    private Handler c = new Handler(Looper.getMainLooper());
    private Runnable d = new o(this);

    private n() {
        if (m.c) {
            this.b = new p(new q(i.a));
        } else {
            this.b = new p(i.a);
        }
    }

    private long a(String str, ContentValues contentValues) {
        long j = 0;
        try {
            j = this.b.getWritableDatabase().insert(str, null, contentValues);
        } catch (Exception e) {
        } finally {
            b();
        }
        return j;
    }

    static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (a == null) {
                a = new n();
            }
            nVar = a;
        }
        return nVar;
    }

    private void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
            }
        }
    }

    private void b() {
        this.c.removeCallbacks(this.d);
        this.c.postDelayed(this.d, 120000);
    }

    long a(ap apVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("product_id", apVar.c);
        contentValues.put("promotion", apVar.d);
        contentValues.put("fuid", apVar.e);
        contentValues.put("uid", apVar.f);
        contentValues.put("app_ver", apVar.g);
        contentValues.put("sdk_ver", apVar.h);
        contentValues.put("api_ver", apVar.i);
        contentValues.put("tk", apVar.j);
        contentValues.put("report_time", Long.valueOf(apVar.k));
        contentValues.put("network", Integer.valueOf(apVar.l));
        contentValues.put("sid", Integer.valueOf(apVar.m));
        contentValues.put("seq", Integer.valueOf(apVar.n));
        contentValues.put("imei", apVar.o);
        contentValues.put("aid", apVar.p);
        contentValues.put("brand", apVar.q);
        contentValues.put("model", apVar.r);
        contentValues.put(IXAdRequestInfo.OSV, apVar.s);
        contentValues.put("platform", apVar.t);
        contentValues.put("language", apVar.u);
        contentValues.put("app_lan", apVar.v);
        contentValues.put("mcc", apVar.w);
        contentValues.put("mnc", apVar.x);
        contentValues.put("nmcc", apVar.y);
        contentValues.put("nmnc", apVar.z);
        contentValues.put("upack", apVar.A);
        contentValues.put("referrer", apVar.B);
        contentValues.put("data", apVar.C);
        return a("report_data", contentValues);
    }

    List a(int i) {
        Cursor query;
        Cursor cursor;
        Throwable th;
        List arrayList = new ArrayList();
        try {
            query = this.b.getReadableDatabase().query("report_data", null, null, null, null, null, String.format("%s DESC, %s DESC", new Object[]{"report_time", "seq"}), i > 0 ? String.valueOf(i) : null);
            try {
                int columnIndex = query.getColumnIndex("_id");
                int columnIndex2 = query.getColumnIndex("product_id");
                int columnIndex3 = query.getColumnIndex("promotion");
                int columnIndex4 = query.getColumnIndex("fuid");
                int columnIndex5 = query.getColumnIndex("uid");
                int columnIndex6 = query.getColumnIndex("app_ver");
                int columnIndex7 = query.getColumnIndex("sdk_ver");
                int columnIndex8 = query.getColumnIndex("api_ver");
                int columnIndex9 = query.getColumnIndex("tk");
                int columnIndex10 = query.getColumnIndex("report_time");
                int columnIndex11 = query.getColumnIndex("network");
                int columnIndex12 = query.getColumnIndex("sid");
                int columnIndex13 = query.getColumnIndex("seq");
                int columnIndex14 = query.getColumnIndex("imei");
                int columnIndex15 = query.getColumnIndex("aid");
                int columnIndex16 = query.getColumnIndex("brand");
                int columnIndex17 = query.getColumnIndex("model");
                int columnIndex18 = query.getColumnIndex(IXAdRequestInfo.OSV);
                int columnIndex19 = query.getColumnIndex("platform");
                int columnIndex20 = query.getColumnIndex("language");
                int columnIndex21 = query.getColumnIndex("app_lan");
                int columnIndex22 = query.getColumnIndex("mcc");
                int columnIndex23 = query.getColumnIndex("mnc");
                int columnIndex24 = query.getColumnIndex("nmcc");
                int columnIndex25 = query.getColumnIndex("nmnc");
                int columnIndex26 = query.getColumnIndex("upack");
                int columnIndex27 = query.getColumnIndex("referrer");
                int columnIndex28 = query.getColumnIndex("data");
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    ar arVar = new ar((long) query.getInt(columnIndex), 2, query.getString(columnIndex2), query.getString(columnIndex3), query.getString(columnIndex5), query.getString(columnIndex6), query.getString(columnIndex8), query.getString(columnIndex9), query.getLong(columnIndex10), query.getInt(columnIndex11), query.getInt(columnIndex12), query.getInt(columnIndex13), query.getString(columnIndex14), query.getString(columnIndex15), query.getString(columnIndex16), query.getString(columnIndex17), query.getString(columnIndex19), query.getString(columnIndex21), query.getString(columnIndex26), query.getString(columnIndex28));
                    arVar.a(query.getString(columnIndex4));
                    arVar.b(query.getString(columnIndex7));
                    arVar.c(query.getString(columnIndex18));
                    arVar.d(query.getString(columnIndex20));
                    arVar.e(query.getString(columnIndex22));
                    arVar.f(query.getString(columnIndex23));
                    arVar.g(query.getString(columnIndex24));
                    arVar.h(query.getString(columnIndex25));
                    arVar.i(query.getString(columnIndex27));
                    arrayList.add(arVar.a());
                    query.moveToNext();
                }
                a(query);
                b();
            } catch (Exception e) {
                cursor = query;
                a(cursor);
                b();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                a(query);
                b();
                throw th;
            }
        } catch (Exception e2) {
            cursor = null;
            a(cursor);
            b();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            a(query);
            b();
            throw th;
        }
        return arrayList;
    }

    int b(ap apVar) {
        int i = 0;
        try {
            i = this.b.getWritableDatabase().delete("report_data", "_id = ? ", new String[]{String.valueOf(apVar.a)});
        } catch (Exception e) {
        } finally {
            b();
        }
        return i;
    }
}
