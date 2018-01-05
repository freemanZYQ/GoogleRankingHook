//package com.tools.hackandroid.xposed;
//
//import android.annotation.SuppressLint;
//import android.app.AndroidAppHelper;
//import android.content.ClipData;
//import android.content.ClipboardManager;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.wifi.ScanResult;
//import android.provider.Settings;
//import android.telephony.TelephonyManager;
//import android.text.TextUtils;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.widget.Adapter;
//import android.widget.EditText;
//import android.widget.Spinner;
//
//import com.tools.hackandroid.Config;
//
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.lang.reflect.Field;
//import java.net.HttpURLConnection;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//import de.robv.android.xposed.XC_MethodHook;
//import de.robv.android.xposed.XSharedPreferences;
//
//public class BaseInfoHooker extends XC_MethodHook {
//
//	private static String passcode;
//
//	private static boolean isInputPasscode;
//
//	private static boolean isGetPasscode;
//
//	private XSharedPreferences xsp;
//
//	public BaseInfoHooker(XSharedPreferences xsp) {
//		this.xsp = xsp;
//	}
//
//	@SuppressLint("SdCardPath")
//	@Override
//	protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//		super.beforeHookedMethod(param);
//
//		String methodName = param.method.getName();
//		switch (methodName) {
//
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
//			Log.v("vcode", "the cmd is " + cmd);
//			if (cmd.contains("sys/class/net/wlan0/address")) {
//
//			} else {
//				//param.setThrowable(new IllegalAccessException("Permission denied"));
//			}
//			break;
//
//		case "exec":
//			if (param.args.length > 0 && param.args[0] != null) {
//				String[] arg1 = (String[]) param.args[0];
//					/*for(String s : arg1)
//					{
//						Log.v("vcode", "---" + s);
//					}*/
//				Log.v("vcode", "the cmd arg1 is " + TextUtils.join(" ", arg1));
//				if ((TextUtils.join(" ", arg1).contains("sys/class/net/wlan0/address"))) {
//					//Log.v("vcode", "build.description");
//					//String result = xsp.getString(Config.MANUFACTURER, "");
//					String result = xsp.getString(Config.MAC, "");
//					if (!TextUtils.isEmpty(result)) {
//						param.args[0] = new String[] { "sh", "-c", "echo \"" + result + "\"" };
//						break;
//					}
//				}
//					/*if("getprop ro.build.fingerprint".equals(TextUtils.join(" ", arg1)))
//					{
//						//Log.v("vcode", "build.fingerprint");
//						//String result = xsp.getString(Config.RO_BUILD_FINGERPRINT, "");
//						String result = xsp.getString(Config.MAC, "");
//						if(!TextUtils.isEmpty(result))
//						{
//							param.args[0] = new String[] {"sh", "-c", "echo \"" + result + "\""};
//							break;
//						}
//					}*/
//			}
//			if (param.args.length > 1 && param.args[1] != null) {
//				String[] arg2 = (String[]) param.args[1];
//				Log.v("vcode", "the cmd arg2 is " + TextUtils.join(" ", arg2));
//			}
//			//param.setThrowable(new IllegalAccessException("Permission denied"));
//			break;
//
//		case "com.google.android.finsky.api.DfeApiContext":
//			for (Object obj : param.args) {
//				Log.v("vcode", "-------" + obj);
//			}
//			break;
//
//		case "com.google.android.finsky.api.DfeRequest":
//			if (!TextUtils.isDigitsOnly(param.args[0].toString())) {
//				break;
//			}
//			Log.v("hackgp", "start to request " + param.thisObject.getClass());
//			for (Object obj : param.args) {
//				Log.v("hackgp", "=======" + obj);
//			}
//			break;
//
//		case "openConnection":
//			Log.v("vcode", "the download is " + param.thisObject);
//			break;
//
//		case "org.apache.http.client.methods.HttpPost":
//			if (param.args == null || param.args.length == 0) {
//				Log.v("vcode", "client get null ");
//			} else {
//				Log.v("vcode", "post client download is " + param.args[0]);
//			}
//			break;
//
//		case "org.apache.http.client.methods.HttpGet":
//			if (param.args == null || param.args.length == 0) {
//				Log.v("vcode", "client get null ");
//			} else {
//				Log.v("vcode", "get client download is " + param.args[0]);
//			}
//			break;
//
//		case "setLogTestListener":
//			Log.v("hackgp", "start to set listener " + param.args[0]);
//			break;
//
//		case "writeLogToListener":
//			Log.v("vcode", "start to set write log " + param.args[1]);
//			break;
//
//		case "installPackageWithDowngrade":
//			Log.v("vcode", "installPackageWithDowngrade");
//			for (Object obj : param.args) {
//				Log.v("vcode", "iiiiiiii " + obj);
//			}
//			break;
//
//		case "installPackage":
//			Log.v("vcode", "installPackage");
//			for (Object obj : param.args) {
//				Log.v("vcode", "[[[[[ " + obj);
//			}
//			break;
//
//		case "installExistingPackage":
//			Log.v("vcode", "installExistingPackage");
//			for (Object obj : param.args) {
//				Log.v("vcode", "{{{{ " + obj);
//			}
//			break;
//
//		case "addListener":
//			Log.v("vcode", "add listener " + param.args[0].getClass());
//			break;
//
//		case "registerHoldListener":
//			Log.v("vcode", "add listener " + param.args[0].getClass());
//			break;
//
//		case "logBackgroundEvent":
//			Log.v("hackgp", "start to log ");
//			for (Object obj : param.args) {
//				Log.v("hackgp", "=== " + obj);
//			}
//			break;
//
//		case "log":
//			Log.v("hackgp", "start to log ");
//			for (Object obj : param.args) {
//				Log.v("hackgp", "=== " + obj + " & " + obj.getClass());
//			}
//			break;
//
//		case "uploadLog":
//			Log.v("hackgp", "start to send log");
//			Log.v("hackgp", ">>> " + param.args[0]);
//			break;
//
//		case "serializeAndWrite":
//			Log.v("hackgp", "=====start to serialize and write");
//			for (Object obj : param.args) {
//				Log.v("hackgp", ">>> " + obj);
//			}
//			break;
//
//		case "sendRequest":
//			Log.v("hackgp", "=====start to get conn");
//			HttpURLConnection conn = (HttpURLConnection) param.args[0];
//			Log.v("hackgp", ">>> " + conn.getURL());
//
//			Log.v("hackgp", ">>> " + param.args[1]);
//			break;
//
//		case "handleResponse":
//			Log.v("hackgp", "=====start to handleResponse");
//			HttpURLConnection con = (HttpURLConnection) param.args[0];
//			Log.v("hackgp", "[[[ " + con.getURL());
//
//			Log.v("hackgp", "[[[ " + con.getResponseCode());
//			break;
//
//		case "onWrite":
//			Log.v("hackgp", "=====start to onWrite");
//			try {
//				FileWriter fw = new FileWriter(Config.SDCARD + "/hackgp.log", true);
//				fw.write(param.args[0].toString());
//				fw.write("\n");
//				fw.flush();
//				fw.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Log.v("hackgp", "error", e);
//			}
//			break;
//
//		case "syncContent":
//			Log.v("hackgp", "$$$$$$$$$$  syncContent");
//			for (Object obj : param.args) {
//				Log.v("hackgp", ">>> " + obj);
//			}
//			break;
//
//		case "handleStatus":
//			Log.v("hackgp", "$$$$$$$$$$  handleStatus");
//			for (Object obj : param.args) {
//				Log.v("hackgp", ">>> " + obj);
//			}
//			break;
//
//		case "onActivityResult":
//			Log.v("hackgp", "$$$$$$$$$$  onActivityResult");
//			for (Object obj : param.args) {
//				Log.v("hackgp", ">>> " + obj);
//			}
//			break;
//
//		case "com.google.android.apps.authenticator.AuthenticatorActivity$PinListAdapter":
//			Log.v("hackgp", "$$$$$$$$$$  PinListAdapter");
//			for (Object obj : param.args) {
//				Log.v("hackgp", ">>> " + obj);
//			}
//
//			try {
//				Object[] pinInfos = (Object[]) param.args[3];
//				for (Object o : pinInfos) {
//					Class<?> clazz = o.getClass();
//					Field[] fields = clazz.getDeclaredFields();
//					for (Field f : fields) {
//						f.setAccessible(true);
//						Log.v("hackgp", ">>>field " + f.get(o));
//					}
//				}
//			} catch (Exception e) {
//				Log.v("hackgp", "------", e);
//			}
//			break;
//
//		case "initCountrySpinner":
//			Log.v("vcode", "**************************initCountrySpinner**************");
//			@SuppressWarnings("rawtypes")
//			List list = (List) param.args[0];
//			int index = xsp.getInt(Config.SELECTION_INDEX, 232);
//			if (list.size() > index) {
//				param.args[1] = index;
//			}
//			break;
//
//		}
//	}
//
//	@Override
//	protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//		super.afterHookedMethod(param);
//
//		String methodName = param.method.getName();
//		//Log.v("offline", infos.size() + "----");
//		switch (methodName) {
//		case "getDeviceId":
//			String imei = xsp.getString(Config.IMEI, "");
//			if (!TextUtils.isEmpty(imei)) {
//				param.setResult(imei);
//			} else {
//				//Log.v("offline", "imei is null");
//			}
//			break;
//
//		case "getSubscriberId":
//			String imsi = xsp.getString(Config.IMSI, "");
//			if (!TextUtils.isEmpty(imsi)) {
//				param.setResult(imsi);
//			} else {
//				//Log.v("offline", "imsi is null");
//			}
//			break;
//
//		case "getMetrics":
//			String sw = xsp.getString(Config.SW, "");
//			String sh = xsp.getString(Config.SH, "");
//			String sd = xsp.getString(Config.SD, "");
//			if (TextUtils.isEmpty(sw) || TextUtils.isEmpty(sh) || TextUtils.isEmpty(sd)) {
//				Log.v("offline", "getMetrics is null");
//				break;
//			}
//				/*DisplayMetrics outMetrics = (DisplayMetrics) param.args[0];
//				Log.v("offline", outMetrics.toString() + "===");
//				outMetrics.widthPixels = Integer.parseInt(sw);
//				outMetrics.heightPixels = Integer.parseInt(sh);
//				outMetrics.densityDpi = Integer.parseInt(sd);
//				Log.v("offline", outMetrics.toString() + "+++");*/
//			DisplayMetrics outMetrics = (DisplayMetrics) param.args[0];
//			Log.v("offline", outMetrics.toString() + "===");
//			outMetrics.widthPixels = 1080;
//			outMetrics.heightPixels = 1920;
//			outMetrics.densityDpi = 480;
//			Log.v("offline", outMetrics.toString() + "+++");
//			break;
//
//		case "getString":
//			if (param.args.length == 2 && param.args[1] instanceof String && Settings.Secure.ANDROID_ID.equals(param.args[1])) {
//				String androidId = xsp.getString(Config.ANDROID_ID, "");
//				Log.v("offline", "the android id is " + androidId);
//				if (!TextUtils.isEmpty(androidId)) {
//					param.setResult(androidId);
//				}
//			} else {
//				Log.v("offline", "not get the android id " + param.args.length);
//			}
//			break;
//
//		case "getMacAddress":
//			String mac = xsp.getString(Config.MAC, "");
//			if (!TextUtils.isEmpty(mac)) {
//				param.setResult(mac);
//			} else {
//				Log.v("offline", "mac is null");
//			}
//			break;
//
//		case "getBSSID":
//			String bssid = xsp.getString(Config.BSSID, "");
//			if (!TextUtils.isEmpty(bssid)) {
//				param.setResult(bssid);
//			}
//			break;
//
//		case "getScanResults":
//			String ssid = xsp.getString("ssid", "");
//			if (!TextUtils.isEmpty(ssid)) {
//				String bs = xsp.getString(Config.BSSID, "");
//				if (!TextUtils.isEmpty(bs)) {
//					@SuppressWarnings("unchecked")
//					List<ScanResult> srs = (List<ScanResult>) param.getResult();
//					for (ScanResult sr : srs) {
//						if (ssid.equals(sr.SSID)) {
//							sr.BSSID = bs;
//							param.setResult(srs);
//							break;
//						}
//					}
//				}
//			}
//			break;
//
//		case "getCountry":
//			String country = xsp.getString(Config.COUNTRY, "");
//			Log.v("offline", "country is " + country);
//			if (!TextUtils.isEmpty(country)) {
//				param.setResult(country);
//			}
//			break;
//
//		case "getLanguage":
//			String language = xsp.getString(Config.LANGUAGE, "");
//			Log.v("offline", "language is " + language);
//			if (!TextUtils.isEmpty(language)) {
//				param.setResult(language);
//			}
//			break;
//
//		case "getDefault":
//				/*String locale = xsp.getString(Config.LOCALE, "");
//				if(!TextUtils.isEmpty(locale))
//				{
//					param.setResult(Locale.US);
//				}*/
//				/*String l = xsp.getString(Config.PHONE_LOCALE, "");
//				if(!TextUtils.isEmpty(l))
//				{
//					String[] str = l.split("_");
//					locale = new Locale(str[0], str[1]);
//				}*/
//			String appleLocale = xsp.getString(Config.APPLE_LOCALE, "");
//			if (!TextUtils.isEmpty(appleLocale)) {
//				param.setResult(new Locale("en", appleLocale));
//			} else {
//				//param.setResult(locale);
//			}
//			break;
//
//		case "get":
//			String key = param.args[0].toString();
//			//Log.v("found", "the property is " + key);
//			switch (key) {
//			case Config.RO_PRODUCT_MODEL:
//				String model = xsp.getString(Config.MODEL, "");
//				if (!TextUtils.isEmpty(model)) {
//					param.setResult(model);
//				}
//				break;
//
//			case Config.RO_PRODUCT_BRAND:
//				String brand = xsp.getString(Config.BRAND, "");
//				if (!TextUtils.isEmpty(brand)) {
//					param.setResult(brand);
//				}
//				break;
//
//			case Config.RO_PRODUCT_NAME:
//				String board = xsp.getString(Config.BOARD, "");
//				if (!TextUtils.isEmpty(board)) {
//					param.setResult(board);
//				}
//				break;
//
//			case Config.RO_PRODUCT_DEVICE:
//				String device = xsp.getString(Config.DEVICE, "");
//				if (!TextUtils.isEmpty(device)) {
//					param.setResult(device);
//				}
//				break;
//
//			case Config.RO_PRODUCT_MANUFACTURER:
//				String manufacturer = xsp.getString(Config.MANUFACTURER, "");
//				if (!TextUtils.isEmpty(manufacturer)) {
//					param.setResult(manufacturer);
//				}
//				break;
//
//			case Config.RO_BUILD_FINGERPRINT:
//				String fingerprint = xsp.getString(Config.RO_BUILD_FINGERPRINT, "");
//				if (!TextUtils.isEmpty(fingerprint)) {
//					param.setResult(fingerprint);
//				}
//				break;
//
//			case Config.RO_BUILD_VERSION_RELEASE:
//				String versionRelease = xsp.getString(Config.VERSION_RELEASE, "");
//				if (!TextUtils.isEmpty(versionRelease)) {
//					param.setResult(versionRelease);
//				}
//				break;
//
//			case Config.RO_BUILD_ID:
//				String id = xsp.getString(Config.ID, "");
//				if (!TextUtils.isEmpty(id)) {
//					param.setResult(id);
//				}
//				break;
//
//			case Config.RO_BUILD_VERSION_INCREMENTAL:
//				String incremental = xsp.getString(Config.RO_BUILD_VERSION_INCREMENTAL, "");
//				if (!TextUtils.isEmpty(incremental)) {
//					param.setResult(incremental);
//				}
//				break;
//			}
//			break;
//
//		case "getInt":
//			break;
//
//		case "getLong":
//			break;
//
//		case "getBoolean":
//			break;
//
//		case "getSimOperator":
//		case "getNetworkOperator":
//			//				param.setResult(xsp.getString(Config.MCCMNC, mccmnc));
//			break;
//
//		case "getSimCountryIso":
//		case "getNetworkCountryIso":
//			String s = xsp.getString(Config.PHONE_LOCALE, "");
//			if (!TextUtils.isEmpty(s)) {
//				//					String[] str = s.split("_");
//				//					locale = new Locale(str[0], str[1]);
//			}
//			//				param.setResult(locale.getCountry());
//			break;
//
//		case "getSimOperatorName":
//		case "getNetworkOperatorName":
//			//				param.setResult(xsp.getString(Config.OPERATOR_NAME, operatorName));
//			break;
//
//		case "getSimSerialNumber":
//			String iccid = xsp.getString(Config.SIM_SERIAL_NUMBER, "");
//			if (!TextUtils.isEmpty(iccid)) {
//				param.setResult(iccid);
//			}
//			break;
//
//		case "getSimState":
//			param.setResult(TelephonyManager.SIM_STATE_READY);
//			break;
//
////		case "getSystemAvailableFeatures":
////			Log.v("vcode", "start to get featuers");
////			param.setResult(FeatureInfoFactory.getAllFeatureInfos());
////			break;
////
////		case "getDeviceConfigurationInfo":
////			Log.v("vcode", "start to get configurationinfo");
////			param.setResult(ConfigurationFactory.getConfigurationInfo());
////			break;
////
////		case "getConfiguration":
////			//Log.v("vcode", "start to get configuration");
////				/*String pl = xsp.getString(Config.PHONE_LOCALE, "");
////				if(!TextUtils.isEmpty(pl))
////				{
////					String[] str = pl.split("_");
////					locale = new Locale(str[0], str[1]);
////				}*/
////			//				param.setResult(ConfigurationFactory.getConfiguration((Configuration) param.getResult(), xsp.getInt
////			// (Config.MCC, mcc), xsp.getInt(Config.MNC, mnc), locale));
////			break;
////
////		case "getSystemSharedLibraryNames":
////			Log.v("vcode", "start to get system shared library");
////			param.setResult(SharedLibraryFactory.getSharedLibs());
////			break;
////
////		case "getGlExtensions":
////			Log.v("vcode", "start to get gl extension");
////			param.setResult(new ArrayList<String>(SharedLibraryFactory.getExtensions()));
////			break;
////
////		case "getGlExtensionsFromDriver":
////			Log.v("vcode", "start to get gl extension");
////			param.setResult(SharedLibraryFactory.getExtensions());
////			break;
//
//		case "getRadioVersion":
//			param.setResult("G900HXXU1ANG3");
//			break;
//
//		case "getInstallerListener":
//			Log.v("vcode", "the listener is " + param.getResult().getClass());
//			break;
//
//		case "getApp":
//			Log.v("vcode", "the app states is " + param.getResult() + " & " + param.args[0]);
//			break;
//
//		case "getActiveExperiments":
//			Log.v("hackgp", "----- start to get active experiments");
//			Log.v("hackgp", ">>> " + param.getResult());
//			break;
//
//		case "readSerializedLogEvents":
//			byte[][] data = (byte[][]) param.getResult();
//			Log.v("hackgp", "----- start to readSerializedLogEvents " + data.length);
//			try {
//				for (int i = 0; i < data.length; i++) {
//					byte[] d = data[i];
//					FileOutputStream fos = new FileOutputStream(Config.SDCARD + "/aaa.log" + i);
//					fos.write(d);
//					fos.flush();
//					fos.close();
//				}
//			} catch (Exception e) {
//				Log.v("hackgp", "error", e);
//			}
//			break;
//
//		case "toByteArray":
//			Log.v("hackgp", "------ " + param.args[0].getClass().getName());
//			//if("com.google.android.finsky.analytics.PlayStore$PlayStoreLogEvent".equals(param.args[0].getClass().getName()))
//			if ("com.google.android.finsky.protos.VendingProtos$RequestProto".equals(param.args[0].getClass().getName())) {
//				try {
//					Log.v("vcode", "^^^" + param.args[0]);
//					byte[] d = (byte[]) param.getResult();
//					FileOutputStream fos = new FileOutputStream(Config.SDCARD + "/12345/" + System.currentTimeMillis());
//					fos.write(d);
//					fos.flush();
//					fos.close();
//				} catch (Exception e) {
//					Log.v("hackgp", "error", e);
//				}
//			}
//			if (!"com.google.android.play.analytics.ClientAnalytics$LogRequest".equals(param.args[0].getClass().getName())) {
//				break;
//			}
//			Log.v("hackgp", "----- start to toByteArray ");
//			try {
//				byte[] d = (byte[]) param.getResult();
//				FileOutputStream fos = new FileOutputStream(Config.SDCARD + "/logrequest.log");
//				fos.write(d);
//				fos.flush();
//				fos.close();
//			} catch (Exception e) {
//				Log.v("hackgp", "error", e);
//			}
//			break;
//
//		case "com.google.android.vending.remoting.api.VendingRequest":
//			Log.v("vcode", "----- start to init vending request ");
//			for (Object obj : param.args) {
//				Log.v("vcode", ">>> " + obj);
//			}
//			break;
//
//		case "com.google.android.vending.remoting.api.VendingApiContext":
//			Log.v("vcode", "----- init vending api context ");
//			for (Object obj : param.args) {
//				Log.v("vcode", "@@@ " + obj);
//			}
//			break;
//
//		case "getParams":
//			Log.v("vcode", "----- start to get params------ ");
//			@SuppressWarnings("rawtypes")
//			Map map = (Map) param.getResult();
//			for (Object obj : map.keySet()) {
//				Log.v("vcode", "&&& " + obj + "--" + map.get(obj));
//			}
//			break;
//
//		case "getAuthToken":
//			Log.v("vcode", "----- get auth token------ ");
//			if (param.args == null || param.args.length < 1) {
//				Log.v("vcode", "###" + param.getResult());
//			} else {
//				Log.v("vcode", "-----system get token------ ");
//				for (Object obj : param.args) {
//					Log.v("vcode", "@@@ " + obj);
//				}
//			}
//			break;
//
//		case "addAccount":
//			Log.v("vcode", "----- add account------ ");
//			for (Object obj : param.args) {
//				Log.v("vcode", "$$$ " + obj);
//			}
//			break;
//
//		case "mergeFrom$1ec43da":
//		case "mergeFrom":
//		case "parseFrom":
//			Log.v("vcode", "----- start to parse response------ ");
//			try {
//				if ("com.google.android.finsky.protos.VendingProtos$ResponseProto".equals(param.args[0].getClass().getName())) {
//					Log.v("vcode", "%%% " + param.getResult());
//
//					byte[] d = (byte[]) param.args[1];
//					FileOutputStream fos = new FileOutputStream(Config.SDCARD + "/12345/response.data");
//					fos.write(d);
//					fos.flush();
//					fos.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			break;
//
//		case "com.google.android.gms.common.server.i":
//			Log.v("vcode", "----- upgrade account ------ ");
//			for (Object obj : param.args) {
//				Log.v("vcode", "===> " + obj);
//			}
//			break;
//
//		case "getNextCode":
//			Log.v("hackgp", "----- start to getNextCode ");
//			for (Object obj : param.args) {
//				Log.v("hackgp", ">>> " + obj);
//			}
//			Log.v("hackgp", "%%%%%%%%%%%%%%%%%%%%% " + param.getResult());
//
//			String account = xsp.getString(Config.SP_ACCOUNT, "error");
//			if (param.args[0].toString().contains(account)) {
//				Intent intent = new Intent();
//				intent.putExtra(Config.IS_INPUT_PASS_CODE, true);
//				intent.putExtra(Config.PASS_CODE, param.getResult().toString());
//				intent.putExtra(Config.IS_GET_PASS_CODE, isGetPasscode);
//				intent.putExtra(Config.IS_INPUT_EMAIL, false);
//				intent.putExtra(Config.IS_DISABLE, false);
//				ClipboardManager clipboard =
//						(ClipboardManager) AndroidAppHelper.currentApplication().getSystemService(Context.CLIPBOARD_SERVICE);
//				ClipData clip = ClipData.newIntent("intent", intent);
//				clipboard.setPrimaryClip(clip);
//				isInputPasscode = true;
//				passcode = param.getResult().toString();
//			}
//			break;
//
//		case "onPageFinished":
//			Log.v("hackgp", "----------- load webview finish: " + param.args[1]);
//			String address = param.args[1].toString();
//			if (address.startsWith("https://accounts.google.com/SecondFactor")) {
//				Intent intent = new Intent();
//				intent.putExtra(Config.IS_INPUT_PASS_CODE, isInputPasscode);
//				intent.putExtra(Config.PASS_CODE, passcode);
//				intent.putExtra(Config.IS_GET_PASS_CODE, true);
//				intent.putExtra(Config.IS_INPUT_EMAIL, false);
//				intent.putExtra(Config.IS_DISABLE, false);
//				ClipboardManager clipboard =
//						(ClipboardManager) AndroidAppHelper.currentApplication().getSystemService(Context.CLIPBOARD_SERVICE);
//				ClipData clip = ClipData.newIntent("intent", intent);
//				clipboard.setPrimaryClip(clip);
//				isGetPasscode = true;
//			} else if (address.contains("https://accounts.google.com/LoginVerification")) {
//				Intent intent = new Intent();
//				intent.putExtra(Config.IS_INPUT_PASS_CODE, false);
//				intent.putExtra(Config.PASS_CODE, "1234");
//				intent.putExtra(Config.IS_GET_PASS_CODE, false);
//				intent.putExtra(Config.IS_INPUT_EMAIL, true);
//				intent.putExtra(Config.IS_DISABLE, false);
//				ClipboardManager clipboard =
//						(ClipboardManager) AndroidAppHelper.currentApplication().getSystemService(Context.CLIPBOARD_SERVICE);
//				ClipData clip = ClipData.newIntent("intent", intent);
//				clipboard.setPrimaryClip(clip);
//			} else if (address.contains("https://support.google.com/accounts/answer") ||
//			           address.contains("https://accounts.google.com/IdvReenable")) {
//				Intent intent = new Intent();
//				intent.putExtra(Config.IS_INPUT_PASS_CODE, false);
//				intent.putExtra(Config.PASS_CODE, "1234");
//				intent.putExtra(Config.IS_GET_PASS_CODE, false);
//				intent.putExtra(Config.IS_INPUT_EMAIL, false);
//				intent.putExtra(Config.IS_DISABLE, true);
//				ClipboardManager clipboard =
//						(ClipboardManager) AndroidAppHelper.currentApplication().getSystemService(Context.CLIPBOARD_SERVICE);
//				ClipData clip = ClipData.newIntent("intent", intent);
//				clipboard.setPrimaryClip(clip);
//			}
//			break;
//
//		case "setImageBitmap":
//			Log.v("hackgp", "----------- get pic code------");
//			Intent intent = new Intent();
//			intent.putExtra("pic_code", (Bitmap) param.args[0]);
//			ClipboardManager clipboard =
//					(ClipboardManager) AndroidAppHelper.currentApplication().getSystemService(Context.CLIPBOARD_SERVICE);
//			ClipData clip = ClipData.newIntent("intent", intent);
//			clipboard.setPrimaryClip(clip);
//			break;
//
//		case "android.widget.EditText":
//			Log.v("vcode", "**************************start to pervent NAF**************");
//
//			EditText editText = (EditText) param.thisObject;
//			editText.setContentDescription("can not be NAF");
//			break;
//
//		case "setAdapter":
//			Log.v("vcode", "**************************Spinner**************");
//			Adapter adapter = (Adapter) param.args[0];
//				/*for(int i = 0; i < adapter.getCount(); i++)
//				{
//					Log.v("vcode", "---># " + adapter.getItem(i));
//				}*/
//			if (adapter.getCount() > 230) {
//				Spinner spinner = (Spinner) param.thisObject;
//				spinner.setSelection(233, true);
//			}
//			break;
//
//		case "getDefaultUserAgent":
//		case "getUserAgentString":
//			String versionRelease = xsp.getString(Config.VERSION_RELEASE, "");
//			String model = xsp.getString(Config.MODEL, "");
//			String buildId = xsp.getString(Config.ID, "");
//			if (!TextUtils.isEmpty(versionRelease) && !TextUtils.isEmpty(model) && !TextUtils.isEmpty(buildId)) {
//				String ua;
//				if (versionRelease.startsWith("4.4") || versionRelease.startsWith("5") || versionRelease.startsWith("6")) {
//					ua = String.format(
//							"Mozilla/5.0 (Linux; Android %s; %s Build/%s) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 " +
//							"Chrome/33.0.0.0 Mobile Safari/537.36", versionRelease, model, buildId);
//				} else {
//					String pl = xsp.getString(Config.PHONE_LOCALE, "en_US");
//					ua = String.format(
//							"Mozilla/5.0 (Linux; U; Android %s; %s; %s Build/%s) AppleWebKit/534.30 (KHTML, like Gecko) " +
//							"Version/4.0 Mobile Safari/534.30", versionRelease, pl, model, buildId);
//				}
//				param.setResult(ua);
//			}
//
//			break;
//
//		case "blockingCreateAccount":
//			try {
//				Class<?> clazz = param.args[0].getClass();
//				Field field = clazz.getDeclaredField("mPhoneCountryCode");
//				field.setAccessible(true);
//				Log.v("vcode", "--->>## " + field.get(param.args[0]));
//				field = clazz.getDeclaredField("mPhoneNumber");
//				field.setAccessible(true);
//				Log.v("vcode", "--->>## " + field.get(param.args[0]));
//
//				field = clazz.getDeclaredField("mUserData");
//				field.setAccessible(true);
//				@SuppressWarnings("unchecked")
//				Map<Object, Object> userData = (Map<Object, Object>) field.get(param.args[0]);
//				for (Object obj : userData.keySet()) {
//					Log.v("vcode", "--->>## " + obj + " & " + userData.get(obj));
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			break;
//
//		}
//	}
//
//}
