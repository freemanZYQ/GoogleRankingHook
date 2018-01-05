package com.vlocker.j;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RemoteViews;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.msg.an;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.widget.MusicLrcView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class a {
    public static boolean a = false;
    private static n e;
    private static a k;
    private BroadcastReceiver A = new h(this);
    private long B;
    private long C;
    private long D;
    private long E;
    private long F;
    private boolean G = false;
    private int H;
    private List I;
    private Runnable J = new d(this);
    public boolean b;
    private Context c = MoSecurityApplication.a();
    private o d = new o(this.c);
    private String f = "UNKNOWN";
    private String g = "";
    private String h = "";
    private Bitmap i = null;
    private boolean j = false;
    private boolean l = false;
    private PackageManager m;
    private boolean n = false;
    private String o = null;
    private Handler p;
    private com.vlocker.c.a q;
    private boolean r = false;
    private m s;
    private MusicLrcView t;
    private ViewGroup u;
    private long v;
    private long w = -1;
    private boolean x = false;
    private boolean y = false;
    private BroadcastReceiver z = new g(this);

    private a() {
        Resources resources = this.c.getResources();
        this.f = "";
        this.i = BitmapFactory.decodeResource(resources, R.drawable.l_music_art_default);
        e = new n(this);
        e.c = this.f;
        e.d = this.f;
        e.e = this.i;
        this.q = com.vlocker.c.a.a(this.c);
        this.m = this.c.getPackageManager();
    }

    public static a a() {
        if (k == null) {
            synchronized (a.class) {
                if (k == null) {
                    k = new a();
                }
            }
        }
        return k;
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

    @TargetApi(16)
    private void a(Notification notification) {
        ArrayList arrayList = new ArrayList();
        Bitmap bitmap = null;
        Object obj = notification.contentView;
        if ((obj == null && VERSION.SDK_INT >= 16) || "com.meizu.media.music".equals(e.a)) {
            obj = notification.bigContentView != null ? notification.bigContentView : notification.contentView;
        }
        if (obj != null) {
            obj = a(RemoteViews.class.getName(), "mActions", obj);
            if (obj != null && (obj instanceof List)) {
                for (Object next : (List) obj) {
                    Bitmap bitmap2;
                    if (next.getClass().getName().equals("android.widget.RemoteViews$ReflectionAction")) {
                        obj = a("android.widget.RemoteViews$ReflectionAction", "methodName", next);
                        if (obj != null && (obj instanceof String)) {
                            if (((String) obj).equals("setText")) {
                                obj = a("android.widget.RemoteViews$ReflectionAction", "value", next);
                                if (obj != null && (obj instanceof String)) {
                                    String charSequence = ((CharSequence) obj).toString();
                                    if (!p.b(charSequence)) {
                                        if (arrayList.size() < 3) {
                                            arrayList.add(charSequence);
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            bitmap2 = bitmap;
                        }
                        bitmap2 = bitmap;
                    } else {
                        if (next.getClass().getName().equals("android.widget.RemoteViews$BitmapReflectionAction")) {
                            obj = a("android.widget.RemoteViews$BitmapReflectionAction", "methodName", next);
                            if (obj != null && (obj instanceof String) && ((String) obj).equals("setImageBitmap")) {
                                obj = a("android.widget.RemoteViews$BitmapReflectionAction", "bitmap", next);
                                if (obj != null && (obj instanceof Bitmap) && bitmap == null) {
                                    bitmap2 = (Bitmap) obj;
                                }
                            }
                        }
                        bitmap2 = bitmap;
                    }
                    bitmap = bitmap2;
                }
                a(arrayList, bitmap);
            }
        }
    }

    private final void a(Intent intent) {
        String stringExtra = intent.getStringExtra("artist");
        String stringExtra2 = intent.getStringExtra("track");
        if (stringExtra != null && stringExtra2 != null) {
            this.g = stringExtra;
            this.h = stringExtra2;
            if (!an.c(this.c)) {
                if ("com.kugou.android".equals(this.o) || "com.tencent.qqmusic".equals(this.o) || "com.miui.player".equals(this.o)) {
                    new Thread(new i(this)).start();
                }
            }
        }
    }

    private void a(Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            e.e = bitmap;
            if (!(z || this.r)) {
                this.p.removeMessages(5);
                this.p.sendEmptyMessage(5);
            }
            this.r = true;
            if (z) {
                this.p.removeMessages(5);
                this.p.sendEmptyMessage(5);
                return;
            }
            return;
        }
        this.r = false;
        this.p.postDelayed(new l(this), 600);
    }

    private void a(n nVar) {
        new c(this, nVar).start();
    }

    private void a(String str) {
        if (e.d == null || str == null || this.t == null) {
            this.G = false;
        } else if (!e.d.equals(str) || (e.d.equals(str) && System.currentTimeMillis() - this.v > 1000 && ((this.D > 0 || this.C == 0) && this.F == 0 && System.currentTimeMillis() - ((this.B + this.t.getSongLong()) + this.D) > 1000))) {
            this.F = 0;
            this.D = 0;
            this.C = 0;
            this.B = this.E;
            this.G = true;
        } else {
            this.G = false;
            if (!this.d.a()) {
                this.C = this.E;
                this.F = 0;
            } else if (this.C > 0 && this.F == 0) {
                this.F = this.E - this.C;
                this.D += this.F;
            }
        }
    }

    private void a(ArrayList arrayList, Bitmap bitmap) {
        String str;
        int size = arrayList.size();
        String str2 = this.f;
        str2 = this.f;
        if ("com.kugou.android".equals(this.o) && size >= 2) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            arrayList.clear();
            arrayList.add(arrayList2.get(1));
            arrayList.add(arrayList2.get(0));
            arrayList2.clear();
        }
        if (arrayList != null && size > 0) {
            a((String) arrayList.get(0));
        }
        if (size >= 2) {
            str2 = (String) arrayList.get(0);
            str = (String) arrayList.get(1);
        } else if (size >= 1) {
            str2 = (String) arrayList.get(0);
            str = (this.g == null || this.g.isEmpty()) ? this.f : this.g;
        } else {
            str2 = (this.h == null || this.h.isEmpty()) ? this.f : this.h;
            str = (this.g == null || this.g.isEmpty()) ? this.f : this.g;
        }
        this.g = "";
        this.h = "";
        if (e.c.equals(str) && e.d.equals(str2)) {
            a(bitmap, false);
            return;
        }
        e.c = str;
        e.d = str2;
        this.p.removeMessages(3);
        this.p.sendEmptyMessage(3);
        a(bitmap, true);
    }

    private String b(String str) {
        String replaceAll = (str.contains("(") && str.contains(")")) ? str.replaceAll(str.substring(str.lastIndexOf("("), str.lastIndexOf(")") + 1), "") : str;
        if (str.contains("（") && str.contains("）")) {
            replaceAll = str.replaceAll(str.substring(str.indexOf("（"), str.indexOf("）") + 1), "");
        }
        if (str.contains("（") && str.contains(")")) {
            replaceAll = str.replaceAll(str.substring(str.indexOf("（"), str.indexOf(")") + 1), "");
        }
        if (str.contains("(") && str.contains("）")) {
            replaceAll = str.replaceAll(str.substring(str.indexOf("("), str.indexOf("）") + 1), "");
        }
        return replaceAll.replaceAll("\\(", "").replaceAll("\\)", "").trim();
    }

    private final void b(Intent intent) {
        e.a = "com.miui.player";
        String stringExtra = intent.getStringExtra("artist");
        String stringExtra2 = intent.getStringExtra("track");
        if (stringExtra != null && stringExtra2 != null) {
            this.g = stringExtra;
            this.h = stringExtra2;
            new Thread(new j(this)).start();
        }
    }

    private boolean r() {
        return "com.duomi.android".equals(e.a) || "fm.xiami.main".equals(e.a);
    }

    private void s() {
        this.t.c(!a);
        if (this.G) {
            this.C = 0;
            if (this.t.a(e, this.B)) {
                this.p.removeCallbacks(this.J);
                this.H = 1;
                a(e);
            }
        } else if (this.d.a()) {
            this.t.a(this.D);
        } else {
            this.t.d();
        }
        if (a && !l() && LockerService.a().c()) {
            g();
        }
    }

    private void t() {
        boolean c = LockerService.a().c();
        if (!a || l()) {
            if (!(a || this.t == null || c)) {
                h();
                w();
                return;
            }
        } else if (c) {
            g();
        } else {
            return;
        }
        j();
    }

    private void u() {
        this.p.postDelayed(new e(this), 1500);
    }

    private void v() {
        if (!this.l) {
            return;
        }
        if (this.q.ap()) {
            if (this.t != null) {
                this.t.d();
            }
            if (!this.n) {
                h();
            }
            if (this.d.a() && !l()) {
                g();
                return;
            }
            return;
        }
        h();
    }

    private void w() {
        if (this.l) {
            e.a = null;
            e.c = this.f;
            e.d = this.f;
            e.e = this.i;
            e.b = -1;
        }
    }

    private void x() {
        if (!(this.t == null || this.t == null || e == null || e.e == null)) {
            this.t.a(e.e.equals(this.i), e.e);
        }
        if (a && !l()) {
            g();
        }
    }

    private final void y() {
        e.a = "com.tencent.qqmusic";
        if (!an.c(this.c)) {
            new Thread(new k(this)).start();
        }
    }

    public void a(Notification notification, String str, int i) {
        if (this.l && notification != null && str != null) {
            this.b = false;
            this.n = false;
            if (e.b == i) {
                this.p.sendEmptyMessage(2);
            }
        }
    }

    public void a(Notification notification, String str, int i, long j) {
        if (this.l && notification != null && str != null) {
            this.w = System.currentTimeMillis();
            this.o = str;
            e.a = str;
            e.b = i;
            if (!str.equals("com.miui.player")) {
                this.E = j;
                this.p.post(new f(this, notification));
            }
        }
    }

    public void a(m mVar) {
        this.s = mVar;
    }

    public void a(MusicLrcView musicLrcView, ViewGroup viewGroup) {
        this.u = viewGroup;
        this.t = musicLrcView;
        this.p = new b(this);
        this.l = true;
    }

    public void b() {
        this.d.a(r() ? e.a : null);
    }

    public void c() {
        this.d.b(r() ? e.a : null);
    }

    public void d() {
        this.d.c(r() ? e.a : null);
    }

    public void e() {
        this.d.d(r() ? e.a : null);
    }

    public void f() {
        try {
            p.a(this.c, "v_open", "101000", "101001", "1016");
            Intent launchIntentForPackage = this.m.getLaunchIntentForPackage(e.a);
            launchIntentForPackage.addFlags(268435456);
            this.c.startActivity(launchIntentForPackage);
        } catch (Exception e) {
        }
    }

    public void g() {
        if (!this.b && !MusicLrcView.a && e.d != null && !e.d.isEmpty()) {
            if (!(this.t == null || this.u == null)) {
                this.u.addView(this.t, this.u.getChildCount() > 1 ? 1 : 0, new LayoutParams(-1, (int) this.c.getResources().getDimension(R.dimen.l_msg_item_height)));
                this.t.setVisibility(0);
                this.t.a(true);
            }
            MusicLrcView.a = true;
            if (this.s != null) {
                this.s.a();
            }
            this.n = true;
        }
    }

    public void h() {
        if (this.t != null) {
            this.t.setVisibility(8);
        }
        if (this.u != null) {
            this.u.removeView(this.t);
            System.gc();
        }
        MusicLrcView.a = false;
        if (this.t != null) {
            this.t.a(false);
        }
        if (this.s != null) {
            this.s.b();
        }
    }

    public void i() {
        this.v = System.currentTimeMillis();
        if (!this.l) {
            return;
        }
        if (this.q.ap()) {
            a = this.d.a();
            this.j = a;
            if (this.t != null && a) {
                this.t.b();
            }
            if (this.j || this.n) {
                this.n = true;
                if (!l()) {
                    g();
                }
                j();
                return;
            }
            return;
        }
        h();
    }

    public void j() {
        if (this.t != null) {
            this.t.c(!a);
        }
    }

    public void k() {
        if (this.l) {
            if ("com.miui.player".equals(this.o)) {
                this.b = false;
            }
            if (l()) {
                h();
            }
        }
    }

    public boolean l() {
        return this.t != null ? this.t.isShown() : false;
    }

    public synchronized void m() {
        if (!this.x) {
            this.x = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.c.registerReceiver(this.z, intentFilter);
        }
    }

    public synchronized void n() {
        if (!this.y) {
            this.y = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.android.music.metachanged");
            intentFilter.addAction("com.tencent.qqmusic.ACTION_META_CHANGED.QQMusicPhone");
            intentFilter.addAction("com.kugou.android.music.playstatechanged");
            intentFilter.addAction("com.miui.player.playstatechanged");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            if (this.c != null) {
                this.c.registerReceiver(this.A, intentFilter);
            }
            if (!(this.q == null || this.q.aq())) {
                this.q.C(true);
            }
        }
    }

    public synchronized void o() {
        if (this.l && this.x) {
            this.x = false;
            if (this.t.getVisibility() == 0) {
                h();
            }
            w();
            try {
                this.c.unregisterReceiver(this.z);
            } catch (Exception e) {
            }
        }
    }

    public synchronized void p() {
        if (this.l && this.y) {
            this.y = false;
            if (this.t.getVisibility() == 0) {
                h();
            }
            w();
            try {
                this.c.unregisterReceiver(this.A);
            } catch (Exception e) {
            }
        }
    }
}
