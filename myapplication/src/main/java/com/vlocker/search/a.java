package com.vlocker.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator {
    a() {
    }

    public A_AppItemInfo a(Parcel parcel) {
        return new A_AppItemInfo(parcel);
    }

    public A_AppItemInfo[] a(int i) {
        return new A_AppItemInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
