package com.tools.hackandroid.generator.third;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * @author zhitao
 * @since 2016-07-13 17:44
 */
public class WeipinhuiGenerator {
	//
	//	/**
	//	 * 唯品会中存在一个cid，格式如下
	//	 * <p/>
	//	 * mars_cid : 6bfc9091-d786-3be6-8183-5cce401c2f3f
	//	 *
	//	 * @return
	//	 */
	//	public static String newMarsCid() {
	//		//		return RandomUtil.newRandomString(RandomUtil.NUMBER_STRING + RandomUtil.LOWER_CASE_STRING, 8) + "-" +
	//		//		       RandomUtil.newRandomString(RandomUtil.NUMBER_STRING + RandomUtil.LOWER_CASE_STRING, 4) + "-" +
	//		//		       RandomUtil.newRandomString(RandomUtil.NUMBER_STRING + RandomUtil.LOWER_CASE_STRING, 4) + "-" +
	//		//		       RandomUtil.newRandomString(RandomUtil.NUMBER_STRING, 4) + "-" +
	//		//		       RandomUtil.newRandomString(RandomUtil.NUMBER_STRING + RandomUtil.LOWER_CASE_STRING, 12);
	//		return UUID.randomUUID().toString();
	//	}
	//

	/**
	 * 正宗的mid生成规则
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String newMid(Context context) {
		UUID uuid;
		String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
		try {
			if (!"9774d56d682e549c".equals(string)) {
				uuid = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
			} else {
				string = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
				uuid = string != null ? UUID.nameUUIDFromBytes(string.getBytes("utf8")) : UUID.randomUUID();
			}
		} catch (Throwable e) {
			uuid = UUID.randomUUID();
		}
		return uuid == null ? "" : uuid.toString();
	}

	/**
	 * 正宗的mid生成规则
	 *
	 * @return
	 */
	public static String newMid(String androidid, String imei) {
		UUID uuid = null;
		try {
			if (!TextUtils.isEmpty(androidid) && !"9774d56d682e549c".equals(androidid)) {
				uuid = UUID.nameUUIDFromBytes(androidid.getBytes("utf8"));
			} else {
				uuid = !TextUtils.isEmpty(imei) ? UUID.nameUUIDFromBytes(imei.getBytes("utf8")) : UUID.randomUUID();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return uuid == null ? "" : uuid.toString();
	}
}
