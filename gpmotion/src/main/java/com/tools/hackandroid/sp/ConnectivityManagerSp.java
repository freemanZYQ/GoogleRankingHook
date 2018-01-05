package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;

public class ConnectivityManagerSp extends AbsSp {

	public final static String IS_AVAILABLE = "isAvailable";

	public final static String TYPE = "type";

	public final static String APN = "apn";

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	@Override
	public String getSharedPreferencesName() {
		return ConnectivityManager.class.getName();
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
		mSpEditor.putString(IS_AVAILABLE, "true");
		mSpEditor.putString(TYPE, "" + ConnectivityManager.TYPE_MOBILE);
		mSpEditor.putString(APN, "test_APN" + System.currentTimeMillis());
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
//		SharedPreferences.Editor mSpEditor = sharedPreferences.edit();
//		mSpEditor.putString(IS_AVAILABLE, "true");
//		mSpEditor.putString(TYPE, "" + ConnectivityManager.TYPE_MOBILE);
//		for (String str : keyValueStringArray) {
//			try {
//				String[] kv = str.split("=", 2);
//		if (kv.length != 2) {
//			continue;
//		}
//				if (TextUtils.isEmpty(kv[0]) || TextUtils.isEmpty(kv[1])) {
//					continue;
//				}
//				switch (kv[0]) {
//				case "apn":
//					mSpEditor.putString(APN, kv[1]);
//					break;
//				}
//			} catch (Throwable e) {
//				DLog.e(e);
//			}
//		}
//		mSpEditor.apply();

	}

}
