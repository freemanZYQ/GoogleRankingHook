package com.vlocker.new_theme.beans;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator {
    b() {
    }

    public T_AlbumThemePageInfo a(Parcel parcel) {
        return new T_AlbumThemePageInfo(parcel);
    }

    public T_AlbumThemePageInfo[] a(int i) {
        return new T_AlbumThemePageInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
