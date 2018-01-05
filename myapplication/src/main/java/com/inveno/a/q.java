package com.inveno.a;

import a.e;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Environment;
import android.util.Log;
import com.inveno.se.f.a;
import java.io.File;

public class q extends ContextWrapper {
    private Context a;

    public q(Context context) {
        super(context);
        this.a = context;
    }

    public static String a(Context context) {
        return e.a(context, "reportdata" + File.separator + "data_sdk.db");
    }

    public static boolean b(Context context) {
        File file = new File(a(context));
        File file2 = new File(file.getParent());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.createNewFile();
            return true;
        } catch (Exception e) {
            a.a("DataSDK", "创建外部数据库文件时失败");
            e.printStackTrace();
            return false;
        }
    }

    public File getDatabasePath(String str) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return b(this.a) ? new File(a(this.a)) : null;
        } else {
            Log.e("SD卡管理：", "SD卡不存在，请加载SD卡");
            return null;
        }
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), null);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), null);
    }
}
