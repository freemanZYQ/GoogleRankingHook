package com.baidu.location.g;

import android.os.Message;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.h;
import com.baidu.location.b.j;
import com.baidu.location.b.q;
import com.baidu.location.e.d;
import com.baidu.location.e.r;
import com.baidu.location.h.g;
import com.baidu.location.h.i;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.util.EntityUtils;

public class b {
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    i a = null;
    g b = null;
    a c = null;
    boolean d = false;
    long e = 0;
    private com.baidu.location.b.i g = new com.baidu.location.b.i();

    class a extends j {
        final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public void a() {
        }

        void a(String str) {
            this.i = str;
            g();
        }

        public void a(boolean z) {
            this.a.g.c(System.currentTimeMillis());
            if (!z || this.e == null) {
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLocType(63);
                d.a().a(bDLocation);
                return;
            }
            try {
                String entityUtils = EntityUtils.toString(this.e, "utf-8");
                this.a.c = new a(entityUtils);
                if (this.a.d && this.a.c.b()) {
                    bDLocation = new BDLocation();
                    bDLocation.setLongitude(this.a.c.d());
                    bDLocation.setLatitude(this.a.c.c());
                    bDLocation.setRadius(this.a.c.e());
                    bDLocation.setLocType(BDLocation.TypeNetWorkLocation);
                    bDLocation.setLocationWhere(0);
                    bDLocation.setCoorType("wgs84");
                    bDLocation.setNetworkLocationType("sky");
                    String str = this.a.c.b;
                    String str2 = this.a.c.d;
                    String str3 = this.a.c.a;
                    String str4 = this.a.c.e;
                    String str5 = this.a.c.f;
                    com.baidu.location.a build = new com.baidu.location.a.a().country(str).province(str2).city(str3).district(str4).street(str5).streetNumber(this.a.c.g).build();
                    bDLocation.setTime(b.f.format(new Date()));
                    bDLocation.setOperators(com.baidu.location.h.d.a().g());
                    if (com.baidu.location.e.b.a().d()) {
                        bDLocation.setDirection(com.baidu.location.e.b.a().e());
                    }
                    if (h.f.equals("all")) {
                        bDLocation.setAddr(build);
                    }
                    if (this.a.c.a()) {
                        double[] dArr = Jni.if(this.a.c.d(), this.a.c.c(), "gps2gcj");
                        bDLocation.setCoorType("gcj02");
                        bDLocation.setLongitude(dArr[0]);
                        bDLocation.setLatitude(dArr[1]);
                    }
                    Message obtainMessage = r.b().h.obtainMessage(21);
                    obtainMessage.obj = bDLocation;
                    obtainMessage.sendToTarget();
                    this.a.g.d(System.currentTimeMillis());
                    this.a.g.a("skys");
                    if (this.a.a != null) {
                        this.a.g.b(this.a.a.j());
                    }
                    q.a().a(this.a.g);
                } else if (this.a.d && !this.a.c.b()) {
                    bDLocation = new BDLocation();
                    bDLocation.setLocType(BDLocation.TypeServerError);
                    d.a().a(bDLocation);
                    this.a.g.d(System.currentTimeMillis());
                    this.a.g.a("skyf");
                    if (this.a.a != null) {
                        this.a.g.b(this.a.a.j());
                    }
                    q.a().a(this.a.g);
                }
            } catch (Exception e) {
            }
        }
    }

    public b(i iVar, g gVar, boolean z) {
        this.a = iVar;
        this.b = gVar;
        this.d = z;
        this.g.a();
        long currentTimeMillis = System.currentTimeMillis();
        this.g.a(currentTimeMillis);
        this.g.b(currentTimeMillis);
    }

    public void a() {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer(IXAdIOUtils.BUFFER_SIZE);
        String b = (this.b == null || this.b.a() <= 1) ? null : this.b.b(15);
        if (this.a != null && this.a.c()) {
            str = this.a.i();
        }
        if (b != null || str != null) {
            stringBuffer.append("<LocationRQ xmlns=\"http://skyhookwireless.com/wps/2005\"\nversion=\"2.21\"\nstreet-address-lookup=\"full\">\n<authentication version=\"2.2\">\n<key key=\"" + Jni.dG() + "\"\n" + "username=\"BAIDULOC\"/></authentication>\n");
            if (b != null) {
                stringBuffer.append(b);
            }
            if (str != null) {
                stringBuffer.append(str);
            }
            stringBuffer.append("</LocationRQ>");
            new a(this).a(stringBuffer.toString());
            this.e = System.currentTimeMillis();
        }
    }
}
