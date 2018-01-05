package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

import com.tools.hackandroid.generator.WifiManagerGenerator;
import com.tools.hackandroid.util.DLog;

public class WIfiManagerSp extends AbsSp {

	public final static String GET_MAC_ADDRESS = "getMacAddress";

	public final static String GET_BSSID = "getBSSID";

	public final static String GET_SSID = "getSSID";

	public final static String GET_SCAN_RESULTS = "getScanResults";

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	@Override
	public String getSharedPreferencesName() {
		return WifiManager.class.getName();
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
		mSpEditor.putString(GET_MAC_ADDRESS, "test_mac");
		mSpEditor.putString(GET_BSSID, "test_bssid");
		mSpEditor.putString(GET_SSID, "test_ssid");
		mSpEditor.putStringSet(GET_SCAN_RESULTS, null);
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
				case "mac":
					char[] temp = kv[1].toCharArray();
					StringBuilder originMac = new StringBuilder(24);
					for (int i = 0; i < temp.length; ++i) {
						originMac.append(temp[i]);
						if (i != temp.length - 1 && i % 2 != 0) {
							originMac.append(":");
						}
					}
					mSpEditor.putString(GET_MAC_ADDRESS, originMac.toString());
					break;
				case "bssid":
					char[] tempbssid = kv[1].toCharArray();
					StringBuilder originBssid = new StringBuilder(24);
					for (int i = 0; i < tempbssid.length; ++i) {
						originBssid.append(tempbssid[i]);
						if (i != tempbssid.length - 1 && i % 2 != 0) {
							originBssid.append(":");
						}
					}
					mSpEditor.putString(GET_BSSID, originBssid.toString());
					break;
				}
			} catch (Throwable throwable) {
				DLog.e(throwable);
			}
		}
//		// 设置周边没有wifi
//		mSpEditor.putStringSet(GET_SCAN_RESULTS, null);
		// 随机模拟ssid
		mSpEditor.putString(GET_SSID, WifiManagerGenerator.newRandomSSID());
		mSpEditor.apply();
	}

}
