package com.vlocker.msg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;

public class ap {
    public static ResolveInfo a(Context context, PackageManager packageManager, String str) {
        List b = b(context, str);
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        int size = b.size();
        for (int i = 0; i < size; i++) {
            String[] split = ((String) b.get(i)).split("/");
            String str2 = split[0];
            Object obj = split[1];
            intent.setPackage(str2);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (!(queryIntentActivities == null || queryIntentActivities.size() == 0)) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo.activityInfo.name.equals(obj)) {
                        return resolveInfo;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static ResolveInfo a(Context context, String str) {
        new Intent("android.intent.action.MAIN", null).addCategory("android.intent.category.LAUNCHER");
        PackageManager packageManager = context.getPackageManager();
        ResolveInfo a = a(context, packageManager, str);
        if (a != null) {
            return a;
        }
        List queryIntentActivities;
        Intent g = as.g(context, str);
        try {
            queryIntentActivities = packageManager.queryIntentActivities(g, 0);
        } catch (Exception e) {
            queryIntentActivities = null;
        }
        if (queryIntentActivities == null) {
            return null;
        }
        ResolveInfo resolveInfo;
        int size = queryIntentActivities.size();
        int size2;
        if (size > 0) {
            try {
                int i;
                if (str.equals("phone")) {
                    for (i = 0; i < size; i++) {
                        if (as.h(context, ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.packageName)) {
                            a = (ResolveInfo) queryIntentActivities.get(i);
                            break;
                        }
                    }
                    String str2 = a.activityInfo.packageName;
                    Intent intent = new Intent("android.intent.action.MAIN", null);
                    intent.addCategory("android.intent.category.LAUNCHER");
                    intent.setPackage(str2);
                    List queryIntentActivities2 = packageManager.queryIntentActivities(intent, 0);
                    size2 = queryIntentActivities2.size();
                    if (queryIntentActivities2 != null && size2 > 0) {
                        for (i = size - 1; i >= 0; i--) {
                            resolveInfo = (ResolveInfo) queryIntentActivities2.get(i);
                            String toLowerCase = resolveInfo.activityInfo.name.toLowerCase();
                            if ((toLowerCase.contains("phone") | toLowerCase.contains("dial")) != 0) {
                                break;
                            }
                        }
                    }
                } else {
                    for (i = 0; i < size; i++) {
                        if (as.h(context, ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.packageName)) {
                            resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                            break;
                        }
                    }
                }
                resolveInfo = a;
            } catch (Exception e2) {
                resolveInfo = a;
            }
            if (resolveInfo == null) {
                resolveInfo = (ResolveInfo) queryIntentActivities.get(0);
            }
        } else {
            List<ResolveInfo> queryIntentActivities3 = packageManager.queryIntentActivities(g, 0);
            if (queryIntentActivities3 != null && queryIntentActivities3.size() >= 0) {
                for (ResolveInfo resolveInfo2 : queryIntentActivities3) {
                    resolveInfo2.loadLabel(packageManager);
                    if (as.h(context, resolveInfo2.activityInfo.packageName)) {
                        if (!resolveInfo2.activityInfo.packageName.equals("com.android.fileManager")) {
                            a = resolveInfo2;
                            size2 = 1;
                            break;
                        }
                        a = resolveInfo2;
                    }
                }
                size2 = 0;
                if (size2 == 0 && queryIntentActivities3.size() > 0) {
                    a = (ResolveInfo) queryIntentActivities3.get(0);
                }
            }
            try {
                if (str.equals("mms")) {
                    Intent intent2 = new Intent("android.intent.action.MAIN", null);
                    intent2.addCategory("android.intent.category.LAUNCHER");
                    intent2.setPackage("com.google.android.talk");
                    resolveInfo2 = (ResolveInfo) packageManager.queryIntentActivities(intent2, 0).get(0);
                } else {
                    resolveInfo2 = a;
                }
            } catch (Exception e3) {
                resolveInfo2 = a;
            }
        }
        return resolveInfo2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List b(android.content.Context r5, java.lang.String r6) {
        /*
        r2 = new java.util.ArrayList;
        r2.<init>();
        r1 = 0;
        r0 = r5.getAssets();	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r4 = "raw/";
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r3 = r3.append(r6);	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r1 = r0.open(r3);	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r0 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r3 = new java.io.InputStreamReader;	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r3.<init>(r1);	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
    L_0x002c:
        r3 = r0.readLine();	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        if (r3 == 0) goto L_0x0042;
    L_0x0032:
        r3 = r3.trim();	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        r2.add(r3);	 Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x005a, Exception -> 0x006c }
        goto L_0x002c;
    L_0x003a:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x007e }
        r1.close();	 Catch:{ IOException -> 0x0050, Exception -> 0x0055 }
    L_0x0041:
        return r2;
    L_0x0042:
        r1.close();	 Catch:{ IOException -> 0x0046, Exception -> 0x004b }
        goto L_0x0041;
    L_0x0046:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0041;
    L_0x004b:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0041;
    L_0x0050:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0041;
    L_0x0055:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0041;
    L_0x005a:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x007e }
        r1.close();	 Catch:{ IOException -> 0x0062, Exception -> 0x0067 }
        goto L_0x0041;
    L_0x0062:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0041;
    L_0x0067:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0041;
    L_0x006c:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x007e }
        r1.close();	 Catch:{ IOException -> 0x0074, Exception -> 0x0079 }
        goto L_0x0041;
    L_0x0074:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0041;
    L_0x0079:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0041;
    L_0x007e:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0083, Exception -> 0x0088 }
    L_0x0082:
        throw r0;
    L_0x0083:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0082;
    L_0x0088:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.msg.ap.b(android.content.Context, java.lang.String):java.util.List");
    }
}
