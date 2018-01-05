package com.inveno.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class p extends SQLiteOpenHelper {
    public p(Context context) {
        super(context, "data_sdk", null, 3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE report_data (_id INTEGER PRIMARY KEY AUTOINCREMENT, product_id TEXT, promotion TEXT, fuid TEXT, uid TEXT, app_ver TEXT, sdk_ver TEXT, api_ver TEXT, tk TEXT, report_time TEXT, network TEXT, sid TEXT, seq TEXT, imei TEXT, aid TEXT, brand TEXT, model TEXT, osv TEXT, platform TEXT, language TEXT, app_lan TEXT, mcc TEXT, mnc TEXT, nmcc TEXT, nmnc TEXT, upack TEXT, referrer TEXT, data TEXT )");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 3) {
            sQLiteDatabase.execSQL("CREATE TABLE report_data (_id INTEGER PRIMARY KEY AUTOINCREMENT, product_id TEXT, promotion TEXT, fuid TEXT, uid TEXT, app_ver TEXT, sdk_ver TEXT, api_ver TEXT, tk TEXT, report_time TEXT, network TEXT, sid TEXT, seq TEXT, imei TEXT, aid TEXT, brand TEXT, model TEXT, osv TEXT, platform TEXT, language TEXT, app_lan TEXT, mcc TEXT, mnc TEXT, nmcc TEXT, nmnc TEXT, upack TEXT, referrer TEXT, data TEXT )");
        }
    }
}
