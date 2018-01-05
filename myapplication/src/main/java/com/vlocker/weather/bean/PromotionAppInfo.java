package com.vlocker.weather.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.moxiu.b.a.a;

public class PromotionAppInfo implements Parcelable {
    public static final Creator CREATOR = new b();
    public String a;
    public String b;
    public String c;
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
    public String o;
    public String p;
    public String q;
    public int r;
    public String s;
    public String[] t;
    public boolean u;
    public String[] v;
    public String w;
    public String x;
    public String y;
    public int z = 0;

    public PromotionAppInfo(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.o = parcel.readString();
        this.n = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readInt();
        this.s = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.t = new String[readInt];
            parcel.readStringArray(this.t);
        }
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.u = z;
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            this.v = new String[readInt2];
            parcel.readStringArray(this.v);
        }
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.y = parcel.readString();
    }

    public PromotionAppInfo(a aVar) {
        this.d = aVar.c();
        this.w = aVar.C;
        this.b = aVar.b();
        this.a = aVar.h();
        this.x = aVar.d();
        this.s = aVar.j();
        this.y = aVar.k();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PromotionAppInfo [title=" + this.a + ", iconUrl=" + this.b + ", packageName=" + this.c + ", describe=" + this.d + ", weburl=" + this.e + ", apkurl=" + this.f + ", marketuri=" + this.g + ", openType=" + this.h + ", sourceType=" + this.i + ", appId=" + this.j + ", channelId=" + this.k + ", apkId=" + this.l + ", dataAnalysisId=" + this.m + ", versionCode=" + this.n + ", recommendId=" + this.o + ", tagInfo=" + this.p + ", fileSize=" + this.q + ", source=" + this.r + ", downloadNum = " + this.s + ", screenshot count = " + this.t.length + ", offcial = " + this.u + ", sourceName = " + this.w + ", appuri = " + this.x + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.o);
        parcel.writeString(this.n);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeInt(this.r);
        parcel.writeString(this.s);
        if (this.t == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.t.length);
        }
        if (this.t != null) {
            parcel.writeStringArray(this.t);
        }
        parcel.writeInt(this.u ? 1 : 0);
        if (this.v == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.v.length);
        }
        if (this.v != null) {
            parcel.writeStringArray(this.v);
        }
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
    }
}
