package com.tools.hackandroid.accessibility.util;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

import com.tools.hackandroid.util.DLog;

/**
 * Created by czt on 16/8/6.
 */
public class ActionUtil {

	/**
	 * 模拟back按键
	 */
	public static void pressBackButton() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
		} catch (Exception e) {
			DLog.e(e);
		}
	}

	/**
	 * 回到系统桌面
	 */
	private void back2Home(Context context) {
		Intent home = new Intent(Intent.ACTION_MAIN);

		home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		home.addCategory(Intent.CATEGORY_HOME);

		context.startActivity(home);
	}

}
