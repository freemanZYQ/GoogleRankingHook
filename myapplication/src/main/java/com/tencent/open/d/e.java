package com.tencent.open.d;

import android.content.Context;
import java.io.File;

public final class e {
    private static Context a;

    public static final Context a() {
        return a == null ? null : a;
    }

    public static final void a(Context context) {
        a = context;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final File c() {
        return a() == null ? null : a().getFilesDir();
    }
}
