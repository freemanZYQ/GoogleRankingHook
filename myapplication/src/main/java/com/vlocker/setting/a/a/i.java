package com.vlocker.setting.a.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.vlocker.setting.a.a;
import com.vlocker.setting.a.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class i {
    private static Map a = new HashMap();
    private String b = null;
    private String c = null;
    private int d = 1;

    private String a(String str) {
        String str2 = (String) a.get(this.b);
        if (!a.containsKey(str)) {
            if ("display".equals(this.b)) {
                str2 = Build.DISPLAY;
            } else if ("device".equals(this.b)) {
                str2 = Build.DEVICE;
            } else if ("manufacturer".equals(this.b)) {
                str2 = Build.MANUFACTURER;
            } else if ("product".equals(this.b)) {
                str2 = Build.PRODUCT;
            } else if ("model".equals(this.b)) {
                str2 = Build.MODEL;
            } else if ("sdk".equals(this.b)) {
                str2 = "" + VERSION.SDK_INT;
            } else if ("brand".equals(this.b)) {
                str2 = Build.BRAND;
            } else if (this.b.startsWith("ro.")) {
                str2 = b.getPropertyByName(this.b);
                if ("ro.com.google.gmsversion".equals(this.b) && str2 == "") {
                    str2 = "-";
                }
            } else {
                str2 = this.b;
            }
            str2 = str2 == null ? "" : str2.toLowerCase(Locale.ENGLISH);
            if (str2.contains("h2os")) {
                str2 = str2.replaceAll("h2os", "");
            }
            a.put(this.b, str2);
            Log.d(getClass().getSimpleName(), this.b + ":" + str2);
        }
        return str2;
    }

    private final boolean a(String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        return a.getInstance().getContext().getPackageManager().queryIntentActivities(intent, 1).size() > 0;
    }

    public boolean matched() {
        boolean z = true;
        boolean z2 = false;
        String a = a(this.b);
        if (!(a == null || a.isEmpty())) {
            long versionCodeByString;
            boolean z3;
            switch (this.d) {
                case 1:
                    z2 = a.contains(this.c);
                    break;
                case 2:
                    z2 = a.startsWith(this.c);
                    break;
                case 3:
                    z2 = a.endsWith(this.c);
                    break;
                case 4:
                    z2 = a.equals(this.c);
                    break;
                case 5:
                    versionCodeByString = b.getVersionCodeByString(this.c);
                    if (versionCodeByString != -1) {
                        if (b.getVersionCodeByString(a) < versionCodeByString) {
                            z = false;
                        }
                        z2 = z;
                        break;
                    }
                    break;
                case 7:
                    versionCodeByString = b.getVersionCodeByString(this.c);
                    if (versionCodeByString != -1) {
                        if (b.getVersionCodeByString(a) <= versionCodeByString) {
                            z3 = false;
                            break;
                        }
                        z3 = true;
                        break;
                    }
                case 6:
                    z3 = false;
                    break;
                case 8:
                    z2 = a(this.b, this.c);
                    break;
            }
            versionCodeByString = b.getVersionCodeByString(this.c);
            if (versionCodeByString != -1) {
                if (b.getVersionCodeByString(a) >= versionCodeByString) {
                    z = false;
                }
                z2 = z;
            } else {
                z2 = z3;
            }
        }
        Log.d(getClass().getSimpleName(), this.b + ":" + this.d + "@" + a + "#" + this.c + "=" + z2);
        return z2;
    }

    @com.vlocker.setting.common.a.b(a = "condition")
    public void setCondition(String str) {
        String toLowerCase = str.toLowerCase(Locale.ENGLISH);
        if ("any".equals(toLowerCase)) {
            this.d = 1;
        } else if ("left".equals(toLowerCase)) {
            this.d = 2;
        } else if ("right".equals(toLowerCase)) {
            this.d = 3;
        } else if ("equal".equals(toLowerCase)) {
            this.d = 4;
        } else if ("ge".equals(toLowerCase)) {
            this.d = 5;
        } else if ("lt".equals(toLowerCase)) {
            this.d = 6;
        } else if ("intent".equals(toLowerCase)) {
            this.d = 8;
        } else if ("gt".equals(toLowerCase)) {
            this.d = 7;
        }
    }

    @com.vlocker.setting.common.a.b(a = "key")
    public void setKey(String str) {
        this.b = str.toLowerCase(Locale.ENGLISH);
    }

    @com.vlocker.setting.common.a.b(a = "value")
    public void setValue(String str) {
        this.c = str.toLowerCase(Locale.ENGLISH);
    }
}
