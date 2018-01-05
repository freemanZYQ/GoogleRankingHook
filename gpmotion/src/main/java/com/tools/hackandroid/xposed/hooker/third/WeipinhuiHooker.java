package com.tools.hackandroid.xposed.hooker.third;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.tools.hackandroid.BuildConfig;
import com.tools.hackandroid.generator.third.WeipinhuiGenerator;
import com.tools.hackandroid.sp.TelephonyManagerSp;
import com.tools.hackandroid.sp.UnSpecifiedSp;
import com.tools.hackandroid.sp.third.WeipinhuiSp;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 唯品会特殊处理的hooker
 */
public class WeipinhuiHooker extends AbsHooker<WeipinhuiSp> {

	private Class PlatformApiClass;

	private Class ApiClass;

	// -----------------------------------------------------------------------------------------------------------------------
	// 5.23.8
	private Class DevDataClass;

	private Class UserResultClass;

	private Class RestResultClass;

	private Class UrlFactoryClass;

	/**
	 * 返回这个Hook所用的SharePreferencesde的管理类
	 *
	 * @return
	 */
	@Override
	protected WeipinhuiSp initSp() {
		return new WeipinhuiSp();
	}

	/**
	 * 实现需要hook的各种方法，静态变量等等的钩子
	 *
	 * @param lpparam Information about the hook app.
	 */
	@Override
	protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {

		// -----------------------------------------------------------------------------------------------------------------------
		// 5.22.8
		// 替换mid
		//		findAndHookMethod("com.vipshop.sdk.util.SdkConfig", lpparam.classLoader, "getMid", this);
		//		// 登陆接口，但是xposed不能hook到方法的内部变量，所以还需要更低一层的hook
		//		findAndHookMethod("com.vipshop.sdk.middleware.service.UserService", lpparam.classLoader, "oauthLogin", String
		// .class,
		//				String.class, String.class, String.class, this);
		//
		//		// 登陆接口的post
		//		try {
		//			UserResultClass = lpparam.classLoader.loadClass("com.vipshop.sdk.middleware.model.UserResult");
		//			PlatformApiClass = lpparam.classLoader.loadClass("com.vipshop.sdk.rest.PlatformApi");
		//			ApiClass = lpparam.classLoader.loadClass("com.vipshop.sdk.rest.Api");
		//
		//			findAndHookMethod("com.vipshop.sdk.rest.VipshopService", lpparam.classLoader, "postHttpsRestResult", Context
		// .class,
		//					PlatformApiClass, Class.class, this);
		//		} catch (ClassNotFoundException e) {
		//			DLog.e(e);
		//		}
		//
		//		// 因为找不到provider存放的内容究竟存放在哪个文件，所以只能直接hook住从provider中获取出来的数据
		//
		//		//com.achievo.vipshop.util.bb.c(context, "VIPS_MID")
		//		//public static String c(Context context, String str) {
		//
		//		findAndHookMethod("com.achievo.vipshop.util.bb", lpparam.classLoader, "c", Context.class, String.class, this);

		// -----------------------------------------------------------------------------------------------------------------------
		// 5.23.8
		try {
			DevDataClass = lpparam.classLoader.loadClass("com.achievo.vipshop.presenter.SessionPresenter$DevData");
			PlatformApiClass = lpparam.classLoader.loadClass("com.vipshop.sdk.rest.PlatformApi");
			ApiClass = lpparam.classLoader.loadClass("com.vipshop.sdk.rest.Api");
			UserResultClass = lpparam.classLoader.loadClass("com.vipshop.sdk.middleware.model.UserResult");
			RestResultClass = lpparam.classLoader.loadClass("com.vipshop.sdk.rest.RestResult");
			UrlFactoryClass = lpparam.classLoader.loadClass("com.vipshop.sdk.middleware.UrlFactory");
		} catch (ClassNotFoundException e) {
			DLog.e(e);
		}

		findAndHookMethod("com.achievo.vipshop.presenter.SessionPresenter", lpparam.classLoader, "g", this);

		// 篡改mid
		// 有几个地方，不管了，全hook
		findAndHookMethod("com.achievo.vipshop.util.cb", lpparam.classLoader, "c", Context.class, this);
		findAndHookMethod("com.achievo.vipshop.util.bh", lpparam.classLoader, "c", Context.class, String.class, this);
		findAndHookMethod("com.vipshop.sdk.d.a", lpparam.classLoader, "a", Context.class, this);

		// 篡改standby_id
		findAndHookMethod("com.vipshop.sdk.util.t", lpparam.classLoader, "s", String.class, this);

		// 篡改rom
		findAndHookMethod(System.class, "getProperty", String.class, String.class, this);
		findAndHookMethod(System.class, "getProperty", String.class, this);

		// 篡改create_session
		// 最后调用的是这个请求方法
		findAndHookMethod("com.vipshop.sdk.rest.VipshopService", lpparam.classLoader, "postRestResult", Context.class,
				PlatformApiClass, Class.class, this);
		// hook 注册并绑定手机接口 v1
		findAndHookMethod("com.vipshop.sdk.rest.VipshopService", lpparam.classLoader, "postHttpsRestResult", Context.class,
				PlatformApiClass, Class.class, this);

		// hook 注册并绑定手机接口 v2
		findAndHookMethod("com.vipshop.sdk.middleware.ApiRequest", lpparam.classLoader, "postHttpResponseType", Context.class,
				UrlFactoryClass, Type.class, this);

		// ---------------
		// hook rest 接口
		// hook 注册并绑定手机接口 v2
		findAndHookMethod("com.vipshop.sdk.middleware.service.UserService", lpparam.classLoader, "regBindPhone", String.class,
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, this);
		findAndHookMethod("com.vipshop.sdk.middleware.service.UserService", lpparam.classLoader, "regBindPhoneV2", String.class,
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, this);

	}

	@Override
	protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
		switch (param.method.getDeclaringClass().getName()) {
		case "com.vipshop.sdk.util.t":
			switch (param.method.getName()) {
			case "s":
				DLog.i("======\n%s.%s", param.method.getDeclaringClass().getName(), param.method.getName());
				DLog.i("篡改standby_id/mobile_channel");
				DLog.i("原始的，standby_id : %s", param.args[0]);
				DLog.i("篡改后，standby_id : %s", param.args[0]);
				break;
			}
			break;
		}
	}

	@Override
	protected void afterHookedMethod(MethodHookParam param) throws Throwable {

		// -----------------------------------------------------------------------------------------------------------------------
		// 5.22.8
		//		switch (param.method.getName()) {
		//		case "getMid":
		//			DLog.i("======\n注入之前的mid: %s", param.getResult().toString());
		//			setStringResult(param, WeipinhuiSp.MID);
		//			DLog.i("注入之后的mid: %s", param.getResult().toString());
		//			break;
		//		case "oauthLogin":
		//			DLog.i("======\n解析oauthLogin登陆参数");
		//			if (param.args != null && param.args.length > 0) {
		//				DLog.i("用户相关信息");
		//				for (int i = 0; i < param.args.length; i++) {
		//					DLog.i("param %d: %s", i, param.args[i]);
		//				}
		//			}
		//			break;
		//		case "postHttpsRestResult":
		//			DLog.i("======\n解析 postHttpsRestResult 输入参数");
		//			if (param.args != null && param.args.length > 0) {
		//				Method getParamsMethod = ApiClass.getDeclaredMethod("getParams");
		//				getParamsMethod.setAccessible(true);
		//				Object obj = getParamsMethod.invoke(param.args[1]);
		//				if (obj == null) {
		//					DLog.i("null");
		//				} else {
		//					TreeMap<String, String> map = (TreeMap<String, String>) obj;
		//					for (Map.Entry<String, String> entry : map.entrySet()) {
		//						DLog.i("%s : %s", entry.getKey(), entry.getValue());
		//					}
		//				}
		//			}
		//			break;
		//		case "c":
		//			if (param.method.getDeclaringClass().getName().equals("com.achievo.vipshop.util.bb")) {
		//				DLog.i("++ provider中存在 %s : %s", param.args[1].toString(), param.getResult().toString());
		//				if (param.args != null && param.args.length > 0) {
		//					if ("VIPS_MID".equals(param.args[1].toString())) {
		//						DLog.i("===0===");
		//						DLog.i("篡改VIPS_MID/mars_cid");
		//						DLog.i("原始的，VIPS_MID : %s", param.getResult().toString());
		//						setStringResult(param, WeipinhuiSp.MID);
		//						DLog.i("篡改后，VIPs_MID : %s", param.getResult().toString());
		//					}
		//				}
		//			}
		//			break;
		//		}

		// -----------------------------------------------------------------------------------------------------------------------
		// 5.23.8

		switch (param.method.getDeclaringClass().getName()) {
		case "com.achievo.vipshop.util.bh":
			switch (param.method.getName()) {
			case "c":
				if (param.args != null && param.args.length > 0) {
					if ("VIPS_MID".equals(param.args[1].toString())) {
						DLog.i("======\n%s.%s", param.method.getDeclaringClass().getName(), param.method.getName());
						DLog.i("篡改VIPS_MID/mars_cid");
						DLog.i("原始的，VIPS_MID : %s", param.getResult().toString());
						XSharedPreferences xsp1 = new XSharedPreferences(BuildConfig.APPLICATION_ID, "unSpecified");
						xsp1.makeWorldReadable();
						String androidId = xsp1.getString(UnSpecifiedSp.ANDROID_ID, null);

						XSharedPreferences xsp2 =
								new XSharedPreferences(BuildConfig.APPLICATION_ID, TelephonyManager.class.getName());
						xsp2.makeWorldReadable();
						String imei = xsp2.getString(TelephonyManagerSp.IMEI, null);

						param.setResult(WeipinhuiGenerator.newMid(androidId, imei));
						DLog.i("篡改后，VIPs_MID : %s", param.getResult().toString());
					}
				}
				break;
			}
			break;
		case "com.achievo.vipshop.util.cb":
			switch (param.method.getName()) {
			case "c":
				DLog.i("======\n%s.%s", param.method.getDeclaringClass().getName(), param.method.getName());

				DLog.i("篡改VIPS_MID/mars_cid");
				DLog.i("原始的，VIPS_MID : %s", param.getResult().toString());

				XSharedPreferences xsp1 = new XSharedPreferences(BuildConfig.APPLICATION_ID, "unSpecified");
				xsp1.makeWorldReadable();
				String androidId = xsp1.getString(UnSpecifiedSp.ANDROID_ID, null);

				XSharedPreferences xsp2 = new XSharedPreferences(BuildConfig.APPLICATION_ID, TelephonyManager.class.getName());
				xsp2.makeWorldReadable();
				String imei = xsp2.getString(TelephonyManagerSp.IMEI, null);

				param.setResult(WeipinhuiGenerator.newMid(androidId, imei));

				DLog.i("篡改后，VIPs_MID : %s", param.getResult().toString());
				break;
			}
			break;
		case "com.achievo.vipshop.presenter.SessionPresenter":
			switch (param.method.getName()) {
			case "g":
				DLog.i("======\n%s.%s", param.method.getDeclaringClass().getName(), param.method.getName());

				DLog.i("方法对应的原始结果\n");
				Object instance = param.getResult();
				logDevData(instance);

				Field longitudeField = DevDataClass.getField("longitude");
				longitudeField.setAccessible(true);
				longitudeField.set(instance, "");

				Field latitudeField = DevDataClass.getField("latitude");
				latitudeField.setAccessible(true);
				latitudeField.set(instance, "");

				DLog.i("方法对应的修改结果\n");
				logDevData(instance);
				break;
			}
			break;
		case "com.vipshop.sdk.d.a":
			switch (param.method.getName()) {
			case "a":
				DLog.i("======\n%s.%s", param.method.getDeclaringClass().getName(), param.method.getName());

				DLog.i("篡改VIPS_MID/mars_cid");
				DLog.i("原始的，VIPS_MID : %s", param.getResult().toString());

				XSharedPreferences xsp1 = new XSharedPreferences(BuildConfig.APPLICATION_ID, "unSpecified");
				xsp1.makeWorldReadable();
				String androidId = xsp1.getString(UnSpecifiedSp.ANDROID_ID, null);

				XSharedPreferences xsp2 = new XSharedPreferences(BuildConfig.APPLICATION_ID, TelephonyManager.class.getName());
				xsp2.makeWorldReadable();
				String imei = xsp2.getString(TelephonyManagerSp.IMEI, null);

				param.setResult(WeipinhuiGenerator.newMid(androidId, imei));
				DLog.i("篡改后，VIPs_MID : %s", param.getResult().toString());
				break;
			}
			break;

		case "com.vipshop.sdk.middleware.service.UserService":
			DLog.i("======\n%s.%s", param.method.getDeclaringClass().getName(), param.method.getName());

			switch (param.method.getName()) {
			case "regBindPhone":
				DLog.i("调用注册接口v1 : regBindPhone");
				break;
			case "regBindPhoneV2":
				DLog.i("调用注册接口v2 : regBindPhoneV2");
			}
			break;
		case "com.vipshop.sdk.rest.VipshopService":
			DLog.i("======\n%s.%s", param.method.getDeclaringClass().getName(), param.method.getName());

			switch (param.method.getName()) {
			case "postRestResult":
				if (param.args != null && param.args.length == 3) {
					Object platformApiObj = param.args[1];
					Class resultClassObj = (Class) param.args[2];

					DLog.i("result class : %s", resultClassObj.getName());
					DLog.i("params : ");

					Method getParamsMethod = ApiClass.getDeclaredMethod("getParams");
					getParamsMethod.setAccessible(true);
					Object obj = getParamsMethod.invoke(platformApiObj);
					if (obj == null) {
						DLog.i("  null");
					} else {
						TreeMap<String, String> map = (TreeMap<String, String>) obj;
						for (Map.Entry<String, String> entry : map.entrySet()) {
							DLog.i("  %s : %s", entry.getKey(), entry.getValue());
						}
					}
				}
				break;
			case "postHttpsRestResult":
				if (param.args != null && param.args.length == 3) {
					Object platformApiObj = param.args[1];
					Class resultClassObj = (Class) param.args[2];

					if (resultClassObj.getName().equals(UserResultClass.getName())) {

						DLog.i("result class : \n  %s", resultClassObj.getName());
						DLog.i("params : ");

						Method getParamsMethod = ApiClass.getDeclaredMethod("getParams");
						getParamsMethod.setAccessible(true);
						Object obj = getParamsMethod.invoke(platformApiObj);
						if (obj == null) {
							DLog.i("  null");
						} else {
							TreeMap<String, String> map = (TreeMap<String, String>) obj;
							for (Map.Entry<String, String> entry : map.entrySet()) {
								DLog.i("  %s : %s", entry.getKey(), entry.getValue());
							}
						}
						DLog.i("result : ");
						Object result = param.getResult();

						// String bizcode
						// int code
						// String msg
						DLog.i("  bizcode : " + RestResultClass.getDeclaredField("data").get(result));
						DLog.i("  code : " + RestResultClass.getDeclaredField("code").get(result));
						DLog.i("  msg : " + RestResultClass.getDeclaredField("msg").get(result));

						// T data
						DLog.i("  T : ");
						Field dataField = RestResultClass.getDeclaredField("data");
						Object tObj = dataField.get(result);
						if (tObj != null) {
							Field[] fields = UserResultClass.getDeclaredFields();
							for (Field field : fields) {
								field.setAccessible(true);
								DLog.i("    " + field.getName() + " : " + field.get(tObj));
							}
						}
					}
				}
				break;
			}
			break;

		case "com.vipshop.sdk.middleware.ApiRequest":
			DLog.i("======\n%s.%s", param.method.getDeclaringClass().getName(), param.method.getName());
			switch (param.method.getName()) {
			case "postHttpResponseType":
				if (param.args != null && param.args.length == 3) {
					Object urlFactoryObj = param.args[1];
					Type typeClass = (Type) param.args[2];

					Field field = UrlFactoryClass.getDeclaredField("mService");
					field.setAccessible(true);
					String serviceName = field.get(urlFactoryObj).toString();
					DLog.i("ApiRequest.postHttpResponseType : %s", serviceName);
					switch (serviceName) {
					case "/user/registerAndBindMobile/v2":
						DLog.i("调用v2注册绑定手机接口，请求参数");
						Method getParamMethod = UrlFactoryClass.getDeclaredMethod("getParams");
						getParamMethod.setAccessible(true);
						TreeMap<String, String> map = (TreeMap<String, String>) getParamMethod.invoke(urlFactoryObj);
						for (Map.Entry<String, String> entry : map.entrySet()) {
							DLog.i("  %s : %s", entry.getKey(), entry.getValue());
						}
						break;
					}

				}
				break;
			}
			break;
		case "java.lang.System":
			switch (param.method.getName()) {
			case "getProperty":
				if (param.args != null || param.args.length > 0) {
					if ("http.agent".equals(param.args[0])) {
						// Dalvik%2F1.6.0+%28Linux%3B+U%3B+Android+4.4.4%3B+Nexus+4+Build%2FKTU84P%29
						// Dalvik/1.6.0 (Linux; U; Android 4.4.4; Nexus 4 Build/KTU84P)
						// 版本号,机型,build id
						DLog.i("======\n%s.%s", param.method.getDeclaringClass().getName(), param.method.getName());

						DLog.i("src http.agent : %s", param.getResult().toString());
						param.setResult(String.format("Dalvik/1.6.0 (Linux; U; Android %s %s Build/%s)", Build.VERSION.RELEASE,
								Build.MODEL, Build.ID));
						DLog.i("new http.agent : %s", param.getResult().toString());

					}
				}
				break;
			}
			break;

		}

	}

	private void logDevData(Object instance) {
		HashMap<String, Class> map = new HashMap<>();
		map.put("app_channel", String.class);
		map.put("app_name", String.class);
		map.put("app_version", String.class);
		map.put("cc_id", String.class);
		map.put("factory", String.class);
		map.put("iccid", String.class);
		map.put("imsi", String.class);
		map.put("latitude", String.class);
		map.put("login_name", String.class);
		map.put("longitude", String.class);
		map.put("mid", String.class);
		map.put("model", String.class);
		map.put("network", String.class);
		map.put("os", String.class);
		map.put("os_version", int.class);
		map.put("pp_id", String.class);
		map.put("province", String.class);
		map.put("resolution", String.class);
		map.put("service_provider", String.class);
		map.put("user_id", String.class);
		map.put("warehouse", String.class);
		for (Map.Entry<String, Class> entry : map.entrySet()) {
			try {
				Field field = DevDataClass.getField(entry.getKey());
				Object obj = field.get(instance);
				DLog.i("  " + entry.getKey() + " : " + obj);
			} catch (Exception e) {
				DLog.e(e);
			}
		}
	}
}

//class DevData {
//	public String app_channel;
//	public String app_name;
//	public String app_version;
//  3des 加密的imei
//	public String cc_id;

//  Build.MANUFACTURER
//	public String factory;
//	public String iccid;
//	public String imsi;
//	public String latitude;
//	public String login_name;
//	public String longitude;

//  一个随机生成的uuid
//	public String mid;
//	public String model;
//	public String network;
//	public String os;
//	public int os_version;
//  同样是3des加密的androidid
//	public String pp_id;
//	public String province;
//	public String resolution;
//	public String service_provider;
//	public String user_id;
//	public String warehouse;
//
//	private DevData() {
//	}
//}

//	private DevData g() {
//		DevData devData = new DevData();
//		TelephonyManager telephonyManager = (TelephonyManager) this.d.getSystemService("phone");
//		devData.mid = t.a().j();
//		devData.app_name = t.a().b();
//		devData.app_version = t.a().d();
//		devData.app_channel = t.a().c();
//		devData.os = "Android";
//		devData.os_version = VERSION.SDK_INT;
//		devData.model = Build.MODEL;
//		devData.resolution = BaseApplication.f + "*" + BaseApplication.g;
//		devData.user_id = t.a().f();
//		devData.login_name = c();
//		devData.longitude = (String) p.a(this.d, "log_longitude", String.class);
//		devData.latitude = (String) p.a(this.d, "log_latitude", String.class);
//		devData.province = (String) p.a(this.d, "log_province", String.class);
//		devData.warehouse = t.a().h();
//		devData.service_provider = a(telephonyManager);
//		devData.network = f();
//		devData.imsi = telephonyManager.getSubscriberId();
//		String deviceId = telephonyManager.getDeviceId();
//		if (TextUtils.isEmpty(deviceId)) {
//			deviceId = "000000000000000";
//		}
//		devData.cc_id = Des3Helper.des3EncodeECB(deviceId, 0);
//		devData.pp_id = Des3Helper.des3EncodeECB(Secure.getString(this.d.getContentResolver(), "android_id"), 0);
//		devData.iccid = telephonyManager.getSimSerialNumber();
//		devData.factory = Build.MANUFACTURER;
//		return devData;
//	}

//      07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   os : Android
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   model : Nexus 4
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   service_provider :
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   iccid : null
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   app_version : 5.23.8
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   app_channel : 有米广点通02
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   resolution : 768*1184
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   warehouse : VIP_NH
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   app_name : shop_android
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   network : wifi
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   os_version : 19
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   cc_id : 4l7Irnt+pLjeIgse493gRg==
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   login_name : 15920336729
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   province : null
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   user_id :
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   pp_id : xMI4uaJ+HRABzsae0hv+QlC5D/gSRbxB
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   longitude : 113.414887
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   factory : LGE
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   mid : 6bfc9091-d786-3be6-8183-5cce401c2f3f
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   latitude : 23.064271
//		07-27 17:48:22.140 1495-4803/com.achievo.vipshop I/hack:   imsi : null