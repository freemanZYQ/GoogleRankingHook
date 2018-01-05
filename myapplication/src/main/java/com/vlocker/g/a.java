package com.vlocker.g;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class a {
    public List a = new ArrayList();
    public String b;
    public String c;
    public Bitmap d;
    public boolean e = false;
    public String f;
    public String g;
    public String h;
    public String i;
    public Bitmap j;
    public Bitmap k;
    public String l = "";
    public String m = "";
    public String n;
    public String o;
    public boolean p;
    public String q;
    public Bitmap r;
    public Intent s;
    public String t = "";
    public String u;
    public String v;
    public boolean w;
    public String x;
    public long y = 0;
    public long z = Long.MAX_VALUE;

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.z = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
