package com.tools.hackandroid.xposed.hooker.global;

import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.provider.Settings;
import android.text.TextUtils;

import com.tools.hackandroid.sp.UnSpecifiedSp;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import java.io.File;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 存放一些还没有想好放在哪里的hook
 */
class UnSpecifiedHooker extends AbsHooker<UnSpecifiedSp> {

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected UnSpecifiedSp initSp() {
		return new UnSpecifiedSp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {

		//		XposedBridge.hookAllConstructors(File.class, this);

		// 通过命令行方式获取的mac地址（from 文件）
		//		findAndHookMethod(ProcessBuilder.class, "start", this);
		findAndHookMethod(Runtime.class, "exec", String[].class, String[].class, File.class, this);

		// AndroidId
		findAndHookMethod(Settings.Secure.class, "getString", ContentResolver.class, String.class, this);

		// TODO 后面要考虑一下不同类，相同方法的switch case 写法
		// 是否开启调试模式

		// 17之下，api获取
		findAndHookMethod(Settings.Secure.class, "getInt", ContentResolver.class, String.class, this);
		findAndHookMethod(Settings.Secure.class, "getInt", ContentResolver.class, String.class, int.class, this);

		// 17以上，api获取
		findAndHookMethod(Settings.Global.class, "getInt", ContentResolver.class, String.class, this);
		findAndHookMethod(Settings.Global.class, "getInt", ContentResolver.class, String.class, int.class, this);

		// 修改GoogleAdId
		//		findAndHookMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info", lpparam.classLoader,
		// "getId", this);

		// 修改蓝牙地址

		findAndHookMethod(BluetoothAdapter.class, "getAddress", this);

		// 修改一些版本名对应的版本号
//		XposedHelpers.setStaticIntField(Build.VERSION_CODES.class, "JELLY_BEAN_MR2", 21);
//		XposedHelpers.setStaticIntField(Build.VERSION_CODES.class, "KITKAT", 21);
	}

	/**
	 * Called before the invocation of the method.
	 * <p/>
	 * <p>You can use {@link MethodHookParam#setResult} and {@link MethodHookParam#setThrowable}
	 * to prevent the original method from being called.
	 * <p/>
	 * <p>Note that implementations shouldn't call {@code super(param)}, it's not necessary.
	 *
	 * @param param Information about the method call.
	 *
	 * @throws Throwable Everything the callback throws is caught and logged.
	 */
	@Override
	protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
		super.beforeHookedMethod(param);

		switch (param.method.getName()) {

		//		case "java.io.File":
		//			String path = param.args[0].toString();
		//			if (!(path.contains("/sdcard") || path.contains("/data/data") || path.contains("/mnt"))) {
		//				//param.setThrowable(new IllegalAccessException("Permission denied"));
		//				//Log.v("vcode", "--------" + path);
		//			}
		//			break;
		//
		//		case "start":
		//			ProcessBuilder pb = (ProcessBuilder) param.thisObject;
		//			List<String> strs = pb.command();
		//			String cmd = TextUtils.join(" ", strs);
		//			DLog.i("the cmd is " + cmd);
		//			if (cmd.contains("sys/class/net/wlan0/address")) {
		//
		//			} else {
		//				//param.setThrowable(new IllegalAccessException("Permission denied"));
		//			}
		//			break;
		//

		case "exec":
			if (param.args.length > 0 && param.args[0] != null) {
				String[] arg1 = (String[]) param.args[0];
				DLog.v("the cmd arg1 is " + TextUtils.join(" ", arg1));
				if ((TextUtils.join(" ", arg1).contains("sys/class/net/wlan0/address"))) {
					//Log.v("vcode", "build.description");
					//String result = xsp.getString(Config.MANUFACTURER, "");
					String result = getXSharedPreferences().getString(UnSpecifiedSp.MAC_FROM_FILE, null);
					if (!TextUtils.isEmpty(result)) {
						param.args[0] = new String[] { "sh", "-c", "echo \"" + result + "\"" };
						break;
					}
				}
			}
			if (param.args.length > 1 && param.args[1] != null) {
				String[] arg2 = (String[]) param.args[1];
				DLog.v("vcode", "the cmd arg2 is " + TextUtils.join(" ", arg2));
			}
			//param.setThrowable(new IllegalAccessException("Permission denied"));
			break;

		case "start":
			//			ProcessBuilder pb = (ProcessBuilder) param.thisObject;
			//			List<String> strs = pb.command();
			//			String cmd = TextUtils.join(" ", strs);
			//			Log.v("vcode", "the cmd is " + cmd);
			//			if (cmd.contains("sys/class/net/wlan0/address")) {
			//
			//			} else {
			//				//param.setThrowable(new IllegalAccessException("Permission denied"));
			//			}
			break;
		}
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

		// TODO  找一个嵌入了gp的测试一下是否修改成功
		case "getId":
			setStringResult(param, UnSpecifiedSp.GOOGLE_AD_ID);
			break;
		case "getString":
			if (param.args.length == 2 && param.args[0] instanceof ContentResolver && param.args[1] instanceof String &&
			    Settings.Secure.ANDROID_ID.equals(param.args[1])) {
				setStringResult(param, UnSpecifiedSp.ANDROID_ID);
			}
			break;

		case "getInt":
			if (param.args[0] instanceof ContentResolver && param.args[1] instanceof String &&
			    Settings.Secure.ADB_ENABLED.equals(param.args[1])) {
				setIntResult(param, UnSpecifiedSp.ADB_ENABLED);
			}
			break;

		case "getAddress":
			setStringResult(param, UnSpecifiedSp.BLUETOOTH_MAC);
			break;
		}
	}
}


