package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vlocker.theme.model.b;
import com.vlocker.theme.model.d;

public class T_CateInfo implements Parcelable, b {
    public static final Creator CREATOR = new c();
    public d a = null;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l;

    public T_CateInfo(Parcel parcel) {
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.a = new d();
        parcel.readTypedList(this.a, T_CateItemTagInfo.CREATOR);
    }

    public String a() {
        return this.c;
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(d dVar) {
        this.a = dVar;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.d;
    }

    public void b(int i) {
        this.l = i;
    }

    public void b(String str) {
        this.d = str;
    }

    public String c() {
        return this.g;
    }

    public void c(String str) {
        this.e = str;
    }

    public Object clone() {
        T_CateInfo t_CateInfo = new T_CateInfo();
        t_CateInfo.b = this.b;
        t_CateInfo.c = this.c;
        t_CateInfo.d = this.d;
        t_CateInfo.e = this.e;
        t_CateInfo.f = this.f;
        t_CateInfo.g = this.g;
        t_CateInfo.h = this.h;
        t_CateInfo.i = this.i;
        t_CateInfo.j = this.j;
        t_CateInfo.k = this.k;
        t_CateInfo.l = this.l;
        t_CateInfo.a = this.a;
        return t_CateInfo;
    }

    public String d() {
        return this.h;
    }

    public void d(String str) {
        this.f = str;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.i;
    }

    public void e(String str) {
        this.g = str;
    }

    public String f() {
        return this.j;
    }

    public void f(String str) {
        this.h = str;
    }

    public int g() {
        return this.l;
    }

    public void g(String str) {
        this.i = str;
    }

    public void h(String str) {
        this.j = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.d);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeTypedList(this.a);
    }
}
