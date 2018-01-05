package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i implements Creator {
    i() {
    }

    public T_SpecialThemeInfo a(Parcel parcel) {
        return new T_SpecialThemeInfo(parcel);
    }

    public T_SpecialThemeInfo[] a(int i) {
        return new T_SpecialThemeInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
