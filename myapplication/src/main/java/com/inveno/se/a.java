package com.inveno.se;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.inveno.a.ah;
import com.inveno.se.a.f;
import com.inveno.se.f.b;
import com.inveno.se.f.j;
import com.inveno.se.f.k;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static a a;
    private static boolean b = false;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    private void a(PackageManager packageManager, String str) {
        try {
            b.b = packageManager.getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("can not get " + str + "  versionName!!");
        }
    }

    private void a(String str) {
        if (k.b(str)) {
            String replace = str.replace("com.", "").replace(".", "");
            try {
                if (k.a(replace)) {
                    replace = str.substring(str.lastIndexOf(".") + 1, str.length());
                }
            } catch (IndexOutOfBoundsException e) {
            }
            b.i = replace;
            return;
        }
        throw new RuntimeException("can not get packageName!!!");
    }

    private void b(Context context) {
        String str;
        String str2;
        String str3;
        JSONException e;
        Throwable th;
        try {
            String str4;
            if (a.a.a) {
                str4 = null;
                str = null;
                str2 = null;
                str3 = null;
            } else {
                JSONObject jSONObject = new JSONObject(k.c(j.a(context, "debug")));
                if (jSONObject.has("debug")) {
                    b.a = jSONObject.getBoolean("debug");
                }
                if (jSONObject.has("log")) {
                    b.j = jSONObject.getBoolean("log");
                }
                str3 = jSONObject.has("host") ? jSONObject.getString("host") : null;
                try {
                    str2 = jSONObject.has("second_host") ? jSONObject.getString("second_host") : null;
                    try {
                        str = jSONObject.has("zzhost") ? jSONObject.getString("zzhost") : null;
                    } catch (JSONException e2) {
                        e = e2;
                        str = null;
                        try {
                            e.printStackTrace();
                            if (c.b()) {
                                b.j = true;
                            }
                            if (k.a(str3)) {
                                b.e = com.inveno.se.a.a.b;
                            } else {
                                b.e = str3;
                            }
                            if (k.a(str2)) {
                                b.f = com.inveno.se.a.a.a;
                            } else {
                                b.f = str2;
                            }
                            if (k.a(str)) {
                                ah.b(com.inveno.se.a.a.d);
                            } else {
                                ah.b(str);
                            }
                            if (k.a(null)) {
                                ah.a(com.inveno.se.a.a.e);
                            } else {
                                ah.a(null);
                            }
                            com.inveno.se.f.a.a("inveno", "AppConfig.DEBUG_MODE:" + b.a + " AppConfig.LOG_SWITCH:" + b.j + " host:" + str3 + " detailHost:" + null + " AppConfig.HOST :" + b.e + " ZZHost:" + com.inveno.se.a.a.d + " ZZ_REPORT_HOST:" + com.inveno.se.a.a.e);
                        } catch (Throwable th2) {
                            th = th2;
                            if (c.b()) {
                                b.j = true;
                            }
                            if (k.a(str3)) {
                                b.e = com.inveno.se.a.a.b;
                            } else {
                                b.e = str3;
                            }
                            if (k.a(str2)) {
                                b.f = com.inveno.se.a.a.a;
                            } else {
                                b.f = str2;
                            }
                            if (k.a(str)) {
                                ah.b(com.inveno.se.a.a.d);
                            } else {
                                ah.b(str);
                            }
                            if (k.a(null)) {
                                ah.a(com.inveno.se.a.a.e);
                            } else {
                                ah.a(null);
                            }
                            com.inveno.se.f.a.a("inveno", "AppConfig.DEBUG_MODE:" + b.a + " AppConfig.LOG_SWITCH:" + b.j + " host:" + str3 + " detailHost:" + null + " AppConfig.HOST :" + b.e + " ZZHost:" + com.inveno.se.a.a.d + " ZZ_REPORT_HOST:" + com.inveno.se.a.a.e);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = null;
                        if (c.b()) {
                            b.j = true;
                        }
                        if (k.a(str3)) {
                            b.e = str3;
                        } else {
                            b.e = com.inveno.se.a.a.b;
                        }
                        if (k.a(str2)) {
                            b.f = str2;
                        } else {
                            b.f = com.inveno.se.a.a.a;
                        }
                        if (k.a(str)) {
                            ah.b(str);
                        } else {
                            ah.b(com.inveno.se.a.a.d);
                        }
                        if (k.a(null)) {
                            ah.a(null);
                        } else {
                            ah.a(com.inveno.se.a.a.e);
                        }
                        com.inveno.se.f.a.a("inveno", "AppConfig.DEBUG_MODE:" + b.a + " AppConfig.LOG_SWITCH:" + b.j + " host:" + str3 + " detailHost:" + null + " AppConfig.HOST :" + b.e + " ZZHost:" + com.inveno.se.a.a.d + " ZZ_REPORT_HOST:" + com.inveno.se.a.a.e);
                        throw th;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str = null;
                    str2 = null;
                    e.printStackTrace();
                    if (c.b()) {
                        b.j = true;
                    }
                    if (k.a(str3)) {
                        b.e = com.inveno.se.a.a.b;
                    } else {
                        b.e = str3;
                    }
                    if (k.a(str2)) {
                        b.f = com.inveno.se.a.a.a;
                    } else {
                        b.f = str2;
                    }
                    if (k.a(str)) {
                        ah.b(com.inveno.se.a.a.d);
                    } else {
                        ah.b(str);
                    }
                    if (k.a(null)) {
                        ah.a(com.inveno.se.a.a.e);
                    } else {
                        ah.a(null);
                    }
                    com.inveno.se.f.a.a("inveno", "AppConfig.DEBUG_MODE:" + b.a + " AppConfig.LOG_SWITCH:" + b.j + " host:" + str3 + " detailHost:" + null + " AppConfig.HOST :" + b.e + " ZZHost:" + com.inveno.se.a.a.d + " ZZ_REPORT_HOST:" + com.inveno.se.a.a.e);
                } catch (Throwable th4) {
                    th = th4;
                    str = null;
                    str2 = null;
                    if (c.b()) {
                        b.j = true;
                    }
                    if (k.a(str3)) {
                        b.e = com.inveno.se.a.a.b;
                    } else {
                        b.e = str3;
                    }
                    if (k.a(str2)) {
                        b.f = com.inveno.se.a.a.a;
                    } else {
                        b.f = str2;
                    }
                    if (k.a(str)) {
                        ah.b(com.inveno.se.a.a.d);
                    } else {
                        ah.b(str);
                    }
                    if (k.a(null)) {
                        ah.a(com.inveno.se.a.a.e);
                    } else {
                        ah.a(null);
                    }
                    com.inveno.se.f.a.a("inveno", "AppConfig.DEBUG_MODE:" + b.a + " AppConfig.LOG_SWITCH:" + b.j + " host:" + str3 + " detailHost:" + null + " AppConfig.HOST :" + b.e + " ZZHost:" + com.inveno.se.a.a.d + " ZZ_REPORT_HOST:" + com.inveno.se.a.a.e);
                    throw th;
                }
                try {
                    str4 = jSONObject.has("zz_report_host") ? jSONObject.getString("zz_report_host") : null;
                } catch (JSONException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (c.b()) {
                        b.j = true;
                    }
                    if (k.a(str3)) {
                        b.e = com.inveno.se.a.a.b;
                    } else {
                        b.e = str3;
                    }
                    if (k.a(str2)) {
                        b.f = com.inveno.se.a.a.a;
                    } else {
                        b.f = str2;
                    }
                    if (k.a(str)) {
                        ah.b(com.inveno.se.a.a.d);
                    } else {
                        ah.b(str);
                    }
                    if (k.a(null)) {
                        ah.a(com.inveno.se.a.a.e);
                    } else {
                        ah.a(null);
                    }
                    com.inveno.se.f.a.a("inveno", "AppConfig.DEBUG_MODE:" + b.a + " AppConfig.LOG_SWITCH:" + b.j + " host:" + str3 + " detailHost:" + null + " AppConfig.HOST :" + b.e + " ZZHost:" + com.inveno.se.a.a.d + " ZZ_REPORT_HOST:" + com.inveno.se.a.a.e);
                }
            }
            if (c.b()) {
                b.j = true;
            }
            if (k.a(str3)) {
                b.e = com.inveno.se.a.a.b;
            } else {
                b.e = str3;
            }
            if (k.a(str2)) {
                b.f = com.inveno.se.a.a.a;
            } else {
                b.f = str2;
            }
            if (k.a(str)) {
                ah.b(com.inveno.se.a.a.d);
            } else {
                ah.b(str);
            }
            if (k.a(str4)) {
                ah.a(com.inveno.se.a.a.e);
            } else {
                ah.a(str4);
            }
            com.inveno.se.f.a.a("inveno", "AppConfig.DEBUG_MODE:" + b.a + " AppConfig.LOG_SWITCH:" + b.j + " host:" + str3 + " detailHost:" + null + " AppConfig.HOST :" + b.e + " ZZHost:" + com.inveno.se.a.a.d + " ZZ_REPORT_HOST:" + com.inveno.se.a.a.e);
        } catch (JSONException e5) {
            e = e5;
            str = null;
            str2 = null;
            str3 = null;
            e.printStackTrace();
            if (c.b()) {
                b.j = true;
            }
            if (k.a(str3)) {
                b.e = str3;
            } else {
                b.e = com.inveno.se.a.a.b;
            }
            if (k.a(str2)) {
                b.f = str2;
            } else {
                b.f = com.inveno.se.a.a.a;
            }
            if (k.a(str)) {
                ah.b(str);
            } else {
                ah.b(com.inveno.se.a.a.d);
            }
            if (k.a(null)) {
                ah.a(null);
            } else {
                ah.a(com.inveno.se.a.a.e);
            }
            com.inveno.se.f.a.a("inveno", "AppConfig.DEBUG_MODE:" + b.a + " AppConfig.LOG_SWITCH:" + b.j + " host:" + str3 + " detailHost:" + null + " AppConfig.HOST :" + b.e + " ZZHost:" + com.inveno.se.a.a.d + " ZZ_REPORT_HOST:" + com.inveno.se.a.a.e);
        } catch (Throwable th5) {
            th = th5;
            str = null;
            str2 = null;
            str3 = null;
            if (c.b()) {
                b.j = true;
            }
            if (k.a(str3)) {
                b.e = com.inveno.se.a.a.b;
            } else {
                b.e = str3;
            }
            if (k.a(str2)) {
                b.f = com.inveno.se.a.a.a;
            } else {
                b.f = str2;
            }
            if (k.a(str)) {
                ah.b(com.inveno.se.a.a.d);
            } else {
                ah.b(str);
            }
            if (k.a(null)) {
                ah.a(com.inveno.se.a.a.e);
            } else {
                ah.a(null);
            }
            com.inveno.se.f.a.a("inveno", "AppConfig.DEBUG_MODE:" + b.a + " AppConfig.LOG_SWITCH:" + b.j + " host:" + str3 + " detailHost:" + null + " AppConfig.HOST :" + b.e + " ZZHost:" + com.inveno.se.a.a.d + " ZZ_REPORT_HOST:" + com.inveno.se.a.a.e);
            throw th;
        }
    }

    private void b(PackageManager packageManager, String str) {
        try {
            b.c = packageManager.getApplicationInfo(str, 128).metaData.getString("PIKEY");
        } catch (Exception e) {
            com.inveno.se.f.a.a("inveno", "getAppName error:" + e.getMessage());
        }
        if (k.a(b.c)) {
            b.c = f.f;
        }
        com.inveno.se.f.a.a("inveno", "getAppName AppConfig.APP_NAME:" + b.c + " ZZConfig.PIKEY:" + f.f);
    }

    public void a(Context context) {
        if (!b) {
            if (context == null) {
                throw new RuntimeException("Context can not be null !!!");
            }
            if (VERSION.SDK_INT >= 23) {
                a.a.a(context);
            }
            String packageName = context.getPackageName();
            b.d = packageName;
            a(packageName);
            PackageManager packageManager = context.getPackageManager();
            a(packageManager, packageName);
            b(packageManager, packageName);
            com.inveno.se.f.a.b("initConfig packageName:" + packageName + " SdcardName:" + b.i + " versionName:" + b.b);
            b(context);
            b = true;
        }
    }
}
