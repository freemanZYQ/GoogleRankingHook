package com.tools.hackandroid.generator;

import android.os.Build;
import android.text.TextUtils;

import com.tools.hackandroid.util.RandomUtil;

import java.util.Random;

/**
 * @author zhitao
 * @since 2016-04-19 16:02
 */
public class BuildGenerator {

	/**
	 * 本次application的Build.ID
	 */
	private static String id;

	/**
	 * 本次application的Build.TIME
	 */
	private static long buildtime = 0L;

	private static String[] MANUFACTURER_ARRAY = { "Xiaomi", "Meizu", "LG", "Samsung" };

	public static String newRandomRadioVersion() {
		// e.g. G900HXXU1ANG3
		return "G900" + RandomUtil.newRandomString(RandomUtil.UPPER_CASE_STRING + RandomUtil.NUMBER_STRING, 9);
	}
	
	/**
	 * 根据版本名来生成ID
	 *
	 * @param codeName
	 *
	 * @return
	 *
	 * @see http://www.cookqq.com/blog/8a10a5f35167c83a01519e5f5d8616a8
	 */
	public static String newIDBaseonReleaseVersion(String codeName) {
		if (TextUtils.isEmpty(codeName)) {
			return "KTU84Q";
		}
		if (codeName.startsWith("2.1")) {
			return "EPF21B";
		} else if (codeName.startsWith("2.2")) {
			return "FRK76C";
		} else if (codeName.startsWith("2.3")) {
			return "GWK74";
		} else if (codeName.startsWith("4.0")) {
			return "ITL41F";
		} else if (codeName.startsWith("4.0.3")) {
			return "IML74K";
		} else if (codeName.startsWith("4.1")) {
			return "JRO03D";
		} else if (codeName.startsWith("4.2")) {
			return "JOP40D";
		} else if (codeName.startsWith("4.3")) {
			return "JWR66N";
		} else if (codeName.startsWith("4.4")) {
			return "KRT16S";
		} else if (codeName.startsWith("4.4W")) {
			return "KTU84Q";
		} else if (codeName.startsWith("5.0")) {
			return "LRX21R";
		} else if (codeName.startsWith("5.1")) {
			return "LVY48E";
		} else if (codeName.startsWith("6")) {
			return "MMB29K";
		}
		return "KTU84Q";

	}
	
	/**
	 * 生成ID
	 * <p/>
	 * TODO 先随便搞点，这里的ID是有规则的
	 *
	 * @return
	 */
	public static String newRandomID() {
		return RandomUtil.newRandomString(RandomUtil.UPPER_CASE_STRING + RandomUtil.NUMBER_STRING, 6);
	}

	/**
	 * 仅仅为此次创建的application进行模拟
	 *
	 * @return
	 */
	public static String newRandomIDForThisApplication() {
		if (TextUtils.isEmpty(id)) {
			id = newRandomID();
		}
		return id;
	}

	/**
	 * 模拟生成 {@link Build#TIME}
	 * <p/>
	 * 规则：当前时间-[3个月, 6个月]
	 *
	 * @return
	 */
	public static long newRandomTime() {
		//		long halfYearMs = 15552000000L;
		//		long halfYearMs = 180 * 24 * 60 * 60 * 1000L;
		long currentTime = System.currentTimeMillis();
		long threeMonthMs = 7776000000L;
		// 一天的毫秒 × 天数
		long daySeedMs = 86400000L * new Random().nextInt(90);
		return (currentTime - threeMonthMs - daySeedMs) / 1000L;
	}

	/**
	 * 仅仅为此次创建的application进行模拟
	 *
	 * @return
	 */
	public static long newRandomTimeForThisApplication() {
		if (buildtime == 0L) {
			buildtime = newRandomTime();
		}
		return buildtime;
	}

	/**
	 * 随机一个厂商
	 *
	 * @return
	 */
	public static String newRandomMANUFACTURER() {
		int index = new Random().nextInt(MANUFACTURER_ARRAY.length);
		return MANUFACTURER_ARRAY[index];
	}
}
