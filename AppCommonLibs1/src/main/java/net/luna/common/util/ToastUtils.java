package net.luna.common.util;

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtils
 * 
 */
public class ToastUtils {

	private ToastUtils() {
		throw new AssertionError();
	}

	public static void show(Context context, int resId) {
		show(context, context.getResources().getText(resId), Toast.LENGTH_SHORT);
	}

	public static void show(Context context, int resId, int duration) {
		show(context, context.getResources().getText(resId), duration);
	}

	public static void show(Context context, CharSequence text) {
		show(context, text, Toast.LENGTH_SHORT);
	}

	public static void show(final Context context, final CharSequence text, final int duration) {
		try {
			if (ThreadUtils.isInUIThread()) {
				Toast.makeText(context, text, duration).show();
			} else {
				ThreadUtils.runInUiThread(new Runnable() {

					@Override
					public void run() {
						Toast.makeText(context, text, duration).show();
					}
				});
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
	}

	public static void show(Context context, int resId, Object... args) {
		show(context, String.format(context.getResources().getString(resId), args), Toast.LENGTH_SHORT);
	}

	public static void show(Context context, String format, Object... args) {
		show(context, String.format(format, args), Toast.LENGTH_SHORT);
	}

	public static void show(Context context, int resId, int duration, Object... args) {
		show(context, String.format(context.getResources().getString(resId), args), duration);
	}

	public static void show(Context context, String format, int duration, Object... args) {
		show(context, String.format(format, args), duration);
	}
}
