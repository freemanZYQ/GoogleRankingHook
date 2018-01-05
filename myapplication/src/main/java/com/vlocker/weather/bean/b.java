package com.vlocker.weather.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator {
    b() {
    }

    public PromotionAppInfo a(Parcel parcel) {
        return new PromotionAppInfo(parcel);
    }

    public PromotionAppInfo[] a(int i) {
        return new PromotionAppInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
