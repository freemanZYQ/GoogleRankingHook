package com.vlocker.update;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vlocker.beans.c;

public class UpdateApkParamBean extends c implements Parcelable {
    public static final Creator CREATOR = new h();
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private String i;
    private boolean j = false;
    private int k = 0;
    private String l;
    private String m;
    private int n;
    private String o;
    private String p;
    private boolean q;
    private int r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;

    public UpdateApkParamBean(Parcel parcel) {
        boolean z = false;
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.r = parcel.readInt();
        this.s = parcel.readString();
        this.t = parcel.readString();
        this.u = parcel.readString();
        try {
            if (parcel.readByte() != (byte) 0) {
                z = true;
            }
            this.q = z;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.g = parcel.readString();
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public String b() {
        return this.d;
    }

    public void b(int i) {
        this.h = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public void b(boolean z) {
        this.q = z;
    }

    public String c() {
        return this.e;
    }

    public void c(int i) {
        this.k = i;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.f;
    }

    public void d(int i) {
        this.n = i;
    }

    public void d(String str) {
        this.g = str;
    }

    public int describeContents() {
        return 0;
    }

    public int e(String str) {
        if (str.equals("manual")) {
            this.k = 1;
        } else if (str.equals("force")) {
            this.k = 2;
        } else if (str.equals("force2")) {
            this.k = 3;
        }
        return this.k;
    }

    public String e() {
        return this.g;
    }

    public void e(int i) {
        this.r = i;
    }

    public int f() {
        return this.k;
    }

    public void f(String str) {
        this.l = str;
    }

    public void g(String str) {
        this.m = str;
    }

    public boolean g() {
        return this.j;
    }

    public String h() {
        return this.l;
    }

    public void h(String str) {
        this.o = str;
    }

    public String i() {
        return this.m;
    }

    public void i(String str) {
        this.p = str;
    }

    public int j() {
        return this.n;
    }

    public void j(String str) {
        this.x = str;
    }

    public String k() {
        return this.o;
    }

    public void k(String str) {
        this.w = str;
    }

    public String l() {
        return this.p;
    }

    public void l(String str) {
        this.y = str;
    }

    public void m(String str) {
        this.t = str;
    }

    public boolean m() {
        return this.q;
    }

    public int n() {
        return this.r;
    }

    public void n(String str) {
        this.u = str;
    }

    public String o() {
        return this.y;
    }

    public void o(String str) {
        this.v = str;
    }

    public String p() {
        return this.v;
    }

    public void p(String str) {
        this.c = str;
    }

    public String q() {
        return this.c;
    }

    public void q(String str) {
        this.b = str;
    }

    public String r() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeInt(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeInt(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeByte((byte) (this.q ? 1 : 0));
        parcel.writeString(this.g);
    }
}
