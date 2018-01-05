package com.vlocker.setting.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.vlocker.setting.a.a;

public class PackageReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            String dataString = intent.getDataString();
            dataString = dataString.substring(dataString.indexOf(":") + 1, dataString.length());
            SharedPreferences sharedPreferences = context.getSharedPreferences(a.SHARED_KEY_TASK_STATUS, 0);
            if (sharedPreferences.getBoolean(dataString, false)) {
                Editor edit = sharedPreferences.edit();
                edit.putBoolean(dataString, false);
                edit.commit();
            }
        }
    }
}
