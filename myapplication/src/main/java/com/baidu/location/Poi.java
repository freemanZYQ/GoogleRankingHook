package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Poi implements Parcelable {
    public static final Creator CREATOR = new d();
    private final double a;
    private final String b;
    private final String c;

    public Poi(String str, String str2, double d) {
        this.b = str;
        this.c = str2;
        this.a = d;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.b;
    }

    public String getName() {
        return this.c;
    }

    public double getRank() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeDouble(this.a);
    }
}
