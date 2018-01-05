package com.vlocker.settings;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.vlocker.c.a;
import java.util.ArrayList;
import java.util.List;

public class w {
    public static final String[] a = new String[]{"com.meitu.makeup", "jp.gmo_media.decoproject", "cn.nubia.camera", "com.mt.mtxx.mtxx", "com.meitu.meiyancamera"};
    public static final String[] b = new String[]{"com.meitu.meipaimv", "com.yixia.videoeditor", "com.smile.gifmaker", "com.intsig.BizCardReader"};

    public static ArrayList a(Context context, ArrayList arrayList) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            for (String equals : a) {
                if (equals.equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                    dc dcVar = new dc();
                    dcVar.b = resolveInfo.activityInfo.applicationInfo.packageName;
                    dcVar.c = resolveInfo.activityInfo.name;
                    dcVar.a = resolveInfo.loadLabel(packageManager).toString().trim();
                    dcVar.d = resolveInfo.loadIcon(packageManager);
                    arrayList.add(dcVar);
                }
            }
        }
        return arrayList;
    }

    public static boolean a(Context context) {
        a a = a.a(context);
        PackageManager packageManager = context.getPackageManager();
        List queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.media.action.STILL_IMAGE_CAMERA"), 0);
        if (queryIntentActivities.size() > 0 && !"com.intsig.BizCardReader".equals(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.applicationInfo.packageName)) {
            a.z(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.applicationInfo.packageName);
            a.B(((ResolveInfo) queryIntentActivities.get(0)).loadLabel(packageManager).toString().trim());
        } else if (queryIntentActivities.size() <= 1 || !"com.intsig.BizCardReader".equals(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.applicationInfo.packageName)) {
            ArrayList a2 = a(context, new ArrayList());
            if (a2.size() <= 0) {
                return false;
            }
            a.z(((dc) a2.get(0)).b);
            a.B(((dc) a2.get(0)).a);
            if (a(((dc) a2.get(0)).b)) {
                a.A(((dc) a2.get(0)).c);
            }
        } else {
            a.z(((ResolveInfo) queryIntentActivities.get(1)).activityInfo.applicationInfo.packageName);
            a.B(((ResolveInfo) queryIntentActivities.get(1)).loadLabel(packageManager).toString().trim());
        }
        return true;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        for (String equals : a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
