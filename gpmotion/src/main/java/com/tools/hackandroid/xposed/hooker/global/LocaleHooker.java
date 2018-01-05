package com.tools.hackandroid.xposed.hooker.global;

import android.text.TextUtils;

import com.tools.hackandroid.sp.LocaleSp;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import java.util.Locale;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

class LocaleHooker extends AbsHooker<LocaleSp> {

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected LocaleSp initSp() {
		return new LocaleSp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {
		findAndHookMethod(Locale.class, "getDefault", this);
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
		super.afterHookedMethod(param);

		switch (param.method.getName()) {
		case "getDefault":
			String newLanguage = getXSharedPreferences().getString(LocaleSp.LANGUAGE, null);
			String newCountry = getXSharedPreferences().getString(LocaleSp.COUNTRY, null);
			if (TextUtils.isEmpty(newLanguage) || TextUtils.isEmpty(newCountry)) {
				break;
			}
			param.setResult(new Locale(newLanguage, newCountry));
			break;
		}

	}
}


