package com.vlocker.msg;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class at implements Creator {
    at() {
    }

    public VlockerMsg a(Parcel parcel) {
        return new VlockerMsg(parcel);
    }

    public VlockerMsg[] a(int i) {
        return new VlockerMsg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
