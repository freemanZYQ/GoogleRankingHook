package com.tools.hackandroid.xposed.hooker.global;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.tools.hackandroid.sp.WIfiManagerSp;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

class WifiManagerHooker extends AbsHooker<WIfiManagerSp> {

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected WIfiManagerSp initSp() {
		return new WIfiManagerSp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {

		findAndHookMethod(WifiInfo.class, "getMacAddress", this);
		findAndHookMethod(WifiInfo.class, "getSSID", this);
		findAndHookMethod(WifiInfo.class, "getBSSID", this);
		findAndHookMethod(WifiManager.class, "getScanResults", this);

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
		case "getMacAddress":
			setStringResult(param, WIfiManagerSp.GET_MAC_ADDRESS);
			break;
		case "getBSSID":
			setStringResult(param, WIfiManagerSp.GET_BSSID);
			break;
		case "getSSID":
			setStringResult(param, WIfiManagerSp.GET_SSID);
			break;
		case "getScanResults":
			// 实际上，还应该要从获取到的string中，解析出ScanResult对象，比较麻烦，目前先直接置为空
			param.setResult(null);
			break;
		//		Set<String> set = getXSharedPreferences().getStringSet(WIfiManagerSp.GET_SCAN_RESULTS, null);
		//		if (set == null || set.isEmpty()) {
		//			param.setResult(null);
		//		} else {
		//			List<String> list = new ArrayList<>();
		//			for (String aSet : set) {
		//				list.add(aSet);
		//			}
		//			param.setResult(list);
		//		}
		//		break;

		//			String ssid = getXSharedPreferences().getString(WIfiManagerSp.GET_SSID, null);
		//			if (TextUtils.isEmpty(ssid)) {
		//				break;
		//			}
		//			String bssid = getXSharedPreferences().getString(WIfiManagerSp.GET_BSSID, null);
		//			if (TextUtils.isEmpty(bssid)) {
		//				break;
		//			}
		//
		//			List<ScanResult> srs = (List<ScanResult>) param.getResult();
		//			for (ScanResult sr : srs) {
		//				if (ssid.equals(sr.SSID)) {
		//					sr.BSSID = bssid;
		//					param.setResult(srs);
		//					break;
		//				}
		//			}
		//			break;
		}
	}
}
