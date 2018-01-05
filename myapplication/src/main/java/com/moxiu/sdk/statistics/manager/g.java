package com.moxiu.sdk.statistics.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import com.moxiu.sdk.statistics.a.a;
import com.moxiu.sdk.statistics.e.i;

public class g extends SQLiteOpenHelper {
    final /* synthetic */ e a;

    public g(e eVar, Context context) {
        this.a = eVar;
        super(context, "mxstat2.db", null, 1);
    }

    public long a(a aVar, long j) {
        i.a("insertItem");
        ContentValues contentValues = new ContentValues();
        contentValues.put("_posttype", Integer.valueOf(aVar.b().a()));
        contentValues.put("_sertype", Integer.valueOf(aVar.a()));
        contentValues.put("_verifyinfo", aVar.c());
        contentValues.put("_serdata", aVar.d());
        contentValues.put("_time", Long.valueOf(j));
        long j2 = -1;
        try {
            j2 = getWritableDatabase().insert("delay_table", null, contentValues);
        } catch (Throwable e) {
            i.a("insertItem Exception = ", e);
        }
        i.a("insertItem resultId = " + j2);
        return j2;
    }

    public Pair a() {
        Pair pair;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2 = null;
        i.a("getItem");
        Cursor query;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            try {
                query = readableDatabase.query("delay_table", null, "_time<?", new String[]{"" + System.currentTimeMillis()}, null, null, "_id", "1");
                try {
                    if (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex("_id"));
                        a b = a.b(query.getInt(query.getColumnIndex("_sertype")), query.getInt(query.getColumnIndex("_posttype")), query.getString(query.getColumnIndex("_verifyinfo")), query.getBlob(query.getColumnIndex("_serdata")));
                        if (b == null) {
                            a(readableDatabase, query);
                            return null;
                        }
                        pair = new Pair(Integer.valueOf(i), b);
                    } else {
                        pair = null;
                    }
                    a(readableDatabase, query);
                } catch (Throwable e) {
                    Throwable th2 = e;
                    cursor = query;
                    sQLiteDatabase = readableDatabase;
                    th = th2;
                    try {
                        i.a("getItem Exception = ", th);
                        a(sQLiteDatabase, cursor);
                        pair = null;
                        return pair;
                    } catch (Throwable th3) {
                        th = th3;
                        sQLiteDatabase2 = sQLiteDatabase;
                        query = cursor;
                        a(sQLiteDatabase2, query);
                        throw th;
                    }
                } catch (Throwable e2) {
                    sQLiteDatabase2 = readableDatabase;
                    th = e2;
                    a(sQLiteDatabase2, query);
                    throw th;
                }
            } catch (Throwable e22) {
                sQLiteDatabase = readableDatabase;
                th = e22;
                cursor = null;
                i.a("getItem Exception = ", th);
                a(sQLiteDatabase, cursor);
                pair = null;
                return pair;
            } catch (Throwable e222) {
                query = null;
                sQLiteDatabase2 = readableDatabase;
                th = e222;
                a(sQLiteDatabase2, query);
                throw th;
            }
        } catch (Exception e3) {
            th = e3;
            cursor = null;
            sQLiteDatabase = null;
            i.a("getItem Exception = ", th);
            a(sQLiteDatabase, cursor);
            pair = null;
            return pair;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            a(sQLiteDatabase2, query);
            throw th;
        }
        return pair;
    }

    public void a(long j) {
        i.a("deleteItem id = " + j);
        try {
            getWritableDatabase().delete("delay_table", "_id=?", new String[]{"" + j});
        } catch (Throwable e) {
            i.a("deleteItem Exception = ", e);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Throwable e) {
                i.a("close cursor Exception = ", e);
            }
        }
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable e2) {
                i.a("close db Exception = ", e2);
            }
        }
    }

    public int b() {
        Throwable th;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Throwable th2;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor2 = null;
        i.a("getCount");
        try {
            Cursor query;
            SQLiteDatabase readableDatabase = getReadableDatabase();
            try {
                query = readableDatabase.query("delay_table", null, null, null, null, null, null, null);
            } catch (Throwable e) {
                th = e;
                cursor = null;
                sQLiteDatabase = readableDatabase;
                th2 = th;
                try {
                    i.a("getCount Exception = ", th2);
                    a(sQLiteDatabase, cursor);
                    return -1;
                } catch (Throwable th3) {
                    th2 = th3;
                    Cursor cursor3 = cursor;
                    sQLiteDatabase2 = sQLiteDatabase;
                    cursor2 = cursor3;
                    a(sQLiteDatabase2, cursor2);
                    throw th2;
                }
            } catch (Throwable e2) {
                th = e2;
                sQLiteDatabase2 = readableDatabase;
                th2 = th;
                a(sQLiteDatabase2, cursor2);
                throw th2;
            }
            try {
                int count = query.getCount();
                a(readableDatabase, query);
                return count;
            } catch (Throwable e22) {
                sQLiteDatabase = readableDatabase;
                th2 = e22;
                cursor = query;
                i.a("getCount Exception = ", th2);
                a(sQLiteDatabase, cursor);
                return -1;
            } catch (Throwable e222) {
                cursor2 = query;
                th = e222;
                sQLiteDatabase2 = readableDatabase;
                th2 = th;
                a(sQLiteDatabase2, cursor2);
                throw th2;
            }
        } catch (Exception e3) {
            th2 = e3;
            cursor = null;
            i.a("getCount Exception = ", th2);
            a(sQLiteDatabase, cursor);
            return -1;
        } catch (Throwable th4) {
            th2 = th4;
            sQLiteDatabase2 = null;
            a(sQLiteDatabase2, cursor2);
            throw th2;
        }
    }

    public void c() {
        i.a("clearDB");
        try {
            getWritableDatabase().delete("delay_table", null, null);
        } catch (Throwable e) {
            i.a("clearDB Exception = ", e);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE delay_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,_posttype INTEGER,_sertype INTEGER,_verifyinfo TEXT,_serdata BLOB,_time INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS delay_table");
        onCreate(sQLiteDatabase);
    }
}
