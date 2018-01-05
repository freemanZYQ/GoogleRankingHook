package com.baidu.location.e;

import android.os.Bundle;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.c;
import com.baidu.location.b.e;
import com.baidu.location.b.h;
import com.baidu.location.b.j;
import com.baidu.location.c.h.b;
import com.baidu.location.h.d;
import com.baidu.location.h.g;
import com.baidu.location.h.i;
import com.baidu.location.h.m;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

class p {
    private static p a;
    private g b = null;
    private i c = null;
    private long d = 0;
    private final long e = 1000;
    private String f = null;

    class a extends j {
        final /* synthetic */ p a;
        private String k;

        a(p pVar) {
            this.a = pVar;
            this.k = null;
            this.f = new ArrayList();
        }

        public void a() {
            this.d = 1;
            this.c = h.b();
            String b = c.a().b();
            if (b == e.e || b == e.f) {
                this.c = "http://" + b + "/sdk.php";
            }
            b = Jni.H(this.k);
            this.k = null;
            this.f.add(new BasicNameValuePair("bloc", b));
        }

        public void a(String str) {
            this.k = str;
            f();
        }

        public void a(boolean z) {
            if (!z || this.e == null) {
                boolean z2 = h.g;
                h.g = true;
                if (com.baidu.location.c.h.a().d() && com.baidu.location.c.h.a().e()) {
                    BDLocation a = com.baidu.location.c.h.a().a(d.a().f(), m.a().j(), null, com.baidu.location.c.h.c.IS_NOT_MIX_MODE, b.NEED_TO_LOG);
                    if (a == null || a.getLocType() == 67) {
                        this.a.a(null);
                    } else {
                        this.a.a(a.getLocationDescribe());
                    }
                } else {
                    this.a.a(null);
                }
                if (!z2) {
                    h.g = false;
                }
            } else {
                try {
                    this.a.a(new BDLocation(EntityUtils.toString(this.e, "utf-8")).getLocationDescribe());
                } catch (Exception e) {
                    this.a.a(null);
                }
            }
            if (this.f != null) {
                this.f.clear();
            }
        }
    }

    private p() {
    }

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            if (a == null) {
                a = new p();
            }
            pVar = a;
        }
        return pVar;
    }

    private void a(String str) {
        this.f = str;
        Bundle bundle = new Bundle();
        if (str == null || str.equals("")) {
            bundle.putByteArray("locationtag", null);
        } else {
            bundle.putByteArray("locationtag", str.getBytes());
        }
        d.a().a(bundle, 601);
    }

    private boolean a(g gVar) {
        g k = m.a().k();
        return gVar == k ? false : k == null || gVar == null || !gVar.c(k);
    }

    private boolean a(i iVar) {
        i f = d.a().f();
        return f == iVar ? false : f == null || iVar == null || !iVar.a(f);
    }

    public void b() {
        if (System.currentTimeMillis() - this.d >= 1000 || this.f == null) {
            this.d = System.currentTimeMillis();
            boolean a = a(this.b);
            boolean a2 = a(this.c);
            if (a || a2 || this.f == null) {
                this.c = d.a().f();
                this.b = m.a().k();
                StringBuffer stringBuffer = new StringBuffer(IXAdIOUtils.BUFFER_SIZE);
                if (this.c != null && this.c.c()) {
                    stringBuffer.append(this.c.j());
                }
                if (this.b != null && this.b.a() > 1) {
                    stringBuffer.append(this.b.a(15));
                }
                String f = com.baidu.location.h.e.a().f();
                if (f != null) {
                    stringBuffer.append(f);
                }
                stringBuffer.append("&sema=aptag");
                stringBuffer.append(com.baidu.location.b.b.a().a(false));
                stringBuffer.append(d.a().c());
                new a(this).a(stringBuffer.toString());
                return;
            }
            a(this.f);
            return;
        }
        a(this.f);
    }
}
