package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

import com.tools.hackandroid.util.DLog;

public class BuildVersionSp extends AbsSp {

	public final static String BASE_OS = "BASE_OS";

	public final static String PREVIEW_SDK_INT = "PREVIEW_SDK_INT";

	public final static String SECURITY_PATCH = "SECURITY_PATCH";

	public final static String CODENAME = "CODENAME";

	public final static String INCREMENTAL = "INCREMENTAL";

	public final static String RELEASE = "RELEASE";

	public final static String SDK_INT = "SDK_INT";

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	@Override
	public String getSharedPreferencesName() {
		return Build.VERSION.class.getName();
	}

	/**
	 * 输入测试数据
	 *
	 * @param context
	 * @param sharedPreferences 数据所保存到的sp文件
	 */
	@Override
	protected void inputTestData(Context context, SharedPreferences sharedPreferences) {
		SharedPreferences.Editor mSpEditor = getSharedPreferences(context).edit();
		mSpEditor.putString(BASE_OS, "1");
		mSpEditor.putString(PREVIEW_SDK_INT, "2");
		mSpEditor.putString(SECURITY_PATCH, "3");
		mSpEditor.putString(CODENAME, "4");
		mSpEditor.putString(INCREMENTAL, "5");
		mSpEditor.putString(RELEASE, "6");
		mSpEditor.putString(SDK_INT, "17");
		mSpEditor.apply();
	}

	/**
	 * 输入随机数据
	 *
	 * @param context
	 * @param sharedPreferences 数据所保存到的sp文件
	 */
	@Override
	protected void inputRandomData(Context context, SharedPreferences sharedPreferences) {

	}

	/**
	 * 输入指定的数组数据
	 *
	 * @param context
	 * @param sharedPreferences   数据所保存到的sp文件
	 * @param keyValueStringArray e.g new String [] {"key1=value1", "key2=value2", "key3=value3"}
	 */
	@Override
	protected void inputDataFromKeyValueStringArray(Context context, SharedPreferences sharedPreferences,
			String[] keyValueStringArray) {
		SharedPreferences.Editor mSpEditor = sharedPreferences.edit();
		for (String str : keyValueStringArray) {
			try {
				String[] kv = str.split("=", 2);
				if (kv.length != 2) {
					continue;
				}
				if (TextUtils.isEmpty(kv[0]) || TextUtils.isEmpty(kv[1])) {
					continue;
				}
				switch (kv[0]) {
				case "osv":
					if (!kv[1].startsWith("android ")) {
						continue;
					}
					String release = kv[1].substring(8);
					mSpEditor.putString(RELEASE, release);

					// 因为暂时没有传入SDK_INIT的值，所以不能只改RELEASE的值，还需要同时根据 RELEASE 的值改回SDK_INIT
					//					int sdkinit = 14;
					//					if (release.startsWith("4.0")) {
					//						sdkinit = 14;
					//					}
					//					if (release.startsWith("4.0.3")) {
					//						sdkinit = 15;
					//					}
					//					if (release.startsWith("4.1")) {
					//						sdkinit = 16;
					//					}
					//					if (release.startsWith("4.2")) {
					//						sdkinit = 17;
					//					}
					//					if (release.startsWith("4.3")) {
					//						sdkinit = 18;
					//					}
					//					if (release.startsWith("4.4")) {
					//						sdkinit = 19;
					//					}
					//					if (release.startsWith("4.4W")) {
					//						sdkinit = 20;
					//					}
					//					if (release.startsWith("5.0")) {
					//						sdkinit = 21;
					//					}
					//					if (release.startsWith("5.1")) {
					//						sdkinit = 22;
					//					}
					//					if (release.startsWith("6")) {
					//						sdkinit = 23;
					//					}
					//					mSpEditor.putString(SDK_INT, sdkinit + "");
					break;
				}
			} catch (Throwable e) {
				DLog.e(e);
			}
		}
		mSpEditor.putString(INCREMENTAL, String.valueOf((int) (Math.random() * 100000)));
		mSpEditor.apply();

	}
}
