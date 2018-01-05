package com.vlocker.j.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class g extends SQLiteOpenHelper {
    private static g b;
    private SQLiteDatabase a;

    private g(Context context) {
        this(context, "music_lrc.db", null, 1);
    }

    private g(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static g a(Context context) {
        if (b == null) {
            b = new g(context);
        }
        return b;
    }

    public synchronized long a(String str, String str2) {
        String replaceAll = str.replaceAll("'", "");
        try {
            this.a = getWritableDatabase();
            this.a.execSQL("insert into music_lrc (_id, _songinfo,_filepath) values (?,?,?)", new Object[]{null, replaceAll, str2});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public synchronized String a(String str) {
        String replaceAll;
        Exception e;
        Cursor cursor = null;
        synchronized (this) {
            String str2 = "";
            replaceAll = str.replaceAll("'", "");
            try {
                this.a = getReadableDatabase();
                cursor = this.a.rawQuery("select * from music_lrc where _songinfo = '" + replaceAll + "'", null);
                replaceAll = str2;
                while (cursor.moveToNext()) {
                    try {
                        replaceAll = cursor.getString(cursor.getColumnIndexOrThrow("_filepath"));
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                a(this.a, cursor);
            } catch (Exception e3) {
                Exception exception = e3;
                replaceAll = str2;
                e = exception;
                try {
                    e.printStackTrace();
                    a(this.a, cursor);
                    return replaceAll;
                } catch (Throwable th) {
                    a(this.a, cursor);
                }
            }
        }
        return replaceAll;
    }

    public synchronized void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
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
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e22) {
                e22.printStackTrace();
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
            if (sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        }
    }

    public synchronized void b(String str) {
        try {
            this.a = getWritableDatabase();
            String[] strArr = new String[]{str};
            this.a.execSQL("DELETE FROM music_lrc where _filepath = ?", strArr);
            a(this.a, null);
        } catch (Exception e) {
            e.printStackTrace();
            a(this.a, null);
        } catch (Throwable th) {
            a(this.a, null);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE music_lrc ( _id INTEGER PRIMARY KEY AUTOINCREMENT,_songinfo TEXT ,_filepath TEXT )");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS music_lrc");
        onCreate(sQLiteDatabase);
    }
}
