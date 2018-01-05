package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.location.b.g;
import com.baidu.location.e.v;
import java.util.ArrayList;
import java.util.Iterator;

public final class LocationClient implements com.baidu.location.e.v.a {
    private Boolean A = Boolean.valueOf(true);
    private boolean B;
    private v C = null;
    private boolean D = false;
    private boolean E = false;
    private ServiceConnection F = new c(this);
    private long a = 0;
    private String b = null;
    private LocationClientOption c = new LocationClientOption();
    private boolean d = false;
    private Context e = null;
    private Messenger f = null;
    private a g = new a();
    private final Messenger h = new Messenger(this.g);
    private ArrayList i = null;
    private BDLocation j = null;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private b n = null;
    private boolean o = false;
    private final Object p = new Object();
    private long q = 0;
    private long r = 0;
    private com.baidu.location.d.a s = null;
    private BDLocationListener t = null;
    private String u = null;
    private String v;
    private boolean w = false;
    private boolean x = true;
    private Boolean y = Boolean.valueOf(false);
    private Boolean z = Boolean.valueOf(false);

    class a extends Handler {
        final /* synthetic */ LocationClient a;

        private a(LocationClient locationClient) {
            this.a = locationClient;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.a.b();
                    return;
                case 2:
                    this.a.c();
                    return;
                case 3:
                    this.a.c(message);
                    return;
                case 4:
                    this.a.f();
                    return;
                case 5:
                    this.a.e(message);
                    return;
                case 6:
                    this.a.f(message);
                    return;
                case 7:
                    return;
                case 8:
                    this.a.d(message);
                    return;
                case 9:
                    this.a.a(message);
                    return;
                case 10:
                    this.a.b(message);
                    return;
                case 11:
                    this.a.e();
                    return;
                case 12:
                    this.a.a();
                    return;
                case 21:
                    Bundle data = message.getData();
                    data.setClassLoader(BDLocation.class.getClassLoader());
                    BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                    if (this.a.E || !this.a.D || bDLocation.getLocType() != 66) {
                        if (this.a.E || !this.a.D) {
                            if (!this.a.E) {
                                this.a.E = true;
                            }
                            this.a.a(message, 21);
                            return;
                        }
                        this.a.E = true;
                        return;
                    }
                    return;
                case 26:
                    this.a.a(message, 26);
                    return;
                case 27:
                    this.a.g(message);
                    return;
                case 54:
                    if (this.a.c.location_change_notify) {
                        this.a.o = true;
                        return;
                    }
                    return;
                case 55:
                    if (this.a.c.location_change_notify) {
                        this.a.o = false;
                        return;
                    }
                    return;
                case 701:
                    this.a.a((BDLocation) message.obj);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ LocationClient a;

        private b(LocationClient locationClient) {
            this.a = locationClient;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r6 = this;
            r0 = r6.a;
            r1 = r0.p;
            monitor-enter(r1);
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r2 = 0;
            r0.m = r2;	 Catch:{ all -> 0x0036 }
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.f;	 Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x001d;
        L_0x0015:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.h;	 Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x001f;
        L_0x001d:
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
        L_0x001e:
            return;
        L_0x001f:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.i;	 Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0034;
        L_0x0027:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.i;	 Catch:{ all -> 0x0036 }
            r0 = r0.size();	 Catch:{ all -> 0x0036 }
            r2 = 1;
            if (r0 >= r2) goto L_0x0039;
        L_0x0034:
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            goto L_0x001e;
        L_0x0036:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            throw r0;
        L_0x0039:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.l;	 Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x006f;
        L_0x0041:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.n;	 Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0055;
        L_0x0049:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r2 = new com.baidu.location.LocationClient$b;	 Catch:{ all -> 0x0036 }
            r3 = r6.a;	 Catch:{ all -> 0x0036 }
            r2.<init>(r3);	 Catch:{ all -> 0x0036 }
            r0.n = r2;	 Catch:{ all -> 0x0036 }
        L_0x0055:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.g;	 Catch:{ all -> 0x0036 }
            r2 = r6.a;	 Catch:{ all -> 0x0036 }
            r2 = r2.n;	 Catch:{ all -> 0x0036 }
            r3 = r6.a;	 Catch:{ all -> 0x0036 }
            r3 = r3.c;	 Catch:{ all -> 0x0036 }
            r3 = r3.scanSpan;	 Catch:{ all -> 0x0036 }
            r4 = (long) r3;	 Catch:{ all -> 0x0036 }
            r0.postDelayed(r2, r4);	 Catch:{ all -> 0x0036 }
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            goto L_0x001e;
        L_0x006f:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.g;	 Catch:{ all -> 0x0036 }
            r2 = 4;
            r0 = r0.obtainMessage(r2);	 Catch:{ all -> 0x0036 }
            r0.sendToTarget();	 Catch:{ all -> 0x0036 }
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            goto L_0x001e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.b.run():void");
        }
    }

    public LocationClient(Context context) {
        this.e = context;
        this.c = new LocationClientOption();
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.e = context;
        this.c = locationClientOption;
        if (this.C == null) {
            this.C = new v(this.e, this.c, this);
            this.C.b();
        }
    }

    private void a() {
        Message obtain = Message.obtain(null, 28);
        try {
            obtain.replyTo = this.h;
            this.f.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(int i) {
        if (this.j.getCoorType() == null) {
            this.j.setCoorType(this.c.coorType);
        }
        if (this.k || ((this.c.location_change_notify && this.j.getLocType() == 61) || this.j.getLocType() == 66 || this.j.getLocType() == 67 || this.w || this.j.getLocType() == BDLocation.TypeNetWorkLocation)) {
            if (this.i != null) {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ((BDLocationListener) it.next()).onReceiveLocation(this.j);
                }
            }
            if (this.j.getLocType() != 66 && this.j.getLocType() != 67) {
                this.k = false;
                this.r = System.currentTimeMillis();
            }
        }
    }

    private void a(Message message) {
        if (message != null && message.obj != null) {
            BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
            if (this.s == null) {
                this.s = new com.baidu.location.d.a(this.e, this);
            }
            this.s.a(bDNotifyListener);
        }
    }

    private void a(Message message, int i) {
        if (this.d) {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            this.j = (BDLocation) data.getParcelable("locStr");
            if (this.j.getLocType() == 61) {
                this.q = System.currentTimeMillis();
            }
            a(i);
        }
    }

    private void a(BDLocation bDLocation) {
        if (!this.x) {
            this.j = bDLocation;
            if (!this.E && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                this.D = true;
            }
            if (this.i != null) {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ((BDLocationListener) it.next()).onReceiveLocation(bDLocation);
                }
            }
        }
    }

    private void b() {
        if (!this.d) {
            if (this.A.booleanValue()) {
                if (this.C == null) {
                    this.C = new v(this.e, this.c, this);
                    this.C.b();
                }
                this.C.c();
                this.A = Boolean.valueOf(false);
            }
            this.b = this.e.getPackageName();
            this.u = this.b + "_bdls_v2.9";
            Intent intent = new Intent(this.e, f.class);
            try {
                intent.putExtra("debug_dev", this.B);
            } catch (Exception e) {
            }
            if (this.c == null) {
                this.c = new LocationClientOption();
            }
            intent.putExtra("cache_exception", this.c.isIgnoreCacheException);
            intent.putExtra("kill_process", this.c.isIgnoreKillProcess);
            try {
                this.e.bindService(intent, this.F, 1);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.d = false;
            }
        }
    }

    private void b(Message message) {
        if (message != null && message.obj != null) {
            BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
            if (this.s != null) {
                this.s.c(bDNotifyListener);
            }
        }
    }

    private void c() {
        if (this.d && this.f != null) {
            Message obtain = Message.obtain(null, 12);
            obtain.replyTo = this.h;
            try {
                this.f.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.e.unbindService(this.F);
            } catch (Exception e2) {
            }
            synchronized (this.p) {
                try {
                    if (this.m) {
                        this.g.removeCallbacks(this.n);
                        this.m = false;
                    }
                } catch (Exception e3) {
                }
            }
            if (this.s != null) {
                this.s.a();
            }
            this.f = null;
            this.l = false;
            this.w = false;
            this.d = false;
            this.D = false;
            this.E = false;
        }
    }

    private void c(Message message) {
        this.l = false;
        if (message != null && message.obj != null) {
            LocationClientOption locationClientOption = (LocationClientOption) message.obj;
            if (!this.c.equals(locationClientOption)) {
                if (this.c.scanSpan != locationClientOption.scanSpan) {
                    try {
                        synchronized (this.p) {
                            if (this.m) {
                                this.g.removeCallbacks(this.n);
                                this.m = false;
                            }
                            if (locationClientOption.scanSpan >= LocationClientOption.MIN_SCAN_SPAN && !this.m) {
                                if (this.n == null) {
                                    this.n = new b();
                                }
                                this.g.postDelayed(this.n, (long) locationClientOption.scanSpan);
                                this.m = true;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                this.c = new LocationClientOption(locationClientOption);
                if (this.f != null) {
                    try {
                        Message obtain = Message.obtain(null, 15);
                        obtain.replyTo = this.h;
                        obtain.setData(d());
                        this.f.send(obtain);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private Bundle d() {
        if (this.c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.b);
        bundle.putString("prodName", this.c.prodName);
        bundle.putString("coorType", this.c.coorType);
        bundle.putString("addrType", this.c.addrType);
        bundle.putBoolean("openGPS", this.c.openGps);
        bundle.putBoolean("location_change_notify", this.c.location_change_notify);
        bundle.putInt("scanSpan", this.c.scanSpan);
        bundle.putInt("timeOut", this.c.timeOut);
        bundle.putInt("priority", this.c.priority);
        bundle.putBoolean("map", this.y.booleanValue());
        bundle.putBoolean("import", this.z.booleanValue());
        bundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
        return bundle;
    }

    private void d(Message message) {
        if (message != null && message.obj != null) {
            this.t = (BDLocationListener) message.obj;
        }
    }

    private void e() {
        if (this.f != null) {
            Message obtain = Message.obtain(null, 22);
            try {
                obtain.replyTo = this.h;
                this.f.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void e(Message message) {
        if (message != null && message.obj != null) {
            BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
            if (this.i == null) {
                this.i = new ArrayList();
            }
            this.i.add(bDLocationListener);
        }
    }

    private void f() {
        if (this.f != null) {
            if ((System.currentTimeMillis() - this.q > 3000 || !this.c.location_change_notify || this.l) && (!this.w || System.currentTimeMillis() - this.r > 20000 || this.l)) {
                Message obtain = Message.obtain(null, 22);
                if (this.l) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.l);
                    obtain.setData(bundle);
                }
                try {
                    obtain.replyTo = this.h;
                    this.f.send(obtain);
                    this.a = System.currentTimeMillis();
                    this.k = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.p) {
                if (!(this.c == null || this.c.scanSpan < LocationClientOption.MIN_SCAN_SPAN || this.m)) {
                    if (this.n == null) {
                        this.n = new b();
                    }
                    this.g.postDelayed(this.n, (long) this.c.scanSpan);
                    this.m = true;
                }
            }
        }
    }

    private void f(Message message) {
        if (message != null && message.obj != null) {
            BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
            if (this.i != null && this.i.contains(bDLocationListener)) {
                this.i.remove(bDLocationListener);
            }
        }
    }

    private void g(Message message) {
        Bundle data = message.getData();
        data.setClassLoader(BDLocation.class.getClassLoader());
        BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
        if (this.t == null) {
            return;
        }
        if (this.c == null || !this.c.isDisableCache() || bDLocation.getLocType() != 65) {
            this.t.onReceiveLocation(bDLocation);
        }
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] dArr = Jni.if(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(dArr[1]);
        bDLocation2.setLongitude(dArr[0]);
        return bDLocation2;
    }

    public String getAccessKey() {
        try {
            this.v = g.b(this.e);
            if (TextUtils.isEmpty(this.v)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s;SHA1=%s", new Object[]{this.v, g.a(this.e)});
        } catch (Exception e) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.j;
    }

    public LocationClientOption getLocOption() {
        return this.c;
    }

    public String getVersion() {
        return "6.0.5";
    }

    public boolean isStarted() {
        return this.d;
    }

    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.E || this.D) && bDLocation != null) {
            Message obtainMessage = this.g.obtainMessage(701);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.g.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.g.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.g.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.g.obtainMessage(10);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public int requestLocation() {
        if (this.f == null || this.h == null) {
            return 1;
        }
        if (this.i == null || this.i.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.a < 1000) {
            return 6;
        }
        Message obtainMessage = this.g.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.g.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        if (this.f == null || this.h == null) {
            return 1;
        }
        if (this.i == null || this.i.size() < 1) {
            return 2;
        }
        this.g.obtainMessage(12).sendToTarget();
        return 0;
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (this.C == null) {
            this.C = new v(this.e, locationClientOption, this);
            this.C.b();
        }
        Message obtainMessage = this.g.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.x = false;
        this.g.obtainMessage(1).sendToTarget();
    }

    public void stop() {
        this.x = true;
        this.g.obtainMessage(2).sendToTarget();
        this.C = null;
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.g.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.f == null || this.h == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain(null, 57);
            obtain.obj = location;
            this.f.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
