package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vlocker.theme.model.c;

public class T_SpecialThemeInfo extends c implements Parcelable {
    public static final Creator CREATOR = new i();
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;
    public String g;

    public T_SpecialThemeInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readLong();
        this.f = parcel.readInt();
        this.g = parcel.readString();
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.e;
    }

    public void e(String str) {
        this.g = str;
    }

    public String f() {
        return this.g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
    }
}
