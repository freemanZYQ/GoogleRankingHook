package com.vlocker.e;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.baidu.location.LocationClientOption;
import com.vlocker.b.j;
import com.vlocker.b.o;
import com.vlocker.beans.ThemeItemInfo;
import com.vlocker.i.b;
import com.vlocker.locker.R;
import com.vlocker.update.UpdateApkParamBean;
import com.vlocker.update.g;
import com.vlocker.update.i;
import java.io.File;
import java.io.IOException;

public class a implements b {
    public static boolean c = false;
    public NotificationManager a;
    int b = 0;
    public int d = 0;
    public Handler e = new b(this);
    int f = 0;
    private boolean g = false;
    private Context h;
    private Notification i;
    private UpdateApkParamBean j;
    private c k;
    private m l;

    public a(Context context, UpdateApkParamBean updateApkParamBean, int i) {
        this.h = context;
        this.a = (NotificationManager) context.getSystemService("notification");
        this.j = updateApkParamBean;
        this.d = i;
        a(updateApkParamBean.d());
    }

    private void a() {
        File file = new File(this.j.i() + this.j.h() + ".apk");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a(this.h, file);
    }

    private void a(int i, String str, String str2, String str3, int i2, Context context) {
        this.i = new Notification(i, str, System.currentTimeMillis());
        this.i.tickerText = str;
        this.i.contentView = new RemoteViews(this.h.getPackageName(), R.layout.market_update_content_view);
        this.i.contentView.setTextViewText(R.id.content_view_textupdate, "应用" + this.h.getResources().getString(R.string.vlocker_update_downloadapk_progress_downing));
        this.i.contentView.setImageViewResource(R.id.content_view_image, i);
        this.a.notify(i2, this.i);
    }

    private void a(Context context, File file) {
        if (!this.j.m()) {
            Toast.makeText(context, context.getString(R.string.vlocker_update_downloadapk_finish), 0).show();
            com.vlocker.update.a.a(context, file);
        }
    }

    private boolean a(File file) {
        String a;
        IOException e;
        String str = "";
        try {
            System.currentTimeMillis();
            a = g.a(file);
            try {
                System.currentTimeMillis();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                if (a.equals("")) {
                }
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            a = str;
            e = iOException;
            e.printStackTrace();
            if (a.equals("")) {
            }
        }
        return a.equals("") && a.equals(this.j.c());
    }

    private void b() {
        try {
            if (this.k != null) {
                this.h.unregisterReceiver(this.k);
                this.k = null;
            }
        } catch (Exception e) {
        }
    }

    public void a(long j, long j2, boolean z, ThemeItemInfo themeItemInfo) {
        int i = (int) ((100 * j) / j2);
        if (i > this.b + 2 || z) {
            this.b = i;
            if (z) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isFinish", z);
                bundle.putInt("DOWNLOAD", i);
                Message message = new Message();
                message.what = 1280;
                message.setData(bundle);
                this.e.sendMessage(message);
                Thread.yield();
            } else if (c) {
                this.i.contentView.setTextViewText(R.id.content_view_text1, i + "%");
                this.i.contentView.setProgressBar(R.id.content_view_progress, 100, i, false);
                this.a.notify(this.j.n(), this.i);
            } else {
                this.l.a();
                this.a.cancel(this.j.n());
                b();
            }
        }
    }

    protected void a(String str) {
        boolean z = true;
        if (j.b(this.h.getApplicationContext()) == o.noNetStatus) {
            if (!this.j.m()) {
                Toast.makeText(this.h, this.h.getString(R.string.t_market_vlocker_give_net_dip), 0).show();
            }
        } else if (!c || this.j.m()) {
            c = true;
            File file = new File(this.j.i());
            if (!file.exists()) {
                file.mkdirs();
            }
            String a = i.a(this.h);
            if (a.equals("") || !a.equals(this.j.c())) {
                z = false;
            }
            i.a(this.h, this.j.c());
            file = new File(this.j.i() + this.j.h() + ".apk");
            File file2 = new File(this.j.i() + this.j.h() + ".tmp");
            if (file2.exists()) {
                if (!z) {
                    file2.delete();
                }
                if (file.exists()) {
                    file.delete();
                }
            }
            if (file.exists()) {
                if (!z) {
                    file.delete();
                } else if (a(file)) {
                    a(this.h, file);
                    c = false;
                    return;
                }
            }
            this.f = 0;
            if (!this.j.m()) {
                Toast.makeText(this.h, this.h.getString(R.string.vlocker_update_downloadapk_startdip), 0).show();
            }
            a(this.j.j(), this.j.k(), this.j.l(), "0%", this.j.n(), this.h);
            this.k = new c();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.vlocker.service.stopupdate");
            this.h.registerReceiver(this.k, intentFilter);
            ThemeItemInfo themeItemInfo = new ThemeItemInfo();
            themeItemInfo.a(this.j.h());
            themeItemInfo.b("1");
            if (this.d == LocationClientOption.MIN_SCAN_SPAN) {
                this.l = new m(str, this, this.j.i() + this.j.h(), this.e, themeItemInfo, LocationClientOption.MIN_SCAN_SPAN);
            } else {
                this.l = new m(str, this, this.j.i() + this.j.h(), this.e, themeItemInfo);
            }
            this.l.start();
        } else {
            Toast.makeText(this.h, this.h.getString(R.string.t_market_update_downloading), 0).show();
        }
    }
}
