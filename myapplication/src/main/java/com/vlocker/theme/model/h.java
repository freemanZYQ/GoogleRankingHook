package com.vlocker.theme.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h implements Creator {
    h() {
    }

    public T_ThemePreviewParserInfo a(Parcel parcel) {
        return new T_ThemePreviewParserInfo(parcel);
    }

    public T_ThemePreviewParserInfo[] a(int i) {
        return new T_ThemePreviewParserInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
