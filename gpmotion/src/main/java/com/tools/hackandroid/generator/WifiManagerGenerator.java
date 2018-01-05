package com.tools.hackandroid.generator;

import com.tools.hackandroid.util.RandomUtil;

import java.util.Random;

/**
 * @author zhitao
 * @since 2016-04-19 15:20
 */
public class WifiManagerGenerator {

	/**
	 * 生成随机SSID(长度为5~8位，名称随机)
	 *
	 * @return
	 */
	public static String newRandomSSID() {

		// 仅仅生成数字字母的SSID
		return "\"" + RandomUtil
				.newRandomString(RandomUtil.NUMBER_STRING + RandomUtil.UPPER_CASE_STRING + RandomUtil.LOWER_CASE_STRING,
						5 + new Random().nextInt(3)) + "\"";

		// 生成带符号的SSID
		//		return "\"" + RandomUtil.newRandomCaseAndSymbolString(5 + new Random().nextInt(3)) + "\"";
	}
	
}
