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
		Log.wtf("zzz", "�յ��㲥");
		// if (action.equals(Intent.ACTION_BATTERY_OKAY)) {
		// Log.wtf("zzz", "��������");
		// Dialog d = new Dialog(MainActivity.this);
		// d.setTitle("��������");
		// d.show();
		// }
		if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
			// ��ص���������
			int level = intent.getIntExtra("level", 0);
			Log.wtf("zzz", "��ص��� " + level);
			// ����������
			int scale = intent.getIntExtra("scale", 0);
			Log.wtf("zzz", "���������� " + scale);
			// ��ط���
			int voltage = intent.getIntExtra("voltage", 0);
			Log.wtf("zzz", "��ط��� " + voltage);

			String technology = intent.getStringExtra("technology");
			Log.wtf("zzz", "������� " + technology);

			// ����¶�
			int temperature = intent.getIntExtra("temperature", 0);
			Log.wtf("zzz", "����¶� " + temperature);

			// ���״̬��������һ������
			// BatteryManager.BATTERY_STATUS_CHARGING=2 ��ʾ�ǳ��״̬
			// BatteryManager.BATTERY_STATUS_DISCHARGING=3 �ŵ���
			// BatteryManager.BATTERY_STATUS_NOT_CHARGING=4 δ���
			// BatteryManager.BATTERY_STATUS_FULL=5 �����
			// BatteryManager.BATTERY_STATUS_UNKNOWN=1
			int status = intent.getIntExtra("status", BatteryManager.BATTERY_STATUS_UNKNOWN);
			Log.wtf("zzz", "���״̬ " + status);

			// ������� BatteryManager.BATTERY_PLUGGED_AC ��ʾ�ǳ���������� ���ֵ����ʾ�� USB
			// BATTERY_PLUGGED_AC=1
			// BATTERY_PLUGGED_USB=2
			// BATTERY_PLUGGED_WIRELESS=4
			int plugged = intent.getIntExtra("plugged", 0);
			Log.wtf("zzz", "������� " + plugged);

			// ��ؽ������������Ҳ��һ������
			// BatteryManager.BATTERY_HEALTH_GOOD=2 ����
			// BatteryManager.BATTERY_HEALTH_OVERHEAT=3 ����
			// BatteryManager.BATTERY_HEALTH_DEAD=4 û��
			// BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE=5 ����ѹ
			// BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE=6 δ֪����
			// BatteryManager.BATTERY_HEALTH_COLD=7
			// BatteryManager.BATTERY_HEALTH_UNKNOWN=1
			int health = intent.getIntExtra("health", BatteryManager.BATTERY_HEALTH_UNKNOWN);
			Log.wtf("zzz", "��ؽ������ " + health);

			// ((TextView) findViewById(R.id.level)).setText("ʣ�����: " + level +
			// "/" + scale);
			// // ((TextView)findViewById(R.id.scale)).setText("������: "+scale);
			// ((TextView) findViewById(R.id.voltage)).setText("����ѹ: " +
			// voltage + "mV");
			// ((TextView) findViewById(R.id.technology)).setText("�������: " +
			// toTechnology(technology));
			// String tem = Integer.toString(temperature);
			// String newTem = tem.substring(0, tem.length() - 1) + "." +
			// tem.substring(tem.length() - 1, tem.length());
			// ((TextView) findViewById(R.id.temperature)).setText("����¶�: " +
			// newTem + "��");
			// ((TextView) findViewById(R.id.status)).setText("���״̬: " +
			// toStatus(status));
			// ((TextView) findViewById(R.id.plugged)).setText("�������: " +
			// toPlugged(plugged));
			// ((TextView) findViewById(R.id.health)).setText("�������: " +
			// toHealth(health));
		}
	}

	private String toTechnology(String technology) {
		if (technology.equalsIgnoreCase("Li-poly")) {
			return "﮾ۺ���";
		}
		if (technology.equalsIgnoreCase("Li-ion")) {
			return "�����";
		}
		return technology;
	}

	private String toStatus(int status) {
		switch (status) {
		case BatteryManager.BATTERY_STATUS_CHARGING:
			return "�����";
		case BatteryManager.BATTERY_STATUS_DISCHARGING:
			return "�ŵ���";
		case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
			return "δ���";
		case BatteryManager.BATTERY_STATUS_FULL:
			return "�����";
		case BatteryManager.BATTERY_STATUS_UNKNOWN:
			return "δ֪";
		default:
			return "δ֪";
		}
	}

	private String toPlugged(int plugged) {
		switch (plugged) {
		case BatteryManager.BATTERY_PLUGGED_AC:
			return "ֱ�����";
		case BatteryManager.BATTERY_PLUGGED_USB:
			return "USB���";
		case BatteryManager.BATTERY_PLUGGED_WIRELESS:
			return "���߳��";
		default:
			return "δ֪";
		}
	}

	private String toHealth(int health) {
		switch (health) {
		case BatteryManager.BATTERY_HEALTH_GOOD:
			return "��";
		case BatteryManager.BATTERY_HEALTH_OVERHEAT:
			return "����";
		case BatteryManager.BATTERY_HEALTH_DEAD:
			return "û��";
		case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
			return "����ѹ";
		case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
			return "δ֪����";
		case BatteryManager.BATTERY_HEALTH_COLD:
			return "����";
		case BatteryManager.BATTERY_HEALTH_UNKNOWN:
			return "δ֪";
		default:
			return "δ֪";
		}
	}
}
