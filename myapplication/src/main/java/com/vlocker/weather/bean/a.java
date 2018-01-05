package com.vlocker.weather.bean;

import java.util.Comparator;

class a implements Comparator {
    final /* synthetic */ MXWeatherBean a;

    a(MXWeatherBean mXWeatherBean) {
        this.a = mXWeatherBean;
    }

    public int a(MXOneDayWeatherBean mXOneDayWeatherBean, MXOneDayWeatherBean mXOneDayWeatherBean2) {
        return mXOneDayWeatherBean.a <= mXOneDayWeatherBean2.a ? -1 : 1;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((MXOneDayWeatherBean) obj, (MXOneDayWeatherBean) obj2);
    }
}
