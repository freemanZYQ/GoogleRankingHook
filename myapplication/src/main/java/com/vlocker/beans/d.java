package com.vlocker.beans;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d implements Creator {
    d() {
    }

    public ThemeItemInfo a(Parcel parcel) {
        return new ThemeItemInfo(parcel);
    }

    public ThemeItemInfo[] a(int i) {
        return new ThemeItemInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
