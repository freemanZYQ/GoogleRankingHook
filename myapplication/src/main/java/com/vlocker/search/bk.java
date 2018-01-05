package com.vlocker.search;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.vlocker.new_theme.beans.h;

public class bk extends SQLiteOpenHelper {
    private static bk a;
    private static final String b = ("CREATE TABLE searchhistory ( " + h.a + " INTEGER ," + h.b + " TEXT PRIMARY KEY " + ")");

    private bk(Context context) {
        this(context, "t_searchhistory.db", null, 1);
    }

    private bk(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static bk a(Context context) {
        if (a == null) {
            a = new bk(context);
        }
        return a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(b);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS searchhistory");
        onCreate(sQLiteDatabase);
    }
}
