package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator {
    b() {
    }

    public BDLocation a(Parcel parcel) {
        return new BDLocation(parcel);
    }

    public BDLocation[] a(int i) {
        return new BDLocation[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
