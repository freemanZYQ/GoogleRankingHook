package com.vlocker.m;

import android.content.ComponentName;
import android.content.Context;
import android.os.Environment;
import com.vlocker.security.MoSecurityApplication;
import java.io.File;

public class o {
    public static String a() {
        File b = MoSecurityApplication.a().b();
        String str = null;
        if (b != null) {
            str = b.getAbsolutePath();
        }
        String absolutePath = str == null ? new File(Environment.getExternalStorageDirectory(), "vlocker").getAbsolutePath() : str;
        try {
            new File(absolutePath + "/").mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return absolutePath;
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(new ComponentName(context, context.getClass()).getPackageName(), 0).versionName;
        } catch (Exception e) {
            return null;
        }
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(new ComponentName(context, context.getClass()).getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return -1;
        }
    }
}
