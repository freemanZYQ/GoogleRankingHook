//package com.tools.hackandroid.xposed;
//
//import android.app.ActivityManager;
//import android.content.ContentResolver;
//import android.content.res.Resources;
//import android.net.wifi.WifiInfo;
//import android.net.wifi.WifiManager;
//import android.os.Build;
//import android.provider.Settings;
//import android.telephony.TelephonyManager;
//import android.text.TextUtils;
//import android.util.DisplayMetrics;
//import android.view.Display;
//
//import com.tools.hackandroid.BuildConfig;
//import com.tools.hackandroid.Config;
//import com.tools.hackandroid.util.DLog;
//
//import java.io.File;
//import java.util.Locale;
//
//import de.robv.android.xposed.IXposedHookLoadPackage;
//import de.robv.android.xposed.IXposedHookZygoteInit;
//import de.robv.android.xposed.XSharedPreferences;
//import de.robv.android.xposed.XposedBridge;
//import de.robv.android.xposed.XposedHelpers;
//import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
//
//public class XposedHooker_Old implements IXposedHookZygoteInit, IXposedHookLoadPackage {
//
//	private XSharedPreferences mXSharedPreferences;
//
//	@Override
//	public void initZygote(StartupParam startupParam) throws Throwable {
//		mXSharedPreferences = new XSharedPreferences(BuildConfig.APPLICATION_ID, Config.XPOSED_SP_NAME);
//		mXSharedPreferences.makeWorldReadable();
//	}
//
//	@Override
//	public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
//		mXSharedPreferences.reload();
//
//		DLog.i("开始修改数据");
//
//		final com.tools.hackandroid.xposed.BaseInfoHooker baseInfoHooker = new com.tools.hackandroid.xposed.BaseInfoHooker(mXSharedPreferences);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getDeviceId", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSubscriberId", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getNetworkOperator", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getNetworkCountryIso", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getNetworkOperatorName", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimOperator", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimCountryIso", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimOperatorName", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimSerialNumber", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimState", baseInfoHooker);
//
//		XposedHelpers
//				.findAndHookMethod("android.app.ApplicationPackageManager", lpparam.classLoader, "getSystemAvailableFeatures",
//						baseInfoHooker);
//		XposedHelpers
//				.findAndHookMethod("android.app.ApplicationPackageManager", lpparam.classLoader, "getSystemSharedLibraryNames",
//						baseInfoHooker);
//
//		XposedHelpers.findAndHookMethod(ActivityManager.class, "getDeviceConfigurationInfo", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(Resources.class, "getConfiguration", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(Locale.class, "getDefault", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(Build.class, "getRadioVersion", baseInfoHooker);
//
//		XposedHelpers.findAndHookMethod(WifiManager.class, "getScanResults", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(WifiInfo.class, "getMacAddress", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(WifiInfo.class, "getBSSID", baseInfoHooker);
//
//		/*XposedHelpers.findAndHookMethod(Locale.class, "getCountry", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(Locale.class, "getLanguage", baseInfoHooker);*/
//
//		XposedHelpers.findAndHookMethod(Display.class, "getMetrics", DisplayMetrics.class, baseInfoHooker);
//
//		XposedHelpers.findAndHookMethod(Settings.Secure.class, "getString", ContentResolver.class, String.class, baseInfoHooker);
//
//		XposedHelpers.findAndHookMethod("android.os.SystemProperties", lpparam.classLoader, "get", String.class, baseInfoHooker);
//		XposedHelpers.findAndHookMethod("android.os.SystemProperties", lpparam.classLoader, "get", String.class, String.class,
//				baseInfoHooker);
//		XposedHelpers.findAndHookMethod("android.os.SystemProperties", lpparam.classLoader, "getInt", String.class, int.class,
//				baseInfoHooker);
//		XposedHelpers.findAndHookMethod("android.os.SystemProperties", lpparam.classLoader, "getLong", String.class, long.class,
//				baseInfoHooker);
//		XposedHelpers
//				.findAndHookMethod("android.os.SystemProperties", lpparam.classLoader, "getBoolean", String.class, boolean.class,
//						baseInfoHooker);
//
//		XposedBridge.hookAllConstructors(File.class, baseInfoHooker);
//		XposedHelpers.findAndHookMethod(ProcessBuilder.class, "start", baseInfoHooker);
//		XposedHelpers.findAndHookMethod(Runtime.class, "exec", String[].class, String[].class, File.class, baseInfoHooker);
//
//		//XposedHelpers.setStaticIntField(Build.VERSION.class, "SDK_INT", 17);
//		//XposedHelpers.setStaticIntField(Build.VERSION_CODES.class, "JELLY_BEAN_MR2", 21);
//		//XposedHelpers.setStaticIntField(Build.VERSION_CODES.class, "KITKAT", 21);
//
//		String board = mXSharedPreferences.getString(Config.BOARD, "");
//		if (!TextUtils.isEmpty(board)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.BOARD, board);
//		}
//		String brand = mXSharedPreferences.getString(Config.BRAND, "");
//		if (!TextUtils.isEmpty(brand)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.BRAND, brand);
//		}
//		String device = mXSharedPreferences.getString(Config.DEVICE, "");
//		if (!TextUtils.isEmpty(device)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.DEVICE, device);
//		}
//		String manufacturer = mXSharedPreferences.getString(Config.MANUFACTURER, "");
//		if (!TextUtils.isEmpty(manufacturer)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.MANUFACTURER, manufacturer);
//		}
//		String model = mXSharedPreferences.getString(Config.MODEL, "");
//		if (!TextUtils.isEmpty(model)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.MODEL, model);
//		}
//		String versionRelease = mXSharedPreferences.getString(Config.VERSION_RELEASE, "");
//		if (!TextUtils.isEmpty(versionRelease)) {
//			XposedHelpers.setStaticObjectField(Build.VERSION.class, Config.VERSION_RELEASE, versionRelease);
//		}
//		String id = mXSharedPreferences.getString(Config.ID, "");
//		if (!TextUtils.isEmpty(id)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.ID, id);
//		}
//		String fingerprint = mXSharedPreferences.getString(Config.RO_BUILD_FINGERPRINT, "");
//		if (!TextUtils.isEmpty(fingerprint)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.FINGERPRINT, fingerprint);
//		}
//		String serial = mXSharedPreferences.getString(Config.SERIAL, "");
//		if (!TextUtils.isEmpty(serial)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.SERIAL, serial);
//		}
//		String time = mXSharedPreferences.getString(Config.TIME, "");
//		if (!TextUtils.isEmpty(time)) {
//			XposedHelpers.setStaticLongField(Build.class, Config.TIME, Long.parseLong(time));
//		}
//		String product = mXSharedPreferences.getString(Config.PRODUCT, "");
//		if (!TextUtils.isEmpty(product)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.PRODUCT, product);
//		}
//		String hardware = mXSharedPreferences.getString(Config.HARDWARE, "");
//		if (!TextUtils.isEmpty(hardware)) {
//			XposedHelpers.setStaticObjectField(Build.class, Config.HARDWARE, hardware);
//		}
//		XposedHelpers.setStaticObjectField(Build.class, "BOOTLOADER", "G900HXXU1ANG3");
//
//	}
//
//}
