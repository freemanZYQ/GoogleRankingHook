package com.vlocker.theme.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e implements Creator {
    e() {
    }

    public T_SearchOrderInfo a(Parcel parcel) {
        return new T_SearchOrderInfo(parcel);
    }

    public T_SearchOrderInfo[] a(int i) {
        return new T_SearchOrderInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
