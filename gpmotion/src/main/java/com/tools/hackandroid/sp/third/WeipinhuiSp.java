package com.tools.hackandroid.sp.third;

import android.content.Context;
import android.content.SharedPreferences;

import com.tools.hackandroid.generator.third.WeipinhuiGenerator;
import com.tools.hackandroid.sp.AbsSp;

/**
 * 唯品会相关
 */
public class WeipinhuiSp extends AbsSp {

	public static final String MID = "mid";

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	@Override
	public String getSharedPreferencesName() {
		return "weipinhui";
	}

	/**
	 * 输入测试数据
	 *
	 * @param context
	 * @param sharedPreferences 数据所保存到的sp文件
	 */
	@Override
	protected void inputTestData(Context context, SharedPreferences sharedPreferences) {
		//		SharedPreferences.Editor mSpEditor = sharedPreferences.edit();
		//		String randomMid = RandomUtil.newRandomString(RandomUtil.NUMBER_STRING + RandomUtil.LOWER_CASE_STRING, 8) + "-" +
		//		                   RandomUtil.newRandomString(RandomUtil.NUMBER_STRING + RandomUtil.LOWER_CASE_STRING, 4) + "-" +
		//		                   RandomUtil.newRandomString(RandomUtil.NUMBER_STRING + RandomUtil.LOWER_CASE_STRING, 4) + "-" +
		//		                   RandomUtil.newRandomString(RandomUtil.NUMBER_STRING, 4) + "-" +
		//		                   RandomUtil.newRandomString(RandomUtil.NUMBER_STRING + RandomUtil.LOWER_CASE_STRING, 12);
		//		mSpEditor.putString(MID, randomMid);
		//		mSpEditor.apply();
	}

	/**
	 * 输入随机数据
	 *
	 * @param context
	 * @param sharedPreferences 数据所保存到的sp文件
	 */
	@Override
	protected void inputRandomData(Context context, SharedPreferences sharedPreferences) {
		SharedPreferences.Editor mSpEditor = sharedPreferences.edit();
		mSpEditor.putString(MID, WeipinhuiGenerator.newMid(context));
		mSpEditor.apply();
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
		//		for (String str : keyValueStringArray) {
		//			try {
		//				String[] kv = str.split("=");
		//				if (TextUtils.isEmpty(kv[0]) || TextUtils.isEmpty(kv[1])) {
		//					continue;
		//				}
		//				switch (kv[0]) {
		//				case "andid":
		//					mSpEditor.putString(ANDROID_ID, kv[1]);
		//					break;
		//				case "mac":
		//					char[] temp = kv[1].toCharArray();
		//					StringBuilder originMac = new StringBuilder(24);
		//					for (int i = 0; i < temp.length; ++i) {
		//						originMac.append(temp[i]);
		//						if (i != temp.length - 1 && i % 2 != 0) {
		//							originMac.append(":");
		//						}
		//					}
		//					mSpEditor.putString(MAC_FROM_FILE, originMac.toString());
		//					break;
		//				case "gvid":
		//					mSpEditor.putString(GOOGLE_AD_ID, kv[1]);
		//					break;
		//				case "bd":
		//					mSpEditor.putString(BLUETOOTH_MAC, kv[1]);
		//					break;
		//				// TODO 考虑完成下面几个参数的写入
		//				//			case "scid":
		//				//			case "lat":(忽略)
		//				//			case "lon":(忽略)
		//				//			case "bsi":(忽略)
		//				}
		//			} catch (Throwable throwable) {
		//				DLog.e(throwable);
		//			}
		//		}
		//		mSpEditor.putString(ADB_ENABLED, "0");// 修改为没有开启过开发者调试模式
		//		mSpEditor.apply();
	}

}


