package com.tools.hackandroid.xposed.hooker.global;

import android.telephony.TelephonyManager;

import com.tools.hackandroid.sp.TelephonyManagerSp;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

class TelephonyManagerHooker extends AbsHooker<TelephonyManagerSp> {

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected TelephonyManagerSp initSp() {
		return new TelephonyManagerSp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {

		findAndHookMethod(TelephonyManager.class, "getDeviceId", this);
		findAndHookMethod(TelephonyManager.class, "getSubscriberId", this);

		findAndHookMethod(TelephonyManager.class, "getNetworkOperator", this);
		findAndHookMethod(TelephonyManager.class, "getNetworkCountryIso", this);
		findAndHookMethod(TelephonyManager.class, "getNetworkOperatorName", this);
		findAndHookMethod(TelephonyManager.class, "getNetworkType", this);

		findAndHookMethod(TelephonyManager.class, "getSimOperator", this);
		findAndHookMethod(TelephonyManager.class, "getSimCountryIso", this);
		findAndHookMethod(TelephonyManager.class, "getSimOperatorName", this);
		findAndHookMethod(TelephonyManager.class, "getSimSerialNumber", this);
		findAndHookMethod(TelephonyManager.class, "getSimState", this);
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
		String methodName = param.method.getName();
		switch (methodName) {
		case "getDeviceId":
			setStringResult(param, TelephonyManagerSp.IMEI);
			break;
		case "getSubscriberId":
			setStringResult(param, TelephonyManagerSp.IMSI);
			break;
		case "getNetworkOperator":
			setStringResult(param, TelephonyManagerSp.NETWORK_OPERATOR_MCCMNC);
			break;
		case "getNetworkOperatorName":
			setStringResult(param, TelephonyManagerSp.NETWORK_OPERATOR_NAME);
			break;
		case "getNetworkCountryIso":
			setStringResult(param, TelephonyManagerSp.NETWORK_OPERATOR_COUNTRY_ISO);
			break;
		case "getNetworkType":
			setIntResult(param, TelephonyManagerSp.NETWORK_TPYE);
			break;
		case "getSimOperator":
			setStringResult(param, TelephonyManagerSp.SIM_OPERATOR_MCCMNC);
			break;
		case "getSimOperatorName":
			setStringResult(param, TelephonyManagerSp.SIM_OPERATOR_NAME);
			break;
		case "getSimCountryIso":
			setStringResult(param, TelephonyManagerSp.SIM_OPERATOR_COUNTRY_ISO);
			break;
		case "getSimSerialNumber":
			setStringResult(param, TelephonyManagerSp.SIM_SERIAL_NUMBER_ICCID);
			break;
		case "getSimState":
			setIntResult(param, TelephonyManagerSp.SIM_STATE);
			break;
		}
	}
}
