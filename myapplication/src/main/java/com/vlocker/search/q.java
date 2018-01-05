package com.vlocker.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class q implements Creator {
    q() {
    }

    public BaseModel a(Parcel parcel) {
        return new BaseModel(parcel);
    }

    public BaseModel[] a(int i) {
        return new BaseModel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
