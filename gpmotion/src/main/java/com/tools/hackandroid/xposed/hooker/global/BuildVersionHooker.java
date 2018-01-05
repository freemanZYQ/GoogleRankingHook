package com.tools.hackandroid.xposed.hooker.global;

import android.os.Build;

import com.tools.hackandroid.sp.BuildVersionSp;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

class BuildVersionHooker extends AbsHooker<BuildVersionSp> {

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected BuildVersionSp initSp() {
		return new BuildVersionSp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {
		// 23之后才有
		//		setStaticObjectField(Build.VERSION.class, BuildVersionSp.BASE_OS, BuildVersionSp.BASE_OS);
		//		setStaticIntField(Build.VERSION.class, BuildVersionSp.PREVIEW_SDK_INT, BuildVersionSp.PREVIEW_SDK_INT);
		//		setStaticObjectField(Build.VERSION.class, BuildVersionSp.SECURITY_PATCH, BuildVersionSp.SECURITY_PATCH);

//		setStaticObjectField(Build.VERSION.class, BuildVersionSp.CODENAME, BuildVersionSp.CODENAME);
//		setStaticObjectField(Build.VERSION.class, BuildVersionSp.INCREMENTAL, BuildVersionSp.INCREMENTAL);
//		setStaticObjectField(Build.VERSION.class, BuildVersionSp.RELEASE, BuildVersionSp.RELEASE);
//		setStaticIntField(Build.VERSION.class, BuildVersionSp.SDK_INT, BuildVersionSp.SDK_INT);

		setStaticObjectField(Build.VERSION.class, BuildVersionSp.CODENAME, BuildVersionSp.CODENAME);
		setStaticObjectField(Build.VERSION.class, BuildVersionSp.INCREMENTAL, BuildVersionSp.INCREMENTAL);
		setStaticObjectField(Build.VERSION.class, BuildVersionSp.RELEASE, BuildVersionSp.RELEASE);
		setStaticIntField(Build.VERSION.class, BuildVersionSp.SDK_INT, BuildVersionSp.SDK_INT);
	}
}
