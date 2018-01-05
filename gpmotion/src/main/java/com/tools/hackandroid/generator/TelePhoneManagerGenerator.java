package com.tools.hackandroid.generator;

import android.text.TextUtils;

import com.tools.hackandroid.util.RandomUtil;

import java.util.Date;
import java.util.Random;

/**
 * @author zhitao
 * @since 2016-04-19 17:12
 */
public class TelePhoneManagerGenerator {

	public static String newDefaultRandomICCID() {
		return newRandomICCID("86", 01);
	}

	public static String newRandomICCID(String countryCode, int mnc) {
		String prefix = "89" + countryCode + mnc;

		StringBuffer sb = new StringBuffer();
		StringBuffer buffer = new StringBuffer("0123456789");
		Random r = new Random();
		r.setSeed(new Date().getTime());
		int range = buffer.length();
		for (int i = 0; i < 12; ++i) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}

		if (prefix.length() > 7) {
			prefix = prefix.substring(0, 7);
		}

		String s = prefix + sb.toString();

		String iccid = s + checkSum(s, true);
		return iccid;
	}

	/**
	 * Generate check digit for a number string.
	 *
	 * @param numberString
	 * @param noCheckDigit Whether check digit is present or not. True if no check Digit
	 *                     is appended.
	 *
	 * @return
	 */
	public static int checkSum(String numberString, boolean noCheckDigit) {
		int sum = 0, checkDigit = 0;

		if (!noCheckDigit) {
			numberString = numberString.substring(0, numberString.length() - 1);
		}

		boolean isDouble = true;
		for (int i = numberString.length() - 1; i >= 0; i--) {
			int k = Integer.parseInt(String.valueOf(numberString.charAt(i)));
			sum += sumToSingleDigit((k * (isDouble ? 2 : 1)));
			isDouble = !isDouble;
		}

		if ((sum % 10) > 0) {
			checkDigit = (10 - (sum % 10));
		}

		return checkDigit;
	}

	private static int sumToSingleDigit(int k) {
		if (k < 10) {
			return k;
		}
		return sumToSingleDigit(k / 10) + (k % 10);
	}

	/**
	 * 生成随机的imei
	 * <p/>
	 * IMEI是国际移动通讯设备识别号(International Mobile Equipment Identity)的缩写，用于GSM系统。
	 * 由15位数字组成，前6位(TAC)是型号核准号码，代表手机类型。接着2位(FAC)是最后装配号，代表产地。后6位(SNR)是串号，代表生产顺序号。最后1位(SP)是检验码。
	 * MEID是移动通讯设备识别号(Mobile Equipment IDentifier)的缩写，用于CDMA系统。
	 * 由15位16进制数字组成，前8位是生产商编号，后6位是串号，最后1位是检验码。
	 *
	 *
	 * @param preNumbers 指定imei的前面几位数字，可以不传入这个参数，也可以传入多个参数，如果传入多个，则会随机选择一个来进行
	 *
	 * @return
	 */
	public static String generateRandomImei(String... preNumbers) {
		String preImei = null;

		// 检查是否指定了imei前面几个数字的前缀
		// 然后随机生成14位imei
		if (preNumbers == null || preNumbers.length <= 0) {
			preImei = RandomUtil.newRandomNumberString(14);
		} else {
			for (String temp : preNumbers) {
				if (temp == null) {
					throw new IllegalArgumentException("can't input null");
				}
				if (temp.contains(" ")) {
					throw new IllegalArgumentException("can't not input space");
				}
			}
			String preNumber = preNumbers[new Random().nextInt(preNumbers.length)];
			if (TextUtils.isEmpty(preNumber)) {
				preImei = RandomUtil.newRandomNumberString(14);
			} else {
				if (preNumber.length() == 14) {
					preImei = preNumber;
				} else if (preNumber.length() < 14) {
					preImei = preNumber + RandomUtil.newRandomNumberString(14 - preNumber.length());
				} else if (preNumber.length() > 14) {
					return preNumber;
				}
			}
		}

		// 生成15位imei(前14位+最后一位计算出来的校验位)
		return formatImei(preImei);
	}

	/**
	 * 格式化IMEI
	 * 因为IMEI格式不统一，长度有14位和16位的，所以，为了统一，将14位和16位的MEID，统一设置为15位的 设置格式：
	 * 如果IMEI长度为14位，那么直接得到第15位，如果MEID长度为16位，那么直接在根据前14位得到第15位
	 * 如果IMEI长度为其他长度，那么直接返回原值
	 *
	 * @param imei
	 *
	 * @return
	 */
	public static String formatImei(String imei) {
		int dxml = imei.length();
		if (dxml != 14 && dxml != 16) {
			return imei;
		}
		String imeiRes = "";
		if (dxml == 14) {
			imeiRes = imei + getIMEISum(imei);
		}
		if (dxml == 16) {
			imeiRes = imei + getIMEISum(imei.substring(0, 14));
		}
		return imeiRes;
	}

	/**
	 * 根据IMEI的前14位，得到第15位的校验位
	 * IMEI校验码算法：
	 * (1).将偶数位数字分别乘以2，分别计算个位数和十位数之和
	 * (2).将奇数位数字相加，再加上上一步算得的值
	 * (3).如果得出的数个位是0则校验位为0，否则为10减去个位数
	 * 如：35 89 01 80 69 72 41 偶数位乘以2得到5*2=10 9*2=18 1*2=02 0*2=00 9*2=18 2*2=04 1*2=02,计算奇数位数字之和和偶数位个位十位之和，
	 * 得到 3+(1+0)+8+(1+8)+0+(0+2)+8+(0+0)+6+(1+8)+7+(0+4)+4+(0+2)=63
	 * 校验位 10-3 = 7
	 *
	 * @param imei
	 *
	 * @return
	 */
	private static String getIMEISum(String imei) {
		if (imei.length() == 14) {
			char[] imeiChar = imei.toCharArray();
			int resultInt = 0;
			for (int i = 0; i < imeiChar.length; i++) {
				int a = Integer.parseInt(String.valueOf(imeiChar[i]));
				i++;
				final int temp = Integer.parseInt(String.valueOf(imeiChar[i])) * 2;
				final int b = temp < 10 ? temp : temp - 9;
				resultInt += a + b;
			}
			resultInt %= 10;
			resultInt = resultInt == 0 ? 0 : 10 - resultInt;
			return resultInt + "";
		} else {
			return "";
		}
	}

	/**
	 * 生成随机的meid
	 *
	 * @return
	 */
	public static String geterateRandomMeid() {
		return null;
	}

	/**
	 * 格式化MEID
	 * 因为MEID格式不统一，长度有14位和16位的，所以，为了统一，将14位和16位的MEID，统一设置为15位的 设置格式：
	 * 如果MEID长度为14位，那么直接得到第15位，如果MEID长度为16位，那么直接在根据后14位得到第15位
	 * 如果MEID长度为其他长度，那么直接返回原值
	 *
	 * @param meid
	 *
	 * @return
	 */
	public static String formatMeid(String meid) {
		int dxml = meid.length();
		if (dxml != 14 && dxml != 16) {
			return meid;
		}
		String meidRes = "";
		if (dxml == 14) {
			meidRes = meid + getMEIDSum(meid);
		}
		if (dxml == 16) {
			meidRes = meid.substring(2) + getMEIDSum(meid.substring(2));
		}
		return meidRes;
	}

	/**
	 * 根据MEID的前14位，得到第15位的校验位
	 * MEID校验码算法：
	 * (1).将偶数位数字分别乘以2，分别计算个位数和十位数之和，注意是16进制数
	 * (2).将奇数位数字相加，再加上上一步算得的值
	 * (3).如果得出的数个位是0则校验位为0，否则为10(这里的10是16进制)减去个位数
	 * 如：AF 01 23 45 0A BC DE 偶数位乘以2得到F*2=1E 1*2=02 3*2=06 5*2=0A A*2=14 C*2=18 E*2=1C,
	 * 计算奇数位数字之和和偶数位个位十位之和，得到 A+(1+E)+0+2+2+6+4+A+0+(1+4)+B+(1+8)+D+(1+C)=64
	 * 校验位 10-4 = C
	 *
	 * @param meid
	 *
	 * @return
	 */
	private static String getMEIDSum(String meid) {
		if (meid.length() == 14) {
			String myStr[] = { "a", "b", "c", "d", "e", "f" };
			int sum = 0;
			for (int i = 0; i < meid.length(); i++) {
				String param = meid.substring(i, i + 1);
				for (int j = 0; j < myStr.length; j++) {
					if (param.equalsIgnoreCase(myStr[j])) {
						param = "1" + String.valueOf(j);
					}
				}
				if (i % 2 == 0) {
					sum = sum + Integer.parseInt(param);
				} else {
					sum = sum + 2 * Integer.parseInt(param) % 16;
					sum = sum + 2 * Integer.parseInt(param) / 16;
				}
			}
			if (sum % 16 == 0) {
				return "0";
			} else {
				int result = 16 - sum % 16;
				if (result > 9) {
					result += 65 - 10;
				}
				return result + "";
			}
		} else {
			return "";
		}
	}
}
