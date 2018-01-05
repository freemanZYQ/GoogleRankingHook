package com.vlocker.settings;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;

class bm implements OnClickListener {
    final /* synthetic */ NotificationSettingActivity a;

    bm(NotificationSettingActivity notificationSettingActivity) {
        this.a = notificationSettingActivity;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.notify_enable_layout:
                if (!this.a.b.aC()) {
                    this.a.b.L(true);
                }
                this.a.d();
                this.a.findViewById(R.id.notify_enable_hint).setVisibility(4);
                return;
            case R.id.notify_enable_private_layout:
                this.a.e();
                return;
            case R.id.notify_show_layout:
                this.a.c();
                return;
            case R.id.notify_app_select_layout:
                if (!this.a.b.bi()) {
                    this.a.b.U(true);
                }
                this.a.startActivity(new Intent(this.a, NotifyAppsSelectActivity.class));
                this.a.findViewById(R.id.notify_app_select_hint).setVisibility(4);
                return;
            case R.id.setting_redpacket_layout:
                this.a.b.ae(true);
                this.a.startActivity(new Intent(this.a, RedPacketActivity.class));
                return;
            default:
                return;
        }
    }
}
