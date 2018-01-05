package com.vlocker.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vlocker.theme.model.b;

public class M_bd_BaiduNewsInfo implements Parcelable, b {
    public static final Creator CREATOR = new ae();
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;

    public M_bd_BaiduNewsInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.g = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
    }

    public String a() {
        return this.b;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.d;
    }

    public void b(int i) {
        this.f = i;
    }

    public void b(String str) {
        this.d = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.g);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
    }
}
