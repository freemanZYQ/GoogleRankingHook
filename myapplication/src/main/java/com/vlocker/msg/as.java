package com.vlocker.msg;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.m.aj;
import com.vlocker.msg.data.a;
import com.vlocker.msg.data.b;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.security.MoSecurityApplication;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.TimeZone;
import mcm.sdk.a.a.c.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class as {
    public static final String[] a = new String[]{"com.moxiu.launcher", "com.tencent.mtt", "com.UCMobile", "com.baidu.searchbox", "com.baidu.browser.apps", "com.qihoo.browser"};
    public static final String[] b = new String[]{"com.moxiu.browser.BrowserActivity", "com.tencent.mtt.SplashActivity", "com.UCMobile.main.UCMobile", "com.baidu.searchbox.MainActivity", "com.baidu.browser.framework.BdBrowserActivity", "com.qihoo.browser.BrowserActivity"};
    public static int c = 2;
    public static int d = 1;
    public static int e = 3;

    private static long a(long j) {
        return (((long) TimeZone.getDefault().getOffset(j)) + j) / 86400000;
    }

    public static long a(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
            Date parse2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1970-01-01 08:00:00");
            return parse.getTime() - parse2.getTime() > 0 ? parse.getTime() - parse2.getTime() : parse2.getTime() - parse.getTime();
        } catch (Exception e) {
            return 0;
        }
    }

    public static Intent a(Context context, String str) {
        int i = 0;
        Intent intent = new Intent();
        try {
            ArrayList a = a(context);
            while (i < a.length) {
                if (b(context, a[i])) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i <= -1 || i >= a.length) {
                try {
                    if (a.size() <= 0) {
                        return c(context, str);
                    }
                    b bVar = (b) a.get(a.size() - 1);
                    Intent parseUri = Intent.parseUri(str, 0);
                    parseUri.setPackage(bVar.a());
                    parseUri.addFlags(268435456);
                    return parseUri;
                } catch (Exception e) {
                    return c(context, str);
                }
            }
            ComponentName componentName = new ComponentName(a[i], b[i]);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.BROWSABLE");
            return intent;
        } catch (Exception e2) {
            return c(context, str);
        }
    }

    public static Intent a(Context context, String str, Bundle bundle) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                String str2 = resolveInfo.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setFlags(268435456);
                if (bundle != null) {
                    intent2.putExtras(bundle);
                }
                intent2.setComponent(new ComponentName(str, str2));
                return intent2;
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? null : str.trim() + "/" + str2.trim();
    }

    public static ArrayList a(Context context) {
        Intent parseUri;
        URISyntaxException e;
        int size;
        int i;
        b bVar;
        ActivityInfo activityInfo;
        List list = null;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        try {
            parseUri = Intent.parseUri("http://www.google.com/m", 0);
            try {
                parseUri.setAction("android.intent.action.VIEW");
                parseUri.addCategory("android.intent.category.BROWSABLE");
            } catch (URISyntaxException e2) {
                e = e2;
                e.printStackTrace();
                list = packageManager.queryIntentActivities(parseUri, 0);
                if (list != null) {
                    return arrayList;
                }
                size = list.size();
                if (size > 0) {
                    for (i = 0; i < size; i++) {
                        bVar = new b();
                        activityInfo = ((ResolveInfo) list.get(i)).activityInfo;
                        bVar.b(activityInfo.loadLabel(packageManager).toString());
                        bVar.a(activityInfo.loadIcon(packageManager));
                        bVar.a(activityInfo.applicationInfo.packageName);
                        arrayList.add(bVar);
                    }
                }
                return arrayList;
            }
        } catch (URISyntaxException e3) {
            e = e3;
            parseUri = list;
            e.printStackTrace();
            list = packageManager.queryIntentActivities(parseUri, 0);
            if (list != null) {
                return arrayList;
            }
            size = list.size();
            if (size > 0) {
                for (i = 0; i < size; i++) {
                    bVar = new b();
                    activityInfo = ((ResolveInfo) list.get(i)).activityInfo;
                    bVar.b(activityInfo.loadLabel(packageManager).toString());
                    bVar.a(activityInfo.loadIcon(packageManager));
                    bVar.a(activityInfo.applicationInfo.packageName);
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        try {
            list = packageManager.queryIntentActivities(parseUri, 0);
        } catch (Exception e4) {
        }
        if (list != null) {
            return arrayList;
        }
        size = list.size();
        if (size > 0) {
            for (i = 0; i < size; i++) {
                bVar = new b();
                activityInfo = ((ResolveInfo) list.get(i)).activityInfo;
                if (!(activityInfo.applicationInfo.packageName.equals("com.baidu.browser.apps") || activityInfo.applicationInfo.packageName.equals("com.taobao.taobao") || activityInfo.applicationInfo.packageName.equals("com.ijinshan.browser_fast"))) {
                    bVar.b(activityInfo.loadLabel(packageManager).toString());
                    bVar.a(activityInfo.loadIcon(packageManager));
                    bVar.a(activityInfo.applicationInfo.packageName);
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public static void a(Context context, int i) {
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    public static void a(Context context, long j, String str) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent("com.vlocker.locker.AlarmSend");
        intent.putExtra("eventNames", str);
        alarmManager.set(0, j, PendingIntent.getBroadcast(context, 0, intent, 134217728));
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, FlowWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        intent.putExtra("tag", str3);
        context.startActivity(intent);
    }

    public static void a(Context context, List list) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        String str = "";
        int i = 0;
        Object obj = null;
        while (i < list.size()) {
            String str2;
            Object obj2;
            if (obj != null && ((a) list.get(i)).a() == j) {
                str = str + "|" + ((a) list.get(i)).c();
            }
            if (obj != null || ((a) list.get(i)).a() < currentTimeMillis) {
                str2 = str;
                obj2 = obj;
            } else {
                obj2 = 1;
                j = ((a) list.get(i)).a();
                str2 = ((a) list.get(i)).c();
            }
            i++;
            obj = obj2;
            str = str2;
        }
        if (obj != null) {
            a(context, j, str);
        }
    }

    public static void a(Context context, JSONObject jSONObject, int i) {
        McmPushWidget.getInstance(context).handleMsgTypeOpen(jSONObject, d(context, jSONObject.getJSONObject("intent").toString()), 1, i);
        WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(268435466, "MyPower");
        if (com.vlocker.theme.f.b.a()) {
            newWakeLock.acquire(10000);
        } else {
            newWakeLock.acquire(1);
        }
    }

    public static boolean a() {
        return System.currentTimeMillis() - com.vlocker.c.a.a(MoSecurityApplication.a()).M() < 86400000;
    }

    public static boolean a(long j, long j2) {
        long j3 = j - j2;
        return j3 < 86400000 && j3 > -86400000 && a(j) == a(j2);
    }

    public static boolean a(Context context, ak akVar) {
        if (akVar == null) {
            return false;
        }
        try {
            Intent intent = akVar.m;
            if (intent == null) {
                intent = d(context, akVar.D);
            }
            if (intent == null || !intent.getBooleanExtra("unlock", false)) {
                return false;
            }
            String str = "com.taobao.taobao";
            return ("taobao".equals(intent.getStringExtra("sub_type")) && j.b(context, str) && aj.b(context, str) >= 123) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    public static int b(String str) {
        String[] split = str.split("\\|");
        int i = 113;
        if (str.equals("msg_ad")) {
            i = 200;
        }
        return split.length == 3 ? Integer.parseInt(split[2]) : i;
    }

    public static Intent b(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            ComponentName componentName = new ComponentName(str, str2);
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(componentName);
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setComponent(new ComponentName(str, str2));
        intent.setData(Uri.parse(str3));
        return intent;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Alarm", 0);
        List arrayList = new ArrayList();
        for (Entry entry : sharedPreferences.getAll().entrySet()) {
            String string = sharedPreferences.getString((String) entry.getKey(), null);
            if (string != null) {
                try {
                    String string2 = new JSONObject(string).getString("time");
                    a aVar = new a();
                    aVar.a(string2);
                    aVar.b((String) entry.getKey());
                    long a = a(string2);
                    if (a < System.currentTimeMillis() - 259200000) {
                        Editor edit = sharedPreferences.edit();
                        edit.remove((String) entry.getKey());
                        edit.commit();
                    } else {
                        aVar.a(a);
                        arrayList.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (arrayList.size() != 0) {
            Collections.sort(arrayList);
            a(context, arrayList);
        }
    }

    public static boolean b() {
        Date date = new Date();
        return date.getHours() == 6 || (date.getHours() == 7 && date.getMinutes() <= 30);
    }

    public static boolean b(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static Intent c(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addCategory("android.intent.category.BROWSABLE");
        return intent;
    }

    public static String c(String str) {
        try {
            return str.substring(0, str.indexOf(47));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void c(Context context) {
        try {
            ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent("com.vlocker.locker.AlarmSend"), 134217728));
        } catch (Exception e) {
        }
    }

    public static Intent d(Context context, String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        Intent a;
        JSONObject optJSONObject = jSONObject.optJSONObject("intent");
        if (optJSONObject == null) {
            optJSONObject = jSONObject;
        }
        String optString = optJSONObject.optString("package");
        Object optString2 = optJSONObject.optString("className");
        Object optString3 = optJSONObject.optString("uri");
        JSONArray optJSONArray = optJSONObject.optJSONArray("extras");
        if (TextUtils.isEmpty(optString)) {
            try {
                a = !TextUtils.isEmpty(optString2) ? new c(new Intent(context, Class.forName(optString2))).a(optJSONArray) : null;
            } catch (ClassNotFoundException e2) {
                return null;
            }
        }
        try {
            a = TextUtils.isEmpty(optString2) ? a(context, optString, null) : b(context, optString, optString2, null);
            if (optJSONArray != null) {
                a = new c(a).a(optJSONArray);
            }
        } catch (Exception e3) {
            return null;
        }
        if (!TextUtils.isEmpty(optString3)) {
            if (a == null) {
                try {
                    a = new Intent("android.intent.action.VIEW");
                } catch (Exception e4) {
                    return null;
                }
            }
            a.setData(Uri.parse(optString3));
        }
        return (a == null || !com.vlocker.setting.a.b.validateIntent(context.getPackageManager(), a)) ? null : a;
    }

    public static void d(Context context) {
        if ("A_tengxun".equals(j.p(context))) {
            String str = "Vlock_Count_AppUser_PPC_TF";
            String[] strArr = new String[4];
            strArr[0] = "App_name";
            strArr[1] = aj.a("com.youku.phone") ? "youku" : "no_youku";
            strArr[2] = "App_version";
            strArr[3] = f(context, "com.youku.phone");
            p.a(context, str, strArr);
            str = "Vlock_Count_AppUser_PPC_TF";
            strArr = new String[4];
            strArr[0] = "App_name";
            strArr[1] = aj.a("com.sina.weibo") ? "weibo" : "no_weibo";
            strArr[2] = "App_version";
            strArr[3] = f(context, "com.sina.weibo");
            p.a(context, str, strArr);
            str = "Vlock_Count_AppUser_PPC_TF";
            strArr = new String[4];
            strArr[0] = "App_name";
            strArr[1] = aj.a("com.sina.weibog3") ? "weibo3" : "no_weibo3";
            strArr[2] = "App_version";
            strArr[3] = f(context, "com.sina.weibog3");
            p.a(context, str, strArr);
        }
    }

    public static void e(Context context, String str) {
        String[] split = str.split("[|]");
        for (String str2 : split) {
            if (str2 != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("Alarm", 0);
                int parseInt = Integer.parseInt(str2.split(":")[0]);
                if (str2.split(":")[1].equals("star")) {
                    try {
                        String string = sharedPreferences.getString(str2, "");
                        if (string != null) {
                            a(context, new JSONObject(string), parseInt);
                            p.a(context, "Vlocker_Show_HBRemind_PPC_YZY", new String[0]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str2.split(":")[1].equals("end")) {
                    a(context, parseInt);
                    ab.e(context.getPackageName() + "|" + 1 + "|" + parseInt);
                }
                Editor edit = sharedPreferences.edit();
                edit.remove(str2);
                edit.commit();
            }
        }
        b(context);
    }

    public static String f(Context context, String str) {
        if (!aj.a(str)) {
            return "0";
        }
        try {
            String str2 = context.getPackageManager().getPackageInfo(str, 0).versionName;
            return str2 == null ? "0" : str2;
        } catch (Exception e) {
            return "0";
        }
    }

    public static Intent g(Context context, String str) {
        try {
            Intent intent;
            if (str.equals("phone")) {
                intent = new Intent("android.intent.action.MAIN", null);
                intent.setAction("android.intent.action.DIAL");
                return intent;
            } else if (!str.equals("mms")) {
                return null;
            } else {
                if (VERSION.SDK_INT >= 23) {
                    intent = new Intent();
                    intent.setAction("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.APP_MESSAGING");
                    return intent;
                }
                intent = new Intent();
                intent.setAction("android.intent.action.MAIN");
                intent.setType("vnd.android-dir/mms-sms");
                return intent;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean h(Context context, String str) {
        try {
            return (context.getPackageManager().getPackageInfo(str, 0).applicationInfo.flags & 1) > 0;
        } catch (OutOfMemoryError e) {
            return false;
        } catch (NameNotFoundException e2) {
            return false;
        } catch (Exception e3) {
            return false;
        }
    }
}
