package com.alimama.ad.mobile.b;

import android.text.TextUtils;
import java.util.HashMap;

public class a {
    protected HashMap a = new HashMap();
    protected HashMap b = new HashMap();
    protected HashMap c = new HashMap();

    public int a(String str) {
        return (TextUtils.isEmpty(str) || this.a == null || !this.a.containsKey(str)) ? -1 : ((Integer) this.a.get(str)).intValue();
    }

    public void a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.a.put(str, Integer.valueOf(i));
        }
    }

    public void a(String str, Object obj) {
        this.c.put(str, obj);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.b.put(str, str2);
        }
    }

    public String b(String str) {
        return (TextUtils.isEmpty(str) || this.b == null || !this.b.containsKey(str)) ? null : (String) this.b.get(str);
    }

    public Object c(String str) {
        return (TextUtils.isEmpty(str) || this.c == null || !this.c.containsKey(str)) ? null : this.c.get(str);
    }
}
