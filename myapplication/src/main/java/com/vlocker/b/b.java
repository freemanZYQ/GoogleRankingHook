package com.vlocker.b;

import android.content.Context;
import com.moxiu.b.a.a;
import com.vlocker.weather.Weather2Activity;
import com.vlocker.weather.bean.PromotionAppInfo;
import com.vlocker.weather.y;

final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;
    final /* synthetic */ y c;

    b(Context context, a aVar, y yVar) {
        this.a = context;
        this.b = aVar;
        this.c = yVar;
    }

    public void run() {
        Weather2Activity.a(this.a, new PromotionAppInfo(this.b), "weather_cover", this.c);
    }
}
