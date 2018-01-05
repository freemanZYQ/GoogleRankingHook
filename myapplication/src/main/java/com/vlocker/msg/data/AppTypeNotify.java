package com.vlocker.msg.data;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public class AppTypeNotify implements Parcelable {
    private int a = 0;
    private String b;
    private String c;
    private long d = 0;
    private boolean e;
    private int f = 0;
    private PendingIntent g = null;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        if (this.g != null) {
            parcel.writeInt(1);
            this.g.writeToParcel(parcel, i);
            return;
        }
        parcel.writeInt(0);
    }
}
