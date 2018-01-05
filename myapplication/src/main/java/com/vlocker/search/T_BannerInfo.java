package com.vlocker.search;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.vlocker.theme.model.b;
import com.vlocker.theme.model.d;

public class T_BannerInfo implements Parcelable, b {
    public static String h = "_id";
    public static String i = "_url";
    public static String j = "_time";
    public static String k = "_pastime";
    public d a = null;
    public String b = null;
    public String c = null;
    public String d;
    public String e = null;
    public String f;
    public String g = null;
    public Bitmap l = null;
    public Boolean m = Boolean.valueOf(false);
    public int n = 0;
    public int o;
    public String p;
    public String q;
    public String r = null;
    public A_AppItemInfo s = null;
    public int t;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.t);
        parcel.writeTypedList(this.a);
        parcel.writeInt(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.g);
        parcel.writeParcelable(this.l, i);
        parcel.writeString(this.r);
    }
}
