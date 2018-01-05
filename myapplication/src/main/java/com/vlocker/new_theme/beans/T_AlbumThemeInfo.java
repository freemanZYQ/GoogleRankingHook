package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vlocker.theme.model.c;

public class T_AlbumThemeInfo extends c implements Parcelable {
    public static final Creator CREATOR = new a();
    public String a;
    public String b;
    public String c;
    public long d;
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;
    public int j;
    public String k;

    public T_AlbumThemeInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readLong();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readString();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.f;
    }

    public String c() {
        return this.k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
    }
}
