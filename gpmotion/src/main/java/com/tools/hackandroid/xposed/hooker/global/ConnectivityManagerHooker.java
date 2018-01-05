package com.tools.hackandroid.xposed.hooker.global;

import android.net.NetworkInfo;

import com.tools.hackandroid.sp.ConnectivityManagerSp;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author zhitao
 * @since 2016-04-18 16:04
 */
class ConnectivityManagerHooker extends AbsHooker<ConnectivityManagerSp> {

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected ConnectivityManagerSp initSp() {
		return new ConnectivityManagerSp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {
		findAndHookMethod(NetworkInfo.class, "isAvailable", this);
		findAndHookMethod(NetworkInfo.class, "getType", this);
		findAndHookMethod(NetworkInfo.class, "getExtraInfo", this);
	}

	@Override
	protected void afterHookedMethod(MethodHookParam param) throws Throwable {
		super.afterHookedMethod(param);
		switch (param.method.getName()) {
		case "isAvailable":
			setbooleanResult(param, ConnectivityManagerSp.IS_AVAILABLE);
			break;

		case "getType":
			setIntResult(param, ConnectivityManagerSp.TYPE);
			break;

		// TODO 仅仅针对移动网络下的测试
		case "getExtraInfo":
			setStringResult(param, ConnectivityManagerSp.APN);
			break;
		}
	}
}
