package com.tools.hackandroid.output;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/**
 * @author zhitao
 * @since 2016-04-18 11:36
 */
public class BatteryInfo {

	/**
	 * 获取当前电池相关信息，会自动组合成字符串
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String getCurrentBatteryInfoString(Context context) {
		Intent batteryIntent =
				context.getApplicationContext().registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
		if (batteryIntent == null) {
			return null;
		}

		// 当前电量
		int currLevel = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

		// 总电量
		int total = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

		// 电池充电状态
		int status = batteryIntent.getIntExtra(BatteryManager.EXTRA_STATUS, BatteryManager.BATTERY_STATUS_UNKNOWN);
		String statusStr = "未知电池充电状态";
		switch (status) {
		case BatteryManager.BATTERY_STATUS_CHARGING:
			statusStr = "充电状态";
			break;
		case BatteryManager.BATTERY_STATUS_DISCHARGING:
			statusStr = "放电状态";
			break;
		case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
			statusStr = "未充电";
			break;
		case BatteryManager.BATTERY_STATUS_FULL:
			statusStr = "充满电";
			break;
		case BatteryManager.BATTERY_STATUS_UNKNOWN:
			statusStr = "未知状态";
			break;
		}

		// 电池健康状态
		int health = batteryIntent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);
		String healthStr = "未知电池健康状态";
		switch (health) {
		case BatteryManager.BATTERY_HEALTH_COLD:
			healthStr = "电池冷却";
			break;
		case BatteryManager.BATTERY_HEALTH_DEAD:
			healthStr = "电池不可用";
			break;
		case BatteryManager.BATTERY_HEALTH_GOOD:
			healthStr = "电池状态良好";
			break;
		case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
			healthStr = "电池电压过高";
			break;
		case BatteryManager.BATTERY_HEALTH_OVERHEAT:
			healthStr = "电池过热";
			break;
		case BatteryManager.BATTERY_HEALTH_UNKNOWN:
			healthStr = "健康状态未知";
			break;
		case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
			healthStr = "未制定的失败";
			break;
		}

		// 电池图标
		int batteryIconResId = batteryIntent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL, -1);

		// 当前充电方式
		int plugged = batteryIntent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
		String pluggedStr = "未知插电方式";
		switch (plugged) {
		case BatteryManager.BATTERY_PLUGGED_AC:
			pluggedStr = "AC直流（充电器）";
			break;
		case BatteryManager.BATTERY_PLUGGED_USB:
			pluggedStr = "USB";
			break;
		case BatteryManager.BATTERY_PLUGGED_WIRELESS:
			pluggedStr = "无线";
			break;
		}

		// 当前使用状态
		boolean present = batteryIntent.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false);

		// 当前电池技术（e.g 锂电池 : Li-ion）
		String technology = batteryIntent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);

		// 当前电池温度
		int temperature_f = batteryIntent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);

		// 电池电压（单位：电伏）
		int voltage = batteryIntent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);

		StringBuilder sb = new StringBuilder(128);

		sb.append("\n\n## 电池信息\n");
		sb.append("\n总电量:").append(total);
		int temperature_c = Math.round((temperature_f - 32) / 1.8f);
		sb.append("\n当前电池温度:").append(temperature_f).append("°F  ").append(temperature_c).append("°C");
		sb.append("\n电池图标资源id:").append(batteryIconResId);
		sb.append("\n电池技术:").append(technology);

		sb.append("\n\n## 电池实时状态\n");
		sb.append("\n当前电量:").append(currLevel);
		sb.append("\n剩余电量百分比:").append(currLevel * 100 / total);
		sb.append("\n电池当前电压:").append(voltage);
		sb.append("\n电池充电状态:").append(statusStr);
		sb.append("\n电池健康状态:").append(healthStr);
		sb.append("\n电池插电方式:").append(pluggedStr);
		sb.append("\n是否拥有电池:").append(present).append(" (有些手机在使用USB电源的情况下，即使拔出了电池，仍然可以正常工作)");

		return sb.toString();
	}
	
}
