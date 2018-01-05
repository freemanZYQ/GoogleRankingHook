package com.baidu.mobads.command;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONObject;

public class a implements Serializable {
    private boolean A;
    public String a;
    public String b;
    public String c;
    public long d = -1;
    public int e = 0;
    public int f;
    public DownloadStatus g = DownloadStatus.NONE;
    public Object h = null;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public String p;
    public int q = 0;
    public boolean r = false;
    public long s;
    protected long t;
    protected long u;
    public boolean v = false;
    public String w = null;
    protected final IXAdLogger x = m.a().f();
    private long y;
    private long z;

    public a(String str, String str2) {
        this.i = str;
        this.a = str2;
    }

    public static a a(Context context, String str) {
        Throwable th;
        a aVar = null;
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            String string = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getString(str + "#$#" + b(), null);
            if (string == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            String string2 = jSONObject.getString("title");
            String optString = jSONObject.optString("url", jSONObject.getString("turl"));
            a aVar2 = new a(str, string2);
            try {
                aVar2.a(jSONObject.optString("qk"), jSONObject.optString("adid"), optString, jSONObject.optBoolean("autoOpen"));
                aVar2.a(jSONObject.getString("filename"), jSONObject.getString("folder"));
                aVar2.b(jSONObject.optString("placeId"), jSONObject.optString("prod"));
                int i = jSONObject.getInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
                DownloadStatus[] values = DownloadStatus.values();
                DownloadStatus downloadStatus = DownloadStatus.NONE;
                for (int i2 = 0; i2 < values.length; i2++) {
                    if (values[i2].getCode() == i) {
                        downloadStatus = values[i2];
                    }
                }
                aVar2.g = downloadStatus;
                aVar2.r = jSONObject.optBoolean("mnCfm");
                aVar2.q = jSONObject.getInt("dlCnt");
                aVar2.s = jSONObject.optLong("cts");
                aVar2.t = jSONObject.optLong("ts");
                aVar2.u = (long) jSONObject.optInt("clickProcId");
                return aVar2;
            } catch (Throwable e) {
                Throwable th2 = e;
                aVar = aVar2;
                th = th2;
                m.a().f().d(th);
                com.baidu.mobads.c.a.a().a("get stored download info failed: " + th.toString());
                return aVar;
            }
        } catch (Exception e2) {
            th = e2;
            m.a().f().d(th);
            com.baidu.mobads.c.a.a().a("get stored download info failed: " + th.toString());
            return aVar;
        }
    }

    public static List a(Context context, long j) {
        List arrayList = new ArrayList();
        try {
            for (Entry entry : context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getAll().entrySet()) {
                try {
                    String str = (String) entry.getKey();
                    if (str.contains("#$#" + b())) {
                        JSONObject jSONObject = new JSONObject((String) entry.getValue());
                        if (jSONObject.getLong("cts") >= j) {
                            int i = jSONObject.getInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
                            if (i == 0 || i == 1 || i == 4) {
                                arrayList.add(str.substring(0, str.indexOf("#$#")));
                            }
                        }
                    }
                } catch (Exception e) {
                    m.a().f().d("XAdDownloaderManager", e.getMessage());
                }
            }
        } catch (Throwable e2) {
            m.a().f().d(e2);
        }
        return arrayList;
    }

    public static String b() {
        return m.a().n().getCurrentProcessName(m.a().d());
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, this.g.getCode());
            jSONObject.put("filename", this.b);
            jSONObject.put("folder", this.c);
            jSONObject.put("title", this.a);
            jSONObject.put("contentLength", this.d);
            jSONObject.put(IXAdRequestInfo.PACKAGE, this.i);
            jSONObject.put("qk", this.m);
            jSONObject.put("autoOpen", this.l);
            jSONObject.put("adid", this.n);
            jSONObject.put("placeId", this.o);
            jSONObject.put("prod", this.p);
            jSONObject.put("dlTunnel", 4);
            if (this.k == null || this.k.length() <= 0) {
                jSONObject.put("url", this.j);
            } else {
                jSONObject.put("turl", this.k);
            }
            jSONObject.put("mnCfm", this.r);
            jSONObject.put("dlCnt", this.q);
            jSONObject.put("cts", this.s);
            if (this.q == 1) {
                this.t = System.currentTimeMillis();
                this.u = (long) Process.myPid();
            }
            jSONObject.put("ts", this.t);
            jSONObject.put("clickProcId", this.u);
        } catch (Throwable e) {
            this.x.d(e);
        }
        return jSONObject;
    }

    public void a(long j) {
        this.y = j;
    }

    @TargetApi(9)
    public void a(Context context) {
        if (this.i != null && !"".equals(this.i)) {
            try {
                Editor edit = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).edit();
                edit.putString(this.i + "#$#" + b(), a().toString());
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            } catch (Throwable e) {
                m.a().f().d("XAdAPKDownloadExtraInfo", e);
            }
        }
    }

    public void a(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public void a(String str, String str2, String str3, boolean z) {
        this.m = str;
        this.n = str2;
        this.j = str3;
        this.l = z;
    }

    public void a(boolean z) {
        this.A = z;
    }

    public void b(long j) {
        this.z = j;
    }

    public void b(String str, String str2) {
        this.o = str;
        this.p = str2;
    }

    public long c() {
        return this.y;
    }

    public String d() {
        return this.i;
    }

    public long e() {
        return this.z;
    }

    public boolean f() {
        return this.A;
    }

    public String g() {
        return this.n;
    }

    public String h() {
        return this.m;
    }

    public String i() {
        return this.p;
    }
}
