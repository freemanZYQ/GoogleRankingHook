package com.tools.hackandroid.gp;

import java.util.List;
import java.util.Vector;

public class FeatureInfoFactory
{
	private static List<String> list;
	
	public static List<String> getAllFeatureInfos(int sdk)
	{
		if(list != null && list.size() > 0)
		{
			return list;
		}
		
		list = new Vector<String>();
		
		list.add("android.hardware.audio.low_latency");
		list.add("android.hardware.bluetooth");
		list.add("android.hardware.camera");
		list.add("android.hardware.camera.autofocus");
		list.add("android.hardware.camera.flash");
		list.add("android.hardware.camera.front");
		list.add("android.hardware.faketouch");
		list.add("android.hardware.faketouch.multitouch.distinct");
		list.add("android.hardware.faketouch.multitouch.jazzhand");
		list.add("android.software.live_wallpaper");
		list.add("android.hardware.location");
		list.add("android.hardware.location.gps");
		list.add("android.hardware.location.network");
		list.add("android.hardware.microphone");
		list.add("android.hardware.nfc");
		list.add("android.hardware.screen.landscape");
		list.add("android.hardware.screen.portrait");
		list.add("android.hardware.sensor.accelerometer");
		list.add("android.hardware.sensor.barometer");
		list.add("android.hardware.sensor.compass");
		list.add("android.hardware.sensor.gyroscope");
		list.add("android.hardware.sensor.light");
		list.add("android.hardware.sensor.proximity");
		list.add("android.software.sip");
		list.add("android.software.sip.voip");
		list.add("android.hardware.telephony");
		list.add("android.hardware.telephony.cdma");
		list.add("android.hardware.telephony.gsm");
		list.add("android.hardware.touchscreen");
		list.add("android.hardware.touchscreen.multitouch");
		list.add("android.hardware.touchscreen.multitouch.distinct");
		list.add("android.hardware.touchscreen.multitouch.jazzhand");
		list.add("android.hardware.usb.accessory");
		list.add("android.hardware.usb.host");
		list.add("android.hardware.wifi");
		list.add("android.hardware.wifi.direct");
		
		if(sdk >= 16)
		{
			list.add("android.hardware.type.television");
		}
		if(sdk >= 17)
		{
			list.add("android.hardware.camera.any");
		}
		if(sdk >= 18)
		{
			list.add("android.software.app_widgets");
			list.add("android.hardware.bluetooth_le");
			list.add("android.software.home_screen");
			list.add("android.software.input_methods");
		}
		if(sdk >= 19)
		{
			list.add("android.hardware.consumerir");
			list.add("android.software.device_admin");
			list.add("android.hardware.nfc.hce");
			list.add("android.hardware.sensor.stepcounter");
			list.add("android.hardware.sensor.stepdetector");
		}
		if(sdk >= 20)
		{
			list.add("android.software.backup");
			list.add("android.hardware.camera.external");
			list.add("android.software.print");
			list.add("android.hardware.sensor.heartrate");
			list.add("android.hardware.type.watch");
			list.add("android.software.webview");
		}
		if(sdk >= 21)
		{
			list.add("android.hardware.audio.output");
			list.add("android.hardware.camera.capability.manual_post_processing");
			list.add("android.hardware.camera.capability.manual_sensor");
			list.add("android.hardware.camera.capability.raw");
			list.add("android.hardware.camera.level.full");
			list.add("android.software.connectionservice");
			list.add("android.hardware.gamepad");
			list.add("android.software.leanback");
			list.add("android.software.live_tv");
			list.add("android.software.managed_users");
			list.add("android.hardware.opengles.aep");
			list.add("android.software.securely_removes_users");
			list.add("android.hardware.sensor.ambient_temperature");
			list.add("android.hardware.sensor.heartrate.ecg");
			list.add("android.hardware.sensor.relative_humidity");
			list.add("android.software.verified_boot");
		}
		if(sdk >= 23)
		{
			list.add("android.hardware.audio.pro");
			list.add("android.hardware.type.automotive");
			list.add("android.hardware.fingerprint");
			list.add("android.hardware.sensor.hifi_sensors");
			list.add("android.software.midi");
		}
		
		list.add("android.software.connectionservice");
		list.add("android.software.voice_recognizers");
		list.add("android.software.managed_users");
		list.add("android.hardware.ethernet");
		list.add("android.hardware.hdmi.cec");
		
		list.add("com.nxp.mifare");
		list.add("com.sec.android.mdm");
		list.add("com.sec.feature.context_awareness");
		list.add("com.sec.feature.flashbar");
		list.add("com.sec.feature.minimode");
		list.add("com.sec.feature.minimode");
		list.add("com.sec.feature.multiwindow.phone");
		list.add("com.sec.feature.cover.flip");
		list.add("com.sec.feature.cover.sview");
		list.add("com.sec.feature.cover.sviewcover");
		list.add("com.sec.feature.findo");
		list.add("com.sec.feature.fingerprint_manager_service");
		list.add("com.sec.feature.healthcover");
		list.add("com.sec.feature.multiwindow");
		list.add("com.sec.feature.multiwindow.commonui");
		list.add("com.sec.feature.multiwindow.multiinstance");
		list.add("com.sec.feature.multiwindow.multiwindowlaunch");
		list.add("com.sec.feature.multiwindow.phone");
		list.add("com.sec.feature.samsunglinkplatform");
		list.add("com.sec.feature.secretmode_service");
		list.add("com.sec.feature.sensorhub");
		list.add("com.sec.feature.sidetouch");
		list.add("samsung.software.smartview");
		list.add("samsung.software.smartview.phone");
		list.add("samsung.software.smartview.trustzone");
		list.add("com.google.android.feature.GOOGLE_BUILD");
		list.add("com.google.android.feature.EXCHANGE_6_2");
		list.add("com.google.android.feature.GOOGLE_EXPERIENCE");
		
		return list;
	}
	

}
