package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator {
    a() {
    }

    public T_AlbumThemeInfo a(Parcel parcel) {
        return new T_AlbumThemeInfo(parcel);
    }

    public T_AlbumThemeInfo[] a(int i) {
        return new T_AlbumThemeInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
