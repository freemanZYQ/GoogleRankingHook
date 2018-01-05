package com.baidu.location.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.e;
import com.baidu.location.b.h;
import com.baidu.location.b.j;
import com.baidu.location.b.q;
import com.baidu.location.f;
import com.baidu.location.h.d;
import com.baidu.location.h.g;
import com.baidu.location.h.i;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public abstract class c {
    public static String c = null;
    public g a = null;
    public i b = null;
    final Handler d = new b(this);
    private boolean e = true;
    private boolean f = false;

    class a extends j {
        String a;
        String k;
        final /* synthetic */ c l;

        public a(c cVar) {
            this.l = cVar;
            this.a = null;
            this.k = null;
            this.f = new ArrayList();
        }

        public void a() {
            this.c = h.b();
            String b = com.baidu.location.b.c.a().b();
            if (b == e.e || b == e.f) {
                this.c = "http://" + b + "/sdk.php";
            }
            if (b != null) {
                q.a().b().b("&host=" + b);
            }
            b = Jni.K(this.k);
            this.k = null;
            if (this.a == null) {
                this.a = u.b();
            }
            this.f.add(new BasicNameValuePair("bloc", b));
            if (this.a != null) {
                this.f.add(new BasicNameValuePair("up", this.a));
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[]{com.baidu.location.b.g.b(f.getServiceContext()), com.baidu.location.b.g.a(f.getServiceContext())}));
            if (stringBuffer.length() > 0) {
                this.f.add(new BasicNameValuePair("ext", Jni.H(stringBuffer.toString())));
            }
            this.f.add(new BasicNameValuePair("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())})));
        }

        public void a(String str) {
            this.k = str;
            f();
        }

        public void a(boolean z) {
            Message obtainMessage;
            if (this.l.b == null || this.l.b.a() != 0) {
                if (!z || this.e == null) {
                    obtainMessage = this.l.d.obtainMessage(63);
                    obtainMessage.obj = "HttpStatus error";
                    obtainMessage.sendToTarget();
                } else {
                    try {
                        BDLocation bDLocation;
                        String entityUtils = EntityUtils.toString(this.e, "utf-8");
                        c.c = entityUtils;
                        try {
                            bDLocation = new BDLocation(entityUtils);
                            bDLocation.setOperators(d.a().g());
                            if (b.a().d()) {
                                bDLocation.setDirection(b.a().e());
                            }
                        } catch (Exception e) {
                            bDLocation = new BDLocation();
                            bDLocation.setLocType(0);
                        }
                        this.a = null;
                        if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                            obtainMessage = this.l.d.obtainMessage(63);
                            obtainMessage.obj = "HttpStatus error";
                            obtainMessage.sendToTarget();
                        } else {
                            Message obtainMessage2 = this.l.d.obtainMessage(21);
                            obtainMessage2.obj = bDLocation;
                            obtainMessage2.sendToTarget();
                        }
                    } catch (Exception e2) {
                        obtainMessage = this.l.d.obtainMessage(63);
                        obtainMessage.obj = "HttpStatus error";
                        obtainMessage.sendToTarget();
                    }
                }
                if (this.f != null) {
                    this.f.clear();
                }
            }
        }
    }

    public class b extends Handler {
        final /* synthetic */ c a;

        public b(c cVar) {
            this.a = cVar;
        }

        public void handleMessage(Message message) {
            if (f.isServing) {
                switch (message.what) {
                    case 21:
                        this.a.a(message);
                        return;
                    case BDLocation.TypeCriteriaException /*62*/:
                    case BDLocation.TypeNetWorkException /*63*/:
                        this.a.a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 1;
        r7 = 0;
        r0 = r9.b;
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r0 = r9.b;
        r0 = r0.b();
        if (r0 != 0) goto L_0x0019;
    L_0x000f:
        r0 = com.baidu.location.h.d.a();
        r0 = r0.f();
        r9.b = r0;
    L_0x0019:
        r0 = r9.a;
        if (r0 == 0) goto L_0x0025;
    L_0x001d:
        r0 = r9.a;
        r0 = r0.f();
        if (r0 != 0) goto L_0x002f;
    L_0x0025:
        r0 = com.baidu.location.h.m.a();
        r0 = r0.k();
        r9.a = r0;
    L_0x002f:
        r0 = com.baidu.location.h.e.a();
        r0 = r0.j();
        if (r0 == 0) goto L_0x0117;
    L_0x0039:
        r0 = com.baidu.location.h.e.a();
        r0 = r0.h();
    L_0x0041:
        r2 = r9.b;
        if (r2 == 0) goto L_0x004d;
    L_0x0045:
        r2 = r9.b;
        r2 = r2.d();
        if (r2 == 0) goto L_0x005c;
    L_0x004d:
        r2 = r9.a;
        if (r2 == 0) goto L_0x0059;
    L_0x0051:
        r2 = r9.a;
        r2 = r2.a();
        if (r2 != 0) goto L_0x005c;
    L_0x0059:
        if (r0 != 0) goto L_0x005c;
    L_0x005b:
        return r1;
    L_0x005c:
        r1 = com.baidu.location.e.d.a();
        r2 = r1.c();
        r1 = com.baidu.location.h.m.a();
        r1 = r1.g();
        if (r1 == 0) goto L_0x00de;
    L_0x006e:
        r1 = "&cn=32";
    L_0x0071:
        r3 = r9.e;
        if (r3 == 0) goto L_0x00f9;
    L_0x0075:
        r9.e = r7;
        r3 = com.baidu.location.b.q.a();
        r3 = r3.b();
        r3.a(r8);
        r3 = com.baidu.location.h.m.a();
        r3 = r3.m();
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 != 0) goto L_0x00aa;
    L_0x0090:
        r4 = ":";
        r5 = "";
        r3 = r3.replace(r4, r5);
        r4 = java.util.Locale.CHINA;
        r5 = "%s&mac=%s";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r6[r7] = r1;
        r6[r8] = r3;
        r1 = java.lang.String.format(r4, r5, r6);
    L_0x00aa:
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 17;
        if (r3 <= r4) goto L_0x00b0;
    L_0x00b0:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r1 = r3.append(r1);
        r1 = r1.append(r2);
        r1 = r1.toString();
        if (r10 == 0) goto L_0x00d4;
    L_0x00c3:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r10);
        r1 = r2.append(r1);
        r1 = r1.toString();
    L_0x00d4:
        r2 = r9.b;
        r3 = r9.a;
        r1 = com.baidu.location.b.h.a(r2, r3, r0, r1, r7);
        goto L_0x005b;
    L_0x00de:
        r1 = java.util.Locale.CHINA;
        r3 = "&cn=%d";
        r4 = new java.lang.Object[r8];
        r5 = com.baidu.location.h.d.a();
        r5 = r5.e();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r7] = r5;
        r1 = java.lang.String.format(r1, r3, r4);
        goto L_0x0071;
    L_0x00f9:
        r3 = r9.f;
        if (r3 != 0) goto L_0x00b0;
    L_0x00fd:
        r3 = com.baidu.location.e.u.f();
        if (r3 == 0) goto L_0x0114;
    L_0x0103:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r1 = r4.append(r1);
        r1 = r1.append(r3);
        r1 = r1.toString();
    L_0x0114:
        r9.f = r8;
        goto L_0x00b0;
    L_0x0117:
        r0 = r1;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.c.a(java.lang.String):java.lang.String");
    }

    public abstract void a();

    public abstract void a(Message message);
}
