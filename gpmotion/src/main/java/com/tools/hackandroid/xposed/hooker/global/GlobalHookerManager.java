package com.tools.hackandroid.xposed.hooker.global;

import com.tools.hackandroid.xposed.hooker.core.IHooker;

import java.util.ArrayList;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 通用内容的hooker 像imei这些，如果是针对个别app的hooker不要加入到这里
 *
 * @author zhitao
 * @since 2016-04-15 23:14
 */
public class GlobalHookerManager implements IHooker {

	private ArrayList<IHooker> mAbsHookerInstanceList;

	/**
	 * 初始化XSharedPreferences
	 */
	@Override
	public void initXSharedPreferences() {
		mAbsHookerInstanceList = new ArrayList<>();

		mAbsHookerInstanceList.add(new UnSpecifiedHooker());
		mAbsHookerInstanceList.add(new BatteryHooker());
		mAbsHookerInstanceList.add(new BuildHooker());
		mAbsHookerInstanceList.add(new BuildVersionHooker());
		mAbsHookerInstanceList.add(new ConnectivityManagerHooker());
		mAbsHookerInstanceList.add(new DisplayHooker());
		mAbsHookerInstanceList.add(new LocaleHooker());
		mAbsHookerInstanceList.add(new SystemPropertiesHooker());
		mAbsHookerInstanceList.add(new TelephonyManagerHooker());
		mAbsHookerInstanceList.add(new WifiManagerHooker());

		if (mAbsHookerInstanceList != null && !mAbsHookerInstanceList.isEmpty()) {
			for (IHooker iHooker : mAbsHookerInstanceList) {
				iHooker.initXSharedPreferences();
			}
		}
	}
	
	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	public void hook(XC_LoadPackage.LoadPackageParam lpparam) {
		if (mAbsHookerInstanceList != null && !mAbsHookerInstanceList.isEmpty()) {
			for (IHooker iHooker : mAbsHookerInstanceList) {
				iHooker.hook(lpparam);
			}
		}
	}
}
