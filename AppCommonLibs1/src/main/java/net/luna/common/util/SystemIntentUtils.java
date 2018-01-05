package net.luna.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.NonNull;

import java.util.List;

public class SystemIntentUtils {

    public static boolean startActivityByUriWithChooser(Context context, String uri, int flags, String title) {
        try {
            Intent intent = Intent.parseUri(uri, flags);
            if (intent == null) {
                return false;
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Intent startIntent = Intent.createChooser(intent, title);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startIntent);
            return true;
        } catch (Throwable e) {

        }
        return false;
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

        }
        return false;
    }

    public static boolean startServiceByUri(Context context, String uri, int flags) {
        try {
            Intent intent = Intent.parseUri(uri, flags);

            if (intent == null) {
                return false;
            }

            context.startService(intent);
            return true;
        } catch (Throwable e) {

        }
        return false;
    }

    public static boolean stopServiceByUri(Context context, String uri, int flags) {
        try {
            Intent intent = Intent.parseUri(uri, flags);

            if (intent == null) {
                return false;
            }

            return context.stopService(intent);

        } catch (Throwable e) {

        }
        return false;
    }

    public static boolean startActivityByPackageName(Context context, String packageName, int flags) {
        try {
            PackageManager pm = context.getPackageManager();
            if (pm != null) {
                Intent intent = pm.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    intent.addFlags(flags);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    return true;
                }
            }

        } catch (Throwable e) {

        }

        return false;
    }

    public static Intent getIntentForStartActivityByPackagename(Context context, String packageName) {
        try {
            PackageManager pm = context.getPackageManager();
            if (pm != null) {
                Intent intent = pm.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    return intent;
                }
            }

        } catch (Throwable e) {

        }
        return null;
    }

    public static boolean startActivityByPackageName(Context context, String packageName) {
        try {
            PackageManager pm = context.getPackageManager();
            if (pm != null) {
                Intent intent = pm.getLaunchIntentForPackage(packageName);

                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    return true;
                }
            }

        } catch (Throwable e) {

        }

        return false;
    }

    /**
     * 发送广播事件
     *
     * @param context
     * @param uri
     * @param flags
     * @param receiverPermission
     * @return
     */
    public static boolean sendBroadcastByUri(Context context, String uri, int flags, String receiverPermission) {
        try {

            Intent intent = Intent.parseUri(uri, flags);

            if (intent != null) {

                if (receiverPermission != null) {
                    context.sendBroadcast(intent, receiverPermission);
                    return true;
                } else {
                    context.sendBroadcast(intent);
                    return true;
                }
            }

        } catch (Throwable e) {

        }

        return false;
    }


    public static void wirelessSetting(Context context) {
        try {
            context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } catch (Throwable e) {

        }
    }

    /**
     * 使用系统默认浏览器打开网页
     *
     * @param context
     * @param url
     */
    public static void openUrlByDefaultBrowser(Context context, String url) {
        Intent intent = getToWebUrlIntent(context, null, null, url);
        context.startActivity(intent);
    }

    /**
     * 获取打开url的Intent
     *
     * @param context
     * @param browserPackageName 可为null
     * @param browserActivity    可为null
     * @param url
     * @return
     */
    public static Intent getToWebUrlIntent(Context context, String browserPackageName, String browserActivity,
                                           String url) {

        Intent intent = null;
        try {

            if (browserPackageName != null) {

                if (browserActivity != null) {
                    try {
                        PackageInfo pi = context.getPackageManager().getPackageInfo(browserPackageName, 0);

                        if (pi != null) {
                            intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.setClassName(browserPackageName, browserActivity);
                            intent.addCategory(Intent.CATEGORY_DEFAULT);
                            intent.setData(Uri.parse(url));
                        }

                    } catch (Throwable e) {

                    }

                } else {

                    try {
                        intent = context.getPackageManager().getLaunchIntentForPackage(browserPackageName);
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.setData(Uri.parse(url));

                    } catch (Throwable e) {

                    }
                }

            }

            if (intent == null) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        } catch (Throwable e) {

        }
        return intent;
    }

    /**
     * 判断是否有可以接受的Activity
     */
    public static boolean isIntentAvailable(@NonNull Context context, @NonNull Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).isEmpty();
    }


}
