package com.baidu.mobads.h;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f implements Creator {
    f() {
    }

    public e a(Parcel parcel) {
        return new e(parcel);
    }

    public e[] a(int i) {
        return new e[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
