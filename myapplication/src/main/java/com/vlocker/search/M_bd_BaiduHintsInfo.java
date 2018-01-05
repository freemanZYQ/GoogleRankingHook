package com.vlocker.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class M_bd_BaiduHintsInfo implements Parcelable {
    public static final Creator CREATOR = new ad();
    public static String a = "_id";
    public static String b = "_keyworld";
    public int c;
    public String d;
    public String e;
    public String f;

    public M_bd_BaiduHintsInfo(Parcel parcel) {
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public String b() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }
}
