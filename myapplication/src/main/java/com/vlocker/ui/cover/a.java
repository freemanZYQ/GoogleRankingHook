package com.vlocker.ui.cover;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.location.LocationClientOption;
import com.vlocker.m.aj;
import com.vlocker.m.bb;
import com.vlocker.theme.f.b;
import java.util.List;

public class a {
    Context a;
    private ap b;
    private ActivityManager c = null;
    private boolean d = false;
    private Handler e = new Handler();
    private boolean f = false;
    private boolean g = false;
    private Runnable h = new b(this);
    private boolean i = false;
    private long j;
    private BroadcastReceiver k = new e(this);

    public a(Context context) {
        this.a = context;
    }

    private void d() {
        this.c = (ActivityManager) this.a.getSystemService("activity");
        if (b.A()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.android.alarmclock.ALARM_ALERT");
            intentFilter.addAction("android.intent.action.ALARM_CHANGED");
            intentFilter.setPriority(LocationClientOption.MIN_SCAN_SPAN);
            this.a.registerReceiver(this.k, intentFilter);
        }
        this.d = true;
    }

    private String[] e() {
        if (!this.d) {
            return null;
        }
        List runningTasks;
        try {
            runningTasks = this.c.getRunningTasks(1);
        } catch (SecurityException e) {
            runningTasks = null;
        } catch (NullPointerException e2) {
            runningTasks = null;
        }
        if (runningTasks == null || runningTasks.size() == 0) {
            return null;
        }
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
        if (runningTaskInfo == null) {
            return null;
        }
        ComponentName componentName = runningTaskInfo.topActivity;
        if (componentName == null) {
            return null;
        }
        String packageName = componentName.getPackageName();
        String className = componentName.getClassName();
        return new String[]{packageName, className};
    }

    public void a() {
        d();
    }

    public void a(ap apVar) {
        this.b = apVar;
    }

    public void a(boolean z) {
        if (z) {
            try {
                this.f = false;
                this.g = false;
                com.vlocker.n.a.a().removeCallbacks(this.h);
                com.vlocker.n.a.a().postDelayed(this.h, 2000);
            } catch (Exception e) {
            }
        } else if (!this.g) {
            this.f = true;
        }
    }

    public void b() {
        if (b.A()) {
            this.a.unregisterReceiver(this.k);
        }
    }

    public synchronized boolean c() {
        boolean z;
        if (b.A() && this.i) {
            z = true;
        } else {
            ActivityManager activityManager = (ActivityManager) this.a.getSystemService("activity");
            String[] a;
            int i;
            int length;
            String toLowerCase;
            if (b.q()) {
                a = aj.a(activityManager);
                if (a != null) {
                    for (String toLowerCase2 : a) {
                        toLowerCase2 = toLowerCase2.toLowerCase();
                        if (toLowerCase2.contains("com.tencent.av.ui.videoinvitefull") || toLowerCase2.contains("com.tencent.mm.plugin.voip.ui.videoactivity") || toLowerCase2.contains("alarm") || toLowerCase2.contains("xtime") || toLowerCase2.contains("clock") || toLowerCase2.contains("alert") || toLowerCase2.contains("snooze")) {
                            z = true;
                            break;
                        }
                    }
                }
            } else if (VERSION.SDK_INT < 20) {
                String[] e = e();
                if (e == null) {
                    z = false;
                } else if (e.length != 2) {
                    z = false;
                } else {
                    String str = e[0];
                    String str2 = str + "/" + e[1];
                    if ("com.sec.android.app.GlanceView".equals(str)) {
                        z = true;
                    } else {
                        str2 = str2.toLowerCase();
                        if (str2.contains("com.tencent.av.ui.videoinvitefull") || str2.contains("com.tencent.mm.plugin.voip.ui.videoactivity") || str2.contains("alarm") || str2.contains("clock") || str2.contains("xtime") || str2.contains("alert") || str2.contains("snooze")) {
                            z = true;
                        }
                    }
                }
            } else if (bb.a(this.a)) {
                a = new String[]{bb.b(this.a)};
                if (a != null) {
                    length = a.length;
                    i = 0;
                    while (i < length) {
                        toLowerCase2 = a[i].toLowerCase();
                        if (b.C() && toLowerCase2.contains("com.android.phone.i2incallscreen")) {
                            z = true;
                            break;
                        } else if (toLowerCase2.contains("com.tencent.av.ui.videoinvitefull") || toLowerCase2.contains("com.tencent.mm.plugin.voip.ui.videoactivity") || toLowerCase2.contains("alarm") || toLowerCase2.contains("xtime") || toLowerCase2.contains("clock") || toLowerCase2.contains("alert") || toLowerCase2.contains("snooze")) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                z = false;
            } else {
                a = aj.b(activityManager);
                if (a != null) {
                    for (String toLowerCase22 : a) {
                        toLowerCase22 = toLowerCase22.toLowerCase();
                        if (toLowerCase22.contains("com.tencent.av.ui.videoinvitefull") || toLowerCase22.contains("com.tencent.mm.plugin.voip.ui.videoactivity") || toLowerCase22.contains("alarm") || toLowerCase22.contains("xtime") || toLowerCase22.contains("clock") || toLowerCase22.contains("alert") || toLowerCase22.contains("snooze")) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
            }
            z = false;
        }
        return z;
    }
}
