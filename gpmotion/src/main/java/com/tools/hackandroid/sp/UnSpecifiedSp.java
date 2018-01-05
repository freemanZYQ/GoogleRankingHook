package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.tools.hackandroid.util.DLog;

/**
 * 存放一些还没有想好放在哪里的hook
 */
public class UnSpecifiedSp extends AbsSp {

	public static final String ANDROID_ID = "androidid";

	public static final String MAC_FROM_FILE = "macFromFile";

	public static final String GOOGLE_AD_ID = "google_ad_id";

	public static final String ADB_ENABLED = "adb_enabled";

	public static final String BLUETOOTH_MAC = "bluetooth_mac";

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	@Override
	public String getSharedPreferencesName() {
		return "unSpecified";
	}

	/**
	 * 输入测试数据
	 *
	 * @param context
	 * @param sharedPreferences 数据所保存到的sp文件
	 */
	@Override
	protected void inputTestData(Context context, SharedPreferences sharedPreferences) {
		SharedPreferences.Editor mSpEditor = sharedPreferences.edit();
		mSpEditor.putString(ANDROID_ID, "test_androidid");
		mSpEditor.putString(MAC_FROM_FILE, "test_mac_from_file");
		mSpEditor.putString(GOOGLE_AD_ID, "test_google_adid");
		mSpEditor.putString(ADB_ENABLED, "0");// 修改为没有开启过开发者调试模式
		mSpEditor.putString(BLUETOOTH_MAC, "test_bluetooth");
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
				case "andid":
					mSpEditor.putString(ANDROID_ID, kv[1]);
					break;
				case "mac":
					char[] temp = kv[1].toCharArray();
					StringBuilder originMac = new StringBuilder(24);
					for (int i = 0; i < temp.length; ++i) {
						originMac.append(temp[i]);
						if (i != temp.length - 1 && i % 2 != 0) {
							originMac.append(":");
						}
					}
					mSpEditor.putString(MAC_FROM_FILE, originMac.toString());
					break;
				case "gvid":
					mSpEditor.putString(GOOGLE_AD_ID, kv[1]);
					break;
				case "bd":
					mSpEditor.putString(BLUETOOTH_MAC, kv[1]);
					break;
				// TODO 考虑完成下面几个参数的写入
				//			case "scid":
				//			case "lat":(忽略)
				//			case "lon":(忽略)
				//			case "bsi":(忽略)
				}
			} catch (Throwable throwable) {
				DLog.e(throwable);
			}
		}
		mSpEditor.putString(ADB_ENABLED, "0");// 修改为没有开启过开发者调试模式
		mSpEditor.apply();
	}

}


