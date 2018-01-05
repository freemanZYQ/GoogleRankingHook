package com.vlocker.model;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class c {
    private static c e = null;
    private StringBuffer a = new StringBuffer();
    private List b = new ArrayList();
    private Properties c = new Properties();
    private boolean d = false;

    public c(Context context) {
        b(context);
    }

    public static c a(Context context) {
        if (e == null) {
            e = new c(context);
        }
        return e;
    }

    private void a(int i, String str) {
        if (i == str.length()) {
            if (!this.b.contains(this.a.toString())) {
                this.b.add(this.a.toString());
                return;
            }
            return;
        }
        char charAt = str.charAt(i);
        if ('〇' == charAt || ('一' <= charAt && charAt <= '龥')) {
            String[] a = a(charAt);
            if (a == null) {
                this.a.append(charAt);
                a(i + 1, str);
                return;
            } else if (a.length == 0) {
                this.a.append(charAt);
                a(i + 1, str);
                return;
            } else if (a.length == 1) {
                if (!this.d) {
                    this.a.append(a[0]);
                } else if (!"".equals(a[0])) {
                    this.a.append(a[0].charAt(0));
                }
                a(i + 1, str);
                return;
            } else {
                for (int i2 = 0; i2 < a.length; i2++) {
                    int length = this.a.length();
                    if (!this.d) {
                        this.a.append(a[i2]);
                    } else if (!"".equals(a[i2])) {
                        this.a.append(a[i2].charAt(0));
                    }
                    a(i + 1, str);
                    this.a.delete(length, this.a.length());
                }
                return;
            }
        }
        this.a.append(charAt);
        a(i + 1, str);
    }

    public List a(String str, boolean z) {
        if (str == null || "".equals(str)) {
            return null;
        }
        this.d = z;
        this.b.clear();
        this.a.delete(0, this.a.length());
        a(0, str);
        return this.b;
    }

    public String[] a(char c) {
        return ((String) this.c.get(Integer.toHexString(c).toUpperCase())).split(",");
    }

    public void b(Context context) {
        try {
            this.c.load(new BufferedInputStream(context.getAssets().open("hanyu_pinyin.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
