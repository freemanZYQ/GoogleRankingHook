package com.vlocker.theme.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class T_ThemeListPageInfo implements Parcelable, b {
    public static final Creator CREATOR = new g();
    public d a = null;
    public String b = null;
    public String c = null;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public T_ThemeItemInfo o;
    public String p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public int u = 0;
    public d v = null;

    public T_ThemeListPageInfo(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.u = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.v = new d();
        parcel.readTypedList(this.v, T_SearchOrderInfo.CREATOR);
    }

    public String a() {
        return this.n;
    }

    public void a(int i) {
        this.q = i;
    }

    public void a(T_ThemeItemInfo t_ThemeItemInfo) {
        this.o = t_ThemeItemInfo;
    }

    public void a(d dVar) {
        this.v = dVar;
    }

    public void a(String str) {
        this.n = str;
    }

    public void a(boolean z) {
        this.t = z;
    }

    public T_ThemeItemInfo b() {
        return this.o;
    }

    public void b(int i) {
        this.r = i;
    }

    public void b(d dVar) {
        this.a = dVar;
    }

    public void b(String str) {
        this.p = str;
    }

    public String c() {
        return this.p;
    }

    public void c(int i) {
        this.s = i;
    }

    public void c(String str) {
        this.e = str;
    }

    public Object clone() {
        T_ThemeListPageInfo t_ThemeListPageInfo = new T_ThemeListPageInfo();
        t_ThemeListPageInfo.b = this.b;
        t_ThemeListPageInfo.c = this.c;
        t_ThemeListPageInfo.d = this.d;
        t_ThemeListPageInfo.q = this.q;
        t_ThemeListPageInfo.r = this.r;
        t_ThemeListPageInfo.s = this.s;
        t_ThemeListPageInfo.t = this.t;
        t_ThemeListPageInfo.u = this.u;
        t_ThemeListPageInfo.v = this.v;
        t_ThemeListPageInfo.f = this.f;
        t_ThemeListPageInfo.g = this.g;
        t_ThemeListPageInfo.h = this.h;
        t_ThemeListPageInfo.i = this.i;
        t_ThemeListPageInfo.j = this.j;
        t_ThemeListPageInfo.k = this.k;
        t_ThemeListPageInfo.l = this.l;
        t_ThemeListPageInfo.m = this.m;
        return t_ThemeListPageInfo;
    }

    public String d() {
        return this.e;
    }

    public void d(int i) {
        this.u = i;
    }

    public void d(String str) {
        this.j = str;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.j;
    }

    public void e(String str) {
        this.k = str;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.b = str;
    }

    public d g() {
        return this.v;
    }

    public void g(String str) {
        this.c = str;
    }

    public d h() {
        return this.a;
    }

    public String i() {
        return this.c;
    }

    public int j() {
        return this.s;
    }

    public boolean k() {
        return this.t;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.m);
        parcel.writeString(this.l);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.u);
        parcel.writeTypedList(this.v);
    }
}
