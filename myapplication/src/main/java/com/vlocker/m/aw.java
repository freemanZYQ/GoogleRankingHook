package com.vlocker.m;

import android.os.SystemProperties;
import android.util.Log;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.vlocker.c.a;
import com.vlocker.security.MoSecurityApplication;
import java.io.File;

public class aw {
    private static aw a = new aw();
    private static final String[] b = new String[]{"/system/sbin/", "/system/xbin/", "/system/bin/"};

    private aw() {
    }

    public static synchronized aw a() {
        aw awVar;
        synchronized (aw.class) {
            awVar = a;
        }
        return awVar;
    }

    private String a(String str) {
        if (str.indexOf(47) != -1) {
            return str;
        }
        int i = 0;
        while (i < b.length) {
            try {
                String str2 = b[i] + str;
                if (new File(str2).exists()) {
                    return str2;
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean b() {
        try {
            return (a("su") == null || c()) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean c() {
        String str;
        a a;
        try {
            str = SystemProperties.get("ro.build.id", IXAdSystemUtils.NT_UNKNOWN);
            Log.d("MIR", "bid: " + str);
            if (str.equals("HM2013022")) {
                str = SystemProperties.get("ro.build.version.incremental", IXAdSystemUtils.NT_UNKNOWN);
                Log.d("MIR", "icmt: " + str);
                if (str.equals("JHACNAH3.0") || str.equals("JHACNAH2.0") || str.equals("JHACNAH1.0") || str.equals("HBJ2.3") || str.equals("HBJ2.2") || str.equals("HBJ2.1") || str.equals("HBJ2.0")) {
                    return true;
                }
                if (str.equals("JHACNAH4.0") || str.equals("JHACNAH5.0") || str.equals("JHACNAH6.0") || str.equals("JHACNAH7.0") || str.equals("JHACNAH8.0")) {
                    a = a.a(MoSecurityApplication.a().getApplicationContext());
                    if (!a.n(str)) {
                        return true;
                    }
                    a.o(str);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        try {
            str = SystemProperties.get("ro.build.version.incremental", IXAdSystemUtils.NT_UNKNOWN);
            String str2 = SystemProperties.get("ro.product.model", IXAdSystemUtils.NT_UNKNOWN);
            Log.d("MIR", str + ", " + str2);
            boolean z;
            File file;
            if (str2.equals("MI 3")) {
                if (str.equals("JXCCNAL11.0") || str.equals("JXCCNAI11.0") || str.equals("JXCCNAI7.0") || str.equals("JXCCNAI6.0") || str.equals("JXCCNAI5.0") || str.equals("JXCCNAI4.0") || str.equals("JXCCNAI3.0")) {
                    z = true;
                } else if (str.equals("JXCCNAI12.0") || str.equals("JXCCNAI13.0") || str.equals("JXCCNAI14.0") || str.equals("JXCCNAI15.0") || str.equals("JXCCNAI16.0")) {
                    a = a.a(MoSecurityApplication.a().getApplicationContext());
                    if (a.n(str)) {
                        a.o(str);
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    file = new File("/system/app/LBESEC_MIUI.apk");
                    if (file != null && file.exists() && (file.length() == 547278 || file.length() == 553737)) {
                        file = new File("/data/app/com.lbe.security.su-1.apk");
                        if (!(file == null || file.exists())) {
                            return true;
                        }
                    }
                }
            } else if (str2.equals("MI-ONE Plus") || str2.equals("MI-ONE C1") || str2.equals("MI 1S") || str2.equals("MI-ONE") || str2.equals("MI-ONE")) {
                if (str.equals("ICS19.0") || str.equals("ICS20.0") || str.equals("ICS21.0") || str.equals("ICS22.0") || str.equals("ICS23.0") || str.equals("ICS24.0") || str.equals("ICS25.0")) {
                    file = new File("/system/app/LBESEC_MIUI.apk");
                    if (file != null && file.exists() && (file.length() == 405028 || file.length() == 430756)) {
                        file = new File("/data/app/com.lbe.security.su-1.apk");
                        if (!(file == null || file.exists())) {
                            return true;
                        }
                    }
                }
            } else if (str2.equals("MI 2") || str2.equals("MI 2A")) {
                if (str.equals("JLB27.0") || str.equals("JLB26.0") || str.equals("JLB24.0") || str.equals("JLB23.0") || str.equals("JLB22.0") || str.equals("JLB21.0") || str.equals("JLB20.0") || str.equals("JLB18.0") || str.equals("JLB17.0") || str.equals("JLB16.0") || str.equals("JLB15.0") || str.equals("JLB11.0") || str.equals("JLB12.0") || str.equals("JLB14.0") || str.equals("JLB10.0") || str.equals("JLB7.0") || str.equals("JLB5.0") || str.equals("JLB4.0")) {
                    z = true;
                } else if (str.equals("JLB28.0") || str.equals("JLB29.0") || str.equals("JLB30.0") || str.equals("JLB31.0") || str.equals("JLB32.0")) {
                    a = a.a(MoSecurityApplication.a().getApplicationContext());
                    if (a.n(str)) {
                        a.o(str);
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    file = new File("/system/app/LBESEC_MIUI.apk");
                    if (file != null && file.exists()) {
                        Log.d("MIR", "LBESEC_MIUI.apk size:" + file.length());
                        if (file.length() == 553737 || file.length() == 405054 || file.length() == 430756 || file.length() == 547294 || file.length() == 558637) {
                            file = new File("/data/app/com.lbe.security.su-1.apk");
                            if (!(file == null || file.exists())) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException e2) {
        }
        return false;
    }
}
