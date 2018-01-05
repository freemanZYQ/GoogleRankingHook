package com.tencent.open.a;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class b {
    private static SimpleDateFormat a = h.a("yy.MM.dd.HH");
    private String b = "Tracer.File";
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = 4096;
    private long f = 10000;
    private File g;
    private int h = 10;
    private String i = ".log";
    private long j = Long.MAX_VALUE;

    public b(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        a(file);
        b(i);
        a(i2);
        c(i3);
        a(str);
        a(j);
        d(i4);
        b(str2);
        b(j2);
    }

    private File c(long j) {
        File b = b();
        String str = "";
        try {
            return new File(b, c(d(j)));
        } catch (Throwable th) {
            th.printStackTrace();
            return b;
        }
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private String d(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return new SimpleDateFormat("yy.MM.dd.HH").format(instance.getTime());
    }

    public File a() {
        return c(System.currentTimeMillis());
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(File file) {
        this.g = file;
    }

    public void a(String str) {
        this.b = str;
    }

    public File b() {
        File e = e();
        e.mkdirs();
        return e;
    }

    public void b(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.j = j;
    }

    public void b(String str) {
        this.i = str;
    }

    public String c() {
        return this.b;
    }

    public void c(int i) {
        this.e = i;
    }

    public int d() {
        return this.e;
    }

    public void d(int i) {
        this.h = i;
    }

    public File e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }
}
