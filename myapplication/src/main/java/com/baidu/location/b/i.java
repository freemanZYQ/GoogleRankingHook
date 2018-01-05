package com.baidu.location.b;

import com.baidu.location.e.d;
import com.baidu.location.h.c;
import com.baidu.location.h.f;
import java.util.Locale;

public class i {
    private long a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private int e = 0;
    private String f = null;
    private String g = null;
    private String h = null;

    public void a() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public void a(long j) {
        this.a = j;
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(boolean z) {
        if (z) {
            this.e = 1;
        } else {
            this.e = 0;
        }
    }

    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        if (f.a().g()) {
            this.f = "&cn=32";
        } else {
            this.f = String.format(Locale.CHINA, "&cn=%d", new Object[]{Integer.valueOf(c.a().e())});
        }
        stringBuffer.append(this.f);
        stringBuffer.append(String.format(Locale.CHINA, "&fir=%d&tim=%d&dsc=%d&det=%d&ded=%d&typ=%s", new Object[]{Integer.valueOf(this.e), Long.valueOf(this.a), Long.valueOf(this.b - this.a), Long.valueOf(this.c - this.b), Long.valueOf(this.d - this.c), this.g}));
        if (this.h != null) {
            stringBuffer.append(this.h);
        }
        stringBuffer.append(b.a().a(false));
        stringBuffer.append(d.a().c());
        return stringBuffer.toString();
    }

    public void b(long j) {
        this.b = j;
    }

    public void b(String str) {
        if (this.h == null) {
            this.h = str;
            return;
        }
        this.h = String.format("%s%s", new Object[]{this.h, str});
    }

    public void c(long j) {
        this.c = j;
    }

    public void d(long j) {
        this.d = j;
    }
}
