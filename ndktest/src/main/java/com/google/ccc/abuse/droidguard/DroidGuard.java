package com.google.ccc.abuse.droidguard;

import android.content.Context;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by apple on 16/12/8.
 */
public class DroidGuard {

    private final Context a;
    private final String b;
    private final byte[] c;
    private final Object d;
    private long e;
    private StringBuffer log;



    public DroidGuard(Context context, String str, byte[] bArr) {
        this(context, str, bArr, null);
    }

    public DroidGuard(Context context, String str, byte[] bArr, Object obj) {
        this.a = context;
        this.b = str;
        this.c = bArr;
        this.d = obj;
    }

    private static String[] a(Map map) {
        if (map == null) {
            return new String[0];
        }
        String[] strArr = new String[(map.size() << 1)];
        int i = 0;
        for (Object entry : map.entrySet()) {
            int i2 = i + 1;
            strArr[i] = (String) ((Map.Entry)entry).getKey();
            int i3 = i2 + 1;
            strArr[i2] = (String) ((Map.Entry)entry).getValue();
            i = i3;
        }
        return strArr;
    }

    private native void closeNative(long j);

    public static native void entryHelperNative(long j);

    private native long initNative(Context context, String str, byte[] bArr, Object obj);

    private native byte[] runNative(Context context, String str, byte[] bArr, String[] strArr, Object obj);

    private native byte[] ssNative(long j, Context context, String[] strArr, Object obj);

    public synchronized void close() {
        if (this.e != 0) {
            closeNative(this.e);
            this.e = 0;
        }
    }

    public String getLog() {
        return this.log == null ? "" : this.log.toString();
    }

    public synchronized boolean init() {
        if (this.e != 0) {
            closeNative(this.e);
        }
        this.e = initNative(this.a, this.b, this.c, this.d);
        return this.e != 0;
    }

    public byte[] run(Map map) {
        return runNative(this.a, this.b, this.c, a(map), this.d);
    }

    public synchronized byte[] ss(Map map) {
        return this.e == 0 ? null : ssNative(this.e, this.a, a(map), this.d);
    }
}
