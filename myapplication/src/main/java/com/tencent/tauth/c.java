package com.tencent.tauth;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.connect.b.b;
import com.tencent.open.a.j;
import com.tencent.open.d.e;

public class c {
    private static c b;
    private final b a;

    private c(String str, Context context) {
        e.a(context.getApplicationContext());
        this.a = b.a(str, context);
    }

    public static synchronized c a(String str, Context context) {
        c cVar;
        synchronized (c.class) {
            e.a(context.getApplicationContext());
            j.c("openSDK_LOG.Tencent", "createInstance()  -- start");
            if (b == null) {
                b = new c(str, context);
            } else if (!str.equals(b.a())) {
                b.a(context);
                b = new c(str, context);
            }
            if (a(context, str)) {
                j.c("openSDK_LOG.Tencent", "createInstance()  -- end");
                cVar = b;
            } else {
                cVar = null;
            }
        }
        return cVar;
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (NameNotFoundException e) {
                j.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档." + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                return false;
            }
        } catch (NameNotFoundException e2) {
            j.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n" + "</intent-filter>\n" + "</activity>"));
            return false;
        }
    }

    public String a() {
        return this.a.a().b();
    }

    public void a(Context context) {
        j.c("openSDK_LOG.Tencent", "logout()");
        this.a.a().a(null, "0");
        this.a.a().a(null);
    }

    public com.tencent.connect.b.c b() {
        return this.a.a();
    }
}
