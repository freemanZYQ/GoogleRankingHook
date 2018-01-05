package com.vlocker.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;
import com.vlocker.b.i;
import com.vlocker.b.j;
import com.vlocker.b.o;
import com.vlocker.locker.R;
import com.vlocker.ui.view.ao;
import com.vlocker.update.UpdateApkParamBean;

public class e {
    private static boolean e = false;
    Handler a = new h(this);
    private Context b;
    private UpdateApkParamBean c;
    private ao d;

    public e(Context context) {
        this.b = context;
        this.c = new UpdateApkParamBean();
    }

    private void a(boolean z) {
        this.c.b(z);
        this.c.f("vlocker_launcher");
        this.c.g(i.g);
        this.c.e(101);
        this.c.i(this.b.getResources().getString(R.string.vlocker_domestic_launcher_name));
        this.c.h(this.b.getResources().getString(R.string.vlocker_domestic_launcher_name) + this.b.getResources().getString(R.string.vlocker_update_downloadapk_notificationtitle));
        this.c.d((int) R.drawable.t_market_domestic_launcher_download_notification_logo);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        intent.setAction("com.vlocker.locker.update.receiver");
        bundle.putInt("fromtag", 3);
        bundle.putParcelable("updatebean", this.c);
        intent.putExtras(bundle);
        this.b.sendBroadcast(intent);
    }

    private void a(boolean z, UpdateApkParamBean updateApkParamBean) {
        this.c.b(z);
        this.c.f(updateApkParamBean.h());
        this.c.g(i.g);
        this.c.e(102);
        this.c.i(updateApkParamBean.l());
        this.c.h(updateApkParamBean.l() + this.b.getResources().getString(R.string.vlocker_update_downloadapk_notificationtitle));
        this.c.d((int) R.drawable.t_market_domestic_launcher_download_notification_logo);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        intent.setAction("com.vlocker.locker.update.receiver");
        bundle.putInt("fromtag", 1);
        bundle.putParcelable("updatebean", updateApkParamBean);
        intent.putExtras(bundle);
        this.b.sendBroadcast(intent);
    }

    public void a() {
        if (o.noNetStatus == j.b(this.b.getApplicationContext())) {
            Toast.makeText(this.b, this.b.getString(R.string.vlocker_setting_update_app_nonetdip), 2000).show();
            return;
        }
        b();
        if (!"guanwang".equals("guanwang")) {
        }
    }

    public void a(UpdateApkParamBean updateApkParamBean) {
        if (o.noNetStatus == j.b(this.b.getApplicationContext())) {
            Toast.makeText(this.b, this.b.getString(R.string.vlocker_setting_update_app_nonetdip), 2000).show();
            return;
        }
        if (!updateApkParamBean.m()) {
            Toast.makeText(this.b, this.b.getString(R.string.vlocker_update_downloadapk_startdip), 2000).show();
        }
        a(false, updateApkParamBean);
    }

    public void a(String str) {
        Thread gVar = new g(this, str);
        gVar.setDaemon(true);
        gVar.start();
    }

    public void b() {
        boolean z = false;
        try {
            if (this.d != null) {
                if (this.d.isShowing()) {
                    this.d.dismiss();
                }
                this.d = null;
            }
            this.d = new ao(this.b, R.style.aiVlockerFeedbackDialog);
            this.d.a(R.layout.l_guide_download_mx_domest_launcher, 0, 0);
            if (e) {
                this.d.a.setText(R.string.vlocker_domestic_launcher_name);
                this.d.c.setText(R.string.l_download_domestic_mx_des_txt);
            } else {
                this.d.a.setText(R.string.vlocker_domestic_launcher_name_2);
                this.d.c.setText(R.string.l_download_domestic_mx_des_txt_2);
            }
            if (!e) {
                z = true;
            }
            e = z;
            this.d.d.setText(R.string.l_download_domestic_mx_sure_btn_txt);
            ((ImageView) this.d.findViewById(R.id.dialog_title_iv)).setBackgroundResource(R.drawable.t_market_domestic_launcher_download_logo);
            this.d.d.setOnClickListener(new f(this));
        } catch (Exception e) {
            if (this.d != null && this.d.isShowing()) {
                this.d.dismiss();
            }
        }
    }
}
