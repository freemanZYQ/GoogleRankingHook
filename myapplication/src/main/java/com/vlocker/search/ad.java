package com.vlocker.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ad implements Creator {
    ad() {
    }

    public M_bd_BaiduHintsInfo a(Parcel parcel) {
        return new M_bd_BaiduHintsInfo(parcel);
    }

    public M_bd_BaiduHintsInfo[] a(int i) {
        return new M_bd_BaiduHintsInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
