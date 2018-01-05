package com.vlocker.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vlocker.locker.d.n;

public class A_AppItemInfo implements Parcelable, n {
    public static final Creator CREATOR = new a();
    private String A;
    private String B;
    private String C;
    private int D;
    private String E;
    public String a = null;
    public String b = null;
    public String c = "";
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
    public String n;
    public Boolean o = Boolean.valueOf(true);
    public int p = 0;
    public String q = null;
    public int r = 0;
    public int s;
    public int t = 0;
    public String u = "";
    public int v = 0;
    public boolean w = true;
    public boolean x = false;
    public boolean y = false;
    private String z = null;

    public A_AppItemInfo(Parcel parcel) {
        this.z = parcel.readString();
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
        this.A = parcel.readString();
        this.p = parcel.readInt();
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.n = parcel.readString();
        this.D = parcel.readInt();
        this.q = parcel.readString();
        this.E = parcel.readString();
        this.s = parcel.readInt();
    }

    public Object clone() {
        A_AppItemInfo a_AppItemInfo = new A_AppItemInfo();
        a_AppItemInfo.z = this.z;
        a_AppItemInfo.a = this.a;
        a_AppItemInfo.b = this.b;
        a_AppItemInfo.c = this.c;
        a_AppItemInfo.d = this.d;
        a_AppItemInfo.e = this.e;
        a_AppItemInfo.f = this.f;
        a_AppItemInfo.g = this.g;
        a_AppItemInfo.h = this.h;
        a_AppItemInfo.i = this.i;
        a_AppItemInfo.j = this.j;
        a_AppItemInfo.k = this.k;
        a_AppItemInfo.l = this.l;
        a_AppItemInfo.m = this.m;
        a_AppItemInfo.A = this.A;
        a_AppItemInfo.p = this.p;
        a_AppItemInfo.q = this.q;
        a_AppItemInfo.B = this.B;
        a_AppItemInfo.C = this.C;
        a_AppItemInfo.n = this.n;
        a_AppItemInfo.D = this.D;
        a_AppItemInfo.E = this.E;
        a_AppItemInfo.s = this.s;
        return a_AppItemInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.z);
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
        parcel.writeString(this.A);
        parcel.writeInt(this.p);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeString(this.n);
        parcel.writeInt(this.D);
        parcel.writeString(this.q);
        parcel.writeString(this.E);
        parcel.writeInt(this.s);
    }
}
