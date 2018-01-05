package com.tools.hackandroid.accessibility.util;

import android.content.Context;
import android.provider.Settings;
import android.support.annotation.NonNull;

import com.tools.hackandroid.util.DLog;

/**
 * @author zhitao
 * @since 2016-08-03 17:47
 */
public class AccessibilityServiceUtil {

	/**
	 * 判断当前应用的辅助功能服务是否开启
	 */
	public static boolean isAccessibilitySettingsOn(@NonNull Context context) {
		return isAccessibilitySettingsOn(context, context.getPackageName());
	}

	/**
	 * 判断指定的应用的辅助功能是否开启
	 *
	 * @param context
	 * @param pkgname 要检查的服务所对应的app包名
	 *
	 * @return
	 */
	public static boolean isAccessibilitySettingsOn(@NonNull Context context, @NonNull String pkgname) {
		int accessibilityEnabled = 0;
		try {
			accessibilityEnabled =
					Settings.Secure.getInt(context.getContentResolver(), android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
		} catch (Exception e) {
			DLog.e(e);
		}

		if (accessibilityEnabled == 1) {
			String services =
					Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
			if (services != null) {
				return services.toLowerCase().contains(pkgname.toLowerCase());
			}
		}
		return false;
	}

	//	/**
	//	 * 判断指定的应用的辅助功能是否开启，不能判断自身的辅助功能服务是否开启
	//	 *
	//	 * @param name
	//	 *
	//	 * @return
	//	 */
	//	private boolean enabled(@NonNull Context context, @NonNull String name) {
	//		AccessibilityManager am = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
	//		List<AccessibilityServiceInfo> serviceInfos =
	//				am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
	//		List<AccessibilityServiceInfo> installedAccessibilityServiceList = am.getInstalledAccessibilityServiceList();
	//		for (AccessibilityServiceInfo info : installedAccessibilityServiceList) {
	//			Log.d("MainActivity", "all -->" + info.getId());
	//			if (name.equals(info.getId())) {
	//				return true;
	//			}
	//		}
	//		return false;
	//	}

}
