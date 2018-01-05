package com.vlocker.k;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.math.BigDecimal;

public class d extends SQLiteOpenHelper {
    private static d b;
    private SQLiteDatabase a;

    private d(Context context) {
        this(context, "redpacket.db", null, 1);
    }

    private d(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    private float e(int i) {
        return new BigDecimal((double) (((float) a(i)) / 14.0f)).setScale(1, 4).floatValue();
    }

    public int a(int i) {
        int i2;
        Exception e;
        Cursor cursor = null;
        try {
            this.a = getReadableDatabase();
            cursor = this.a.rawQuery("select sum(count) from redpacket where day='" + i + "'", null);
            i2 = 0;
            while (cursor.moveToNext()) {
                try {
                    i2 = cursor.getInt(0);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            a(this.a, cursor);
        } catch (Exception e3) {
            Exception exception = e3;
            i2 = 0;
            e = exception;
            try {
                e.printStackTrace();
                return i2;
            } finally {
                a(this.a, cursor);
            }
        }
        return i2;
    }

    public int a(String str, int i) {
        int i2;
        Exception e;
        Cursor cursor = null;
        try {
            this.a = getReadableDatabase();
            cursor = this.a.rawQuery("select * from redpacket where name='" + str + "' and day='" + i + "'", null);
            i2 = 0;
            while (cursor.moveToNext()) {
                try {
                    i2 = cursor.getInt(cursor.getColumnIndexOrThrow("count"));
                } catch (Exception e2) {
                    e = e2;
                }
            }
            a(this.a, cursor);
        } catch (Exception e3) {
            Exception exception = e3;
            i2 = 0;
            e = exception;
            try {
                e.printStackTrace();
                return i2;
            } finally {
                a(this.a, cursor);
            }
        }
        return i2;
    }

    public long a(String str) {
        try {
            this.a = getWritableDatabase();
            this.a.execSQL("insert into redpacket (id, name, day,count) values (?,?,?,?)", new Object[]{null, str, Integer.valueOf(1), Integer.valueOf(1)});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a(this.a, null);
        }
        return 0;
    }

    public void a() {
        try {
            this.a = getWritableDatabase();
            this.a.execSQL("delete from redpacket where day='0'");
            this.a.execSQL("update redpacket set day='0' where day='1'");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a(this.a, null);
        }
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

    public void a(String str, int i, int i2) {
        try {
            this.a = getWritableDatabase();
            this.a.execSQL("update redpacket set count='" + i + "' where name='" + str + "' and day='" + i2 + "'");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a(this.a, null);
        }
    }

    public int b(int i) {
        Cursor cursor = null;
        int i2 = 0;
        try {
            this.a = getReadableDatabase();
            cursor = this.a.rawQuery("select * from redpacket where day='" + i + "'", null);
            while (cursor.moveToNext()) {
                int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("count"));
                if (i3 <= i2) {
                    i3 = i2;
                }
                i2 = i3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLiteDatabase sQLiteDatabase = this.a;
            a(sQLiteDatabase, cursor);
        }
        return i2;
    }

    public int c(int i) {
        int i2;
        Exception e;
        Cursor cursor = null;
        try {
            this.a = getReadableDatabase();
            cursor = this.a.rawQuery("select count(*) from redpacket where day='" + i + "'", null);
            i2 = 0;
            while (cursor.moveToNext()) {
                try {
                    i2 = cursor.getInt(0);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            a(this.a, cursor);
        } catch (Exception e3) {
            Exception exception = e3;
            i2 = 0;
            e = exception;
            try {
                e.printStackTrace();
                return i2;
            } finally {
                a(this.a, cursor);
            }
        }
        return i2;
    }

    public String d(int i) {
        return "&pushUser=" + c(i) + "&pushRich=" + b(i) + "&push=" + a(i) + "&pushAvg=" + e(i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE redpacket ( id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT ,day INTEGER ,count INTEGER )");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS redpacket");
        onCreate(sQLiteDatabase);
    }
}
