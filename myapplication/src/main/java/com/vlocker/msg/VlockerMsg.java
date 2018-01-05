package com.vlocker.msg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class VlockerMsg implements Parcelable, Serializable {
    public static final Creator CREATOR = new at();
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;

    public VlockerMsg(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public void e(int i) {
        this.e = i;
    }

    public int f() {
        return this.f;
    }

    public void f(int i) {
        this.g = i;
    }

    public int g() {
        return this.g;
    }

    public void g(int i) {
        this.h = i;
    }

    public int h() {
        return this.h;
    }

    public void h(int i) {
        this.i = i;
    }

    public int i() {
        return this.i;
    }

    public void i(int i) {
        this.j = i;
    }

    public int j() {
        return this.j;
    }

    public void j(int i) {
        this.k = i;
    }

    public int k() {
        return this.k;
    }

    public void k(int i) {
        this.l = i;
    }

    public int l() {
        return this.l;
    }

    public void l(int i) {
        this.m = i;
    }

    public int m() {
        return this.m;
    }

    public void m(int i) {
        this.n = i;
    }

    public int n() {
        return this.n;
    }

    public void n(int i) {
        this.o = i;
    }

    public int o() {
        return this.o;
    }

    public String toString() {
        return "VlockerMsg{push=" + this.a + ", msgAd=" + this.b + ", batteryAd=" + this.c + ", batteryClean=" + this.d + ", repair=" + this.e + ", finger=" + this.f + ", weather=" + this.g + ", information=" + this.h + ", redPacket=" + this.i + ", qq=" + this.j + ", weChat=" + this.k + ", weibo=" + this.l + ", qzone=" + this.m + ", momo=" + this.n + ", other=" + this.o + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
    }
}
