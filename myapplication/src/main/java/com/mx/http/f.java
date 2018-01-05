package com.mx.http;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import com.mx.http.download.a;
import java.io.File;
import java.util.Map;

public class f {
    public static f a;
    public Context b;
    public l c;
    private c d;

    public f(Context context) {
        this.b = context;
        a();
    }

    public static f a(Context context) {
        if (a == null) {
            a = new f(context);
        }
        return a;
    }

    private void a() {
        File file = new File(this.b.getCacheDir(), "volley");
        String str = "moxiu/0";
        try {
            str = this.b.getPackageName();
            new StringBuilder(String.valueOf(str)).append("/").append(this.b.getPackageManager().getPackageInfo(str, 0).versionCode).toString();
        } catch (NameNotFoundException e) {
        }
        if (this.d == null && VERSION.SDK_INT >= 9) {
            this.d = new d();
        }
        if (this.c == null) {
            this.c = new l(this.d, this.b);
        }
    }

    public void a(j jVar, g gVar) {
        Log.e("ZGP", "发起文件下载请求");
        jVar.a(this.b);
        this.c.a(jVar, gVar);
    }

    public void a(String str, int i, Map map, String str2, g gVar) {
        j nVar = new n(str, i, map, str2, this.b, gVar);
        nVar.a(false);
        a(nVar, gVar);
    }

    public void a(String str, a aVar) {
        j bVar = new b(str, aVar, this.b);
        bVar.a(aVar);
        bVar.a(true);
        bVar.a(this.b);
        a(bVar, null);
    }
}
