package com.example.batterychargehelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class BatteryReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		Log.wtf("zzz", "收到广播");
		// if (action.equals(Intent.ACTION_BATTERY_OKAY)) {
		// Log.wtf("zzz", "充满电了");
		// Dialog d = new Dialog(MainActivity.this);
		// d.setTitle("充满电了");
		// d.show();
		// }
		if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
			// 电池电量，数字
			int level = intent.getIntExtra("level", 0);
			Log.wtf("zzz", "电池电量 " + level);
			// 电池最大容量
			int scale = intent.getIntExtra("scale", 0);
			Log.wtf("zzz", "电池最大容量 " + scale);
			// 电池伏数
			int voltage = intent.getIntExtra("voltage", 0);
			Log.wtf("zzz", "电池伏数 " + voltage);

			String technology = intent.getStringExtra("technology");
			Log.wtf("zzz", "电池种类 " + technology);

			// 电池温度
			int temperature = intent.getIntExtra("temperature", 0);
			Log.wtf("zzz", "电池温度 " + temperature);

			// 电池状态，返回是一个数字
			// BatteryManager.BATTERY_STATUS_CHARGING=2 表示是充电状态
			// BatteryManager.BATTERY_STATUS_DISCHARGING=3 放电中
			// BatteryManager.BATTERY_STATUS_NOT_CHARGING=4 未充电
			// BatteryManager.BATTERY_STATUS_FULL=5 电池满
			// BatteryManager.BATTERY_STATUS_UNKNOWN=1
			int status = intent.getIntExtra("status", BatteryManager.BATTERY_STATUS_UNKNOWN);
			Log.wtf("zzz", "电池状态 " + status);

			// 充电类型 BatteryManager.BATTERY_PLUGGED_AC 表示是充电器，不是 这个值，表示是 USB
			// BATTERY_PLUGGED_AC=1
			// BATTERY_PLUGGED_USB=2
			// BATTERY_PLUGGED_WIRELESS=4
			int plugged = intent.getIntExtra("plugged", 0);
			Log.wtf("zzz", "充电类型 " + plugged);

			// 电池健康情况，返回也是一个数字
			// BatteryManager.BATTERY_HEALTH_GOOD=2 良好
			// BatteryManager.BATTERY_HEALTH_OVERHEAT=3 过热
			// BatteryManager.BATTERY_HEALTH_DEAD=4 没电
			// BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE=5 过电压
			// BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE=6 未知错误
			// BatteryManager.BATTERY_HEALTH_COLD=7
			// BatteryManager.BATTERY_HEALTH_UNKNOWN=1
			int health = intent.getIntExtra("health", BatteryManager.BATTERY_HEALTH_UNKNOWN);
			Log.wtf("zzz", "电池健康情况 " + health);

			// ((TextView) findViewById(R.id.level)).setText("剩余电量: " + level +
			// "/" + scale);
			// // ((TextView)findViewById(R.id.scale)).setText("满电量: "+scale);
			// ((TextView) findViewById(R.id.voltage)).setText("充电电压: " +
			// voltage + "mV");
			// ((TextView) findViewById(R.id.technology)).setText("电池种类: " +
			// toTechnology(technology));
			// String tem = Integer.toString(temperature);
			// String newTem = tem.substring(0, tem.length() - 1) + "." +
			// tem.substring(tem.length() - 1, tem.length());
			// ((TextView) findViewById(R.id.temperature)).setText("电池温度: " +
			// newTem + "℃");
			// ((TextView) findViewById(R.id.status)).setText("电池状态: " +
			// toStatus(status));
			// ((TextView) findViewById(R.id.plugged)).setText("充电类型: " +
			// toPlugged(plugged));
			// ((TextView) findViewById(R.id.health)).setText("健康情况: " +
			// toHealth(health));
		}
	}

	private String toTechnology(String technology) {
		if (technology.equalsIgnoreCase("Li-poly")) {
			return "锂聚合物";
		}
		if (technology.equalsIgnoreCase("Li-ion")) {
			return "锂离子";
		}
		return technology;
	}

	private String toStatus(int status) {
		switch (status) {
		case BatteryManager.BATTERY_STATUS_CHARGING:
			return "充电中";
		case BatteryManager.BATTERY_STATUS_DISCHARGING:
			return "放电中";
		case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
			return "未充电";
		case BatteryManager.BATTERY_STATUS_FULL:
			return "电池满";
		case BatteryManager.BATTERY_STATUS_UNKNOWN:
			return "未知";
		default:
			return "未知";
		}
	}

	private String toPlugged(int plugged) {
		switch (plugged) {
		case BatteryManager.BATTERY_PLUGGED_AC:
			return "直流充电";
		case BatteryManager.BATTERY_PLUGGED_USB:
			return "USB充电";
		case BatteryManager.BATTERY_PLUGGED_WIRELESS:
			return "无线充电";
		default:
			return "未知";
		}
	}

	private String toHealth(int health) {
		switch (health) {
		case BatteryManager.BATTERY_HEALTH_GOOD:
			return "好";
		case BatteryManager.BATTERY_HEALTH_OVERHEAT:
			return "过热";
		case BatteryManager.BATTERY_HEALTH_DEAD:
			return "没电";
		case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
			return "过电压";
		case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
			return "未知错误";
		case BatteryManager.BATTERY_HEALTH_COLD:
			return "过冷";
		case BatteryManager.BATTERY_HEALTH_UNKNOWN:
			return "未知";
		default:
			return "未知";
		}
	}
}
