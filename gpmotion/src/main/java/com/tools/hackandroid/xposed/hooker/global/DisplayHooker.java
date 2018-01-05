package com.tools.hackandroid.xposed.hooker.global;

import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;

import com.tools.hackandroid.sp.DisplaySp;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * TODO 目前仅仅针对宽高进行hook，后面可以针对密度等进行hook
 * TODO 解决横竖屏时的宽高转换
 */
class DisplayHooker extends AbsHooker<DisplaySp> {

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected DisplaySp initSp() {
		return new DisplaySp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {

		findAndHookMethod(Display.class, "getWidth", this);
		findAndHookMethod(Display.class, "getHeight", this);
		findAndHookMethod(Display.class, "getMetrics", DisplayMetrics.class, this);

		if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
			findAndHookMethod(Display.class, "getRawWidth", this);
			findAndHookMethod(Display.class, "getRawHeight", this);
		}
		if (Build.VERSION.SDK_INT >= 17) {
			findAndHookMethod(Display.class, "getRealSize", Point.class, this);
		}
	}

	/**
	 * Called after the invocation of the method.
	 * <p/>
	 * <p>You can use {@link MethodHookParam#setResult} and {@link MethodHookParam#setThrowable}
	 * to modify the return value of the original method.
	 * <p/>
	 * <p>Note that implementations shouldn't call {@code super(param)}, it's not necessary.
	 *
	 * @param param Information about the method call.
	 *
	 * @throws Throwable Everything the callback throws is caught and logged.
	 */
	@Override
	protected void afterHookedMethod(MethodHookParam param) throws Throwable {
		switch (param.method.getName()) {
		case "getWidth":
			setIntResult(param, DisplaySp.WIDTH_PX);
			break;
		case "getHeight":
			setIntResult(param, DisplaySp.HEIGHT_PX);
			break;

		case "getMetrics":
			String sw = getXSharedPreferences().getString(DisplaySp.WIDTH_PX, null);
			String sh = getXSharedPreferences().getString(DisplaySp.HEIGHT_PX, null);
			if (TextUtils.isEmpty(sw) || TextUtils.isEmpty(sh)) {
				DLog.e("屏幕宽高像素模拟数据缺失，不模拟屏幕信息");
				break;
			}
			// TODO 这里最好根据当前屏幕横竖屏不同来设置宽高
			DisplayMetrics outMetrics = (DisplayMetrics) param.args[0];
			outMetrics.widthPixels = Integer.parseInt(sw);
			outMetrics.heightPixels = Integer.parseInt(sh);
			String sd = getXSharedPreferences().getString(DisplaySp.DENSITY_DPI, null);
			if (TextUtils.isEmpty(sd)) {
				DLog.w("屏幕密度数据缺失，不模拟密度");
				break;
			}
			outMetrics.densityDpi = Integer.parseInt(sd);
			break;
		case "getRawWidth":
			setIntResult(param, DisplaySp.WIDTH_PX);
			break;
		case "getRawHeight":
			setIntResult(param, DisplaySp.HEIGHT_PX);
			break;
		case "getRealSize":
			String sw1 = getXSharedPreferences().getString(DisplaySp.WIDTH_PX, null);
			String sh1 = getXSharedPreferences().getString(DisplaySp.HEIGHT_PX, null);
			if (TextUtils.isEmpty(sw1) || TextUtils.isEmpty(sh1)) {
				DLog.w("sw, sh, sd maybe null");
				break;
			}
			Point point = (Point) param.args[0];
			point.x = Integer.parseInt(sw1);
			point.y = Integer.parseInt(sh1);
			// TODO 这里最好根据当前屏幕横竖屏不同来设置宽高
			break;
		}

	}
}


