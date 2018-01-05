package com.vlocker.msg.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class d {
    private ArrayList a;
    private ArrayList b;

    public d a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(str);
        }
        return this;
    }

    public boolean b(String str) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public d c(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(str);
        }
        return this;
    }

    public boolean d(String str) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
