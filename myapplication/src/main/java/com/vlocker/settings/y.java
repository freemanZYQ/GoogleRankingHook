package com.vlocker.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vlocker.share.ShareUtil;

class y extends BroadcastReceiver {
    final /* synthetic */ DismissActivity a;

    y(DismissActivity dismissActivity) {
        this.a = dismissActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.vlocker.action_hidedismissact".equals(intent.getAction())) {
            this.a.finish();
        } else if ("com.vlocker.action_sharetheme".equals(intent.getAction())) {
            ShareUtil.getInstance().shareTheme(this.a);
        }
    }
}
