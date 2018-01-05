package com.tencent.open.a;

import android.os.Environment;

public final class f {
    public static boolean a() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static g b() {
        return !a() ? null : g.b(Environment.getExternalStorageDirectory());
    }
}
