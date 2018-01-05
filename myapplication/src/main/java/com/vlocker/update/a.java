package com.vlocker.update;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.bj;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.vlocker.b.i;
import com.vlocker.b.j;
import com.vlocker.b.o;
import com.vlocker.e.p;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.settings.SettingsActivity;
import com.vlocker.theme.f.e;
import com.vlocker.ui.view.ao;
import java.io.File;
import java.io.IOException;

public class a {
    Handler a = new c(this);
    private Context b;
    private UpdateApkParamBean c;
    private int d = 1;
    private f e = null;
    private ao f;
    private boolean g = false;

    public a(Context context, int i, boolean z) {
        this.b = context;
        this.d = i;
        if (z) {
            this.c = i.d(context);
        } else {
            this.c = new UpdateApkParamBean();
        }
        this.c.b(i);
    }

    public static void a(Context context, f fVar) {
        try {
            com.vlocker.c.a.a(context).aL(false);
            com.vlocker.c.a.a(context).aM(false);
            com.vlocker.c.a.a(context).r(0);
            if (j.b(context.getApplicationContext()) != o.noNetStatus) {
                SharedPreferences b = i.b(context);
                if (i.b()) {
                    if (i.b()) {
                        i.a(System.currentTimeMillis());
                        Editor edit = b.edit();
                        edit.putInt("send", 2);
                        edit.commit();
                    }
                    a aVar = new a(context, 1, false);
                    aVar.a(fVar);
                    aVar.a(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, File file) {
        Uri fromFile = Uri.fromFile(file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    private void a(String str) {
        if (str == null || str.equals("")) {
            b(false);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str);
            intent.setData(Uri.parse("market://details?id=com.vlocker.locker"));
            this.b.startActivity(intent);
        } catch (Exception e) {
            b(false);
        }
    }

    private void a(boolean z) {
        if (this.e != null) {
            this.e.a(z);
        }
    }

    private void b(boolean z) {
        this.c.b(z);
        this.c.f("vlocker_lock");
        this.c.g(i.g);
        this.c.e(100);
        this.c.i(this.b.getResources().getString(R.string.vlocker_lock_downloadapk_progress_title));
        this.c.h(this.b.getResources().getString(R.string.vlocker_lock_downloadapk_progress_title) + this.b.getResources().getString(R.string.vlocker_update_downloadapk_notificationtitle));
        this.c.d((int) R.drawable.main_icon);
        p.a(this.b).a(this.c);
    }

    public static void c() {
        NotificationManager notificationManager = (NotificationManager) MoSecurityApplication.a().getSystemService("notification");
        bj bjVar = new bj(MoSecurityApplication.a());
        Intent intent = new Intent(e.a, SettingsActivity.class);
        intent.putExtra("forceUpdateDialog", true);
        intent.setFlags(268435456);
        RemoteViews remoteViews = new RemoteViews(MoSecurityApplication.a().getPackageName(), R.layout.l_notification_type_update);
        bjVar.a(remoteViews).a(PendingIntent.getActivity(MoSecurityApplication.a(), 1, intent, 134217728)).a(System.currentTimeMillis()).b(0).a(false).a(MoSecurityApplication.a().getString(R.string.update_msg_title)).a((int) R.drawable.l_notification_small_icon);
        Notification a = bjVar.a();
        a.contentView = remoteViews;
        notificationManager.notify(108, a);
    }

    public static void d() {
        ((NotificationManager) MoSecurityApplication.a().getSystemService("notification")).cancel(108);
    }

    private void e() {
        if (this.d == 0) {
            Message message = new Message();
            message.what = 3;
            this.a.sendMessage(message);
        }
    }

    private boolean f() {
        File file = new File(i.g + "vlocker_lock" + ".apk");
        String str = "";
        try {
            str = g.a(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.equals(this.c.c());
    }

    private boolean g() {
        return j.b(this.b.getApplicationContext()) == o.wifiNetStatus;
    }

    public void a() {
        Thread bVar = new b(this);
        bVar.setDaemon(true);
        bVar.start();
    }

    public void a(int i) {
        o b = j.b(this.b.getApplicationContext());
        if (b == o.noNetStatus && i == 0) {
            Toast.makeText(this.b, this.b.getString(R.string.vlocker_setting_update_app_nonetdip), 2000).show();
        } else if (i == 0 || b == o.wifiNetStatus || b == o.threeGNetStatus || b == o.twoGNetStatus) {
            a();
        }
    }

    public void a(f fVar) {
        this.e = fVar;
    }

    public void b() {
        try {
            if (this.f != null) {
                if (this.f.isShowing()) {
                    this.f.dismiss();
                }
                this.f = null;
            }
            this.f = new ao(this.b, R.style.aiVlockerFeedbackDialog);
            this.f.a(R.layout.l_vlocker_dialog_tip_download_update, 0, 0);
            this.f.a.setText(R.string.update_tips);
            this.f.b.setText(this.c.q());
            this.f.c.setText(this.c.b());
            this.f.setCanceledOnTouchOutside(false);
            this.f.d.setOnClickListener(new d(this));
            this.f.f.setOnClickListener(new e(this));
        } catch (Exception e) {
            e.printStackTrace();
            if (this.f != null && this.f.isShowing()) {
                this.f.dismiss();
            }
        }
    }
}
