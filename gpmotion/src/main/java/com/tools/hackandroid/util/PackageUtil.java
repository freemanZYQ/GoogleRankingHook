package com.tools.hackandroid.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhitao
 * @since 2016-05-03 15:15
 */
public class PackageUtil {

	private static List<String> mSystemPkgNameList;

	/**
	 * 获取系统应用的包名列表
	 *
	 * @param context
	 *
	 * @return
	 */
	public static List<String> getSystemPkgNameList(Context context) {
		if (mSystemPkgNameList == null || mSystemPkgNameList.isEmpty()) {
			try {
				PackageManager pm = context.getPackageManager();
				// 查询所有已经安装的应用程序
				List<ApplicationInfo> listAppcations = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
				Collections.sort(listAppcations, new ApplicationInfo.DisplayNameComparator(pm));// 排序
				mSystemPkgNameList = new ArrayList<String>(); // 保存过滤查到的AppInfo
				for (ApplicationInfo app : listAppcations) {
					if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
						mSystemPkgNameList.add(app.packageName);
					}
				}
				DLog.i("系统包名列表: ");
				for (String str : mSystemPkgNameList) {
					DLog.i("  %s", str);
				}
			} catch (Throwable e) {
				mSystemPkgNameList = Collections.emptyList();
				DLog.w(e, "没法获取到系统包名列表");
			}
		}

		return mSystemPkgNameList;
	}

	/**
	 * 获取当前在顶端运行的应用包名(适用于Andriod 5.0（不包括Android 5.0）之前的机器)
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String getTopPkgNameBelowAndroidL(Context context) {

		if (Build.VERSION.SDK_INT < 21) {
			ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			ComponentName cn = activityManager.getRunningTasks(1).get(0).topActivity;
			DLog.i("##当前顶端应用包名:%s", cn.getPackageName());
			return cn.getPackageName();
		}
		return null;
	}

	/**
	 * 获取当前在顶端运行的应用包名(适用于Andriod 5.0（不包括Android 5.0）之前的机器)
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String getTopActivityNameBelowAndroidL(Context context) {

		if (Build.VERSION.SDK_INT < 21) {
			ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			ComponentName cn = activityManager.getRunningTasks(1).get(0).topActivity;
			DLog.i("##当前顶端Activity:%s", cn.getClassName());
			return cn.getClassName();
		}
		return null;
	}

}
