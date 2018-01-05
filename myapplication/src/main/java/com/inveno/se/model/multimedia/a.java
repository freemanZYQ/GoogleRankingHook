package com.inveno.se.model.multimedia;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator {
    a() {
    }

    public Imgs a(Parcel parcel) {
        return new Imgs(parcel);
    }

    public Imgs[] a(int i) {
        return new Imgs[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
