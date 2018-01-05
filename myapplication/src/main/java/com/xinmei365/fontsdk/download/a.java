package com.xinmei365.fontsdk.download;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "download_db", null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(g.c());
        sQLiteDatabase.execSQL(c.c());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 && i2 == 2) {
            sQLiteDatabase.execSQL(c.c());
        }
    }
}
