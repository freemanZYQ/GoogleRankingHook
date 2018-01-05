package com.vlocker.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vlocker.theme.model.b;
import com.vlocker.theme.model.d;

public class BaseModel implements Parcelable, b {
    public static final Creator CREATOR = new q();
    private String a;
    private String b;
    private d c;
    private String d;
    private String e;
    private int f;
    private int g;

    public BaseModel(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (d) parcel.readArrayList(d.class.getClassLoader());
        this.d = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.a);
        parcel.writeList(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.e);
    }
}
