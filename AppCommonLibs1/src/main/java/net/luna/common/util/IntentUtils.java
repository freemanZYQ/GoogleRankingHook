package net.luna.common.util;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;

import net.luna.common.debug.LunaLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bintou on 2016/12/12.
 */

public class IntentUtils {

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    public static String a(Intent intent, int i) {
        String substring;
        Uri data = intent.getData();
        Intent selector = intent.getSelector();
        StringBuilder stringBuilder = new StringBuilder(128);
        if (data != null) {
            String uri = data.toString();
            if ((i & 1) != 0) {
                int length = uri.length();
                int i2 = 0;
                while (i2 < length) {
                    char charAt = uri.charAt(i2);
                    if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == '.' || charAt == '-')) {
                        i2++;
                    } else if (charAt == ':' && i2 > 0) {
                        substring = uri.substring(0, i2);
                        stringBuilder.append("intent:");
                        uri = uri.substring(i2 + 1);
                        stringBuilder.append(uri);
                    }
                }
            }
            substring = null;
            stringBuilder.append(uri);
        } else {
            if ((i & 1) != 0) {
                stringBuilder.append("intent:");
            }
            substring = null;
        }
        stringBuilder.append("#Intent;");
        a(intent, stringBuilder, substring, i);
        if (selector != null) {
            stringBuilder.append("SEL;");
            a(selector, stringBuilder, null, i);
        }
        stringBuilder.append("end");
        return stringBuilder.toString();
    }

    private static void a(Intent intent, StringBuilder stringBuilder, String str, int i) {
        String action = intent.getAction();
        List list = null;
        if (intent.getCategories() == null) {
            list = null;
        } else {
            Object arrayList = new ArrayList(intent.getCategories());
        }
        String type = intent.getType();
        int flags = intent.getFlags();
        String str2 = intent.getPackage();
        ComponentName component = intent.getComponent();
        Rect sourceBounds = intent.getSourceBounds();
        Bundle extras = intent.getExtras();
        if (str != null) {
            stringBuilder.append("scheme=").append(str).append(';');
        }
        if (action != null) {
            stringBuilder.append("action=").append(Uri.encode(action)).append(';');
        }
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                stringBuilder.append("category=").append(Uri.encode((String) list.get(i2))).append(';');
            }
        }
        if (type != null) {
            stringBuilder.append("type=").append(Uri.encode(type, "/")).append(';');
        }
        if (flags != 0) {
            stringBuilder.append("launchFlags=0x").append(Integer.toHexString(flags)).append(';');
        }
        if (str2 != null) {
            stringBuilder.append("package=").append(Uri.encode(str2)).append(';');
        }
        if (component != null) {
            stringBuilder.append("component=").append(Uri.encode(component.flattenToShortString(), "/")).append(';');
        }
        if (sourceBounds != null) {
            stringBuilder.append("sourceBounds=").append(Uri.encode(sourceBounds.flattenToString())).append(';');
        }
        if (extras != null) {
            try {
                a(stringBuilder, extras);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, Object> a(Bundle bundle) {
        try {
            Parcel parcel = null;
            Map<String, Object> hashMap = new HashMap();
            Bundle bundle2 = new Bundle(bundle);
            try {
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
                return hashMap;
            } catch (Exception e) {
                parcel = (Parcel) JavaCalls.getField(bundle2, "mParcelledData");
                if (parcel == null || parcel == JavaCalls.getField(bundle2, "EMPTY_PARCEL")) {
                    return hashMap;
                }
                int readInt = parcel.readInt();
                if (readInt < 0) {
                    return hashMap;
                }
                ClassLoader classLoader = bundle.getClassLoader();
                while (readInt > 0) {
                    hashMap.put(parcel.readString(), parcel.readValue(classLoader));
                    readInt--;
                }
            } catch (Throwable th) {
            }
            parcel.recycle();
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    private static void a(StringBuilder stringBuilder, Bundle bundle) {
        for (Map.Entry entry : a(bundle).entrySet()) {
            a(stringBuilder, (String) entry.getKey(), entry.getValue());
        }
    }

    private static void a(StringBuilder stringBuilder, String str, Object obj) {
        char c = obj instanceof String ? 'S' : obj instanceof Boolean ? 'B' : obj instanceof Byte ? 'b' : obj instanceof Character ? 'c' : obj instanceof Double ? 'd' : obj instanceof Float ? 'f' : obj instanceof Integer ? 'i' : obj instanceof Long ? 'l' : obj instanceof Short ? 's' : '\u0000';
        if (c != '\u0000') {
            stringBuilder.append(c);
            stringBuilder.append('.');
            stringBuilder.append(Uri.encode(str));
            stringBuilder.append('=');
            stringBuilder.append(Uri.encode(obj.toString()));
            stringBuilder.append(';');
        }
    }

    public static void startActivityFromPackageName(Context context, String packageName, String classPath, String action) {
        ComponentName componentName = new ComponentName(
                packageName,
                classPath);
        Intent intent = new Intent();
        if (!StringUtils.isBlank(action)) {
            intent.setAction(action);
        }
        intent.setComponent(componentName);
        context.startActivity(intent);
    }

    public static void startActivitybyAction(Context context, String packageName, String action) {

        PackageManager pm = context.getPackageManager();
        if (pm != null) {
            Intent intent = pm.getLaunchIntentForPackage(packageName);
            if (intent != null) {
                intent.setAction(action);
                context.startActivity(intent);
            }
        }
    }

    public static boolean startActivityByUri(Context context, String uri, int flags) {
        try {

            Intent intent = Intent.parseUri(uri, flags);
            if (intent == null) {
                return false;
            }

            PackageManager pm = context.getPackageManager();
            List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
            if (list == null) {
                return false;
            }

            if (list.size() <= 0) {
                return false;
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            return true;
        } catch (Throwable e) {
            LunaLog.e(e);
        }
        return false;
    }

    public static boolean startUrl(Context context, String uri) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url = Uri.parse(uri);
            intent.setData(content_url);
            context.startActivity(intent);
        } catch (Throwable e) {
            LunaLog.e(e);
        }
        return false;
    }


}
