package com.xinmei365.fontsdk.download;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

class g {
    private static g I;
    private boolean b = false;
    private a o;

    private g() {
    }

    public static String c() {
        return "create table download_info(_id integer PRIMARY KEY AUTOINCREMENT, thread_id integer, start_pos integer, end_pos integer, compelete_size integer,url char,download_status integer,local_path char)";
    }

    public static g n() {
        if (I == null) {
            synchronized (g.class) {
                if (I == null) {
                    I = new g();
                }
            }
        }
        return I;
    }

    public void a(f fVar) {
        synchronized (I) {
            this.o.getReadableDatabase().execSQL(String.format("update %s set compelete_size=? , download_status=? where thread_id=? and url=? ", new Object[]{"download_info"}), new Object[]{Integer.valueOf(fVar.k()), Integer.valueOf(fVar.l()), Integer.valueOf(fVar.getThreadId()), fVar.getUrl()});
        }
    }

    public void a(List list) {
        synchronized (I) {
            SQLiteDatabase writableDatabase = this.o.getWritableDatabase();
            for (f fVar : list) {
                writableDatabase.execSQL(String.format("insert into %s(thread_id,start_pos, end_pos,compelete_size,url,download_status,local_path) values (?,?,?,?,?,?,?)", new Object[]{"download_info"}), new Object[]{Integer.valueOf(fVar.getThreadId()), Integer.valueOf(fVar.getStartPosition()), Integer.valueOf(fVar.j()), Integer.valueOf(fVar.k()), fVar.getUrl(), Integer.valueOf(fVar.l()), fVar.m()});
            }
        }
    }

    public void c(Context context) {
        if (!this.b) {
            synchronized (g.class) {
                if (!this.b) {
                    this.o = new a(context);
                    this.b = true;
                }
            }
        }
    }

    public void e(String str) {
        this.o.getReadableDatabase().delete("download_info", "url=?", new String[]{str});
    }

    public boolean f(String str) {
        Cursor rawQuery = this.o.getReadableDatabase().rawQuery(String.format("select count(*)  from %s where url=?", new Object[]{"download_info"}), new String[]{str});
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i > 0;
    }

    public List g(String str) {
        List arrayList = new ArrayList();
        Cursor rawQuery = this.o.getReadableDatabase().rawQuery(String.format("select * from %s where url=?", new Object[]{"download_info"}), new String[]{str});
        while (rawQuery.moveToNext()) {
            arrayList.add(new f(rawQuery.getInt(1), rawQuery.getInt(2), rawQuery.getInt(3), rawQuery.getInt(4), rawQuery.getString(5), rawQuery.getInt(6), rawQuery.getString(7)));
        }
        rawQuery.close();
        return arrayList;
    }
}
