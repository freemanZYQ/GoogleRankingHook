package com.tools.hackandroid.xposed.hooker.global;

import android.os.Build;

import com.tools.hackandroid.sp.BuildSp;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

class BuildHooker extends AbsHooker<BuildSp> {
	
	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected BuildSp initSp() {
		return new BuildSp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {

		setStaticObjectField(Build.class, BuildSp.DEVICE, BuildSp.DEVICE);
		setStaticObjectField(Build.class, BuildSp.BOARD, BuildSp.BOARD);
		setStaticObjectField(Build.class, BuildSp.BRAND, BuildSp.BRAND);
		setStaticObjectField(Build.class, BuildSp.MODEL, BuildSp.MODEL);
		setStaticObjectField(Build.class, BuildSp.FINGERPRINT, BuildSp.FINGERPRINT);
		setStaticObjectField(Build.class, BuildSp.DISPLAY, BuildSp.DISPLAY);
		setStaticObjectField(Build.class, BuildSp.MANUFACTURER, BuildSp.MANUFACTURER);
		setStaticObjectField(Build.class, BuildSp.SERIAL, BuildSp.SERIAL);
		setStaticObjectField(Build.class, BuildSp.BOOTLOADER, BuildSp.BOOTLOADER);
		setStaticObjectField(Build.class, BuildSp.CPU_ABI, BuildSp.CPU_ABI);
		setStaticObjectField(Build.class, BuildSp.CPU_ABI2, BuildSp.CPU_ABI2);

//		setStaticObjectField(Build.class, BuildSp.SUPPORTED_ABIS, BuildSp.SUPPORTED_ABIS);
//		setStaticObjectField(Build.class, BuildSp.SUPPORTED_32_BIT_ABIS, BuildSp.SUPPORTED_32_BIT_ABIS);
//		setStaticObjectField(Build.class, BuildSp.SUPPORTED_64_BIT_ABIS, BuildSp.SUPPORTED_64_BIT_ABIS);

		setStaticObjectField(Build.class, BuildSp.HARDWARE, BuildSp.HARDWARE);
		setStaticObjectField(Build.class, BuildSp.HOST, BuildSp.HOST);
		setStaticObjectField(Build.class, BuildSp.ID, BuildSp.ID);
		setStaticObjectField(Build.class, BuildSp.PRODUCT, BuildSp.PRODUCT);
		setStaticObjectField(Build.class, BuildSp.TAGS, BuildSp.TAGS);
		setStaticLongField(Build.class, BuildSp.TIME, BuildSp.TIME);
		setStaticObjectField(Build.class, BuildSp.TYPE, BuildSp.TYPE);
		setStaticObjectField(Build.class, BuildSp.UNKNOWN, BuildSp.UNKNOWN);
		setStaticObjectField(Build.class, BuildSp.USER, BuildSp.USER);

		findAndHookMethod(Build.class, BuildSp.getRadioVersion, this);
//		findAndHookMethod(Build.class, "isBuildConsistent", this);
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
		case BuildSp.getRadioVersion:
			setStringResult(param, BuildSp.getRadioVersion);
			break;

//		// 设置Build文件自带的参数检验通过
//		case "isBuildConsistent":
//			param.setResult(true);
//			break;
		}
	}
}
