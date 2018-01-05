package com.tools.hackandroid.xposed.hooker.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.tools.hackandroid.BuildConfig;
import com.tools.hackandroid.sp.AbsSp;
import com.tools.hackandroid.sp.SystemPropertiesSp;
import com.tools.hackandroid.util.DLog;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 每个钩子类设计到Android原生的{@link SharedPreferences} 以及 xposed 的 {@link XSharedPreferences}，
 * <p/>
 * <b>注意</b>
 * <p/>
 * <ol>
 * <li>在读写原生的 {@link SharedPreferences} 时，必须要设置为全局可读 {@link Context#MODE_WORLD_READABLE}，如果设置为 {@link Context#MODE_PRIVATE},
 * 那么只能在 {@link de.robv.android.xposed.IXposedHookZygoteInit#initZygote(IXposedHookZygoteInit.StartupParam)
 * }的时候进行标记可读，但是一旦这个文件被重新读写，就不能reload了，十分不友好</li>
 * <li>内部封装好了 {@link XSharedPreferences}的使用，只对外提供 {@link SharedPreferences}，方便外部填入数据之类的</li>
 * </ol>
 */
public abstract class AbsHooker<T extends AbsSp> extends XC_MethodHook implements IHooker {

	private XSharedPreferences mXSp;

	protected T mT;

	/**
	 * Constructs a new instance of {@code Object}.
	 */
	public AbsHooker() {
		super();
		mT = initSp();
	}

	protected XSharedPreferences getXSharedPreferences() {
		if (mXSp == null) {
			mXSp = new XSharedPreferences(BuildConfig.APPLICATION_ID, mT.getSharedPreferencesName());
			mXSp.makeWorldReadable();
			DLog.i("初始化 [%s]", mT.getSharedPreferencesName());
		}

		return mXSp;
	}

	/**
	 * 初始化XSharedPreferences
	 */
	@Override
	public void initXSharedPreferences() {
		try {
			getXSharedPreferences();
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e);
		}
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	public void hook(XC_LoadPackage.LoadPackageParam lpparam) {
		try {
			mXSp.reload();
			handleHook(lpparam);
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e);
		}
	}

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	protected abstract T initSp();

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	protected abstract void handleHook(XC_LoadPackage.LoadPackageParam lpparam);

	/**
	 * 设置int返回值
	 *
	 * @param param
	 * @param key   要替换的值所在的sp文件中key
	 */
	protected void setIntResult(XC_MethodHook.MethodHookParam param, String key) {
		try {
			String temp = mXSp.getString(key, null);
			if (!TextUtils.isEmpty(temp)) {
				param.setResult(Integer.parseInt(temp));
			}
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e, "注入 %s 失败", key);
		}
	}

	/**
	 * 设置字符串返回值
	 *
	 * @param param
	 * @param key   要替换的值所在的sp文件中key
	 */
	protected void setStringResult(XC_MethodHook.MethodHookParam param, String key) {
		try {
			String temp = mXSp.getString(key, null);
			if (!TextUtils.isEmpty(temp)) {
				param.setResult(temp);
			}
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e, "注入 %s 失败", key);
		}
	}

	/**
	 * 设置boolean返回值
	 *
	 * @param param
	 * @param key   要替换的值所在的sp文件中key
	 */
	protected void setbooleanResult(XC_MethodHook.MethodHookParam param, String key) {
		try {
			String temp = mXSp.getString(key, null);
			if (!TextUtils.isEmpty(temp)) {
				param.setResult(Boolean.parseBoolean(temp));
			}
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e, "注入 %s 失败", key);
		}
	}

	/**
	 * 设置静态变量的返回值
	 *
	 * @param targetClass     目标类
	 * @param staticFieldName 目标静态成员变量的名称
	 * @param key             要替换的值所在的sp文件中key
	 */
	protected void setStaticObjectField(Class targetClass, String staticFieldName, String key) {
		try {
			String temp = mXSp.getString(staticFieldName, null);
			if (!TextUtils.isEmpty(temp)) {
				XposedHelpers.setStaticObjectField(targetClass, staticFieldName, temp);
			}
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e, "注入 %s 失败", key);
		}
	}

	/**
	 * 设置静态变量的返回值
	 *
	 * @param targetClass     目标类
	 * @param staticFieldName 目标静态成员变量的名称
	 * @param key             要替换的值所在的sp文件中key
	 */
	protected void setStaticLongField(Class targetClass, String staticFieldName, String key) {
		try {
			String temp = mXSp.getString(staticFieldName, null);
			if (!TextUtils.isEmpty(temp)) {
				XposedHelpers.setStaticLongField(targetClass, staticFieldName, Long.parseLong(temp));
			}
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e, "注入 %s 失败", key);
		}
	}

	/**
	 * 设置静态变量的返回值
	 *
	 * @param targetClass     目标类
	 * @param staticFieldName 目标静态成员变量的名称
	 * @param key             要替换的值所在的sp文件中key
	 */
	protected void setStaticIntField(Class targetClass, String staticFieldName, String key) {
		try {
			String temp = mXSp.getString(staticFieldName, null);
			if (!TextUtils.isEmpty(temp)) {
				XposedHelpers.setStaticIntField(targetClass, staticFieldName, Integer.parseInt(temp));
			}
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e);
		}
	}

	protected XC_MethodHook.Unhook findAndHookMethod(Class<?> clazz, String methodName, Object... parameterTypesAndCallback) {
		try {
			return XposedHelpers.findAndHookMethod(clazz, methodName, parameterTypesAndCallback);
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e);
		}
		return null;
	}

	protected XC_MethodHook.Unhook findAndHookMethod(String className, ClassLoader classLoader, String methodName,
			Object... parameterTypesAndCallback) {
		try {
			return XposedHelpers.findAndHookMethod(className, classLoader, methodName, parameterTypesAndCallback);
		} catch (Throwable e) {
			XposedBridge.log(e);
			DLog.e(e);
		}
		return null;
	}

}
