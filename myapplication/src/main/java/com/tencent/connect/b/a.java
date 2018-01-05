package com.tencent.connect.b;

import android.os.Build;
import com.tencent.connect.common.b;
import com.tencent.open.a.j;

public class a extends b {
    public static String a;
    public static String b;

    static {
        a = "libwbsafeedit";
        b = a + ".so";
        String str = Build.CPU_ABI;
        if (str == null || str.equals("")) {
            a = "libwbsafeedit";
            b = a + ".so";
            j.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        } else if (str.equalsIgnoreCase("arm64-v8a")) {
            a = "libwbsafeedit_64";
            b = a + ".so";
            j.c("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
        } else if (str.equalsIgnoreCase("x86")) {
            a = "libwbsafeedit_x86";
            b = a + ".so";
            j.c("openSDK_LOG.AuthAgent", "is x86 architecture");
        } else if (str.equalsIgnoreCase("x86_64")) {
            a = "libwbsafeedit_x86_64";
            b = a + ".so";
            j.c("openSDK_LOG.AuthAgent", "is x86_64 architecture");
        } else {
            a = "libwbsafeedit";
            b = a + ".so";
            j.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        }
    }

    public a(c cVar) {
        super(cVar);
    }
}
