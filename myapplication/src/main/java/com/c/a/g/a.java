package com.c.a.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.c.a.b;
import com.c.a.k.c;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONObject;

public abstract class a {
    protected HashMap a = new HashMap();
    protected HashMap b = new HashMap();
    public com.c.a.a.a c;
    public com.c.a.c.a d;

    protected a(com.c.a.a.a aVar) {
        this.c = aVar;
        if (b.a().a != null) {
            if (!c.a(b.a().a.c)) {
                this.a.put("backURL", b.a().a.c);
            }
            if (!c.a(b.a().a.a)) {
                this.a.put("appkey", b.a().a.a);
            }
            if (!c.a(b.a().a.d)) {
                this.b.put("pid", b.a().a.d);
            }
            if (!c.a(b.a().a.f)) {
                this.a.put("TTID", b.a().a.f);
            }
            if (!c.a(b.a().a.g)) {
                this.a.put("tag", b.a().a.g);
            }
            if (!c.a(b.a().a.h)) {
                this.a.put("utdid", b.a().a.h);
            }
            if (!c.a(b.a().a.e)) {
                this.a.put("source", b.a().a.e);
            }
        }
    }

    public a a(String str) {
        if (!c.a(str)) {
            this.a.put("backURL", str);
        }
        return this;
    }

    public abstract String a();

    public String a(Context context) {
        if (b.a().a == null) {
            return null;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        this.b.put("time", valueOf);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appkey").append(b.a().a.a).append("packagename").append(com.c.a.b.a.a(context)).append("time").append(valueOf);
        if (b.a().c != null) {
            return stringBuffer.toString();
        }
        if (c.a(b.a().a.b)) {
            return null;
        }
        stringBuffer.insert(0, b.a().a.b).append(b.a().a.b);
        return stringBuffer.toString();
    }

    public String b(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("tbopen://m.taobao.com/tbopen/index.html?");
        this.a.put("appName", com.c.a.b.a.b(context));
        this.a.put("packageName", com.c.a.b.a.a(context));
        this.a.put(IXAdRequestInfo.V, "1.0");
        for (Entry entry : this.a.entrySet()) {
            if (!(c.a((String) entry.getKey()) || c.a((String) entry.getValue()))) {
                try {
                    String encode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
                    stringBuffer.append(encode).append("=").append(URLEncoder.encode((String) entry.getValue(), "UTF-8")).append("&");
                } catch (Throwable th) {
                    Log.d("AppLink", th.toString());
                }
            }
        }
        String a;
        if (b.a().c != null) {
            try {
                a = b.a().c.a(a(context));
                if (!c.a(a)) {
                    this.b.put("sign", a);
                }
            } catch (Throwable th2) {
                Log.d("AppLink", th2.toString());
            }
        } else {
            a = com.c.a.k.a.a(a(context));
            if (!c.a(a)) {
                this.b.put("sign", a);
            }
        }
        JSONObject jSONObject = new JSONObject();
        if (this.b != null) {
            for (Entry entry2 : this.b.entrySet()) {
                if (!(c.a((String) entry2.getKey()) || c.a((String) entry2.getValue()))) {
                    try {
                        jSONObject.put(URLEncoder.encode((String) entry2.getKey(), "UTF-8"), URLEncoder.encode((String) entry2.getValue(), "UTF-8"));
                    } catch (Throwable th22) {
                        Log.d("AppLink", th22.toString());
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(jSONObject.toString())) {
            stringBuffer.append("params").append("=").append(jSONObject.toString()).append("&");
        }
        if (stringBuffer.toString().endsWith("&")) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    protected String b(String str) {
        if (c.a(str)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (this.b != null) {
            for (Entry entry : this.b.entrySet()) {
                if (!(c.a((String) entry.getKey()) || c.a((String) entry.getValue()))) {
                    try {
                        String encode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
                        stringBuffer.append(encode).append("=").append(URLEncoder.encode((String) entry.getValue(), "UTF-8")).append("&");
                    } catch (Throwable th) {
                        Log.d("AppLink", th.toString());
                    }
                }
            }
        }
        if (!c.a((String) this.a.get("TTID"))) {
            try {
                encode = URLEncoder.encode("TTID", "UTF-8");
                stringBuffer.append(encode).append("=").append(URLEncoder.encode((String) this.a.get("TTID"), "UTF-8")).append("&");
            } catch (Throwable th2) {
                Log.d("AppLink", th2.toString());
            }
        }
        if (!c.a((String) this.a.get("tag"))) {
            try {
                encode = URLEncoder.encode("tag", "UTF-8");
                stringBuffer.append(encode).append("=").append(URLEncoder.encode((String) this.a.get("tag"), "UTF-8")).append("&");
            } catch (Throwable th22) {
                Log.d("AppLink", th22.toString());
            }
        }
        if (!c.a((String) this.a.get("utdid"))) {
            try {
                encode = URLEncoder.encode("utdid", "UTF-8");
                stringBuffer.append(encode).append("=").append(URLEncoder.encode((String) this.a.get("utdid"), "UTF-8")).append("&");
            } catch (Throwable th222) {
                Log.d("AppLink", th222.toString());
            }
        }
        if (!c.a((String) this.a.get("source"))) {
            try {
                encode = URLEncoder.encode("source", "UTF-8");
                stringBuffer.append(encode).append("=").append(URLEncoder.encode((String) this.a.get("source"), "UTF-8")).append("&");
            } catch (Throwable th2222) {
                Log.d("AppLink", th2222.toString());
            }
        }
        return str + stringBuffer.toString();
    }
}
