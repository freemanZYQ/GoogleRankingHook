package com.tools.hackandroid.util;

import android.text.TextUtils;
import android.util.Log;

import com.tools.hackandroid.BuildConfig;

/**
 * @author zhitao
 * @since 2016-04-14 10:42
 */
public class DLog {

	private final static String TAG = "hack_";

	private final static int DEBUG = 1;

	private final static int VERBOSE = 2;

	private final static int INFO = 3;

	private final static int WARN = 4;

	private final static int ERROR = 5;

	public static void i(Throwable err) {
		i(err, null);
	}

	public static void i(String format, Object... args) {
		i(null, format, args);
	}

	public static void i(Throwable err, String format, Object... args) {
		if (BuildConfig.DEBUG) {
			log(INFO, TAG, err, format, args);
		}
	}

	public static void d(Throwable err) {
		d(err, null);
	}

	public static void d(String format, Object... args) {
		d(null, format, args);
	}

	public static void d(Throwable err, String format, Object... args) {
		if (BuildConfig.DEBUG) {
			log(DEBUG, TAG, err, format, args);
		}
	}

	public static void w(Throwable err) {
		w(err, null);
	}

	public static void w(String format, Object... args) {
		w(null, format, args);
	}

	public static void w(Throwable err, String format, Object... args) {
		if (BuildConfig.DEBUG) {
			log(WARN, TAG, err, format, args);
		}
	}

	public static void e(Throwable err) {
		e(err, null);
	}

	public static void e(String format, Object... args) {
		e(null, format, args);
	}

	public static void e(Throwable err, String format, Object... args) {
		if (BuildConfig.DEBUG) {
			log(ERROR, TAG, err, format, args);
		}
	}

	public static void v(Throwable err) {
		v(err, null);
	}

	public static void v(String format, Object... args) {
		v(null, format, args);
	}

	public static void v(Throwable err, String format, Object... args) {
		if (BuildConfig.DEBUG) {
			log(VERBOSE, TAG, err, format, args);
		}
	}

	private static void log(int level, String tag, Throwable err, String format, Object... args) {
		if (BuildConfig.DEBUG) {
			String msg = TextUtils.isEmpty(format) ? "" : String.format(format, args);
			switch (level) {
			case DEBUG:
				Log.d(tag, msg, err);
				break;
			case VERBOSE:
				Log.v(tag, msg, err);
				break;
			case INFO:
				Log.i(tag, msg, err);
				break;
			case WARN:
				Log.w(tag, msg, err);
				break;
			case ERROR:
				Log.e(tag, msg, err);
				break;
			}
		}
	}
}
