package com.tools.hackandroid.xposed.hooker.third;

import com.tools.hackandroid.sp.third.TencentSp;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 唯品会特殊处理的hooker
 */
public class TencentHooker extends AbsHooker<TencentSp> {

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected TencentSp initSp() {
		return new TencentSp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {
		// 替换mid
		findAndHookMethod("com.tencent.mid.api.MidEntity", lpparam.classLoader, "getMid", this);
	}

	@Override
	protected void afterHookedMethod(MethodHookParam param) throws Throwable {
		switch (param.method.getName()) {
		case "getMid":
			DLog.i("修改前，腾讯mta的mid: %s", param.getResult().toString());
			setStringResult(param, TencentSp.MTA_MID);
			DLog.i("修改后，腾讯mta的mid: %s", param.getResult().toString());
			break;
		}
	}
}


