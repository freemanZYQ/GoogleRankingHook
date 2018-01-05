package com.vlocker.m;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.b;
import java.util.List;

public class r {
    private static r g;
    private Context a;
    private t b;
    private String[] c;
    private Handler d = new s(this);
    private v e;
    private u f;
    private ActivityManager h;

    private r(Context context) {
        this.a = context;
    }

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (g == null) {
                g = new r(MoSecurityApplication.a());
            }
            rVar = g;
        }
        return rVar;
    }

    private String[] a(ActivityManager activityManager) {
        String[] strArr = new String[2];
        try {
            List runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
                strArr[0] = componentName.getPackageName().toString().toLowerCase();
                strArr[1] = componentName.getClassName().toString().toLowerCase();
            }
        } catch (Exception e) {
        }
        return strArr;
    }

    private String[] c() {
        if (this.h == null) {
            this.h = (ActivityManager) this.a.getSystemService("activity");
        }
        if (b.q()) {
            return aj.a(this.h);
        }
        if (VERSION.SDK_INT < 20 || !bb.a(this.a)) {
            return a(this.h);
        }
        return new String[]{bb.b(this.a)};
    }

    private boolean d() {
        String[] c = c();
        if (c == null || this.c == null) {
            return false;
        }
        for (Object obj : c) {
            String[] strArr = this.c;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                CharSequence charSequence = strArr[i];
                if (TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(obj) || !obj.contains(charSequence)) {
                    i++;
                } else {
                    Message message = new Message();
                    message.what = 2;
                    message.obj = obj;
                    this.d.sendMessage(message);
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized void a(int i, t tVar) {
        this.b = tVar;
        this.e = new v();
        this.f = new u();
        this.a.registerReceiver(this.f, new IntentFilter("action_stop_check"));
        this.c = x.a(i, this.a);
        if (this.b != null) {
            this.b.b();
        }
        this.d.sendEmptyMessage(1);
    }

    public void b() {
        try {
            this.a.unregisterReceiver(this.f);
            this.e = null;
            this.b = null;
            this.f = null;
            this.c = null;
        } catch (Exception e) {
        }
        System.gc();
    }
}
