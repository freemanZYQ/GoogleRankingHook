package com.vlocker.msg;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.RemoteViews;
import com.vlocker.i.a;
import com.vlocker.msg.data.d;
import com.vlocker.msg.data.e;
import com.vlocker.security.MoSecurityApplication;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"NewApi"})
public class ab implements a {
    static ab a = null;
    private boolean b = false;
    private Notification c;
    private String d;
    private String e;
    private long f;
    private com.vlocker.k.a g = new com.vlocker.k.a(this.m);
    private boolean h = false;
    private Object i = new Object();
    private AtomicBoolean j = new AtomicBoolean();
    private HandlerThread k;
    private Handler l;
    private Context m = MoSecurityApplication.a();
    private com.vlocker.c.a n = com.vlocker.c.a.a(this.m);
    private HashMap o = new HashMap();
    private HashMap p = new HashMap();
    private String q;
    private Runnable r = new ae(this);
    private long s;
    private long t;
    private long u = 0;

    public static Context a(Context context, String str) {
        Context context2 = null;
        try {
            context2 = context.createPackageContext(str, 2);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return context2;
    }

    private Bitmap a(Notification notification, String str) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Object obj = notification.contentView;
        if (obj != null) {
            obj = a(RemoteViews.class.getName(), "mActions", obj);
            if (obj != null && (obj instanceof List)) {
                bitmap = null;
                for (Object next : (List) obj) {
                    if (next.getClass().getName().equals("android.widget.RemoteViews$BitmapReflectionAction")) {
                        obj = a("android.widget.RemoteViews$BitmapReflectionAction", "methodName", next);
                        if (obj != null && (obj instanceof String)) {
                            if (((String) obj).equals("setImageBitmap")) {
                                obj = a(next, "bitmap");
                                if (obj != null && (obj instanceof Bitmap)) {
                                    Bitmap bitmap3 = bitmap;
                                    bitmap = (Bitmap) obj;
                                    bitmap2 = bitmap3;
                                    break;
                                }
                            }
                            bitmap2 = bitmap;
                        }
                        bitmap2 = bitmap;
                    } else {
                        if (next.getClass().getName().equals("android.widget.RemoteViews$ReflectionAction")) {
                            obj = a("android.widget.RemoteViews$ReflectionAction", "methodName", next);
                            if (obj != null && (obj instanceof String) && ((String) obj).equals("setImageResource")) {
                                obj = a(next, "value");
                                if (obj != null && (obj instanceof Integer)) {
                                    int intValue = ((Integer) obj).intValue();
                                    if (intValue > 0) {
                                        bitmap2 = c(str, intValue);
                                    }
                                }
                            }
                        }
                        bitmap2 = bitmap;
                    }
                    bitmap = bitmap2;
                }
                bitmap2 = bitmap;
                bitmap = null;
                return bitmap != null ? bitmap2 : bitmap;
            }
        }
        bitmap2 = null;
        bitmap = null;
        if (bitmap != null) {
        }
    }

    public static synchronized ab a() {
        ab abVar;
        synchronized (ab.class) {
            if (a == null) {
                a = new ab();
            }
            abVar = a;
        }
        return abVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.vlocker.msg.ak a(android.app.Notification r11, java.lang.String r12, java.lang.String r13) {
        /*
        r10 = this;
        r9 = 2;
        r8 = 1;
        r5 = 0;
        r3 = 0;
        r4 = new com.vlocker.msg.ak;
        r4.<init>();
        r4.b = r12;
        r0 = java.lang.System.currentTimeMillis();
        r4.g = r0;
        r4.i = r11;
        r0 = r11.contentIntent;
        r4.h = r0;
        r1 = r10.p;
        monitor-enter(r1);
        r0 = r10.p;	 Catch:{ all -> 0x0043 }
        r0 = r0.containsKey(r12);	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0040;
    L_0x0022:
        r0 = r10.p;	 Catch:{ all -> 0x0043 }
        r0 = r0.get(r12);	 Catch:{ all -> 0x0043 }
        r0 = (com.vlocker.msg.data.e) r0;	 Catch:{ all -> 0x0043 }
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        r1 = "com.moxiu.launcher";
        r1 = r1.equals(r12);
        if (r1 == 0) goto L_0x0046;
    L_0x0034:
        r1 = r10.a(r11);
        r1 = com.vlocker.msg.p.a(r4, r1);
        if (r1 != 0) goto L_0x0046;
    L_0x003e:
        r0 = r3;
    L_0x003f:
        return r0;
    L_0x0040:
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        r0 = r3;
        goto L_0x003f;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        r1 = android.text.TextUtils.isEmpty(r13);
        if (r1 != 0) goto L_0x013d;
    L_0x004c:
        r1 = r10.m;	 Catch:{ Exception -> 0x0149 }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x0149 }
        r2 = 0;
        r1 = r1.getPackageInfo(r12, r2);	 Catch:{ Exception -> 0x0149 }
        r1 = r1.applicationInfo;	 Catch:{ Exception -> 0x0149 }
        r2 = r10.m;	 Catch:{ Exception -> 0x0149 }
        r2 = r2.getPackageManager();	 Catch:{ Exception -> 0x0149 }
        r1 = r1.loadLabel(r2);	 Catch:{ Exception -> 0x0149 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0149 }
        r4.j = r1;	 Catch:{ Exception -> 0x01ac }
        r2 = r1;
    L_0x006a:
        r1 = r10.b(r11);
        if (r1 == 0) goto L_0x01ae;
    L_0x0070:
        r5 = r1[r5];
        r1 = r1[r8];
        r10.c(r11);
        r6 = r5;
        r5 = r1;
    L_0x0079:
        if (r11 == 0) goto L_0x00c8;
    L_0x007b:
        r7 = r11.extras;
        r1 = r4.c;	 Catch:{ Exception -> 0x0152 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0152 }
        if (r1 == 0) goto L_0x0092;
    L_0x0085:
        r1 = "android.title";
        r1 = r7.getString(r1);	 Catch:{ Exception -> 0x0152 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0152 }
        r4.c = r1;	 Catch:{ Exception -> 0x0152 }
    L_0x0092:
        r1 = r4.e;	 Catch:{ Exception -> 0x0152 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0152 }
        if (r1 == 0) goto L_0x00a7;
    L_0x009a:
        r1 = "android.text";
        r1 = r7.getCharSequence(r1);	 Catch:{ Exception -> 0x0152 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0152 }
        r4.e = r1;	 Catch:{ Exception -> 0x0152 }
    L_0x00a7:
        r1 = r10.m;
        r1 = com.vlocker.c.a.a(r1);
        r1 = r1.aD();
        if (r1 != 0) goto L_0x015e;
    L_0x00b3:
        r1 = "android.largeIcon";
        r1 = r7.getParcelable(r1);	 Catch:{ Exception -> 0x0158 }
        r1 = (android.graphics.Bitmap) r1;	 Catch:{ Exception -> 0x0158 }
        r4.k = r1;	 Catch:{ Exception -> 0x0158 }
    L_0x00be:
        r1 = r4.k;
        if (r1 != 0) goto L_0x00c8;
    L_0x00c2:
        r1 = r10.a(r11, r12);
        r4.k = r1;
    L_0x00c8:
        r1 = r4.c;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00dc;
    L_0x00d0:
        r1 = r4.e;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00dc;
    L_0x00d8:
        r1 = r4.k;
        if (r1 != 0) goto L_0x0124;
    L_0x00dc:
        if (r0 == 0) goto L_0x0104;
    L_0x00de:
        r1 = r4.k;
        if (r1 != 0) goto L_0x00e8;
    L_0x00e2:
        r1 = r10.a(r11, r12);
        r4.k = r1;
    L_0x00e8:
        r1 = r4.c;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x00f6;
    L_0x00f0:
        r1 = r0.a;
        if (r1 != r8) goto L_0x0185;
    L_0x00f4:
        r4.c = r2;
    L_0x00f6:
        r1 = r4.e;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x0104;
    L_0x00fe:
        r1 = r0.b;
        if (r1 != r8) goto L_0x018d;
    L_0x0102:
        r4.e = r13;
    L_0x0104:
        r1 = r4.c;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x0114;
    L_0x010c:
        r1 = android.text.TextUtils.isEmpty(r6);
        if (r1 != 0) goto L_0x0195;
    L_0x0112:
        r4.c = r6;
    L_0x0114:
        r1 = r4.e;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x0124;
    L_0x011c:
        r1 = android.text.TextUtils.isEmpty(r5);
        if (r1 != 0) goto L_0x019f;
    L_0x0122:
        r4.e = r5;
    L_0x0124:
        r0 = r0.a();
        if (r0 == 0) goto L_0x01a9;
    L_0x012a:
        r1 = r4.c;
        r1 = r0.b(r1);
        if (r1 != 0) goto L_0x013a;
    L_0x0132:
        r1 = r4.e;
        r0 = r0.d(r1);
        if (r0 == 0) goto L_0x01a9;
    L_0x013a:
        r0 = r3;
        goto L_0x003f;
    L_0x013d:
        r1 = r11.tickerText;
        if (r1 == 0) goto L_0x01b2;
    L_0x0141:
        r1 = r11.tickerText;
        r13 = r1.toString();
        goto L_0x004c;
    L_0x0149:
        r1 = move-exception;
        r2 = r1;
        r1 = r3;
    L_0x014c:
        r2.printStackTrace();
        r2 = r1;
        goto L_0x006a;
    L_0x0152:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00a7;
    L_0x0158:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00be;
    L_0x015e:
        r1 = r10.m;	 Catch:{ Exception -> 0x017f }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x017f }
        r7 = 0;
        r1 = r1.getPackageInfo(r12, r7);	 Catch:{ Exception -> 0x017f }
        r1 = r1.applicationInfo;	 Catch:{ Exception -> 0x017f }
        r7 = r10.m;	 Catch:{ Exception -> 0x017f }
        r7 = r7.getPackageManager();	 Catch:{ Exception -> 0x017f }
        r1 = r1.loadIcon(r7);	 Catch:{ Exception -> 0x017f }
        r1 = (android.graphics.drawable.BitmapDrawable) r1;	 Catch:{ Exception -> 0x017f }
        r1 = r1.getBitmap();	 Catch:{ Exception -> 0x017f }
        r4.k = r1;	 Catch:{ Exception -> 0x017f }
        goto L_0x00c8;
    L_0x017f:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00c8;
    L_0x0185:
        r1 = r0.a;
        if (r1 != r9) goto L_0x00f6;
    L_0x0189:
        r4.c = r6;
        goto L_0x00f6;
    L_0x018d:
        r1 = r0.b;
        if (r1 != r9) goto L_0x0104;
    L_0x0191:
        r4.e = r5;
        goto L_0x0104;
    L_0x0195:
        r1 = android.text.TextUtils.isEmpty(r2);
        if (r1 != 0) goto L_0x0114;
    L_0x019b:
        r4.c = r2;
        goto L_0x0114;
    L_0x019f:
        r1 = android.text.TextUtils.isEmpty(r13);
        if (r1 != 0) goto L_0x0124;
    L_0x01a5:
        r4.e = r13;
        goto L_0x0124;
    L_0x01a9:
        r0 = r4;
        goto L_0x003f;
    L_0x01ac:
        r2 = move-exception;
        goto L_0x014c;
    L_0x01ae:
        r5 = r3;
        r6 = r3;
        goto L_0x0079;
    L_0x01b2:
        r13 = r3;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.msg.ab.a(android.app.Notification, java.lang.String, java.lang.String):com.vlocker.msg.ak");
    }

    public static Object a(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != Object.class) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (Exception e) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static Object a(String str, String str2, Object obj) {
        try {
            Class cls = Class.forName(str);
            while (cls != Object.class) {
                try {
                    Field declaredField = cls.getDeclaredField(str2);
                    declaredField.setAccessible(true);
                    return declaredField.get(obj);
                } catch (Exception e) {
                    cls = cls.getSuperclass();
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }

    private String a(Notification notification) {
        try {
            PendingIntent pendingIntent = notification.contentIntent;
            return ((Intent) pendingIntent.getClass().getMethod("getIntent", new Class[0]).invoke(pendingIntent, new Object[0])).getExtras().getString("parameter");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean a(long j) {
        if (!com.vlocker.c.a.a(this.m).aY()) {
            return true;
        }
        if (j < this.s || j < this.t - 120000) {
            this.s = j;
            this.t = 0;
            return true;
        } else if (this.s == 0) {
            this.s = j;
            return true;
        } else if (this.t == 0) {
            if (j - this.s > 30000) {
                this.s = j;
                return true;
            }
            this.t = j + 120000;
            return true;
        } else if (j <= this.t) {
            return false;
        } else {
            this.s = j;
            this.t = 0;
            return true;
        }
    }

    private boolean a(Time time) {
        int aU = this.n.aU();
        int aV = this.n.aV();
        int aW = this.n.aW();
        int aX = this.n.aX();
        return (aU < aW || (aU == aW && aV < aX)) ? (time.hour > aU || (time.hour == aU && time.minute >= aV)) ? time.hour >= aW && (time.hour != aW || time.minute > aX) : true : (aU > aW || (aU == aW && aV > aX)) ? time.hour <= aU && ((time.hour != aU || time.minute < aV) && time.hour >= aW && (time.hour != aW || time.minute > aX)) : true;
    }

    public static void b(String str, int i) {
        Intent intent = new Intent("com.vlocker.app.msgcount.remove");
        intent.putExtra("extral_pkg_name", str);
        intent.putExtra("id", i);
        MoSecurityApplication.a().sendBroadcast(intent);
    }

    private String[] b(Notification notification) {
        String[] strArr = null;
        int i = 0;
        if (notification.contentView == null) {
            return null;
        }
        Object a = a(RemoteViews.class.getName(), "mActions", notification.contentView);
        if (a == null || !(a instanceof List)) {
            return null;
        }
        for (Object next : (List) a) {
            int i2;
            if (next.getClass().getName().equals("android.widget.RemoteViews$ReflectionAction")) {
                a = a("android.widget.RemoteViews$ReflectionAction", "methodName", next);
                if (a != null && (a instanceof String) && ((String) a).equals("setText")) {
                    a = a(next, "value");
                    if (a != null && (a instanceof String)) {
                        String[] strArr2 = strArr == null ? new String[2] : strArr;
                        if (i > 1) {
                            return strArr2;
                        }
                        int i3 = i + 1;
                        strArr2[i] = (String) a;
                        i2 = i3;
                        strArr = strArr2;
                        i = i2;
                    }
                }
            }
            i2 = i;
            i = i2;
        }
        return strArr;
    }

    private String c(Notification notification) {
        if (notification.contentView != null) {
            Object a = a(RemoteViews.class.getName(), "mActions", notification.contentView);
            if (a != null && (a instanceof List)) {
                for (Object next : (List) a) {
                    if (next.getClass().getName().equals("android.widget.RemoteViews$ReflectionAction")) {
                        a = a("android.widget.RemoteViews$ReflectionAction", "methodName", next);
                        if (a != null && (a instanceof String) && ((String) a).equals("setText")) {
                            a = a("android.widget.RemoteViews$ReflectionAction", "viewId", next);
                            if ((a instanceof Integer) && ((Integer) a).intValue() == 16908392) {
                                a = a("android.widget.RemoteViews$ReflectionAction", "value", next);
                                if (a != null && (a instanceof CharSequence)) {
                                    return ((CharSequence) a).toString();
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private synchronized void e() {
        if (this.k == null && this.b) {
            this.k = new HandlerThread("notify_dispatcher");
            this.k.start();
            this.l = new Handler(this.k.getLooper());
            this.l.post(this.r);
        }
    }

    public static void e(String str) {
        b(str, -1);
    }

    private void f() {
        try {
            this.l.postDelayed(new aj(this), 400);
        } catch (Exception e) {
        }
    }

    private void f(String str) {
        Intent intent = new Intent("com.vlocker.app.msgcount.changed");
        intent.putExtra("extral_pkg_name", str);
        this.m.sendBroadcast(intent);
    }

    Bitmap a(Context context, int i) {
        Drawable drawable = context.getResources().getDrawable(i);
        return (drawable == null || !(drawable instanceof BitmapDrawable)) ? null : ((BitmapDrawable) drawable).getBitmap();
    }

    public void a(Notification notification, String str, String str2, long j) {
        e();
        if (!this.j.get()) {
            return;
        }
        if (this.h) {
            this.l.post(new ai(this, notification, str, str2, j));
            return;
        }
        this.c = notification;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.p) {
                e eVar = new e();
                eVar.a = (byte) 2;
                eVar.b = (byte) 1;
                if (str.equals(this.q)) {
                    this.p.put("com.android.server.telecom", eVar);
                    eVar = new e();
                    eVar.a = (byte) 2;
                    eVar.b = (byte) 1;
                    d dVar = new d();
                    dVar.a("来电中").c("来电中");
                    eVar.a(dVar);
                    this.p.put("com.android.phone", eVar);
                } else {
                    String c = as.c(str);
                    if ("com.tencent.mobileqq".equals(c)) {
                        d dVar2 = new d();
                        dVar2.a("后台").a("“QQ”正在运行").c("触摸即可了解详情或停止应用").c("后台");
                        eVar.a(dVar2);
                    }
                    this.p.put(c, eVar);
                }
            }
        }
    }

    public void a(String str, int i) {
        e();
        if (i == -1) {
            this.l.post(new af(this, str));
        } else {
            this.l.post(new ag(this, str, i));
        }
    }

    public void a(String str, Notification notification, int i) {
        if (str != null) {
            if (str.equals(MoSecurityApplication.a().getPackageName())) {
                a(str, i);
            } else if (this.j.get()) {
                c(str);
            }
        }
    }

    public void a_(int i) {
        if (4 != i && 10 != i && 8 != i) {
            if (this.g.a) {
                this.g.a = false;
                return;
            }
            synchronized (this.o) {
                this.o.clear();
                e(null);
                com.vlocker.msg.a.a.a(this.m).c();
            }
            this.j.set(false);
            f(null);
        }
    }

    public void b() {
        com.vlocker.c.a a = com.vlocker.c.a.a(this.m);
        if (a.aH()) {
            this.b = true;
            return;
        }
        a.aI();
        new Thread(new ac(this, a)).start();
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.p) {
                if (str.equals(this.q)) {
                    this.p.remove("com.android.server.telecom");
                    this.p.remove("com.android.phone");
                } else {
                    this.p.remove(as.c(str));
                }
            }
        }
    }

    Bitmap c(String str, int i) {
        Context a = a(this.m, str);
        return a == null ? null : a(a, i);
    }

    public void c() {
        new Thread(new ad(this, com.vlocker.c.a.a(this.m))).start();
    }

    public void c(String str) {
        a(str, -1);
    }

    public ArrayList d() {
        ArrayList arrayList;
        synchronized (this.o) {
            arrayList = new ArrayList(this.o.values());
        }
        return arrayList;
    }

    public void d(String str) {
        e();
        if (this.l != null) {
            this.l.post(new ah(this, str));
        }
    }

    public void g() {
        this.j.set(true);
    }

    public void h() {
    }

    public void i() {
    }
}
