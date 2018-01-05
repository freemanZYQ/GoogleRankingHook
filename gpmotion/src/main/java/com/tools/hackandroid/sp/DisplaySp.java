package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.Display;

import com.tools.hackandroid.util.DLog;

public class DisplaySp extends AbsSp {

	public final static String WIDTH_PX = "widthPixels";

	public final static String HEIGHT_PX = "heightPixels";

	public final static String DENSITY_DPI = "densityDpi";

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	@Override
	public String getSharedPreferencesName() {
		return Display.class.getName();
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
		mSpEditor.putString(WIDTH_PX, "123");
		mSpEditor.putString(HEIGHT_PX, "456");
		mSpEditor.putString(DENSITY_DPI, "789");
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
				case "sd":
					mSpEditor.putString(DENSITY_DPI, kv[1]);
					break;
				case "sw":
					mSpEditor.putString(WIDTH_PX, kv[1]);
					break;
				case "sh":
					mSpEditor.putString(HEIGHT_PX, kv[1]);
					break;
				}
			} catch (Throwable e) {
				DLog.e(e);
			}
		}
		mSpEditor.apply();
	}

}


