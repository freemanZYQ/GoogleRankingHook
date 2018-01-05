package com.baidu.mobads.j;

import android.util.Log;
import com.baidu.mobads.a.a;
import com.baidu.mobads.interfaces.utils.IXAdLogger;

public class j implements IXAdLogger {
    private static volatile j a = null;

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
                }
            }
        }
        return a;
    }

    private String a(Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object append : objArr) {
            stringBuilder.append(append).append(' ');
        }
        return stringBuilder.toString();
    }

    public int d(String str) {
        return d(IXAdLogger.TAG, str);
    }

    public int d(String str, String str2) {
        int i = -1;
        if (isLoggable(3)) {
            try {
                i = Log.d(str, str2);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int d(String str, Throwable th) {
        int i = -1;
        if (isLoggable(3)) {
            try {
                i = Log.d(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int d(Throwable th) {
        return d("", th);
    }

    public int d(Object... objArr) {
        return !isLoggable(3) ? -1 : d(a(objArr));
    }

    public int e(String str) {
        int i = -1;
        if (isLoggable(6)) {
            try {
                i = Log.e(IXAdLogger.TAG, str);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int e(String str, Throwable th) {
        int i = -1;
        if (isLoggable(6)) {
            try {
                i = Log.e(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int e(Throwable th) {
        return e("", th);
    }

    public int e(Object... objArr) {
        return !isLoggable(6) ? -1 : e(a(objArr));
    }

    public int i(String str) {
        return i(IXAdLogger.TAG, str);
    }

    public int i(String str, String str2) {
        int i = -1;
        if (isLoggable(4)) {
            try {
                i = Log.i(str, str2);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int i(String str, Throwable th) {
        int i = -1;
        if (isLoggable(4)) {
            try {
                i = Log.i(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int i(Object... objArr) {
        return !isLoggable(4) ? -1 : i(a(objArr));
    }

    public boolean isLoggable(int i) {
        return isLoggable(IXAdLogger.TAG, i);
    }

    public boolean isLoggable(String str, int i) {
        return i >= a.b;
    }

    public int w(String str) {
        int i = -1;
        if (isLoggable(5)) {
            try {
                i = Log.w(IXAdLogger.TAG, str);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int w(String str, Throwable th) {
        int i = -1;
        if (isLoggable(5)) {
            try {
                i = Log.w(IXAdLogger.TAG, str, th);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int w(Throwable th) {
        return w("", th);
    }

    public int w(Object... objArr) {
        return !isLoggable(5) ? -1 : w(a(objArr));
    }
}
