package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.x;
import com.tencent.wxop.stat.y;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends d {
    protected b a = new b();
    private long m = -1;

    public a(Context context, int i, String str, y yVar) {
        super(context, i, yVar);
        this.a.a = str;
    }

    public final b a() {
        return this.a;
    }

    public final boolean a(JSONObject jSONObject) {
        jSONObject.put("ei", this.a.a);
        if (this.m > 0) {
            jSONObject.put("du", this.m);
        }
        if (this.a.b == null) {
            if (this.a.a != null) {
                Map a = x.a(this.a.a);
                if (a != null && a.size() > 0) {
                    if (this.a.c == null || this.a.c.length() == 0) {
                        this.a.c = new JSONObject(a);
                    } else {
                        for (Entry entry : a.entrySet()) {
                            try {
                                this.a.c.put(entry.getKey().toString(), entry.getValue());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            jSONObject.put("kv", this.a.c);
        } else {
            jSONObject.put("ar", this.a.b);
        }
        return true;
    }

    public final e b() {
        return e.CUSTOM;
    }
}
