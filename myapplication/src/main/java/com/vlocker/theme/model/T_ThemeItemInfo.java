package com.vlocker.theme.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class T_ThemeItemInfo extends c implements Parcelable {
    public static final Creator CREATOR = new f();
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public int E = 0;
    public d F = null;
    private int G;
    private int H;
    public String a = null;
    public String b = null;
    public String c = null;
    public String d = null;
    public String e = null;
    public int f;
    public int g = 0;
    public int h = 0;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public String m = null;
    public String n = null;
    public String o = null;
    public String p = null;
    public String q = null;
    public boolean r = false;
    public int s = 0;
    public Boolean t = null;
    public int u = 0;
    public String v = null;
    public String w = null;
    public String x = null;
    public int y = 0;
    public String z = null;

    public T_ThemeItemInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.G = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.u = parcel.readInt();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.y = parcel.readInt();
        this.z = parcel.readString();
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.E = parcel.readInt();
        this.H = parcel.readInt();
        this.F = new d();
        parcel.readTypedList(this.F, T_ThemePreviewParserInfo.CREATOR);
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.H = i;
    }

    public void a(d dVar) {
        this.F = dVar;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.G = i;
    }

    public void b(String str) {
        this.b = str;
    }

    public int c() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public void c(String str) {
        this.c = str;
    }

    public Object clone() {
        T_ThemeItemInfo t_ThemeItemInfo = new T_ThemeItemInfo();
        t_ThemeItemInfo.a = this.a;
        t_ThemeItemInfo.b = this.b;
        t_ThemeItemInfo.c = this.c;
        t_ThemeItemInfo.d = this.d;
        t_ThemeItemInfo.e = this.e;
        t_ThemeItemInfo.f = this.f;
        t_ThemeItemInfo.g = this.g;
        t_ThemeItemInfo.h = this.h;
        t_ThemeItemInfo.i = this.i;
        t_ThemeItemInfo.j = this.j;
        t_ThemeItemInfo.k = this.k;
        t_ThemeItemInfo.l = this.l;
        t_ThemeItemInfo.n = this.n;
        t_ThemeItemInfo.o = this.o;
        t_ThemeItemInfo.p = this.p;
        t_ThemeItemInfo.q = this.q;
        t_ThemeItemInfo.u = this.u;
        t_ThemeItemInfo.v = this.v;
        t_ThemeItemInfo.w = this.w;
        t_ThemeItemInfo.x = this.x;
        t_ThemeItemInfo.y = this.y;
        t_ThemeItemInfo.z = this.z;
        t_ThemeItemInfo.A = this.A;
        t_ThemeItemInfo.B = this.B;
        t_ThemeItemInfo.C = this.C;
        t_ThemeItemInfo.E = this.E;
        t_ThemeItemInfo.G = this.G;
        t_ThemeItemInfo.H = this.H;
        t_ThemeItemInfo.F = this.F;
        t_ThemeItemInfo.r = this.r;
        t_ThemeItemInfo.s = this.s;
        return t_ThemeItemInfo;
    }

    public int d() {
        return this.g;
    }

    public void d(int i) {
        this.g = i;
    }

    public void d(String str) {
        this.d = str;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.h;
    }

    public void e(int i) {
        this.h = i;
    }

    public void e(String str) {
        this.e = str;
    }

    public String f() {
        return this.p;
    }

    public void f(int i) {
        this.y = i;
    }

    public void f(String str) {
        this.o = str;
    }

    public String g() {
        return this.j;
    }

    public void g(int i) {
        this.E = i;
    }

    public void g(String str) {
        this.p = str;
    }

    public String h() {
        return this.n;
    }

    public void h(String str) {
        this.q = str;
    }

    public int i() {
        return this.s;
    }

    public void i(String str) {
        this.j = str;
    }

    public d j() {
        if (this.F == null) {
            T_ThemePreviewParserInfo t_ThemePreviewParserInfo = new T_ThemePreviewParserInfo();
            t_ThemePreviewParserInfo.a(this.k);
            this.F.add(t_ThemePreviewParserInfo);
            t_ThemePreviewParserInfo.a(this.l);
            this.F.add(t_ThemePreviewParserInfo);
        }
        return this.F;
    }

    public void j(String str) {
        this.k = str;
    }

    public void k(String str) {
        this.l = str;
    }

    public void l(String str) {
        this.n = str;
    }

    public void m(String str) {
        this.z = str;
    }

    public void n(String str) {
        this.A = str;
    }

    public void o(String str) {
        this.B = str;
    }

    public void p(String str) {
        this.C = str;
    }

    public String toString() {
        return "T_ThemeItemInfo [cateid=" + this.a + ", name=" + this.b + ", tag=" + this.c + ", description=" + this.d + ", packageName=" + this.e + ", size=" + this.f + ", rate=" + this.g + ", down=" + this.h + ", dynamic=" + this.i + ", thumbUrl=" + this.j + ", spicMainUrl=" + this.k + ", bpicSecondUrl=" + this.l + ", tpicThreeUrl=" + this.m + ", loadItemUrl=" + this.n + ", related=" + this.o + ", writer=" + this.p + ", realse=" + this.q + ", isCollect=" + this.t + ", mood=" + this.u + ", moodId=" + this.v + ", content=" + this.w + ", time=" + this.x + ", themeRecommend=" + this.y + ", eventTitle=" + this.z + ", eventImageUrl=" + this.A + ", eventWebUrl=" + this.B + ", themeOrgin=" + this.C + ", title=" + this.D + ", dig=" + this.E + ", themePreviewGroup=" + this.F + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.G);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeInt(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeInt(this.y);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeInt(this.E);
        parcel.writeInt(this.H);
        parcel.writeTypedList(this.F);
    }
}
