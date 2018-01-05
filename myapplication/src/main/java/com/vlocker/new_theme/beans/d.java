package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d implements Creator {
    d() {
    }

    public T_CateItemTagInfo a(Parcel parcel) {
        return new T_CateItemTagInfo(parcel);
    }

    public T_CateItemTagInfo[] a(int i) {
        return new T_CateItemTagInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
