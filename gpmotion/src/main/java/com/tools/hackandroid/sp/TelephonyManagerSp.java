package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.tools.hackandroid.generator.TelePhoneManagerGenerator;
import com.tools.hackandroid.util.DLog;

public class TelephonyManagerSp extends AbsSp {

	public final static String IMEI = "imei";

	public final static String IMSI = "imsi";


	public final static String NETWORK_OPERATOR_MCCMNC = "网络运营商MCCMNC";

	public final static String NETWORK_OPERATOR_NAME = "网络运营商名字";

	public final static String NETWORK_OPERATOR_COUNTRY_ISO = "网络运营商国家ISO";

	public final static String NETWORK_TPYE = "网络类型";

	public final static String SIM_OPERATOR_MCCMNC = "SIM卡MCCMNC";

	public final static String SIM_OPERATOR_NAME = "SIM卡运营商名字";

	public final static String SIM_OPERATOR_COUNTRY_ISO = "SIM卡运营商国家ISO";

	public final static String SIM_SERIAL_NUMBER_ICCID = "SIM卡ICCID";

	public final static String SIM_STATE = "SIM卡状态";

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	@Override
	public String getSharedPreferencesName() {
		return TelephonyManager.class.getName();
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
		mSpEditor.putString(IMEI, "test_imei" + System.currentTimeMillis());
		mSpEditor.putString(IMSI, "test_imsi" + System.currentTimeMillis());
		mSpEditor.putString(NETWORK_OPERATOR_MCCMNC, "test_network_mccmnc");
		mSpEditor.putString(NETWORK_OPERATOR_NAME, "test_network_operator");
		mSpEditor.putString(NETWORK_OPERATOR_COUNTRY_ISO, "test_network_operator_iso");
		mSpEditor.putString(NETWORK_TPYE, "100");
		mSpEditor.putString(SIM_OPERATOR_MCCMNC, "test_sim_mccmnc");
		mSpEditor.putString(SIM_OPERATOR_NAME, "test_sim_operator");
		mSpEditor.putString(SIM_OPERATOR_COUNTRY_ISO, "test_sim_operator_iso");
		mSpEditor.putString(SIM_SERIAL_NUMBER_ICCID, "test_sim_iccid");
		mSpEditor.putString(SIM_STATE, "101");
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
				case "ei":
					mSpEditor.putString(IMEI, kv[1]);
					break;
				case "si":
					mSpEditor.putString(IMSI, kv[1]);
					break;
				case "cn":
					mSpEditor.putString(NETWORK_OPERATOR_NAME, kv[1]);
					break;
				}
			} catch (Throwable throwable) {
				DLog.e(throwable);
			}
		}
		mSpEditor.putString(SIM_SERIAL_NUMBER_ICCID, TelePhoneManagerGenerator.newDefaultRandomICCID());
		mSpEditor.putString(SIM_STATE, String.valueOf(TelephonyManager.SIM_STATE_READY));
		mSpEditor.apply();
	}

}
