package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.BatteryManager;

import java.util.Random;

/**
 * @author zhitao
 * @since 2016-04-18 17:02
 */
public class BatterySp extends AbsSp {

	public final static String EXTRA_LEVEL = "level";

	public final static String EXTRA_SCALE = "scale";

	public final static String EXTRA_STATUS = "status";

	public final static String EXTRA_HEALTH = "health";

	public final static String EXTRA_ICON_SMALL = "icon-small";

	public final static String EXTRA_PLUGGED = "plugged";

	public final static String EXTRA_PRESENT = "present";

	public final static String EXTRA_TECHNOLOGY = "technology";

	public final static String EXTRA_TEMPERATURE = "temperature";

	public final static String EXTRA_VOLTAGE = "voltage";

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	@Override
	public String getSharedPreferencesName() {
		return BatteryManager.class.getName();
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
		mSpEditor.putInt(EXTRA_LEVEL, 10);
		mSpEditor.putInt(EXTRA_SCALE, 100);
		mSpEditor.putInt(EXTRA_STATUS, BatteryManager.BATTERY_STATUS_NOT_CHARGING);
		mSpEditor.putInt(EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_GOOD);
		mSpEditor.putInt(EXTRA_ICON_SMALL, 123);
		mSpEditor.putInt(EXTRA_PLUGGED, -1);
		mSpEditor.putBoolean(EXTRA_PRESENT, true);
		mSpEditor.putString(EXTRA_TECHNOLOGY, "test_tech");
		mSpEditor.putInt(EXTRA_TEMPERATURE, 1230);
		mSpEditor.putInt(EXTRA_VOLTAGE, 4560);
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
		//		for (String str : keyValueStringArray) {
		//			try {
		//		String[] kv = str.split("=", 2);
		//		if (kv.length != 2) {
		//			continue;
		//		}
		//				if (TextUtils.isEmpty(kv[0]) || TextUtils.isEmpty(kv[1])) {
		//					continue;
		//				}
		//				switch (kv[0]) {
		//				case "rb":
		//					mSpEditor.putInt(EXTRA_LEVEL, Integer.parseInt(kv[1]));
		//					break;
		//				case "usb":
		//					mSpEditor.putInt(EXTRA_PLUGGED, Integer.parseInt(kv[1]));
		//					break;
		//				}
		//			} catch (Throwable e) {
		//				DLog.e(e);
		//			}
		//		}
		mSpEditor.putInt(EXTRA_LEVEL, new Random().nextInt(101));
		mSpEditor.putInt(EXTRA_PLUGGED, -1);
		mSpEditor.apply();
	}

}
