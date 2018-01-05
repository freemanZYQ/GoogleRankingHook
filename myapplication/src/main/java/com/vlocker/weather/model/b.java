package com.vlocker.weather.model;

class b implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ MXWeatherWidget b;

    b(MXWeatherWidget mXWeatherWidget, f fVar) {
        this.b = mXWeatherWidget;
        this.a = fVar;
    }

    public void run() {
        if (!this.b.isfreshsuccess) {
            this.a.a();
        }
    }
}
