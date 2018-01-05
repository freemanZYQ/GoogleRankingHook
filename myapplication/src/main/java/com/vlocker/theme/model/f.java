package com.vlocker.theme.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f implements Creator {
    f() {
    }

    public T_ThemeItemInfo a(Parcel parcel) {
        return new T_ThemeItemInfo(parcel);
    }

    public T_ThemeItemInfo[] a(int i) {
        return new T_ThemeItemInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
