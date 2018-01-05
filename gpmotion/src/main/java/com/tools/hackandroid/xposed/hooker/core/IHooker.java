package com.tools.hackandroid.xposed.hooker.core;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author zhitao
 * @since 2016-04-15 23:17
 */
public interface IHooker<T> {

	/**
	 * 初始化XSharedPreferences
	 */
	void initXSharedPreferences();

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	void hook(XC_LoadPackage.LoadPackageParam lpparam);

}
