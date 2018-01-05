package com.baidu.location.e;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.b;
import com.baidu.location.b.h;
import com.baidu.location.h.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d {
    private static d b = null;
    public boolean a;
    private ArrayList c;
    private boolean d;
    private boolean e;

    class a {
        public String a = null;
        public Messenger b = null;
        public LocationClientOption c = new LocationClientOption();
        public int d = 0;
        final /* synthetic */ d e;

        public a(d dVar, Message message) {
            this.e = dVar;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            b.a().a(this.c.prodName, this.a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            h.k = this.c.enableSimulateGps;
            h.f = this.c.addrType;
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt("priority");
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect");
            h.g = message.getData().getBoolean("isneedaptag", false);
            h.h = message.getData().getBoolean("isneedaptagd", false);
            h.i = message.getData().getBoolean("isneedpoiregion", false);
            h.j = message.getData().getBoolean("isneedregular", false);
            if (this.c.scanSpan >= LocationClientOption.MIN_SCAN_SPAN) {
                n.a().b();
            }
            if (this.c.mIsNeedDeviceDirect) {
                b.a().a(this.c.mIsNeedDeviceDirect);
                b.a().b();
            }
        }

        private void a(int i) {
            Message obtain = Message.obtain(null, i);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        private void a(int i, Bundle bundle) {
            Message obtain = Message.obtain(null, i);
            obtain.setData(bundle);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
                e.printStackTrace();
            }
        }

        private void a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            Message obtain = Message.obtain(null, i);
            obtain.setData(bundle);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        public void a() {
            if (!this.c.location_change_notify) {
                return;
            }
            if (h.b) {
                a(54);
            } else {
                a(55);
            }
        }

        public void a(BDLocation bDLocation) {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (bDLocation2 != null) {
                if (i == 21) {
                    a(27, "locStr", bDLocation2);
                }
                if (!(this.c.coorType == null || this.c.coorType.equals("gcj02"))) {
                    double longitude = bDLocation2.getLongitude();
                    double latitude = bDLocation2.getLatitude();
                    if (!(longitude == Double.MIN_VALUE || latitude == Double.MIN_VALUE)) {
                        double[] dArr;
                        if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                            dArr = Jni.if(longitude, latitude, this.c.coorType);
                            bDLocation2.setLongitude(dArr[0]);
                            bDLocation2.setLatitude(dArr[1]);
                            bDLocation2.setCoorType(this.c.coorType);
                        } else if (!(bDLocation2.getCoorType() == null || !bDLocation2.getCoorType().equals("wgs84") || this.c.coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09LL))) {
                            dArr = Jni.if(longitude, latitude, "wgs842mc");
                            bDLocation2.setLongitude(dArr[0]);
                            bDLocation2.setLatitude(dArr[1]);
                            bDLocation2.setCoorType("wgs84mc");
                        }
                    }
                }
                a(i, "locStr", bDLocation2);
            }
        }

        public void b(BDLocation bDLocation) {
            if (this.c.location_change_notify) {
                a(bDLocation);
            }
        }
    }

    private d() {
        this.c = null;
        this.d = false;
        this.e = false;
        this.a = true;
        this.c = new ArrayList();
    }

    private a a(Messenger messenger) {
        if (this.c == null) {
            return null;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.b.equals(messenger)) {
                return aVar;
            }
        }
        return null;
    }

    public static d a() {
        if (b == null) {
            b = new d();
        }
        return b;
    }

    private void a(a aVar) {
        if (aVar != null) {
            if (a(aVar.b) != null) {
                aVar.a(14);
                return;
            }
            this.c.add(aVar);
            aVar.a(13);
        }
    }

    private void e() {
        f();
        d();
    }

    private void f() {
        Iterator it = this.c.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.c.openGps) {
                z2 = true;
            }
            z = aVar.c.location_change_notify ? true : z;
        }
        h.a = z;
        if (this.d != z2) {
            this.d = z2;
            e.a().a(this.d);
        }
    }

    public void a(Bundle bundle, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.a(i, bundle);
            if (aVar.d > 4) {
                arrayList.add(aVar);
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.c.remove((a) it2.next());
            }
        }
    }

    public void a(Message message) {
        if (message != null && message.replyTo != null) {
            a(new a(this, message));
            e();
        }
    }

    public void a(BDLocation bDLocation) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.a(bDLocation);
            if (aVar.d > 4) {
                arrayList.add(aVar);
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.c.remove((a) it2.next());
            }
        }
    }

    public void a(BDLocation bDLocation, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.a(bDLocation, i);
            if (aVar.d > 4) {
                arrayList.add(aVar);
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.c.remove((a) it2.next());
            }
        }
    }

    public void a(BDLocation bDLocation, Message message) {
        if (bDLocation != null && message != null) {
            a a = a(message.replyTo);
            if (a != null) {
                a.a(bDLocation);
                if (a.d > 4) {
                    this.c.remove(a);
                }
            }
        }
    }

    public void a(String str) {
        BDLocation bDLocation = new BDLocation(str);
        com.baidu.location.a a = r.b().a(bDLocation);
        String e = r.b().e();
        List f = r.b().f();
        if (a != null) {
            bDLocation.setAddr(a);
        }
        if (e != null) {
            bDLocation.setLocationDescribe(e);
        }
        if (f != null) {
            bDLocation.setPoiList(f);
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(bDLocation);
        }
    }

    public void b() {
        this.c.clear();
        e();
    }

    public void b(Message message) {
        a a = a(message.replyTo);
        if (a != null) {
            this.c.remove(a);
        }
        n.a().c();
        b.a().c();
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.c.isEmpty()) {
            return "&prod=" + b.h + ":" + b.g;
        }
        a aVar = (a) this.c.get(0);
        if (aVar.c.prodName != null) {
            stringBuffer.append(aVar.c.prodName);
        }
        if (aVar.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(aVar.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        return (stringBuffer2 == null || stringBuffer2.equals("")) ? null : "&prod=" + stringBuffer2;
    }

    public boolean c(Message message) {
        boolean z = true;
        a a = a(message.replyTo);
        if (a == null) {
            return false;
        }
        int i = a.c.scanSpan;
        a.c.scanSpan = message.getData().getInt("scanSpan", a.c.scanSpan);
        if (a.c.scanSpan < LocationClientOption.MIN_SCAN_SPAN) {
            n.a().e();
            b.a().c();
            this.a = false;
        } else {
            n.a().d();
            this.a = true;
        }
        if (a.c.scanSpan <= 999 || i >= LocationClientOption.MIN_SCAN_SPAN) {
            z = false;
        } else if (a.c.mIsNeedDeviceDirect) {
            b.a().a(a.c.mIsNeedDeviceDirect);
            b.a().b();
        }
        a.c.openGps = message.getData().getBoolean("openGPS", a.c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.c;
        if (string == null || string.equals("")) {
            string = a.c.coorType;
        }
        locationClientOption.coorType = string;
        string = message.getData().getString("addrType");
        locationClientOption = a.c;
        if (string == null || string.equals("")) {
            string = a.c.addrType;
        }
        locationClientOption.addrType = string;
        if (!h.f.equals(a.c.addrType)) {
            r.b().i();
        }
        h.f = a.c.addrType;
        h.g = message.getData().getBoolean("isneedaptag", false);
        h.h = message.getData().getBoolean("isneedaptagd", false);
        h.i = message.getData().getBoolean("isneedpoiregion", false);
        h.j = message.getData().getBoolean("isneedregular", false);
        a.c.timeOut = message.getData().getInt("timeOut", a.c.timeOut);
        a.c.location_change_notify = message.getData().getBoolean("location_change_notify", a.c.location_change_notify);
        a.c.priority = message.getData().getInt("priority", a.c.priority);
        e();
        return z;
    }

    public int d(Message message) {
        if (message == null || message.replyTo == null) {
            return 1;
        }
        a a = a(message.replyTo);
        return (a == null || a.c == null) ? 1 : a.c.priority;
    }

    public void d() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    public int e(Message message) {
        if (message == null || message.replyTo == null) {
            return LocationClientOption.MIN_SCAN_SPAN;
        }
        a a = a(message.replyTo);
        return (a == null || a.c == null) ? LocationClientOption.MIN_SCAN_SPAN : a.c.scanSpan;
    }
}
