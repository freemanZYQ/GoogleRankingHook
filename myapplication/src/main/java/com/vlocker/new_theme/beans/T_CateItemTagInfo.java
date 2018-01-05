package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vlocker.theme.model.c;

public class T_CateItemTagInfo extends c implements Parcelable {
    public static final Creator CREATOR = new d();
    public String a;
    public String b;

    public T_CateItemTagInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
