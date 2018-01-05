package com.vlocker.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ae implements Creator {
    ae() {
    }

    public M_bd_BaiduNewsInfo a(Parcel parcel) {
        return new M_bd_BaiduNewsInfo(parcel);
    }

    public M_bd_BaiduNewsInfo[] a(int i) {
        return new M_bd_BaiduNewsInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
