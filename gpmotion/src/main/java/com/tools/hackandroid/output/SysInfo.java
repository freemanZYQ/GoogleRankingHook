package com.tools.hackandroid.output;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.tools.hackandroid.sp.WIfiManagerSp;
import com.tools.hackandroid.util.DLog;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author zhitao
 * @since 2016-04-15 10:18
 */
public class SysInfo {

	private static TelephonyManager mTelephonyManager;

	private static WifiManager mWifiManager;

	private static WindowManager mWinDowWindowManager;


	/**
	 * 获取所有模拟的系统设备参数
	 *
	 * @return
	 */
	public static String getAllSimulatorSysInfo(Context context) {
		StringBuilder sb = new StringBuilder(2048);
		sb.append(SysInfo.getSysInfo(context));
		sb.append(SysInfo.getBuildVersionInfo());
		sb.append(SysInfo.getBuildInfo());
		sb.append(SysInfo.getBuildInfoFromSystemProperties());
		sb.append(SysInfo.getExtraInfo(context));
		sb.append(BatteryInfo.getCurrentBatteryInfoString(context));
		return sb.toString();
	}

//	public static String getBaseSysInfo(Context context){
//
//	}

	public static String getSysInfo(Context context) {
		if (mTelephonyManager == null) {
			mTelephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		}
		if (mWifiManager == null) {
			mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		}
		if (mWinDowWindowManager == null) {
			mWinDowWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		}

		//		DisplayMetrics outMetrics = new DisplayMetrics();
		//		getWindow().getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		DisplayMetrics systemDm = new DisplayMetrics();
		mWinDowWindowManager.getDefaultDisplay().getMetrics(systemDm);

		WifiInfo wifiInfo = mWifiManager.getConnectionInfo();

		StringBuilder sb = new StringBuilder();
		sb.append("\n\n## 设备信息\n");

		sb.append("\n\nandroid id:").append(Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID));

		sb.append("\n\nmac:").append(wifiInfo.getMacAddress());
		sb.append("\nssid:").append(wifiInfo.getSSID());
		sb.append("\nbssid:").append(wifiInfo.getBSSID());

		List<ScanResult> list = mWifiManager.getScanResults();
		if (list == null || list.isEmpty()) {
			sb.append("\nscanResults:null");
		} else {
			String str = "";
			for (ScanResult temp : list) {
				str += "\n\n" + temp.toString();
			}
			sb.append("\nscanResults:").append(str);
		}

		sb.append("\n\nhttp.agent:").append(System.getProperty("http.agent", ""));

		sb.append("\n\nimei:").append(mTelephonyManager.getDeviceId());
		sb.append("\nimsi:").append(mTelephonyManager.getSubscriberId());

		sb.append("\n\n网络 MCCMNC:").append(mTelephonyManager.getNetworkOperator());
		sb.append("\n网络 运营商:").append(mTelephonyManager.getNetworkOperatorName());
		sb.append("\n网络 运营商ISO:").append(mTelephonyManager.getNetworkCountryIso());
		sb.append("\n网络 类型:").append(mTelephonyManager.getNetworkType());

		sb.append("\n\nsim MCCMNC:").append(mTelephonyManager.getSimOperator());
		sb.append("\nsim 运营商:").append(mTelephonyManager.getSimOperatorName());
		sb.append("\nsim 国家ISO:").append(mTelephonyManager.getSimCountryIso());
		sb.append("\nsim iccid:").append(mTelephonyManager.getSimSerialNumber());
		sb.append("\nsim 卡状态:").append(mTelephonyManager.getSimState());

		sb.append("\n\ncountry:").append(Locale.getDefault().getCountry());
		sb.append("\nlanguage:").append(Locale.getDefault().getLanguage());

		sb.append("\n\n当前屏幕可视区域:");
		int[] temp = ScreenInfo.getCurrentVisibleScreenInfo(context);
		sb.append("\nwidth:").append(temp[0]);
		sb.append("\nheight:").append(temp[1]);

		sb.append("\n\n旧版屏幕宽高获取:");
		sb.append("\nwidth:").append(systemDm.widthPixels);
		sb.append("\nheight:").append(systemDm.heightPixels);
		sb.append("\ndpi:").append(systemDm.densityDpi);

		sb.append("\n\n屏幕信息修正:");
		sb.append("\ngetWidthPx:").append(ScreenInfo.getWidthPx(context));
		sb.append("\ngetHeightPx:").append(ScreenInfo.getHeightPx(context));
		sb.append("\ngetDensityDpi:").append(ScreenInfo.getDensityDpi(context));
		sb.append("\ngetDensity:").append(ScreenInfo.getDensity(context));
		sb.append("\ngetPPI:").append(ScreenInfo.getPPI(context));
		sb.append("\ngetSize:").append(ScreenInfo.getSize(context));
		sb.append("\ngetXDPI:").append(ScreenInfo.getXDPI(context));
		sb.append("\ngetYDPI:").append(ScreenInfo.getYDPI(context));
		sb.append("\ngetOrientation:").append(ScreenInfo.getOrientation(context));

		return sb.toString();
	}

	/**
	 * 获取Build.VERSION Info
	 *
	 * @return
	 */
	public static String getBuildVersionInfo() {
		StringBuilder sb = new StringBuilder(1024);
		sb.append("\n\n## Build.Version\n");
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			sb.append("\nBuild.VERSION.BASE_OS           = ").append(Build.VERSION.BASE_OS);
			sb.append("\nBuild.VERSION.PREVIEW_SDK_INT   = ").append(Build.VERSION.PREVIEW_SDK_INT);
			sb.append("\nBuild.VERSION.SECURITY_PATCH    = ").append(Build.VERSION.SECURITY_PATCH);
		}
		sb.append("\nBuild.VERSION.CODENAME          = ").append(Build.VERSION.CODENAME);
		sb.append("\nBuild.VERSION.INCREMENTAL       = ").append(Build.VERSION.INCREMENTAL);
		sb.append("\nBuild.VERSION.RELEASE           = ").append(Build.VERSION.RELEASE);
		sb.append("\nBuild.VERSION.SDK_INT           = ").append(Build.VERSION.SDK_INT);
		return sb.toString();
	}

	/**
	 * 获取Build Info
	 *
	 * @return
	 */
	public static String getBuildInfo() {
		StringBuilder sb = new StringBuilder(1024);
		sb.append("\n\n## Build\n");
		sb.append("\nBuild.DEVICE       = ").append(Build.DEVICE);
		sb.append("\nBuild.BOARD        = ").append(Build.BOARD);
		sb.append("\nBuild.BRAND        = ").append(Build.BRAND);
		sb.append("\nBuild.MODEL        = ").append(Build.MODEL);
		sb.append("\nBuild.FINGERPRINT  = ").append(Build.FINGERPRINT);
		sb.append("\nBuild.DISPLAY      = ").append(Build.DISPLAY);
		sb.append("\nBuild.MANUFACTURER = ").append(Build.MANUFACTURER);
		sb.append("\nBuild.SERIAL       = ").append(Build.SERIAL);
		sb.append("\nBuild.BOOTLOADER   = ").append(Build.BOOTLOADER);
		sb.append("\nBuild.CPU_ABI      = ").append(Build.CPU_ABI);
		sb.append("\nBuild.CPU_ABI2     = ").append(Build.CPU_ABI2);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			sb.append("\nBuild.SUPPORTED_ABIS      = ").append(Arrays.toString(Build.SUPPORTED_ABIS));
			sb.append("\nBuild.SUPPORTED_32_BIT_ABIS      = ").append(Arrays.toString(Build.SUPPORTED_32_BIT_ABIS));
			sb.append("\nBuild.SUPPORTED_64_BIT_ABIS      = ").append(Arrays.toString(Build.SUPPORTED_64_BIT_ABIS));
		}
		sb.append("\nBuild.HARDWARE     = ").append(Build.HARDWARE);
		sb.append("\nBuild.HOST         = ").append(Build.HOST);
		sb.append("\nBuild.ID           = ").append(Build.ID);
		sb.append("\nBuild.PRODUCT      = ").append(Build.PRODUCT);
		sb.append("\nBuild.TAGS         = ").append(Build.TAGS);
		sb.append("\nBuild.TIME         = ").append(Build.TIME);
		sb.append("\nBuild.TYPE         = ").append(Build.TYPE);
		sb.append("\nBuild.UNKNOWN      = ").append(Build.UNKNOWN);
		sb.append("\nBuild.USER         = ").append(Build.USER);
		sb.append("\nBuild.getRadioVersion() = ").append(Build.getRadioVersion());

		return sb.toString();
	}

	/**
	 * 从SystemProperties中获取Build Info
	 *
	 * @return
	 */
	public static String getBuildInfoFromSystemProperties() {
		StringBuilder sb = new StringBuilder(1024);
		sb.append("\n\n## Build From SystemProperties\n");
		sb.append("\nBuild.DEVICE       = ").append(reflectStaticStringMethod("ro.product.device"));
		sb.append("\nBuild.BOARD        = ").append(reflectStaticStringMethod("ro.product.board"));
		sb.append("\nBuild.BRAND        = ").append(reflectStaticStringMethod("ro.product.brand"));
		sb.append("\nBuild.MODEL        = ").append(reflectStaticStringMethod("ro.product.model"));
		sb.append("\nBuild.FINGERPRINT  = ").append(reflectStaticStringMethod("ro.build.fingerprint"));
		sb.append("\nBuild.DISPLAY      = ").append(reflectStaticStringMethod("ro.build.display.id"));
		sb.append("\nBuild.MANUFACTURER = ").append(reflectStaticStringMethod("ro.product.manufacturer"));
		sb.append("\nBuild.SERIAL       = ").append(reflectStaticStringMethod("ro.serialno"));
		sb.append("\nBuild.BOOTLOADER   = ").append(reflectStaticStringMethod("ro.bootloader"));
		//		sb.append("\nBuild.CPU_ABI      = ").append(Build.CPU_ABI);
		//		sb.append("\nBuild.CPU_ABI2     = ").append(Build.CPU_ABI2);
		//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
		//			sb.append("\nBuild.SUPPORTED_ABIS      = ").append(Arrays.toString(Build.SUPPORTED_ABIS));
		//			sb.append("\nBuild.SUPPORTED_32_BIT_ABIS      = ").append(Arrays.toString(Build.SUPPORTED_32_BIT_ABIS));
		//			sb.append("\nBuild.SUPPORTED_64_BIT_ABIS      = ").append(Arrays.toString(Build.SUPPORTED_64_BIT_ABIS));
		//		}
		sb.append("\nBuild.HARDWARE     = ").append(reflectStaticStringMethod("ro.hardware"));
		sb.append("\nBuild.HOST         = ").append(reflectStaticStringMethod("ro.build.host"));
		sb.append("\nBuild.ID           = ").append(reflectStaticStringMethod("ro.build.id"));
		sb.append("\nBuild.PRODUCT      = ").append(reflectStaticStringMethod("ro.product.name"));
		sb.append("\nBuild.TAGS         = ").append(reflectStaticStringMethod("ro.build.tags"));
		sb.append("\nBuild.TIME         = ").append(reflectStaticLongMethod("ro.build.date.utc"));
		sb.append("\nBuild.TYPE         = ").append(reflectStaticStringMethod("ro.build.type"));
		sb.append("\nBuild.UNKNOWN      = ").append(Build.UNKNOWN);
		sb.append("\nBuild.USER         = ").append(reflectStaticStringMethod("ro.build.user"));
		sb.append("\nBuild.getRadioVersion() = ").append(Build.getRadioVersion());
		return sb.toString();
	}

	private static String reflectStaticStringMethod(String key) {
		try {
			Class c = Build.class;
			Method method = c.getDeclaredMethod("getString", String.class);
			method.setAccessible(true);
			return method.invoke(null, key).toString();
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	private static long reflectStaticLongMethod(String key) {
		try {
			Class c = Build.class;
			Method method = c.getDeclaredMethod("getLong", String.class);
			method.setAccessible(true);
			return Long.parseLong(method.invoke(null, key).toString());
		} catch (Throwable e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 获取其他额外的信息
	 *
	 * @return
	 */
	public static String getExtraInfo(Context context) {
		StringBuilder sb = new StringBuilder(1024);
		sb.append("\n\n## Extra Info\n");
		sb.append("\ngoogleAdId           = ").append(sync_getGoogleAdId(context));
		sb.append("\nmacfromfile          = ").append(getMacFromFile(context));
		sb.append("\napn                  = ").append(getAPN(context));
		sb.append("\n是否开启了开发者调试模式 = ").append(isDeveloperDebugModelOpened(context));
		sb.append("\n蓝牙mac地址            = ").append(getBLuetoolMac());
		return sb.toString();
	}

	private static String getBLuetoolMac() {
		try {
			return BluetoothAdapter.getDefaultAdapter().getAddress();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取APN
	 *
	 * @param context
	 *
	 * @return
	 */
	private static String getAPN(Context context) {
		try {

			//			if (Util_System_Permission.isWith_ACCESS_NETWORK_STATE_Permission(context)) {
			// 具有网络访问权限时才可以获取apn
			ConnectivityManager connectivityManager =
					(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
			if (activeNetworkInfo != null) {
				if (activeNetworkInfo.isAvailable()) {
					switch (activeNetworkInfo.getType()) {
					case ConnectivityManager.TYPE_WIFI: // wifi网络
						return APN.APN_WIFI;
					case ConnectivityManager.TYPE_MOBILE: // 手机网络
						// 判断接入点
						String apn = activeNetworkInfo.getExtraInfo();
						return apn;
					//						if (apn != null) {
					//							apn = apn.trim().toLowerCase();
					//							if (apn.length() > 25) {
					//								return apn.substring(0, 25);
					//							} else {
					//								return apn;
					//							}
					//						} else {
					//							// 未知接入点，返回 APN_UNKNOW
					//							return APN.APN_UNKNOW;
					//						}
					default:
						break;
					}
				}
			}
			//			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return APN.APN_UNKNOW;
	}

	private static String getMacFromFile(Context context) {
		InputStreamReader ir = null;
		LineNumberReader input = null;
		try {
			String str;
			Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address");
			ir = new InputStreamReader(pp.getInputStream());
			input = new LineNumberReader(ir);
			while (!TextUtils.isEmpty(str = input.readLine())) {
				//				return str;
				String mac = str.trim();
				if (TextUtils.isEmpty(mac)) {
					continue;
				}
				return mac;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			try {
				if (ir != null) {
					ir.close();
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private static String sync_getGoogleAdId(Context context) {
		//		try {
		//			Class<?> c = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
		//			Method m = c.getDeclaredMethod("getAdvertisingIdInfo", Context.class);
		//			Object result = m.invoke(c, context);
		//			Class<?> info = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
		//			Method mid = info.getDeclaredMethod("getId");
		//			Object aid = mid.invoke(result);
		//			if (aid != null) {
		//				return aid.toString();
		//			}
		//		} catch (Throwable e) {
		//			e.printStackTrace();
		//		}
		return null;
	}

	/**
	 * 手机是否开启了开发者调试模式，如果获取不到，就返回false
	 *
	 * @return
	 */
	public static boolean isDeveloperDebugModelOpened(Context context) {
		try {
			if (Build.VERSION.SDK_INT < 17) {
				return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
			} else {
				return Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
