package com.xinmei365.fontsdk.download;

import android.content.Context;

class c {
    private static c p;
    private boolean b = false;
    private a o;

    private c() {
    }

    public static c b() {
        if (p == null) {
            synchronized (c.class) {
                if (p == null) {
                    p = new c();
                }
            }
        }
        return p;
    }

    public static String c() {
        return "create table load_download_info(_id integer PRIMARY KEY AUTOINCREMENT, url char,class_name char,object text,local_path)";
    }

    private void e(String str) {
        this.o.getReadableDatabase().delete("load_download_info", "url=?", new String[]{str});
    }

    public void a(DownloadInfo downloadInfo) {
        synchronized (p) {
        }
    }

    public void b(DownloadInfo downloadInfo) {
        e(downloadInfo.getUrlStr());
    }

    public void c(Context context) {
        if (!this.b) {
            synchronized (c.class) {
                if (!this.b) {
                    this.o = new a(context);
                    this.b = true;
                }
            }
        }
    }
}
