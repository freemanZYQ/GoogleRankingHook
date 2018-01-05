package com.vlocker.weather.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;

public class MXWeatherBean implements Parcelable {
    public ArrayList a = new ArrayList();
    public String b;
    public String c;
    public String d;
    public String e;

    public void a() {
        Collections.sort(this.a, new a(this));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.e);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeList(this.a);
    }
}
