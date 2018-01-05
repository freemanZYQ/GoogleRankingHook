package com.tencent.connect.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;
import com.tencent.connect.a.a;
import com.tencent.open.a.j;
import com.tencent.open.d.e;

public class b {
    private a a = new a(this.b);
    private c b;

    private b(String str, Context context) {
        j.c("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.b = new c(str);
        a.c(context, this.b);
        j.c("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public static b a(String str, Context context) {
        e.a(context.getApplicationContext());
        j.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
            b bVar = new b(str, context);
            j.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
            return bVar;
        } catch (Throwable e) {
            j.a("openSDK_LOG.QQAuth", "createInstance() error --end", e);
            Toast.makeText(context.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
            return null;
        }
    }

    public c a() {
        return this.b;
    }
}
