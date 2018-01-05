package com.vlocker.e;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.vlocker.b.j;
import com.vlocker.b.o;
import com.vlocker.beans.ThemeItemInfo;
import com.vlocker.i.b;
import com.vlocker.locker.R;
import com.vlocker.update.UpdateApkParamBean;
import com.vlocker.update.a;
import com.vlocker.update.g;
import com.vlocker.update.i;
import java.io.File;
import java.io.IOException;

public class p implements b {
    public static boolean c = false;
    private static p h;
    public NotificationManager a;
    int b = 0;
    public Handler d = new q(this);
    private Context e;
    private Notification f;
    private UpdateApkParamBean g;
    private m i;
    private boolean j;

    public p(Context context) {
        this.e = context;
        this.a = (NotificationManager) context.getSystemService("notification");
    }

    public static p a(Context context) {
        if (h == null) {
            h = new p(context);
        }
        return h;
    }

    private void a() {
        File file = new File(this.g.i() + this.g.h() + ".apk");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (a(file)) {
            a(this.e, file);
        } else {
            file.delete();
        }
    }

    private void a(int i, String str, int i2) {
        this.f = new Notification(i, str, System.currentTimeMillis());
        this.f.tickerText = str;
        this.f.contentView = new RemoteViews(this.e.getPackageName(), R.layout.market_update_content_view);
        this.f.contentView.setTextViewText(R.id.content_view_textupdate, this.g.l() + this.e.getResources().getString(R.string.vlocker_update_downloadapk_progress_downing));
        this.f.contentView.setImageViewResource(R.id.content_view_image, i);
        this.a.notify(i2, this.f);
    }

    private void a(Context context, File file) {
        if (!this.g.m() || this.j) {
            a.a(context, file);
        }
        this.j = false;
    }

    private boolean a(File file) {
        String str = "";
        try {
            str = g.a(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return !str.equals("") && str.equals(this.g.c());
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
                this.d.sendMessage(message);
                Thread.yield();
            } else if (!c) {
                this.i.a();
                this.a.cancel(this.g.n());
            } else if (!this.g.m()) {
                this.f.contentView.setTextViewText(R.id.content_view_text1, i + "%");
                this.f.contentView.setProgressBar(R.id.content_view_progress, 100, i, false);
                this.a.notify(this.g.n(), this.f);
            }
        }
    }

    public void a(UpdateApkParamBean updateApkParamBean) {
        boolean z = true;
        if (j.b(this.e.getApplicationContext()) == o.noNetStatus) {
            Toast.makeText(this.e, this.e.getString(R.string.t_market_vlocker_give_net_dip), 0).show();
        } else if (c) {
            this.j = true;
            Toast.makeText(this.e, this.e.getString(R.string.app_name) + this.e.getString(R.string.t_market_update_downloading), 0).show();
        } else {
            this.g = updateApkParamBean;
            String d = updateApkParamBean.d();
            c = true;
            File file = new File(updateApkParamBean.i());
            if (!file.exists()) {
                file.mkdirs();
            }
            String string = i.b(this.e).getString("apk_md5", "");
            if (string.equals("") || !string.equals(updateApkParamBean.c())) {
                z = false;
            }
            file = new File(updateApkParamBean.i() + updateApkParamBean.h() + ".apk");
            File file2 = new File(updateApkParamBean.i() + updateApkParamBean.h() + ".tmp");
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
                    a(this.e, file);
                    c = false;
                    return;
                }
            }
            this.b = 0;
            if (!updateApkParamBean.m()) {
                Toast.makeText(this.e, this.e.getString(R.string.vlocker_update_downloadapk_startdip), 0).show();
                a(updateApkParamBean.j(), updateApkParamBean.k(), updateApkParamBean.n());
            }
            ThemeItemInfo themeItemInfo = new ThemeItemInfo();
            themeItemInfo.a(updateApkParamBean.h());
            themeItemInfo.b("1");
            this.i = new m(d, this, updateApkParamBean.i() + updateApkParamBean.h(), this.d, themeItemInfo);
            this.i.start();
            i.c(this.e).putString("apk_md5", updateApkParamBean.c()).commit();
        }
    }
}
