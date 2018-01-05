package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.j.d;
import com.baidu.mobads.j.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class a {
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    protected Context k;
    protected d l;
    protected IXAdSystemUtils m;

    public a(XAdCommandExtraInfo xAdCommandExtraInfo) {
        this(xAdCommandExtraInfo.getAdInstanceInfo().getAdId(), xAdCommandExtraInfo.getAdInstanceInfo().getQueryKey(), xAdCommandExtraInfo.mProdType);
    }

    public a(String str, String str2, String str3) {
        this.b = "-1";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.j = "";
        this.l = m.a().m();
        this.m = m.a().n();
        this.k = m.a().d();
        this.a = System.currentTimeMillis();
        this.b = str;
        this.c = str2;
        this.e = this.l.getAppSec(this.k);
        if (this.k != null) {
            this.d = this.k.getPackageName();
        }
        this.f = this.l.getAppId(this.k);
        this.h = this.m.getEncodedSN(this.k);
        this.i = "android";
        this.g = "android_" + com.baidu.mobads.a.a.c + "_" + "4.1.30";
        this.j = str3;
    }

    protected String a(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
        } catch (Exception e) {
        }
        return str;
    }

    protected String a(HashMap hashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            d m = m.a().m();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String str : hashMap.keySet()) {
                String str2;
                String str3 = (String) hashMap.get(str2);
                if (!(str2 == null || str3 == null)) {
                    str2 = a(str2);
                    str3 = a(str3);
                    stringBuilder.append(str2 + "=" + str3 + "&");
                    stringBuilder2.append(str3 + ",");
                }
            }
            stringBuilder2.append("mobads,");
            stringBuilder.append("vd=" + m.getMD5(stringBuilder2.toString()) + "&");
            return stringBuilder.toString();
        } catch (Exception e) {
            return "";
        }
    }

    protected HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("adid", this.b);
        hashMap.put("appsec", this.e);
        hashMap.put("appsid", this.f);
        hashMap.put("pack", this.d);
        hashMap.put("qk", this.c);
        hashMap.put(IXAdRequestInfo.SN, this.h);
        hashMap.put("ts", "" + this.a);
        hashMap.put(IXAdRequestInfo.V, this.g);
        hashMap.put(IXAdRequestInfo.OS, this.i);
        hashMap.put("prod", this.j);
        hashMap.put(IXAdRequestInfo.P_VER, "8.23");
        return hashMap;
    }

    protected abstract HashMap b();

    public HashMap c() {
        HashMap a = a();
        Map b = b();
        if (b != null) {
            a.putAll(b);
        }
        return a;
    }

    public String toString() {
        return a(c());
    }
}
