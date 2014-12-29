package com.example.batterychargehelper;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class BatteryService extends Service {

	/*
	 * First Call to onStart we don't want to do anything
	 */
	boolean avoidFirst = false;
	private BroadcastReceiver receiver;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		receiver = new BatteryReceiver();
		registerReceiver(receiver, filter);
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.d("Debug", "Battery Service On Start");
		int level = intent.getIntExtra("level", -1);

		if (avoidFirst) {
			if (level != -1) {
				Log.d("Debug", "Battery Alert Notifying..... " + level);
//				SMSManager.sendSMS(BatteryService.this, "<number redacted>", "Battery Level Aleart: " + level);
				stopSelf();
			}
		} else {
			avoidFirst = true;
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
//		PreferenceUtil.updatePreference(BatteryService.this, "battery_monitor_on", false);
		unregisterReceiver(receiver);
	}

}
