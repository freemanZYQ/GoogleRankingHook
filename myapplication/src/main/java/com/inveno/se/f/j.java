package com.inveno.se.f;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class j {
    public static boolean a = true;
    public static String b;

    public static String a(Context context, String str) {
        if (k.b(b)) {
            return (b + File.separator + d.c) + File.separator + str;
        }
        String str2 = "";
        str2 = a ? "mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + d.c : context.getCacheDir().getPath() : context.getCacheDir().getPath();
        return str2 + File.separator + str;
    }
}
