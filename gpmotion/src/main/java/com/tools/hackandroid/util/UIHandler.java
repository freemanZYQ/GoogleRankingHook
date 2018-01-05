package com.tools.hackandroid.util;

import android.os.Handler;
import android.os.Looper;

public class UIHandler {

	private static Handler sUiHandler;

	public static boolean isInUIThread() {
		try {
			return Looper.myLooper() == Looper.getMainLooper();
		} catch (Throwable e) {
			DLog.e(e);
		}
		return false;
	}

	public static boolean runInUiThread(Runnable runnable) {
		return runInUiThread(runnable, 0);
	}

	/**
	 * 延迟指定时间之后执行任务
	 *
	 * @param runnable     要执行的任务
	 * @param delayTime_ms 要延迟的毫秒数
	 *
	 * @return
	 */
	public static boolean runInUiThread(Runnable runnable, long delayTime_ms) {
		try {
			if (runnable == null) {
				return false;
			}
			if (sUiHandler == null) {
				sUiHandler = new Handler(Looper.getMainLooper());
			}
			return sUiHandler.postDelayed(runnable, delayTime_ms);
		} catch (Throwable e) {
			DLog.e(e);
		}
		return false;
	}
}
