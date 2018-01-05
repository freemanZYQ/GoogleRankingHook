package com.vlocker.update;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h implements Creator {
    h() {
    }

    public UpdateApkParamBean a(Parcel parcel) {
        return new UpdateApkParamBean(parcel);
    }

    public UpdateApkParamBean[] a(int i) {
        return new UpdateApkParamBean[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
