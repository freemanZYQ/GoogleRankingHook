package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j implements Creator {
    j() {
    }

    public T_SpecialThemePageInfo a(Parcel parcel) {
        return new T_SpecialThemePageInfo(parcel);
    }

    public T_SpecialThemePageInfo[] a(int i) {
        return new T_SpecialThemePageInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
