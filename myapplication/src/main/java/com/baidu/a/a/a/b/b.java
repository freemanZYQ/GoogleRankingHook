package com.baidu.a.a.a.b;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.a.a.a.a.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public final class b {

    final class a {
        public final String a;
        public final boolean b;

        private a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        static a a(Context context) {
            String a;
            boolean z;
            Throwable e;
            boolean z2 = false;
            String str = "";
            try {
                CharSequence string = System.getString(context.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string)) {
                    a = a(context, "");
                } else {
                    CharSequence charSequence = string;
                }
                try {
                    System.putString(context.getContentResolver(), "bd_setting_i", a);
                    z = false;
                } catch (Exception e2) {
                    e = e2;
                    Log.e("DeviceId", "Settings.System.getString or putString failed", e);
                    if (TextUtils.isEmpty(a)) {
                        a = a(context, "");
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        z2 = true;
                    }
                    return new a(a, z2);
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                a = str;
                e = th;
                Log.e("DeviceId", "Settings.System.getString or putString failed", e);
                if (TextUtils.isEmpty(a)) {
                    a = a(context, "");
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    z2 = true;
                }
                return new a(a, z2);
            }
            if (z) {
                z2 = true;
            }
            return new a(a, z2);
        }

        private static String a(Context context, String str) {
            String deviceId;
            CharSequence a;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    deviceId = telephonyManager.getDeviceId();
                    a = a(deviceId);
                    return TextUtils.isEmpty(a) ? str : a;
                }
            } catch (Throwable e) {
                Log.e("DeviceId", "Read IMEI failed", e);
            }
            deviceId = null;
            a = a(deviceId);
            if (TextUtils.isEmpty(a)) {
            }
        }

        private static String a(String str) {
            return (str == null || !str.contains(":")) ? str : "";
        }
    }

    public static String a(Context context) {
        a(context, "android.permission.WRITE_SETTINGS");
        a(context, "android.permission.READ_PHONE_STATE");
        a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        a a = a.a(context);
        String str = a.a;
        boolean z = !a.b;
        String c = c(context);
        String str2 = "";
        if (z) {
            return c.a(("com.baidu" + c).getBytes(), true);
        }
        String str3 = null;
        Object string = System.getString(context.getContentResolver(), "com.baidu.deviceid");
        if (TextUtils.isEmpty(string)) {
            str3 = c.a(("com.baidu" + str + c).getBytes(), true);
            string = System.getString(context.getContentResolver(), str3);
            if (!TextUtils.isEmpty(string)) {
                System.putString(context.getContentResolver(), "com.baidu.deviceid", string);
                a(str, (String) string);
            }
        }
        if (TextUtils.isEmpty(string)) {
            string = a(str);
            if (!TextUtils.isEmpty(string)) {
                System.putString(context.getContentResolver(), str3, string);
                System.putString(context.getContentResolver(), "com.baidu.deviceid", string);
            }
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        str2 = c.a(new StringBuilder(String.valueOf(str)).append(c).append(UUID.randomUUID().toString()).toString().getBytes(), true);
        System.putString(context.getContentResolver(), str3, str2);
        System.putString(context.getContentResolver(), "com.baidu.deviceid", str2);
        a(str, str2);
        return str2;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory(), "baidu/.cuid")));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
                stringBuilder.append("\r\n");
            }
            bufferedReader.close();
            String[] split = new String(com.baidu.a.a.a.a.a.b("30212102dicudiab", "30212102dicudiab", com.baidu.a.a.a.a.b.a(stringBuilder.toString().getBytes()))).split("=");
            return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : str2;
        } catch (FileNotFoundException e) {
            return str2;
        } catch (IOException e2) {
            return str2;
        } catch (Exception e3) {
            return str2;
        }
    }

    private static void a(Context context, String str) {
        if ((context.checkCallingOrSelfPermission(str) == 0 ? 1 : null) == null) {
            throw new SecurityException("Permission Denial: requires permission " + str);
        }
    }

    private static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append(str2);
            File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
            try {
                new File(file.getParent()).mkdirs();
                FileWriter fileWriter = new FileWriter(file, false);
                fileWriter.write(com.baidu.a.a.a.a.b.a(com.baidu.a.a.a.a.a.a("30212102dicudiab", "30212102dicudiab", stringBuilder.toString().getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    public static String b(Context context) {
        return a.a(context).a;
    }

    public static String c(Context context) {
        String str = "";
        str = "";
        Object string = Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }
}
