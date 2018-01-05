package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.open.a.j;
import com.tencent.open.d.e;
import com.tencent.open.d.m;
import com.tencent.open.d.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public class g {
    protected static g a;
    protected Random b = new Random();
    protected List c = Collections.synchronizedList(new ArrayList());
    protected List d = Collections.synchronizedList(new ArrayList());
    protected HandlerThread e = null;
    protected Handler f;
    protected Executor g = q.b();
    protected Executor h = q.b();

    private g() {
        if (this.e == null) {
            this.e = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e.start();
        }
        if (this.e.isAlive() && this.e.getLooper() != null) {
            this.f = new h(this, this.e.getLooper());
        }
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    protected int a(int i) {
        int a;
        if (i == 0) {
            a = m.a(e.a(), null).a("Common_CGIReportFrequencySuccess");
            return a == 0 ? 10 : a;
        } else {
            a = m.a(e.a(), null).a("Common_CGIReportFrequencyFailed");
            return a == 0 ? 100 : a;
        }
    }

    public void a(Bundle bundle, String str, boolean z) {
        if (bundle != null) {
            j.a("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
            if (a("report_via", str) || z) {
                this.g.execute(new i(this, bundle, z));
            }
        }
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(String str, long j, long j2, long j3, int i, String str2, boolean z) {
        j.a("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (a("report_cgi", "" + i) || z) {
            this.h.execute(new j(this, j, str, str2, i, j2, j3, z));
        }
    }

    public void a(String str, String str2, Bundle bundle, boolean z) {
        q.a(new m(this, bundle, str, z, str2));
    }

    protected boolean a(String str, int i) {
        int i2 = 5;
        int a;
        if (str.equals("report_cgi")) {
            a = m.a(e.a(), null).a("Common_CGIReportMaxcount");
            if (a != 0) {
                i2 = a;
            }
        } else if (str.equals("report_via")) {
            a = m.a(e.a(), null).a("Agent_ReportBatchCount");
            if (a != 0) {
                i2 = a;
            }
        } else {
            i2 = 0;
        }
        j.b("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
        return i >= i2;
    }

    protected boolean a(String str, String str2) {
        boolean z = true;
        boolean z2 = false;
        j.b("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        if (!TextUtils.isEmpty(str)) {
            int i;
            int a;
            if (str.equals("report_cgi")) {
                try {
                    a = a(Integer.parseInt(str2));
                    if (this.b.nextInt(100) >= a) {
                        z = false;
                    }
                    z2 = z;
                    i = a;
                } catch (Exception e) {
                }
            } else if (str.equals("report_via")) {
                a = e.a(str2);
                if (this.b.nextInt(100) < a) {
                    z2 = true;
                    i = a;
                } else {
                    i = a;
                }
            } else {
                i = 100;
            }
            j.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z2 + " | frequency: " + i);
        }
        return z2;
    }

    protected void b() {
        this.h.execute(new k(this));
    }

    protected Bundle c() {
        if (this.c.size() == 0) {
            return null;
        }
        b bVar = (b) this.c.get(0);
        if (bVar == null) {
            j.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = (String) bVar.a.get("appid");
        Collection a = f.a().a("report_cgi");
        if (a != null) {
            this.c.addAll(a);
        }
        j.b("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
        if (this.c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", "OpenSdk_2.9.4.lite");
            bundle.putString("device", Build.DEVICE);
            bundle.putString("qua", "V1_AND_OpenSDK_2.9.4.lite_1077_RDM_B");
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.c.size(); i++) {
                bVar = (b) this.c.get(i);
                bundle.putString(i + "_1", (String) bVar.a.get("apn"));
                bundle.putString(i + "_2", (String) bVar.a.get("frequency"));
                bundle.putString(i + "_3", (String) bVar.a.get("commandid"));
                bundle.putString(i + "_4", (String) bVar.a.get("resultCode"));
                bundle.putString(i + "_5", (String) bVar.a.get("timeCost"));
                bundle.putString(i + "_6", (String) bVar.a.get("reqSize"));
                bundle.putString(i + "_7", (String) bVar.a.get("rspSize"));
                bundle.putString(i + "_8", (String) bVar.a.get(com.vlocker.setting.a.a.e.ACTION_APPLICATION_DETAILS_SETTINGS));
                bundle.putString(i + "_9", (String) bVar.a.get("uin"));
                bundle.putString(i + "_10", c.e(e.a()) + "&" + ((String) bVar.a.get("deviceInfo")));
            }
            j.a("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Throwable e) {
            j.a("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    protected Bundle d() {
        Collection a = f.a().a("report_via");
        if (a != null) {
            this.d.addAll(a);
        }
        j.b("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.d) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) serializable;
            for (String str : bVar.a.keySet()) {
                try {
                    Object obj = (String) bVar.a.get(str);
                    if (obj == null) {
                        obj = "";
                    }
                    jSONObject.put(str, obj);
                } catch (Throwable e) {
                    j.a("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        j.a("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (Throwable e2) {
            j.a("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected void e() {
        this.g.execute(new l(this));
    }
}
