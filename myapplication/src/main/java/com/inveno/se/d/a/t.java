package com.inveno.se.d.a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.inveno.se.d.s;
import com.inveno.se.f.j;
import java.io.File;

public class t {
    public static s a(Context context) {
        return a(context, null);
    }

    public static s a(Context context, k kVar) {
        File file = new File(j.a(context, "piconfig"));
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (kVar == null) {
            kVar = VERSION.SDK_INT >= 9 ? new l() : new i(AndroidHttpClient.newInstance(str));
        }
        s sVar = new s(new e(file), new a(kVar));
        sVar.a();
        return sVar;
    }
}
