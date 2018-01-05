package com.vlocker.search;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ao extends SQLiteOpenHelper {
    private static ao b;
    private static final String c = ("CREATE TABLE bd_search_history ( " + M_bd_BaiduHintsInfo.a + " INTEGER ," + M_bd_BaiduHintsInfo.b + " TEXT PRIMARY KEY " + ")");
    private SQLiteDatabase a;
    private final String d;

    private ao(Context context) {
        this(context, "bd_search_history.db", null, 1);
    }

    private ao(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.d = "M_BD_BAIDUSEARCH HISTORY DAO";
    }

    public static ao a(Context context) {
        if (b == null) {
            b = new ao(context);
        }
        return b;
    }

    public long a(M_bd_BaiduHintsInfo m_bd_BaiduHintsInfo) {
        try {
            this.a = getWritableDatabase();
            this.a.execSQL("insert into bd_search_history (_id, _keyworld) values (?,?)", new Object[]{Integer.valueOf(m_bd_BaiduHintsInfo.a()), m_bd_BaiduHintsInfo.b()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long a(String str) {
        try {
            this.a = getWritableDatabase();
            String[] strArr = new String[]{str};
            this.a.execSQL("DELETE FROM bd_search_history  where _keyworld = ?", strArr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a(this.a, null);
        }
        return (long) 0;
    }

    public List a() {
        Cursor query;
        Exception e;
        Throwable th;
        List arrayList = new ArrayList();
        try {
            this.a = getReadableDatabase();
            query = this.a.query("bd_search_history", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    M_bd_BaiduHintsInfo m_bd_BaiduHintsInfo = new M_bd_BaiduHintsInfo();
                    m_bd_BaiduHintsInfo.a(query.getInt(query.getColumnIndexOrThrow(M_bd_BaiduHintsInfo.a)));
                    m_bd_BaiduHintsInfo.a(query.getString(query.getColumnIndexOrThrow(M_bd_BaiduHintsInfo.b)));
                    arrayList.add(m_bd_BaiduHintsInfo);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            Collections.reverse(arrayList);
            a(this.a, query);
        } catch (Exception e3) {
            e = e3;
            query = null;
            try {
                e.printStackTrace();
                a(this.a, query);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                a(this.a, query);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            a(this.a, query);
            throw th;
        }
        return arrayList;
    }

    public void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e) {
                if (sQLiteDatabase != null) {
                    try {
                        if (sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        if (sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            } catch (Exception e22) {
                e22.printStackTrace();
            }
        }
    }

    public void b() {
        try {
            this.a = getWritableDatabase();
            this.a.delete("bd_search_history", null, null);
        } catch (Exception e) {
            a(this.a, null);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(c);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bd_search_history");
        onCreate(sQLiteDatabase);
    }
}
