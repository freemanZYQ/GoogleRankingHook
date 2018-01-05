package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c implements Creator {
    c() {
    }

    public T_CateInfo a(Parcel parcel) {
        return new T_CateInfo(parcel);
    }

    public T_CateInfo[] a(int i) {
        return new T_CateInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
