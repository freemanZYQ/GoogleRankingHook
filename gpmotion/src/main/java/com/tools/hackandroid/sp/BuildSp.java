package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

import com.tools.hackandroid.generator.BuildGenerator;
import com.tools.hackandroid.util.DLog;

public class BuildSp extends AbsSp {

	public final static String DEVICE = "DEVICE";

	public final static String BOARD = "BOARD";

	public final static String BRAND = "BRAND";

	public final static String MODEL = "MODEL";

	public final static String FINGERPRINT = "FINGERPRINT";

	public final static String DISPLAY = "DISPLAY";

	public final static String MANUFACTURER = "MANUFACTURER";

	public final static String SERIAL = "SERIAL";

	public final static String BOOTLOADER = "BOOTLOADER";

	public final static String CPU_ABI = "CPU_ABI";

	public final static String CPU_ABI2 = "CPU_ABI2";

	public final static String SUPPORTED_ABIS = "SUPPORTED_ABIS";

	public final static String SUPPORTED_32_BIT_ABIS = "SUPPORTED_32_BIT_ABIS";

	public final static String SUPPORTED_64_BIT_ABIS = "SUPPORTED_64_BIT_ABIS";

	public final static String HARDWARE = "HARDWARE";

	public final static String HOST = "HOST";

	public final static String ID = "ID";

	public final static String PRODUCT = "PRODUCT";

	public final static String TAGS = "TAGS";

	public final static String TIME = "TIME";

	public final static String TYPE = "TYPE";

	public final static String UNKNOWN = "UNKNOWN";

	public final static String USER = "USER";

	public final static String getRadioVersion = "getRadioVersion";

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	@Override
	public String getSharedPreferencesName() {
		return Build.class.getName();
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
		mSpEditor.putString(DEVICE, "1" + System.currentTimeMillis());
		mSpEditor.putString(BOARD, "2");
		mSpEditor.putString(BRAND, "3");
		mSpEditor.putString(MODEL, "4");
		mSpEditor.putString(FINGERPRINT, "5");
		mSpEditor.putString(DISPLAY, "6");
		mSpEditor.putString(MANUFACTURER, "7");
		mSpEditor.putString(SERIAL, "8");
		mSpEditor.putString(BOOTLOADER, "9");
		mSpEditor.putString(CPU_ABI, "10");
		mSpEditor.putString(CPU_ABI2, "11");
		mSpEditor.putString(SUPPORTED_ABIS, "123");
		mSpEditor.putString(SUPPORTED_32_BIT_ABIS, "456");
		mSpEditor.putString(SUPPORTED_64_BIT_ABIS, "789");
		mSpEditor.putString(HARDWARE, "12");
		mSpEditor.putString(HOST, "13");
		mSpEditor.putString(ID, "14");
		mSpEditor.putString(PRODUCT, "15");
		mSpEditor.putString(TAGS, "16");
		mSpEditor.putString(TIME, "17");
		mSpEditor.putString(TYPE, "18");
		mSpEditor.putString(UNKNOWN, "19");
		mSpEditor.putString(USER, "20");
		mSpEditor.putString(getRadioVersion, "21");
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
				case "dd":
					mSpEditor.putString(MODEL, kv[1]);

					// TODO 暂时没有收集到device的参数，先用model顶替
					mSpEditor.putString(DEVICE, kv[1]);

					// TODO 暂时没有收集到board的参数，先用model顶替
					mSpEditor.putString(BOARD, kv[1]);

					break;
				case "dv":
					mSpEditor.putString(MANUFACTURER, kv[1]);

					// TODO 暂时没有收集到brand品牌的信息，先用制造厂商顶替
					mSpEditor.putString(BRAND, kv[1]);

					break;
				case "po":
					mSpEditor.putString(FINGERPRINT, kv[1]);
					break;
				case "sn":
					mSpEditor.putString(SERIAL, kv[1]);
					break;
				case "osv":
					if (!kv[1].startsWith("android ")) {
						continue;
					}
					// 因为暂时没有传入获取ID的值，所以只能根据RELEASE的值修改ID
					mSpEditor.putString(ID, BuildGenerator.newIDBaseonReleaseVersion(kv[1].substring(8)));
					break;

				// TODO product hardward的篡改
				}
			} catch (Throwable e) {
				DLog.e(e);
			}
		}
		mSpEditor.putString(TIME, String.valueOf(BuildGenerator.newRandomTimeForThisApplication() * 1000));
		mSpEditor.putString(getRadioVersion, BuildGenerator.newRandomRadioVersion());
		mSpEditor.putString(MANUFACTURER, BuildGenerator.newRandomMANUFACTURER());
//		mSpEditor.putString(ID, BuildGenerator.newRandomIDForThisApplication());
		mSpEditor.apply();
	}

}
