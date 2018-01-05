package com.tools.hackandroid.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhitao
 * @since 2016-08-05 10:55
 */
public class TimeUtil {

	/**
	 * 获取当前日期
	 * <p/>
	 * e.g "yyyy-MM"
	 * e.g "yyyy-MM-dd hh:mm:ss"
	 * e.g "yyyy-MM-dd HH:mm:ss"
	 *
	 * @return
	 */
	public static String getDate(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

}
