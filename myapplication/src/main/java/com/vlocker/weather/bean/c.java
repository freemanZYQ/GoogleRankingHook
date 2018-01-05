package com.vlocker.weather.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c implements Creator {
    c() {
    }

    public WeatherWidgetBean a(Parcel parcel) {
        return new WeatherWidgetBean(parcel);
    }

    public WeatherWidgetBean[] a(int i) {
        return new WeatherWidgetBean[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
