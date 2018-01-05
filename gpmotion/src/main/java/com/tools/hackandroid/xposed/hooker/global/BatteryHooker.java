package com.tools.hackandroid.xposed.hooker.global;

import android.content.Intent;
import android.text.TextUtils;

import com.tools.hackandroid.sp.BatterySp;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author zhitao
 * @since 2016-04-18 17:15
 */
class BatteryHooker extends AbsHooker<BatterySp> {
	
	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected BatterySp initSp() {
		return new BatterySp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {
		// hook context 篡改返回的Intent是不行的，xposed不能hook抽象类和抽象方法
		//		findAndHookMethod(Context.class, "registerReceiver", BroadcastReceiver.class, IntentFilter.class, this);

		// 改为下面方法 但是总感觉会漏，继续转换思路
		//		findAndHookMethod(Application.class, "registerReceiver", BroadcastReceiver.class, IntentFilter.class, this);
		//		findAndHookMethod(Activity.class, "registerReceiver", BroadcastReceiver.class, IntentFilter.class, this);
		//		findAndHookMethod(Service.class, "registerReceiver", BroadcastReceiver.class, IntentFilter.class, this);
		
		// 最后改为hook Intent 的get 方法
		findAndHookMethod(Intent.class, "getIntExtra", String.class, int.class, this);
		findAndHookMethod(Intent.class, "getBooleanExtra", String.class, boolean.class, this);
		findAndHookMethod(Intent.class, "getStringExtra", String.class, this);

	}

	@Override
	protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
		super.beforeHookedMethod(param);

		Intent srcIntent = null;

		try {
			srcIntent = (Intent) param.thisObject;
			if (srcIntent != null) {
				String action = srcIntent.getAction();
				if (TextUtils.isEmpty(action) || !Intent.ACTION_BATTERY_CHANGED.equals(action)) {
					srcIntent = null;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

		switch (param.method.getName()) {
		case "getBooleanExtra":
			if (srcIntent != null) {
				if (getXSharedPreferences().contains(BatterySp.EXTRA_PRESENT)) {
					srcIntent
							.putExtra(BatterySp.EXTRA_PRESENT, getXSharedPreferences().getBoolean(BatterySp.EXTRA_PRESENT,
									true));
				}
			}
			break;
		case "getStringExtra":
			if (srcIntent != null) {
				if (getXSharedPreferences().contains(BatterySp.EXTRA_TECHNOLOGY)) {
					srcIntent.putExtra(BatterySp.EXTRA_TECHNOLOGY,
							getXSharedPreferences().getString(BatterySp.EXTRA_TECHNOLOGY, "Li-ion"));
				}
			}
			break;

		case "getIntExtra":
			if (srcIntent != null) {
				if (getXSharedPreferences().contains(BatterySp.EXTRA_LEVEL)) {
					srcIntent.putExtra(BatterySp.EXTRA_LEVEL, getXSharedPreferences().getInt(BatterySp.EXTRA_LEVEL, -1));
				}
				if (getXSharedPreferences().contains(BatterySp.EXTRA_SCALE)) {
					srcIntent.putExtra(BatterySp.EXTRA_SCALE, getXSharedPreferences().getInt(BatterySp.EXTRA_SCALE, -1));
				}
				if (getXSharedPreferences().contains(BatterySp.EXTRA_STATUS)) {
					srcIntent.putExtra(BatterySp.EXTRA_STATUS, getXSharedPreferences().getInt(BatterySp.EXTRA_STATUS, -1));
				}
				if (getXSharedPreferences().contains(BatterySp.EXTRA_HEALTH)) {
					srcIntent.putExtra(BatterySp.EXTRA_HEALTH, getXSharedPreferences().getInt(BatterySp.EXTRA_HEALTH, -1));
				}
				if (getXSharedPreferences().contains(BatterySp.EXTRA_ICON_SMALL)) {
					srcIntent.putExtra(BatterySp.EXTRA_ICON_SMALL, getXSharedPreferences().getInt(BatterySp.EXTRA_ICON_SMALL, -1));
				}
				if (getXSharedPreferences().contains(BatterySp.EXTRA_PLUGGED)) {
					srcIntent.putExtra(BatterySp.EXTRA_PLUGGED, getXSharedPreferences().getInt(BatterySp.EXTRA_PLUGGED, -1));
				}
				if (getXSharedPreferences().contains(BatterySp.EXTRA_TEMPERATURE)) {
					srcIntent.putExtra(BatterySp.EXTRA_TEMPERATURE, getXSharedPreferences().getInt(BatterySp.EXTRA_TEMPERATURE, -1));
				}
				if (getXSharedPreferences().contains(BatterySp.EXTRA_VOLTAGE)) {
					srcIntent.putExtra(BatterySp.EXTRA_VOLTAGE, getXSharedPreferences().getInt(BatterySp.EXTRA_VOLTAGE, -1));
				}
			}
			break;

		}
	}

	@Override
	protected void afterHookedMethod(MethodHookParam param) throws Throwable {
		super.afterHookedMethod(param);
		
		//		switch (param.method.getName()) {
		//		case "registerReceiver":
		//			Intent intent = new Intent();
		//			intent.putExtra(BatterySp.EXTRA_LEVEL, getXSharedPreferences().getInt(BatterySp.EXTRA_LEVEL, -1));
		//			intent.putExtra(BatterySp.EXTRA_SCALE, getXSharedPreferences().getInt(BatterySp.EXTRA_SCALE, -1));
		//			intent.putExtra(BatterySp.EXTRA_STATUS, getXSharedPreferences().getInt(BatterySp.EXTRA_STATUS, -1));
		//			intent.putExtra(BatterySp.EXTRA_HEALTH, getXSharedPreferences().getInt(BatterySp.EXTRA_HEALTH, -1));
		//			intent.putExtra(BatterySp.EXTRA_ICON_SMALL, getXSharedPreferences().getInt(BatterySp.EXTRA_ICON_SMALL,
		// -1));
		//			intent.putExtra(BatterySp.EXTRA_PLUGGED, getXSharedPreferences().getInt(BatterySp.EXTRA_PLUGGED, -1));
		//			intent.putExtra(BatterySp.EXTRA_PRESENT, getXSharedPreferences().getBoolean(BatterySp.EXTRA_PRESENT,
		// true));
		//			intent.putExtra(BatterySp.EXTRA_TECHNOLOGY,
		//					getXSharedPreferences().getString(BatterySp.EXTRA_TECHNOLOGY, "Li-ion1" + ""));
		//			intent.putExtra(BatterySp.EXTRA_TEMPERATURE, getXSharedPreferences().getInt(BatterySp.EXTRA_TEMPERATURE,
		// -1));
		//			intent.putExtra(BatterySp.EXTRA_VOLTAGE, getXSharedPreferences().getInt(BatterySp.EXTRA_VOLTAGE, -1));
		//			param.setResult(intent);
		//			break;
		//		}
	}
}
