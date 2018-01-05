package com.vlocker.theme.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class T_ThemePreviewParserInfo extends c implements Parcelable {
    public static final Creator CREATOR = new h();
    public String a;

    public T_ThemePreviewParserInfo(Parcel parcel) {
        this.a = parcel.readString();
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
    }
}
