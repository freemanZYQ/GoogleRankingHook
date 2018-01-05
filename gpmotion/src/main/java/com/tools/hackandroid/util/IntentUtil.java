package com.tools.hackandroid.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

/**
 * @author zhitao
 * @since 2016-08-08 15:45
 */
public class IntentUtil {

	/**
	 * 打开app的应用详细设置页面
	 *
	 * @param context
	 * @param pkgName
	 *
	 * @return
	 */
	public static void openAppDetailSettingPage(Context context, String pkgName) {
		try {
			//Open the specific App Info page:
			Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
			intent.setData(Uri.parse("package:" + pkgName));
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);

		} catch (ActivityNotFoundException e) {
			DLog.w("没有该activity,转为打开应用管理页面");
			//e.printStackTrace();
			//Open the generic Apps page:
			Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
			context.startActivity(intent);
		}
	}

	public static boolean startActivityByPackageName(Context context, String packageName) {
		return startActivityByPackageName(context, packageName, -1);
	}

	public static boolean startActivityByPackageName(Context context, String packageName, int flags) {
		try {
			PackageManager pm = context.getPackageManager();
			if (pm != null) {
				Intent intent = pm.getLaunchIntentForPackage(packageName);
				if (intent != null) {
					if (flags >= 0) {
						intent.addFlags(flags);
					}
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
					return true;
				}
			}

		} catch (Throwable e) {
			DLog.i(e);
		}

		return false;
	}
}
