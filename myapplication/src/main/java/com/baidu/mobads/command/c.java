package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c implements Creator {
    c() {
    }

    public XAdLandingPageExtraInfo a(Parcel parcel) {
        return new XAdLandingPageExtraInfo(parcel);
    }

    public XAdLandingPageExtraInfo[] a(int i) {
        return new XAdLandingPageExtraInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
