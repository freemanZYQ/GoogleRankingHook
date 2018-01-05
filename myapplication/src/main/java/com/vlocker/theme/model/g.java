package com.vlocker.theme.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g implements Creator {
    g() {
    }

    public T_ThemeListPageInfo a(Parcel parcel) {
        return new T_ThemeListPageInfo(parcel);
    }

    public T_ThemeListPageInfo[] a(int i) {
        return new T_ThemeListPageInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
