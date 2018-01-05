package com.vlocker.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ThemeItemInfo extends a implements Parcelable {
    public static final Creator CREATOR = new d();
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
    public Boolean q = null;
    public int r = 0;
    public String s = null;
    public String t = null;
    public String u = null;

    public ThemeItemInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.r = parcel.readInt();
        this.s = parcel.readString();
        this.t = parcel.readString();
        this.u = parcel.readString();
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.i = str;
    }

    public Object clone() {
        ThemeItemInfo themeItemInfo = new ThemeItemInfo();
        themeItemInfo.a = this.a;
        themeItemInfo.b = this.b;
        themeItemInfo.c = this.c;
        themeItemInfo.d = this.d;
        themeItemInfo.e = this.e;
        themeItemInfo.f = this.f;
        themeItemInfo.g = this.g;
        themeItemInfo.h = this.h;
        themeItemInfo.i = this.i;
        themeItemInfo.j = this.j;
        themeItemInfo.k = this.k;
        themeItemInfo.l = this.l;
        themeItemInfo.m = this.m;
        themeItemInfo.n = this.n;
        themeItemInfo.o = this.o;
        themeItemInfo.p = this.p;
        themeItemInfo.r = this.r;
        themeItemInfo.s = this.s;
        themeItemInfo.t = this.t;
        themeItemInfo.u = this.u;
        return themeItemInfo;
    }

    public int describeContents() {
        return 0;
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
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeInt(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
    }
}
