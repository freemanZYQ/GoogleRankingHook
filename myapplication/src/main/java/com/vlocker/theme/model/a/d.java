package com.vlocker.theme.model.a;

import android.content.Context;
import com.vlocker.theme.b.a;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.i;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d implements i {
    public int a = 1;
    private f b;
    private T_ThemeItemInfo c;
    private c d;
    private Context e;
    private i f = null;
    private a g;
    private a h = new e(this);
    private Boolean i = Boolean.valueOf(true);

    public d(Context context, T_ThemeItemInfo t_ThemeItemInfo, String str, a aVar) {
        String valueOf;
        this.e = context;
        this.g = aVar;
        try {
            this.c = (T_ThemeItemInfo) t_ThemeItemInfo.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Pattern compile = Pattern.compile("[a-zA-Z一-龥][a-zA-Z0-9一-龥]+");
        Matcher matcher = compile.matcher(this.c.b());
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            stringBuffer.append(matcher.group());
        }
        this.c.b(stringBuffer.toString());
        if (this.c.f() != null) {
            Matcher matcher2 = compile.matcher(this.c.f());
            StringBuffer stringBuffer2 = new StringBuffer();
            while (matcher2.find()) {
                stringBuffer2.append(matcher2.group());
            }
            this.c.g(stringBuffer2.toString());
        }
        try {
            this.a = this.c.c();
            if (this.a == 0) {
                this.a = ((HttpURLConnection) new URL(this.c.h()).openConnection()).getContentLength();
            }
            valueOf = String.valueOf(this.a);
        } catch (Exception e2) {
            e2.printStackTrace();
            valueOf = null;
        }
        if (this.a == 0) {
            this.a = 2097152;
        }
        e();
        long intValue = (valueOf == null || valueOf.length() == 0) ? 1 : (long) Integer.valueOf(valueOf).intValue();
        if (intValue != 0) {
        }
    }

    private void a(boolean z) {
        String str = null;
        this.b = f.Downloading;
        String h = this.c.h();
        this.d = new c(e.c(h != null ? h.toString() : null), this, e.a(this.c.b(), this.c.a(), com.vlocker.b.i.j), this.h, this.c);
        h = this.c.a();
        if (h != null) {
            str = h.toString();
        }
        if (!(str == null || str.length() == 0)) {
            this.d.setName(str);
        }
        this.d.start();
    }

    public void a() {
        a(true);
    }

    public void a(long j, long j2, boolean z, T_ThemeItemInfo t_ThemeItemInfo) {
        int i = 100;
        Thread.currentThread().getName();
        long longValue = Long.valueOf(String.valueOf(this.c.c())).longValue();
        if (this.i.booleanValue()) {
            this.c.b(j2);
            this.i = Boolean.valueOf(false);
        }
        int e = (int) ((e() * 100) / longValue);
        if (e <= 100) {
            i = e;
        }
        if (i % 4 == 0 || i < 5) {
            if (this.f != null) {
                this.f.a((long) i, 100, z, this.c);
            }
            Thread.yield();
        }
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public void a(i iVar) {
        this.f = iVar;
    }

    public boolean a(String str) {
        String a = this.c.a();
        String str2 = null;
        if (a != null) {
            str2 = a.toString();
        }
        return str2.equals(str);
    }

    public void b() {
        a(false);
    }

    public f c() {
        return this.b;
    }

    public void d() {
        if (this.d != null && this.d.isAlive()) {
            this.d.a();
        }
    }

    public long e() {
        try {
            File file = new File(e.b(this.c.b(), this.c.a(), com.vlocker.b.i.j));
            return file.exists() ? file.length() : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public a f() {
        return this.g;
    }
}
