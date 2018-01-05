package com.baidu.location.e;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.h;
import com.baidu.location.b.q;
import com.baidu.location.c.h.c;
import com.baidu.location.h.d;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import com.baidu.location.h.i;
import com.baidu.location.h.m;
import java.util.List;

public class r extends c {
    private static r i = null;
    private double A;
    private boolean B;
    private long C;
    private long D;
    private b E;
    private boolean F;
    private boolean G;
    private boolean H;
    final int e;
    final int f;
    public a g;
    public final Handler h;
    private boolean j;
    private String k;
    private BDLocation l;
    private BDLocation m;
    private g n;
    private i o;
    private g p;
    private i q;
    private boolean r;
    private volatile boolean s;
    private boolean t;
    private long u;
    private long v;
    private com.baidu.location.a w;
    private String x;
    private List y;
    private double z;

    class a implements Runnable {
        final /* synthetic */ r a;

        private a(r rVar) {
            this.a = rVar;
        }

        public void run() {
            if (this.a.t) {
                this.a.t = false;
                this.a.g(null);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ r a;

        private b(r rVar) {
            this.a = rVar;
        }

        public void run() {
            if (this.a.F) {
                this.a.F = false;
                if (!this.a.G) {
                    this.a.j();
                }
            }
        }
    }

    private r() {
        this.e = 2000;
        this.f = LocationClientOption.MIN_SCAN_SPAN;
        this.j = true;
        this.g = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = null;
        this.x = null;
        this.y = null;
        this.B = false;
        this.C = 0;
        this.D = 0;
        this.E = null;
        this.F = false;
        this.G = false;
        this.H = true;
        this.h = new com.baidu.location.e.c.b(this);
        this.g = new a(this);
    }

    private boolean a(g gVar) {
        this.a = m.a().k();
        return gVar == this.a ? false : this.a == null || gVar == null || !gVar.c(this.a);
    }

    private boolean a(i iVar) {
        this.b = d.a().f();
        return this.b == iVar ? false : this.b == null || iVar == null || !iVar.a(this.b);
    }

    public static r b() {
        if (i == null) {
            i = new r();
        }
        return i;
    }

    private boolean b(i iVar) {
        return iVar == null ? false : this.q == null || !iVar.a(this.q);
    }

    private void c(Message message) {
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            p.a().b();
        }
        switch (d.a().d(message)) {
            case 1:
                d(message);
                return;
            case 2:
                f(message);
                return;
            case 3:
                if (e.a().j()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", new Object[]{Integer.valueOf(d.a().d(message))}));
        }
    }

    private void d(Message message) {
        if (e.a().j()) {
            e(message);
        } else {
            f(message);
        }
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(e.a().g());
        if (h.f.equals("all") || h.g || h.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.A, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.w != null) {
                    bDLocation.setAddr(this.w);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.y != null) {
                    bDLocation.setPoiList(this.y);
                }
            } else {
                this.B = true;
                f(null);
            }
        }
        this.l = bDLocation;
        this.m = null;
        d.a().a(bDLocation, message);
    }

    private void f(Message message) {
        if (this.r) {
            this.D = System.currentTimeMillis();
            g(message);
        } else if (!this.s) {
            this.D = System.currentTimeMillis();
            if (m.a().e()) {
                this.t = true;
                this.h.postDelayed(new a(), 2000);
                return;
            }
            g(message);
        }
    }

    private void g(Message message) {
        if (!this.s) {
            if (System.currentTimeMillis() - this.u >= 1000 || this.l == null) {
                if (this.D > 0) {
                    q.a().b().a(this.D);
                } else {
                    q.a().b().a(System.currentTimeMillis());
                }
                this.s = true;
                this.j = a(this.o);
                if (a(this.n) || this.j || this.l == null || this.B) {
                    String a = a(null);
                    if (a != null) {
                        if (this.k != null) {
                            a = a + this.k;
                            this.k = null;
                        }
                        q.a().b().b(System.currentTimeMillis());
                        this.g.a(a);
                        this.o = this.b;
                        this.n = this.a;
                        if (this.o == null || this.o.a() != 0) {
                            if (k()) {
                                this.o = this.b;
                                this.n = this.a;
                            }
                            if (com.baidu.location.c.h.a().h()) {
                                if (this.E == null) {
                                    this.E = new b();
                                }
                                this.h.postDelayed(this.E, com.baidu.location.c.h.a().a(d.a(d.a().e())));
                                this.F = true;
                            }
                        } else {
                            new com.baidu.location.g.b(this.o, this.n, true).a();
                            l();
                        }
                        if (this.r) {
                            this.r = false;
                            if (m.a().g() && message != null && d.a().e(message) < LocationClientOption.MIN_SCAN_SPAN && com.baidu.location.c.h.a().d()) {
                                new s(this).start();
                            }
                        }
                        this.u = System.currentTimeMillis();
                        return;
                    } else if (this.l != null) {
                        d.a().a(this.l);
                        l();
                        return;
                    } else {
                        BDLocation bDLocation = new BDLocation();
                        bDLocation.setLocType(62);
                        d.a().a(bDLocation);
                        l();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.C > 60000) {
                            this.C = currentTimeMillis;
                            q.a().a("TypeCriteriaException");
                            return;
                        }
                        return;
                    }
                }
                if (this.m != null && System.currentTimeMillis() - this.v > 30000) {
                    this.l = this.m;
                    this.m = null;
                }
                if (b.a().d()) {
                    this.l.setDirection(b.a().e());
                }
                d.a().a(this.l);
                l();
                return;
            }
            d.a().a(this.l);
            l();
        }
    }

    private boolean k() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long currentTimeMillis = System.currentTimeMillis();
        i f = d.a().f();
        g j = m.a().j();
        boolean z = f != null && f.f() && (j == null || j.a() == 0);
        if (com.baidu.location.c.h.a().d() && com.baidu.location.c.h.a().f() && (z || (0.0d < random && random < com.baidu.location.c.h.a().o()))) {
            bDLocation = com.baidu.location.c.h.a().a(d.a().f(), m.a().j(), null, c.IS_MIX_MODE, com.baidu.location.c.h.b.NEED_TO_LOG);
        }
        if (bDLocation == null || bDLocation.getLocType() != 66 || !this.s) {
            return false;
        }
        com.baidu.location.b.i iVar = new com.baidu.location.b.i();
        iVar.a(this.D);
        iVar.b(currentTimeMillis);
        iVar.c(currentTimeMillis);
        iVar.d(System.currentTimeMillis());
        iVar.a("ofs");
        if (this.o != null) {
            iVar.b(this.o.j());
            iVar.b("&offtag=1");
        }
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
        if (!this.s) {
            return false;
        }
        q.a().a(iVar);
        this.G = true;
        d.a().a(bDLocation2);
        this.l = bDLocation2;
        return true;
    }

    private void l() {
        this.s = false;
        this.G = false;
        this.H = false;
        this.B = false;
        m();
    }

    private void m() {
        if (this.l != null) {
            u.a().c();
        }
    }

    public com.baidu.location.a a(BDLocation bDLocation) {
        if (h.f.equals("all") || h.g || h.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.A, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                f(null);
            } else if (this.w != null) {
                return this.w;
            }
        }
        return null;
    }

    public void a() {
        boolean z;
        if (this.E == null || !this.F) {
            z = false;
        } else {
            this.F = false;
            this.h.removeCallbacks(this.E);
            z = true;
        }
        if (e.a().j()) {
            BDLocation bDLocation = new BDLocation(e.a().g());
            if (h.f.equals("all") || h.g || h.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.A, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.w != null) {
                        bDLocation.setAddr(this.w);
                    }
                    if (this.x != null) {
                        bDLocation.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation.setPoiList(this.y);
                    }
                }
            }
            d.a().a(bDLocation, 21);
            l();
        } else if (this.G) {
            l();
        } else {
            q.a().b().c(System.currentTimeMillis());
            BDLocation a;
            if (z) {
                if (com.baidu.location.c.h.a().d() && com.baidu.location.c.h.a().e()) {
                    a = com.baidu.location.c.h.a().a(d.a().f(), m.a().j(), null, c.IS_NOT_MIX_MODE, com.baidu.location.c.h.b.NEED_TO_LOG);
                    if (a != null && a.getLocType() == 66) {
                        d.a().a(a, 21);
                    }
                } else {
                    a = null;
                }
                if (a == null || a.getLocType() == 67) {
                    if (this.j || this.l == null) {
                        a = com.baidu.location.c.d.a().a(false);
                        d.a().a(a, 21);
                    } else {
                        d.a().a(this.l, 21);
                    }
                }
                q.a().b().d(System.currentTimeMillis());
                if (a == null || a.getLocType() == 67) {
                    this.l = null;
                    q.a().b().a("off");
                    if (this.o != null) {
                        q.a().b().b(this.o.j());
                    }
                    q.a().c();
                } else {
                    this.l = a;
                    q.a().b().a("ofs");
                    if (this.o != null) {
                        q.a().b().b(this.o.j());
                    }
                    q.a().c();
                }
            } else {
                a = new BDLocation();
                a.setLocType(63);
                this.l = null;
                d.a().a(a, 21);
            }
            this.m = null;
            l();
        }
    }

    public void a(Message message) {
        if (this.E != null && this.F) {
            this.F = false;
            this.h.removeCallbacks(this.E);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.w = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.A = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.A = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.A = bDLocation.getLatitude();
        }
        float[] fArr;
        if (e.a().j()) {
            bDLocation = new BDLocation(e.a().g());
            if (h.f.equals("all") || h.g || h.h) {
                fArr = new float[2];
                Location.distanceBetween(this.A, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.w != null) {
                        bDLocation.setAddr(this.w);
                    }
                    if (this.x != null) {
                        bDLocation.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation.setPoiList(this.y);
                    }
                }
            }
            d.a().a(bDLocation, 21);
            l();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            d.a().a(bDLocation, 21);
            this.v = System.currentTimeMillis();
            this.l = bDLocation;
        } else if (this.G) {
            fArr = new float[2];
            if (this.l != null) {
                Location.distanceBetween(this.l.getLatitude(), this.l.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            }
            if (fArr[0] > 10.0f) {
                this.l = bDLocation;
                if (!this.H) {
                    this.H = false;
                    d.a().a(bDLocation, 21);
                }
            }
            l();
        } else {
            boolean z;
            q.a().b().c(System.currentTimeMillis());
            this.m = null;
            if (!(this.o == null || this.o.a() == 0 || ((bDLocation.getLocationWhere() != 2 && bDLocation.getLocationWhere() != 0) || bDLocation.getLocType() != BDLocation.TypeServerError))) {
                new com.baidu.location.g.b(this.o, this.n, true).a();
            }
            if (bDLocation.getLocType() == BDLocation.TypeNetWorkLocation && "cl".equals(bDLocation.getNetworkLocationType()) && this.l != null && this.l.getLocType() == BDLocation.TypeNetWorkLocation && "wf".equals(this.l.getNetworkLocationType()) && System.currentTimeMillis() - this.v < 30000) {
                z = true;
                this.m = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                d.a().a(this.l, 21);
            } else {
                d.a().a(bDLocation, 21);
                this.v = System.currentTimeMillis();
                q.a().b().d(this.v);
                if (bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                    q.a().b().a("ons");
                    if (this.o != null) {
                        q.a().b().b(this.o.j());
                    }
                } else {
                    q.a().b().a("onf");
                    if (this.o != null) {
                        q.a().b().b(this.o.j());
                    }
                    q.a().c();
                }
            }
            if (!h.a(bDLocation)) {
                this.l = null;
            } else if (!z) {
                this.l = bDLocation;
            }
            int a = h.a(c, "ssid\":\"", "\"");
            if (a == Integer.MIN_VALUE || this.n == null) {
                this.k = null;
            } else {
                this.k = this.n.d(a);
            }
            if (com.baidu.location.c.h.a().d() && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.o)) {
                com.baidu.location.c.h.a().a(this.o, null, bDLocation2, c.IS_NOT_MIX_MODE, com.baidu.location.c.h.b.NO_NEED_TO_LOG);
                this.q = this.o;
            }
            if (com.baidu.location.c.h.a().d() && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.c.h.a().a(null, this.n, bDLocation2, c.IS_NOT_MIX_MODE, com.baidu.location.c.h.b.NO_NEED_TO_LOG);
                this.p = this.n;
            }
            com.baidu.location.c.d.a().a(c, this.o, this.n, bDLocation2);
            l();
        }
    }

    public void b(Message message) {
        c(message);
    }

    public void c() {
        this.r = true;
        this.s = false;
    }

    public void d() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        i();
    }

    public String e() {
        return this.x;
    }

    public List f() {
        return this.y;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (this.t) {
            g(null);
            this.t = false;
        }
    }

    public void i() {
        this.l = null;
    }

    public void j() {
        BDLocation a;
        if (com.baidu.location.c.h.a().d() && com.baidu.location.c.h.a().g()) {
            BDLocation a2 = com.baidu.location.c.h.a().a(d.a().f(), m.a().j(), null, c.IS_NOT_MIX_MODE, com.baidu.location.c.h.b.NEED_TO_LOG);
            a = (a2 == null || a2.getLocType() == 67) ? com.baidu.location.c.d.a().a(false) : a2;
        } else {
            a = com.baidu.location.c.d.a().a(false);
        }
        if (a != null && a.getLocType() == 66) {
            boolean z = true;
            if (h.f.equals("all") && a.getAddrStr() == null) {
                z = false;
            }
            if (h.g && a.getLocationDescribe() == null) {
                z = false;
            }
            if (h.h && a.getPoiList() == null) {
                z = false;
            }
            if (z) {
                d.a().a(a, 21);
            }
        }
    }
}
