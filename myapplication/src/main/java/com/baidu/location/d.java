package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d implements Creator {
    d() {
    }

    public Poi a(Parcel parcel) {
        return new Poi(parcel.readString(), parcel.readString(), parcel.readDouble());
    }

    public Poi[] a(int i) {
        return new Poi[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
