package com.vlocker.weather.b;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

class e implements BDLocationListener {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public void onReceiveLocation(BDLocation bDLocation) {
        if (bDLocation != null) {
            this.a.a(bDLocation, 1);
            this.a.d();
        }
    }
}
